package com.sam_chordas.android.stockhawk.constants;

import com.sam_chordas.android.stockhawk.service.StockTaskService;

/**
 * Created by PY-DEV on 8/16/2016.
 */
public class Constants {

    public final static String BASE_URL = "https://query.yahooapis.com/v1/public/yql?q=";
    public final static String POST_URL = "&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
    public final static String LOG_TAG = StockTaskService.class.getSimpleName();
}
