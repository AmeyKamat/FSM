import {Coordinate} from "../util/coordinate";

export class Floor{

    private leftTopPoint:Coordinate ;
    private length:number ;
    private width:number ;

    constructor(leftTopPoint:Coordinate, length:number, width:number){
        this.leftTopPoint=leftTopPoint;
        this.length=length;
        this.width=width;
    }

    getLeftTopPoint(): Coordinate {
        return this.leftTopPoint;
    }
    getLength(): number {
        return this.length;
    }
    getWidth(): number {
        return this.width;
    }
}