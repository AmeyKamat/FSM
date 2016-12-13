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
var data_service_1 = require("../util/data.service");
var layout_service_1 = require("../layout/layout.service");
var canvas_service_1 = require("../canvas/canvas.service");
var UploadService = (function () {
    function UploadService(dataService, layoutService, canvasService) {
        this.dataService = dataService;
        this.layoutService = layoutService;
        this.canvasService = canvasService;
    }
    UploadService.prototype.getCountries = function () {
        return this.dataService.getCountries();
    };
    UploadService.prototype.getCities = function (countryId) {
        return this.dataService.getCities(countryId);
    };
    UploadService.prototype.getLocations = function (cityId) {
        return this.dataService.getLocations(cityId);
    };
    UploadService.prototype.getLevels = function (locationId) {
        return this.dataService.getLevels(locationId);
    };
    UploadService.prototype.setUploadFile = function (file) {
        this.file = file;
    };
    UploadService.prototype.acceptFormData = function (formGroup) {
        var _this = this;
        this.formData = new FormData();
        this.formData.append("name", "layout");
        this.formData.append("country", formGroup.get('country').value);
        this.formData.append("city", formGroup.get('city').value);
        this.formData.append("location", formGroup.get('location').value);
        this.formData.append("floorId", formGroup.get('floorId').value);
        this.formData.append("file", this.file);
        this.dataService.postUploadData(this.formData).
            subscribe(function (layoutData) {
            var layout = _this.layoutService.getLayout(layoutData);
            _this.canvasService.showPublishToggle();
            _this.canvasService.renderLayout(layout);
        });
    };
    UploadService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [data_service_1.DataService, layout_service_1.LayoutService, canvas_service_1.CanvasService])
    ], UploadService);
    return UploadService;
}());
exports.UploadService = UploadService;
//# sourceMappingURL=upload.service.js.map