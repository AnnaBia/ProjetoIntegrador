// Módulos Globais
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

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

@NgModule({
  declarations: [
    AppComponent,
    
    InicioComponent,
    
    FeedComponent,
    RodapeComponent,
    MenuComponent,

    PostagemDeleteComponent,
    PostagemEditComponent,
    
    TemaDeleteComponent,
    TemaEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, // Modulo HTTP
    FormsModule // Modulo para Formularios
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
