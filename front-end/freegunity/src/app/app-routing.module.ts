import { TemaEditComponent } from './edit/tema-edit/tema-edit.component';
import { TemaDeleteComponent } from './delete/tema-delete/tema-delete.component';
import { PostagemEditComponent } from './edit/postagem-edit/postagem-edit.component';
import { PostagemDeleteComponent } from './delete/postagem-delete/postagem-delete.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FeedComponent } from './feed/feed.component';
import { InicioComponent } from './inicio/inicio.component';

// ROTAS DE TODA APLICAÇÃO
const routes: Routes = [
  { path: '', redirectTo: 'inicio', pathMatch: 'full' },

  { path: 'inicio', component: InicioComponent },
  { path: 'feed', component: FeedComponent },

  { path: 'postagem-delete/:id', component: PostagemDeleteComponent },
  { path: 'postagem-edit/:id', component: PostagemEditComponent },

  { path: 'tema-delete/:id', component: TemaDeleteComponent },
  { path: 'tema-edit/:id', component: TemaEditComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
