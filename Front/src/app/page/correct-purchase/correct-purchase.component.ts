import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-correct-purchase',
  templateUrl: './correct-purchase.component.html',
  styleUrls: ['./correct-purchase.component.scss']
})
export class CorrectPurchaseComponent {
  constructor(private router: Router) { }
  returnToLobby(){
    this.router.navigate([''])
  }
}
