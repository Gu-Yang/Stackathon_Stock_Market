import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

import { companies } from '../../../companies'

@Component({
    selector: 'company-list',
    templateUrl: 'company-list.component.html',
    styleUrls: ['company-list.component.css']
})

export class CompanyListComponent implements OnInit {

    companies = companies;

    formData;

    constructor(
        private formBuilder : FormBuilder
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
        window.alert("Option details of Company " + company.companyName + "(" + company.id + ").")
    }

    openCharts(company) {
        window.alert("Option charts of Company " + company.companyName + "(" + company.id + ").")
    }
}