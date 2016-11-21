import { Injectable } from '@angular/core';

import { Table } from "./table";
import { Coordinate } from "../util/coordinate";
import { Orientation } from "../util/orientation";

@Injectable()
export class TableService {
  public getTable(tableJSON: any): Table {
    
    // Why not JSON as type??
    let orientation: Orientation = this.getOrientation(tableJSON.width, tableJSON.height);
    let topLeftPoint: Coordinate = new Coordinate(this.adjustX(orientation, tableJSON.x), this.adjustY(orientation, tableJSON.y));
    let width: number = this.adjustWidth(orientation, tableJSON.width);
    let length: number = this.adjustLength(orientation, tableJSON.length);
    let noOfChairsInRow: number[] = this.getChairsInRow(tableJSON.desks);
    
    return new Table(topLeftPoint, length, width, noOfChairsInRow, orientation);
  }
  
  private getOrientation(width: number, length: number): Orientation{
    let orientation: Orientation;
    if(length>width){
      orientation = Orientation.Horizontal;
    }
    else{
      orientation = Orientation.Vertical;
    }
    return orientation;
  }
  
  private adjustWidth(orientation: Orientation, width: number): number{
    let adjustedWidth: number;
    if(orientation == Orientation.Vertical){
      adjustedWidth = width;
    }
    else if(orientation == Orientation.Horizontal){
      adjustedWidth = (width>1)?width-1:width;
    }
    return adjustedWidth;
  }
  
  private adjustLength(orientation: Orientation, length: number): number{
    let adjustedLength: number;
    if(orientation == Orientation.Vertical){
      adjustedLength = (length>1)?length-1:length;
    }
    else if(orientation == Orientation.Horizontal){
      adjustedLength = length;
    }
    return adjustedLength;
  }
  
  private adjustX(orientation: Orientation, x: number): number{
    let adjustedX: number;
    if(orientation == Orientation.Vertical){
      adjustedX = x+1;
    }
    else if(orientation == Orientation.Horizontal){
      adjustedX = x;
    }
    return adjustedX;
  }
  
  private adjustY(orientation: Orientation, y: number): number{
    let adjustedY: number;
    if(orientation == Orientation.Vertical){
      adjustedY = y;
    }
    else if(orientation == Orientation.Horizontal){
      adjustedY = y+1;
    }
    return adjustedY;
  }
  
  private getChairsInRow(desks: any): number[]{
    let chairsInRow: number[] = [0,0];
    return chairsInRow;
  }
}