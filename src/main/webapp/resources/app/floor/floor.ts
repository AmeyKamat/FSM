import {Coordinate} from "../util/coordinate";

export class Floor{

    private leftTopPoint:Coordinate ;
    private height:number ;
    private width:number ;

    constructor(leftTopPoint:Coordinate, height:number, width:number){
        this.leftTopPoint=leftTopPoint;
        this.height=height;
        this.width=width;
    }

    getLeftTopPoint(): Coordinate {
        return this.leftTopPoint;
    }
    getHeight(): number {
        return this.height;
    }
    getWidth(): number {
        return this.width;
    }
}