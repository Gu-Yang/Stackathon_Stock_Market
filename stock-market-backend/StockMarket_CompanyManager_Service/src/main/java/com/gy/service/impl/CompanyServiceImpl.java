package com.gy.service.impl;

import com.gy.entity.Company;
import com.gy.repository.CompanyRepository;
import com.gy.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> searchCompany(String searchText) {
        return companyRepository.findByCompanyNameContainingOrderByCompanyCodeAsc(searchText);
    }

    @Override
    public Company findByCompanyCode(String companyCode) {
        return companyRepository.findByCompanyCode(companyCode);
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void editCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void setActiveStatus(String companyCode, boolean status) {
        Company company = companyRepository.findByCompanyCode(companyCode);
        company.setActive(status);
        companyRepository.save(company);
    }
}