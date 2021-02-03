import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { WordService } from '../../Services/word.service';
import { Word } from '../../Models/word';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  words: Array<Word> = [];
  
  editableWord!: Word;

  optionsList: any = [
    "Id",
    "Word",
    "Meaning",
    "Part Of Speech",
    "Example",
    "Last Modified Time",
  ];

  form = new FormGroup({
    sortBy: new FormControl('', Validators.required)
  });

  constructor(private service: WordService) { }

  ngOnInit(): void {
    this.service.getAll().subscribe(resp => {
      this.words = resp;
      
    });
    console.log(this.words);
  }

  edit(word:Word):void{
    console.log("edit", word);
    this.editableWord = word;
  }

  updateWord($event: any):void{
    console.log($event);
    this.service.deleteWord($event.id).subscribe(
      resp => {
        if(resp)
        {
          this.words = this.words.filter(old => old.id != $event.id);  
        } 
      }
    )
    this.service.addWord($event).subscribe(resp => this.words.push(resp));
  }

  delete(word:Word):void{
    console.log("delete", word);
    this.service.deleteWord(word.id).subscribe(resp => {
      if(resp)
      {
        this.words = this.words.filter(old => old.id != word.id);  
      } 
    })
  }


  sort() {
    console.log(this.form.value);

    switch (this.form.value.sortBy) {
      case "Id":
        this.words.sort(function (a, b) {
          return (a.id.valueOf() - b.id.valueOf());
        });
        break;
      case "Word":
        this.words.sort((a, b) => a.word.localeCompare(b.word));
        break;
      case "Meaning":
        this.words.sort((a, b) => a.meaning.localeCompare(b.meaning));
        break;
      case "Part Of Speech":
        this.words.sort((a, b) => a.partOfSpeech.localeCompare(b.partOfSpeech));
        break;
      case "Example":
        this.words.sort((a, b) => a.example.localeCompare(b.example));
        break;
      case "Last Modified Time":
        this.words.sort(function (a, b) { return new Date(a.lastModifiedTm).valueOf() - new Date(b.lastModifiedTm).valueOf(); });
        break;
    }
  }

}
