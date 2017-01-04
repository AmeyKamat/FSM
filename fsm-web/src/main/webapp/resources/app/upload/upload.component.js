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
var forms_1 = require('@angular/forms');
var upload_service_1 = require("./upload.service");
var UploadComponent = (function () {
    function UploadComponent(fb, uploadService) {
        this.uploadService = uploadService;
        this.submitAttempt = false;
        this.uploadFileName = "No File Selected";
        this.form = fb.group({
            'country': ['', forms_1.Validators.required],
            'city': ['', forms_1.Validators.required],
            'location': ['', forms_1.Validators.required],
            'floorId': ['', forms_1.Validators.required],
            'upload': ['', forms_1.Validators.required]
        });
    }
    UploadComponent.prototype.ngOnInit = function () {
        this.getCountries();
    };
    UploadComponent.prototype.getCountries = function () {
        var _this = this;
        this.uploadService.getCountries().subscribe(function (countries) {
            _this.countries = countries;
            for (var i = 0; i < _this.countries.length; i++) {
                _this.countries[i].cities = null;
            }
        });
    };
    UploadComponent.prototype.getCities = function (countryId) {
        var _this = this;
        this.uploadService.getCities(countryId).subscribe(function (cities) {
            _this.cities = cities;
            for (var i = 0; i < _this.cities.length; i++) {
                _this.cities[i].locations = null;
            }
        });
    };
    UploadComponent.prototype.getLocations = function (cityId) {
        var _this = this;
        this.uploadService.getLocations(cityId).subscribe(function (locations) {
            _this.locations = locations;
            for (var i = 0; i < _this.locations.length; i++) {
                _this.locations[i].levels = null;
            }
        });
    };
    UploadComponent.prototype.getLevels = function (locationId) {
        var _this = this;
        this.uploadService.getLevels(locationId).subscribe(function (levels) {
            _this.levels = levels;
        });
    };
    UploadComponent.prototype.getPlanExistStatus = function (floorId) {
        var _this = this;
        this.uploadService.getPlanExistStatus(floorId).subscribe(function (status) {
            _this.planExistStatus = status;
        });
    };
    UploadComponent.prototype.uploadFileListener = function ($event) {
        this.file = $event.target.files[0];
        this.uploadFileName = this.file.name;
    };
    UploadComponent.prototype.onSubmit = function (formGroup) {
        var formData = new FormData();
        formData.append("floorId", formGroup.get('floorId').value);
        formData.append("file", this.file);
        this.uploadService.acceptFormData(formData);
    };
    UploadComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'upload',
            templateUrl: 'upload.component.html'
        }),
        core_1.Injectable(), 
        __metadata('design:paramtypes', [forms_1.FormBuilder, upload_service_1.UploadService])
    ], UploadComponent);
    return UploadComponent;
}());
exports.UploadComponent = UploadComponent;
//# sourceMappingURL=upload.component.js.map