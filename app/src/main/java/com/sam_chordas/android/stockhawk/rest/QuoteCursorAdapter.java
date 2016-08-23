package com.sam_chordas.android.stockhawk.rest;

import android.annotation.TargetApi;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sam_chordas.stockhawk.StockHawkWidget;
import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.data.QuoteColumns;
import com.sam_chordas.android.stockhawk.data.QuoteProvider;
import com.sam_chordas.android.stockhawk.touch_helper.ItemTouchHelperAdapter;
import com.sam_chordas.android.stockhawk.touch_helper.ItemTouchHelperViewHolder;

/**
 * Created by sam_chordas on 10/6/15.
 *  Credit to skyfishjy gist:
 *    https://gist.github.com/skyfishjy/443b7448f59be978bc59
 * for the code structure
 */
public class QuoteCursorAdapter extends CursorRecyclerViewAdapter<QuoteCursorAdapter.ViewHolder>
    implements ItemTouchHelperAdapter {

  private static Context mContext;
  private static Typeface robotoLight;
  private boolean isPercent;
  AccessChartData accessChartData = new AccessChartData();

  public QuoteCursorAdapter(Context context, Cursor cursor) {
    super(context, cursor);
    mContext = context;

  }



  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    robotoLight = Typeface.createFromAsset(mContext.getAssets(), "fonts/Roboto-Light.ttf");


    final View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item_quote, parent, false);
    ViewHolder vh = new ViewHolder(itemView);


    return vh;
  }


  @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
  @Override
  public void onBindViewHolder(final ViewHolder viewHolder, final Cursor cursor) {

    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        accessChartData.openChart();
      }
    });

    viewHolder.symbol.setText(cursor.getString(cursor.getColumnIndex("symbol")));
    viewHolder.bidPrice.setText(cursor.getString(cursor.getColumnIndex("bid_price")));
    viewHolder.stockName.setText(cursor.getString(cursor.getColumnIndex("name")));
    viewHolder.openChart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
      accessChartData.openChart();
      }
    });

    int sdk = Build.VERSION.SDK_INT;
    if (cursor.getInt(cursor.getColumnIndex("is_up")) == 1) {
      if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
        viewHolder.change.setBackgroundDrawable(
                mContext.getResources().getDrawable(R.drawable.percent_change_pill_green));
      } else {
        viewHolder.change.setBackground(
                mContext.getResources().getDrawable(R.drawable.percent_change_pill_green));
      }
    } else {
      if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
        viewHolder.change.setBackgroundDrawable(
                mContext.getResources().getDrawable(R.drawable.percent_change_pill_red));
      } else {
        viewHolder.change.setBackground(
                mContext.getResources().getDrawable(R.drawable.percent_change_pill_red));
      }
    }
    if (Utils.showPercent) {
      viewHolder.change.setText(cursor.getString(cursor.getColumnIndex("percent_change")));
    } else {
      viewHolder.change.setText(cursor.getString(cursor.getColumnIndex("change")));
    }

    // Update Widget if data changes...
    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(mContext);
    ComponentName thisWidget = new ComponentName(mContext, StockHawkWidget.class);
    int[] cWidget = appWidgetManager.getAppWidgetIds(thisWidget);
    appWidgetManager.notifyAppWidgetViewDataChanged(cWidget, R.id.listView);

  }

  @Override
  public void onItemDismiss(int position) {
    Cursor c = getCursor();
    c.moveToPosition(position);
    String symbol = c.getString(c.getColumnIndex(QuoteColumns.SYMBOL));
    mContext.getContentResolver().delete(QuoteProvider.Quotes.withSymbol(symbol), null, null);
    notifyItemRemoved(position);

  }

  @Override
  public int getItemCount() {
    return super.getItemCount();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder
          implements ItemTouchHelperViewHolder, View.OnClickListener {
    public final TextView symbol;
    public final TextView bidPrice;
    public final TextView change;
    public final ImageButton openChart;
    public final TextView stockName;

    public ViewHolder(View itemView) {
      super(itemView);
      symbol = (TextView) itemView.findViewById(R.id.stock_symbol);
      stockName = (TextView) itemView.findViewById(R.id.stockName);
      symbol.setTypeface(robotoLight);
      bidPrice = (TextView) itemView.findViewById(R.id.bid_price);
      change = (TextView) itemView.findViewById(R.id.change);
      openChart = (ImageButton) itemView.findViewById(R.id.openChart);

    }

    @Override
    public void onItemSelected() {
      itemView.setBackgroundColor(Color.LTGRAY);
      itemView.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

          return false;
        }
      });
      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


        }
      });

    }

    @Override
    public void onItemClear() {
      itemView.setBackgroundColor(0);
    }


    @Override
    public void onClick(View v) {


    }


  }



}

