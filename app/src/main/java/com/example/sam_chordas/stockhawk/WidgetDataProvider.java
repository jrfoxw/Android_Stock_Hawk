package com.example.sam_chordas.stockhawk;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Color;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.constants.Constants;
import com.sam_chordas.android.stockhawk.data.QuoteColumns;
import com.sam_chordas.android.stockhawk.data.QuoteProvider;
import com.sam_chordas.android.stockhawk.model.WidgetDataModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by PY-DEV on 8/19/2016.
 */
public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory{

    private ArrayList<WidgetDataModel> listItemModel = new ArrayList<>();
    private ArrayList<String> sSymbols = new ArrayList<>();
    private Context context = null;
    private int appWidgetId;
    Random rnd = new Random();
    private int percentColorN = Color.RED;
    private int percentColorP = Color.GREEN;


    public WidgetDataProvider(Context context, Intent intent){

        this.context = context;
        appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
//        populateListItem();
    }






    @Override
    public void onCreate() {
            populateListItem(context);
    }

    @Override
    public void onDataSetChanged() {
        populateListItem(context);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return listItemModel.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {
        final RemoteViews remoteView = new RemoteViews(
                context.getPackageName(), R.layout.list_item_widget);
        WidgetDataModel itemModel = listItemModel.get(i);
        if(i % 2 == 0){
            remoteView.setInt(R.id.widgetItemWrap, "setBackgroundResource", R.drawable.cell_shading);
        }else{
            remoteView.setInt(R.id.widgetItemWrap, "setBackgroundResource", R.drawable.cell_shading2);
        }
        remoteView.setTextViewText(R.id.stockName, itemModel.getStockName());
        remoteView.setTextViewText(R.id.stock_symbol, itemModel.getStockSymbol());
        remoteView.setTextViewText(R.id.bid_price, itemModel.getBid_price());
        remoteView.setTextViewText(R.id.change, itemModel.getPercent());


        if(Float.parseFloat(itemModel.getChange()) < 0){


            remoteView.setInt(R.id.change, "setBackgroundResource", R.drawable.percent_change_pill_red);
        }else{
            remoteView.setInt(R.id.change, "setBackgroundResource", R.drawable.percent_change_pill_green);
        }

        Intent intent = new Intent(context.getApplicationContext(), StockHawkWidgetService.class);
        context.startService(intent);
        return remoteView;

    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    public void populateListItem(Context context){
        Cursor cursor;
        listItemModel.clear();
        sSymbols.clear();
        Log.i(Constants.LOG_TAG,"Updating from populateListItem");
        String mSelection = QuoteColumns.ISCURRENT;

        cursor = context.getContentResolver().query(QuoteProvider.Quotes.CONTENT_URI,
                null,mSelection="1",null, null);

        if(cursor.getCount() == 0 || cursor == null){
            listItemModel.add(new WidgetDataModel("NO DATA","NO DATA","0.00","0",null));

        }else {
            DatabaseUtils.dumpCursor(cursor);

            for (int i = 0; i < 5; i++) {
                if (cursor.moveToFirst()) {
                    while(!cursor.isAfterLast()) {
                        String isCurrent = cursor.getString(cursor.getColumnIndex(QuoteColumns.ISCURRENT));
                        String sym = cursor.getString(cursor.getColumnIndex("symbol"));
                        if (isCurrent.equals("1") && !sSymbols.contains(sym)) {

                            sSymbols.add(sym);
                            String price = cursor.getString(cursor.getColumnIndex("bid_price"));
                            String name = cursor.getString(cursor.getColumnIndex(QuoteColumns.NAME));
                            String percent = cursor.getString(cursor.getColumnIndex(QuoteColumns.PERCENT_CHANGE));
                            String change = cursor.getString(cursor.getColumnIndex(QuoteColumns.CHANGE));


                            listItemModel.add(new WidgetDataModel(sym, name, price,percent,change));
                        }
                        cursor.moveToNext();

                    }
                }
            }
            cursor.close();
        }

    }
}


