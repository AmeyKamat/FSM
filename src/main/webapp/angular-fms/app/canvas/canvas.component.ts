import {Component, ElementRef, AfterViewInit, ViewChild, Injectable} from '@angular/core';
import {CanvasService} from "./canvas.service";

@Component({
    moduleId:module.id,
    selector:'canvas',
    templateUrl:'canvas.component.html',
    styleUrls: ['canvas.component.css']
})

@Injectable()
export class CanvasComponent implements AfterViewInit{

    constructor(private canvasService:CanvasService){
    }

    @ViewChild('canvasZoomElement') canvasZoomElement: ElementRef;
    ngAfterViewInit(): void {
        let canvasZoomElement = this.canvasZoomElement.nativeElement;
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