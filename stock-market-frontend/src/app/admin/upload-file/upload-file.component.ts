import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router} from '@angular/router'

@Component({
    selector: 'upload-file',
    templateUrl: 'upload-file.component.html',
    styleUrls: ['upload-file.component.css']
})

export class UploadFileComponent implements OnInit {

    checkoutForm;

    constructor(
        private router: Router,
        private formBuilder: FormBuilder,
    ) { 
        this.checkoutForm = this.formBuilder.group({
            file: '',
        })
    }

    ngOnInit() { }

    submit(formData) {
        window.alert("File upload successfully!!");
        this.router.navigate(['upload-summary']);
    }

    close() {
        window.alert("Close!");
    }

}