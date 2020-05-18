import { Component, OnInit } from '@angular/core';

import { user } from '../../../user'

@Component({
  selector: 'show-profile',
  templateUrl: './show-profile.component.html',
  styleUrls: ['./show-profile.component.css']
})
export class ShowProfileComponent implements OnInit {

    user = user;

    constructor() { }

    ngOnInit() {
        
    }

}