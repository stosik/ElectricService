import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs';
import { AppConst } from '../web-api/app-consts';

@Injectable()
export class LoginService {

  constructor (private http: Http) {}
  
    sendCredential(username: string, password: string) {
      const url = `${AppConst.localhost}/index`;
      const params = `username=${username}&password=${password}`;
      const headers = new Headers(
        {
          'Content-Type': 'application/x-www-form-urlencoded'
        });
  
      return this.http.post(url, params, {headers: headers, withCredentials : true});
    }
  
    logout() {
      const url = `${AppConst.localhost}/logout`;

      return this.http.get(url, { withCredentials: true });
     }
} 
