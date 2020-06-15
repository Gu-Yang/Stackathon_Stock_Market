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
}