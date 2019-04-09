<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>


<body background="img/login.jpg">

	<div class="container-fluid">
		<%@include file="header.jsp"%>


		<div class="row">
			<div>
				<h3 style="visibility: hidden">don't show it</h3>
			</div>
		</div>

		<form action='generateotp' method='post'>

			<div id="error_msg" style="color:red">
				<strong>generated otp will be your new password for sometime</strong>
			</div>
			

			<div class="row">
				<div class="col-sm-12">
					<input type="text" name="email" placeholder="Enter Email Id" required>
				</div>
			</div>


			<div class="row">
				<div class="col-sm-12">
					<input type="submit" value="generate otp">
				</div>
			</div>

		</form>


	</div>

	<%@include file="footer.jsp"%>
</body>
</html>
