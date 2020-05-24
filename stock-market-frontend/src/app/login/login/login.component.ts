import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { Output, EventEmitter } from '@angular/core';

import { RoleService } from '../../role.service';

@Component({
    selector: 'login',
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.css']
})

export class LoginComponent implements OnInit {

    checkoutForm;

    @Output() notify = new EventEmitter();

    constructor(
        private router: Router,
        private formBuilder: FormBuilder,
        private roleService: RoleService,
    ) { 
        this.checkoutForm = this.formBuilder.group({
            username: '',
            password: '',
            isAdmin: false
        })
    }

    ngOnInit() { }

    submit(formData) {

     
        window.alert("login");
        window.alert(this.roleService.getRole());
        if(formData.isAdmin === true) {
            this.roleService.setRole("admin");
            this.notify.emit();
            // this.router.navigate()
        } else {
            this.roleService.setRole("user");
            this.notify.emit();
        }
    }

    signUp() {
        this.router.navigate(['sign-up']);
    }
}