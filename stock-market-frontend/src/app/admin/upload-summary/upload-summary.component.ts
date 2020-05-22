import { Component, OnInit } from '@angular/core';

import { companies } from '../../companies';

@Component({
    selector: 'upload-summary',
    templateUrl: 'upload-summary.component.html',
    styleUrls: ['upload-summary.component.css']
})

export class UploadSummaryComponent implements OnInit {

    company = companies[1];
    date = new Date();

    constructor() { }

    ngOnInit() { }
}