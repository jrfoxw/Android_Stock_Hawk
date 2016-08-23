package com.sam_chordas.android.stockhawk.model;

/**
 * Created by PY-DEV on 8/11/2016.
 */
public class StockDataModel {


    /**
     * count : 1
     * created : 2016-08-11T14:01:17Z
     * lang : en-US
     * diagnostics : {"url":[{"execution-start-time":"0","execution-stop-time":"1","execution-time":"1","content":"http://www.datatables.org/yahoo/finance/yahoo.finance.quotes.xml"},{"execution-start-time":"5","execution-stop-time":"25","execution-time":"20","content":"http://download.finance.yahoo.com/d/quotes.csv?f=aa2bb2b3b4cc1c3c4c6c8dd1d2ee1e7e8e9ghjkg1g3g4g5g6ii5j1j3j4j5j6k1k2k4k5ll1l2l3mm2m3m4m5m6m7m8nn4opp1p2p5p6qrr1r2r5r6r7ss1s7t1t7t8vv1v7ww1w4xy&s=PBEL"}],"publiclyCallable":"true","cache":{"execution-start-time":"4","execution-stop-time":"4","execution-time":"0","method":"GET","type":"MEMCACHED","content":"5d1e1de680846a307c9874dc3d6878dc"},"query":{"execution-start-time":"4","execution-stop-time":"25","execution-time":"21","params":"{url=[http://download.finance.yahoo.com/d/quotes.csv?f=aa2bb2b3b4cc1c3c4c6c8dd1d2ee1e7e8e9ghjkg1g3g4g5g6ii5j1j3j4j5j6k1k2k4k5ll1l2l3mm2m3m4m5m6m7m8nn4opp1p2p5p6qrr1r2r5r6r7ss1s7t1t7t8vv1v7ww1w4xy&s=PBEL]}","content":"select * from csv where url=@url and columns='Ask,AverageDailyVolume,Bid,AskRealtime,BidRealtime,BookValue,Change&PercentChange,Change,Commission,Currency,ChangeRealtime,AfterHoursChangeRealtime,DividendShare,LastTradeDate,TradeDate,EarningsShare,ErrorIndicationreturnedforsymbolchangedinvalid,EPSEstimateCurrentYear,EPSEstimateNextYear,EPSEstimateNextQuarter,DaysLow,DaysHigh,YearLow,YearHigh,HoldingsGainPercent,AnnualizedGain,HoldingsGain,HoldingsGainPercentRealtime,HoldingsGainRealtime,MoreInfo,OrderBookRealtime,MarketCapitalization,MarketCapRealtime,EBITDA,ChangeFromYearLow,PercentChangeFromYearLow,LastTradeRealtimeWithTime,ChangePercentRealtime,ChangeFromYearHigh,PercebtChangeFromYearHigh,LastTradeWithTime,LastTradePriceOnly,HighLimit,LowLimit,DaysRange,DaysRangeRealtime,FiftydayMovingAverage,TwoHundreddayMovingAverage,ChangeFromTwoHundreddayMovingAverage,PercentChangeFromTwoHundreddayMovingAverage,ChangeFromFiftydayMovingAverage,PercentChangeFromFiftydayMovingAverage,Name,Notes,Open,PreviousClose,PricePaid,ChangeinPercent,PriceSales,PriceBook,ExDividendDate,PERatio,DividendPayDate,PERatioRealtime,PEGRatio,PriceEPSEstimateCurrentYear,PriceEPSEstimateNextYear,Symbol,SharesOwned,ShortRatio,LastTradeTime,TickerTrend,OneyrTargetPrice,Volume,HoldingsValue,HoldingsValueRealtime,YearRange,DaysValueChange,DaysValueChangeRealtime,StockExchange,DividendYield'"},"javascript":{"execution-start-time":"3","execution-stop-time":"32","execution-time":"29","instructions-used":"53640","table-name":"yahoo.finance.quotes"},"user-time":"33","service-time":"21","build-version":"0.2.39"}
     * results : {"quote":{"symbol":"PBEL","Ask":null,"AverageDailyVolume":null,"Bid":null,"AskRealtime":null,"BidRealtime":null,"BookValue":null,"Change_PercentChange":null,"Change":null,"Commission":null,"Currency":null,"ChangeRealtime":null,"AfterHoursChangeRealtime":null,"DividendShare":null,"LastTradeDate":null,"TradeDate":null,"EarningsShare":null,"ErrorIndicationreturnedforsymbolchangedinvalid":null,"EPSEstimateCurrentYear":null,"EPSEstimateNextYear":null,"EPSEstimateNextQuarter":null,"DaysLow":null,"DaysHigh":null,"YearLow":null,"YearHigh":null,"HoldingsGainPercent":null,"AnnualizedGain":null,"HoldingsGain":null,"HoldingsGainPercentRealtime":null,"HoldingsGainRealtime":null,"MoreInfo":null,"OrderBookRealtime":null,"MarketCapitalization":null,"MarketCapRealtime":null,"EBITDA":null,"ChangeFromYearLow":null,"PercentChangeFromYearLow":null,"LastTradeRealtimeWithTime":null,"ChangePercentRealtime":null,"ChangeFromYearHigh":null,"PercebtChangeFromYearHigh":null,"LastTradeWithTime":null,"LastTradePriceOnly":null,"HighLimit":null,"LowLimit":null,"DaysRange":null,"DaysRangeRealtime":null,"FiftydayMovingAverage":null,"TwoHundreddayMovingAverage":null,"ChangeFromTwoHundreddayMovingAverage":null,"PercentChangeFromTwoHundreddayMovingAverage":null,"ChangeFromFiftydayMovingAverage":null,"PercentChangeFromFiftydayMovingAverage":null,"Name":null,"Notes":null,"Open":null,"PreviousClose":null,"PricePaid":null,"ChangeinPercent":null,"PriceSales":null,"PriceBook":null,"ExDividendDate":null,"PERatio":null,"DividendPayDate":null,"PERatioRealtime":null,"PEGRatio":null,"PriceEPSEstimateCurrentYear":null,"PriceEPSEstimateNextYear":null,"Symbol":"PBEL","SharesOwned":null,"ShortRatio":null,"LastTradeTime":null,"TickerTrend":null,"OneyrTargetPrice":null,"Volume":null,"HoldingsValue":null,"HoldingsValueRealtime":null,"YearRange":null,"DaysValueChange":null,"DaysValueChangeRealtime":null,"StockExchange":null,"DividendYield":null,"PercentChange":null}}
     */

