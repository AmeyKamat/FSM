import { Coordinate } from "../util/coordinate";
import { Orientation } from "../util/orientation";

export class Table{
    private leftTopPoint: Coordinate;
    private length: number;
    private width: number;
    private chairsInRow: number[];
    private orientation: Orientation;
    
    constructor(leftTopPoint: Coordinate, length: number, width: number, chairsInRow: number[], orientation: Orientation) {
        this.leftTopPoint = leftTopPoint;
        this.length = length;
        this.width = width;
        this.chairsInRow = chairsInRow;
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
  
    getChairsInRow(): number[]{
      return this.chairsInRow;
    }
  
    getOrientation(): Orientation{
      return this.orientation;
    }
}
