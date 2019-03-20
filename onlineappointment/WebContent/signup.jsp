<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/signup.css">
</head>

<body background="img/login.jpg">
	<div class="container-fluid">

		<%@include file="header.jsp"%>

		<div class="row">
			<div>
				<h3 style="visibility: hidden">don't show it</h3>
			</div>
		</div>

		<%
			String message = null;
			if (request.getAttribute("message") != null) {
				message = (String) request.getAttribute("message");
			}
		%>


		<div class="form_outline">
			<form action="patientsignup" method="post">
				<div id="new_aptmt" style="margin-left: 0px">New Account</div>

				<%
					if (message != null) {
				%>
				<div id="error_msg" style="color:red;">
					<center>
						<strong><%=message%></strong>
					</center>
				</div>
				<%
					}
				%>



				<div class="row">
					<div class="col-25">
						<label for="Email">Email</label>
					</div>
					<div class="col-75">
						<input type="email" id="email" name="email"
							placeholder="Your Email" required>
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="fname">First Name</label>
					</div>
					<div class="col-75">
						<input type="text" id="fname" name="firstname"
							placeholder="Your name.." required>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="lname">Last Name</label>
					</div>
					<div class="col-75">
						<input type="text" id="lname" name="lastname"
							placeholder="Your last name.." required>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="lname">Password</label>
					</div>
					<div class="col-75">
						<input type="password" id="lname" name="password"
							placeholder="Set password for future reference.." required>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="Age">Age</label>
					</div>
					<div class="col-75">
						<input type="text" id="Age" name="age"
							placeholder="Your age in years..." required>
					</div>
				</div>



				<div class="row">
					<div class="col-25">
						<label for="Contact-no">Contact No</label>
					</div>
					<div class="col-75">
						<input type="text" id="Contact-no" name="contactno"
							placeholder="Your contact details" required>
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="gender">Gender</label>
					</div>
					<div class="col-75" id="gender">
						<input type="radio" name="gender" value="ma" checked> Male
						&nbsp &nbsp <input type="radio" name="gender" value="f">
						Female &nbsp &nbsp <input type="radio" name="gender" value="o">
						Other
					</div>
				</div>

				<div class="row">
					<!-- <center><input type="button" value="cancel"> -->
					<center>
						<input type="submit" value="Create">
					</center>
				</div>

			</form>
		</div>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>