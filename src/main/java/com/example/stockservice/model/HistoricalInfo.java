package com.example.stockservice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HistoricalInfo {

    private String symbol;
    private String date;
    private BigDecimal close;
}
