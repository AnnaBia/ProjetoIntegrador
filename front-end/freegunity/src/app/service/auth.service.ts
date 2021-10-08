import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { UserLogin } from '../model/UserLogin';
<<<<<<< HEAD
//import com erro, nome definido = Usuario
import { User } from '../model/User';

=======
import { User } from '../model/User';
>>>>>>> 2b8542d0ef27bab77b1ff15973c5f3dc89dd74ec

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }

  entrar(userLogin: UserLogin): Observable<UserLogin> {
    return this.http.post<UserLogin>('https://fregunity.herokuapp.com/usuarios/entrar', userLogin)
  }
<<<<<<< HEAD
//observable cadastrar  = : Observable<Usuario>
  cadastrar(usuario: User): Observable<User> {
    return this.http.post<User>('https://fregunity.herokuapp.com​/usuarios​/cadastrar', usuario)
=======

  cadastrar(user: User): Observable<User> {
    return this.http.post<User>('https://fregunity.herokuapp.com/usuarios/cadastrar', user)
>>>>>>> 2b8542d0ef27bab77b1ff15973c5f3dc89dd74ec
  }

  logado() {
    let ok: boolean = false

    if (environment.token != '') {
      ok = true
    }

    return ok
  }
}
