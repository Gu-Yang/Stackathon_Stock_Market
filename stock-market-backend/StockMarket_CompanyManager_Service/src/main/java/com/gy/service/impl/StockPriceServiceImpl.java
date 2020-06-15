package com.gy.service.impl;

import com.gy.entity.StockPrice;
import com.gy.repository.StockPriceRepository;
import com.gy.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StockPriceServiceImpl implements StockPriceService {

    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Override
    public List<StockPrice> findAll() {
        return stockPriceRepository.findAll();
    }

    @Override
    public List<StockPrice> findByCompanyCode(String companyCode) {
        return stockPriceRepository.findByCompanyCompanyCode(companyCode);
    }


}