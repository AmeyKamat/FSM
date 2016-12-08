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
var core_1 = require("@angular/core");
var floor_service_1 = require("../floor/floor.service");
var table_service_1 = require("../table/table.service");
var chair_service_1 = require("../chair/chair.service");
var layout_1 = require("./layout");
var LayoutService = (function () {
    function LayoutService(floorService, tableService, chairService) {
        this.floorService = floorService;
        this.tableService = tableService;
        this.chairService = chairService;
    }
    LayoutService.prototype.getLayout = function (layoutData) {
        var floor = this.floorService.getFloor(layoutData);
        var tables = [];
        var chairs = [];
        var tableList = layoutData.tables;
        for (var _i = 0, tableList_1 = tableList; _i < tableList_1.length; _i++) {
            var tableData = tableList_1[_i];
            var table = this.tableService.getTable(tableData);
            tables.push(table);
            var deskList = tableData.desks;
            for (var _a = 0, deskList_1 = deskList; _a < deskList_1.length; _a++) {
                var deskData = deskList_1[_a];
                var chair = this.chairService.getChair(table, deskData);
                chairs.push(chair);
            }
        }
        return new layout_1.Layout(floor, tables, chairs);
    };
    LayoutService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [floor_service_1.FloorService, table_service_1.TableService, chair_service_1.ChairService])
    ], LayoutService);
    return LayoutService;
}());
exports.LayoutService = LayoutService;
//# sourceMappingURL=layout.service.js.map