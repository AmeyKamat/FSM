import {Injectable, OnInit} from "@angular/core";
import {UtilService} from "./util.service";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Floor} from "../floor/floor";

@Injectable()
export class DataFetchService {

    constructor(private http: Http,
                private utilService:UtilService
    ){}

    getFloorData(floorID:number): Observable<any> {
        return this.http
            .get(this.utilService.GET_LAYOUT_URL)
            .map((res: Response) => res.json());
           /* .subscribe(result=> this.floorJSON= result);*/

       // this.tableJSON= this.floorJSON.tableList;
    }
}