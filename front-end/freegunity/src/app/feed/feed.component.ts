import { User } from './../model/User';
import { environment } from 'src/environments/environment.prod';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  user = environment.nome

  // Injeção de módulos e services
  constructor(
    private router: Router
  ) { }

  ngOnInit() {
    window.scroll(0, 0)
    
    if (environment.token == '') {
      // alert('Sua sessão expirou, faça login novamente.')
      this.router.navigate(['/entrar'])
    }
  }

}
