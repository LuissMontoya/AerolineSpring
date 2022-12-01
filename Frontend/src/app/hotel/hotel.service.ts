import { Hotel } from './../model/HotelModel';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private url: String = "http://localhost:5000/hotel/list/";

  constructor(private httpClient: HttpClient) { }

  //metodos
  finAllHotel(): Observable<Hotel[]>{
    return this.httpClient.get<Hotel[]>(`${this.url}`);
  }
}
