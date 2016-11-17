import { NgModule }      from '@angular/core';
import {BrowserModule} from "@angular/platform-browser";
import { HttpModule }    from '@angular/http'
import {  ReactiveFormsModule } from '@angular/forms'
import {AppComponent} from "./app.component";
import {UtilService} from "./util/util.service";
@NgModule({
    imports: [ BrowserModule ],
    declarations: [
        AppComponent
    ],
    providers: [UtilService],
    bootstrap: [ AppComponent ]
})
export class AppModule { }