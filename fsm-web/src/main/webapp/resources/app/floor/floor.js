"use strict";
var Floor = (function () {
    function Floor(leftTopPoint, length, width) {
        this.leftTopPoint = leftTopPoint;
        this.length = length;
        this.width = width;
    }
    Floor.prototype.getLeftTopPoint = function () {
        return this.leftTopPoint;
    };
    Floor.prototype.getLength = function () {
        return this.length;
    };
    Floor.prototype.getWidth = function () {
        return this.width;
    };
    return Floor;
}());
exports.Floor = Floor;
//# sourceMappingURL=floor.js.map