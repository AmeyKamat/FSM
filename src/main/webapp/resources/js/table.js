function Table(tableJSON){
	this.leftTopPoint = {x: tableJSON.topLeftX, y: tableJSON.topLeftY},
	this.width = tableJSON.columns;
	this.height = tableJSON.rows;
	this.orientation = (this.width>this.height)?"horizontal":"vertical";
	this.deskRows = JSON.parse(tableJSON.deskString);
}

Table.prototype.createTableLayout = function(){
	console.log("Table being drawn at (" + this.leftTopPoint.x + ", " + this.leftTopPoint.y + ") of dimensions " + this.width + "x" + this.height)
	this.drawTable();

	for(var deskRow = 0; deskRow<this.deskRows.length; deskRow++){
		this.createTableLayoutForRow(deskRow);	
	}
};

Table.prototype.createTableLayoutForRow = function(deskRow){
	console.log("Identifying row properties")
	if(this.orientation == "horizontal"){
		var variableCoord = this.leftTopPoint.x;
		var fixedCoord = this.leftTopPoint.y;

		var noOfDesksOnThisSide = this.deskRows[deskRow].length;
		var sidePaddingForChair = (this.width - noOfDesksOnThisSide*ENV.gridsPerChair)/(2*noOfDesksOnThisSide);
		if(deskRow == 1){fixedCoord += this.height; }
	}
	else if(this.orientation == "vertical"){
		var variableCoord = this.leftTopPoint.y;
		var fixedCoord = this.leftTopPoint.x;
		var noOfDesksOnThisSide = this.deskRows[deskRow].length;
		var sidePaddingForChair = (this.height - noOfDesksOnThisSide*ENV.gridsPerChair)/(2*noOfDesksOnThisSide);
		if(deskRow == 1){fixedCoord += this.width}
	}

	var chairAngle = this.getChairAngle(deskRow); 
	for(var deskNo=0; deskNo<this.deskRows[deskRow].length; deskNo++){
	    variableCoord += sidePaddingForChair;
	    if(this.orientation == "horizontal"){
	    	var chair = new Chair({
	    		x: variableCoord,
	    		y: fixedCoord,
	    		angle: chairAngle,
	    		deskid: this.deskRows[deskRow][deskNo]
	    	});
	      	chair.drawChair();

	    }
	    else if(this.orientation == "vertical"){
	      	var chair = new Chair({
	    		x: fixedCoord,
	    		y: variableCoord,
	    		angle: chairAngle,
	    		deskid: this.deskRows[deskRow][deskNo]
	    	});
	      	chair.drawChair();
	    }
	    variableCoord += ENV.gridsPerChair + sidePaddingForChair;
	}
}

Table.prototype.getChairAngle=function(deskRow){
	if(this.orientation == "horizontal" && deskRow==0){
		var angle = 0;
	}
	else if(this.orientation == "horizontal" && deskRow==1){
		var angle = 180;
	}
	else if(this.orientation == "vertical" && deskRow==0){
		var angle = 270;
	}
	else if(this.orientation == "vertical" && deskRow==1){
		var angle = 90;
	}

	return angle;
}

Table.prototype.drawTable = function(){
	if(this.orientation == "horizontal"){
		var x = this.leftTopPoint.x;
		var y = this.leftTopPoint.y+1;
		var width = this.width;
		//var height = this.height-1;
		var height = (this.height>1)?this.height-1:this.height;
	}
	else if(this.orientation == "vertical"){
		var x = this.leftTopPoint.x+1;
		var y = this.leftTopPoint.y;
		//var width = this.width -1;
		var width = (this.width>1)?this.width-1:this.width;
		var height = this.height;
	}
	console.log(y + " " + height)
	fabric.util.loadImage(IMG_PATH + TABLE_PATTERN_FILE, function(img) {
	    canvas.add(new fabric.Rect({ 
	      left: x*ENV.gridSize, 
	      top: y*ENV.gridSize,  
	      width: width*ENV.gridSize,
	      height: height*ENV.gridSize,
	      fill: '#9f9', 
	      originX: 'left', 
	      originY: 'top',
	      rx : ENV.tableBorderRadiusRatio*ENV.gridSize,
	      ry: ENV.tableBorderRadiusRatio*ENV.gridSize,
	      hasControls: false,
	      selectable: false,
	      fill: new fabric.Pattern({source:img}),
	      hoverCursor: 'move'
    	}));
  	});
  	canvas.renderAll();
  	console.log("Table Drawn")
};

