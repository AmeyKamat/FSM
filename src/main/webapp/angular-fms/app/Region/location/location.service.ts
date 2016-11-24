import {Http, URLSearchParams, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Location} from "./location";
import {Level} from '../floor/level' ;
import {Injectable} from "@angular/core";


@Injectable()
export class LocationService{


    constructor(private http:Http) {

    }
    getFloors(location:Location):Observable<Level[]>
    {
        let params = new URLSearchParams();
        params.set('name', location.name.toString());

        return this.http.get('', { search: params }).map((response: Response) => <Level[]> response.json());
        // return [new City("Pune",country,[]),new City("Pune",country,[])] ;

    }
}