import { HotelService } from './hotel.service';
import { AfterViewInit, Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Hotel } from '../model/Models';
import * as $ from 'jquery';
  // import 'datatables.net';
//  import { DataTablesModule } from 'angular-datatables';

declare var window: any;

// import { DataTableDirective } from 'angular-datatables';

import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css'],
})
export class HotelComponent implements OnDestroy,AfterViewInit, OnInit {
  hoteles!: Hotel[];
  selectedHotel!: Hotel;

  formHotel!: FormGroup;
  formModal: any;

  //datatable
   dtOptions: DataTables.Settings = {};
   dtTrigger: Subject<any> = new Subject<any>();

  /*
  //dtTrigger = new Subject();
  dtTrigger: Subject<any> = new Subject();
 */

  @Input() data: any;

  constructor(
    private hotelService: HotelService,
  ) {}

  ngOnInit(): void {
    this.dtOptions = {
      responsive: true,
				"ordering": false,
				"info":     false,
			"lengthMenu":  [10, 25, 30,40,50],
				language: {
						"searchPlaceholder":    "Buscar",
						"decimal": "",
						"emptyTable": "No hay información",

						"info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
						"infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
						"infoFiltered": "(Filtrado de _MAX_ total entradas)",
						"infoPostFix": "",
						"thousands": ",",
						"lengthMenu": " _MENU_ ",
						"loadingRecords": "Cargando...",
						"processing": "Procesando...",
						"search": " ",
						"zeroRecords": "Sin resultados encontrados",

						"paginate": {
							"first": "Primero",
							"last": "Ultimo",
							"next": "Siguiente",
							"previous": "Anterior"
						}
				},
        //dom: 'Bfrtip',
    }

    this.getHotel();

    this.formHotel = new FormGroup({
      nombre: new FormControl('', [Validators.required, Validators.minLength(3)]),
      nit:  new FormControl ('',[Validators.required, Validators.minLength(8), Validators.pattern("^[0-9]+-{1}[0-9]{1}")]),
      direccion:new FormControl('', [Validators.required, Validators.minLength(4)]),
      telefono: new FormControl('',[Validators.required, Validators.minLength(8),Validators.pattern("[0-9]*")]),
      estado:new FormControl('',[Validators.required]),
      email:new FormControl('', [Validators.email]),
      celular:new FormControl('',[Validators.minLength(10), Validators.pattern("[0-9]{10}")])
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
     this.dtTrigger.next(false);
  }


  private getHotel() {
    this.hotelService.finAllHotel().subscribe(
      /*(data) => {this.hotel = data,
        console.log(this.hotel[1])},*/
      (response) => {this.hoteles = response;
       // this.dtTrigger.next(null);
       // initiate our data table
        this.dtTrigger.next(false);
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

  onSubmit(form: FormGroup) {
    // Process checkout data here
    console.log(this.formHotel.get("nit"));
     if(form.valid){
       this.hotelService.addHotel(form.value).subscribe(
         (response:Hotel)=>{
           console.log(response);
           if(response.codigo != null){
            alert('Registro Insertado Correctamente.');
            window.location.reload();
           }else{
            alert('No se pudo Insertar el registro.');
           }
         },
        );
    }
  }

  eliminarHotel(codigo:number){
    alert(codigo);
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

  buscarPorNombre(nombre: String){
    //alert("nombre -> "+nombre);
    if(nombre == null || nombre == ''){
      document.getElementById('name')?.focus();
    }else{
      this.hotelService.findHotelByName(nombre).subscribe(
        (response) =>{
          this.hoteles = response;
        }
      );
    }
  }


  openFormModal(codigo: number) {
    this.formModal.show();
  }

  saveSomeThing() {
    // confirm or save something
    this.formModal.hide();
  }

  //Validaciones
  get Nombre(): FormControl{
    return this.formHotel.get("nombre") as FormControl;
  }
  get Nit(): FormControl{
    return this.formHotel.get("nit") as FormControl;
  }
  get Direccion(): FormControl{
    return this.formHotel.get("direccion") as FormControl;
  }
  get Telefono(): FormControl{
    return this.formHotel.get("telefono") as FormControl;
  }
  get Estado(): FormControl{
    return this.formHotel.get("estado") as FormControl;
  }
  get Email(): FormControl{
    return this.formHotel.get("email") as FormControl;
  }
  get Celular(): FormControl{
    return this.formHotel.get("celular") as FormControl;
  }


  ngOnDestroy(): void {
      this.dtTrigger.unsubscribe();
  }


}
