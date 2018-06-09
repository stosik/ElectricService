import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs';
import { AppConst } from '../web-api/app-consts';

@Injectable()
export class LoginService {

  constructor(private http:Http) { }

  sendCredential(username: string, password: string) {
  	const url = `${AppConst.localhost}/token`;
  	const encodedCredentials = btoa(username+":"+password);
  	const basicHeader = "Basic "+encodedCredentials;
  	const headers = new Headers({
  		'Content-Type' : 'application/x-www-form-urlencoded',
  		'Authorization' : basicHeader
  	});

  	return this.http.get(url, {headers: headers});
  }

  checkSession() {
  	const url = `${AppConst.localhost}/checkSession`;
  	const headers = new Headers({
  		'x-auth-token' : localStorage.getItem('xAuthToken')
  	});

  	return this.http.get(url, {headers: headers});
  }

  logout() {
  	const url = `${AppConst.localhost}/user/logout`;
  	const headers = new Headers({
  		'x-auth-token' : localStorage.getItem('xAuthToken')
  	});

  	return this.http.post(url, '', {headers: headers});
  }
} 
