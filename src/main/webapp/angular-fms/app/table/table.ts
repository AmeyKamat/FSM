import { Coordinate } from "../coordinate/coordinate";
import { Orientation } from "../util/orientation";


export class Table{
    private leftTopPoint: Coordinate;
    private length: number;
    private width: number;
    private orientation: Orientation;
    
    constructor(leftTopPoint: Coordinate, length: number, width: number, orientation: Orientation) {
        this.leftTopPoint = leftTopPoint;
        this.length = length;
        this.width = width;
        this.orientation = orientation;
    }
  
    getLeftTopPoint(): Coordinate {
      return this.leftTopPoint;
    }
  
    getLength(): number {
      return this.length;
    }
  
    getWidth(): number{
      return this.width;
    }
  
    getOrientation(): Orientation{
      return this.orientation;
    }
}