import { Coordinate } from "../util/coordinate";

export class Chair{
  private topLeftPoint: Coordinate;
  private angle: number;
  private deskId: number;
  private brid: string;
  
  constructor(topLeftPoint: Coordinate, angle: number, deskId: number, brid: string) {
        this.topLeftPoint = topLeftPoint;
        this.angle = angle;
        this.deskId = deskId;
        this.brid = brid;
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