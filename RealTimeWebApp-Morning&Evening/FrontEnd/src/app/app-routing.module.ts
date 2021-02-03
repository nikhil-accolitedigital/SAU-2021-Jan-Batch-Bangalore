import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { AddComponent } from './Components/add/add.component';

const routes: Routes = [
  { path: "home" , pathMatch: "full" , component: HomeComponent},
  { path: "add" , pathMatch: "full" , component: AddComponent},
  { path: "**" , redirectTo: "/home" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
