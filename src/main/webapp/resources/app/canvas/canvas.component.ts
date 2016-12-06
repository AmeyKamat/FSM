import {Component, Injectable, OnInit} from '@angular/core';
import {CanvasService} from "./canvas.service";

@Component({
    moduleId:module.id,
    selector:'my-canvas',
    templateUrl:'canvas.component.html',
})

@Injectable()
export class CanvasComponent implements OnInit{
    showPublish:boolean;
    subscription:any;
    ngOnInit(): void {
        this.canvasService.initCanvas();
        this.canvasService.renderWelcomePage();
    }

    constructor( private canvasService:CanvasService) {
        this.showPublish = canvasService.showPublish;
        this.subscription = this.canvasService.showPublishEmitter.subscribe((value)=>{this.showPublish=value;
        });
    }

    zoomIn():void {
        this.canvasService.zoomIn();
    }
    zoomOut():void {
        this.canvasService.zoomOut()
    }
    zoomReset():void {
        this.canvasService.zoomReset();
    }

    zoom(e):boolean {
    return this.canvasService.zoom(e);
    }

    publishDecision(decision:boolean):void {
        this.canvasService.publishDecision(decision);
    }
}