"use strict";
var Floor = (function () {
    function Floor(leftTopPoint, height, width) {
        this.leftTopPoint = leftTopPoint;
        this.height = height;
        this.width = width;
    }
    Floor.prototype.getLeftTopPoint = function () {
        return this.leftTopPoint;
    };
    Floor.prototype.getHeight = function () {
        return this.height;
    };
    Floor.prototype.getWidth = function () {
        return this.width;
    };
    return Floor;
}());
exports.Floor = Floor;
//# sourceMappingURL=floor.js.map