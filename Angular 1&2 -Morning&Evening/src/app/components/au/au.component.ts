import { DatePipe } from '@angular/common';
import { visitValue } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Session } from '../Models/Session';

@Component({
  selector: 'app-root',
  templateUrl: './au.component.html',
  styleUrls: ['./au.component.scss']
})
export class AuComponent implements OnInit {

  
 sessions : Session[];

  inputName: String = "";
  inputTrainer: String = "";
  inputDate: String = "";

  showDetails(id: number) {
    this.sessions.map((session, index) => {
      if(index == id) session.details = !session.details;
      return session;
    })
  }


  addNewSession() {
    //console.log(e);
    this.sessions.unshift( {
      Name: this.inputName,
      Trainer: this.inputTrainer,
      Date: this.inputDate,
      Completed : true,
      visible :true,
      edit :true,
      details : false
    }) 
    return false;
  }



  enable(id: number) {
    this.sessions.map((session, index) => {
      if(index == id) session.edit = !session.edit;
      return session;
    })
  }


  editSession(id: number) {
    this.sessions.map((session, index) => {
      if(index == id) {
        session.Name = this.inputName,
        session.Trainer = this.inputTrainer,
        session.Date = this.inputDate,
        session.visible = true,
        session.details = false,
        session.edit = false

      }
      return session;
    })
  }

 deleteSession(id : number){
  this.sessions.map((v, i) => {
    if(i == id) v.visible = false;
    return v;
  })
  
 }




 constructor() { }

 



  ngOnInit(): void {
    this.sessions = [
      {
        Name : 'Angular Session',
        Trainer : 'Pritam Chouwdhary',
        Date : '12-01-2021',
        Completed : true,
        visible :true,
        edit :false,
        details : false


      },
      {
        Name : 'JavaScript Session',
        Trainer : 'Anushree Rai',
        Date : '11-01-2021',
        Completed : true,
        visible : true,
        edit :false,
        details : false


      },
      {
        Name : 'HTML5 & CSS Session',
        Trainer : 'Vigneshwar K',
        Date : '08-01-2021',
        Completed : true,
        visible : true,
        edit :false,
        details : false


      }

    ]
  }

}
