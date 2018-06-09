import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { AppConst } from '../web-api/app-consts';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: Http) { }

  retrieveItems() {
    const url = `${AppConst.localhost}/items/all`
  	const tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
    });

    return this.http.get(url, { headers: tokenHeader })
  }

  retrieveSpecificItem(id: number) {
    const url = `${AppConst.localhost}/items/${id}/details`
  	const tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
    });

    return this.http.get(url, { headers: tokenHeader })
  }

  reportMalfunction(id: number) {
    const url = `${AppConst.localhost}/items/${id}/report`
  	const tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
    });

    return this.http.get(url, { headers: tokenHeader })
  }

  addComment(id: number, comment: Comment) {
    const url = `${AppConst.localhost}/items/${id}/comment/add`
  	const tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
    });
    
    return this.http.get(url, { headers: tokenHeader })
  }
}
