import { Component, OnInit } from '@angular/core';
import { LoginService } from './../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  
  loggedIn: boolean;
  
    constructor(private loginService: LoginService, private router : Router) {
      if(localStorage.getItem('ServiceUserLoggedIn') == '') {
        this.loggedIn = false;
      } else {
        this.loggedIn = true;
      }
    }
  
    logout(){
      this.loginService.logout().subscribe(
        res => {
          localStorage.setItem('ServiceUserLoggedIn', '');
        },
        err => console.log(err)
        );
      location.reload();
      this.router.navigate(['/login']);
    }
  
    ngOnInit() {
    }
  }