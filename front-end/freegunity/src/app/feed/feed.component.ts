import { AlertasService } from './../service/alertas.service';
import { AuthService } from './../service/auth.service';
import { User } from './../model/User';
import { environment } from 'src/environments/environment.prod';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  user: User = new User()
  idUser = environment.id

  // Injeção de módulos e services
  constructor(
    private authService: AuthService,
    private router: Router,
    private alert: AlertasService
  ) { }

  ngOnInit() {
    window.scroll(0, 0)
    
    if (environment.token == '') {
      this.alert.showAlertInfo('Sua sessão expirou, faça login novamente.')
      this.router.navigate(['/inicio'])
    }

    this.findByIdUser(this.idUser)
  }

  icon() {
    let pic: string = 'assets/img/user-default.jpg'

    if (this.user.foto == '') {
      environment.foto = pic
    } else {
      environment.foto = this.user.foto
    }

    return environment.foto
  }

  findByIdUser(id: number) {
    this.authService.getByIdUser(id).subscribe((resp: User) => {
      this.user = resp
    })
  }
}
