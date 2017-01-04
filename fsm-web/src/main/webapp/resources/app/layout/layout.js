"use strict";
var Layout = (function () {
    function Layout(floor, tables, chairs) {
        this.floor = floor;
        this.tables = tables;
        this.chairs = chairs;
    }
    Layout.prototype.getFloor = function () {
        return this.floor;
    };
    Layout.prototype.getTables = function () {
        return this.tables;
    };
    Layout.prototype.getChairs = function () {
        return this.chairs;
    };
    return Layout;
}());
exports.Layout = Layout;
//# sourceMappingURL=layout.js.map