    private QueryBean query;

    public QueryBean getQuery() {
        return query;
    }

    public void setQuery(QueryBean query) {
        this.query = query;
    }

    public static class QueryBean {
        private int count;
        /**
         * quote : {"symbol":"PBEL","Ask":null,"AverageDailyVolume":null,"Bid":null,"AskRealtime":null,"BidRealtime":null,"BookValue":null,"Change_PercentChange":null,"Change":null,"Commission":null,"Currency":null,"ChangeRealtime":null,"AfterHoursChangeRealtime":null,"DividendShare":null,"LastTradeDate":null,"TradeDate":null,"EarningsShare":null,"ErrorIndicationreturnedforsymbolchangedinvalid":null,"EPSEstimateCurrentYear":null,"EPSEstimateNextYear":null,"EPSEstimateNextQuarter":null,"DaysLow":null,"DaysHigh":null,"YearLow":null,"YearHigh":null,"HoldingsGainPercent":null,"AnnualizedGain":null,"HoldingsGain":null,"HoldingsGainPercentRealtime":null,"HoldingsGainRealtime":null,"MoreInfo":null,"OrderBookRealtime":null,"MarketCapitalization":null,"MarketCapRealtime":null,"EBITDA":null,"ChangeFromYearLow":null,"PercentChangeFromYearLow":null,"LastTradeRealtimeWithTime":null,"ChangePercentRealtime":null,"ChangeFromYearHigh":null,"PercebtChangeFromYearHigh":null,"LastTradeWithTime":null,"LastTradePriceOnly":null,"HighLimit":null,"LowLimit":null,"DaysRange":null,"DaysRangeRealtime":null,"FiftydayMovingAverage":null,"TwoHundreddayMovingAverage":null,"ChangeFromTwoHundreddayMovingAverage":null,"PercentChangeFromTwoHundreddayMovingAverage":null,"ChangeFromFiftydayMovingAverage":null,"PercentChangeFromFiftydayMovingAverage":null,"Name":null,"Notes":null,"Open":null,"PreviousClose":null,"PricePaid":null,"ChangeinPercent":null,"PriceSales":null,"PriceBook":null,"ExDividendDate":null,"PERatio":null,"DividendPayDate":null,"PERatioRealtime":null,"PEGRatio":null,"PriceEPSEstimateCurrentYear":null,"PriceEPSEstimateNextYear":null,"Symbol":"PBEL","SharesOwned":null,"ShortRatio":null,"LastTradeTime":null,"TickerTrend":null,"OneyrTargetPrice":null,"Volume":null,"HoldingsValue":null,"HoldingsValueRealtime":null,"YearRange":null,"DaysValueChange":null,"DaysValueChangeRealtime":null,"StockExchange":null,"DividendYield":null,"PercentChange":null}
         */

