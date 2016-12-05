<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<script>
	function showPassword() {

		var key_attr = $('#key').attr('type');

		if (key_attr != 'text') {

			$('.checkbox').addClass('show');
			$('#key').attr('type', 'text');

		} else {

			$('.checkbox').removeClass('show');
			$('#key').attr('type', 'password');

		}

	}
</script>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login {
	padding-top: 50px
}

#login .form-wrap {
	width: 30%;
	margin: 0 auto;
}

#login h1 {
	color: #333;
	font-size: 18px;
	text-align: center;
	font-weight: bold;
	padding-bottom: 20px;
}

#login .form-group {
	margin-bottom: 25px;
}

#login .checkbox {
	margin-bottom: 20px;
	position: relative;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	-o-user-select: none;
	user-select: none;
}

#login .checkbox.show:before {
	content: '\e013';
	color: #1fa67b;
	font-size: 17px;
	margin: 1px 0 0 3px;
	position: absolute;
	pointer-events: none;
	font-family: 'Glyphicons Halflings';
}

#login .checkbox .character-checkbox {
	width: 25px;
	height: 25px;
	cursor: pointer;
	border-radius: 3px;
	border: 1px solid #ccc;
	vertical-align: middle;
	display: inline-block;
}

#login .checkbox .label {
	color: #6d6d6d;
	font-size: 13px;
	font-weight: normal;
}

#login .btn.btn-custom {
	font-size: 14px;
	margin-bottom: 20px;
}

#login .forget {
	font-size: 13px;
	text-align: center;
	display: block;
}

/*    --------------------------------------------------
        :: Inputs & Buttons
        -------------------------------------------------- */
.form-control {
	color: #212121;
}

.btn-custom {
	color: #fff;
	background-color: #555;
}

.btn-custom:hover, .btn-custom:focus {
	color: #fff;
}

/*    --------------------------------------------------
        :: Footer
        -------------------------------------------------- */
#footer {
	color: #6d6d6d;
	font-size: 12px;
	text-align: center;
}

#footer p {
	margin-bottom: 0;
}

#footer a {
	color: inherit;
}
</style>
<body onload='document.loginForm.username.focus();'>
	
	<link rel="stylesheet" type="text/css"
		href="/resources/node_modules\bootstrap\dist\css\bootstrap.min.css">




	<section id="login">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="form-wrap">
						<h1>Log in</h1>

						<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>

						<form name="loginForm" role="form" action="<c:url value='j_spring_security_check' />" method="POST"
							id="login-form" autocomplete="off">
							<div class="form-group">
								<label for="username" class="sr-only">Username</label> <input
									type="text" name="username" id="user" class="form-control"
									placeholder="username">
							</div>
							<div class="form-group">
								<label for="password" class="sr-only">Password</label> <input
									type="password" name="password" id="password"
									class="form-control" placeholder="Password">
							</div>
							<div class="checkbox">
								<span class="character-checkbox" onclick="showPassword()"></span>
								<span class="label">Show password</span>
							</div>
							<input type="submit" id="btn-login"
								class="btn btn-custom btn-lg btn-block" value="Log in">

							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
						<a href="javascript:;" class="forget" data-toggle="modal"
							data-target=".forget-modal">Forgot your password?</a>
						<hr>
					</div>
				</div>
				<!-- /.col-xs-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</section>

	<div class="modal fade forget-modal" tabindex="-1" role="dialog"
		aria-labelledby="myForgetModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Recovery password</h4>
				</div>
				<div class="modal-body">
					<p>Type your email account</p>
					<input type="email" name="recovery-email" id="recovery-email"
						class="form-control" autocomplete="off">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-custom">Recovery</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<footer id="footer">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<p>
						Powered by <strong>Barclays</strong>
					</p>
				</div>
			</div>
		</div>
	</footer>



</body>
</html>
