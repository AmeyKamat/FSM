var tooltipSpan = document.getElementById('tooltip-span');
var deskInfo = document.getElementById('desk-info');
var employeeInfo = document.getElementById('employee-info');

canvas.on('mouse:over', function(e) {
     if(e.target.entity == "chair"){
      var element = e.target;
      e.target.set({fill:"#ccc"})
      var style = "display:block; position:fixed; overflow:hidden; background-color: black; color:white; padding:10px; box-shadow: 1px 1px 2px grey; border-radius:5px"
      tooltipSpan.setAttribute("style", style);
      deskInfo.innerHTML = "Desk Id: " + e.target.deskid;
      
      if(e.target.brid == "" || e.target.brid == undefined){
        deskInfo.innerHTML += "<br>Not Alloted";
      }
      else{
        employeeInfo.innerHTML = "Loading..."
      
        $.ajax({url: GET_EMPLOYEE_URL, success: function(result){
          employeeInfo.innerHTML = "BRID: " + result.brid + "<br>Employee Name: " + result.name + "<br>Date of Occupancy: " + result.doo + "<br>Team: " + result.team;
        },
        error: function(error){
          employeeInfo.innerHTML="Error Fetching Employee Information";
        }});
      }
      canvas.renderAll();
    }
  });

  canvas.on('mouse:out', function(e) {
  	if(e.target.entity == 'chair'){
	    tooltipSpan.setAttribute("style", "display:none;")
	    canvas.renderAll();
	}
  });

  window.onmousemove = function (e) {
    var x = e.clientX,
        y = e.clientY;
    tooltipSpan.style.top = (y + 20) + 'px';
    tooltipSpan.style.left = (x + 20) + 'px';
}; 