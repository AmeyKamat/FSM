import {Floor} from "../floor/floor";
import {Table} from "../table/table";
import {Chair} from "../chair/chair";
export class Layout{
    private floor:Floor;
    private tables:Table[];
    private chairs:Chair[];

    constructor(floor:Floor, tables:Table[],chairs:Chair[]){
        this.floor=floor;
        this.tables=tables;
        this.chairs=chairs;
    }

    getFloor(): Floor {
        return this.floor;
    }

    getTables(): Table[] {
        return this.tables;
    }

    getChairs(): Chair[] {
        return this.chairs;
    }
}