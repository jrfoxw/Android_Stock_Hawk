package com.sam_chordas.android.stockhawk.service;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.RemoteException;
import android.util.Log;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;
import com.google.gson.Gson;
import com.sam_chordas.android.stockhawk.constants.Constants;
import com.sam_chordas.android.stockhawk.data.QuoteColumns;
import com.sam_chordas.android.stockhawk.data.QuoteProvider;
import com.sam_chordas.android.stockhawk.model.StockDataModel;
import com.sam_chordas.android.stockhawk.rest.Utils;
import com.sam_chordas.android.stockhawk.ui.MyStocksActivity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sam_chordas on 9/30/15.
 * The GCMTask service is primarily for periodic tasks. However, OnRunTask can be called directly
 * and is used for the initialization and adding task as well.
 */
public class StockTaskService extends GcmTaskService {
  private String LOG_TAG = Constants.LOG_TAG;

  private OkHttpClient client = new OkHttpClient();
  private Context mContext;
  private StringBuilder mStoredSymbols = new StringBuilder();
  private ArrayList<String> aStoredSymbols = new ArrayList<>();
  private boolean isUpdate;
  private StockDataModel stockDataModel;
  private boolean dataVerification;
  Response response;

//  ValidateData validateData;
  Gson gson = new Gson();



  public StockTaskService() {
  }

  public StockTaskService(Context context) {
    mContext = context;
  }



  public String fetchData(String url) throws IOException {
    Request request = new Request.Builder()
            .url(url)
            .build();

    response = client.newCall(request).execute();
    Log.i(LOG_TAG, "**DATA REQUEST: " + request.toString());
    String responseStr = response.body().string();
    Log.i(LOG_TAG, "**DATA RESPONSE: " + responseStr);



    return responseStr;
  }

  @Override
  public int onRunTask(TaskParams params) {
    Cursor initQueryCursor;
    if (mContext == null) {
      mContext = this;

    }
    StringBuilder urlStringBuilder = new StringBuilder();
    try {
      // Base URL for the Yahoo query
      Log.i(LOG_TAG,"TASKPARAMS: "+params.getTag());
      urlStringBuilder.append(Constants.BASE_URL);
      urlStringBuilder.append(URLEncoder.encode("select * from yahoo.finance.quotes where symbol "
              + "in (", "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    // Initialize OR Periodic update.
    if (params.getTag().equals("init") || params.getTag().equals("periodic")) {
      dataVerification = true;
      isUpdate = true;
      initQueryCursor = mContext.getContentResolver().query(QuoteProvider.Quotes.CONTENT_URI,
              new String[]{"Distinct " + QuoteColumns.SYMBOL}, null,
              null, null);
      Log.i(LOG_TAG,"DB COUNT: "+initQueryCursor.getCount());

      if (initQueryCursor.getCount() == 0 || initQueryCursor == null) {
        // Init task. Populates DB with quotes for the symbols seen below

        try {
          urlStringBuilder.append(
                  URLEncoder.encode("\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")", "UTF-8"));
          urlStringBuilder.append(Constants.POST_URL);
          try {
            fetchData(urlStringBuilder.toString());
          } catch (IOException e) {
            e.printStackTrace();
          }
          Log.i(LOG_TAG, "URL: " + urlStringBuilder.toString());
          Log.i(LOG_TAG, "QueryCursor: "+initQueryCursor);
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
      }else if (initQueryCursor != null){


        Log.i(LOG_TAG,"QUERY CURSOR != Null: ");
        DatabaseUtils.dumpCursor(initQueryCursor);
        initQueryCursor.moveToFirst();
        for (int i = 0; i < initQueryCursor.getCount(); i++) {
          mStoredSymbols.append("\"" +
                  initQueryCursor.getString(initQueryCursor.getColumnIndex("symbol")) + "\",");
          initQueryCursor.moveToNext();
          Log.i(LOG_TAG,"STORED SYMBOLS: "+mStoredSymbols);

        }
        mStoredSymbols.replace(mStoredSymbols.length() - 1, mStoredSymbols.length(), ")");
        try {
          urlStringBuilder.append(URLEncoder.encode(mStoredSymbols.toString(), "UTF-8"));

        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
      }
      // When adding a new stock
    } else if (params.getTag().equals("add")){
      isUpdate = false;

      Log.i(LOG_TAG,"Verifying Data...");
      // get symbol from params.getExtra and build query
      String stockInput = params.getExtras().getString("symbol");
      try {
        // Does symbol exist?
        dataVerification = checkData(stockInput);
        if(!dataVerification){
          Log.i(LOG_TAG,"DATA IS NOT VALID...");

        }

      } catch (IOException e) {
        e.printStackTrace();
      }

      try {
        urlStringBuilder.append(URLEncoder.encode("\""+stockInput+"\")", "UTF-8"));
      } catch (UnsupportedEncodingException e){
        e.printStackTrace();
      }
    }
    // finalize the URL for the API query.
    urlStringBuilder.append(Constants.POST_URL);

    String urlString;
    String getResponse;
    int result = GcmNetworkManager.RESULT_FAILURE;

    if (urlStringBuilder != null && dataVerification) {
      urlString = urlStringBuilder.toString();
      try {
        getResponse = fetchData(urlString);
        Log.i(LOG_TAG, ">>>DATA RESPONSE: " + getResponse);

//        if (stockDataModel.getQuery().getResults().getQuote().getName() == null) {
//          Log.i(LOG_TAG,"DATA IS NULL");
//          return result;
//        }
        result = GcmNetworkManager.RESULT_SUCCESS;
        try {
          ContentValues contentValues = new ContentValues();
          // update ISCURRENT to 0 (false) so new data is current
          if (isUpdate) {
            contentValues.put(QuoteColumns.ISCURRENT, 0);
            mContext.getContentResolver().update(QuoteProvider.Quotes.CONTENT_URI, contentValues,
                    null, null);
          }
          mContext.getContentResolver().applyBatch(QuoteProvider.AUTHORITY,
                  Utils.quoteJsonToContentVals(getResponse));
        } catch (RemoteException | OperationApplicationException e) {
          Log.e(LOG_TAG, "Error applying batch insert", e);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return result;

  }

  // Check if symbol sent is valid data...
  public Boolean checkData(String symbol) throws IOException {

    StringBuilder urlBuilder = new StringBuilder();
    urlBuilder.append(Constants.BASE_URL);
    urlBuilder.append(URLEncoder.encode(String.format("select * from yahoo.finance.quotes where " +
            "symbol in (\"%s\")",symbol), "UTF-8"));
    urlBuilder.append(Constants.POST_URL);
    String url = urlBuilder.toString();


    Request request = new Request.Builder()
            .url(url)
            .build();

    Log.i(LOG_TAG, "DATA REQUEST: " + request.toString());
    response = client.newCall(request).execute();
    String responseStr = response.body().string();
    Log.i(LOG_TAG, "DATA RESPONSE: " + responseStr);
    stockDataModel = gson.fromJson(responseStr, StockDataModel.class);

      if(stockDataModel.getQuery().getResults().getQuote().getName() == null){
        Log.i(LOG_TAG,"STOCK NOT FOUND!");

        Intent i = new Intent(MyStocksActivity.UpdateInfoReceiver.class.getName());
        i.putExtra("symbol",symbol);
        mContext.sendBroadcast(i);

        return false;
      }else {
        return true;
      }


  }
}
