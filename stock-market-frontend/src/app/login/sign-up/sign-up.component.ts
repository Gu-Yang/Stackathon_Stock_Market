import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router} from '@angular/router'

@Component({
    selector: 'sign-up',
    templateUrl: 'sign-up.component.html',
    styleUrls: ['sign-up.component.css']
})

export class SignUpComponent implements OnInit {

    checkoutForm;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
    ) { 
        this.checkoutForm = this.formBuilder.group({
            username: '',
            password: '',
            name:'',
            email:'',
            mobile:'',
        })
    }

    ngOnInit() { }

    submit(formData) {
        window.alert("Username: " + formData.username + "\nPassword: " + formData.password + "\nName: " + formData.name + "\nEmail: " + formData.email + "\nMobile: " + formData.mobile + "\nSign up successfully!");
        this.router.navigate(['login']);
    }

    cancel() {
        this.router.navigate(['login']);
    }
}