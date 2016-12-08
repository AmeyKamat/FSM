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
var chair_1 = require("../chair/chair");
var coordinate_1 = require("../util/coordinate");
var orientation_1 = require("../util/orientation");
var ChairService = (function () {
    function ChairService(utilService) {
        this.utilService = utilService;
    }
    ChairService.prototype.getChair = function (table, chairJSON) {
        var topLeftPoint = new coordinate_1.Coordinate(this.getAbsoluteX(table, chairJSON.tableRow, chairJSON.tableCol), this.getAbsoluteY(table, chairJSON.tableRow, chairJSON.tableCol));
        var chairId = chairJSON.id;
        var angle = this.getChairAngle(table.getOrientation(), chairJSON.tableRow);
        return new chair_1.Chair(topLeftPoint, angle, chairId, "");
    };
    ChairService.prototype.getAbsoluteX = function (table, row, column) {
        var calculatedX;
        if (table.getOrientation() == orientation_1.Orientation.Horizontal) {
            calculatedX = table.getLeftTopPoint().getX();
            var noOfChairsInThisRow = table.getChairsInRow[row];
            var padding = (table.getLength() - this.utilService.GRIDS_PER_CHAIR * noOfChairsInThisRow) / (2 * noOfChairsInThisRow);
            calculatedX += padding + 2 * (column - 1) * padding;
        }
        else if (table.getOrientation() == orientation_1.Orientation.Vertical) {
            calculatedX = table.getLeftTopPoint().getX();
            if (row == 2) {
                calculatedX += table.getWidth();
            }
        }
        return calculatedX;
    };
    ChairService.prototype.getAbsoluteY = function (table, row, column) {
        var calculatedY;
        if (table.getOrientation() == orientation_1.Orientation.Horizontal) {
            calculatedY = table.getLeftTopPoint().getY();
            if (row == 2) {
                calculatedY += table.getWidth();
            }
        }
        else if (table.getOrientation() == orientation_1.Orientation.Vertical) {
            calculatedY = table.getLeftTopPoint().getY();
            var noOfChairsInThisRow = table.getChairsInRow[row];
            var padding = (table.getWidth() - this.utilService.GRIDS_PER_CHAIR * noOfChairsInThisRow) / (2 * noOfChairsInThisRow);
            calculatedY += padding + 2 * (column - 1) * padding;
        }
        return calculatedY;
    };
    ChairService.prototype.getChairAngle = function (orientation, row) {
        var angle;
        if (orientation == orientation_1.Orientation.Horizontal && row == 1) {
            angle = 0;
        }
        else if (orientation == orientation_1.Orientation.Horizontal && row == 2) {
            angle = 180;
        }
        else if (orientation == orientation_1.Orientation.Vertical && row == 1) {
            angle = 270;
        }
        else if (orientation == orientation_1.Orientation.Vertical && row == 2) {
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