import { Coordinate } from "../util/coordinate";
import {Employee} from "../util/employee";

export class Chair{
  private topLeftPoint: Coordinate;
  private angle: number;
  private deskId: number;
  private employee: Employee;
  
  constructor(topLeftPoint: Coordinate, angle: number, deskId: number, employee: Employee) {
        this.topLeftPoint = topLeftPoint;
        this.angle = angle;
        this.deskId = deskId;
        this.employee = employee;
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
  
  getEmployee(): Employee{
    return this.employee;
  }
}