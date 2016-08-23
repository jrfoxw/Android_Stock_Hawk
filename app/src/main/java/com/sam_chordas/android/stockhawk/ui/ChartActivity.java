package com.sam_chordas.android.stockhawk.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.data.QuoteColumns;
import com.sam_chordas.android.stockhawk.data.QuoteProvider;
import com.sam_chordas.android.stockhawk.rest.QuoteCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChartActivity extends AppCompatActivity {


    private LineChart mChartLine;
    private HashMap<String, ArrayList<Float>> stockMap = new HashMap<>();
    private String symbol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        mChartLine = (LineChart) findViewById(R.id.stockChart);




        // Line Chart
        LimitLine llXAxis = new LimitLine(315f, "Index 10");
        llXAxis.setLineWidth(15f);

        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        llXAxis.setTextSize(10f);
        llXAxis.setTextColor(Color.RED);

        XAxis xAxis = mChartLine.getXAxis();
        xAxis.setTextColor(Color.BLUE);
        xAxis.setAxisMaxValue(7);
        xAxis.setAxisMinValue(0);

        YAxis leftAxis = mChartLine.getAxisLeft();
        YAxis rightAxis = mChartLine.getAxisRight();
        rightAxis.setTextColor(Color.RED);
        leftAxis.removeAllLimitLines();
        leftAxis.setTextColor(Color.WHITE);

        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawLimitLinesBehindData(true);


        Intent chart = getIntent();
        symbol = chart.getStringExtra("symbol");
        String name = chart.getStringExtra("name");



        ArrayList<Float> prices2 = checkDataBase();

        leftAxis.setAxisMaxValue(prices2.get(prices2.size()-1)+10);
        leftAxis.setAxisMinValue(prices2.get(0)-10);
        stockMap.put(symbol,prices2);
        this.setTitle(String.format("%s ",name));


        mChartLine.setDrawGridBackground(false);
        mChartLine.animateX(1000);
        mChartLine.setDescription("History");
        mChartLine.setDescriptionPosition(215,575);
        mChartLine.setDescription("Day");
        mChartLine.setDescriptionPosition(200,25);


        Legend l1 = mChartLine.getLegend();
        l1.setPosition(Legend.LegendPosition.LEFT_OF_CHART);
        l1.setForm(Legend.LegendForm.SQUARE);
        l1.setTextColor(Color.WHITE);

        setData();

        checkDataBase();

    }


    public void setData(){

        ArrayList<Entry> entries1 = new ArrayList<>();
        ArrayList<ILineDataSet> dataSet2 = new ArrayList<>();
        Random rnd = new Random();

        String stockName;
        for(Map.Entry<String, ArrayList<Float>> e:stockMap.entrySet()) {
            int count = 0;
            stockName = e.getKey();
            ArrayList<Float> values = e.getValue();
            for(float f: values){

                entries1.add(new Entry(count, f));
                count++;
                System.out.println("Key: "+stockName+" Value: "+f);
            }

            LineDataSet set1 = new LineDataSet(entries1, stockName);

            set1.setValues(entries1);
            set1.enableDashedLine(10f, 5f, 0f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.rgb(155,255,255));
            set1.setValueTextColor(Color.WHITE);
            set1.setLineWidth(1f);
            set1.setValueTextSize(6f);

            dataSet2.add(set1);
            LineData data1 = new LineData(dataSet2);
            System.out.println("Sets: "+dataSet2.size());
            mChartLine.setData(data1);

        }

    }

    public ArrayList<Float> checkDataBase() {


        float[] prices = new float[]{0,0,0,0,0,0,0,0,0,0,0,0};
        ArrayList<Float> prices2 = new ArrayList<>();
        int count=0;
        SQLiteDatabase db;
        db = openOrCreateDatabase("quoteDatabase.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null);


        ContentValues values = new ContentValues();

        String URL = "com.sam_chordas.android.stockhawk.data.QuoteProvider";
        Uri data = Uri.parse(URL);

        Cursor c = db.query("quotes", null, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast() && count != 7) {

            if (c.getString(c.getColumnIndex("symbol")).equals(symbol)) {

                System.out.println(">>>> +++ <<<<< " + c.getString(c.getColumnIndex("bid_price")));
                prices2.add(Float.parseFloat(c.getString(c.getColumnIndex("bid_price"))));
                count++;
            }
            c.moveToNext();
        }
        c.close();

        return prices2;
    }

}
