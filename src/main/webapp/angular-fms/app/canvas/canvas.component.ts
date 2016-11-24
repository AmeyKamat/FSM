import {Component, ElementRef, AfterViewInit, ViewChild, Injectable, Renderer} from '@angular/core';
import {CanvasService} from "./canvas.service";
import {AppComponent} from "../app.component";

@Component({
    moduleId:module.id,
    selector:'canvas',
    templateUrl:'canvas.component.html',
    styleUrls: ['canvas.component.css']
})

@Injectable()
export class CanvasComponent implements AfterViewInit{

    constructor(private rd: Renderer, private canvasService:CanvasService){
    }

    @ViewChild('canvass') canvasZoomElement;
    ngAfterViewInit(): void {
        let canvasZoomElement = this.canvasZoomElement.nativeElement;
        /*this.rd.invokeElementMethod(this.canvasZoomElement.nativeElement,'method');*/
        if(canvasZoomElement.addEventListener){
            // IE9, Chrome, Safari, Opera
            canvasZoomElement.addEventListener("mousewheel", this.zoom, false);
            // Firefox
            canvasZoomElement.addEventListener("DOMMouseScroll", this.zoom, false);
        }
        else{
            // IE 6/7/8
            canvasZoomElement.attachEvent("onmousewheel", this.zoom);
        }
    }

    zoomIn():void{
        this.canvasService.zoomIn();
    }
    zoomOut():void{
        this.canvasService.zoomOut()
    }
    zoomReset():void{
        this.canvasService.zoomReset();
    }

    zoom(e):boolean{
    return this.canvasService.zoom(e);
    }
}