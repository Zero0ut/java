package com.zeroout.java.stockpricequery.controller;

import com.zeroout.java.stockpricequery.model.Quote;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/rest/stock")
public class StockController {

    Logger logger = LoggerFactory.getLogger(StockController.class);

    @GetMapping("/{quote}")
    @ApiOperation(value = "Find Stock Price by Stock Code",
       notes = "Provide an stock code to lookup the bid and ask price of a stock",
       response = Quote.class)
    private Quote getStockPrice(@PathVariable("quote") final String quote) {

        try {
            InetAddress ip = InetAddress.getLocalHost();
            logger.info("From host: " + ip);
        } catch (UnknownHostException ex) {
            logger.error("Unable to detected host ip");
        }
        logger.info("Fetching Stock Price: " + quote.toUpperCase());

        Stock stock;
        try {
            stock = YahooFinance.get(quote);
        } catch (IOException e) {
            e.printStackTrace();
            stock =  new Stock(quote);
        }
        return new Quote(quote, stock.getQuote().getBid(), stock.getQuote().getAsk());
    }
}
