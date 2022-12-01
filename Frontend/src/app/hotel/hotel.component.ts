import { HotelService } from './hotel.service';
import { Component, Input, OnInit } from '@angular/core';
import { Hotel } from '../model/HotelModel';
import * as $ from 'jquery';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css'],
})
export class HotelComponent implements OnInit {

  hoteles!: Hotel[];
  selectedHotel!: Hotel;
  seleccionados:string[]=[];

  @Input() data:any;

  constructor(private hotelService: HotelService) {}

  ngOnInit(): void {
    //console.log(this.hotel);
    this.getHotel();
    $('button').click(function() {
      //alert('hola Jquey!!');
      var hotelVal = $('#hotel').val();
      var hotelName = $('select[name="hotel"] option:selected').text();

      alert(hotelVal + hotelName);
      $('#id').val(hotelVal!);
  });

  $("#hotel").blur(function() {
    alert('hola Hotel!!');
});

  }

  private getHotel(){
    this.hotelService.finAllHotel().subscribe(
      /*(data) => {this.hotel = data,
        console.log(this.hotel[1])},*/
      (response) =>{
        this.hoteles = response,
      console.log(response);
    }

    );
  }


  onSelect(hotel: Hotel): void {
    this.selectedHotel = hotel;
  }

  click ():void {
    alert('click');
  }

  blur (event:any) {
    alert(event.target.value);
  }

  hotelChange(value: any) {
    if (value) {
      alert(value);
    }
 }

}
