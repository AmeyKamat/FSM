import {Location} from "../location/location";
import {Country} from "../country/country";
import {CityService} from "./cityService";
export class City{
 name : String ;
 locations:Location[] ;
 country:Country ;
 id:number ;



 // expanded:boolean ;
 // errorMessage:String ;
 // constructor(name,country,locations)
 // {
 //   this.name=name ;
 //  this.country=country ;
 //  this.locations=locations ;
 // }
 // constructor(private cityService:CityService){
 //
 // }
 // toggle()
 // {
 //  this.expanded = !this.expanded;
 //  if(this.expanded==true)
 //  {
 //   this.getLocations();
 //  }
 // }
 // getLocations()
 // {
 //
 //       this.cityService.getLocations(this).
 //       subscribe((locations) =>
 //       {
 //          this.locations=locations ;
 //        for (var i = 0; i < this.locations.length; i++) {
 //         this.locations[i].expanded=false ;
 //         console.log(this.locations[i].expanded) ;
 //        }
 //       }
 //  ,error =>this.errorMessage=<any>error) ;
 //  //this.cities=this.countryService.getCities(this) ;
 // }
 // getIcon(){
 //
 //  // console.log("i am being called") ;
 //  if(this.expanded){
 //   return '-';
 //  }
 //
 //  return '+';
 // }


}