import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router'

import { companies } from '../../companies';

@Component({
    selector: 'upload-summary',
    templateUrl: 'upload-summary.component.html',
    styleUrls: ['upload-summary.component.css']
})

export class UploadSummaryComponent implements OnInit {

    company = companies[1];
    date = new Date();

    constructor(
        private router: Router,
    ) { }

    ngOnInit() { }

    close() {
        this.router.navigate(['upload-file']);
    }
}