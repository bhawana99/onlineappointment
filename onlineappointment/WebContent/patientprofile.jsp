<!DOCTYPE html>
<%@page import="java.awt.print.Printable"%>
<%@page import="project.com.bo.Report"%>
<%@page import="java.util.List"%>
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
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://unpkg.com/gijgo@1.9.11/js/gijgo.min.js"
	type="text/javascript"></script>
<link href="https://unpkg.com/gijgo@1.9.11/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="css/patientprofile.css">

</head>
<body background="img/login.jpg">
	<div class="container-fluid">

		<%@include file="header.jsp"%>

		<%
			String message = null;
			if (session.getAttribute("message") != null) {
				message = (String) session.getAttribute("message");
			}
			
			
			List<Report> list = null;
			if (session.getAttribute("reportlist") != null) {
				list = (List<Report>) session.getAttribute("reportlist");
			}
			
			List<String> doctor_namelist = null;
			if (session.getAttribute("doctor_namelist") != null) {
				doctor_namelist = (List<String>) session.getAttribute("doctor_namelist");
			}
		%>


		<div class="row">
			<div>
				<h3 style="visibility: hidden">don't show it</h3>
			</div>
		</div>

		<div class="row" id="contentbody">

			<div id="profile">
				<%
					if (message != null) {
				%>
				<div class="row" id="error_msg" style="color: blue">
					<div>
						<center></center>
						<strong style="visibility: visible;"><%=message%></strong>
						</center>
					</div>
				</div>

				<%
					session.setAttribute("message","");
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

				<div id="heading">Patient's Profile</div>
				<br> Name :
				<%=patient.getP_fname().toUpperCase()%>
				<%=patient.getP_lname().toUpperCase()%><br> Email :
				<%=patient.getP_email()%><br> Age :
				<%=patient.getP_age()%><br> Gender :
				<%=patient.getP_gender().toUpperCase()%><br> Contact :
				<%=patient.getP_contact()%><br>

				<hr>
				<a href="appointment.jsp">Get an appointment</a><br> <a
					href="password_change.jsp">Change password</a>
			</div>

			<div id="reports">
				<div id="heading">Reports</div>
				
				<%if(list!=null && list.size()>0){ %>
				<table  align="center" width='90%'>
					<tr>
						<th>Report No</th>
						<th>Doctor Name</th>
						<th>Action</th>
					</tr>

					<%
						for (int i = 1; i <= list.size(); i++) {
					%>

					<tr>
						<td><%=i %></td>
						<td><%=doctor_namelist.get(i-1)%></td>
						<td><a href="reportdown?id=<%=list.get(i-1).getR_id()%>">view</a></td>
					</tr>
					<%
						}
					%>


				</table>
                <%}else{ %>
                   <center><strong>No Reports</strong></center>
                <%} %>

				<br>

			</div>
		</div>

	</div>

	<%@include file="footer.jsp"%>
	<script>
		$('#datepicker').datepicker({
			uiLibrary : 'bootstrap4'
		});
	</script>
</body>
</html>