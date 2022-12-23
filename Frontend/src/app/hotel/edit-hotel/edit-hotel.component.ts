import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hotel } from 'src/app/model/Models';
import { HotelService } from '../hotel.service';
import * as $ from 'jquery';

@Component({
  selector: 'app-edit-hotel',
  templateUrl: './edit-hotel.component.html',
  styleUrls: ['./edit-hotel.component.css']
})
export class EditHotelComponent implements OnInit {

  constructor(private hotelService: HotelService, private activeRoute: ActivatedRoute) { }
  hotel!:Hotel;
  //formHotelEdit!: FormGroup;

   //formulario
   formHotelEdit = new FormGroup({
    codigo: new FormControl(''),
    nombre: new FormControl('', /*[Validators.required, Validators.minLength(3)] */),
    nit:  new FormControl ('', /* [Validators.required, Validators.minLength(8), Validators.pattern("^[0-9]+-{1}[0-9]{1}")]*/),
    direccion:new FormControl('', /*[Validators.required, Validators.minLength(4)]*/),
    telefono: new FormControl('',/* [Validators.required, Validators.minLength(8),Validators.pattern("[0-9]*")]*/),
    estado:new FormControl('', /*[Validators.required]*/),
    email:new FormControl('', /*[Validators.email]*/),
    celular: new FormControl('')
    //celular:new FormControl('',[Validators.minLength(10), Validators.pattern("[0-9]{10}")])
  });

  ngOnInit(): void {
    let id = this.activeRoute.snapshot.paramMap.get('id');
    //console.log( id);
    this.obtenerDatos(Number(id));
  }

  obtenerDatos(id:number){
    this.hotelService.findHotel(id).subscribe(
      (response) => {this.hotel = response;
      console.log(response);
      this.formHotelEdit.setValue({
        'codigo':id,
        'nombre': this.hotel.nombre,
        'nit': this.hotel.nit,
        'direccion': this.hotel.direccion,
        'telefono': this.hotel.telefono,
        'estado': this.hotel.estado,
        'email': this.hotel.email,
        'celular': this.hotel.celular,
      });
    }
    );
  }

  onSubmit(form: FormGroup) {
    // Process checkout data here
    //console.log(form);
    //console.log(this.formHotelEdit.value);
      if(form.valid){
        this.hotelService.updateHotel(form.value).subscribe(
          (response:Hotel)=>{
            console.log(response);
            if(response.codigo != null){
             alert('Registro Editado Correctamente.');
             window.location.href = '/hotel';
            }else{
             alert('No se pudo Editar el registro.');
            }
          },
         );
     }
  }

}

