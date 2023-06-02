import { Usuario } from "./Usuario.model";

export interface Direccion {
  nombre: string; // Alvaro
  ciudad:    string;
  direccion: string;
  usuario:   Usuario;
  id:        number;
}
