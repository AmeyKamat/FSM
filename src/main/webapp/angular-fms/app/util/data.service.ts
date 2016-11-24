import {Injectable} from "@angular/core";
import {UtilService} from "./util.service";
import {Http, Response, URLSearchParams} from "@angular/http";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map' ;
import {City} from "../Region/city/city";
import {Country} from "../Region/country/country";
import {Level} from "../Region/floor/level";
import {Location} from "../Region/location/location";

@Injectable()
export class DataService {

    constructor(private http: Http,
                private utilService:UtilService
    ){}

    getLayoutData(floorID:number): Observable<any> {
        let params = new URLSearchParams();
        params.set('floorID', floorID.toString());
        return this.http
            .get(this.utilService.GET_LAYOUT_URL,{search : params})
            .map((res: Response) => res.json());
    }

    getCountries():Observable<Country[]>{
        return this.http.get('http://localhost:8080/rest/countries').map((response: Response) => <Country[]> response.json());
    }

    getCities():Observable<City[]> {
        return this.http.get('http://localhost:8080/rest/countries').map((response: Response) => <City[]> response.json());
    }

    getLocations():Observable<Location[]>{
        return this.http.get('http://localhost:8080/rest/countries').map((response: Response) => <Location[]> response.json());
    }
    getLevels():Observable<Level[]>{
        return this.http.get('http://localhost:8080/rest/countries').map((response: Response) => <Level[]> response.json());
    }
}