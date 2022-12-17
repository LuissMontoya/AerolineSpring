import { Hotel } from './../model/HotelModel';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private url: String = "http://localhost:5000/api/hotel";

  constructor(private httpClient: HttpClient) { }

  //metodos
  finAllHotel(): Observable<Hotel[]>{
    return this.httpClient.get<Hotel[]>(`${this.url}`);
  }

  findHotel(id:number): Observable<Hotel>{
    return this.httpClient.get<Hotel>(`${this.url}/${id}`);
  }

  addHotel(hotel: Hotel): Observable<Hotel>{
    return this.httpClient.post<Hotel>(`${this.url}/add`,hotel);
  }

  updateHotel(hotel: Hotel): Observable<Hotel>{
    return this.httpClient.put<Hotel>(`${this.url}/update`,hotel);
  }

  deleteHotel(id: number): Observable<boolean>{
    return this.httpClient.delete<boolean>(`${this.url}/delete/${id}`);
  }


}
