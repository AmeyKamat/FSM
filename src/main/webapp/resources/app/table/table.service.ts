import { Injectable } from '@angular/core';
import { Table } from "./table";
import { Coordinate } from "../util/coordinate";
import { Orientation } from "../util/orientation";

@Injectable()
export class TableService {

    public getTable(tableJSON: any): Table {
        // Why not JSON as type??

        let orientation: Orientation = this.getOrientation(tableJSON.length, tableJSON.width);
        let topLeftPoint: Coordinate = new Coordinate(this.adjustX(orientation, tableJSON.topLeftX), this.adjustY(orientation, tableJSON.topLeftY));
        let width: number = this.adjustWidth(orientation, tableJSON.width);
        let length: number = this.adjustLength(orientation, tableJSON.length);
        let noOfChairsInRow: number[] = this.getChairsInRow(orientation, tableJSON.desks);

        return new Table(topLeftPoint, length, width, noOfChairsInRow, orientation);
    }

    private getOrientation(length: number, width: number): Orientation{
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

    private getChairsInRow(orientation: Orientation, desks: any): number[]{
        let chairsInRow: number[] = [0,0];
        let rowProperty: string;
        if(orientation == Orientation.Horizontal){
            rowProperty = "tableRow";
        }
        else if(orientation == Orientation.Vertical){
            rowProperty = "tableCol";
        }

        for(let deskNo=0; deskNo<desks.length; deskNo++){
            chairsInRow[desks[deskNo][rowProperty]]++;
        }

        return chairsInRow;
    }
}