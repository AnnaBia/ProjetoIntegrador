import { environment } from 'src/environments/environment.prod';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserLogin } from '../model/UserLogin';
import { AuthService } from '../service/auth.service';
import { User } from '../model/User';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  // INSTANCIAMENTO E CRIAÇÃO DE VARIAVEIS
  userLogin: UserLogin = new UserLogin()
  user: User = new User()

  confirmarSenha: string
  tipoUsuario: string

  // INJEÇÃO DE MODULOS
  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    window.scroll(0, 0)
  }
  
  // MÉTODO PARA CHAMAR O BOTÃO ENTRAR DA PÁGINA INICIAL
  click(){
    document.getElementById('teste')?.click()
  }

  // MÉTODO PARA FAZER LOGIN
  entrar() {
    this.auth.entrar(this.userLogin).subscribe((resp: UserLogin) => {
      this.userLogin = resp

      environment.id = this.userLogin.id
      environment.nome = this.userLogin.nome
      environment.username = this.userLogin.username
      environment.token = this.userLogin.token
      environment.email = this.userLogin.email
      environment.admin = this.userLogin.admin
      environment.foto = this.userLogin.foto

      this.router.navigate(['/feed'])
    }, erro => {
      if (erro.status == 500) {
        alert('Usuário ou senha estão incorretos!')
      }
    })
  }

  // MÉTODOS PARA CADASTRAR USUARIOS
  confirmaSenha(event: any) {
    this.confirmarSenha = event.target.value
  }

  tipoUser(event: any) {
    this.tipoUsuario = event.target.value
  }

  cadastrar() {
    if (this.tipoUsuario == "admin") {
      this.user.admin = "adm"
    } else {
      this.user.admin = "user"
    }

    if (this.user.senha != this.confirmarSenha) {
      alert('As senhas estão incorretas!')
    } else {
      this.auth.cadastrar(this.user).subscribe((resp: User) => {
        this.user = resp
        
        this.click() // Chamando o método de clicar no botão entrar assim que cadastrar

        alert('O usuário foi cadastrado com sucesso!')       
      })
    }
  }

}
