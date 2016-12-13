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
var util_service_1 = require("../util/util.service");
var core_1 = require("@angular/core");
var CanvasService = (function () {
    function CanvasService(utilService) {
        this.utilService = utilService;
        this.panning = false;
    }
    CanvasService.prototype.renderLayout = function (layout) {
        this.initCanvas();
        this.utilService.calculateGridSize(layout.getFloor());
        for (var _i = 0, _a = layout.getTables(); _i < _a.length; _i++) {
            var table = _a[_i];
            this.drawTable(table);
        }
        for (var _b = 0, _c = layout.getChairs(); _b < _c.length; _b++) {
            var chair = _c[_b];
            this.drawChair(chair);
        }
    };
    CanvasService.prototype.initCanvas = function () {
        this.canvas = new fabric.Canvas('workarea', { selection: false, defaultCursor: "move" });
        this.resizeCanvas();
        this.mouseUpEvent();
        this.mouseDownEvent();
        this.mouseMoveEvent();
        this.setupFloor();
    };
    CanvasService.prototype.resizeCanvas = function () {
        this.canvas.setHeight(window.innerHeight);
        this.canvas.setWidth(window.innerWidth);
    };
    CanvasService.prototype.mouseUpEvent = function () {
        var _this = this;
        this.canvas.on('mouse:up', function (e) { return _this.panning = false; });
    };
    CanvasService.prototype.mouseDownEvent = function () {
        var _this = this;
        this.canvas.on('mouse:down', function (e) { return _this.panning = true; });
    };
    CanvasService.prototype.mouseMoveEvent = function () {
        var _this = this;
        this.canvas.on('mouse:move', function (e) {
            if (_this.panning && e && e.e) {
                var delta = new fabric.Point(e.e.movementX, e.e.movementY);
                _this.canvas.relativePan(delta);
            }
        });
    };
    CanvasService.prototype.zoomIn = function () {
        this.canvas.setZoom(this.canvas.getZoom() * 1.1);
    };
    CanvasService.prototype.zoomOut = function () {
        this.canvas.setZoom(this.canvas.getZoom() / 1.1);
    };
    CanvasService.prototype.zoomReset = function () {
        this.canvas.setZoom(1);
    };
    CanvasService.prototype.zoom = function (e) {
        var evt = window.event || e;
        var delta = (evt.detail) ? (evt.detail * (-120)) : (evt.wheelDelta);
        var curZoom = this.canvas.getZoom();
        var newZoom = curZoom + delta / 4000;
        var x = e.offsetX, y = e.offsetY;
        //applying zoom values.
        this.canvas.zoomToPoint({ x: x, y: y }, newZoom);
        if (e != null) {
            e.preventDefault();
        }
        return false;
    };
    /* Used to add slider functionality
    changeZoomLevel():void{
     this.canvas.setZoom(1);
     var value=(50-this.value)/100;
     if (value < 0)
     {
     canvas.setZoom(canvas.getZoom() * (1 - value ));
     }
     else {
     canvas.setZoom(canvas.getZoom() / (1 + value));
     }
     }*/
    CanvasService.prototype.setupFloor = function () {
        var _this = this;
        this.canvas.setBackgroundColor({ source: this.utilService.IMG_PATH + this.utilService.FLOOR_PATTERN_FILE, repeat: 'repeat' }, function () { return _this.canvas.renderAll(); });
    };
    CanvasService.prototype.drawTable = function (table) {
        var _this = this;
        fabric.util.loadImage(this.utilService.IMG_PATH + this.utilService.TABLE_PATTERN_FILE, function (img) {
            _this.canvas.add(new fabric.Rect({
                left: table.getLeftTopPoint().getX() * _this.utilService.GRID_SIZE,
                top: table.getLeftTopPoint().getY() * _this.utilService.GRID_SIZE,
                width: table.getWidth() * _this.utilService.GRID_SIZE,
                height: table.getLength() * _this.utilService.GRID_SIZE,
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
        this.canvas.renderAll();
    };
    CanvasService.prototype.drawChair = function (chair) {
        //Seat
        var mid = new fabric.Rect({
            left: chair.x + 2 * this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE + this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            top: chair.y + 2 * this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE + this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            stroke: 'grey',
            width: chair.width - 4 * this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE - 2 * this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            height: chair.height - 4 * this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE - 2 * this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            rx: this.utilService.CHAIR_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE,
            ry: this.utilService.CHAIR_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE
        });
        //Left Arm
        var leftArm = new fabric.Rect({
            left: chair.x + this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE,
            top: chair.y + chair.height / 4,
            stroke: 'grey',
            width: this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            height: chair.height / 2,
            rx: this.utilService.ARM_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE,
            ry: this.utilService.ARM_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE
        });
        //Right Arm
        var rightArm = new fabric.Rect({
            left: chair.x + chair.width - this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE - this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            top: chair.y + chair.height / 4,
            stroke: 'grey',
            width: this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            height: chair.height / 2,
            rx: this.utilService.ARM_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE,
            ry: this.utilService.ARM_BORDER_RADIUS_RATIO * this.utilService.GRID_SIZE
        });
        //UpperArm
        var upperArm = new fabric.Rect({
            left: chair.x + chair.width / 4,
            top: chair.y + this.utilService.CHAIR_PADDING * this.utilService.GRID_SIZE,
            stroke: 'grey',
            width: chair.width / 2,
            height: this.utilService.MIN_BLOCK_SIZE_RATIO * this.utilService.GRID_SIZE,
            rx: 0,
            ry: 0
        });
        var group = new fabric.Group([leftArm, rightArm, mid, upperArm], {
            left: chair.x + chair.width / 2,
            top: chair.y + chair.height / 2,
            originX: 'center',
            originY: 'center',
            selectable: false,
            angle: chair.angle,
            fill: "#cccccc",
            entity: "chair",
            deskid: chair.deskid
        });
        this.canvas.add(group);
    };
    CanvasService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [util_service_1.UtilService])
    ], CanvasService);
    return CanvasService;
}());
exports.CanvasService = CanvasService;
//# sourceMappingURL=canvas.service.js.map