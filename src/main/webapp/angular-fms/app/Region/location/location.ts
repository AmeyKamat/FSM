import {City} from "../city/city";
import {Level} from '../floor/level' ;
export class Location{
    name:String ;
    levels:Level[] ;
    city:City ;
    id:number ;
    // errorMessage:String ;
    //  expanded:boolean ;
    //
    // constructor(private locationService:LocationService){
    //
    // }
    // toggle()
    // {
    //     this.expanded = !this.expanded;
    //     if(this.expanded==true)
    //     {
    //         this.getFloors();
    //     }
    // }
    // getFloors()
    // {
    //
    //     this.locationService.getFloors(this).
    //     subscribe((floors) =>
    //     {
    //         this.levels=floors ;
    //
    //     },error =>this.errorMessage=<any>error) ;
    //     //this.cities=this.countryService.getCities(this) ;
    // }
    // getIcon(){
    //
    //     // console.log("i am being called") ;
    //     if(this.expanded){
    //         return '-';
    //     }
    //
    //     return '+';
    // }
}