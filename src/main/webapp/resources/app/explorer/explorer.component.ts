import {Component, Injectable, OnInit} from '@angular/core' ;
import {ExplorerService} from "./explorer.service";
import {Country} from "../region/country/country";
import {Level} from "../region/level/level";
import {count} from "rxjs/operator/count";

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
        });
    }


    getCities(country) {
        if(country.cities==null) {
            this.explorerService.getCities(country.id).
            subscribe((cities)=> {
                country.cities=cities ;
            }) ;
        }
        else {
            country.cities=null ;
        }
    }

    getLocations(city) {
        if(city.locations==null) {
            this.explorerService.getLocations(city.id).
            subscribe((locations)=> {
                city.locations=locations ;
            }) ;
        }
        else {
            city.locations=null ;
        }
    }

    getLevels(location) {
        if(location.levels==null) {
            this.explorerService.getLevels(location.id).
            subscribe((levels)=> {
                location.levels=levels ;
            }) ;
        }
        else {
            location.levels=null ;
        }
    }

    onSelect(floorId: number) {
        this.explorerService.getPlanExistStatus(floorId)
            .subscribe((status)=>{
            if(status == true){
                this.explorerService.drawLayout(floorId);
            }
            else {
                //TODO: Disable this floor
            }
        });
    }
}
