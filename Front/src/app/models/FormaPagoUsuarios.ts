import { FormaPago } from "./FormaPago.model";
import { Usuario } from "./Usuario.model";

export interface FormaPagoUsuario {
  id: number;
  datos: string;
  usuario: Usuario;
  formaPago: FormaPago;
}
