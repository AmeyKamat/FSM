
// $(document).ready(function(){
// 	initializeCanvas();
// 	for(var i = 0 ; i < chairArray.length ; i++ ){
// 		drawChair(chairArray[i]);
// 	}
// 	//drawSemi();

// 	canvas.on('mouse:over' , function(e){
// 		//console.log("Object: "+e);
// 		e.target.setFill('red');
// 		canvas.renderAll();
// 	});

// 	canvas.on('mouse:out' , function(e){
// 		//console.log("Object: "+e);
// 		e.target.setFill('transparent');
// 		canvas.renderAll();
// 	});
// 	//drawRect();
// });



function drawChairImage(chair){
	//Seat
	var mid = new fabric.Rect({
		left : chair.x + 2*ENV.chairPadding*ENV.gridSize + ENV.minBlockSizeRatio*ENV.gridSize,
		top :  chair.y + 2*ENV.chairPadding*ENV.gridSize + ENV.minBlockSizeRatio*ENV.gridSize,
		//originX : 'center',
		//originY : 'center',
		stroke : 'grey',
	//	fill : 'transparent',
		width : chair.width - 4*ENV.chairPadding*ENV.gridSize -2*ENV.minBlockSizeRatio*ENV.gridSize,
		height : chair.height - 4*ENV.chairPadding*ENV.gridSize -2*ENV.minBlockSizeRatio*ENV.gridSize,
		rx : ENV.chairBorderRadiusRatio*ENV.gridSize,
		ry : ENV.chairBorderRadiusRatio*ENV.gridSize
	});


	//Left Arm
	var leftArm = new fabric.Rect({
		left : chair.x + ENV.chairPadding*ENV.gridSize,
		top :  chair.y + chair.height/4,
		//originX : 'center',
		//originY : 'center',
		//fill : 'transparent',
		stroke : 'grey',
		width : ENV.minBlockSizeRatio*ENV.gridSize,
		height : chair.height/2,
		rx : ENV.armBorderRadiusRatio*ENV.gridSize,
		ry : ENV.armBorderRadiusRatio*ENV.gridSize
	});

	//Right Arm
	var rightArm = new fabric.Rect({
		left : chair.x + chair.width - ENV.chairPadding*ENV.gridSize - ENV.minBlockSizeRatio*ENV.gridSize,
		top :  chair.y + chair.height/4,
		//originX : 'center',
		//originY : 'center',
		//fill : 'transparent',
		stroke : 'grey',
		width : ENV.minBlockSizeRatio*ENV.gridSize,
		height : chair.height/2,
		rx : ENV.armBorderRadiusRatio*ENV.gridSize,
		ry : ENV.armBorderRadiusRatio*ENV.gridSize
	});

	//UpperArm
	var upperArm = new fabric.Rect({
		left : chair.x + chair.width/4,
		top :  chair.y + ENV.chairPadding*ENV.gridSize,
		//originX : 'center',
		//originY : 'center',
		//fill : 'transparent',
		stroke : 'grey',
		width : chair.width/2,
		height : ENV.minBlockSizeRatio*ENV.gridSize,
		rx : 0,
		ry : 0
	});


	/*var rect3 = new fabric.Rect({
		left : gridX,
		top : gridY,
		fill : 'transparent',
		stroke : 'grey',
		width : gridWidth,
		height : gridHeight,
		rx : 0,
		ry : 0
	});

	var semicircle = new fabric.Circle({
		radius : gridWidth/4,
		left : gridX + gridWidth/2 - gridWidth/4 ,
		top :  gridY + padding + minBlockSize - gridWidth/4 + 10, 
		fill : 'white',
		stroke: 'grey',
		startAngle : Math.PI + Math.PI/10,
		endAngle   : Math.PI * 2 - Math.PI/10,
		strokeWidth : 1
	});*/

	var group = new fabric.Group([leftArm,rightArm,mid,upperArm],{
		left : chair.x + chair.width/2,
		top  : chair.y + chair.height/2,
		originX : 'center',
		originY : 'center',
		selectable : false,
		angle : chair.angle,
		fill: "#cccccc",
		entity : "chair",
		deskid: chair.deskid
	});
	

	//canvas.add(rect3);
	canvas.add(group);
}

/*function drawSemi(){
	var semicircle = new fabric.Circle({
		radius : 50,
		originX :  23,
		originY :  'center', 
		fill : 'transparent',
		stroke: 'grey',
		//startAngle : 0,
		//endAngle   : Math.PI,
	});

	var rect3 = new fabric.Rect({
		left : 100,
		top : 100,
		fill : 'transparent',
		stroke : 'grey',
		width : 100,
		height : 100,
		rx : 0,
		ry : 0
	});

	canvas.add(rect3);
	canvas.add(semicircle);
}

function resizeImage(chair,img){
	var mWidth = pixelSize * chair.width - 2*(2*padding + minBlockSize) ;
	var mHeight = pixelSize * chair.height - 2*(2*padding + minBlockSize);
	var cRatio = img.width/img.height;
	var mRatio = mWidth/mHeight;

	if(mRatio  > cRatio){
		img.height = mHeight;
		img.width =  mHeight * cRatio;
	}
	else{
		img.width = mWidth;
		img.height =  mWidth /cRatio;
	}

	console.log(img.width);
	console.log(img.height);
	return img;
}
*/



