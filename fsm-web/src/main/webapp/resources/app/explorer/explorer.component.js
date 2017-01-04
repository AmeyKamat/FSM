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
var explorer_service_1 = require("./explorer.service");
var ExplorerComponent = (function () {
    function ExplorerComponent(explorerService) {
        this.explorerService = explorerService;
    }
    ExplorerComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.explorerService.getCountries().
            subscribe(function (countries) {
            _this.countries = countries;
        });
    };
    ExplorerComponent.prototype.getCities = function (country) {
        if (country.cities == null) {
            this.explorerService.getCities(country.id).
                subscribe(function (cities) {
                country.cities = cities;
            });
        }
        else {
            country.cities = null;
        }
    };
    ExplorerComponent.prototype.getLocations = function (city) {
        if (city.locations == null) {
            this.explorerService.getLocations(city.id).
                subscribe(function (locations) {
                city.locations = locations;
            });
        }
        else {
            city.locations = null;
        }
    };
    ExplorerComponent.prototype.getLevels = function (location) {
        if (location.levels == null) {
            this.explorerService.getLevels(location.id).
                subscribe(function (levels) {
                location.levels = levels;
            });
        }
        else {
            location.levels = null;
        }
    };
    ExplorerComponent.prototype.onSelect = function (floorId) {
        var _this = this;
        this.explorerService.getPlanExistStatus(floorId)
            .subscribe(function (status) {
            if (status == true) {
                _this.explorerService.drawLayout(floorId);
            }
            else {
            }
        });
    };
    ExplorerComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'explorer',
            templateUrl: 'explorer.component.html'
        }),
        core_1.Injectable(), 
        __metadata('design:paramtypes', [explorer_service_1.ExplorerService])
    ], ExplorerComponent);
    return ExplorerComponent;
}());
exports.ExplorerComponent = ExplorerComponent;
//# sourceMappingURL=explorer.component.js.map