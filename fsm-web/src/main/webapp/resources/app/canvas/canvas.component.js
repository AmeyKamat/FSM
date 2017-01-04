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
var canvas_service_1 = require("./canvas.service");
exports.maxZoom = 2.0;
exports.defaultZoom = 0.5;
var CanvasComponent = (function () {
    function CanvasComponent(canvasService) {
        var _this = this;
        this.canvasService = canvasService;
        this.showPublish = false;
        this.showLoader = false;
        this.zoomValue = exports.defaultZoom;
        this.canvasService.showPublishEmitter.subscribe(function (value) { _this.showPublish = value; });
        this.canvasService.showLoaderEmitter.subscribe(function (value) { _this.showLoader = value; });
    }
    CanvasComponent.prototype.ngOnInit = function () {
        this.canvasService.initCanvas();
        this.canvasService.renderWelcomePage();
        this.zoomReset();
    };
    CanvasComponent.prototype.zoomIn = function () {
        if (this.zoomValue <= exports.maxZoom) {
            this.zoomValue = this.zoomValue * 1.1;
            this.canvasService.setZoom(this.zoomValue);
        }
    };
    CanvasComponent.prototype.zoomOut = function () {
        this.zoomValue = this.zoomValue / 1.1;
        this.canvasService.setZoom(this.zoomValue);
    };
    CanvasComponent.prototype.zoomReset = function () {
        this.canvasService.setZoom(exports.defaultZoom);
    };
    CanvasComponent.prototype.zoom = function (e) {
        var evt = window.event || e;
        var delta = (evt.detail) ? (evt.detail * (-120)) : (evt.wheelDelta);
        this.zoomValue = this.zoomValue + delta / 4000;
        var x = e.offsetX;
        var y = e.offsetY;
        this.canvasService.zoomToPoint(x, y, this.zoomValue);
    };
    CanvasComponent.prototype.changeZoomLevel = function (value) {
        this.zoomValue = value;
        this.canvasService.setZoom(this.zoomValue);
    };
    CanvasComponent.prototype.publishDecision = function (decision) {
        this.canvasService.publishDecision(decision);
    };
    CanvasComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'my-canvas',
            templateUrl: 'canvas.component.html',
        }),
        core_1.Injectable(), 
        __metadata('design:paramtypes', [canvas_service_1.CanvasService])
    ], CanvasComponent);
    return CanvasComponent;
}());
exports.CanvasComponent = CanvasComponent;
//# sourceMappingURL=canvas.component.js.map