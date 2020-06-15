package com.gy;

import com.gy.entity.Company;
import com.gy.entity.StockPrice;
import com.gy.repository.CompanyRepository;
import com.gy.repository.StockPriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StockPriceTest {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Test
    public void testFindAllStockPrice() {
        List<StockPrice> all = stockPriceRepository.findAll();
        System.out.println(all);
    }

    @Test
    public void testFindStockPriceByCompany() {

        List<StockPrice> list = stockPriceRepository.findByCompanyCompanyCode("471678");
        System.out.println(list);
    }
}