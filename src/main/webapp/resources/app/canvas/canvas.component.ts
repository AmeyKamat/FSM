import {Component, Injectable, OnInit} from '@angular/core';
import {CanvasService} from "./canvas.service";

@Component({
    moduleId:module.id,
    selector:'my-canvas',
    templateUrl:'canvas.component.html',
})

@Injectable()
export class CanvasComponent implements OnInit{
    showPublish:boolean=false;
    showLoader:boolean=false;
    zoomValue:number=0.5;

    ngOnInit(): void {
        this.canvasService.initCanvas();
        this.canvasService.renderWelcomePage();
    }

    constructor( private canvasService:CanvasService) {
        this.canvasService.showPublishEmitter.subscribe((value)=>{this.showPublish=value;});
        this.canvasService.showLoaderEmitter.subscribe((value)=>{this.showLoader=value;});
    }

    zoomIn():void {
        this.zoomValue = this.zoomValue * 1.1;
        this.canvasService.setZoom(this.zoomValue);
    }
    zoomOut():void {
        this.zoomValue = this.zoomValue / 1.1
        this.canvasService.setZoom(this.zoomValue);
    }
    zoomReset():void {
        this.canvasService.setZoom(0.5);
    }

    zoom(e):void {
        let evt = window.event || e;
        let delta = (evt.detail)?(evt.detail*(-120)):(evt.wheelDelta);
        this.zoomValue = this.zoomValue + delta/4000;
        let x = e.offsetX;
        let y = e.offsetY;
        this.canvasService.zoomToPoint(x, y, this.zoomValue);
    }

    changeZoomLevel(value:number):void{
        this.canvasService.setZoom(value);
    }

    publishDecision(decision:boolean):void {
        this.canvasService.publishDecision(decision);
    }
}