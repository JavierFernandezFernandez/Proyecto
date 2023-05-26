export class Producto {
  nombre?: string;
  precio?: number;
  iva?: number;
  descripcion?: string;
  marca?: Marca;
  categoria?: Categoria;
  id?: number;
  constructor() {
    this.id = -1,
      this.nombre = '',
      this.precio = -1,
      this.iva = -1,
      this.descripcion = '',
      this.categoria = {
        id: -1,
        nombre: '',
        descripcion: '',
      },
      this.marca = {
        id: -1,
        nombre: '',
        descripcion: '',
      }
  }
}

export interface Categoria {
  id?: number;
  nombre?: string;
  descripcion?: string;
}

export interface Marca {
  id?: number;
  nombre?: string;
  descripcion?: string;
}
