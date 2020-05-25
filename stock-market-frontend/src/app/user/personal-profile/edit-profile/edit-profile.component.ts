import { Component} from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

import { user } from '../../../user';

@Component({
  selector: 'edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent {

    user = user;

    checkoutForm;

    constructor(
      private formBuilder: FormBuilder,
      private router : Router,
    ) { 
      this.checkoutForm = this.formBuilder.group({
        name: user.name,
        email: user.email,
        mobile: user.mobile
      });
    }

    submit(formData) {
      this.router.navigate(['show-profile']);
    }

    cancel() {
      this.router.navigate(['show-profile']);
    }

}