import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router'

import { companies } from '../../../companies';
 
@Component({
  selector: 'company-detail',
  templateUrl: './company-detail.component.html',
  styleUrls: ['./company-detail.component.css']
})
export class CompanyDetailComponent implements OnInit {

    company = companies[0];

    constructor(
      private router: Router,
    ) { }

    ngOnInit() {
        
    }

    close() {
      this.router.navigate(['company-list']);
    }

}