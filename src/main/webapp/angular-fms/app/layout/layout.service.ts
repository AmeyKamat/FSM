import {OnInit} from "@angular/core";
import {FloorService} from "../floor/floor.service";
import {TableService} from "../table/table.service";
import {LayoutDataService} from "./layout-data.service";
import {Floor} from "../floor/floor";
import {Table} from "../table/table";
import {Chair} from "../chair/chair";
export class LayoutService implements OnInit{
    public floor:Floor;
    public tables:Table[]=[];
    public chair:Chair;
constructor(
    private layoutDataService:LayoutDataService,
    private floorService:FloorService,
    private  tableService:TableService,
    private chairService:ChairService
){}
    ngOnInit(): void {
        this.floor = this.floorService.getFloor(this.layoutDataService.floorJSON);

        let tableList=this.layoutDataService.tableJSON;
        for(let table of tableList){
            let newTable = this.tableService.getTable(table);
            this.tables.push(newTable);
        }

        this.chairService.getChair(this.layoutDataService.chairJSON);
    }

}