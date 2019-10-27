package com.zeroout.java.stockpricequery.model;

import java.math.BigDecimal;

public class Quote {

    private String quote;
    private BigDecimal bid;
    private BigDecimal ask;

    public Quote(String quote, BigDecimal bid, BigDecimal ask) {
        this.quote = quote;
        this.bid = bid;
        this.ask = ask;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }
}
