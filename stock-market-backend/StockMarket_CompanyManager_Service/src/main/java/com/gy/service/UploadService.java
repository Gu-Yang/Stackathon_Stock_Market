package com.gy.service;

import com.gy.entity.ExcelStockPrice;

import java.util.List;

public interface UploadService {
    int UploadStockPrices(List<ExcelStockPrice> excelStockPriceList);
}
