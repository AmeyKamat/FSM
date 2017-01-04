"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var util_service_1 = require('../util/util.service');
var chair_1 = require("./chair");
var coordinate_1 = require("../util/coordinate");
var orientation_1 = require("../util/orientation");
var employee_1 = require("../util/employee");
var ChairService = (function () {
    function ChairService(utilService) {
        this.utilService = utilService;
    }
    ChairService.prototype.getChair = function (table, chairJSON) {
        var row = this.applyCorrectionToRow(table, chairJSON.tableRow);
        var column = this.applyCorrectionToColumn(table, chairJSON.tableCol);
        var topLeftPoint = new coordinate_1.Coordinate(this.getAbsoluteX(table, row, column), this.getAbsoluteY(table, row, column));
        var chairId = chairJSON.deskCode;
        var angle = this.getChairAngle(table.getOrientation(), row, column);
        var deskEmployee = chairJSON.deskEmployee;
        var employee;
        if (deskEmployee != null) {
            employee = new employee_1.Employee(deskEmployee.id, deskEmployee.brid, deskEmployee.name, deskEmployee.group);
        }
        else
            employee = null;
        return new chair_1.Chair(topLeftPoint, angle, chairId, employee);
    };
    ChairService.prototype.applyCorrectionToRow = function (table, tableRow) {
        var row = tableRow;
        if (table.getOrientation() == orientation_1.Orientation.Horizontal && tableRow > 2) {
            row = 2;
        }
        return row;
    };
    ChairService.prototype.applyCorrectionToColumn = function (table, tableCol) {
        var column = tableCol;
        if (table.getOrientation() == orientation_1.Orientation.Vertical && tableCol > 2) {
            column = 2;
        }
        return column;
    };
    ChairService.prototype.getAbsoluteX = function (table, row, column) {
        var calculatedX;
        if (table.getOrientation() == orientation_1.Orientation.Horizontal) {
            calculatedX = table.getLeftTopPoint().getX();
            var noOfChairsInThisRow = table.getChairsInRow()[row - 1];
            var padding = 0;
            /* For future exploration */
            //let padding = (table.getLength() - this.utilService.GRIDS_PER_CHAIR*noOfChairsInThisRow)/(2*noOfChairsInThisRow);
            calculatedX += padding + (column - 1) * (padding + this.utilService.GRIDS_PER_CHAIR);
        }
        else if (table.getOrientation() == orientation_1.Orientation.Vertical) {
            calculatedX = table.getLeftTopPoint().getX() - 1;
            if (column >= 2) {
                calculatedX += table.getLength() + 1;
            }
        }
        return calculatedX;
    };
    ChairService.prototype.getAbsoluteY = function (table, row, column) {
        var calculatedY;
        if (table.getOrientation() == orientation_1.Orientation.Horizontal) {
            calculatedY = table.getLeftTopPoint().getY() - 1;
            if (row >= 2) {
                calculatedY += table.getWidth() + 1;
            }
        }
        else if (table.getOrientation() == orientation_1.Orientation.Vertical) {
            calculatedY = table.getLeftTopPoint().getY();
            var noOfChairsInThisRow = table.getChairsInRow()[column - 1];
            var padding = 0;
            /* for future exploration */
            //let padding = (table.getWidth() - this.utilService.GRIDS_PER_CHAIR*noOfChairsInThisRow)/(2*noOfChairsInThisRow)
            calculatedY += padding + (row - 1) * (padding + this.utilService.GRIDS_PER_CHAIR);
        }
        return calculatedY;
    };
    ChairService.prototype.getChairAngle = function (orientation, row, column) {
        var angle;
        if (orientation == orientation_1.Orientation.Horizontal && row == 1) {
            angle = 0;
        }
        else if (orientation == orientation_1.Orientation.Horizontal && row == 2) {
            angle = 180;
        }
        else if (orientation == orientation_1.Orientation.Vertical && column == 1) {
            angle = 270;
        }
        else if (orientation == orientation_1.Orientation.Vertical && column == 2) {
            angle = 90;
        }
        return angle;
    };
    ChairService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [util_service_1.UtilService])
    ], ChairService);
    return ChairService;
}());
exports.ChairService = ChairService;
//# sourceMappingURL=chair.service.js.map