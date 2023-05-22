import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/Producto.model';
import { ProductService } from '../services/product/product.service';
import { Router } from '@angular/router';
import { CommentService } from '../services/comment/comment.service';
import { Comment } from 'src/app/models/Comment.model';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  id: string = '';
  product: Producto = new Producto();
  comments: Comment[] = [];
  averageNote: number = 0;

  constructor(
    private productService: ProductService,
    private router: Router,
    private commentService: CommentService
  ) { }

  ngOnInit(): void {
    const urlSplitted = this.router.url.split("/");
    this.id = urlSplitted[urlSplitted.length - 1];
    this.initializeProduct();
    this.initializeComments();
  }
  initializeProduct() {
    this.productService.getProductById(this.id).subscribe((response: Producto) => {
      this.product = response;
    })
  }

  initializeComments() {
    this.commentService.getCommentsByProduct(this.id).subscribe((response: Comment[]) => {
      this.comments = response
      console.log(response)
      if (this.comments.length > 0) {
        for (const comment of this.comments) {
          this.averageNote += comment.puntuacion
        }
        this.averageNote /= this.comments.length
      }
    });
  }

}
