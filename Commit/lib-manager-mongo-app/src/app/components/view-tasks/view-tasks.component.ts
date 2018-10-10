import { Component, OnInit } from '@angular/core';
import { Task } from '../../model/Task';
import { TaskService } from '../../services/task.service';
import * as moment from 'moment';

@Component({
  selector: 'app-view-tasks',
  templateUrl: './view-tasks.component.html',
  styleUrls: ['./view-tasks.component.css']
})
export class ViewTasksComponent implements OnInit {

  books: Array<Task> = []
  message:string = ''
  alertClass: string = "alert alert-success"

  constructor(private taskService: TaskService) { }

  ngOnInit() {
    this.fetchBooks();
  }

  fetchBooks(){
    this.taskService.fetchBooks()
    .then((data)=>{
      console.log(data);

      // Convertdate using Moment JS - start
      //var dt = moment("2016-01-05").format('MM/DD/YYYY');
      //console.log("myForm.value--> ", dt);
      for (var key in data) {
        if (data.hasOwnProperty(key)) {
          //alert(data[key].stPublishDate);
          data[key].stPublishDate = moment(data[key].stPublishDate).format('MM/DD/YYYY');
          //alert(data[key].stPublishDate);
        }
      }
      // Convertdate using Moment JS - end

      this.books = data;
    })
  }

  deleteBook(index: number){
    this.taskService.deleteBook(index)
    .then((data)=>{
      console.log(data)
    })
    .catch((err)=>{
      if(err.status == 410){
        this.alertClass = "alert alert-success"
        this.message = "Book details deleted successfully!!"
        this.fetchBooks();
      }
      console.log(err)});
  }

  /*updateTaskStatus(index: number){
    this.taskService.updateTaskStatus(index)
    .then((data)=>{
      console.log(data)
      if(data.status == 202){
        this.alertClass = "alert alert-success"
        this.message = "Task ended successfully!!"
        this.fetchTasks();
      }
    })
    .catch((err)=>{
        this.alertClass = "alert alert-danger"
        this.message = "Failed!!"
        console.log(err)});
  }*/

}
