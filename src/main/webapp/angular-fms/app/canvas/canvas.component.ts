import {Component, OnInit, ElementRef, AfterViewInit} from "@angular/core";
import {ViewChild} from "@angular/core/src/metadata/di";

declare var fabric:any;

@Component({
    moduleId:module.id,
    selector:'canvas',
    templateUrl:'canvas.component.html',
    styleUrls: ['canvas.component.css',
                'treeview-canvas.component.css']
})
export class CanvasComponent implements OnInit,AfterViewInit{

    @ViewChild('canvasZoomElement') canvasZoomElement: ElementRef;
    private canvas = new fabric.Canvas('workarea', {selection: false, defaultCursor: "move"});
    panning:Boolean = false;

    ngOnInit():void{
        this.resizeCanvas();
        this.canvas.on('mouse:up', function (e) {
            this.panning = false;
        });
        this.canvas.on('mouse:down', function (e) {
            this.panning = true;
        });
        this.canvas.on('mouse:move', function(e) {
            if (this.panning && e && e.e) {
                var delta = new fabric.Point(e.e.movementX, e.e.movementY);
                this.canvas.relativePan(delta);
            }
        });
    }
    ngAfterViewInit(): void {
        var canvasZoomElement = this.canvasZoomElement.nativeElement;
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
    var evt = window.event || e;
    var delta = (evt.detail)?(evt.detail*(-120)):(evt.wheelDelta);
    var curZoom = this.canvas.getZoom();
    var newZoom = curZoom + delta/4000;
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

}