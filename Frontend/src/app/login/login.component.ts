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

  mostrarPwd(pwd:String){
    let tipo:any = document.getElementById('password');
    let icon:any = document.getElementById('iconPwd');
    if(tipo.type == 'password'){
      tipo.type = 'text';
      icon.classList.remove("fa-eye");
      icon.classList.add("fa-eye-slash");
    }else{
      tipo.type = 'password';
      icon.classList.remove("fa-eye-slash");
      icon.classList.add("fa-eye");
    }
  }

}
