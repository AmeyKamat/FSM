function Floor(floorJSON){
  this.leftTopPoint = {x: floorJSON.minimumX, y: floorJSON.minimumY};
  this.rightBottomPoint = {x: floorJSON.maximumX, y: floorJSON.maximumY};
  this.height = this.rightBottomPoint.y
  this.width = this.rightBottomPoint.x
  this.tables = floorJSON.tableList;
  console.log("Width and Height: " + this.width + " " + this.height)

  ENV.xGridSize = window.innerWidth/this.width;
  ENV.yGridSize = window.innerHeight/this.height;
  console.log(ENV.xGridSize + " " + ENV.yGridSize) 
  ENV.gridSize = (ENV.xGridSize<ENV.yGridSize)?(ENV.xGridSize):(ENV.yGridSize);

  console.log("Floor created.")
}

Floor.prototype.createFloorLayout = function(){
  this.setupFloor();
  this.tables.forEach(function(tableJSON){
    var table = new Table(tableJSON);
    console.log("Creating Table Layouts")
    table.createTableLayout();
  });
};

Floor.prototype.setupFloor = function(){
  canvas.setBackgroundColor({source: IMG_PATH + FLOOR_PATTERN_FILE, repeat: 'repeat'}, function(){
    canvas.renderAll();
  });
}

Floor.prototype.setDesks = function(tableJSON){
  this.tables = tableJSON;
}