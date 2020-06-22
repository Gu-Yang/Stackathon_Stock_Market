import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router'

import { CompanyService } from 'src/app/company.service';
import { EChartOption } from 'echarts';
import * as echarts from 'echarts';
 
@Component({
  selector: 'company-chart',
  templateUrl: './company-chart.component.html',
  styleUrls: ['./company-chart.component.css']
})
export class CompanyChartComponent implements OnInit {

    stockPriceInfo: any = {
      'companyCode': '',
      'companyName': '',
      'stockPrices': []
    };
    options;

    constructor(
      private router: Router,
      private activatedRoute : ActivatedRoute,
      private companyService : CompanyService
    ) { 
      console.info(this.options);
      let companyCode = this.activatedRoute.snapshot.queryParams['companyCode'];
      this.companyService.getStockPricesByCode(companyCode)
      .then(res => {
        this.stockPriceInfo = res;
        console.log(this.stockPriceInfo);
        
        if (this.stockPriceInfo.stockPrices.length != 0) {
          this.setData(this.stockPriceInfo);
          
          let node = document.getElementById("charts");
          let myCharts = echarts.init(node);
          myCharts.setOption(this.options);
        }

      })
      .catch(error => {
        console.error(error);
      });
    }

    ngOnInit() {}

    close() {
      this.router.navigate(['company-list']);
    }

    setData(stockPriceInfo) {
      let priceSet = stockPriceInfo.stockPrices;
      let dates = [];
      let prices = [];
      
      for(let p of priceSet) {
        let date = p.localDate;
        let price = p.currentPrice;
        dates.push(date);
        prices.push(price);
      }

      this.setChartOptions(dates, prices);
    }

    setChartOptions(dates, prices) {
      this.options = { 
        title: { text: 'Stock Price', }, 
        tooltip: {}, 
        xAxis: { 
          data: dates, 
        },
         yAxis: {}, 
         series: [
           { 
            name: 'Stock Price', 
            type: 'line', 
            data: prices,
           },
          ], 
        };
    }

}