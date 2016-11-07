var uploadModal = $("uploadModal");

var scope = {};

function changeCity(){
	var country = document.getElementById("select-country").country
}
	
var layouts = document.getElementsByClassName('file');
for(var layoutNo=0; layoutNo < layouts.length; layoutNo++){
	layouts[layoutNo].addEventListener("click", getFloorLayout, false);
}

function getFloorLayout(event){
	var target = event.target;
	document.getElementById("loader").setAttribute('style', "display:block");
	$.ajax({
		url: GET_LAYOUT_URL,
		type: "POST",
		data: JSON.stringify({
			"country": target.dataset.country,
			"city": target.dataset.city,
			"branch": target.dataset.branch,
			"floor": target.dataset.floor
		}),
		contentType: "application/json",
		success: function(result){
			document.getElementById("loader").setAttribute('style', "display:none");
			canvas.clear();
			var floor = new Floor(result);
			floor.createFloorLayout();
		},
		error: function(error){
			document.getElementById("loader").setAttribute('style', "display:none");
			errorModal.modal("show");
		}
	});
}