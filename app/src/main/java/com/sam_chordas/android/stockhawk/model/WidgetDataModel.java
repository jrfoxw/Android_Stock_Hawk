package com.sam_chordas.android.stockhawk.model;

import java.util.Random;

/**
 * Created by PY-DEV on 8/18/2016.
 */
public class WidgetDataModel {

    public String stockName;
    public String stockSymbol;
    public String bid_price;
    public String percent;
    public String change;

    public WidgetDataModel(String stockSymbol,
                           String stockName,
                           String bid_price,
                           String percent,
                           String change) {

        this.stockSymbol = stockSymbol;
        this.stockName = stockName;
        this.bid_price = bid_price;
        this.percent = percent;
        this.change = change;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getBid_price() {
        return bid_price;
    }

    public void setBid_price(String bid_price) {
        this.bid_price = bid_price;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }
}
