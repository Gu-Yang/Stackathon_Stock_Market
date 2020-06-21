import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute} from '@angular/router'

import { companies } from '../../companies';
import { CompanyService } from 'src/app/company.service';

@Component({
  selector: 'edit-company',
  templateUrl: './edit-company.component.html',
  styleUrls: ['./edit-company.component.css']
})
export class EditCompanyComponent {

  checkoutForm;

  company;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRoute : ActivatedRoute,
    private companyService : CompanyService
  ) { 

    let companyCode = this.activatedRoute.snapshot.queryParams['companyCode'];
    this.companyService.getCompanyByCode(companyCode)
    .then(res => {
      this.company = res;
      console.log(this.company);
      this.checkoutForm = this.formBuilder.group({
        companyCode: this.company.companyCode,
        companyName: this.company.companyName,
        ceoName: this.company.ceoName,
        boardMember: this.company.boardMember,
        description: this.company.description
      });
    })
    .catch(error => {
      console.error(error);
    });

  }

  submit(formData) {
    // window.alert("Company Id: " + formData.companyId + "\nCompany Name: " + formData.companyName + "\nCEO Name: " + formData.ceoName + "\nBoard Member: " + formData.boardMembers + "\nDescription:" + formData.description + "\nEdit company successfully!");
    this.companyService.editCompany(this.company, formData)
    .then(res => {
      alert("Update company info successfully!");
      this.router.navigate(['company-list']);
    })
    .catch(error => {
      console.error(error);
    })
  }

  cancel() {
    this.router.navigate(['company-list']);
  }

}