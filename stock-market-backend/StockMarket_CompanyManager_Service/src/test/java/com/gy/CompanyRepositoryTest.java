package com.gy;

import com.gy.entity.Company;
import com.gy.repository.CompanyRepository;
import com.gy.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @Test
    public void testFindAllCompany() {
        Sort sort = Sort.by(Sort.Direction.ASC, "companyName");
        List<Company> companyList = companyRepository.findAll(sort);
        System.out.println(companyList);
    }

    @Test
    public void testFindBySearchText() {
        Sort sort = Sort.by(Sort.Direction.ASC, "companyName");
        String searchText = "a";
        List<Company> companyList = companyRepository.findByCompanyNameContainingOrderByCompanyCodeAsc(searchText);
        System.out.println(companyList);
    }

    @Test
    public void testFindCompanyBycompanyCode() {
        String companyCode = "471678";
        Company company = companyRepository.findByCompanyCode(companyCode);
        System.out.println(company);
    }

    @Test
    public void testSetActiveStatus() {
        companyService.setActiveStatus("471678", false);
        Company company = companyService.findByCompanyCode("471678");
        System.out.println(company);
    }

    @Test
    public void testFindAllActiveCompany() {
        List<Company> companyList = companyService.findAllActiveCompany();
        System.out.println(companyList);
    }
}