package com.example.stockservice.service;

import com.example.stockservice.model.HistoricalQuotesRequest;
import com.example.stockservice.model.HistoricalQuotesResponse;
import com.example.stockservice.model.StockQuotes;

import java.util.List;

public interface StockServiceApi {
    StockQuotes getStockQuotesByTicket(List<String> tickets);

    HistoricalQuotesResponse getHistoricalQuotes(HistoricalQuotesRequest request);
}
