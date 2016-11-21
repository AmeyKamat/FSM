import {Injectable} from "@angular/core";
import {FloorService} from "../floor/floor.service";
import {TableService} from "../table/table.service";
import {ChairService} from "../chair/chair.service";
import {Floor} from "../floor/floor";
import {Table} from "../table/table";
import {Chair} from "../chair/chair";
import {CanvasService} from "../canvas/canvas.service";

@Injectable()
export class LayoutService{
    public floor:Floor;
    public tables:Table[]=[];
    public chairs:Chair[]=[];
    constructor(
        private floorService:FloorService,
        private  tableService:TableService,
        private chairService:ChairService,
        private canvasService:CanvasService
    ){}

    loadLayoutData(layoutData:any): void {
        this.floor = this.floorService.getFloor(layoutData);
        let tableList= layoutData.tables;
        for(let table of tableList){
            let newTable = this.tableService.getTable(table);
            this.tables.push(newTable);
            let deskList = table.desks;
            for(let desk of deskList){
                let newChair = this.chairService.getChair(table, desk);
                this.chairs.push(newChair);
            }
        }
    }
    drawLayout():void{
        this.canvasService.initCanvas();
        for(let table of this.tables) {
            this.canvasService.drawTable(table);
        }
        for(let chair of this.chairs){
            this.canvasService.drawChair(chair);
        }
    }
}