import { ApiService } from './../service/Api.Service';
import { Credentials } from './../model/Models';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  cred: Credentials = {
    email: '',
    password: ''
  };


  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit(): void {
  }

  login(form: NgForm){
    console.log('form -> ',form.value);
    this.apiService.login(this.cred).subscribe(response => {
      this.router.navigate(['/main']);
    });
  }



}
