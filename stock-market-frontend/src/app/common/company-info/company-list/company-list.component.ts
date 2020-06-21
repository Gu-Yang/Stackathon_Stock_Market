import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

import { companies } from '../../../companies';

import { RoleService } from '../../../role.service';
import { CompanyService } from 'src/app/company.service';

@Component({
    selector: 'company-list',
    templateUrl: 'company-list.component.html',
    styleUrls: ['company-list.component.css']
})

export class CompanyListComponent implements OnInit {

    companies;

    formData;

    role;

    constructor(
        private formBuilder: FormBuilder,
        private roleService: RoleService,
        private router: Router,
        private companyService: CompanyService,
    ) {
        this.formData = this.formBuilder.group({
            searchText: ''
        });

        this.companyService.getCompanyList()
            .then(res => {

                this.companies = res;
                console.log(res);
            })
            .catch(error => {
                console.error(error);
            })

        this.role = localStorage.getItem('role');
    }

    ngOnInit() { }

    submit(formData) {
        let searchText = formData.searchText;
        this.companyService.searchCompany(searchText)
        .then(res => {
            this.companies = res;
            console.log(res);
        })
        .catch(error => {
            console.error(error);
        })
    }

    openDetails(company) {

        this.router.navigate(['company-detail'], {queryParams: {companyCode: company.companyCode}});
    }

    openCharts(company) {
        // window.alert("Option charts of Company " + company.companyName + "(" + company.id + ").")
        this.router.navigate(['company-chart'], {queryParams: {companyCode: company.companyCode}});
    }

    edit(company) {
        this.router.navigate(['edit-company'], {queryParams: {companyCode: company.companyCode}});
    }

    setCompanyActivateStatus(company, targetStatus) {
        this.companyService.setCompanyActivateStatus(company.companyCode, targetStatus)
        .then(res => {
            console.log('Deactivate company [' + company.companyName + '] successfully!');
            company.active = targetStatus;
        })
        .catch(error => {
            console.error(error);
        });
    }


    addCompany() {
        this.router.navigate(['add-company']);
    }

}