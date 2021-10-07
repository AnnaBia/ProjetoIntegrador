import { environment } from 'src/environments/environment.prod';
import { Tema } from './../../model/Tema';
import { TemaService } from './../../service/tema.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tema-edit',
  templateUrl: './tema-edit.component.html',
  styleUrls: ['./tema-edit.component.css']
})
export class TemaEditComponent implements OnInit {

  tema: Tema = new Tema()

  constructor(
    private temaService: TemaService,
    private router: Router,
    private actRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    // if (environment.token == '') {
    //   this.router.navigate(['/entrar'])
    // }

    let id = this.actRoute.snapshot.params['id']
    this.findByIdTema(id)
  }

  findByIdTema(id: number) {
    this.temaService.getByIdTema(id).subscribe((resp: Tema) => {
      this.tema = resp
    })
  }

  atualizar() {
    this.temaService.putTema(this.tema).subscribe((resp: Tema) => {
      this.tema = resp
      alert('Tema atualizado com sucesso!')
      this.router.navigate(['/tema'])
    })
  }

}
