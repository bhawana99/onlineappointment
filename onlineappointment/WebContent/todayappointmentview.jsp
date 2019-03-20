<%@page import="project.com.bo.Patient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/todayappointment.css">
<title>Todays appointment</title>
</head>
<body background="image/doctor6.jpg">
	<%
		List<Patient> list = null;
		if (request.getAttribute("patientlist") != null) {
			list = (List<Patient>) request.getAttribute("patientlist");
		}
	%>
	<div style="overflow-x: auto;">
		<table border='1' align="center">
			<caption>TODAY'S APPOINTMENT</caption>
			<tr>
				<th colspan="2">Name</th>
				<th>PatientId</th>
				<th>Age</th>
				<th>Gender</th>
				<th>EmailId</th>
				<th>ContactNumber</th>
				<th>DateOfAppointment</th>
				<th>IsDiagnosed</th>
			</tr>
			<%
				for (int i = 1; i <= list.size(); i++) {
			%>

			<tr>
				<td colspan="2"><%=list.get(i - 1).getP_fname()%> <%=list.get(i - 1).getP_lname()%></td>
				<td><%=list.get(i - 1).getP_id()%></td>
				<td><%=list.get(i - 1).getP_age()%></td>
				<td><%=list.get(i - 1).getP_gender()%></td>
				<td><%=list.get(i - 1).getP_email()%></td>
				<td><%=list.get(i - 1).getP_contact()%></td>
				<td><%=list.get(i - 1).getDoa()%></td>
				<td><%=list.get(i - 1).getIsDiagnosed()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>