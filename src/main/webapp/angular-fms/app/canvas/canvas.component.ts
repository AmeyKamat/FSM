import {Component, OnInit, ElementRef, AfterViewInit} from "@angular/core";
import {ViewChild} from "@angular/core/src/metadata/di";
import {UtilService} from "../util/util.service";

declare var fabric:any;

@Component({
    moduleId:module.id,
    selector:'canvas',
    templateUrl:'canvas.component.html',
    styleUrls: ['canvas.component.css',
                'treeview-canvas.component.css']
})
export class CanvasComponent implements OnInit,AfterViewInit{

    constructor(private utilService:UtilService){

    }
    @ViewChild('canvasZoomElement') canvasZoomElement: ElementRef;
    private canvas:any;
    panning:Boolean = false;

    ngOnInit():void{
        this.canvas = new fabric.Canvas('workarea', {selection: false, defaultCursor: "move"});
        this.resizeCanvas();
        this.canvas.on('mouse:up', (e)=> this.panning = false);
        this.canvas.on('mouse:down',(e)=> this.panning = true);
        this.canvas.on('mouse:move', (e)=> {if (this.panning && e && e.e) {
                let delta = new fabric.Point(e.e.movementX, e.e.movementY);
                this.canvas.relativePan(delta);
            }
        });
    }
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
    this.canvas.setZoom(this.canvas.getZoom()*1.1) ;
}
    zoomOut():void{
    this.canvas.setZoom(this.canvas.getZoom()/1.1) ;
}
    zoomReset():void{
    this.canvas.setZoom(1);
}

    /*changeZoomLevel():void{
     this.canvas.setZoom(1);
     var value=(50-this.value)/100;
     if (value < 0)
     {
     canvas.setZoom(canvas.getZoom() * (1 - value ));
     }
     else {
     canvas.setZoom(canvas.getZoom() / (1 + value));
     }
     }*/

    zoom(e):Boolean{
    console.log("zoom")
    let evt = window.event || e;
    let delta = (evt.detail)?(evt.detail*(-120)):(evt.wheelDelta);
    let curZoom = this.canvas.getZoom();
    let newZoom = curZoom + delta/4000;
    var x = e.offsetX, y = e.offsetY;
    //applying zoom values.
    this.canvas.zoomToPoint({x: x, y: y}, newZoom);
    if(e != null){
        e.preventDefault();
    }
    return false;
}

    resizeCanvas():void{
        this.canvas.setHeight(window.innerHeight);
        this.canvas.setWidth(window.innerWidth);

    }

    drawTable():void{
    fabric.util.loadImage(this.utilService.IMG_PATH + this.utilService.TABLE_PATTERN_FILE, (img)=>{
        this.canvas.add(new fabric.Rect({
            left: x*ENV.gridSize,
            top: y*ENV.gridSize,
            width: width*ENV.gridSize,
            height: height*ENV.gridSize,
            fill: '#9f9',
            originX: 'left',
            originY: 'top',
            rx : ENV.tableBorderRadiusRatio*ENV.gridSize,
            ry: ENV.tableBorderRadiusRatio*ENV.gridSize,
            hasControls: false,
            selectable: false,
            fill: new fabric.Pattern({source:img}),
            hoverCursor: 'move'
        }));
    });
    this.canvas.renderAll();
    console.log("Table Drawn")
};


}