import {Injectable} from "@angular/core";
import {UtilService} from "./util.service";
import {Http, Response, URLSearchParams} from "@angular/http";
import {City} from "../region/city/city";
import {Country} from "../region/country/country";
import {Level} from "../region/level/level";
import {Location} from "../region/location/location";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';

@Injectable()
export class DataService {

    constructor(private http: Http,
                private utilService:UtilService
    ){}

    getLayoutData(floorId:number): Observable<any> {
        let params = new URLSearchParams();
        params.set('floorId', floorId.toString());
        return this.http
            .get(this.utilService.GET_LAYOUT_URL,{search : params})
            .map((res: Response) => res.json());
    }

    getCountries():Observable<Country[]> {
        return this.http
            .get(this.utilService.GET_COUNTRY_URL)
            .map((response: Response) => <Country[]> response.json());
    }

    getCities():Observable<City[]> {
        return this.http
            .get(this.utilService.GET_CITY_URL)
            .map((response: Response) => <City[]> response.json());
    }

    getLocations():Observable<Location[]> {
        return this.http
            .get(this.utilService.GET_LOCATION_URL)
            .map((response: Response) => <Location[]> response.json());
    }
    getLevels():Observable<Level[]> {
        return this.http
            .get(this.utilService.GET_LEVEL_URL)
            .map((response: Response) => <Level[]> response.json());
    }
}