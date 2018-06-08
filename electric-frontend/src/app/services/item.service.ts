import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { AppConst } from '../web-api/app-consts';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: Http) { }

  retrieveItems() {
    const url = `${AppConst.localhost}/items/all`;

    return this
      .http
      .get(url, { withCredentials: true })
  }

  retrieveSpecificItem(id: number) {
    const url = `${AppConst.localhost}/${id}`

    return this
      .http
      .get(url, { withCredentials: true })
  }

  reportMalfunction(id: number) {
    const url = `${AppConst.localhost}/${id}/report`

    return this
      .http
      .get(url, { withCredentials: true })
  }

  addComment(id: number, comment: Comment) {
    const url = `${AppConst.localhost}/${id}/comment/add`

    return this
      .http
      .post(url, comment, { withCredentials: true })
  }
}
