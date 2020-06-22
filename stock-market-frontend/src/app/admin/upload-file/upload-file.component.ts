import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router} from '@angular/router'
import { UploadService } from 'src/app/upload.service';

@Component({
    selector: 'upload-file',
    templateUrl: 'upload-file.component.html',
    styleUrls: ['upload-file.component.css']
})

export class UploadFileComponent implements OnInit {

    file: File;

    checkoutForm;

    constructor(
        private router: Router,
        private formBuilder: FormBuilder,
        private uploadService: UploadService,
    ) { 
        this.checkoutForm = this.formBuilder.group({
            file: '',
        })
    }

    ngOnInit() { }

    submit(formData) {
        this.uploadService.uploadExcelFile(this.file)
        .then(res => {
            console.log(res);
            // alert('upload successfully!');
            this.router.navigate(['upload-summary'], {queryParams: {uploadRecords: res, uploadStatus: 'Successfully'}});
        })
        .catch(error => {
            console.error(error);
            // alert('upload failed!');
            this.router.navigate(['upload-summary'], {queryParams: {uploadRecords: 0, uploadStatus: 'Failed'}});
        })
        
    }

    onFileSelect(event) {
        this.file = event.target.files[0];
        console.log(this.file);
    }

    downloadExcelTemplate() {
        this.uploadService.downloadExcelTemplate()
        .then(res => {

            let blob = new Blob([res], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'});            

            const objUrl = window.URL.createObjectURL(blob);
            console.log('Download excel template.' + blob);
            window.open(objUrl);
        })
        .catch(error => {
            console.error(error);
        })
    }

    close() {
        window.alert("Close!");
    }

}