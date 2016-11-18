import { Injectable } from '@angular/core';

import { Table } from "../table/table";
import { Chair } from "../chair/chair";

import { Coordinate } from "../coordinate/coordinate";
import { Orientation } from "../util/orientation";

@Injectable()
export class TableService {
  public getTable(table: Table, chairJSONString: string): Chair {
    let chairJSON: any = JSON.parse(chairJSONString);
    
    
    
    return new Table(topLeftPoint, width, length, orientation);
  }
   
  private getAboluteX(table: Table, row: number, column: number): number{
    let calculatedX = number;
    if(table.getOrientation() == Orientation.Horizontal){
      calculatedX = table.getLefTopPoint().getX();
      //TODO
    }
    return 0;
  }
  
  private getChairAngle(orientation: Orientation, deskRow: number): number{
    let angle: number;
    if(orientation == Orientation.Horizontal && deskRow == 1){
      angle = 0;
    }
    else if(orientation == Orientation.Horizontal && deskRow == 2){
    var angle = 180;
    }
    else if(orientation == Orientation.Vertical && deskRow == 1){
      var angle = 270;
    }
    else if(orientation == Orientation.Vertical && deskRow == 2){
      var angle = 90;
    }

    return angle;
  }
}