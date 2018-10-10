import { Injectable } from '@angular/core';
import {Http} from '@angular/http'
import { Task } from '../model/Task';

@Injectable()
export class TaskService {
  constructor(private http: Http) { }

  fetchBooks(): Promise<any>{
    return this.http.get('http://localhost:8087/libraryapi/books').toPromise()
    .then(res=>res.json())
  }
  fetchBook(id: number): Promise<any>{
    return this.http.get('http://localhost:8087/libraryapi/book/'+id).toPromise()
    .then(res=>res.json())
  }
  updateBook(task:Task){
    return this.http.put('http://localhost:8087/libraryapi/book/', task).toPromise()
  }

  addBook(task:Task): Promise<any>{
    return this.http.post('http://localhost:8087/libraryapi/book/', task).toPromise()
  }

  deleteBook(index:number): Promise<any>{
    return this.http.delete('http://localhost:8087/libraryapi/book/'+index).toPromise()
  }

  /*updateTaskStatus(index:number): Promise<any>{
    return this.http.delete('http://localhost:8082/TaskManagerService/taskapi/taskStatus/'+index).toPromise()
  }*/
}
