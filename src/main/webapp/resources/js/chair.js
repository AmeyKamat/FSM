function Chair(chairJSON){
	this.x = chairJSON.x;
	this.y = chairJSON.y;
	this.angle = chairJSON.angle;
	this.deskid = chairJSON.deskid;
	this.brid = chairJSON.brid;
	this.chairAdjustment = [[0,0], [1,0], [1,1], [0,1]];
	console.log("Creating chair no." + this.deskid + " at (" + this.x + ", " + this.y + ") at angle " + this.angle);
}

Chair.prototype.drawChair = function() {
    var chair = {
        x: this.x*ENV.gridSize,
        y: this.y*ENV.gridSize,
        width: ENV.gridSize,
        height: ENV.gridSize,
        angle: this.angle,
        deskid: this.deskid
    }
    drawChairImage(chair);
	//var that = this;
	// fabric.Image.fromURL(IMG_PATH + CHAIR_FILE, function(chair) {      
 //    chair.set({'width':ENV.gridSize});
 //    chair.set({'height':ENV.gridSize});
 //    chair.set({'left':(that.x+that.chairAdjustment[that.angle/90][0])*ENV.gridSize});
 //    chair.set({'top':(that.y+that.chairAdjustment[that.angle/90][1])*ENV.gridSize});
 //    chair.set({'hasControls': false});
 //    chair.set({'centeredRotation': true});
 //    chair.set({'angle': that.angle});
 //    chair.set({'entity': 'chair'})
 //    chair.set({'deskid': that.deskid});
 //    chair.set({'brid': that.brid});
 //    chair.set({'selectable': false});
 //    chair.set({'hoverCursor': 'pointer'})
 //    canvas.add(chair);        
 //  });
};