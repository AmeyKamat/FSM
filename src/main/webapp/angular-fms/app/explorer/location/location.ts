import {City} from "../city/city";
import {LocationService} from "./location.service";
import {Floor} from '../floor/floor' ;
export class Location{
    name:String ;
    floors:Floor[] ;
    city:City ;
    errorMessage:String ;
     expanded:boolean ;

    constructor(private locationService:LocationService){

    }
    toggle()
    {
        this.expanded = !this.expanded;
        if(this.expanded==true)
        {
            this.getFloors();
        }
    }
    getFloors()
    {

        this.locationService.getFloors(this).
        subscribe((floors) =>
        {
            this.floors=floors ;

        },error =>this.errorMessage=<any>error) ;
        //this.cities=this.countryService.getCities(this) ;
    }
    getIcon(){

        // console.log("i am being called") ;
        if(this.expanded){
            return '-';
        }

        return '+';
    }
}