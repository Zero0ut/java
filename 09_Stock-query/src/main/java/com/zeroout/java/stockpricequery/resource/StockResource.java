package com.zeroout.java.stockpricequery.resource;

import com.zeroout.java.stockpricequery.model.Quote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

    @GetMapping("/{quote}")
    private Quote getStockPrice(@PathVariable("quote") final String quote) {
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
