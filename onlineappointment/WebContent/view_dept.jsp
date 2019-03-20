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
table{
  margin: auto;
  z-index: 1;
}
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
       List<Department> deptList = (List<Department>)request.getAttribute("deptlist");
     %>

	<div class="heading">DEPARTMENTS</div>
	<%@include file="adminheader.jsp"%>
	<div class="row" id="content_body">
	
		<div class="col-md-2" id="sidebar">
			<%@include file="admin_menu.jsp"%>
		</div>


		<div class="col-md-10" id="main">
         <table border="1" width="60%">
            <tr>
            <th>Department Id</th>
            <th>Name</th>
            <th>Diseases</th>
            <th>Action</th>
            </tr>
            <%for(int row=1;row<=deptList.size();row++){ %>
                 <%Department dept = deptList.get(row-1); %>
                 <tr>
                 <td><%=dept.getDept_id() %></td>
                 <td><%=dept.getDept_name().toUpperCase() %></td>
                 <td><%=dept.getDiseases() %></td>
                 <td><a href="deletecontroller?id=<%=dept.getDept_id()%>">remove</a> <br>
                 <a href="updatecontroller?id=<%=dept.getDept_id()%>">update</a></td>
                 </tr>
            
            <%} %>
         </table>
        
        </div>
    
    </div>
</body>
</html>

