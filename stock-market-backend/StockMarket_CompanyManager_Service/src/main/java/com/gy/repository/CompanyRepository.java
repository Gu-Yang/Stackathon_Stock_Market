package com.gy.repository;

import com.gy.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByCompanyCode(String companyCode);
    List<Company> findByCompanyNameContainingOrderByCompanyCodeAsc(String searchText);
    List<Company> findByIsActive(boolean isActive);
}
