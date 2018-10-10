import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Http } from '@angular/http';
import { TaskService } from '../../services/task.service';
import {ActivatedRoute} from "@angular/router";
import * as moment from 'moment';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  myForm: FormGroup
  message:string = ''
  alertClass: string = "alert alert-success"

  //genders: Array<string> = ['Male', 'Female']

  constructor(private taskService: TaskService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.params.subscribe( params => {
      if(params.id){
        this.fetchBook(params.id) 
      }
    });

  }

  fetchBook(id: number){
    this.taskService.fetchBook(id)
    .then(data => {
      console.log(data);
      this.myForm.controls['bookId'].setValue(data.bookId)
      this.myForm.controls['title'].setValue( data.title);
      this.myForm.controls['price'].setValue( data.price);
      this.myForm.controls['volume'].setValue( data.volume);
      this.myForm.controls['stPublishDate'].setValue( data.stPublishDate);
      this.myForm.controls['subtitle'].setValue( data.subtitle);
      this.myForm.controls['durationInHours'].setValue( data.durationInHours);
    })
  }


  ngOnInit() {
      this.myForm = new FormGroup({  
              'bookId': new FormControl('' ),   
              'title': new FormControl('', Validators.required),  
              'price': new FormControl('', Validators.required),
              'volume': new FormControl('', Validators.required),
              'stPublishDate': new FormControl('', Validators.required),
              'subtitle': new FormControl('', Validators.required),
              'durationInHours': new FormControl(0, Validators.required)
          // 'password': new FormControl('', Validators.pattern("^[a-zA-Z0-9!@#$%^&*]{6,16}$")),
          // 'age': new FormControl('', [Validators.min(18), Validators.max(100)]),
          // 'gender': new FormControl('Male')
      })

      this.myForm.statusChanges.subscribe((data: any) => console.log(data));
  }
  
  onSubmit() {
      console.log("myForm--> " + this.myForm);
      console.log("myForm.value--> ", this.myForm.value);
      //this.myForm.value.stStartDate = "01-Dec-2018";
      //this.myForm.value.stStartDate = moment(this.myForm.value.stStartDate).format('MM/DD/YYYY');
      //console.log("myForm.value--> ", this.myForm.value);
      this.taskService.addBook(this.myForm.value)
      .then((res) => {
        console.log(res.status)
        if(res.status == 201){
          this.alertClass = "alert alert-success"
          this.message = "Book added successfully!!"
        }
      })
      .catch((res) =>{
        console.log(res.status)
        if(res.status == 409){
          this.alertClass = "alert alert-danger"
          this.message = "Book already exists!!"
        }
      })
  }
  updateBook() {
      console.log(this.myForm);
      console.log(this.myForm.value);
      this.taskService.updateBook(this.myForm.value)
      .then((res) => {
        console.log(res.status)
        if(res.status == 201){
          this.alertClass = "alert alert-success"
          this.message = "Book added successfully!!"
        }
        if(res.status == 202){
          this.alertClass = "alert alert-success"
          this.message = "Book updated successfully!!"
        }
      })
  }

  resetBook() {
    this.myForm.reset();
    this.myForm.controls['bookId'].setValue('');
    this.myForm.controls['title'].setValue('');
    this.myForm.controls['price'].setValue('');
    this.myForm.controls['volume'].setValue('');
    this.myForm.controls['stPublishDate'].setValue('');
    this.myForm.controls['subtitle'].setValue('');
    this.myForm.controls['durationInHours'].setValue('0');
  }


  // uniqueUserValidator(control: FormControl): Promise<any> {
  //     // Server to make a request, AJAX -> can take time

  //     const promise = new Promise<{ [s: string]: boolean }>(
  //         (resolve, reject) => {

  //             if (control.value && control.value!='') {

  //                 setTimeout(() => {
  //                     console.log('Validation is fired now!!')
  //                     this.http.get('http://localhost:7000/userexists/' + control.value)
  //                         .toPromise().then((res) => res.json())
  //                         .then((data) => {
  //                             console.log(data)
  //                             if (data.exists === true) {
  //                                 resolve({ "invalid": true })
  //                             }
  //                             else {
  //                                 resolve(null)
  //                             }
  //                         }
  //                         )
  //                 }
  //                     , 1000)
  //             }
  //             else{
  //                 resolve(null)
  //             }
  //         })
  //     return promise;


  // }


}
