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
var floor_1 = require("./floor");
var coordinate_1 = require("../util/coordinate");
var core_1 = require("@angular/core");
var FloorService = (function () {
    function FloorService() {
    }
    FloorService.prototype.getFloor = function (floorData) {
        return new floor_1.Floor(new coordinate_1.Coordinate(floorData.minX, floorData.minY), floorData.maxY - floorData.minY, floorData.maxX - floorData.minX);
    };
    FloorService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], FloorService);
    return FloorService;
}());
exports.FloorService = FloorService;
//# sourceMappingURL=floor.service.js.map