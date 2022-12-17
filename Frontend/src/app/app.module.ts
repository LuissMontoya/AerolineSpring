import { RouterModule, Routes } from '@angular/router';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HotelComponent } from './hotel/hotel.component';
import { ReactiveFormsModule } from '@angular/forms';

import { DataTablesModule} from 'angular-datatables';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { EditHotelComponent } from './hotel/edit-hotel/edit-hotel.component';


const routes: Routes = [
  { path: 'hotel', component: HotelComponent },
  { path: 'hotel/:id', component: EditHotelComponent },
  { path: '**', redirectTo: '' },
];



@NgModule({
  declarations: [
    AppComponent,
    HotelComponent,
    HeaderComponent,
    FooterComponent,
    EditHotelComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    AppRoutingModule,
    DataTablesModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
