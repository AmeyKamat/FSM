import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Layout} from "../layout/layout";
import {DataService} from "../util/data.service";
import {LayoutService} from "../layout/layout.service";
import {CanvasService} from "../canvas/canvas.service";
import {Country} from "../region/country/country";
import {City} from "../region/city/city";
import {Level} from "../region/level/level";
import {Location} from "../region/location/location";

@Injectable()
export class ExplorerService {
    constructor(private dataService:DataService,
                private layoutService:LayoutService,
                private canvasService:CanvasService){
    }

    getCountries():Observable<Country[]> {
        return this.dataService.getCountries() ;
    }

    getCities(countryId:number):Observable<City[]> {
        return this.dataService.getCities(countryId) ;
    }

    getLocations(cityId:number):Observable<Location[]> {
        return this.dataService.getLocations(cityId) ;
    }

    getLevels(locationId:number):Observable<Level[]> {
        return this.dataService.getLevels(locationId) ;
    }

    drawLayout(floorId):void {
        this.dataService.getLayoutData(floorId).
        subscribe((layoutData)=> {
            let layout:Layout = this.layoutService.getLayout(layoutData);
            this.canvasService.showPublish = false;
            this.canvasService.renderLayout(layout);
        });
    }
}