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
    DataService.prototype.getLayoutData = function (floorID) {
        var params = new http_1.URLSearchParams();
        params.set('floorID', floorID.toString());
        return this.http
            .get(this.utilService.GET_LAYOUT_URL, { search: params })
            .map(function (res) { return res.json(); });
    };
    DataService.prototype.getCountries = function () {
        return this.http.get('http://localhost:8080/rest/countries').map(function (response) { return response.json(); });
    };
    DataService.prototype.getCities = function () {
        return this.http.get('http://localhost:8080/rest/countries').map(function (response) { return response.json(); });
    };
    DataService.prototype.getLocations = function () {
        return this.http.get('http://localhost:8080/rest/countries').map(function (response) { return response.json(); });
    };
    DataService.prototype.getLevels = function () {
        return this.http.get('http://localhost:8080/rest/countries').map(function (response) { return response.json(); });
    };
    DataService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http, util_service_1.UtilService])
    ], DataService);
    return DataService;
}());
exports.DataService = DataService;
//# sourceMappingURL=data.service.js.map