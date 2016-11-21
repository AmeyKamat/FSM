import {Http, URLSearchParams, Response} from "@angular/http";
import {Observable} from "rxjs";
import {City} from "./city";
import {Location} from "../location/location"

import {Injectable} from "@angular/core";
@Injectable()
export class CityService{


    constructor(private http:Http) {

    }
    getLocations(city:City):Observable<Location[]>
    {
        let params = new URLSearchParams();
        params.set('name', city.name.toString());

        return this.http.get('', { search: params }).map((response: Response) => <Location[]> response.json());
        // return [new City("Pune",country,[]),new City("Pune",country,[])] ;

    }
}