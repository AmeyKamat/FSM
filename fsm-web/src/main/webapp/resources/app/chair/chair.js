"use strict";
var Chair = (function () {
    function Chair(topLeftPoint, angle, deskId, employee) {
        this.topLeftPoint = topLeftPoint;
        this.angle = angle;
        this.deskId = deskId;
        this.employee = employee;
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
    Chair.prototype.getEmployee = function () {
        return this.employee;
    };
    return Chair;
}());
exports.Chair = Chair;
//# sourceMappingURL=chair.js.map