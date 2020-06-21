package com.gy.controller;

import com.gy.entity.Company;
import com.gy.entity.request.CompanyRequest;
import com.gy.entity.request.SearchCompanyRequest;
import com.gy.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/findCompanyByCode")
    public Company findCompanyByCompanyCode(@RequestBody CompanyRequest request) {
        Company company = companyService.findByCompanyCode(request.getCompanyCode());
        return company;
    }

//    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    @GetMapping("/findAllCompany")
    public List<Company> findAllCompany() {
        List<Company> companyList = companyService.findAll();

        return companyList;
    }

    @GetMapping("/findAllActiveCompany")
    public List<Company> findAllActiveCompany() {
        List<Company> companyList = companyService.findAllActiveCompany();
        return companyList;
    }

    @PostMapping("/searchCompany")
    public List<Company> searchCompany(@RequestBody SearchCompanyRequest request) {
        List<Company> companyList = companyService.searchCompany(request.getSearchText());
        return companyList;
    }

    @PostMapping("/searchActiveCompany")
    public List<Company> searchActiveCompany(@RequestBody SearchCompanyRequest request) {
        List<Company> companyList = companyService.searchCompany(request.getSearchText());
        List<Company> activeCompanyList = new ArrayList<>();

        for (Company company : companyList) {
            if (company.isActive()) {
                activeCompanyList.add(company);
            }
        }

        return activeCompanyList;
    }

    @PostMapping("/addCompany")
    public void addCompany(@RequestBody CompanyRequest request) {

        boolean codeGenerateFlag = false;
        String companyCode = null;

        while(codeGenerateFlag != true) {
            int companyCodeNum = (int) (Math.random()*1000000);
            if (companyCodeNum < 100000) {
                companyCodeNum += 100000;
            }
            companyCode = String.valueOf(companyCodeNum);
            if(companyService.findByCompanyCode(companyCode) == null) {
                codeGenerateFlag = true;
            }
        }

        Company company = new Company();
        company.setCompanyCode(companyCode);
        company.setCompanyName(request.getCompanyName());
        company.setCeoName(request.getCeoName());
        company.setBoardMember(request.getBoardMember());
        company.setDescription(request.getDescription());
        company.setActive(true);

        companyService.addCompany(company);
    }

    @PostMapping("/editCompany")
    public void editCompany(@RequestBody CompanyRequest request) {
        String companyCode = request.getCompanyCode();
        Company company = companyService.findByCompanyCode(companyCode);

        if (company == null) {
            return;
        }

        company.setCompanyName(request.getCompanyName());
        company.setCeoName(request.getCeoName());
        company.setBoardMember(request.getBoardMember());
        company.setDescription(request.getDescription());

        companyService.editCompany(company);
    }

    @PostMapping("/setCompanyActiveStatus")
    public void setCompanyActiveStatus(@RequestBody CompanyRequest request) {
        String companyCode = request.getCompanyCode();
        boolean isActive = request.isActive();

        if (companyCode != null) {
            companyService.setActiveStatus(companyCode, isActive);
        }
    }

}