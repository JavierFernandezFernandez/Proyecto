import { Direccion } from "./Direccion.model";
import { Usuario } from "./Usuario.model";

export interface Factura {
  id: number;
  observaciones: string;
  fecha: string;
  usuario: Usuario;
  direccion: Direccion;
}
