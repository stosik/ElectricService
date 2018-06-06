import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NoopAnimationsModule, BrowserAnimationsModule } from '@angular/platform-browser/animations'
import 'hammerjs';

import {
  MatButtonModule,
  MatToolbarModule,
  MatGridListModule,
  MatInputModule,
  MatOptionModule,
  MatSelectModule,
  MatSlideToggleModule,
  MatCheckboxModule,
  MatTableModule
} from "@angular/material";

import { MatIconModule } from '@angular/material/icon';
import { routing } from './app.routing';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';

const MAT_MODULES  = [
  MatButtonModule,
  MatToolbarModule,
  MatGridListModule,
  MatInputModule,
  MatOptionModule,
  MatSelectModule,
  MatCheckboxModule,  
  MatSlideToggleModule,
  MatIconModule,
  MatTableModule
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent
  ],
  imports: [
    MAT_MODULES,
    BrowserModule,
    FormsModule,
    HttpModule,
    NoopAnimationsModule,
    BrowserAnimationsModule,
    routing,
  ],
  providers: [
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
