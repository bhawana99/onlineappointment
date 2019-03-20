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
       List<Patient> patientList = (List<Patient>)request.getAttribute("patientList");
     %>

	<div class="heading">PATIENT DETAILS</div>
	<%@include file="adminheader.jsp"%>
	<div class="row" id="content_body">
	
		<div class="col-md-2" id="sidebar">
			<%@include file="admin_menu.jsp"%>
		</div>


		<div class="col-md-10" id="main">
         <table border="1" width="100%">
            <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Email</th>
            <th>Contact</th>
            </tr>
            <%for(int row=1;row<=patientList.size();row++){ %>
                 <%Patient patient = patientList.get(row-1); %>
                 <tr>
                 <td><%=patient.getP_fname().toUpperCase()+" "+patient.getP_lname().toUpperCase() %></td>
                 <td><%=patient.getP_gender() %></td>
                 <td><%=patient.getP_age() %></td>
                 <td><%=patient.getP_email() %></td>
                 <td><%=patient.getP_contact() %></td>
                 </tr>
            
            <%} %>
         </table>
        
        </div>
    
    </div>
</body>
</html>

