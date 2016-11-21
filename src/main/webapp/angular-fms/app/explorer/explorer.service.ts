import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Country} from "./country/country";
import {Response, Http} from "@angular/http";
import {DataFetchService} from "../util/data-fetch.service";
import {City} from "./city/city";

Injectable()
export class ExplorerService{
    constructor(private dataFetchService:DataFetchService){

    }

    getCountries():Observable<Country[]>{

        return this.dataFetchService.getCountries() ;
         // return this.http.get('').map((response: Response) => <Country[]> response.json());
 // retur[] ;

    }

}