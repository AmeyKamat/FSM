"use strict";
var Table = (function () {
    function Table(leftTopPoint, length, width, chairsInRow, orientation) {
        this.leftTopPoint = leftTopPoint;
        this.length = length;
        this.width = width;
        this.chairsInRow = chairsInRow;
        this.orientation = orientation;
    }
    Table.prototype.getLeftTopPoint = function () {
        return this.leftTopPoint;
    };
    Table.prototype.getLength = function () {
        return this.length;
    };
    Table.prototype.getWidth = function () {
        return this.width;
    };
    Table.prototype.getChairsInRow = function () {
        return this.chairsInRow;
    };
    Table.prototype.getOrientation = function () {
        return this.orientation;
    };
    return Table;
}());
exports.Table = Table;
//# sourceMappingURL=table.js.map