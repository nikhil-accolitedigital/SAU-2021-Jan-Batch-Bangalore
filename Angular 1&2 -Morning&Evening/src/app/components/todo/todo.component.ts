import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { todo } from './todo';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {

  todos: todo[];

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.getTodos();
  }
  
  getTodos() {
    this.httpClient.get<any>('https://jsonplaceholder.typicode.com/todos').subscribe(
      response  => {
        this.todos = response;
      }
    );
  }

  showTodo(id: number) {
    this.todos.map((todo, index) => {
      if(index == id) todo.display = !todo.display;
      return todo;
    })
  }

}