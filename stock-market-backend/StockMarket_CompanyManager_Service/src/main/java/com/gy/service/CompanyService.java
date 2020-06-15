package com.gy.service;

import com.gy.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    List<Company> searchCompany(String searchText);
    Company findByCompanyCode(String companyCode);
}
