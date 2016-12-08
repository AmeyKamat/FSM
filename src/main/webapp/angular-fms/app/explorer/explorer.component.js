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
        console.log("Exploreer constructed");
    }
    ExplorerComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.explorerService.getCountries().
            subscribe(function (countries) {
            _this.countries = countries;
            for (var i = 0; i < _this.countries.length; i++) {
                // console.log("Countries are:"+countries[i].name) ;
                _this.countries[i].cities = null;
            }
        });
    };
    ExplorerComponent.prototype.getCities = function (country) {
        // this.cities = !this.expanded;
        console.log("toggle block of country" + country.id);
        if (country.cities == null) {
            // console.log("Inside if block") ;
            // country.cities=[new City("Pune",1,[])] ;
            this.explorerService.getCities().
                subscribe(function (cities) {
                country.cities = cities;
                for (var i = 0; i < country.cities.length; i++) {
                    // console.log("Countries are:"+cities[i].name) ;
                    country.cities[i].expanded = false;
                    country.cities[i].locations = null;
                }
            });
        }
        else {
            country.cities = null;
        }
    };
    ExplorerComponent.prototype.getLocations = function (city) {
        // this.cities = !this.expanded;
        console.log(" city toggle block");
        if (city.locations == null) {
            console.log("Inside if block");
            this.explorerService.getLocations().
                subscribe(function (locations) {
                city.locations = locations;
                for (var i = 0; i < city.locations.length; i++) {
                    // console.log("Countries are:"+city.locations[i].name) ;
                    city.locations[i].levels = null;
                }
            });
        }
        else {
            city.locations = null;
        }
    };
    ExplorerComponent.prototype.getLevels = function (location) {
        // this.cities = !this.expanded;
        console.log(" location toggle block");
        if (location.levels == null) {
            console.log("Inside if block ");
            this.explorerService.getLevels().
                subscribe(function (levels) {
                location.levels = levels;
                for (var i = 0; i < location.levels.length; i++) {
                }
            });
        }
        else {
            location.levels = null;
        }
    };
    ExplorerComponent.prototype.onSelect = function (id) {
        console.log("on select called ");
        this.explorerService.drawLayout(id);
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