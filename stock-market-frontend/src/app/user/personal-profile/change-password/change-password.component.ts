import { Component} from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent {

    checkoutForm;

    constructor(
      private formBuilder: FormBuilder,
      private router : Router,
    ) { 
      this.checkoutForm = this.formBuilder.group({
        oldpassword: '',
        newpassword: '',
        repeatpassword: ''
      });
    }

    submit(formData) {
      this.router.navigate(['show-profile']);
    }

    cancel() {
      this.router.navigate(['show-profile']);
    }
}