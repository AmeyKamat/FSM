import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Country} from "./country/country";
import {DataFetchService} from "../util/data-fetch.service";

@Injectable()
export class ExplorerService{
    constructor(private dataFetchService:DataFetchService){
    }
    getLayoutData(floorID:number):Observable<any>{
        return this.dataFetchService.getLayoutData(floorID);
    }
    getCountries():Observable<Country[]>{
        return this.dataFetchService.getCountries() ;
         // return this.http.get('').map((response: Response) => <Country[]> response.json());
 // return[] ;
    }
}