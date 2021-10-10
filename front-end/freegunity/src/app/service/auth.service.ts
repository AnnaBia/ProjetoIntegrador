import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { UserLogin } from '../model/UserLogin';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // Injeção de módulos e services
  constructor(
    private http: HttpClient
  ) { }

  // Métodos HTTP de logar e cadastrar implemetados do back-end
  entrar(userLogin: UserLogin): Observable<UserLogin> {
    return this.http.post<UserLogin>('https://fregunity.herokuapp.com/usuarios/entrar', userLogin)
  }

  cadastrar(user: User): Observable<User> {
    return this.http.post<User>('https://fregunity.herokuapp.com​/usuarios​/cadastrar', user)
  }

  getByIdUser(id: number): Observable<User> {
    return this.http.get<User>(`https://fregunity.herokuapp.com​/usuarios/${id}`)
  }

  // Método para ativar certos componentes quando estiver logado
  logado() {
    let ok: boolean = false

    if (environment.token != '') {
      ok = true
    }

    return ok
  }
}
