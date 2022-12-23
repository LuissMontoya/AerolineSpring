import { AuthInterceptor } from './helpers/auth.interceptor';
import { RouterModule, Routes } from '@angular/router';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HotelComponent } from './hotel/hotel.component';
import { ReactiveFormsModule } from '@angular/forms';

import { DataTablesModule} from 'angular-datatables';

import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { EditHotelComponent } from './hotel/edit-hotel/edit-hotel.component';
import { LoginComponent } from './login/login.component';

import {FormsModule} from '@angular/forms';
import { MainComponent } from './main/main.component';
/*
const routes: Routes = [
  { path: 'hotel', component: HotelComponent },
  { path: 'hotel/:id', component: EditHotelComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: '' },
];*/



@NgModule({
  declarations: [
    AppComponent,
    HotelComponent,
    HeaderComponent,
    FooterComponent,
    EditHotelComponent,
    LoginComponent,
    MainComponent,
  ],
  imports: [
    BrowserModule,
    //RouterModule.forRoot(routes),
    AppRoutingModule,
    DataTablesModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
