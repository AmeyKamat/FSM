import {OnInit} from "@angular/core";
import {FloorService} from "../floor/floor.service";
import {TableService} from "../table/table.service";
import {LayoutDataService} from "./layout-data.service";
export class LayoutService implements OnInit{

constructor(
    private layoutDataService:LayoutDataService,
    private floorService:FloorService,
    private  tableService:TableService,
    private chairService:ChairService
){}
    ngOnInit(): void {

    }

}