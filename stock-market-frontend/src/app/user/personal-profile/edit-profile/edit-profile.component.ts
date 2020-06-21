import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { UserService } from 'src/app/user.service';
import { error } from 'protractor';


@Component({
  selector: 'edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  user;

  checkoutForm;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private http: HttpClient,
    private userService: UserService,
  ) {

    this.checkoutForm = this.formBuilder.group({
      name: '',
      email: '',
      mobile: ''
    });

  }

  ngOnInit() {
    this.userService.getUserPromise().then(res => {
      this.user = res;
      console.log('Edit user information for user: ' + this.user.username);
      this.checkoutForm = this.formBuilder.group({
        name: this.user.name,
        email: this.user.email,
        mobile: this.user.mobile
      });
    })
      .catch(error => {
        console.error(error);
      });
  }

  submit(formData) {

    this.userService.editUser(this.user, formData).then(res => {
      console.log('Edit user ' + this.user.username + ' successfully!');
      
    })
    .catch(error => {
      console.error(error);
    })
    .finally(() => {
      this.router.navigate(['show-profile']);
    })

  }

  cancel() {
    this.router.navigate(['show-profile']);
  }


}