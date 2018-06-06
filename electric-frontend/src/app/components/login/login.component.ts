import { Component, OnInit } from '@angular/core';
import { LoginService } from './../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loggedIn: boolean;
  username: string;
  password: string;

	constructor (private loginService: LoginService) {
    if(localStorage.getItem('PortalUserLoggedIn') == '' || localStorage.getItem('PortalUserLoggedIn') == null) {
      this.loggedIn = false;
    } else {
      this.loggedIn = true;
    }
  }
  
  onSubmit() {
  	this.loginService.sendCredential(this.username, this.password).subscribe(
      res => {
        this.loggedIn = true;
        localStorage.setItem('PortalUserLoggedIn', 'true');
        location.reload();
      },
      err => console.log(err)
    );
  }

  ngOnInit() {}
}