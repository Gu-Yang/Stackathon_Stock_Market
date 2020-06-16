package com.gy.entity.response;

import com.gy.entity.StockPrice;
import lombok.Data;

import java.util.List;

@Data
public class CompanyAndStockPriceResponse {
    private String companyCode;
    private String companyName;
    private List<StockPriceResponse> stockPrices;
}