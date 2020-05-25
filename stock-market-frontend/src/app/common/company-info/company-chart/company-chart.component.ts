import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router'

import { companies} from '../../../companies';
 
@Component({
  selector: 'company-chart',
  templateUrl: './company-chart.component.html',
  styleUrls: ['./company-chart.component.css']
})
export class CompanyChartComponent implements OnInit {

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