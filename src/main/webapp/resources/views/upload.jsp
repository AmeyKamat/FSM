<html>
	<body>
		<link rel="stylesheet" type="text/css" href="/fsm/resources/css/index.css">
		<link rel="stylesheet" type="text/css" href="/fsm/resources/lib/font-awesome-4.6.3/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="/fsm/resources/lib/bootstrap-3.3.7-dist\css\bootstrap.min.css">

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" id="uploadModal">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<form action="<%= request.getContextPath() %>/" method="post" enctype="multipart/form-data">
					  				<div class="modal-header">
					    				<h4 class="modal-title">File Upload</h4>
					  				</div>
					  				<div class="modal-body">
					    				<div class="row">
							  				<div class="col-md-12">
							  					<label>Upload floor layout: </label>
							  					<div>
							  						<div class="col-md-4">
							  							<input id="uploadFile" class="form-control" placeholder="No File Selected" disabled="disabled" />
							  						</div>
							  						<div class="fileUpload btn-circle-sm">
														<i class="fa fa-folder"></i>
														<input id="uploadBtn" name="file-upload" type="file" class="upload" />
													</div>
												</div>
							  				</div>
							  			</div>
					  				</div>
					  				<div class="modal-footer">
					    				<buton type="submit" class="btn" value="submit" style="background-color:black; color:white"><i class="fa fa-upload"></i> Upload</button>
					  				</div>
					  			</form>
							</div><!--/.modal-content -->
						</div><!-- /.modal-dialog -->
					</div><!-- /.modal -->
					<!-- <div class="jumbotron centered">
		  				<h3>Upload Layout</h3>
		  				<hr />
		  				<form action="<%= request.getContextPath() %>/" method="post" enctype="multipart/form-data">
		  					<div class="row">
			  					<div class="col-md-2">
			  						<input id="uploadFile" class="form-control" placeholder="Choose File" disabled="disabled" />
			  					</div>
								<div class="col-md-1 fileUpload btn btn-info">
									<span>Choose a file</span>
									<input id="uploadBtn" name="file-upload" type="file" class="upload" />
								</div>
								<div class="text-center">
			  						<input type="submit"  style="margin: 20px" class="btn btn-success" value="Upload" id="upload" name="upload" />
			  					</div>
			  				</div>
		  				</form> 
					</div>-->
				</div> 
			</div>

		</div>
		
		<script type="text/javascript" src="/fsm/resources/lib/jquery-3.1.0/jquery-3.1.0.min.js"></script>
		<script type="text/javascript" src="/fsm/resources/lib/bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
		<script>
			$("#uploadModal").modal("show")
			document.getElementById("uploadBtn").onchange = function () {
			  console.log(this.value);
			  var filePathString = this.value.split("\\")
			  document.getElementById("uploadFile").value = filePathString[filePathString.length - 1];
			};
		</script>
	</body>
</html>