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
var util_service_1 = require("../util/util.service");
var data_service_1 = require("../util/data.service");
var Subject_1 = require('rxjs/Subject');
var CanvasService = (function () {
    function CanvasService(utilService, dataService) {
        this.utilService = utilService;
        this.dataService = dataService;
        this.showPublishEmitter = new Subject_1.Subject();
        this.showLoaderEmitter = new Subject_1.Subject();
        this.showTooltipEmitter = new Subject_1.Subject();
        this.hideTooltipEmitter = new Subject_1.Subject();
        this.panning = false;
    }
    CanvasService.prototype.initCanvas = function () {
        this.canvas = new fabric.Canvas('workarea', { selection: false, defaultCursor: "move" });
        this.canvas.setHeight(window.innerHeight);
        this.canvas.setWidth(window.innerWidth);
        this.onMouseUp();
        this.onMouseDown();
        this.onMouseMove();
        this.onMouseHover();
    };
    CanvasService.prototype.onMouseUp = function () {
        var _this = this;
        this.canvas.on('mouse:up', function (e) { return _this.panning = false; });
    };
    CanvasService.prototype.onMouseDown = function () {
        var _this = this;
        this.canvas.on('mouse:down', function (e) { return _this.panning = true; });
    };
    CanvasService.prototype.onMouseMove = function () {
        var _this = this;
        this.canvas.on('mouse:move', function (e) {
            if (_this.panning && e && e.e) {
                var delta = new fabric.Point(e.e.movementX, e.e.movementY);
                _this.canvas.relativePan(delta);
            }
        });
    };
    CanvasService.prototype.onMouseHover = function () {
        var _this = this;
        this.canvas.on('mouse:over', function (e) {
            if (e.target.entity == "chair") {
                _this.showTooltipEmitter.next(e);
            }
        });
        this.canvas.on('mouse:out', function (e) {
            if (e.target.entity == 'chair') {
                _this.hideTooltipEmitter.next(false);
            }
        });
    };
    CanvasService.prototype.showPublish = function (value) {
        this.showPublishEmitter.next(value);
    };
    CanvasService.prototype.showLoader = function (value) {
        this.showLoaderEmitter.next(value);
    };
    CanvasService.prototype.setupFloor = function () {
        this.canvas.setBackgroundColor({ source: this.utilService.IMG_PATH + this.utilService.FLOOR_PATTERN_FILE, repeat: 'repeat' }, function () { });
    };
    CanvasService.prototype.setZoom = function (value) {
        this.canvas.setZoom(value);
    };
    CanvasService.prototype.zoomToPoint = function (x, y, value) {
        this.canvas.zoomToPoint({ x: x, y: y }, value);
    };
    CanvasService.prototype.publishDecision = function (decision) {
        this.dataService.saveUploadData(decision);
        this.showPublish(false);
        this.renderWelcomePage();
    };
    CanvasService.prototype.renderWelcomePage = function () {
        var _this = this;
        this.clearCanvas();
        fabric.Image.fromURL(this.utilService.IMG_PATH + this.utilService.WELCOME_SCREEN, function (oImg) {
            oImg.set({
                left: 500,
                selectable: false,
            });
            _this.canvas.add(oImg);
        });
    };
    CanvasService.prototype.clearCanvas = function () {
        this.canvas.clear();
    };
    CanvasService.prototype.renderLayout = function (layout) {
        this.clearCanvas();
        this.utilService.calculateGridSize(layout.getFloor());
        //this.setupFloor();
        for (var _i = 0, _a = layout.getTables(); _i < _a.length; _i++) {
            var table = _a[_i];
            this.drawTable(table);
        }
        for (var _b = 0, _c = layout.getChairs(); _b < _c.length; _b++) {
            var chair = _c[_b];
            this.drawChair(chair);
        }
        //this.canvas.renderAll();
    };
    CanvasService.prototype.drawTable = function (table) {
        var _this = this;
        fabric.util.loadImage(this.utilService.IMG_PATH + this.utilService.TABLE_PATTERN_FILE, function (img) {
            _this.canvas.add(new fabric.Rect({
                left: table.getLeftTopPoint().getX() * _this.utilService.GRID_SIZE,
                top: table.getLeftTopPoint().getY() * _this.utilService.GRID_SIZE,
                width: table.getLength() * _this.utilService.GRID_SIZE,
                height: table.getWidth() * _this.utilService.GRID_SIZE,
                originX: 'left',
                originY: 'top',
                rx: _this.utilService.TABLE_BORDER_RADIUS_RATIO * _this.utilService.GRID_SIZE,
                ry: _this.utilService.TABLE_BORDER_RADIUS_RATIO * _this.utilService.GRID_SIZE,
                hasControls: false,
                selectable: false,
                fill: new fabric.Pattern({ source: img }),
                hoverCursor: 'move'
            }));
        });
    };
    CanvasService.prototype.drawChair = function (chair) {
        var seat = this.getChairSeat(chair);
        var leftArm = this.getLeftArm(chair);
        var rightArm = this.getRightArm(chair);
        var upperArm = this.getUpperArm(chair);
        var group = this.getChairGroup(chair, leftArm, rightArm, upperArm, seat);
        this.canvas.add(group);
    };
    CanvasService.prototype.getChairSeat = function (chair) {
        var mid = new fabric.Rect({
            left: chair.getTopLeftPoint().getX() * this.utilService.GRID_SIZE + 2 * this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE + this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            top: chair.getTopLeftPoint().getY() * this.utilService.GRID_SIZE + 2 * this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE + this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            stroke: 'grey',
            width: this.utilService.GRID_SIZE - 4 * this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE - 2 * this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            height: this.utilService.GRID_SIZE - 4 * this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE - 2 * this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            rx: this.utilService.CHAIR_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE,
            ry: this.utilService.CHAIR_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE
        });
        return mid;
    };
    CanvasService.prototype.getLeftArm = function (chair) {
        var leftArm = new fabric.Rect({
            left: chair.getTopLeftPoint().getX() * this.utilService.GRID_SIZE + this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE,
            top: chair.getTopLeftPoint().getY() * this.utilService.GRID_SIZE + 1 / 4 * this.utilService.GRID_SIZE,
            stroke: 'grey',
            width: this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            height: 1 / 2 * this.utilService.GRID_SIZE,
            rx: this.utilService.ARM_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE,
            ry: this.utilService.ARM_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE
        });
        return leftArm;
    };
    CanvasService.prototype.getRightArm = function (chair) {
        var rightArm = new fabric.Rect({
            left: chair.getTopLeftPoint().getX() * this.utilService.GRID_SIZE + this.utilService.GRID_SIZE - this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE - this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            top: chair.getTopLeftPoint().getY() * this.utilService.GRID_SIZE + 1 / 4 * this.utilService.GRID_SIZE,
            stroke: 'grey',
            width: this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            height: 1 / 2 * this.utilService.GRID_SIZE,
            rx: this.utilService.ARM_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE,
            ry: this.utilService.ARM_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE
        });
        return rightArm;
    };
    CanvasService.prototype.getUpperArm = function (chair) {
        var upperArm = new fabric.Rect({
            left: chair.getTopLeftPoint().getX() * this.utilService.GRID_SIZE + 1 / 4 * this.utilService.GRID_SIZE,
            top: chair.getTopLeftPoint().getY() * this.utilService.GRID_SIZE + this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE,
            stroke: 'grey',
            width: 1 / 2 * this.utilService.GRID_SIZE,
            height: this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            rx: 0,
            ry: 0
        });
        return upperArm;
    };
    CanvasService.prototype.getChairGroup = function (chair, leftArm, rightArm, upperArm, seat) {
        var group = new fabric.Group([leftArm, rightArm, seat, upperArm], {
            left: chair.getTopLeftPoint().getX() * this.utilService.GRID_SIZE + 1 / 2 * this.utilService.GRID_SIZE,
            top: chair.getTopLeftPoint().getY() * this.utilService.GRID_SIZE + 1 / 2 * this.utilService.GRID_SIZE,
            originX: 'center',
            originY: 'center',
            selectable: false,
            angle: chair.getAngle(),
            fill: "#cccccc",
            entity: "chair",
            deskid: chair.getDeskId(),
            employee: chair.getEmployee()
        });
        return group;
    };
    CanvasService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [util_service_1.UtilService, data_service_1.DataService])
    ], CanvasService);
    return CanvasService;
}());
exports.CanvasService = CanvasService;
//# sourceMappingURL=canvas.service.js.map