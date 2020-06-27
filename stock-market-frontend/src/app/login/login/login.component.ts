import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { JwtHelperService } from '@auth0/angular-jwt';
import { RoleService } from '../../role.service';
import { base_url } from 'src/app/constants';

@Component({
    selector: 'login',
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.css']
})

export class LoginComponent implements OnInit {

    checkoutForm;
    data;

    @Output() notify = new EventEmitter();

    constructor(
        private router: Router,
        private formBuilder: FormBuilder,
        private roleService: RoleService,
        private http: HttpClient,
        private jwtHelper: JwtHelperService,
    ) {

        this.checkoutForm = this.formBuilder.group({
            username: '',
            password: ''
        })
    }

    ngOnInit() { }

    submit(formData) {

        let username = formData.username;
        let password = formData.password;

        let authenticateBody = {
            "username": username,
            "password": password
        }

        let headers = {
            "Content-Type": "application/json"
        }

        this.http.post(base_url + '/login/authenticate', JSON.stringify(authenticateBody), { headers: headers })
            .toPromise()
            .then(res => {
                this.data = res;

                let token = this.data.token;
                localStorage.setItem('token', token);

                let claims = this.jwtHelper.decodeToken();
                let role = claims.role;
                let name = claims.username;

                localStorage.setItem("username", name);
                localStorage.setItem("role", role);

                console.log('User ' + name + ' login, Role: ' + role);

                if (role === "admin") {
                    this.roleService.setRole("admin");
                    this.router.navigate(['company-list']);
                } else {
                    this.roleService.setRole("user");
                    this.router.navigate(['company-list']);
                }
            })
            .catch(this.handleError);

    }

    signUp() {
        this.router.navigate(['sign-up']);
    }

    private handleError(error) {
        if (error.status === 403) {
            alert("incorrect username or password.");
        } else {
            alert("login failure");
        }
        this.router.navigate(['login'])
    }
}