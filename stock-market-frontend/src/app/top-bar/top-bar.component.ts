import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { RoleService } from '../role.service';
import { error } from 'protractor';

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit {

  role;

  constructor(
    private router : Router,
  ) { }

  ngOnInit() {
    
  }

  openPersonalProfile() {
    this.role = localStorage.getItem('role');
    if (this.role == 'normal' || this.role == 'admin') {
      this.router.navigate(['/show-profile']);
    } else {
      alert("You don't have access to open this, please login with correct role!");
    }
  }

  openCompanyInfo() {
    this.role = localStorage.getItem('role');
    if (this.role == 'normal' || this.role == 'admin') {
      this.router.navigate(['/company-list']);
    } else {
      alert("You don't have access to open this, please login with correct role!");
    }
  }

  openImportData() {
    this.role = localStorage.getItem('role');
    if (this.role == 'admin') {
      this.router.navigate(['/upload-file']);
    } else {
      alert("You don't have access to open this, please login with correct role!");
    }
  }

  logout() {
    let confirmDialog = confirm('Are you sure you want to logout?');
    if (confirmDialog == true) {
      localStorage.removeItem('token');
      localStorage.removeItem('username');
      localStorage.removeItem('role');
      this.router.navigate(['login']);
    }

  }

}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/