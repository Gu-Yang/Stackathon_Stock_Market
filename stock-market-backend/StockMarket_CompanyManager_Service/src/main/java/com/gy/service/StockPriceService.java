package com.gy.service;

import com.gy.entity.StockPrice;

import java.util.List;

public interface StockPriceService {
    List<StockPrice> findAll();
    List<StockPrice> findByCompanyCode(String companyCode);
}
