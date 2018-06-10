import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { AppConst } from '../web-api/app-consts';
import { tokenHeader } from '../web-api/app-consts';

@Injectable()
export class ItemService {

  constructor(private http: Http) { }

  retrieveItems() {
    const url = `${AppConst.localhost}/items/all`;

    return this.http.get(url, { headers: tokenHeader });
  }

  retrieveSpecificItem(id: number) {
    const url = `${AppConst.localhost}/items/${id}/details`;

    return this.http.get(url, { headers: tokenHeader });
  }

  reportMalfunction(id: number) {
    const url = `${AppConst.localhost}/items/${id}/report`;

    return this.http.get(url, { headers: tokenHeader });
  }

  postComment(id: number, comment: Comment) {
    const url = `${AppConst.localhost}/items/${id}/comment/add`;

    return this.http.put(url, comment, { headers: tokenHeader });
  }
}
