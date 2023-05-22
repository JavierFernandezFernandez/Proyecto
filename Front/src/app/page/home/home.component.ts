import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ProductService } from '../services/product/product.service';
import { Producto } from 'src/app/models/Producto.model';
import { Router, RouterLink } from '@angular/router';
import { delay } from 'rxjs/operators';
import { Observable, of } from 'rxjs';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  ranodmProducts: Producto[] = [];
  imageNames: string[] = [];

  constructor( private router: Router, private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.get4RandomProducts()
      .subscribe(response => {
        this.ranodmProducts = response
        console.log(this.ranodmProducts);
      });
  }

  goToProduct(id: number) {
    this.router.navigate([id]);
  }

}
