<%@page import="project.com.bo.Report"%>
<%@page import="project.com.bo.Patient"%>
<%@page import="project.com.dao.PatientDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.com.bo.Department"%>
<%@page import="java.util.List"%>
<%@page import="project.com.dao.factory.DaoFactory"%>
<%@page import="project.com.dao.DepartmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css\style.css">
<style>
th,td{
	font-size: 15px;
	text-align: center;
	padding: 0px;
	margin-top: 30px;
}
</style>
</head>
<body background="img/admin.jpg">
     <%
     List<Report> list = null;
		if (request.getAttribute("reportlist") != null) {
			list = (List<Report>) request.getAttribute("reportlist");
		}
		
		List<String> doctor_namelist = null;
		if (request.getAttribute("doctor_namelist") != null) {
			doctor_namelist = (List<String>) request.getAttribute("doctor_namelist");
		}
		
		List<String> namelist = null;
		if (request.getAttribute("namelist") != null) {
			namelist = (List<String>) request.getAttribute("namelist");
		}
     %>

	<div class="heading">REPORTS</div>
	<%@include file="adminheader.jsp"%>
	<div class="row" id="content_body">
	
		<div class="col-md-2" id="sidebar">
			<%@include file="admin_menu.jsp"%>
		</div>


		<div class="col-md-10" id="main">
         <table border="1" width="100%">
            <tr>
            <th>Appointment ID</th>
            <th>Patient Name</th>
            <th>Doctor Name</th>
            <th>Action</th>
            </tr>
            
            <% for (int i = 1; i <= list.size(); i++) {
				%>

			<tr>	
				<td><%=list.get(i-1).getP_id()%></td>
				<td><%=namelist.get(i-1) %></td>
				<td><%=doctor_namelist.get(i-1)%></td>
				<td><a href="reportdown?id=<%=list.get(i-1).getR_id() %>">view</a> &nbsp; &nbsp; &nbsp;
				<a href="reportdelete?id=<%=list.get(i-1).getR_id() %>">remove</a></td>
			</tr>
			<%
		}
			%>
            
         </table>
        
        </div>
    
    </div>
</body>
</html>

