import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ProductoService } from '../services/producto.service';
import { Producto } from 'src/app/models/Producto.model';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  products: Producto[] = [];
  constructor(private productoService: ProductoService, private router: Router) {
    this.productoService.getProducts()
      .subscribe(response => {
        console.log(response)
        this.products = response
      });
  }
  goToProduct(id:number){
    this.router.navigate([id]);
  }

}
