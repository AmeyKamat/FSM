"use strict";
var Coordinate = (function () {
    function Coordinate(x, y) {
        this.x = x;
        this.y = y;
    }
    Coordinate.prototype.getX = function () {
        return this.x;
    };
    Coordinate.prototype.getY = function () {
        return this.y;
    };
    return Coordinate;
}());
exports.Coordinate = Coordinate;
//# sourceMappingURL=coordinate.js.map