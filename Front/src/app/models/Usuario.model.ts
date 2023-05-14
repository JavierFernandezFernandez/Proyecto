export interface Usuario {
  nombre:     string;
  email:      string;
  telefono:   string;
  contraseña: string;
  rol:        Rol;
  id?:         number;
}

export interface Rol {
  id:  number;
  rol?: string;
}
