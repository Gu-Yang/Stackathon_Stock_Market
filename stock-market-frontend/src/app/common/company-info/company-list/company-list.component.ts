import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

import { companies } from '../../../companies';

import { RoleService } from '../../../role.service';

@Component({
    selector: 'company-list',
    templateUrl: 'company-list.component.html',
    styleUrls: ['company-list.component.css']
})

export class CompanyListComponent implements OnInit {

    companies = companies;

    formData;

    role = this.roleService.getRole();

    constructor(
        private formBuilder: FormBuilder,
        private roleService: RoleService,
        private router: Router,
    ) { 
        this.formData = this.formBuilder.group({
            searchText: ''
        });
    }

    ngOnInit() { }

    submit(data) {
        window.alert("Text " + data.searchText + " was searched!");
    }

    openDetails(company) {
        // window.alert("Option details of Company " + company.companyName + "(" + company.id + ").")
        this.router.navigate(['company-detail']);
    }

    openCharts(company) {
        // window.alert("Option charts of Company " + company.companyName + "(" + company.id + ").")
        this.router.navigate(['company-chart']);
    }

    edit(company) {
        this.router.navigate(['edit-company']);
    }

    deactivate(company) {
        window.alert("Company [" + company.companyName + "] was deactivated!")
    }

    addCompany() {
        this.router.navigate(['add-company']);
    }
}