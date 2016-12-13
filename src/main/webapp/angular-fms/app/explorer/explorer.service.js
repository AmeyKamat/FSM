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
var data_service_1 = require("../util/data.service");
var layout_service_1 = require("../layout/layout.service");
var canvas_service_1 = require("../canvas/canvas.service");
var ExplorerService = (function () {
    function ExplorerService(dataService, layoutService, canvasService) {
        this.dataService = dataService;
        this.layoutService = layoutService;
        this.canvasService = canvasService;
    }
    ExplorerService.prototype.getCountries = function () {
        return this.dataService.getCountries();
    };
    ExplorerService.prototype.getCities = function () {
        return this.dataService.getCities();
    };
    ExplorerService.prototype.getLocations = function () {
        return this.dataService.getLocations();
    };
    ExplorerService.prototype.getLevels = function () {
        return this.dataService.getLevels();
    };
    ExplorerService.prototype.drawLayout = function (floorId) {
        var _this = this;
        this.getLayoutData(floorId).
            subscribe(function (layoutData) {
            var layout = _this.layoutService.getLayout(layoutData);
            _this.canvasService.renderLayout(layout);
        });
    };
    ExplorerService.prototype.getLayoutData = function (floorId) {
        return this.dataService.getLayoutData(floorId);
    };
    ExplorerService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [data_service_1.DataService, layout_service_1.LayoutService, canvas_service_1.CanvasService])
    ], ExplorerService);
    return ExplorerService;
}());
exports.ExplorerService = ExplorerService;
//# sourceMappingURL=explorer.service.js.map