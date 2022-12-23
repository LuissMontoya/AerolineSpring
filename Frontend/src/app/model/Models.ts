export interface Hotel{
  codigo: number;
  nombre: String;
  nit: String;
  direccion: String;
  telefono: number;
  estado: String;
  email?:String;
  celular?:number;
 }


 export interface Credentials {
  email: String;
  password: String;
 }
