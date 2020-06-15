package com.gy;

import com.gy.entity.Company;
import com.gy.entity.StockPrice;
import com.gy.repository.CompanyRepository;
import com.gy.repository.StockPriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class DataInitTest {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Test
    public void testInitCompany() {

        Company company1 = new Company();
        company1.setCompanyCode("746783");
        company1.setCompanyName("ABC");
        company1.setCeoName("Li");
        company1.setBoardMember(40);
        company1.setDescription("abc");

        Company company2 = new Company();
        company2.setCompanyCode("564367");
        company2.setCompanyName("IKBC");
        company2.setCeoName("Wang");
        company2.setBoardMember(547);
        company2.setDescription("ikbc");

        Company company3 = new Company();
        company3.setCompanyCode("464995");
        company3.setCompanyName("ABC");
        company3.setCeoName("Li");
        company3.setBoardMember(40);
        company3.setDescription("abc");

        Company company4 = new Company();
        company4.setCompanyCode("321567");
        company4.setCompanyName("TCPIP");
        company4.setCeoName("Martin");
        company4.setBoardMember(64);
        company4.setDescription("tcpip");

        Company company5 = new Company();
        company5.setCompanyCode("647642");
        company5.setCompanyName("Razer");
        company5.setCeoName("Tom");
        company5.setBoardMember(193);
        company5.setDescription("razer");

        Company company6 = new Company();
        company6.setCompanyCode("471678");
        company6.setCompanyName("AMD");
        company6.setCeoName("Su");
        company6.setBoardMember(437);
        company6.setDescription("amd,yes!");

        Company company7 = new Company();
        company7.setCompanyCode("962345");
        company7.setCompanyName("Tiger Gaming");
        company7.setCeoName("Xuan");
        company7.setBoardMember(21);
        company7.setDescription("tiger gaming");

        companyRepository.save(company1);
        companyRepository.save(company2);
        companyRepository.save(company3);
        companyRepository.save(company4);
        companyRepository.save(company5);
        companyRepository.save(company6);
        companyRepository.save(company7);

    }

    @Test
    public void testInitStockPrice() {

        Company company1 = companyRepository.findByCompanyCode("471678");
        Company company2 = companyRepository.findByCompanyCode("647642");

        StockPrice stockPrice1 = new StockPrice();
        stockPrice1.setCompany(company1);
        stockPrice1.setCurrentPrice(69.43);
        stockPrice1.setTimestamp(LocalDateTime.of(2020, 5,1, 6, 0));

        StockPrice stockPrice2 = new StockPrice();
        stockPrice2.setCompany(company1);
        stockPrice2.setCurrentPrice(71.57);
        stockPrice2.setTimestamp(LocalDateTime.of(2020, 5,1, 7, 0));

        StockPrice stockPrice3 = new StockPrice();
        stockPrice3.setCompany(company1);
        stockPrice3.setCurrentPrice(78.43);
        stockPrice3.setTimestamp(LocalDateTime.of(2020, 5,1, 8, 0));

        StockPrice stockPrice4 = new StockPrice();
        stockPrice4.setCompany(company1);
        stockPrice4.setCurrentPrice(73.46);
        stockPrice4.setTimestamp(LocalDateTime.of(2020, 5,1, 9, 0));

        StockPrice stockPrice5 = new StockPrice();
        stockPrice5.setCompany(company2);
        stockPrice5.setCurrentPrice(345.36);
        stockPrice5.setTimestamp(LocalDateTime.of(2020, 5,3, 6, 0));

        StockPrice stockPrice6 = new StockPrice();
        stockPrice6.setCompany(company2);
        stockPrice6.setCurrentPrice(365.23);
        stockPrice6.setTimestamp(LocalDateTime.of(2020, 5,3, 7, 0));

//        Set<StockPrice> stockPriceSet1 = new HashSet<>();
//        stockPriceSet1.add(stockPrice1);
//        stockPriceSet1.add(stockPrice2);
//        stockPriceSet1.add(stockPrice3);
//        stockPriceSet1.add(stockPrice4);
//
//        Set<StockPrice> stockPriceSet2 = new HashSet<>();
//        stockPriceSet2.add(stockPrice5);
//        stockPriceSet2.add(stockPrice6);
//
//        company1.setStockPriceSet(stockPriceSet1);
//        company2.setStockPriceSet(stockPriceSet2);
//
//        companyRepository.save(company1);
//        companyRepository.save(company2);

        stockPriceRepository.save(stockPrice1);
        stockPriceRepository.save(stockPrice2);
        stockPriceRepository.save(stockPrice3);
        stockPriceRepository.save(stockPrice4);
        stockPriceRepository.save(stockPrice5);
        stockPriceRepository.save(stockPrice6);
    }

    @Test
    public void deleteAllCompanies() {
        companyRepository.deleteAll();
    }
}