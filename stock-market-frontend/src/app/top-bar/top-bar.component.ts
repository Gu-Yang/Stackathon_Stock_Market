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
    private roleService : RoleService,
    private router : Router,
  ) { }

  ngOnInit() {
    this.role = this.roleService.getRole()
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