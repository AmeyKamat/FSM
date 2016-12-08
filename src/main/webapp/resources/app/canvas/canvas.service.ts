import {Injectable} from "@angular/core";
import {Table} from "../table/table";
import {UtilService} from "../util/util.service";
import {Layout} from "../layout/layout";
import {DataService} from "../util/data.service";
import { Subject }    from 'rxjs/Subject';
import {Chair} from "../chair/chair";

declare var fabric:any;

@Injectable()
export class CanvasService{
    private canvas: any;

    showPublishEmitter: Subject<boolean> = new Subject<boolean>();
    showLoaderEmitter: Subject<boolean> = new Subject<boolean>();

    panning:boolean = false;

    constructor(private utilService:UtilService,
                private dataService:DataService){
    }

    initCanvas():void{
        this.canvas = new fabric.Canvas('workarea', {selection: false, defaultCursor: "move"});
        this.canvas.setHeight(window.innerHeight);
        this.canvas.setWidth(window.innerWidth);
        this.mouseUpEvent();
        this.mouseDownEvent();
        this.mouseMoveEvent();
        //this.setupFloor();
    }

    showPublishToggle(value:boolean):void{
        this.showPublishEmitter.next(value);
    }
    showLoaderToggle(value:boolean):void{
        this.showLoaderEmitter.next(value);
    }

