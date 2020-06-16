package com.gy.entity.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StockPriceResponse {
    private double currentPrice;
    private LocalDate localDate;
}