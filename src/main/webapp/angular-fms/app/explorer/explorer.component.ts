import {Component, Injectable, OnInit} from '@angular/core' ;
import {ExplorerService} from "./explorer.service";
import {Country} from "./country/country";
import {Floor} from "./floor/floor";
@Component({
    moduleId:module.id,
    selector:'explorer',
    templateUrl:'explorer1.component.html'
    })

export class ExplorerComponent implements OnInit{
     countries: Country[] ;
     selectedFloor:Floor ;

    constructor(private explorerService:ExplorerService,private utilService:UtilService){

    }

    ngOnInit(){

       // this.countries=[new Country(1,"India",[]),new Country(2,"China",[])] ;
        this.explorerService.getCountries().
            subscribe((countries)=>
        {
            this.countries=countries ;
            for (var i = 0; i < this.countries.length; i++) {
                this.countries[i].expanded=false ;
                console.log(this.countries[i].expanded) ;
            }
        }) ;

    }

    onSelect(id:number){
       let floorData=this.explorerService.getFloorData(id) ;
        this.utilService.calculateGridSize(floorData) ;
        this.explorerService.loadFloorData(floorData ) ;
    }

}
//exploreer Service code
// constructor(private http:Http){
//
// }
// getCountries():Observable<Country[]>{
//
//     return this.http.get('').map((response: Response) => <Country[]> response.json());
// // return [new City("Pune",country,[]),new City("Pune",country,[])] ;
//
// }