    renderWelcomePage(){
        this.clearCanvas();
        fabric.Image.fromURL(this.utilService.IMG_PATH + this.utilService.WELCOME_SCREEN,
            (oImg)=> {
                oImg.set({
                    left: 500,
                    selectable:false,
                });
            this.canvas.add(oImg);
        });
    }
    mouseUpEvent():void{
        this.canvas.on('mouse:up', (e)=> this.panning = false);
    }
    mouseDownEvent():void{
        this.canvas.on('mouse:down',(e)=> this.panning = true);
    }
    mouseMoveEvent():void{
    this.canvas.on('mouse:move', (e)=> {if (this.panning && e && e.e) {
        let delta = new fabric.Point(e.e.movementX, e.e.movementY);
        this.canvas.relativePan(delta);
        }
        });
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
    zoom(e):boolean{
        let evt = window.event || e;
        let delta = (evt.detail)?(evt.detail*(-120)):(evt.wheelDelta);
        let curZoom = this.canvas.getZoom();
        let newZoom = curZoom + delta/4000;
        var x = e.offsetX, y = e.offsetY;
        this.canvas.zoomToPoint({x: x, y: y}, newZoom);
        if(e != null){
            e.preventDefault();
        }
        return false;
    }
    publishDecision(decision:boolean):void{
        this.showPublishToggle(false);
        this.renderWelcomePage();
        this.dataService.saveUploadData(decision);
    }

    changeZoomLevel(value:number):void{
        this.canvas.setZoom(value);
     }

    renderLayout(layout:Layout):void{
        this.clearCanvas();
        this.utilService.calculateGridSize(layout.getFloor());

        for(let table of layout.getTables()) {
            this.drawTable(table);
        }
        for(let chair of layout.getChairs()){
            this.drawChair(chair);
        }
        //this.canvas.renderAll();
    }

    clearCanvas():void{
        this.canvas.clear();
    }

    drawTable(table:Table):void{
    fabric.util.loadImage(this.utilService.IMG_PATH + this.utilService.TABLE_PATTERN_FILE, (img)=>{
    this.canvas.add(new fabric.Rect({
        left:table.getLeftTopPoint().getX()*this.utilService.GRID_SIZE ,
        top: table.getLeftTopPoint().getY()*this.utilService.GRID_SIZE ,
        width: table.getLength()*this.utilService.GRID_SIZE,
        height: table.getWidth()*this.utilService.GRID_SIZE,
        originX: 'left',
        originY: 'top',
        rx : this.utilService.TABLE_BORDER_RADIUS_RATIO*this.utilService.GRID_SIZE,
        ry: this.utilService.TABLE_BORDER_RADIUS_RATIO*this.utilService.GRID_SIZE,
        hasControls: false,
        selectable: false,
        fill: new fabric.Pattern({source:img}),
        hoverCursor: 'move'
        }));
    });
    //this.canvas.renderAll();
    }

    drawChair(chair: Chair):void{
        let seat = this.getChairSeat(chair);

        let leftArm = this.getLeftArm(chair);

        let rightArm = this.getRightArm(chair);

        let upperArm = this.getUpperArm(chair);

        let group = this.getChairGroup(chair, leftArm, rightArm, upperArm, seat);

        this.canvas.add(group);
    }

    private getChairSeat(chair: Chair): any{
        let mid = new fabric.Rect({
            left : chair.getTopLeftPoint().getX()*this.utilService.GRID_SIZE + 2*this.utilService.CHAIR_PADDING*this.utilService.GRID_SIZE + this.utilService.MIN_BLOCK_SIZE_RATIO*this.utilService.GRID_SIZE,
            top :  chair.getTopLeftPoint().getY()*this.utilService.GRID_SIZE + 2*this.utilService.CHAIR_PADDING*this.utilService.GRID_SIZE + this.utilService.MIN_BLOCK_SIZE_RATIO*this.utilService.GRID_SIZE,
            stroke : 'grey',
            width : this.utilService.GRID_SIZE - 4*this.utilService.CHAIR_PADDING*this.utilService.GRID_SIZE -2*this.utilService.MIN_BLOCK_SIZE_RATIO*this.utilService.GRID_SIZE,
            height : this.utilService.GRID_SIZE - 4*this.utilService.CHAIR_PADDING*this.utilService.GRID_SIZE -2*this.utilService.MIN_BLOCK_SIZE_RATIO*this.utilService.GRID_SIZE,
            rx : this.utilService.CHAIR_BORDER_RADIUS_RATIO*this.utilService.GRID_SIZE,
            ry : this.utilService.CHAIR_BORDER_RADIUS_RATIO*this.utilService.GRID_SIZE
        });
        return mid;
    }

    private getLeftArm(chair: Chair): any {
        let leftArm = new fabric.Rect({
            left : chair.getTopLeftPoint().getX()*this.utilService.GRID_SIZE + this.utilService.CHAIR_PADDING*this.utilService.GRID_SIZE,
            top :  chair.getTopLeftPoint().getY()*this.utilService.GRID_SIZE + 1/4*this.utilService.GRID_SIZE,
            stroke : 'grey',
            width : this.utilService.MIN_BLOCK_SIZE_RATIO*this.utilService.GRID_SIZE,
            height : 1/2*this.utilService.GRID_SIZE,
            rx : this.utilService.ARM_BORDER_RADIUS_RATIO*this.utilService.GRID_SIZE,
            ry : this.utilService.ARM_BORDER_RADIUS_RATIO*this.utilService.GRID_SIZE
        });

        return leftArm;
    }

    private getRightArm(chair: Chair): any{
        let rightArm = new fabric.Rect({
            left : chair.getTopLeftPoint().getX()*this.utilService.GRID_SIZE + this.utilService.GRID_SIZE - this.utilService.CHAIR_PADDING*this.utilService.GRID_SIZE - this.utilService.MIN_BLOCK_SIZE_RATIO*this.utilService.GRID_SIZE,
            top :  chair.getTopLeftPoint().getY()*this.utilService.GRID_SIZE + 1/4*this.utilService.GRID_SIZE,
            stroke : 'grey',
            width : this.utilService.MIN_BLOCK_SIZE_RATIO*this.utilService.GRID_SIZE,
            height : 1/2*this.utilService.GRID_SIZE,
            rx : this.utilService.ARM_BORDER_RADIUS_RATIO*this.utilService.GRID_SIZE,
            ry : this.utilService.ARM_BORDER_RADIUS_RATIO*this.utilService.GRID_SIZE
        });
        return rightArm;
    }

    private getUpperArm(chair: Chair): any{
        let upperArm = new fabric.Rect({
            left : chair.getTopLeftPoint().getX()*this.utilService.GRID_SIZE + 1/4*this.utilService.GRID_SIZE,
            top :  chair.getTopLeftPoint().getY()*this.utilService.GRID_SIZE + this.utilService.CHAIR_PADDING*this.utilService.GRID_SIZE,
            stroke : 'grey',
            width : 1/2*this.utilService.GRID_SIZE,
            height : this.utilService.MIN_BLOCK_SIZE_RATIO*this.utilService.GRID_SIZE,
            rx : 0,
            ry : 0
        });

        return upperArm;
    }

    private getChairGroup(chair: Chair, leftArm: any, rightArm: any, upperArm: any, seat: any): any{
        var group = new fabric.Group([leftArm,rightArm,seat,upperArm],{
            left : chair.getTopLeftPoint().getX()*this.utilService.GRID_SIZE + 1/2*this.utilService.GRID_SIZE,
            top  : chair.getTopLeftPoint().getY()*this.utilService.GRID_SIZE + 1/2*this.utilService.GRID_SIZE,
            originX : 'center',
            originY : 'center',
            selectable : false,
            angle : chair.getAngle(),
            fill: "#cccccc",
            entity : "chair",
            deskid: chair.getDeskId()
        });
        return group;
    }
}