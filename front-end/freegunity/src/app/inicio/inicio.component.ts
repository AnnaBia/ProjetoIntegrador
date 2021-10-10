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

  // Instanciamento e criação de variáveis
  userLogin: UserLogin = new UserLogin()
  user: User = new User()

  confirmarSenha: string
  tipoUsuario: string

  // Injeção de módulos e services
  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  // Método do Angular que inicia primeiro todos os métodos dentro dele
  ngOnInit() {
    window.scroll(0, 0)
  }
  
  // Método para chamar o botão entrar da página inicial
  click(){
    document.getElementById('teste')?.click()
  }

  // Método para fazer login
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

  // Métodos para cadastrar usuários
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

  confirmaSenha(event: any) {
    this.confirmarSenha = event.target.value
  }

  tipoUser(event: any) {
    this.tipoUsuario = event.target.value
  }

}
