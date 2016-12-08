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
var util_service_1 = require("./util.service");
var http_1 = require("@angular/http");
require('rxjs/add/operator/map');
var DataService = (function () {
    function DataService(http, utilService) {
        this.http = http;
        this.utilService = utilService;
    }
    DataService.prototype.getCountries = function () {
        return this.http
            .get("/controller/countries")
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getCities = function (countryId) {
        return this.http
            .get("/controller/countries/" + countryId + "/cities")
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getLocations = function (cityId) {
        return this.http
            .get("/controller/cities/" + cityId + "/locations")
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getLevels = function (locationId) {
        return this.http
            .get("/controller/locations/" + locationId + "/floors")
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getLayoutData = function (floorId) {
        return this.http
            .get(this.utilService.GET_LAYOUT_URL + "/" + floorId)
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.postUploadData = function (formData) {
        return this.http
            .post("/controller/layoutFile/upload", formData, {
            headers: new http_1.Headers()
        })
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.saveUploadData = function (decision) {
        var params = new http_1.URLSearchParams();
        params.set('decision', decision.toString());
        this.http
            .get(this.utilService.SAVE_UPLOAD_DATA_URL, { search: params });
    };
    DataService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http, util_service_1.UtilService])
    ], DataService);
    return DataService;
}());
exports.DataService = DataService;
//# sourceMappingURL=data.service.js.map