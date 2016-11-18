import { Coordinate } from "../coordinate/coordinate";

export class Chair{
  private topLeftPoint: Coordinate;
  private angle: number;
  private deskId: number;
  private brid: string;
  
  constructor(leftTopPoint: Coordinate, angle: number, deskId: number, brid: string) {
        this.leftTopPoint = leftTopPoint;
        this.length = length;
        this.width = width;
        this.orientation = orientation;
  }
  
  getTopLeftPoint(): Coordinate{
    return this.topLeftPoint;
  }
  
  getAngle(): number{
    return this.angle;
  }
  
  getDeskId(): number{
    return this.deskId;
  }
  
  getBrid(): string{
    return this.brid;
  }
}