import {Injectable} from "@angular/core";
import {UtilService} from "./util.service";
import {Http, Response, URLSearchParams, Headers} from "@angular/http";
import {City} from "../region/city/city";
import {Country} from "../region/country/country";
import {Level} from "../region/level/level";
import {Location} from "../region/location/location";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';

@Injectable()
export class DataService {
    headers: Headers;

    constructor(private http: Http,
                private utilService:UtilService
    ){
        this.headers = new Headers();
        this.headers.set('Content-Type', 'multipart/form-data');
    }

    getCountries():Observable<Country[]> {
        return this.http
            .get(`/controller/countries`)
            .map((response: Response) => <Country[]> response.json());
    }

    getCities(countryId: number):Observable<City[]> {
        return this.http
            .get(`/controller/countries/${countryId}/cities`)
            .map((response: Response) => <City[]> response.json());
    }

    getLocations(cityId:number):Observable<Location[]> {
        return this.http
            .get(`/controller/cities/${cityId}/locations`)
            .map((response: Response) => <Location[]> response.json());
    }
    getLevels(locationId:number):Observable<Level[]> {
        return this.http
            .get(`/controller/locations/${locationId}/floors`)
            .map((response: Response) => <Level[]> response.json());
    }
    getLayoutData(floorId:number): Observable<any> {
        return this.http
            .get(`${this.utilService.GET_LAYOUT_URL}/${floorId}`)
            .map((response: Response) => response.json());
    }

    postUploadData(formData:FormData):Observable<any> {
        return this.http
            .post("/controller/layoutFile/upload", formData, {
                headers : this.headers
            })
            .map((response: Response) => response.json());
    }
    saveUploadData(decision:boolean):void {
        let params = new URLSearchParams();
        params.set('decision', decision.toString());
        this.http
            .get(this.utilService.SAVE_UPLOAD_DATA_URL,{search : params});
    }
}