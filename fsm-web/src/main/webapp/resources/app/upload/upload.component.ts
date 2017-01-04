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

    form: FormGroup;
    file:File;
    submitAttempt:boolean =false ;
    uploadFileName:string = "No File Selected";
    countries:Country[] ;
    cities:City[] ;
    locations:Location[] ;
    levels:Level[] ;
    planExistStatus:boolean;

    constructor(fb: FormBuilder, private uploadService:UploadService) {
        this.form= fb.group({
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
    getPlanExistStatus(floorId:number):void{
        this.uploadService.getPlanExistStatus(floorId).subscribe((status)=>{
            this.planExistStatus = status;
        });
    }

    uploadFileListener($event): void {
        this.file = $event.target.files[0];
        this.uploadFileName = this.file.name;
    }

    onSubmit(formGroup: FormGroup): void {
        let formData = new FormData();
        formData.append("floorId",formGroup.get('floorId').value) ;
        formData.append("file",this.file);
        this.uploadService.acceptFormData(formData) ;
    }
}