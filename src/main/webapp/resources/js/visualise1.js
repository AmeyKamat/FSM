var canvas = new fabric.Canvas('workarea', {selection: false, defaultCursor: "move"});

var loader = document.getElementById("loader");
var errorModal = $("#errorModal");

 function initialiseFromDummy(floorInput, desksInput){
   var floor = new Floor(floorInput);
   floor.setDesks(desksInput)
   floor.createFloorLayout();
 }

var ENV = {
	gridsPerChair: 1,
	chairBorderRadiusRatio : 0.08,
	armBorderRadiusRatio : 0.05,
	tableBorderRadiusRatio : 0.125,
	minBlockSizeRatio : 0.1,
	chairPadding : 0.1
};


 
 function initialise(){
	  loader.setAttribute('style', "display:block")
	  $.ajax({url: GET_LAYOUT_URL, success: function(result){
		  loader.setAttribute('style', "display:none");
		  var inputObj = result;
		  var floor = new Floor(inputObj);
	    
	    if(result = ""){
	      uploadModal.modal('show');
	    }
	    else{
	      
	    	
	          var desksList = inputObj.tableList;
	          floor.setDesks(desksList);
	          floor.createFloorLayout();
	    } 
	     
	  },
	  error: function(error, statusText){
	    document.getElementById("loader").setAttribute('style', "display:none");
	    errorModal.modal("show");
	  }});
	}


window.onload = function(e){
initialise();
//initialiseFromDummy(sampleInputFloor, sampleInputDesks);
}