import { Component } from '@angular/core';

import { RoleService } from './role.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{

  title = 'stock-market-frontend';
  role;

  constructor(
    private roleService: RoleService,
) { }

  onNotify() {
    window.alert("Notified");
    this.role = this.roleService.getRole();
  }


}
