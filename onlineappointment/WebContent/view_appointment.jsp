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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="css\style.css">
<style>
.main {
 margin-left: 160px; /* Same as the width of the sidenav */
 padding: 0px 10px;
 margin-top:50px;
  height:100%;
 background-image:url("images/background.png");
background-repeat:no-repeat;
 background-size:cover;
 width:100%;
}
.tab{
font-size:20px;
text-align:center;
padding:40px;
margin-top:30px;
margin-left:20px;
}
.tab th{
text-align:center;
}
</style>
</head>
<body>	
<div class="heading">
APPOINTMENT OF PATIENT
</div>
<%@include file="adminheader.jsp" %>
<div class="main">
<div class="not_main">
<table class='tab' border='1' width='100%'>
<tr>
<th>Doctor id</th>
<th>Date of appointment</th>
<th>Department Id</th>
<th>Diagnosed</th>
</tr>
<% String email = request.getParameter("email");
List<Patient> pat = new ArrayList<Patient>();
PatientDao dao = DaoFactory.getPatientDao();
pat = dao.view_all_appointment(email);
for(Patient list : pat){%>
<tr>
<td><%=list.getD_id()%></td>
<td><%=list.getDoa()%></td>
<td><%=list.getDept_id()%></td>
<td><%=list.getIsDiagnosed()%></td>
</tr>
<%} %>
<a style="color:black;" href="patient_vew.jsp">back</a>
</table>
</div>
</div>
<script>
    window.onscroll = function() {myFunction()};
    var navbar = document.getElementById("myHeader");
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
    
    