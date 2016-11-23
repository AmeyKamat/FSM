import {NgModule} from "@angular/core" ;
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule }    from '@angular/forms';
import {ReactiveFormsModule } from '@angular/forms';
import {AppRoutingModule} from "./app-routing.module";
import {HttpModule} from "@angular/http";
import {CommonModule} from "@angular/common";
import {AppComponent} from "./app.component";
import {UploadComponent} from "./upload/upload.component";
import {ExplorerComponent} from "./explorer/explorer.component";
import {CanvasComponent} from "./canvas/canvas.component";
import {UploadService} from "./upload/upload.service";
import {ExplorerService} from "./explorer/explorer.service";
import {CanvasService} from "./canvas/canvas.service";
import {CountryService} from "./explorer/country/country.service";
import {CityService} from "./explorer/city/cityService";
import {LocationService} from "./explorer/location/location.service";
import {UtilService} from "./util/util.service";
import {DataFetchService} from "./util/data.service";
import {FloorService} from "./floor/floor.service";
import {ChairService} from "./chair/chair.service";
import {TableService} from "./table/table.service";
import {LayoutService} from "./layout/layout.service";

@NgModule({
    imports: [ BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule,
        HttpModule,
        CommonModule
         ],
    declarations: [
        AppComponent,
        UploadComponent,
        ExplorerComponent,
        CanvasComponent
    ],
    providers:[UploadService,
        ExplorerService,
        CanvasService,
        CountryService,
        CityService,
        LocationService,
        UtilService,
        DataFetchService,
        FloorService,
        ChairService,
        TableService,
        LayoutService
    ],
    bootstrap: [ AppComponent ],
})
export class AppModule { }