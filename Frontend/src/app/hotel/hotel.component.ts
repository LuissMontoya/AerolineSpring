import { HotelService } from './hotel.service';
import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { Hotel } from '../model/HotelModel';
import * as $ from 'jquery';
declare var window: any;

import { DataTableDirective } from 'angular-datatables';

import { NgForm, Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css'],
})
export class HotelComponent implements AfterViewInit, OnInit {
  hoteles!: Hotel[];
  selectedHotel!: Hotel;
  seleccionados: string[] = [];

  items:any;
  formHotel!: any;
  formHotel1!: any;

  formModal: any;

  /*@ViewChild(DataTableDirective, {static: false})
  dtElement!: DataTableDirective;
*/
  /*dtOptions: DataTables.Settings ={};
  //dtTrigger = new Subject();
  dtTrigger: Subject<any> = new Subject();
 */

  @Input() data: any;

  constructor(
    private hotelService: HotelService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    /*this.dtOptions = {
      ajax: 'data/data.json',
      columns: [{
        title: 'ID',
        data: 'id'
      }, {
        title: 'First name',
        data: 'firstName'
      }, {
        title: 'Last name',
        data: 'lastName'
      }]
    };*/

    // const table: any = $('example');
   // this.dtElement = table.DataTable();

    //console.log(this.hotel);
    this.getHotel();

    this.formHotel1 = this.formBuilder.group({
      nombre: ['', [Validators.required, Validators.minLength(2)]],
      nit: ['',[Validators.required,Validators.minLength(8)]],
      direccion:['', [Validators.required,Validators.minLength(3)]],
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

    this.formModal = new window.bootstrap.Modal(
      document.getElementById('myModal')
    );
  }

  ngAfterViewInit(): void {
    //this.dtTrigger.next(null);
  }


  private getHotel() {
    this.hotelService.finAllHotel().subscribe(
      /*(data) => {this.hotel = data,
        console.log(this.hotel[1])},*/
      (response) => {this.hoteles = response;
       // this.dtTrigger.next(null);

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
    if(form.valid){
      this.hotelService.addHotel(form.value).subscribe(
        (response:Hotel)=>{
          console.log(response);
          window.location.reload();
        },
        );
    }


  }

  eliminarHotel(codigo:number){
    //alert(codigo);
    let op = confirm("Realmente desea eliminar el registro?");
    if(op){
     this.hotelService.deleteHotel(codigo).subscribe(
      (resp)=>{
        if(resp == true){
          alert('Registro Eliminado!');
          window.location.reload();
        }
      }
     );
    }else{
      alert('Registro No Eliminado!');
    }
  }

  actualizarHotel(codigo:number){

  }

  openFormModal(codigo: number) {
    this.formModal.show();
  }
  saveSomeThing() {
    // confirm or save something
    this.formModal.hide();
  }

}
