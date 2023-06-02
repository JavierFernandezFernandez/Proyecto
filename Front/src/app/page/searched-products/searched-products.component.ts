import { Producto } from 'src/app/models/Producto.model';
import { ProductService } from './../../services/product/product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-searched-products',
  templateUrl: './searched-products.component.html',
  styleUrls: ['./searched-products.component.scss']
})
export class SearchedProductsComponent implements OnInit {
  term: string;
  products: Producto[] = [];

  constructor(private productService: ProductService) {
    const arrHref = location.href.split('/');
    this.term = arrHref[arrHref.length - 1];
  }

  ngOnInit(): void {
    this.productService.getProductByName(this.term)
      .subscribe((response: Producto[]) => {
        this.products = response
      })
  }
  checkDescriptionQuantity(product: Producto): boolean {
    if (product.descripcion) {
      if (product.descripcion.length > 297) {
        return true;
      }
    }
    return false;
  }
}
