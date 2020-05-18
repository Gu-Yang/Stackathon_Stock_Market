import { Component} from '@angular/core';
import { FormBuilder } from '@angular/forms';

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
    ) { 
      this.checkoutForm = this.formBuilder.group({
        name: user.name,
        email: user.email,
        mobile: user.mobile
      });
    }

    submit(formData) {
      window.alert("name: " + formData.name + "\nemail: " + formData.email + "\nmobile: " + formData.mobile + "\n Edit profile successfully!");

    }

}