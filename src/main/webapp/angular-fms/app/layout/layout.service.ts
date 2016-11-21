import {Injectable} from "@angular/core";
import {FloorService} from "../floor/floor.service";
import {TableService} from "../table/table.service";
import {ChairService} from "../chair/chair.service";
import {Floor} from "../floor/floor";
import {Table} from "../table/table";
import {Chair} from "../chair/chair";
import {DataFetchService} from "../util/data-fetch.service";
import {Observable} from "rxjs";

Injectable()
export class LayoutService{
    public floor:Floor;
    public tables:Table[]=[];
    public chairs:Chair[]=[];
    constructor(
        private floorService:FloorService,
        private  tableService:TableService,
        private chairService:ChairService,
        private dataFetchService:DataFetchService
    ){}
    getLayoutData(floorID:number):Observable<any>{
        return this.dataFetchService.getLayoutData(floorID);
    }
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
}