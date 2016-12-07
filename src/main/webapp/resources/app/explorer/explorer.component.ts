import {Component, Injectable, OnInit} from '@angular/core' ;
import {ExplorerService} from "./explorer.service";
import {Country} from "../region/country/country";
import {Level} from "../region/level/level";

@Component({
    moduleId:module.id,
    selector:'explorer',
    templateUrl:'explorer.component.html'
})

@Injectable()
export class ExplorerComponent implements OnInit {
    countries: Country[];
    selectedLevel: Level;

    constructor(private explorerService: ExplorerService) {
    }

    ngOnInit(){
        this.explorerService.getCountries().
        subscribe((countries)=> {
            this.countries = countries;
            for (var i = 0; i < this.countries.length; i++) {
                this.countries[i].cities=null ;
            }
        });
    }

    toggleCountry(country) {
        // this.cities = !this.expanded;
        console.log("toggle block") ;
        if(country.cities==null) {
            console.log("Inside if block") ;
            this.explorerService.getCities(country.id).
            subscribe((cities)=> {
                country.cities=cities ;
                for (var i = 0; i < country.cities.length; i++) {
                    console.log("Countries are:"+cities[i].name) ;
                    country.cities[i].expanded=false ;
                    country.cities[i].locations=null ;
                }
            }) ;
        }
        else {
            country.cities=null ;
        }
    }

    toggleCity(city) {
        console.log(" city toggle block") ;
        if(city.locations==null) {
            console.log("Inside if block") ;
            this.explorerService.getLocations(city.id).
            subscribe((locations)=> {
                city.locations=locations ;
                for (var i = 0; i < city.locations.length; i++) {
                    console.log("Countries are:"+city.locations[i].name) ;
                    city.locations[i].levels=null ;
                }
            }) ;
        }
        else {
            city.locations=null ;
        }
    }

    toggleLocation(location) {
        // this.cities = !this.expanded;
        console.log(" location toggle block") ;
        if(location.levels==null) {
            console.log("Inside if block ") ;
            this.explorerService.getLevels(location.id).
            subscribe((levels)=> {
                location.levels=levels ;
                for (var i = 0; i < location.levels.length; i++) {
                    console.log("levels are:"+location.levels[i].floorCode) ;
                    // location.locations[i].locations=null ;
                }
            }) ;
        }
        else {
            location.levels=null ;
        }
    }

    onSelect(id: number) {
        this.explorerService.drawLayout(id);
    }
}
