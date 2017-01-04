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
var platform_browser_1 = require("@angular/platform-browser");
var forms_1 = require('@angular/forms');
var forms_2 = require('@angular/forms');
var app_routing_module_1 = require("./app-routing.module");
var http_1 = require("@angular/http");
var common_1 = require("@angular/common");
var app_component_1 = require("./app.component");
var upload_component_1 = require("./upload/upload.component");
var explorer_component_1 = require("./explorer/explorer.component");
var canvas_component_1 = require("./canvas/canvas.component");
var upload_service_1 = require("./upload/upload.service");
var explorer_service_1 = require("./explorer/explorer.service");
var canvas_service_1 = require("./canvas/canvas.service");
var util_service_1 = require("./util/util.service");
var floor_service_1 = require("./floor/floor.service");
var chair_service_1 = require("./chair/chair.service");
var table_service_1 = require("./table/table.service");
var layout_service_1 = require("./layout/layout.service");
var data_service_1 = require("./util/data.service");
var tooltip_component_1 = require("./tooltip/tooltip.component");
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [platform_browser_1.BrowserModule,
                forms_1.FormsModule,
                forms_2.ReactiveFormsModule,
                app_routing_module_1.AppRoutingModule,
                http_1.HttpModule,
                common_1.CommonModule
            ],
            declarations: [
                app_component_1.AppComponent,
                upload_component_1.UploadComponent,
                explorer_component_1.ExplorerComponent,
                canvas_component_1.CanvasComponent,
                tooltip_component_1.TooltipComponent
            ],
            providers: [upload_service_1.UploadService,
                explorer_service_1.ExplorerService,
                canvas_service_1.CanvasService,
                util_service_1.UtilService,
                data_service_1.DataService,
                floor_service_1.FloorService,
                chair_service_1.ChairService,
                table_service_1.TableService,
                layout_service_1.LayoutService
            ],
            bootstrap: [app_component_1.AppComponent],
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map