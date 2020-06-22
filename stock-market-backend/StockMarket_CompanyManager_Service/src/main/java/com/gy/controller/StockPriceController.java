package com.gy.controller;

import com.gy.entity.Company;
import com.gy.entity.StockPrice;
import com.gy.entity.request.StockPriceRequest;
import com.gy.entity.response.CompanyAndStockPriceResponse;
import com.gy.entity.response.StockPriceResponse;
import com.gy.service.CompanyService;
import com.gy.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

@RestController
public class StockPriceController {

    @Autowired
    private StockPriceService stockPriceService;
    @Autowired
    private CompanyService companyService;

    @PostMapping("/getStockPrices")
    public ResponseEntity<CompanyAndStockPriceResponse> getStockPrices(@RequestBody StockPriceRequest request) {
        String companyCode = request.getCompanyCode();

        if (companyCode == null || companyCode.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Company company = companyService.findByCompanyCode(companyCode);
        List<StockPrice> stockPriceList = stockPriceService.findByCompanyCode(companyCode);

        if (company == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<StockPriceResponse> stockPriceResponseList = mergeStockPriceList(stockPriceList);
        Collections.sort(stockPriceResponseList, Comparator.comparing(StockPriceResponse::getLocalDate));

        CompanyAndStockPriceResponse companyAndStockPriceResponse = new CompanyAndStockPriceResponse();
        companyAndStockPriceResponse.setCompanyCode(company.getCompanyCode());
        companyAndStockPriceResponse.setCompanyName(company.getCompanyName());
        companyAndStockPriceResponse.setStockPrices(stockPriceResponseList);

        return new ResponseEntity<>(companyAndStockPriceResponse, HttpStatus.OK);
    }

    private List<StockPriceResponse> mergeStockPriceList(List<StockPrice> stockPriceList) {

        Map<LocalDate, List<StockPrice>> stockPriceMap = new HashMap<>();

        for (StockPrice stockPrice : stockPriceList) {
            LocalDate date = stockPrice.getTimestamp().toLocalDate();
            if (stockPriceMap.get(date) == null) {
                List<StockPrice> list = new ArrayList<>();
                stockPriceMap.put(date, list);
            }
            stockPriceMap.get(date).add(stockPrice);
        }

        List<StockPriceResponse> mergedStockPriceList = new ArrayList<>();
        for (LocalDate date : stockPriceMap.keySet()) {
            List<StockPrice> list = stockPriceMap.get(date);
            StockPriceResponse stockPriceResponse = merge(list, date);
            mergedStockPriceList.add(stockPriceResponse);
        }

        return mergedStockPriceList;
    }

    private StockPriceResponse merge(List<StockPrice> stockPriceList, LocalDate date) {

        double totalPrice = 0;

        for (StockPrice stockPrice : stockPriceList) {
            totalPrice += stockPrice.getCurrentPrice();
        }

        double averagePrice = totalPrice / stockPriceList.size();

        double scaledAveragePrice = new BigDecimal(averagePrice).setScale(2, RoundingMode.HALF_UP).doubleValue();

        StockPriceResponse stockPriceResponse = new StockPriceResponse();
        stockPriceResponse.setCurrentPrice(scaledAveragePrice);
        stockPriceResponse.setLocalDate(date);

        return stockPriceResponse;
    }
}