package com.zeroout.java.stockpricequery.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel(description = "Details of the Quote")
public class Quote {

    @ApiModelProperty(notes = "This is the unique stock code")
    private String quote;
    @ApiModelProperty(notes = "This bid price of the stock")
    private BigDecimal bid;
    @ApiModelProperty(notes = "This ask price of the stock")
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
