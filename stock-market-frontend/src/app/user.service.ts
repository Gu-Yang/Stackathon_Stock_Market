import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { base_url } from './constants';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    user;

    constructor(
        private http : HttpClient,
    ) { }

    getUserPromise(){
        let authorization = "Bearer " + localStorage.getItem('token');

        let userNameRequestBody = {
          "username": localStorage.getItem("username")
        }
        let headers = {
          "Content-Type": "application/json",
          "Authorization": authorization
      }

      let promise = this.http.post(base_url + '/user/findUser', JSON.stringify(userNameRequestBody), {headers : headers}).toPromise();
  
      return promise;
    }

    addUser(formData) {
      let userRequestBody = {
        "username": formData.username,
        "password": formData.password,
        "name": formData.name,
        "email": formData.email,
        "mobile": formData.mobile
      }

      let headers = {
        "Content-Type": "application/json"
      }

      let promise = this.http.post(base_url + '/user/signup', JSON.stringify(userRequestBody), {headers : headers}).toPromise();
      return promise;
    }

    editUser(user, formData) {

      let authorization = "Bearer " + localStorage.getItem('token');
      let userRequestBody = {
        "username": user.username,
        "name": formData.name,
        "email": formData.email,
        "mobile": formData.mobile
      }
      let headers = {
        "Content-Type": "application/json",
        "Authorization": authorization
      }

      let promise = this.http.post(base_url + '/user/editUser', JSON.stringify(userRequestBody), {headers : headers}).toPromise();
      return promise;
    }

    changePassword(user, formData) {

      let authorization = "Bearer " + localStorage.getItem('token');
      let userRequestBody = {
        "username": user.username,
        "password": formData.newpassword
      }
      let headers = {
        "Content-Type": "application/json",
        "Authorization": authorization
      }

      let promise = this.http.post(base_url + '/user/changePassword', JSON.stringify(userRequestBody), {headers : headers}).toPromise();
      return promise;
    }
}