        private ResultsBean results;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public ResultsBean getResults() {
            return results;
        }

        public void setResults(ResultsBean results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * symbol : PBEL
             * Ask : null
             * AverageDailyVolume : null
             * Bid : null
             * AskRealtime : null
             * BidRealtime : null
             * BookValue : null
             * Change_PercentChange : null
             * Change : null
             * Commission : null
             * Currency : null
             * ChangeRealtime : null
             * AfterHoursChangeRealtime : null
             * DividendShare : null
             * LastTradeDate : null
             * TradeDate : null
             * EarningsShare : null
             * ErrorIndicationreturnedforsymbolchangedinvalid : null
             * EPSEstimateCurrentYear : null
             * EPSEstimateNextYear : null
             * EPSEstimateNextQuarter : null
             * DaysLow : null
             * DaysHigh : null
             * YearLow : null
             * YearHigh : null
             * HoldingsGainPercent : null
             * AnnualizedGain : null
             * HoldingsGain : null
             * HoldingsGainPercentRealtime : null
             * HoldingsGainRealtime : null
             * MoreInfo : null
             * OrderBookRealtime : null
             * MarketCapitalization : null
             * MarketCapRealtime : null
             * EBITDA : null
             * ChangeFromYearLow : null
             * PercentChangeFromYearLow : null
             * LastTradeRealtimeWithTime : null
             * ChangePercentRealtime : null
             * ChangeFromYearHigh : null
             * PercebtChangeFromYearHigh : null
             * LastTradeWithTime : null
             * LastTradePriceOnly : null
             * HighLimit : null
             * LowLimit : null
             * DaysRange : null
             * DaysRangeRealtime : null
             * FiftydayMovingAverage : null
             * TwoHundreddayMovingAverage : null
             * ChangeFromTwoHundreddayMovingAverage : null
             * PercentChangeFromTwoHundreddayMovingAverage : null
             * ChangeFromFiftydayMovingAverage : null
             * PercentChangeFromFiftydayMovingAverage : null
             * Name : null
             * Notes : null
             * Open : null
             * PreviousClose : null
             * PricePaid : null
             * ChangeinPercent : null
             * PriceSales : null
             * PriceBook : null
             * ExDividendDate : null
             * PERatio : null
             * DividendPayDate : null
             * PERatioRealtime : null
             * PEGRatio : null
             * PriceEPSEstimateCurrentYear : null
             * PriceEPSEstimateNextYear : null
             * Symbol : PBEL
             * SharesOwned : null
             * ShortRatio : null
             * LastTradeTime : null
             * TickerTrend : null
             * OneyrTargetPrice : null
             * Volume : null
             * HoldingsValue : null
             * HoldingsValueRealtime : null
             * YearRange : null
             * DaysValueChange : null
             * DaysValueChangeRealtime : null
             * StockExchange : null
             * DividendYield : null
             * PercentChange : null
             */

            private QuoteBean quote;

            public QuoteBean getQuote() {
                return quote;
            }

            public void setQuote(QuoteBean quote) {
                this.quote = quote;
            }

            public static class QuoteBean {
                private String symbol;
                private Object Ask;
                private Object AverageDailyVolume;
                private Object Bid;
                private Object AskRealtime;
                private Object BidRealtime;
                private Object BookValue;
                private Object Change_PercentChange;
                private Object Change;
                private Object Commission;
                private Object Currency;
                private Object ChangeRealtime;
                private Object AfterHoursChangeRealtime;
                private Object DividendShare;
                private Object LastTradeDate;
                private Object TradeDate;
                private Object EarningsShare;
                private Object ErrorIndicationreturnedforsymbolchangedinvalid;
                private Object EPSEstimateCurrentYear;
                private Object EPSEstimateNextYear;
                private Object EPSEstimateNextQuarter;
                private Object DaysLow;
                private Object DaysHigh;
                private Object YearLow;
                private Object YearHigh;
                private Object HoldingsGainPercent;
                private Object AnnualizedGain;
                private Object HoldingsGain;
                private Object HoldingsGainPercentRealtime;
                private Object HoldingsGainRealtime;
                private Object MoreInfo;
                private Object OrderBookRealtime;
                private Object MarketCapitalization;
                private Object MarketCapRealtime;
                private Object EBITDA;
                private Object ChangeFromYearLow;
                private Object PercentChangeFromYearLow;
                private Object LastTradeRealtimeWithTime;
                private Object ChangePercentRealtime;
                private Object ChangeFromYearHigh;
                private Object PercebtChangeFromYearHigh;
                private Object LastTradeWithTime;
                private Object LastTradePriceOnly;
                private Object HighLimit;
                private Object LowLimit;
                private Object DaysRange;
                private Object DaysRangeRealtime;
                private Object FiftydayMovingAverage;
                private Object TwoHundreddayMovingAverage;
                private Object ChangeFromTwoHundreddayMovingAverage;
                private Object PercentChangeFromTwoHundreddayMovingAverage;
                private Object ChangeFromFiftydayMovingAverage;
                private Object PercentChangeFromFiftydayMovingAverage;
                private Object Name;
                private Object Notes;
                private Object Open;
                private Object PreviousClose;
                private Object PricePaid;
                private Object ChangeinPercent;
                private Object PriceSales;
                private Object PriceBook;
                private Object ExDividendDate;
                private Object PERatio;
                private Object DividendPayDate;
                private Object PERatioRealtime;
                private Object PEGRatio;
                private Object PriceEPSEstimateCurrentYear;
                private Object PriceEPSEstimateNextYear;
                private String Symbol;
                private Object SharesOwned;
                private Object ShortRatio;
                private Object LastTradeTime;
                private Object TickerTrend;
                private Object OneyrTargetPrice;
                private Object Volume;
                private Object HoldingsValue;
                private Object HoldingsValueRealtime;
                private Object YearRange;
                private Object DaysValueChange;
                private Object DaysValueChangeRealtime;
                private Object StockExchange;
                private Object DividendYield;
                private Object PercentChange;

                public String getSymbol() {
                    return symbol;
                }

                public void setSymbol(String symbol) {
                    this.symbol = symbol;
                }

                public Object getAsk() {
                    return Ask;
                }

                public void setAsk(Object Ask) {
                    this.Ask = Ask;
                }

                public Object getAverageDailyVolume() {
                    return AverageDailyVolume;
                }

                public void setAverageDailyVolume(Object AverageDailyVolume) {
                    this.AverageDailyVolume = AverageDailyVolume;
                }

                public Object getBid() {
                    return Bid;
                }

                public void setBid(Object Bid) {
                    this.Bid = Bid;
                }

                public Object getAskRealtime() {
                    return AskRealtime;
                }

                public void setAskRealtime(Object AskRealtime) {
                    this.AskRealtime = AskRealtime;
                }

                public Object getBidRealtime() {
                    return BidRealtime;
                }

                public void setBidRealtime(Object BidRealtime) {
                    this.BidRealtime = BidRealtime;
                }

                public Object getBookValue() {
                    return BookValue;
                }

                public void setBookValue(Object BookValue) {
                    this.BookValue = BookValue;
                }

                public Object getChange_PercentChange() {
                    return Change_PercentChange;
                }

                public void setChange_PercentChange(Object Change_PercentChange) {
                    this.Change_PercentChange = Change_PercentChange;
                }

                public Object getChange() {
                    return Change;
                }

                public void setChange(Object Change) {
                    this.Change = Change;
                }

                public Object getCommission() {
                    return Commission;
                }

                public void setCommission(Object Commission) {
                    this.Commission = Commission;
                }

                public Object getCurrency() {
                    return Currency;
                }

                public void setCurrency(Object Currency) {
                    this.Currency = Currency;
                }

                public Object getChangeRealtime() {
                    return ChangeRealtime;
                }

                public void setChangeRealtime(Object ChangeRealtime) {
                    this.ChangeRealtime = ChangeRealtime;
                }

                public Object getAfterHoursChangeRealtime() {
                    return AfterHoursChangeRealtime;
                }

                public void setAfterHoursChangeRealtime(Object AfterHoursChangeRealtime) {
                    this.AfterHoursChangeRealtime = AfterHoursChangeRealtime;
                }

                public Object getDividendShare() {
                    return DividendShare;
                }

                public void setDividendShare(Object DividendShare) {
                    this.DividendShare = DividendShare;
                }

                public Object getLastTradeDate() {
                    return LastTradeDate;
                }

                public void setLastTradeDate(Object LastTradeDate) {
                    this.LastTradeDate = LastTradeDate;
                }

                public Object getTradeDate() {
                    return TradeDate;
                }

                public void setTradeDate(Object TradeDate) {
                    this.TradeDate = TradeDate;
                }

                public Object getEarningsShare() {
                    return EarningsShare;
                }

                public void setEarningsShare(Object EarningsShare) {
                    this.EarningsShare = EarningsShare;
                }

                public Object getErrorIndicationreturnedforsymbolchangedinvalid() {
                    return ErrorIndicationreturnedforsymbolchangedinvalid;
                }

                public void setErrorIndicationreturnedforsymbolchangedinvalid(Object ErrorIndicationreturnedforsymbolchangedinvalid) {
                    this.ErrorIndicationreturnedforsymbolchangedinvalid = ErrorIndicationreturnedforsymbolchangedinvalid;
                }

                public Object getEPSEstimateCurrentYear() {
                    return EPSEstimateCurrentYear;
                }

                public void setEPSEstimateCurrentYear(Object EPSEstimateCurrentYear) {
                    this.EPSEstimateCurrentYear = EPSEstimateCurrentYear;
                }

                public Object getEPSEstimateNextYear() {
                    return EPSEstimateNextYear;
                }

                public void setEPSEstimateNextYear(Object EPSEstimateNextYear) {
                    this.EPSEstimateNextYear = EPSEstimateNextYear;
                }

                public Object getEPSEstimateNextQuarter() {
                    return EPSEstimateNextQuarter;
                }

                public void setEPSEstimateNextQuarter(Object EPSEstimateNextQuarter) {
                    this.EPSEstimateNextQuarter = EPSEstimateNextQuarter;
                }

                public Object getDaysLow() {
                    return DaysLow;
                }

                public void setDaysLow(Object DaysLow) {
                    this.DaysLow = DaysLow;
                }

                public Object getDaysHigh() {
                    return DaysHigh;
                }

                public void setDaysHigh(Object DaysHigh) {
                    this.DaysHigh = DaysHigh;
                }

                public Object getYearLow() {
                    return YearLow;
                }

                public void setYearLow(Object YearLow) {
                    this.YearLow = YearLow;
                }

                public Object getYearHigh() {
                    return YearHigh;
                }

                public void setYearHigh(Object YearHigh) {
                    this.YearHigh = YearHigh;
                }

                public Object getHoldingsGainPercent() {
                    return HoldingsGainPercent;
                }

                public void setHoldingsGainPercent(Object HoldingsGainPercent) {
                    this.HoldingsGainPercent = HoldingsGainPercent;
                }

                public Object getAnnualizedGain() {
                    return AnnualizedGain;
                }

                public void setAnnualizedGain(Object AnnualizedGain) {
                    this.AnnualizedGain = AnnualizedGain;
                }

                public Object getHoldingsGain() {
                    return HoldingsGain;
                }

                public void setHoldingsGain(Object HoldingsGain) {
                    this.HoldingsGain = HoldingsGain;
                }

                public Object getHoldingsGainPercentRealtime() {
                    return HoldingsGainPercentRealtime;
                }

                public void setHoldingsGainPercentRealtime(Object HoldingsGainPercentRealtime) {
                    this.HoldingsGainPercentRealtime = HoldingsGainPercentRealtime;
                }

                public Object getHoldingsGainRealtime() {
                    return HoldingsGainRealtime;
                }

                public void setHoldingsGainRealtime(Object HoldingsGainRealtime) {
                    this.HoldingsGainRealtime = HoldingsGainRealtime;
                }

                public Object getMoreInfo() {
                    return MoreInfo;
                }

                public void setMoreInfo(Object MoreInfo) {
                    this.MoreInfo = MoreInfo;
                }

                public Object getOrderBookRealtime() {
                    return OrderBookRealtime;
                }

                public void setOrderBookRealtime(Object OrderBookRealtime) {
                    this.OrderBookRealtime = OrderBookRealtime;
                }

                public Object getMarketCapitalization() {
                    return MarketCapitalization;
                }

                public void setMarketCapitalization(Object MarketCapitalization) {
                    this.MarketCapitalization = MarketCapitalization;
                }

                public Object getMarketCapRealtime() {
                    return MarketCapRealtime;
                }

                public void setMarketCapRealtime(Object MarketCapRealtime) {
                    this.MarketCapRealtime = MarketCapRealtime;
                }

                public Object getEBITDA() {
                    return EBITDA;
                }

                public void setEBITDA(Object EBITDA) {
                    this.EBITDA = EBITDA;
                }

                public Object getChangeFromYearLow() {
                    return ChangeFromYearLow;
                }

                public void setChangeFromYearLow(Object ChangeFromYearLow) {
                    this.ChangeFromYearLow = ChangeFromYearLow;
                }

                public Object getPercentChangeFromYearLow() {
                    return PercentChangeFromYearLow;
                }

                public void setPercentChangeFromYearLow(Object PercentChangeFromYearLow) {
                    this.PercentChangeFromYearLow = PercentChangeFromYearLow;
                }

                public Object getLastTradeRealtimeWithTime() {
                    return LastTradeRealtimeWithTime;
                }

                public void setLastTradeRealtimeWithTime(Object LastTradeRealtimeWithTime) {
                    this.LastTradeRealtimeWithTime = LastTradeRealtimeWithTime;
                }

                public Object getChangePercentRealtime() {
                    return ChangePercentRealtime;
                }

                public void setChangePercentRealtime(Object ChangePercentRealtime) {
                    this.ChangePercentRealtime = ChangePercentRealtime;
                }

                public Object getChangeFromYearHigh() {
                    return ChangeFromYearHigh;
                }

                public void setChangeFromYearHigh(Object ChangeFromYearHigh) {
                    this.ChangeFromYearHigh = ChangeFromYearHigh;
                }

                public Object getPercebtChangeFromYearHigh() {
                    return PercebtChangeFromYearHigh;
                }

                public void setPercebtChangeFromYearHigh(Object PercebtChangeFromYearHigh) {
                    this.PercebtChangeFromYearHigh = PercebtChangeFromYearHigh;
                }

                public Object getLastTradeWithTime() {
                    return LastTradeWithTime;
                }

                public void setLastTradeWithTime(Object LastTradeWithTime) {
                    this.LastTradeWithTime = LastTradeWithTime;
                }

                public Object getLastTradePriceOnly() {
                    return LastTradePriceOnly;
                }

                public void setLastTradePriceOnly(Object LastTradePriceOnly) {
                    this.LastTradePriceOnly = LastTradePriceOnly;
                }

                public Object getHighLimit() {
                    return HighLimit;
                }

                public void setHighLimit(Object HighLimit) {
                    this.HighLimit = HighLimit;
                }

                public Object getLowLimit() {
                    return LowLimit;
                }

                public void setLowLimit(Object LowLimit) {
                    this.LowLimit = LowLimit;
                }

                public Object getDaysRange() {
                    return DaysRange;
                }

                public void setDaysRange(Object DaysRange) {
                    this.DaysRange = DaysRange;
                }

                public Object getDaysRangeRealtime() {
                    return DaysRangeRealtime;
                }

                public void setDaysRangeRealtime(Object DaysRangeRealtime) {
                    this.DaysRangeRealtime = DaysRangeRealtime;
                }

                public Object getFiftydayMovingAverage() {
                    return FiftydayMovingAverage;
                }

                public void setFiftydayMovingAverage(Object FiftydayMovingAverage) {
                    this.FiftydayMovingAverage = FiftydayMovingAverage;
                }

                public Object getTwoHundreddayMovingAverage() {
                    return TwoHundreddayMovingAverage;
                }

                public void setTwoHundreddayMovingAverage(Object TwoHundreddayMovingAverage) {
                    this.TwoHundreddayMovingAverage = TwoHundreddayMovingAverage;
                }

                public Object getChangeFromTwoHundreddayMovingAverage() {
                    return ChangeFromTwoHundreddayMovingAverage;
                }

                public void setChangeFromTwoHundreddayMovingAverage(Object ChangeFromTwoHundreddayMovingAverage) {
                    this.ChangeFromTwoHundreddayMovingAverage = ChangeFromTwoHundreddayMovingAverage;
                }

                public Object getPercentChangeFromTwoHundreddayMovingAverage() {
                    return PercentChangeFromTwoHundreddayMovingAverage;
                }

                public void setPercentChangeFromTwoHundreddayMovingAverage(Object PercentChangeFromTwoHundreddayMovingAverage) {
                    this.PercentChangeFromTwoHundreddayMovingAverage = PercentChangeFromTwoHundreddayMovingAverage;
                }

                public Object getChangeFromFiftydayMovingAverage() {
                    return ChangeFromFiftydayMovingAverage;
                }

                public void setChangeFromFiftydayMovingAverage(Object ChangeFromFiftydayMovingAverage) {
                    this.ChangeFromFiftydayMovingAverage = ChangeFromFiftydayMovingAverage;
                }

                public Object getPercentChangeFromFiftydayMovingAverage() {
                    return PercentChangeFromFiftydayMovingAverage;
                }

                public void setPercentChangeFromFiftydayMovingAverage(Object PercentChangeFromFiftydayMovingAverage) {
                    this.PercentChangeFromFiftydayMovingAverage = PercentChangeFromFiftydayMovingAverage;
                }

                public Object getName() {
                    return Name;
                }

                public void setName(Object Name) {
                    this.Name = Name;
                }

                public Object getNotes() {
                    return Notes;
                }

                public void setNotes(Object Notes) {
                    this.Notes = Notes;
                }

                public Object getOpen() {
                    return Open;
                }

                public void setOpen(Object Open) {
                    this.Open = Open;
                }

                public Object getPreviousClose() {
                    return PreviousClose;
                }

                public void setPreviousClose(Object PreviousClose) {
                    this.PreviousClose = PreviousClose;
                }

                public Object getPricePaid() {
                    return PricePaid;
                }

                public void setPricePaid(Object PricePaid) {
                    this.PricePaid = PricePaid;
                }

                public Object getChangeinPercent() {
                    return ChangeinPercent;
                }

                public void setChangeinPercent(Object ChangeinPercent) {
                    this.ChangeinPercent = ChangeinPercent;
                }

                public Object getPriceSales() {
                    return PriceSales;
                }

                public void setPriceSales(Object PriceSales) {
                    this.PriceSales = PriceSales;
                }

                public Object getPriceBook() {
                    return PriceBook;
                }

                public void setPriceBook(Object PriceBook) {
                    this.PriceBook = PriceBook;
                }

                public Object getExDividendDate() {
                    return ExDividendDate;
                }

                public void setExDividendDate(Object ExDividendDate) {
                    this.ExDividendDate = ExDividendDate;
                }

                public Object getPERatio() {
                    return PERatio;
                }

                public void setPERatio(Object PERatio) {
                    this.PERatio = PERatio;
                }

                public Object getDividendPayDate() {
                    return DividendPayDate;
                }

                public void setDividendPayDate(Object DividendPayDate) {
                    this.DividendPayDate = DividendPayDate;
                }

                public Object getPERatioRealtime() {
                    return PERatioRealtime;
                }

                public void setPERatioRealtime(Object PERatioRealtime) {
                    this.PERatioRealtime = PERatioRealtime;
                }

                public Object getPEGRatio() {
                    return PEGRatio;
                }

                public void setPEGRatio(Object PEGRatio) {
                    this.PEGRatio = PEGRatio;
                }

                public Object getPriceEPSEstimateCurrentYear() {
                    return PriceEPSEstimateCurrentYear;
                }

                public void setPriceEPSEstimateCurrentYear(Object PriceEPSEstimateCurrentYear) {
                    this.PriceEPSEstimateCurrentYear = PriceEPSEstimateCurrentYear;
                }

                public Object getPriceEPSEstimateNextYear() {
                    return PriceEPSEstimateNextYear;
                }

                public void setPriceEPSEstimateNextYear(Object PriceEPSEstimateNextYear) {
                    this.PriceEPSEstimateNextYear = PriceEPSEstimateNextYear;
                }


                public Object getSharesOwned() {
                    return SharesOwned;
                }

                public void setSharesOwned(Object SharesOwned) {
                    this.SharesOwned = SharesOwned;
                }

                public Object getShortRatio() {
                    return ShortRatio;
                }

                public void setShortRatio(Object ShortRatio) {
                    this.ShortRatio = ShortRatio;
                }

                public Object getLastTradeTime() {
                    return LastTradeTime;
                }

                public void setLastTradeTime(Object LastTradeTime) {
                    this.LastTradeTime = LastTradeTime;
                }

                public Object getTickerTrend() {
                    return TickerTrend;
                }

                public void setTickerTrend(Object TickerTrend) {
                    this.TickerTrend = TickerTrend;
                }

                public Object getOneyrTargetPrice() {
                    return OneyrTargetPrice;
                }

                public void setOneyrTargetPrice(Object OneyrTargetPrice) {
                    this.OneyrTargetPrice = OneyrTargetPrice;
                }

                public Object getVolume() {
                    return Volume;
                }

                public void setVolume(Object Volume) {
                    this.Volume = Volume;
                }

                public Object getHoldingsValue() {
                    return HoldingsValue;
                }

                public void setHoldingsValue(Object HoldingsValue) {
                    this.HoldingsValue = HoldingsValue;
                }

                public Object getHoldingsValueRealtime() {
                    return HoldingsValueRealtime;
                }

                public void setHoldingsValueRealtime(Object HoldingsValueRealtime) {
                    this.HoldingsValueRealtime = HoldingsValueRealtime;
                }

                public Object getYearRange() {
                    return YearRange;
                }

                public void setYearRange(Object YearRange) {
                    this.YearRange = YearRange;
                }

                public Object getDaysValueChange() {
                    return DaysValueChange;
                }

                public void setDaysValueChange(Object DaysValueChange) {
                    this.DaysValueChange = DaysValueChange;
                }

                public Object getDaysValueChangeRealtime() {
                    return DaysValueChangeRealtime;
                }

                public void setDaysValueChangeRealtime(Object DaysValueChangeRealtime) {
                    this.DaysValueChangeRealtime = DaysValueChangeRealtime;
                }

                public Object getStockExchange() {
                    return StockExchange;
                }

                public void setStockExchange(Object StockExchange) {
                    this.StockExchange = StockExchange;
                }

                public Object getDividendYield() {
                    return DividendYield;
                }

                public void setDividendYield(Object DividendYield) {
                    this.DividendYield = DividendYield;
                }

                public Object getPercentChange() {
                    return PercentChange;
                }

                public void setPercentChange(Object PercentChange) {
                    this.PercentChange = PercentChange;
                }
            }
        }
    }
}
