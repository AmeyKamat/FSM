import {Headers, Http} from "@angular/http";
import {FormGroup} from "@angular/forms";
import {Injectable} from "@angular/core";

@Injectable()
export class UploadService{
    public file: File;
    public url:string;
    headers: Headers;
    formData:FormData ;

    print(){
        console.log("Service is getting cured") ;
    }


    constructor(){
        this.headers = new Headers();
        this.headers.set('Content-Type', 'multipart/form-data');
        this.url = 'http://localhost:8080/test';
    }
    changeListener($event): void {
        // this.postFile($event.target);
        console.log(" in service: "+$event.target.files[0].name) ;
        this.formData = new FormData();
        this.formData.append("name", "layout");
        this.formData.append("file",  +$event.target.files[0]);
    }
    //
    acceptFormData(formGroup:FormGroup):void{
        console.log('you submitted value: ', formGroup.get('country').value);
        this.formData.append("country",formGroup.get('country').value) ;
        this.formData.append("city",formGroup.get('city').value) ;
        this.formData.append("location",formGroup.get('location').value) ;
        this.formData.append("floor",formGroup.get('floor').value) ;
         // this.http.post(this.url ,
         //     this.formData ,
         //     {
         //         headers: this.headers
         //
         //     });

    }

}
