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
    private customHeaders = new Headers();

    constructor(private http: Http, private utilService:UtilService){
        this.getAuthTokenHeaders()
            .subscribe((customHeaders) => {
                this.customHeaders = customHeaders;
            });
    }

    getCountries():Observable<Country[]> {
        return this.http
            .get(`/countries`)
            .map((response: Response) => <Country[]> response.json());
    }

    getCities(countryId: number):Observable<City[]> {
        return this.http
            .get(`/countries/${countryId}/cities`)
            .map((response: Response) => <City[]> response.json());
    }

    getLocations(cityId:number):Observable<Location[]> {
        return this.http
            .get(`/cities/${cityId}/locations`)
            .map((response: Response) => <Location[]> response.json());
    }
    getLevels(locationId:number):Observable<Level[]> {
        return this.http
            .get(`/locations/${locationId}/floors`)
            .map((response: Response) => <Level[]> response.json());
    }

    getPlanExistStatus(floorId:number): Observable<boolean>{
        return this.http
            .get(`/floors/${floorId}/doesPlanExist`)
            .map((response:Response)=> <boolean> response.json() );
    }
    getLayoutData(floorId:number): Observable<any> {
        return this.http
            .get(`/floors/${floorId}`)
            .map((response: Response) => response.json());
    }

    getAuthToken():Observable<any> {
        return this.http
            .get("/csrfToken")
            .map((response: Response) =>response.json());
    }

    getAuthTokenHeaders(): Observable<any> {
        return this.getAuthToken()
            .map((csrfToken) => {
                let headerName = csrfToken.headerName;
                let token = csrfToken.token;
                let customHeaders = new Headers();
                customHeaders.append(headerName, token);
                return customHeaders;
            });
    }

    postUploadData(formData:FormData):Observable<any> {
        return this.http
            .post("/layoutFile/upload", formData, {headers: this.customHeaders})
            .map((response: Response) => {
                return response.json();
            });
    }

    saveUploadData(decision:boolean):void {
        let params = new URLSearchParams();
        params.append('toBePublished', decision.toString());
        this.http
            .post("/layoutFile/publish", params, {
                headers : this.customHeaders
            })
            .subscribe(()=>{
            });
    }
}