import { Component} from '@angular/core';
import { FormBuilder } from '@angular/forms';



@Component({
  selector: 'change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent {

    checkoutForm;

    constructor(
      private formBuilder: FormBuilder,
    ) { 
      this.checkoutForm = this.formBuilder.group({
        oldpassword: '',
        newpassword: '',
        repeatpassword: ''
      });
    }

    submit(formData) {
      window.alert("Old Password: " + formData.oldpassword + "\nNew Password: " + formData.newpassword + "\nRepeat Password: " + formData.repeatpassword + "\n Change password successfully!");

    }

}