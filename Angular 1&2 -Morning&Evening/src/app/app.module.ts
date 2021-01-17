import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { RouterModule, Routes } from '@angular/router';
import {HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AuComponent } from './components/au/au.component';
import { TodoComponent } from './components/todo/todo.component';



const appRoutes: Routes = [
  {
    path: "",
    component: AuComponent
  },
  {
    path: "nav",
    component: TodoComponent
  }
]
@NgModule({
  declarations: [
    AppComponent,
    AuComponent,
    TodoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    //ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AuComponent]
})
export class AppModule { }
