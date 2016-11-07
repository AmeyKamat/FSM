var panning = false;
var canvasZoomElement = document.getElementById("canvasZoomElement");

canvas.on('mouse:up', function (e) {
    panning = false;
});

canvas.on('mouse:down', function (e) {
    panning = true;
});

canvas.on('mouse:move', function(e) {
	if (panning && e && e.e) {
		var delta = new fabric.Point(e.e.movementX, e.e.movementY);
		canvas.relativePan(delta);
	}
});

function changeZoomLevel(){
	canvas.setZoom(1);
	var value=(50-this.value)/100;
	if (value < 0)
	{
		canvas.setZoom(canvas.getZoom() * (1 - value ));
	}
	else {
		canvas.setZoom(canvas.getZoom() / (1 + value));
	}
}

function zoomIn(){
	canvas.setZoom(canvas.getZoom()*1.1) ;
}

function zoomOut(){
	canvas.setZoom(canvas.getZoom()/1.1) ;
}

function zoomReset(){
	canvas.setZoom(1);
}

if(canvasZoomElement.addEventListener){
	// IE9, Chrome, Safari, Opera
	canvasZoomElement.addEventListener("mousewheel", zoom, false);
	// Firefox
	canvasZoomElement.addEventListener("DOMMouseScroll", zoom, false);
}
else{
	// IE 6/7/8
	canvasZoomElement.attachEvent("onmousewheel", zoom);
}

function zoom(e){
	console.log("zoom")
	var evt = window.event || e;
	var delta = (evt.detail)?(evt.detail*(-120)):(evt.wheelDelta);
	var curZoom = canvas.getZoom();
	var newZoom = curZoom + delta/4000;
	var x = e.offsetX, y = e.offsetY;
	//applying zoom values.
	canvas.zoomToPoint({x: x, y: y}, newZoom);
	if(e != null){
		e.preventDefault();
	}
	return false;
}