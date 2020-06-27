import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { base_url } from './constants';

@Injectable({
    providedIn: 'root'
})
export class UploadService {

    constructor(
        private http : HttpClient,
    ) { }

    downloadExcelTemplate() {
        let authorization = "Bearer " + localStorage.getItem('token');
        let headers = {
          "Authorization": authorization
        }

        let promise = this.http.get(base_url + '/company/downloadExcelTemplate', {responseType: 'blob', headers : headers}).toPromise();
        return promise;
    }

    uploadExcelFile(file) {
        let authorization = "Bearer " + localStorage.getItem('token');
        let headers = {
          "Authorization": authorization,
        //   "Content-Type": 'multipart/form-data'
        };
        let formData = new FormData();
        formData.append('file', file);

        let promise = this.http.post(base_url + '/company/uploadExcel', formData, {headers : headers}).toPromise();
        return promise;
    }

}