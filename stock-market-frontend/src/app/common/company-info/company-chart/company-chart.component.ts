import { Component, OnInit } from '@angular/core';

import { companies} from '../../../companies';
 
@Component({
  selector: 'company-chart',
  templateUrl: './company-chart.component.html',
  styleUrls: ['./company-chart.component.css']
})
export class CompanyChartComponent implements OnInit {

    company = companies[0];

    constructor() { }

    ngOnInit() {
        
    }

}