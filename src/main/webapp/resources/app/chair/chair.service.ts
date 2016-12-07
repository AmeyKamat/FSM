import { Injectable } from '@angular/core';

import { UtilService } from '../util/util.service';

import { Table } from "../table/table";
import { Chair } from "../chair/chair";

import { Coordinate } from "../util/coordinate";
import { Orientation } from "../util/orientation";

@Injectable()
export class ChairService {

  constructor(private utilService: UtilService) {
  }

  public getChair(table: Table, chairJSON: any): Chair {

    let topLeftPoint: Coordinate = new Coordinate(
        this.getAbsoluteX(table, chairJSON.tableRow, chairJSON.tableCol),
        this.getAbsoluteY(table, chairJSON.tableRow, chairJSON.tableCol)
    );
    let chairId = chairJSON.deskCode;
    let angle = this.getChairAngle(table.getOrientation(), chairJSON.tableRow, chairJSON.tableCol);

    return new Chair(topLeftPoint, angle, chairId, "");
  }

  private getAbsoluteX(table: Table, row: number, column: number): number{
    let calculatedX: number;
    if(table.getOrientation() == Orientation.Horizontal){
      calculatedX = table.getLeftTopPoint().getX();

      let noOfChairsInThisRow = table.getChairsInRow()[row-1];
      let padding = (table.getLength() - this.utilService.GRIDS_PER_CHAIR*noOfChairsInThisRow)/(2*noOfChairsInThisRow);
      console.log("table.getLength: " + table.getLength() + " this.utilService.GRID_PER_CHAIR: " + this.utilService.GRIDS_PER_CHAIR + " noOfChairsInThisRow: " + noOfChairsInThisRow);
      calculatedX += padding + 2*(column-1)*padding;
    }
    else if(table.getOrientation() == Orientation.Vertical){
      calculatedX = table.getLeftTopPoint().getX() - 1;

      if(row == 2){
        calculatedX += table.getWidth() - 1;
      }
    }
    return calculatedX;
  }

  private getAbsoluteY(table: Table, row: number, column: number): number{
    let calculatedY: number;
    if(table.getOrientation() == Orientation.Horizontal){
      calculatedY = table.getLeftTopPoint().getY() - 1;

      if(column == 2){
        calculatedY += table.getWidth();
      }
    }
    else if(table.getOrientation() == Orientation.Vertical){
      calculatedY = table.getLeftTopPoint().getY();

      let noOfChairsInThisRow = table.getChairsInRow()[column-1];
      let padding = (table.getWidth() - this.utilService.GRIDS_PER_CHAIR*noOfChairsInThisRow)/(2*noOfChairsInThisRow)
      calculatedY += padding + 2*(row-1)*padding;
    }

    return calculatedY;
  }

  private getChairAngle(orientation: Orientation, row: number, column:number): number{
    let angle: number;
    if(orientation == Orientation.Horizontal && row == 1){
      angle = 0;
    }
    else if(orientation == Orientation.Horizontal && row == 2){
      angle = 180;
    }
    else if(orientation == Orientation.Vertical && column == 1){
      angle = 270;
    }
    else if(orientation == Orientation.Vertical && column == 2){
      angle = 90;
    }

    return angle;
  }
}
