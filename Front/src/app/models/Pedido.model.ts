import { Direccion } from "./Direccion.model";
import { FormaPago } from "./FormaPago.model";
import { Usuario } from "./Usuario.model";

export interface Pedido {
  id: number;
  fecha: string;
  fechaEntrega: string;
  usuario: Usuario;
  direccion: Direccion;
  formaPago: FormaPago;
}
