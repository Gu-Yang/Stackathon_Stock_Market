package com.gy.service.impl;

import com.gy.entity.Company;
import com.gy.entity.ExcelStockPrice;
import com.gy.entity.StockPrice;
import com.gy.repository.CompanyRepository;
import com.gy.repository.StockPriceRepository;
import com.gy.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Override
    public int UploadStockPrices(List<ExcelStockPrice> excelStockPriceList) {

        int uploadedCount = 0;

        for (ExcelStockPrice excelStockPrice : excelStockPriceList) {
            String companyCode = excelStockPrice.getCompanyCode();

            if (companyCode == null) {
                continue;
            }

            Company company = companyRepository.findByCompanyCode(companyCode);
            if (company != null) {
                StockPrice stockPrice = new StockPrice();
                stockPrice.setCompany(company);
                stockPrice.setCurrentPrice(excelStockPrice.getCurrentPrice());
                stockPrice.setTimestamp(excelStockPrice.getLocalDateTime());
                stockPriceRepository.save(stockPrice);
                uploadedCount++;
            }
        }
        return uploadedCount;
    }
}