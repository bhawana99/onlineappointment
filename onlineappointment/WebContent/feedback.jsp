<!DOCTYPE html>
<%@page import="project.com.bo.Feedback"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/feedback.css">
<link type="text/css" rel="stylesheet" href="css/home.css">
<script type="text/javascript" src="main.js"></script>
</head>


<body background="img/login.jpg">
	<div class="container-fluid">


		<%@include file="header.jsp"%>

		<div class="row" id="dropdown">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="home.jsp" id="a">Back to Home</a></li>
					<li><a href="login.jsp" id="a">Get an Appointment</a></li>
					<li><a href="reportlogin.jsp" id="a">Online Lab Reports</a></li>
				</ul>
			</div>
		</div>

		<%
			String message = null;
			if (request.getAttribute("message") != null) {
				message = (String) request.getAttribute("message");
			}

			List<Feedback> feedbackList = null;
			if (request.getAttribute("feedbacklist") != null)
				feedbackList = (List<Feedback>) request
						.getAttribute("feedbacklist");
		%>

		<div class="row">
			<div class="col-md-6"
				style="background-color: rgba(255, 255, 255, 0.5);">
				<form action="feedbackpost" method="post">

					<div id="aptmt_receipt" style="margin-left: 0px">Request you
						to provide your Feedback.</div>
					<hr>

					<%
						if (message != null) {
					%>
					<div class="row" id="error_msg" style="color: blue">
						<div>
							<strong style="visibility: visible;"><%=message%></strong>
						</div>
					</div>
					<%
						request.setAttribute("message", "");
					%>
					<%
						} else {
					%>
					<div class="row" id="error_msg" style="color: blue">
						<div>
							<strong style="visibility: hidden;">Don't show it</strong>
						</div>
					</div>

					<%
						}
					%>


					<div class="row">
						<div class="col-sm-6">
							<label>Name</label><br> <input type="text" name="name"
								placeholder="Enter Name" required="required">
						</div>

						<div class="col-sm-6">
							<label>Email</label><br> <input type="text" name="email"
								placeholder="Enter Email Id" required="required">
						</div>
					</div>

					<div class='row'>
						<div class="col-sm-12">
							<label style="padding-top: 10px;">Your Review</label><br>
							<textarea name="review" maxlength="300" rows="4" cols="80"
								placeholder="Write your feedback here" required="required">
		   </textarea>
						</div>
					</div>

					<div class="row">
						<center>
							<input type="submit" value="Submit">
						</center>
					</div>

				</form>
			</div>

			<div class="col-md-6">
				<div class="row" id="feedback_heading">
					<div>
						<strong>READ FEEDBACK</strong>
					</div>
				</div>

				<%
					if (feedbackList.size() > 0) {
				%>
				<%
					for (int f = feedbackList.size(); f >=1; f--) {
											Feedback feedback = feedbackList.get(f-1);
				%>
				<div id="feebback">
					<div class="row" id="heading">
						<div class="col-md-6">
							<strong><%=feedback.getName()%></strong>
						</div>
						<div class="col-md-6" style="float: right;">
							posted on: <strong><%=feedback.getDof()%></strong>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12" id="feebback_content"><%=feedback.getReview()%></div>
					</div>

				</div>
				<%
					}
				%>
				<%
					} else {
				%>
				<center>
					<strong>No Feedback posted yet</strong>
				</center>
				<%
					}
				%>


			</div>

		</div>

		<%@include file="footer.jsp"%>
		<script>
			window.onscroll = function() {
				myFunction()
			};
			var navbar = document.getElementById("top");
			var sticky = navbar.offsetTop;

			function myFunction() {
				if (window.pageYOffset >= sticky) {
					navbar.classList.add("sticky")
				} else {
					navbar.classList.remove("sticky");
				}
			}
		</script>
</body>
</html>
