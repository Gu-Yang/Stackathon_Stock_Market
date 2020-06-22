import { Component, OnInit} from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/user.service';


@Component({
  selector: 'change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit{

    checkoutForm;
    user;

    constructor(
      private formBuilder: FormBuilder,
      private router : Router,
      private userService : UserService
    ) { 
      this.checkoutForm = this.formBuilder.group({
        oldpassword: '',
        newpassword: '',
        repeatpassword: ''
      });
    }

  ngOnInit() {
    this.userService.getUserPromise().then(res => {
      this.user = res;
      console.log('Change password for user: ' + this.user.username);
    })
      .catch(error => {
        console.error(error);
      });
  }

    submit(formData) {

      let oldpassword = formData.oldpassword;
      let newpassword = formData.newpassword;
      let repeatpassword = formData.repeatpassword;

      if (oldpassword != this.user.password) {

        console.log('Old password incorrect!');
        alert('Old password incorrect!');
        this.router.navigate(['change-password']);
      } else if (newpassword === null || newpassword === '') {

        console.log('illegal new password!');
        alert('illegal new password!');
        this.router.navigate(['change-password']);
      } else if (newpassword != repeatpassword) {

        console.log('Two new password are different!')
        alert('Two new password are different!');
        this.router.navigate(['change-password']);
      } else {

        this.userService.changePassword(this.user, formData)
        .then(res => {
          console.log("Password changed successfully!");
          alert("Password changed successfully!");
          localStorage.removeItem('role');
          localStorage.removeItem('username');
          localStorage.removeItem('token');
          this.router.navigate(['login']);
        })
        .catch(error => {
          console.error(error);
        })
      }

    }

    cancel() {
      this.router.navigate(['show-profile']);
    }
}