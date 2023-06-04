import { Usuario } from "./Usuario.model";

export interface Direccion {
  nombre: string;
  ciudad:    string;
  direccion: string;
  cp: string;
  usuario:   Usuario;
  id:        number;
}
