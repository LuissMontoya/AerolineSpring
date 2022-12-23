import { AuthGuard } from './helpers/auth.guard';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditHotelComponent } from './hotel/edit-hotel/edit-hotel.component';
import { HotelComponent } from './hotel/hotel.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: 'hotel', component: HotelComponent,
    canActivate: [AuthGuard]
  },
  { path: 'hotel/:id', component: EditHotelComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
