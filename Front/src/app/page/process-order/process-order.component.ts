import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-process-order',
  templateUrl: './process-order.component.html',
  styleUrls: ['./process-order.component.scss']
})
export class ProcessOrderComponent implements OnInit {

  previousUrl: string = '';


  constructor(private router:Router,private usuarioService: UsuarioService,){

  }
  ngOnInit(): void {

  }

  

}
