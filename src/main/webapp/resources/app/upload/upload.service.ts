import {Headers} from "@angular/http";
import {FormGroup} from "@angular/forms";
import {Injectable} from "@angular/core";
import {Country} from "../region/country/country";
import {Observable} from "rxjs";
import {DataService} from "../util/data.service";
import {City} from "../region/city/city";
import {Location} from "../region/location/location";
import {Level} from "../region/level/level";
import {LayoutService} from "../layout/layout.service";
import {CanvasService} from "../canvas/canvas.service";
import {Layout} from "../layout/layout";

@Injectable()
export class UploadService{
    file: File;
    formData:FormData ;

    constructor( private dataService:DataService,
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

    setUploadFile(file:File){
        this.file=file;
    }

    acceptFormData(formGroup:FormGroup):void {
        this.formData = new FormData();
        this.formData.append("name", "layout");
        this.formData.append("country",formGroup.get('country').value) ;
        this.formData.append("city",formGroup.get('city').value) ;
        this.formData.append("location",formGroup.get('location').value) ;
        this.formData.append("floorId",formGroup.get('floorId').value) ;
        this.formData.append("file",this.file);
        this.dataService.postUploadData(this.formData).
        subscribe((layoutData)=> {
            let layout:Layout = this.layoutService.getLayout(layoutData);
            this.canvasService.showPublishToggle();
            this.canvasService.renderLayout(layout);
        });
    }
    /*/* Need bug fixing after which it will replace above code
    acceptFormData(formData:FormData):void {
        console.log(formData);
        this.dataService.postUploadData(formData).
        subscribe((layoutData)=> {
            let layout:Layout = this.layoutService.getLayout(layoutData);
            this.canvasService.showPublish = true;
            this.canvasService.renderLayout(layout);
        });
    }*/
}
