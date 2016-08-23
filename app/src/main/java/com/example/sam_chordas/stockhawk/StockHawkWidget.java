package com.example.sam_chordas.stockhawk;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.constants.Constants;
import com.sam_chordas.android.stockhawk.data.QuoteColumns;
import com.sam_chordas.android.stockhawk.data.QuoteProvider;
import com.sam_chordas.android.stockhawk.model.WidgetDataModel;

import java.util.ArrayList;


public class StockHawkWidget extends AppWidgetProvider {

    private ArrayList<WidgetDataModel> listItemModel = new ArrayList<>();
    private ArrayList<String> sSymbols = new ArrayList<>();



    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int wLength = appWidgetIds.length;
        Log.i(Constants.LOG_TAG,"Updating Widget");


        System.out.println("App Widget Ids: "+appWidgetIds.length);
        for (int id = 0; id <wLength; id++) {
//            populateListItem(context, id);

            RemoteViews remoteViews = updateAppWidgetListView(context, appWidgetIds[id]);
            remoteViews.setTextViewText(R.id.stock_symbol, "0000");
            appWidgetManager.updateAppWidget(appWidgetIds[id],remoteViews);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    private RemoteViews updateAppWidgetListView(Context context, int appWidgetId){

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.stock_hawk_widget);
        Intent intent = new Intent(context,StockHawkWidgetService.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

        WidgetDataProvider widgetDataProvider = new WidgetDataProvider(context, intent);
        widgetDataProvider.populateListItem(context);


        remoteViews.setRemoteAdapter(R.id.listView, intent);
        return remoteViews;
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    public void populateListItem(Context context, int widgetId){
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

//
    }

}

