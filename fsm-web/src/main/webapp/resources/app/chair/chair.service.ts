import { Injectable } from '@angular/core';

import { UtilService } from '../util/util.service';

import { Table } from "../table/table";
import { Chair } from "./chair";

import { Coordinate } from "../util/coordinate";
import { Orientation } from "../util/orientation";
import {Employee} from "../util/employee";
import {Group} from "../util/group";

@Injectable()
export class ChairService {

    constructor(private utilService: UtilService) {
    }

    public getChair(table: Table, chairJSON: any): Chair {

        let row = this.applyCorrectionToRow(table, chairJSON.tableRow);
        let column = this.applyCorrectionToColumn(table, chairJSON.tableCol);

        let topLeftPoint: Coordinate = new Coordinate(
            this.getAbsoluteX(table, row, column),
            this.getAbsoluteY(table, row, column)
        );
        let chairId = chairJSON.deskCode;
        let angle = this.getChairAngle(table.getOrientation(), row, column);
        let deskEmployee = chairJSON.deskEmployee;
        let employee:Employee;
        if(deskEmployee!=null) {
            employee = new Employee(deskEmployee.id, deskEmployee.brid, deskEmployee.name, deskEmployee.group);
        }
        else
            employee = null;
        return new Chair(topLeftPoint, angle, chairId, employee);
    }

    private applyCorrectionToRow(table: Table, tableRow: number) {
        let row: number = tableRow;
        if(table.getOrientation() == Orientation.Horizontal && tableRow > 2){
            row = 2;
        }
        return row;
    }

    private applyCorrectionToColumn(table: Table, tableCol: number) {
        let column: number = tableCol;
        if(table.getOrientation() == Orientation.Vertical && tableCol > 2){
            column = 2;
        }
        return column;
    }

    private getAbsoluteX(table: Table, row: number, column: number): number{
        let calculatedX: number;
        if(table.getOrientation() == Orientation.Horizontal){
            calculatedX = table.getLeftTopPoint().getX();

            let noOfChairsInThisRow = table.getChairsInRow()[row-1];
            let padding = 0;

            /* For future exploration */
            //let padding = (table.getLength() - this.utilService.GRIDS_PER_CHAIR*noOfChairsInThisRow)/(2*noOfChairsInThisRow);

            calculatedX += padding + (column-1)*(padding + this.utilService.GRIDS_PER_CHAIR);
        }
        else if(table.getOrientation() == Orientation.Vertical){
            calculatedX = table.getLeftTopPoint().getX() - 1;

            if(column >= 2){
                calculatedX += table.getLength() + 1;
            }
        }
        return calculatedX;
    }

    private getAbsoluteY(table: Table, row: number, column: number): number{
        let calculatedY: number;
        if(table.getOrientation() == Orientation.Horizontal){
            calculatedY = table.getLeftTopPoint().getY()-1;

            if(row >= 2){
                calculatedY += table.getWidth() + 1;
            }
        }
        else if(table.getOrientation() == Orientation.Vertical){
            calculatedY = table.getLeftTopPoint().getY();

            let noOfChairsInThisRow = table.getChairsInRow()[column-1];
            let padding = 0;

            /* for future exploration */
            //let padding = (table.getWidth() - this.utilService.GRIDS_PER_CHAIR*noOfChairsInThisRow)/(2*noOfChairsInThisRow)
            calculatedY += padding + (row-1)*(padding + this.utilService.GRIDS_PER_CHAIR);
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
