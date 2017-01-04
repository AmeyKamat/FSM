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
        var _this = this;
        this.http = http;
        this.utilService = utilService;
        this.customHeaders = new http_1.Headers();
        this.getAuthTokenHeaders()
            .subscribe(function (customHeaders) {
            _this.customHeaders = customHeaders;
        });
    }
    DataService.prototype.getCountries = function () {
        return this.http
            .get("/countries")
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getCities = function (countryId) {
        return this.http
            .get("/countries/" + countryId + "/cities")
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getLocations = function (cityId) {
        return this.http
            .get("/cities/" + cityId + "/locations")
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getLevels = function (locationId) {
        return this.http
            .get("/locations/" + locationId + "/floors")
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getPlanExistStatus = function (floorId) {
        return this.http
            .get("/floors/" + floorId + "/doesPlanExist")
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getLayoutData = function (floorId) {
        return this.http
            .get("/floors/" + floorId)
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getAuthToken = function () {
        return this.http
            .get("/csrfToken")
            .map(function (response) { return response.json(); });
    };
    DataService.prototype.getAuthTokenHeaders = function () {
        return this.getAuthToken()
            .map(function (csrfToken) {
            var headerName = csrfToken.headerName;
            var token = csrfToken.token;
            var customHeaders = new http_1.Headers();
            customHeaders.append(headerName, token);
            return customHeaders;
        });
    };
    DataService.prototype.postUploadData = function (formData) {
        return this.http
            .post("/layoutFile/upload", formData, { headers: this.customHeaders })
            .map(function (response) {
            return response.json();
        });
    };
    DataService.prototype.saveUploadData = function (decision) {
        var params = new http_1.URLSearchParams();
        params.append('toBePublished', decision.toString());
        this.http
            .post("/layoutFile/publish", params, {
            headers: this.customHeaders
        })
            .subscribe(function () {
        });
    };
    DataService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http, util_service_1.UtilService])
    ], DataService);
    return DataService;
}());
exports.DataService = DataService;
//# sourceMappingURL=data.service.js.map