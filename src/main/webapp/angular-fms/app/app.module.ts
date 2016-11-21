import { NgModule }      from '@angular/core';
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {UtilService} from "./util/util.service";
import {DataFetchService} from "./util/data-fetch.service";
import {CanvasService} from "./canvas/canvas.service";
import {ExplorerService} from "./explorer/explorer.service";
import {FloorService} from "./floor/floor.service";
import {ChairService} from "./chair/chair.service";
import {TableService} from "./table/table.service";
@NgModule({
    imports: [ BrowserModule ],
    declarations: [
        AppComponent,
    ],
    providers: [UtilService,
                DataFetchService,
                CanvasService,
                ExplorerService,
                UtilService,
                FloorService,
                ChairService,
                TableService
    ],
    bootstrap: [ AppComponent ]
})
export class AppModule { }