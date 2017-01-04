import {Component, Injectable, OnInit} from '@angular/core';
import {CanvasService} from "../canvas/canvas.service";
import {Employee} from "../util/employee";
@Component({
    moduleId:module.id,
    selector:'my-tooltip',
    templateUrl:'tooltip.component.html',
})

@Injectable()
export class TooltipComponent implements OnInit{
    showTooltip:boolean=false;
    top:any;
    left:any;
    deskId:number;
    employee:Employee;

    constructor(private canvasService:CanvasService){
    }
    ngOnInit(): void {
        this.canvasService.showTooltipEmitter.subscribe((e)=>{
            this.showTooltip = true;
            this.deskId = e.target.deskid;
            this.employee = e.target.employee;
            e= e.e;
            this.left = (e.clientX + 20) + 'px';
            this.top = (e.clientY + 20) + 'px';
        });
        this.canvasService.hideTooltipEmitter.subscribe((value)=>{
            this.showTooltip = value;
        });
    }
}