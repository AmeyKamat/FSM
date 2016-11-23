import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Country} from "./country/country";
import {Response, Http} from "@angular/http";
import {DataFetchService} from "../util/data-fetch.service";
import {City} from "./city/city";

@Injectable()
export class ExplorerService{
    constructor(private dataFetchService:DataFetchService,private http:Http){

    }

    getCountries():Observable<Country[]>{

          return this.dataFetchService.getCountries() ;
        // return this.http.get('http://localhost:8080/rest/countries').map((response: Response) => <Country[]> response.json());

        //  return this.http.get('').map((response: Response) => <Country[]> response.json());
 // retur[] ;

    }

    getCities():Observable<City[]>{

        return this.dataFetchService.getCities() ;

    }

}