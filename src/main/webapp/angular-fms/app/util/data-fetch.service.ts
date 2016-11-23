import {Injectable, OnInit} from "@angular/core";
import {UtilService} from "./util.service";
import {Http, Response, URLSearchParams} from "@angular/http";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map' ;


import {Country} from "../explorer/country/country";
import {City} from "../explorer/city/city";

@Injectable()
export class DataFetchService {

    constructor(private http: Http,
                private utilService:UtilService
    ){}

    getLayoutData(floorID:number): Observable<any> {
        let params = new URLSearchParams();
        params.set('floorID', floorID.toString());


        return this.http
            .get(this.utilService.GET_LAYOUT_URL,{search : params})
            .map((res: Response) => res.json());
           /* .subscribe(result=> this.floorJSON= result);*/

       // this.tableJSON= this.floorJSON.tableList;
    }
    getCountries():Observable<Country[]>{

        return this.http.get('http://localhost:8080/rest/countries').map((response: Response) => <Country[]> response.json());
// return [new City("Pune",country,[]),new City("Pune",country,[])] ;

    }
    getCities():Observable<City[]>{

        return this.http.get('http://localhost:8080/rest/countries').map((response: Response) => <City[]> response.json());
// return [new City("Pune",country,[]),new City("Pune",country,[])] ;

    }

}