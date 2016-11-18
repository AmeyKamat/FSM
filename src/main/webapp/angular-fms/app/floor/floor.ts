import {Coordinate} from "../coordinate/coordinate";

export class Floor{

    private leftTopPoint:Coordinate ;
    private height:number ;
    private width:number ;

    constructor(leftTopPoint:Coordinate, height:number, width:number){
        this.leftTopPoint=leftTopPoint;
        this.height=height;
        this.width=width;
    }

    get leftTopPoint(): Coordinate {
        return this.leftTopPoint;
    }
    get height(): number {
        return this.height;
    }
    get width(): number {
        return this.width;
    }
}