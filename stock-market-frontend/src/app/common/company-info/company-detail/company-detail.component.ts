import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router'

import { companies } from '../../../companies';
import { CompanyService } from 'src/app/company.service';
 
@Component({
  selector: 'company-detail',
  templateUrl: './company-detail.component.html',
  styleUrls: ['./company-detail.component.css']
})
export class CompanyDetailComponent implements OnInit {

    company

    constructor(
      private router: Router,
      private activatedRoute : ActivatedRoute,
      private companyService : CompanyService
    ) { 

      let companyCode = this.activatedRoute.snapshot.queryParams['companyCode'];
      this.companyService.getCompanyByCode(companyCode)
      .then(res => {
        this.company = res;
        console.log(this.company);
      })
      .catch(error => {
        console.error(error);
      });

    }

    ngOnInit() {
        
    }

    close() {
      this.router.navigate(['company-list']);
    }

}