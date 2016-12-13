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
var UtilService = (function () {
    function UtilService() {
        /* static paths */
        this.IMG_PATH = "/resources/img/";
        this.CHAIR_FILE = "chair.png";
        this.TABLE_PATTERN_FILE = "table_pattern.jpg";
        this.FLOOR_PATTERN_FILE = "floor_pattern.jpg";
        this.LOADING_FILE = "loading.gif";
        this.WELCOME_SCREEN = "barclays.png";
        /* API paths */
        /*  public GET_LAYOUT_URL = `/controller/floors`;
            public GET_COUNTRY_URL = "/controller/countries";
            public GET_CITY_URL = "/countries/${countryId}/cities";
            public GET_LOCATION_URL = "";
            public GET_LEVEL_URL = "";
            public GET_EMPLOYEE_URL = "";
            public POST_UPLOAD_URL = "/controller/layoutFile/upload";
            public SAVE_UPLOAD_DATA_URL=`/controller/layoutFile/publish`;*/
        /*ENV Variables*/
        this.GRIDS_PER_CHAIR = 1;
        this.CHAIR_BORDER_RADIUS_RATIO = 0.08;
        this.ARM_BORDER_RADIUS_RATIO = 0.05;
        this.TABLE_BORDER_RADIUS_RATIO = 0.125;
        this.MIN_BLOCK_SIZE_RATIO = 0.1;
        this.CHAIR_PADDING = 0.1;
    }
    UtilService.prototype.calculateGridSize = function (floor) {
        var xGridSize = window.innerWidth / floor.getLength();
        var yGridSize = window.innerWidth / floor.getWidth();
        this.GRID_SIZE = (xGridSize < yGridSize) ? (xGridSize) : (yGridSize);
    };
    UtilService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], UtilService);
    return UtilService;
}());
exports.UtilService = UtilService;
//# sourceMappingURL=util.service.js.map