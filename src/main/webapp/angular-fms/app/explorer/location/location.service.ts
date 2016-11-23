import {Http, URLSearchParams, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Location} from "./location";
import {Floor} from '../floor/floor' ;
import {Injectable} from "@angular/core";


@Injectable()
export class LocationService{


    constructor(private http:Http) {

    }
    getFloors(location:Location):Observable<Floor[]>
    {
        let params = new URLSearchParams();
        params.set('name', location.name.toString());

        return this.http.get('', { search: params }).map((response: Response) => <Floor[]> response.json());
        // return [new City("Pune",country,[]),new City("Pune",country,[])] ;

    }
}