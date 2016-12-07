import {Injectable} from "@angular/core";
import {FloorService} from "../floor/floor.service";
import {TableService} from "../table/table.service";
import {ChairService} from "../chair/chair.service";
import {Floor} from "../floor/floor";
import {Table} from "../table/table";
import {Chair} from "../chair/chair";
import {Layout} from "./layout";

@Injectable()
export class LayoutService{

    constructor(
        private floorService:FloorService,
        private tableService:TableService,
        private chairService:ChairService,
    ){}

    getLayout(layoutData:any): Layout {
        let floor:Floor = this.floorService.getFloor(layoutData);
        let tables:Table[]=[];
        let chairs:Chair[]=[];
        let tableList= layoutData.tables;
        for(let tableData of tableList){
            let table = this.tableService.getTable(tableData);
            tables.push(table);
            let deskList = tableData.desks;
            for(let deskData of deskList){
                let chair = this.chairService.getChair(table, deskData);
                chairs.push(chair);
            }
        }
        return new Layout(floor, tables, chairs);
    }
}