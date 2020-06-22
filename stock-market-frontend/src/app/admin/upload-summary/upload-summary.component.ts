import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router'

import { companies } from '../../companies';

@Component({
    selector: 'upload-summary',
    templateUrl: 'upload-summary.component.html',
    styleUrls: ['upload-summary.component.css']
})

export class UploadSummaryComponent implements OnInit {

    date = new Date();
    uploadStatus;
    uploadRecords;

    constructor(
        private router: Router,
        private activatedRoute: ActivatedRoute,
    ) { 
        this.uploadStatus = this.activatedRoute.snapshot.queryParams['uploadStatus'];
        this.uploadRecords = this.activatedRoute.snapshot.queryParams['uploadRecords'];
    }

    ngOnInit() { }

    close() {
        this.router.navigate(['upload-file']);
    }
}