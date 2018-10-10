import { Pipe, PipeTransform } from '@angular/core';
import { Task } from '../model/Task';

@Pipe({
  name: 'filterTask'
})
export class FilterTaskPipe implements PipeTransform {

  d:Date
  

  
  /*transform(tasks: Array<Task>, bookSearch: string, subjectSearch: string,
    priorityFromSearch: number, priorityToSearch: number, dateFromSearch: Date, dateToSearch: Date){*/

transform(tasks: Array<Task>, bookSearch: string, subjectSearch: string,
    durationSearch: number, volumeSearch: number){
        
    if (tasks && tasks.length){
        return tasks.filter(task =>{
            if (bookSearch && task.title.toLowerCase().indexOf(bookSearch.toLowerCase()) == -1){
                return false;
            }
            if (subjectSearch && task.subtitle.toLowerCase().indexOf(subjectSearch.toLowerCase()) == -1){
                return false;
            }
            if (durationSearch && task.durationInHours == durationSearch == false){
                return false;
            }
            if (volumeSearch && task.volume == volumeSearch == false){
                return false;
            }
            /*if (priorityFromSearch && task.priority >= priorityFromSearch == false){
                return false;
            }
            if (priorityToSearch && task.priority <= priorityToSearch == false){
                return false;
            }

            let leftFrom = Number(new Date(dateFromSearch));
            let rightFrom = Number(new Date(task.stStartDate));
            if (dateFromSearch && rightFrom >= leftFrom == false){
                return false;
            }
            let leftTo = Number(new Date(dateToSearch));
            let rightTo = Number(new Date(task.stEndDate));
            if (dateToSearch && rightTo <= leftTo == false){
                return false;
            }*/
            return true;
       })
    }
    else{
        return tasks;
    }
}

}
