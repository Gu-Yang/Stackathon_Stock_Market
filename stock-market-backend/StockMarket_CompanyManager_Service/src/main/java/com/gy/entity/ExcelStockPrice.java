package com.gy.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ExcelStockPrice {
    private String companyCode;
    private String companyName;
    private double currentPrice;
    private LocalDateTime localDateTime;
}