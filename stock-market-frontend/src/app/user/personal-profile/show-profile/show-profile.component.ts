import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { user } from '../../../user'
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'show-profile',
  templateUrl: './show-profile.component.html',
  styleUrls: ['./show-profile.component.css']
})
export class ShowProfileComponent implements OnInit {

    user;

    constructor(
      private router: Router,
      private http: HttpClient,
      private userService: UserService,
    ) { }

    ngOnInit() {

      this.userService.getUserPromise()
      .then(res => {
        this.user = res;
        console.log('Show user information for user: ' + this.user.username)
      })
      .catch(error =>{
        console.error(error);
      });
    }

    changePassword() {
      this.router.navigate(['change-password']);
    }

    editProfile() {
      this.router.navigate(['edit-profile']);
    }

}