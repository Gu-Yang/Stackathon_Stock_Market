import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router} from '@angular/router'

import { companies } from '../../companies';

@Component({
  selector: 'edit-company',
  templateUrl: './edit-company.component.html',
  styleUrls: ['./edit-company.component.css']
})
export class EditCompanyComponent {

  checkoutForm;

  company = companies[1];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
  ) {
    this.checkoutForm = this.formBuilder.group({
      companyId: this.company.id,
      companyName: '',
      ceoName: '',
      boardMembers: '',
      description: ''
    });
  }

  submit(formData) {
    window.alert("Company Id: " + formData.companyId + "\nCompany Name: " + formData.companyName + "\nCEO Name: " + formData.ceoName + "\nBoard Member: " + formData.boardMembers + "\nDescription:" + formData.description + "\nEdit company successfully!");
    this.router.navigate(['company-list']);
  }

  cancel() {
    this.router.navigate(['company-list']);
  }

}