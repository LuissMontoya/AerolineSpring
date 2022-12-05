import { HotelService } from './hotel.service';
import { Component, Input, OnInit } from '@angular/core';
import { Hotel } from '../model/HotelModel';
import * as $ from 'jquery';
import { FormGroup, NgForm, Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css'],
})
export class HotelComponent implements OnInit {
  hoteles!: Hotel[];
  selectedHotel!: Hotel;
  seleccionados: string[] = [];

  items:any;
  formHotel!: any;
  formHotel1!: any;

  @Input() data: any;

  constructor(
    private hotelService: HotelService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    //console.log(this.hotel);
    this.getHotel();
    this.formHotel = this.formBuilder.group({
      id: '',
    });

    this.formHotel1 = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      nit: ['',[Validators.required,Validators.minLength(5)]],
      direccion:['', [Validators.required]],
      telefono:['',[Validators.required,Validators.minLength(8)]],
      estado:['',[Validators.required]],
      email:['', [Validators.email]],
      celular:''
    });

    $('button#button').click(function () {
      //alert('hola Jquey!!');
      var hotelVal = $('#hotel').val();
      var hotelName = $('select[name="hotel"] option:selected').text();

      alert(hotelVal + hotelName);
      $('#id').val(hotelVal!);
    });

    $('#hotel').blur(function () {
      //alert('hola Hotel!!');
    });
  }

  private getHotel() {
    this.hotelService.finAllHotel().subscribe(
      /*(data) => {this.hotel = data,
        console.log(this.hotel[1])},*/
      (response) => {
        (this.hoteles = response)
        //console.log(response);
      }
    );
  }

  onSelect(hotel: Hotel): void {
    this.selectedHotel = hotel;
  }

  click(): void {
    alert('click');
  }

  blur(event: any) {
    alert(event.target.value);
  }

  onSubmit(form: NgForm) {
    // Process checkout data here
    console.log(form.value);

    this.hotelService.addHotel(form.value).subscribe(
      (response:Hotel)=>{
        console.log(response);
      },
      );
  }


}
