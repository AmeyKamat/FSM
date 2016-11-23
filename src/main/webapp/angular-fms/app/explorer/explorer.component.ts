import {Component, Injectable, OnInit} from '@angular/core' ;
import {ExplorerService} from "./explorer.service";
import {Country} from "./country/country";
import {Floor} from "./floor/floor";
import {UtilService} from "../util/util.service";
import {LayoutService} from "../layout/layout.service";
import {City} from "./city/city";
@Component({
    moduleId:module.id,
    selector:'explorer',
    templateUrl:'explorer1.component.html',
    providers:[ExplorerService]
    })

export class ExplorerComponent implements OnInit{
     countries: Country[] ;
     selectedFloor:Floor ;

    constructor(private explorerService:ExplorerService,private utilService:UtilService,private layoutService:LayoutService){


    }

    ngOnInit(){

        console.log("explorer initialised") ;
        // this.countries=[new Country(1,"India",[]),new Country(2,"China",[])] ;
        this.explorerService.getCountries().
            subscribe((countries)=>
        {
            this.countries=countries ;
            for (var i = 0; i < this.countries.length; i++) {
                console.log("Countries are:"+countries[i].name) ;
                this.countries[i].expanded=false ;
                this.countries[i].cities=null ;

            }
        }) ;

    }
    // public getIcon(country:Country){
    //
    //     // console.log("i am being called") ;
    //     if(country.expanded){
    //         return '-';
    //     }
    //
    //     return '+';
    // }
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
            // city.locations=[new City("Pune",1,[])] ;
        }
        else
        {
            city.locations=null ;
        }
    }


}
//Saurabh's to be added with the floor
// onSelect(id:number){
//    let layoutData=this.layoutService.getLayoutData(id) ;
//     this.utilService.calculateGridSize(layoutData) ;
//     this.layoutService.loadLayoutData(layoutData ) ;
// }
