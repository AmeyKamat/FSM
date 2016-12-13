"use strict";
var Chair = (function () {
    function Chair(topLeftPoint, angle, deskId, brid) {
        this.topLeftPoint = topLeftPoint;
        this.angle = angle;
        this.deskId = deskId;
        this.brid = brid;
    }
    Chair.prototype.getTopLeftPoint = function () {
        return this.topLeftPoint;
    };
    Chair.prototype.getAngle = function () {
        return this.angle;
    };
    Chair.prototype.getDeskId = function () {
        return this.deskId;
    };
    Chair.prototype.getBrid = function () {
        return this.brid;
    };
    return Chair;
}());
exports.Chair = Chair;
//# sourceMappingURL=chair.js.map