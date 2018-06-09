import { Http, Headers } from '@angular/http';

export class AppConst {
	public static localhost = 'http://localhost:8080';
}

export const tokenHeader = new Headers({
		'Content-Type' : 'application/json',
		'x-auth-token' : localStorage.getItem("xAuthToken")
	});
}
