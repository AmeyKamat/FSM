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
var http_1 = require("@angular/http");
var core_1 = require("@angular/core");
var data_service_1 = require("../util/data.service");
// import {Location} from "../Region/location/location";
var UploadService = (function () {
    function UploadService(dataService) {
        this.dataService = dataService;
        this.headers = new http_1.Headers();
        this.headers.set('Content-Type', 'multipart/form-data');
        this.url = 'http://localhost:8080/test';
    }
    UploadService.prototype.print = function () {
        console.log("Service is getting cured");
    };
    UploadService.prototype.changeListener = function ($event) {
        // this.postFile($event.target);
        console.log(" in service: " + $event.target.files[0].name);
        this.formData = new FormData();
        this.formData.append("name", "layout");
        this.formData.append("file", +$event.target.files[0]);
    };
    //
    UploadService.prototype.acceptFormData = function (formGroup) {
        console.log('you submitted value: ', formGroup.get('country').value);
        this.formData.append("country", formGroup.get('country').value);
        this.formData.append("city", formGroup.get('city').value);
        this.formData.append("location", formGroup.get('location').value);
        this.formData.append("floor", formGroup.get('floor').value);
        // this.http.post(this.url ,
        //     this.formData ,
        //     {
        //         headers: this.headers
        //
        //     });
        /*return this.dataFetchService.postFormData(this.url,this.formData);*/
    };
    UploadService.prototype.getCountries = function () {
        return this.dataService.getCountries();
    };
    UploadService.prototype.getCities = function () {
        return this.dataService.getCities();
    };
    UploadService.prototype.getLocations = function () {
        return this.dataService.getLocations();
    };
    UploadService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [data_service_1.DataService])
    ], UploadService);
    return UploadService;
}());
exports.UploadService = UploadService;
//# sourceMappingURL=upload.service.js.map