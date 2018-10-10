export class Task{
    /*constructor(public taskId: number, public task: string, public priority: number, 
        public parentTask: string, public stStartDate: Date, public stEndDate: Date,
        public taskStatus: number){

    }*/
    constructor(public bookId: string, public title: string, public price: number, 
        public volume: number, public stPublishDate: Date, public subjectId: string,
        public subtitle: string, public durationInHours: number){
            
    }
}