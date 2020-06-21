import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class CompanyService {

    companies;

    constructor(
        private http: HttpClient,
    ) { }

    getCompanyList() {
        let authorization = "Bearer " + localStorage.getItem('token');
        let role = localStorage.getItem("role");
        let url;
        if (role === 'admin') {
            url = 'http://localhost:9001/company/findAllCompany';
        } else if (role === 'normal') {
            url = 'http://localhost:9001/company/findAllActiveCompany';
        }
        let headers = {
            "Authorization": authorization,
            "Content-Type": "application/json"
        }

        let promise = this.http.get(url, { headers: headers }).toPromise();
        return promise;
    }

    getCompanyByCode(companyCode) {
        let authorization = "Bearer " + localStorage.getItem('token');
        let headers = {
            "Authorization": authorization,
            "Content-Type": "application/json"
        }
        let companyCodeBody = {
            'companyCode': companyCode
        }
        let promise = this.http.post('http://localhost:9001/company/findCompanyByCode', companyCodeBody, { headers: headers }).toPromise();

        return promise;
    }

    editCompany(company, formData) {

        let authorization = "Bearer " + localStorage.getItem('token');
        let companyRequestBody = {
            "companyCode": company.companyCode,
            "companyName": formData.companyName,
            "ceoName": formData.ceoName,
            "boardMember": formData.boardMember,
            "description": formData.description
        }
        let headers = {
            "Content-Type": "application/json",
            "Authorization": authorization
        }

        let promise = this.http.post('http://localhost:9001/company/editCompany', JSON.stringify(companyRequestBody), { headers: headers }).toPromise();
        return promise;
    }

    addCompany(formData) {
        let authorization = "Bearer " + localStorage.getItem('token');
        let companyRequestBody = {
            "companyName": formData.companyName,
            "ceoName": formData.ceoName,
            "boardMember": formData.boardMember,
            "description": formData.description
        }
        let headers = {
            "Content-Type": "application/json",
            "Authorization": authorization
        }

        let promise = this.http.post('http://localhost:9001/company/addCompany', JSON.stringify(companyRequestBody), { headers: headers }).toPromise();
        return promise;
    }

    searchCompany(searchText) {

        let authorization = "Bearer " + localStorage.getItem('token');
        let role = localStorage.getItem("role");
        let url;
        if (role === 'admin') {
            url = 'http://localhost:9001/company/searchCompany';
        } else if (role === 'normal') {
            url = 'http://localhost:9001/company/searchActiveCompany';
        }
        let headers = {
            "Authorization": authorization,
            "Content-Type": "application/json"
        }
        let searchBody = {
            "searchText": searchText
        }

        let promise = this.http.post(url, searchBody, { headers: headers }).toPromise();
        return promise;
    }

    setCompanyActivateStatus(companyCode, isActive) {
        let url = 'http://localhost:9001/company/setCompanyActiveStatus';
        let authorization = "Bearer " + localStorage.getItem('token');
        let headers = {
            "Authorization": authorization,
            "Content-Type": "application/json"
        }
        let companyRequestBody = {
            "companyCode": companyCode,
            "active": isActive
        }
        let promise = this.http.post(url, companyRequestBody, { headers: headers }).toPromise();
        return promise;
    }


    // getUserPromise(){
    //     let authorization = "Bearer " + localStorage.getItem('token');

    //     let userNameRequestBody = {
    //       "username": localStorage.getItem("username")
    //     }
    //     let headers = {
    //       "Content-Type": "application/json",
    //       "Authorization": authorization
    //   }

    //   let promise = this.http.post('http://localhost:9001/user/findUser', JSON.stringify(userNameRequestBody), {headers : headers}).toPromise();

    //   return promise;
    // }

    // editUser(user, formData) {

    //   let authorization = "Bearer " + localStorage.getItem('token');
    //   let userRequestBody = {
    //     "username": user.username,
    //     "name": formData.name,
    //     "email": formData.email,
    //     "mobile": formData.mobile
    //   }
    //   let headers = {
    //     "Content-Type": "application/json",
    //     "Authorization": authorization
    //   }

    //   let promise = this.http.post('http://localhost:9001/user/editUser', JSON.stringify(userRequestBody), {headers : headers}).toPromise();
    //   return promise;
    // }

    // changePassword(user, formData) {

    //   let authorization = "Bearer " + localStorage.getItem('token');
    //   let userRequestBody = {
    //     "username": user.username,
    //     "password": formData.newpassword
    //   }
    //   let headers = {
    //     "Content-Type": "application/json",
    //     "Authorization": authorization
    //   }

    //   let promise = this.http.post('http://localhost:9001/user/changePassword', JSON.stringify(userRequestBody), {headers : headers}).toPromise();
    //   return promise;
    // }
}