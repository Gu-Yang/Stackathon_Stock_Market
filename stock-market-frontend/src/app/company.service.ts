import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { base_url } from './constants';

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
            url = base_url + '/company/findAllCompany';
        } else if (role === 'normal') {
            url = base_url + '/company/findAllActiveCompany';
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
        let promise = this.http.post(base_url + '/company/findCompanyByCode', companyCodeBody, { headers: headers }).toPromise();

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

        let promise = this.http.post(base_url + '/company/editCompany', JSON.stringify(companyRequestBody), { headers: headers }).toPromise();
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

        let promise = this.http.post(base_url + '/company/addCompany', JSON.stringify(companyRequestBody), { headers: headers }).toPromise();
        return promise;
    }

    searchCompany(searchText) {

        let authorization = "Bearer " + localStorage.getItem('token');
        let role = localStorage.getItem("role");
        let url;
        if (role === 'admin') {
            url = base_url + '/company/searchCompany';
        } else if (role === 'normal') {
            url = base_url + '/company/searchActiveCompany';
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
        let url = base_url + '/company/setCompanyActiveStatus';
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

    getStockPricesByCode(companyCode) {
        let url = base_url + '/company/getStockPrices';
        let authorization = "Bearer " + localStorage.getItem('token');
        let headers = {
            "Authorization": authorization,
            "Content-Type": "application/json"
        }
        let companyCodeRequestBody = {
            "companyCode": companyCode,
        }
        let promise = this.http.post(url, companyCodeRequestBody, { headers: headers }).toPromise();
        return promise;
    }

}