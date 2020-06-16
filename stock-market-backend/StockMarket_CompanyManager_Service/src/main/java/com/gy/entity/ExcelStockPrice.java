package com.gy.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExcelStockPrice {
    private String companyCode;
    private String companyName;
    private double currentPrice;
    private LocalDateTime localDateTime;
}