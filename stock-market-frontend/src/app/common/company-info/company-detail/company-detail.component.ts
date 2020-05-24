import { Component, OnInit } from '@angular/core';

import { companies} from '../../../companies';
 
@Component({
  selector: 'company-detail',
  templateUrl: './company-detail.component.html',
  styleUrls: ['./company-detail.component.css']
})
export class CompanyDetailComponent implements OnInit {

    company = companies[0];

    constructor() { }

    ngOnInit() {
        
    }

}