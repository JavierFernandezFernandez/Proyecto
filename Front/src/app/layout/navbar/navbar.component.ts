import { ProductService } from './../../page/services/product/product.service';
import { Component, OnInit } from '@angular/core';
import { LayoutService } from '../services/layout.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  isLoggedIn: boolean = false;

  constructor(
    private layoutService: LayoutService,
    private router: Router,
    private productService:ProductService
  ) { }

  ngOnInit(): void {
    this.layoutService.isLoggedIn.subscribe((isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
    });
  }
  closeSesion() {
    localStorage.clear();
    this.isLoggedIn = false;
    this.router.navigate(['/']);
  }

  getAcutualRoute(): string {
    return this.router.url
  }

  search(therm: HTMLInputElement){
    this.router.navigate([`/search/${therm.value}`]);
  }
}
