// Módulos Globais
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

// Componentes Globais
import { AppComponent } from './app.component';
import { InicioComponent } from './inicio/inicio.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent
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
