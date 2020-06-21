import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router} from '@angular/router'
import { UserService } from 'src/app/user.service';

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
        private userService: UserService
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

        this.userService.addUser(formData)
        .then(res => {
            alert("Sign up successfully! Please login.");
            console.log("Sign up successfully! Please login.")
            this.router.navigate(['login']);
        })
        .catch(error => {
            alert("Sign up failed!");
            console.error(error);
        })
    }

    cancel() {
        this.router.navigate(['login']);
    }
}