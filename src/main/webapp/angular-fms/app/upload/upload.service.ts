import {Headers} from "@angular/http";
import {FormGroup} from "@angular/forms";
import {Injectable} from "@angular/core";
import {Country} from "../region/country/country";
import {Observable} from "rxjs";
import {DataService} from "../util/data.service";
import {City} from "../region/city/city";
import {Location} from "../region/location/location";

@Injectable()
export class UploadService{
    public file: File;
    public url:string;
    headers: Headers;
    formData:FormData ;

    constructor( private dataService:DataService){
        this.headers = new Headers();
        this.headers.set('Content-Type', 'multipart/form-data');
        this.url = 'http://localhost:8080/test';
    }
    changeListener($event): void {
        console.log(" in service: "+$event.target.files[0].name) ;
        this.formData = new FormData();
        this.formData.append("name", "layout");
        this.formData.append("file",  +$event.target.files[0]);
    }

    acceptFormData(formGroup:FormGroup):void {
        console.log('you submitted value: ', formGroup.get('country').value);
        this.formData.append("country",formGroup.get('country').value) ;
        this.formData.append("city",formGroup.get('city').value) ;
        this.formData.append("location",formGroup.get('location').value) ;
        this.formData.append("floor",formGroup.get('floor').value) ;
    }

    getCountries():Observable<Country[]> {
        return this.dataService.getCountries() ;
    }

    getCities():Observable<City[]> {
        return this.dataService.getCities() ;
    }

    getLocations():Observable<Location[]> {
        return this.dataService.getLocations() ;
    }
}
