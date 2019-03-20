<%@page import="project.com.bo.Report"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/getreport.css">
<title>Reports</title>
</head>
<body>
<body background="image/doctor6.jpg">
	<%
		List<Report> list = null;
		if (request.getAttribute("reportlist") != null) {
			list = (List<Report>) request.getAttribute("reportlist");
		}
		
		List<String> namelist = null;
		if (request.getAttribute("namelist") != null) {
			namelist = (List<String>) request.getAttribute("namelist");
		}
		
	%>
	<div style="overflow-x: auto;">
		<table border='1' align="center">
			<caption>REPORTS</caption>
			<tr>
				<th>ReportId</th>
				<th>PatientId</th>
				<th>PatientName</th>
				<th>Action</th>
			</tr>
			
			<% for (int i = 1; i <= list.size(); i++) {
				%>

			<tr>	
				<td><%=list.get(i-1).getP_id()%></td>
				<td><%=list.get(i-1).getR_id()%></td>
				<td><%=namelist.get(i-1)%></td>
				<td><a href="reportdown?id=<%=list.get(i-1).getR_id() %>">view</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>