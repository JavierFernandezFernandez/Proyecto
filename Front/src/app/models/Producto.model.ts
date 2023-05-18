export interface Producto {
  nombre:    string;
  precio:    number;
  iva:       number;
  marca:     Marca;
  categoria: Categoria;
  id:        number;
}

export interface Categoria {
  id:          number;
  nombre:      string;
  descripcion: string;
}

export interface Marca {
  id:          number;
  nombre:      string;
  descripcion: string;
}
