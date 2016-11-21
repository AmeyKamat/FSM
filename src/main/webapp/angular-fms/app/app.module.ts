import {NgModule} from "@angular/core" ;
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {UploadService} from "./upload/upload.service";
import {UploadComponent} from "./upload/upload.component";
import { FormsModule }    from '@angular/forms';
import {  ReactiveFormsModule } from '@angular/forms';
import {AppRoutingModule} from "./app-routing.module";
import {Http} from "@angular/http";
import {ExplorerComponent} from "./explorer/explorer.component";
import {ExplorerService} from "./explorer/explorer.service";
import {CommonModule} from "@angular/common";
import {CountryService} from "./country/country.service";
import {CityService} from "./city/cityService";
import {LocationService} from "./location/location.service";

@NgModule({
    imports: [ BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule,
        CommonModule
         ],
    declarations: [
        AppComponent,
        UploadComponent,
        ExplorerComponent
    ],
    bootstrap: [ AppComponent ],
    providers:[UploadService,Http,ExplorerService,CountryService,CityService,LocationService]
})
export class AppModule { }