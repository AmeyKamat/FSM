import {NgModule} from "@angular/core" ;
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {UploadService} from "./upload/upload.service";
import {UploadComponent} from "./upload/upload.component";
import {FormsModule }    from '@angular/forms';
import {ReactiveFormsModule } from '@angular/forms';
import {AppRoutingModule} from "./app-routing.module";
import {HttpModule} from "@angular/http";
import {ExplorerComponent} from "./explorer/explorer.component";
import {CommonModule} from "@angular/common";
import {CountryService} from "./explorer/country/country.service";
import {CityService} from "./explorer/city/cityService";
import {LocationService} from "./explorer/location/location.service";
import {UtilService} from "./util/util.service";
import {DataFetchService} from "./util/data-fetch.service";
import {CanvasService} from "./canvas/canvas.service";
import {ExplorerService} from "./explorer/explorer.service";
import {FloorService} from "./floor/floor.service";
import {ChairService} from "./chair/chair.service";
import {TableService} from "./table/table.service";
import {LayoutService} from "./layout/layout.service";
import {CanvasComponent} from "./canvas/canvas.component";
@NgModule({
    imports: [ BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule,
        CommonModule,
        HttpModule
         ],
    declarations: [
        AppComponent,
        UploadComponent,
        ExplorerComponent,
        CanvasComponent
    ],
    providers:[UploadService,
        // Http,
        ExplorerService,
        CountryService,
        CityService,
        LocationService,
        UtilService,
        DataFetchService,
        CanvasService,
        FloorService,
        ChairService,
        TableService,
        LayoutService
    ],
    bootstrap: [ AppComponent ],
})
export class AppModule { }