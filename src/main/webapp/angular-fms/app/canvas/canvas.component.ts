import {Component, OnInit, ElementRef, AfterViewInit, ViewChild} from '@angular/core';
import {CanvasService} from "./canvas.service";
import {LayoutService} from "../layout/layout.service";

@Component({
    moduleId:module.id,
    selector:'canvas',
    templateUrl:'canvas.component.html',
    styleUrls: ['canvas.component.css',
                'treeview-canvas.component.css']
})
export class CanvasComponent implements OnInit,AfterViewInit{

    constructor(private layoutService:LayoutService,
                private canvasService:CanvasService
                ){
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

    ngOnInit():void{
        this.canvasService.initCanvas();
        for(let table of this.layoutService.tables) {
            this.canvasService.drawTable(table);
        }
            for(let chair of this.layoutService.chairs){
                this.canvasService.drawChair(chair);
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

    zoom(e):Boolean{
    return this.canvasService.zoom(e);
    }
}