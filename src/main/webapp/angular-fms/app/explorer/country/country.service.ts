import {Http, URLSearchParams, Response} from "@angular/http";
import {Observable} from "rxjs";
import {City} from "../city/city";
import {Country} from "./country";
import {Injectable} from "@angular/core";
@Injectable()
export class CountryService{


    constructor(private http:Http) {

    }
    getCities(country:Country):Observable<City[]>
    {
        let params = new URLSearchParams();
        params.set('id', country.id.toString());

         return this.http.get('', { search: params }).map((response: Response) => <City[]> response.json());
    // return [new City("Pune",country,[]),new City("Pune",country,[])] ;

    }
}