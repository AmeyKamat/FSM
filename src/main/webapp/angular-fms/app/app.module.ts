import { NgModule }      from '@angular/core';
import {BrowserModule} from "@angular/platform-browser";
import { HttpModule }    from '@angular/http'
import {  ReactiveFormsModule } from '@angular/forms'
import {AppComponent} from "./app.component";
@NgModule({
    imports: [ BrowserModule ],
    declarations: [
        AppComponent
    ],
    providers: [],
    bootstrap: [ AppComponent ]
})
export class AppModule { }