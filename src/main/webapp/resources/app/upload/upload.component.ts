import {Component, Injectable, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UploadService} from "./upload.service";
import {Country} from "../region/country/country";
import {City} from "../region/city/city";
import {Location} from "../region/location/location";
import {Level} from "../region/level/level";

@Component({
    moduleId: module.id,
    selector: 'upload',
    templateUrl: 'upload.component.html'
})

@Injectable()
export class UploadComponent implements OnInit{
    myForm: FormGroup;
    file:File;
    submitAttempt:boolean =false ;
    uploadFileName:string = "No File Selected";
    countries:Country[] ;
    cities:City[] ;
    locations:Location[] ;
    levels:Level[] ;

    constructor(fb: FormBuilder, private uploadService:UploadService) {
        this.myForm = fb.group({
            'country':['',Validators.required],
            'city':['',Validators.required],
            'location':['',Validators.required],
            'floorId':['',Validators.required],
            'upload':['',Validators.required]
        });
    }

    ngOnInit(){
        this.getCountries() ;
    }

    getCountries() {
        this.uploadService.getCountries().subscribe((countries)=> {
            this.countries = countries;
            for (var i = 0; i < this.countries.length; i++) {
                this.countries[i].cities = null;
            }
        });
    }

    getCities(countryId:number) {
        this.uploadService.getCities(countryId).subscribe((cities)=> {
            this.cities = cities;
            for (var i = 0; i < this.cities.length; i++) {
                this.cities[i].locations = null;
            }
        });
    }

    getLocations(cityId:number) {
        this.uploadService.getLocations(cityId).subscribe((locations)=> {
            this.locations = locations;
            for (var i = 0; i < this.locations.length; i++) {
                this.locations[i].levels = null;
            }
        });
    }

    getLevels(locationId:number) {
        this.uploadService.getLevels(locationId).subscribe((levels)=> {
            this.levels = levels;
        });
    }
    uploadFileListener($event): void {
        let file = $event.target.files[0];
        this.uploadFileName = file.name;
        this.uploadService.setUploadFile(file);
    }

    onSubmit(formGroup: FormGroup): void {
        this.submitAttempt=true ;
        this.uploadService.acceptFormData(formGroup) ;
    }
    /* Need bug fixing after which it will replace above code
    uploadFileListener($event): void {
        this.file = $event.target.files[0];
        this.uploadFileName = this.file.name;
    }

    onSubmit(formGroup: FormGroup): void {
        let formData = new FormData();
        formData.append("name", "layout");
        formData.append("country",formGroup.get('country').value) ;
        formData.append("city",formGroup.get('city').value) ;
        formData.append("location",formGroup.get('location').value) ;
        formData.append("floor",formGroup.get('floor').value) ;
        formData.append("file",this.file);

        this.uploadService.acceptFormData(formData) ;
    }*/
}