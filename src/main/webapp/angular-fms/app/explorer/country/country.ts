import {City} from "../city/city";
import {Inject, Injectable} from "@angular/core";
import {CountryService} from "./country.service";
export class Country{
    name:String ;
    id:number ;
    cities:City[] ;





   //  expanded:boolean=false ;
   //  // @Inject(CountryService)countryService ;
   //  errorMessage:String ;
   //
   //  constructor(private countryService:CountryService){
   //
   //  }
   //
   //  toggle()
   //  {
   //      console.log("toggle called") ;
   //      this.expanded = !this.expanded;
   //      if(this.expanded==true)
   //      {
   //          this.getCities();
   //      }
   //  }
   //  getCities()
   //  {
   //
   //
   //      // this.countryService.getCities(this).
   //      // subscribe((cities) =>{
   //      //     this.cities=cities;
   //      //         console.log(" length", this.cities.length);
   //      //         for (var i = 0; i < this.cities.length; i++) {
   //      //             this.cities[i].expanded=false ;
   //      //             console.log(this.cities[i].expanded) ;
   //      //         }
   //      // },
   //      //     error =>this.errorMessage=<any>error) ;
   //
   //  }
   //
   // // public getIcon(){
   // //
   // //       console.log("i am being called") ;
   // //      if(this.expanded){
   // //          return '-';
   // //      }
   // //
   // //      return '+';
   // //  }
   //

}