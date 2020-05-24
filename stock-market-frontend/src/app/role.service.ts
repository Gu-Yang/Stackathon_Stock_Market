import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class RoleService {

    role;

    constructor() { }

    setRole(role) {
        this.role = role;
    }

    getRole() {
        return this.role;
    }

}