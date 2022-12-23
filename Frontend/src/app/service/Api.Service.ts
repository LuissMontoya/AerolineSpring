import { Credentials } from '../model/Models';
import { map } from 'rxjs';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private url: String = "http://localhost:5000";
  constructor(private http: HttpClient) { }

  login(cred:Credentials){
    return this.http.post(`${this.url}/login`, cred, {
      observe: 'response'
    }).pipe(map((response: HttpResponse<any>) =>{
      const body = response.body;
      const headers = response.headers;

      const bearerToken = headers.get('Authorization');
      const token = bearerToken!.replace('Bearer ', '');

      localStorage.setItem('token', token);

      return body;
    }))
  }

  getToken(){
    return localStorage.getItem('token');
  }


}

