package com.gy.service;

import com.gy.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();
    List<Company> findAllActiveCompany();
    List<Company> searchCompany(String searchText);
    Company findByCompanyCode(String companyCode);
    public void addCompany(Company company);
    public void editCompany(Company company);
    public void setActiveStatus(String companyCode, boolean status);
}
