import { Injectable } from '@angular/core';

import { UtilService } from '../util/util.service';

import { Table } from "../table/table";
import { Chair } from "../chair/chair";

import { Coordinate } from "../coordinate/coordinate";
import { Orientation } from "../util/orientation";

@Injectable()
export class TableService {
  private utilService: UtilService;
  
  constructor(utilService: UtilService) {
        this.utilService = utilService;
  }
  
  public getChair(table: Table, chairJSONString: string): Chair {
    let chairJSON: any = JSON.parse(chairJSONString);
    
    let topLeftPoint: Coordinate = new Coordinate(
                                        this.getAboluteX(table, chairJSON.row, chairJSON.column), 
                                        this.getAboluteY(table, chairJSON.row, chairJSON.column)
    );
    let chairId = chairJSON.chairId;
    let angle = this.getChairAngle(table.getOrientation(), chairJSON.row);
    
    return new Chair(topLeftPoint, angle, chairId, "");
  }
   
  private getAboluteX(table: Table, row: number, column: number): number{
    let calculatedX = number;
    if(table.getOrientation() == Orientation.Horizontal){
      calculatedX = table.getLeftTopPoint().getX();
      
      let noOfChairsInThisRow = table.getChairsInRow[row]
      let padding = (table.getLength() - this.utilService.GRIDS_PER_CHAIR*noOfChairsInThisRow)/(2*noOfChairsInThisRow)
      calculatedX += padding + 2*(column-1)*padding;
    }
    else if(table.getOrientation() == Orientation.Vertical){
      calculatedX = table.getLeftTopPoint().getX();
      
      if(row == 2){
        calculatedX += table.getWidth();
      }
    }
    return calculatedX;
  }
  
  private getAboluteY(table: Table, row: number, column: number): number{
    let calculatedY = number;
    if(table.getOrientation() == Orientation.Horizontal){
      calculatedY = table.getLeftTopPoint().getY();
      
      if(row == 2){
        calculatedY += table.getWidth();
      }
    }
    else if(table.getOrientation() == Orientation.Vertical){
      calculatedY = table.getLeftTopPoint().getY();
      
      let noOfChairsInThisRow = table.getChairsInRow[row]
      let padding = (table.getWidth() - this.utilService.GRIDS_PER_CHAIR*noOfChairsInThisRow)/(2*noOfChairsInThisRow)
      calculatedX += padding + 2*(column-1)*padding;
    }
    return calculatedX;
  }
  
  private getChairAngle(orientation: Orientation, row: number): number{
    let angle: number;
    if(orientation == Orientation.Horizontal && row == 1){
      angle = 0;
    }
    else if(orientation == Orientation.Horizontal && row == 2){
    var angle = 180;
    }
    else if(orientation == Orientation.Vertical && row == 1){
      var angle = 270;
    }
    else if(orientation == Orientation.Vertical && row == 2){
      var angle = 90;
    }

    return angle;
  }
}