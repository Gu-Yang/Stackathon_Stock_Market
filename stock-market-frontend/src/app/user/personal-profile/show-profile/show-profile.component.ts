import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { user } from '../../../user'

@Component({
  selector: 'show-profile',
  templateUrl: './show-profile.component.html',
  styleUrls: ['./show-profile.component.css']
})
export class ShowProfileComponent implements OnInit {

    user = user;

    constructor(
      private router: Router,
    ) { }

    ngOnInit() {
        
    }

    changePassword() {
      this.router.navigate(['change-password']);
    }

    editProfile() {
      this.router.navigate(['edit-profile']);
    }

}