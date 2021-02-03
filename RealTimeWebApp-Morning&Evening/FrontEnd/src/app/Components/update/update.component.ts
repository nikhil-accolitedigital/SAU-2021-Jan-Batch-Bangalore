import { Component, Input, OnChanges, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Word } from 'src/app/Models/word';
import { WordService } from '../../Services/word.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit,OnChanges {

  @Input('label') label:any;
  @Input('editableWord') editableWord:any;


  @Output() updateWord = new EventEmitter<any>();
  
  
  
  
  wordForm: FormGroup;
  addwordPayload!: Word;

  constructor(private wordService: WordService) { 
    this.wordForm = new FormGroup({
      word: new FormControl(null,[Validators.required , Validators.minLength(2) , Validators.maxLength(30)]),
      meaning: new FormControl(null,[Validators.required , Validators.minLength(10)]),
      partOfSpeech: new FormControl(null,[Validators.required , Validators.maxLength(20)]),
      example: new FormControl("demo",[Validators.required , Validators.minLength(20)]),
    });
  }


  
  ngOnChanges(changes: any): void {
    if(changes.editableWord && changes.editableWord.currentValue != changes.editableWord.previousValue)
    {
      let tempWord = {
        word: this.editableWord.word,
        meaning: this.editableWord.meaning,
        partOfSpeech: this.editableWord.partOfSpeech,
        example: this.editableWord.example
      }
      this.wordForm.setValue(tempWord);
    } 
  }

  ngOnInit(): void {
    
  }

  AddorUpdateWord():void
  {
    if(this.label.includes("Update"))
    {
      this.updateWord.emit({
        ...this.wordForm.value,
        id:this.editableWord.id
      })
    }
    else
    {
      this.addwordPayload = this.wordForm.value;
      this.wordService.addWord(this.addwordPayload).subscribe(resp => console.log(resp));
    }
  }

}
