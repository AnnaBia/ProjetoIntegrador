// Módulos Globais
import { ModalModule } from 'ngx-bootstrap/modal';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { OrderModule } from 'ngx-order-pipe';

// Componentes Globais
import { AppComponent } from './app.component';
import { InicioComponent } from './inicio/inicio.component';
import { FeedComponent } from './feed/feed.component';
import { RodapeComponent } from './rodape/rodape.component';
import { MenuComponent } from './menu/menu.component';
import { PostagemDeleteComponent } from './delete/postagem-delete/postagem-delete.component';
import { TemaDeleteComponent } from './delete/tema-delete/tema-delete.component';
import { PostagemEditComponent } from './edit/postagem-edit/postagem-edit.component';
import { TemaEditComponent } from './edit/tema-edit/tema-edit.component';
import { AlertasComponent } from './alertas/alertas.component';
import { UserEditComponent } from './edit/user-edit/user-edit.component';
import { UserComponent } from './user/user.component';

// Todos os componentes criados serão válidados aqui
@NgModule({
  declarations: [
    AppComponent,
    AlertasComponent,

    InicioComponent,

    FeedComponent,
    RodapeComponent,
    MenuComponent,

    PostagemDeleteComponent,
    PostagemEditComponent,

    TemaDeleteComponent,
    TemaEditComponent,

    UserEditComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, 
    FormsModule,
    ModalModule.forRoot(),
    OrderModule
  ],
  providers: [],
  bootstrap: [AppComponent] // Permissão do bootstrap agir em toda aplicação
})
export class AppModule { }
