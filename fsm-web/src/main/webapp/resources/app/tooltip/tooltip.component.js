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
var canvas_service_1 = require("../canvas/canvas.service");
var TooltipComponent = (function () {
    function TooltipComponent(canvasService) {
        this.canvasService = canvasService;
        this.showTooltip = false;
    }
    TooltipComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.canvasService.showTooltipEmitter.subscribe(function (e) {
            _this.showTooltip = true;
            _this.deskId = e.target.deskid;
            _this.employee = e.target.employee;
            e = e.e;
            _this.left = (e.clientX + 20) + 'px';
            _this.top = (e.clientY + 20) + 'px';
        });
        this.canvasService.hideTooltipEmitter.subscribe(function (value) {
            _this.showTooltip = value;
        });
    };
    TooltipComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'my-tooltip',
            templateUrl: 'tooltip.component.html',
        }),
        core_1.Injectable(), 
        __metadata('design:paramtypes', [canvas_service_1.CanvasService])
    ], TooltipComponent);
    return TooltipComponent;
}());
exports.TooltipComponent = TooltipComponent;
//# sourceMappingURL=tooltip.component.js.map