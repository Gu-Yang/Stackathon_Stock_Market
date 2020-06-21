import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router} from '@angular/router'
import { CompanyService } from 'src/app/company.service';


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
    private companyService: CompanyService,
  ) {
    this.checkoutForm = this.formBuilder.group({
      companyName: '',
      ceoName: '',
      boardMember: '',
      description: ''
    });
  }

  submit(formData) {
    // window.alert("Company Name: " + formData.companyName + "\nCEO Name: " + formData.ceoName + "\nBoard Member: " + formData.boardMembers + "\nDescription:" + formData.description + "\nAdd company successfully!");
    this.companyService.addCompany(formData)
    .then(res => {
      alert("Add new company successfully!");
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