package com.gy.service.impl;

import com.gy.entity.Company;
import com.gy.repository.CompanyRepository;
import com.gy.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "companyCode");
        return companyRepository.findAll(sort);
    }

    @Override
    public List<Company> findAllActiveCompany() {
        return companyRepository.findByIsActiveOrderByCompanyCodeAsc(true);
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

        if (company == null) {
            return;
        }

        company.setActive(status);
        companyRepository.save(company);
    }
}