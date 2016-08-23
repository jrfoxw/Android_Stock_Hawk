package com.example.sam_chordas.stockhawk;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by PY-DEV on 8/18/2016.
 */
public class StockHawkWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
//        return new NewAppRemoteViewsFactory(this.getApplicationContext(), intent);
        int appWidgetId = intent.getIntExtra(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
        return (new WidgetDataProvider(this.getApplicationContext(),intent));
    }

}
