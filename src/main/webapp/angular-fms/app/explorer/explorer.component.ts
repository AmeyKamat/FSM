import {Component, Injectable, OnInit} from '@angular/core' ;
import {ExplorerService} from "./explorer.service";
import {Level} from "../Region/floor/level";
import {Country} from "../Region/country/country";

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
            console.log("Exploreer constructed") ;
    }

    ngOnInit(){
        this.explorerService.getCountries().
        subscribe((countries)=> {
            this.countries = countries;
            for (var i = 0; i < this.countries.length; i++) {
                console.log("Countries are:"+countries[i].name) ;
                this.countries[i].cities=null ;

            }
        });
    }

    toggleCountry(country)
    {
        // this.cities = !this.expanded;
        console.log("toggle block") ;
        if(country.cities==null)
        {
            console.log("Inside if block") ;
            // country.cities=[new City("Pune",1,[])] ;
            this.explorerService.getCities().
            subscribe((cities)=>
            {
                country.cities=cities ;
                for (var i = 0; i < country.cities.length; i++) {
                    console.log("Countries are:"+cities[i].name) ;
                    country.cities[i].expanded=false ;
                    country.cities[i].locations=null ;

                }
            }) ;

        }
        else
        {
            country.cities=null ;
        }
    }
    toggleCity(city)
    {
        // this.cities = !this.expanded;
        console.log(" city toggle block") ;
        if(city.locations==null)
        {
            console.log("Inside if block") ;
            this.explorerService.getLocations().
            subscribe((locations)=>
            {
                city.locations=locations ;
                for (var i = 0; i < city.locations.length; i++) {
                     console.log("Countries are:"+city.locations[i].name) ;

                    city.locations[i].levels=null ;

                }
            }) ;
        }
        else
        {
            city.locations=null ;
        }
    }


    toggleLocation(location)
    {
        // this.cities = !this.expanded;
        console.log(" location toggle block") ;
        if(location.levels==null)
        {
            console.log("Inside if block ") ;
            this.explorerService.getLevels().
            subscribe((levels)=>
            {
                location.levels=levels ;
                for (var i = 0; i < location.levels.length; i++) {
                    console.log("levels are:"+levels[i].name) ;

                    // location.locations[i].locations=null ;

                }
            }) ;
        }
        else
        {
            location.levels=null ;
        }
    }



    onSelect(id: number) {
        console.log("on select called ") ;
        this.explorerService.drawLayout(id);
    }

}
