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
    submitAttempt:boolean =false ;
    countries:Country[] ;
    cities:City[] ;
    locations:Location[] ;
    levels:Level[] ;

    constructor(fb: FormBuilder, private uploadService:UploadService) {
        console.log("I am constructed") ;
        this.myForm = fb.group({
            'country':['',Validators.required],
            'city':['',Validators.required],
            'location':['',Validators.required],
            'floor':['',Validators.required],
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
                console.log("Countries are:" + countries[i].name);
                this.countries[i].cities = null;
            }
        });
    }

    getCities(countryName) {
        console.log("Country selected successfully"+countryName) ;
        this.uploadService.getCities().subscribe((cities)=> {
            this.cities = cities;
            for (var i = 0; i < this.cities.length; i++) {
                console.log("Countries are:" + cities[i].name);
                this.cities[i].locations = null;
            }
        });
    }

    getLocations(cityName) {
        this.uploadService.getLocations().subscribe((locations)=> {
            this.locations = locations;
            for (var i = 0; i < this.locations.length; i++) {
                console.log("Countries are:" + locations[i].name);
                this.locations[i].levels = null;
            }
        });
    }

    getLevels(locationName) {
        this.uploadService.getLocations().subscribe((levels)=> {
            this.levels = levels;
            for (var i = 0; i < this.levels.length; i++) {
                console.log("Countries are:" + levels[i].name);
            }
        });
    }

    changeListener($event): void {
        this.uploadService.changeListener($event) ;
    }

    onSubmit(value: FormGroup): void {
        this.submitAttempt=true ;
        console.log(JSON.stringify(value.value))
        this.uploadService.acceptFormData(value) ;
    }
}