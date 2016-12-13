import {Component} from '@angular/core';
import {CanvasService} from "../canvas/canvas.service";
import {Employee} from "../employee/employee";
import {Coordinate} from "../util/coordinate";
@Component({
    moduleId:module.id,
    selector:'my-tooltip',
    templateUrl:'tooltip.component.html',
})
export class TooltipComponent{
    showTooltip:boolean=false;
    top:any;
    left:any;
    deskId:number;
    employee:Employee;

    constructor(private canvasService:CanvasService){
    this.canvasService.showTooltipEmitter.subscribe((e)=>{
        this.showTooltip = true;
        this.deskId = e.target.deskid;
        e= e.e;
        this.left = (e.clientX + 20) + 'px';
        this.top = (e.clientY + 20) + 'px';
    });
        this.canvasService.hideTooltipEmitter.subscribe((value)=>{
            this.showTooltip = value;
        });
    }
}