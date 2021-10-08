import { environment } from 'src/environments/environment.prod';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
    // if (environment.token == '') {
    //   // alert('Sua sessão expirou, faça login novamente.')
    //   this.router.navigate(['/entrar'])
    // }
  }

}
