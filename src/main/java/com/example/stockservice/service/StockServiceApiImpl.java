package com.example.stockservice.service;

import com.example.stockservice.model.HistoricalQuotesRequest;
import com.example.stockservice.model.HistoricalQuotesResponse;
import com.example.stockservice.model.StockQuotes;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
class StockServiceApiImpl implements StockServiceApi{

    private final RestTemplate restTemplate;
    private final String token;
    private final String urlStockQuotes;
    private final String urlHistoricalStock;

    public StockServiceApiImpl(@Qualifier("restTemplateStock") RestTemplate restTemplate,
                               @Value("${stock.token}") String token,
                               @Value("${stock.url.quote}") String urlStockQuotes,
                               @Value("${stock.url.historical-quote}") String urlHistoricalStock) {
        this.restTemplate = restTemplate;
        this.token = token;
        this.urlStockQuotes = urlStockQuotes;
        this.urlHistoricalStock = urlHistoricalStock;
    }

    @Override
    public StockQuotes getStockQuotesByTicket(List<String> tickets) {
        String collectTicket = String.join(",", tickets);

        ResponseEntity<StockQuotes> responseEntity = restTemplate.getForEntity(
                String.format(urlStockQuotes, collectTicket, token),
                StockQuotes.class
        );
        return responseEntity.getBody();
    }

    @Override
    public HistoricalQuotesResponse getHistoricalQuotes(HistoricalQuotesRequest request) {
        String collectTicket = String.join(",", request.getTickets());

        ResponseEntity<HistoricalQuotesResponse> responseEntity = restTemplate.getForEntity(
                String.format(urlHistoricalStock, collectTicket, request.getDate(), token),
                HistoricalQuotesResponse.class
        );
        return responseEntity.getBody();
    }
}
