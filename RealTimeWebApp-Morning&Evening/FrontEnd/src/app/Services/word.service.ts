import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Word } from '../Models/word';

@Injectable()
export class WordService {

  GET_ALL_WORDS = "/word/getAll";
  SAVE_WORDS = "/word/save";
  DELETE_WORD = "/word/delete";
  UPDATE_WORD = "/word/update";

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get(this.GET_ALL_WORDS);
  }

  addWord(payload: Word): Observable<any>{
    return this.http.post(this.SAVE_WORDS, payload);
  }

  deleteWord(id: Number): Observable<any>{
    return this.http.delete(this.DELETE_WORD + "/" + id)
  }

  updateWord(payload: Word): Observable<any> {
    return this.http.post(this.UPDATE_WORD, payload);
  }

}
