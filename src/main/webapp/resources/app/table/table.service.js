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
var table_1 = require("./table");
var coordinate_1 = require("../util/coordinate");
var orientation_1 = require("../util/orientation");
var TableService = (function () {
    function TableService() {
    }
    TableService.prototype.getTable = function (tableJSON) {
        // Why not JSON as type??
        var orientation = this.getOrientation(tableJSON.length, tableJSON.width);
        var topLeftPoint = new coordinate_1.Coordinate(this.adjustX(orientation, tableJSON.topLeftX), this.adjustY(orientation, tableJSON.topLeftY));
        var width = this.adjustWidth(orientation, tableJSON.width);
        var length = this.adjustLength(orientation, tableJSON.length);
        var noOfChairsInRow = this.getChairsInRow(orientation, tableJSON.desks);
        return new table_1.Table(topLeftPoint, length, width, noOfChairsInRow, orientation);
    };
    TableService.prototype.getOrientation = function (length, width) {
        var orientation;
        if (length > width) {
            orientation = orientation_1.Orientation.Horizontal;
        }
        else {
            orientation = orientation_1.Orientation.Vertical;
        }
        return orientation;
    };
    TableService.prototype.adjustWidth = function (orientation, width) {
        var adjustedWidth;
        if (orientation == orientation_1.Orientation.Vertical) {
            adjustedWidth = width;
        }
        else if (orientation == orientation_1.Orientation.Horizontal) {
            adjustedWidth = (width > 1) ? width - 1 : width;
        }
        return adjustedWidth;
    };
    TableService.prototype.adjustLength = function (orientation, length) {
        var adjustedLength;
        if (orientation == orientation_1.Orientation.Vertical) {
            adjustedLength = (length > 1) ? length - 1 : length;
        }
        else if (orientation == orientation_1.Orientation.Horizontal) {
            adjustedLength = length;
        }
        return adjustedLength;
    };
    TableService.prototype.adjustX = function (orientation, x) {
        var adjustedX;
        if (orientation == orientation_1.Orientation.Vertical) {
            adjustedX = x + 1;
        }
        else if (orientation == orientation_1.Orientation.Horizontal) {
            adjustedX = x;
        }
        return adjustedX;
    };
    TableService.prototype.adjustY = function (orientation, y) {
        var adjustedY;
        if (orientation == orientation_1.Orientation.Vertical) {
            adjustedY = y;
        }
        else if (orientation == orientation_1.Orientation.Horizontal) {
            adjustedY = y + 1;
        }
        return adjustedY;
    };
    TableService.prototype.getChairsInRow = function (orientation, desks) {
        var chairsInRow = [0, 0];
        var rowProperty;
        if (orientation == orientation_1.Orientation.Horizontal) {
            rowProperty = "tableRow";
        }
        else if (orientation == orientation_1.Orientation.Vertical) {
            rowProperty = "tableCol";
        }
        for (var deskNo = 0; deskNo < desks.length; deskNo++) {
            var row = void 0;
            if (desks[deskNo][rowProperty] <= 2) {
                row = desks[deskNo][rowProperty];
            }
            else {
                row = 2;
            }
            chairsInRow[row - 1]++;
        }
        return chairsInRow;
    };
    TableService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], TableService);
    return TableService;
}());
exports.TableService = TableService;
//# sourceMappingURL=table.service.js.map