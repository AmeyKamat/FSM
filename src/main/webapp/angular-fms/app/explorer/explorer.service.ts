import {Injectable} from "@angular/core";
import {FloorService} from "../floor/floor.service";
import {TableService} from "../table/table.service";
import {ChairService} from "../chair/chair.service";
import {Floor} from "../floor/floor";
import {Table} from "../table/table";
import {Chair} from "../chair/chair";
import {CanvasService} from "../canvas/canvas.service";
import {DataFetchService} from "../util/data-fetch.service";
import {Observable} from "rxjs";

Injectable()
export class ExplorerService{
    public floor:Floor;
    public tables:Table[]=[];
    public chairs:Chair[]=[];
    constructor(
        private floorService:FloorService,
        private  tableService:TableService,
        private chairService:ChairService,
        private dataFetchService:DataFetchService
    ){}
    getFloorData(floorID:number):Observable<any>{
        return this.dataFetchService.getFloorData(floorID);
    }
    loadFloorData(floorData:any): void {
        this.floor = this.floorService.getFloor(floorData);
        let tableList= floorData.tables;
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
    drawFloor(): void{
    }
}
