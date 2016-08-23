package com.sam_chordas.android.stockhawk.rest;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.sam_chordas.android.stockhawk.ui.ChartActivity;

/**
 * Created by PY-DEV on 8/22/2016.
 */
public class AccessChartData {

    public QuoteCursorAdapter.ViewHolder viewHolder;
    public View v;
    public Context mContext;

    public AccessChartData(){}

    public AccessChartData(QuoteCursorAdapter.ViewHolder viewHolder, View v, Context mContext){
        this.viewHolder = viewHolder;
        this.v = v;
        this.mContext = mContext;

    }

    public void openChart() {

        Intent chart = new Intent(v.getContext(), ChartActivity.class);



        chart.putExtra("symbol", viewHolder.symbol.getText());
        chart.putExtra("bid_price", Float.parseFloat(viewHolder.bidPrice.getText().toString()));
        chart.putExtra("name", viewHolder.stockName.getText());

        v.getContext().startActivity(chart);
    }

}
