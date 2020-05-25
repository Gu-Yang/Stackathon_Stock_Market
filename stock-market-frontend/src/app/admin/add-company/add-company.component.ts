import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router} from '@angular/router'


@Component({
  selector: 'add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent {

  checkoutForm;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
  ) {
    this.checkoutForm = this.formBuilder.group({
      companyName: '',
      ceoName: '',
      boardMembers: '',
      description: ''
    });
  }

  submit(formData) {
    window.alert("Company Name: " + formData.companyName + "\nCEO Name: " + formData.ceoName + "\nBoard Member: " + formData.boardMembers + "\nDescription:" + formData.description + "\nAdd company successfully!");
    this.router.navigate(['company-list']);
  }

  cancel() {
    this.router.navigate(['company-list']);
  }

}