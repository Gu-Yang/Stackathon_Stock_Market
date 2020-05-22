import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit {

  isUser = true;
  isAdmin = true;

  constructor() { }

  ngOnInit() {
  }

  setIsUser(isUser) {
    this.isUser = isUser;
  }

  setIsAdmin(isAdmin) {
    this.isAdmin = isAdmin;
  }

}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/