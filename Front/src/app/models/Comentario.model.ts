import { Producto } from "./Producto.model";
import { Usuario } from "./Usuario.model";

export interface Comentario {
  mensaje:    string;
  titulo:     string;
  puntuacion: number;
  producto:   Producto;
  usuario:    Usuario;
  id:         number;
}
