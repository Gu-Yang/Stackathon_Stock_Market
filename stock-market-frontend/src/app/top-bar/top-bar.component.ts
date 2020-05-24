import { Component, OnInit } from '@angular/core';

import { RoleService } from '../role.service';

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit {

  role = this.roleService.getRole();

  constructor(
    private roleService : RoleService
  ) { }

  ngOnInit() {
  }


}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/