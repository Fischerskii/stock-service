package com.example.stockservice.controller;

import com.example.stockservice.model.HistoricalQuotesRequest;
import com.example.stockservice.model.HistoricalQuotesResponse;
import com.example.stockservice.model.StockQuotes;
import com.example.stockservice.service.StockServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockServiceApi stockServiceApi;

    @PostMapping("/get-stock-quotes")
    public StockQuotes getStockQuotes(@RequestBody List<String> tickets) {
        return stockServiceApi.getStockQuotesByTicket(tickets);
    }

    @PostMapping("/get-historical-quotes")
    public HistoricalQuotesResponse getStockQuotes(@RequestBody HistoricalQuotesRequest request) {
        return stockServiceApi.getHistoricalQuotes(request);
    }
}
