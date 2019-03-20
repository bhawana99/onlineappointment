<%@page import="project.com.bo.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/dashboard.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<%Doctor doctor = null;
   if(session.getAttribute("doctor")!=null){
	   doctor = (Doctor)session.getAttribute("doctor");
   } 
%>
<body background="image/doctor6.jpg">
	<div class="container" id="grad">

		<h3 style="float: left;" class="heading1">DASHBOARD</h3>
		<h3 style="float: right; padding-right: 50px;" class="heading2">
			<%=doctor.getD_name()%>
			<div>
				<u><a href="logout">LogOut</a></u>
			</div>
		</h3>
	</div>

	<div class="row" id="d1">
		<div class="col-sm-4" id="c1">
			<a href="totalpatient?doctorId=<%=doctor.getD_id()%>"><img src="image/icon1.png" class="img1"><br>TOTAL
				PATIENT</a>
		</div>
		<div class="col-sm-4" id="c2">
			<a href="todaypatient?doctorId=<%=doctor.getD_id()%>"><img src="image/icon4.png" class="img2"><br>TODAYS
				APPOINTMENT</a>
		</div>
		<div class="col-sm-4" id="c3">
			<a href="getreport?doctorId=<%=doctor.getD_id()%>"><img src="image/report.jpg" class="img3"><br>PATIENT REPORTS</a>
		</div>
	</div>

</body>
</html>