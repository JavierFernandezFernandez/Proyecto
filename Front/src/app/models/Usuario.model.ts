export interface Usuario {
  nombre: string;
  email: string;
  telefono: string;
  password: string;
  rol: Rol | null;
  id?: number;
}

export interface Rol {
  id: number;
  rol?: string;
}
