<%@page import="project.com.bo.Doctor"%>
<%@page import="java.util.List"%>
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
#form {
	font-size: 20px;
	padding: 30px;
}
</style>
</head>
<body background="img/admin.jpg">
	<div class="heading">UPLOAD REPORT</div>
	<%@include file="adminheader.jsp"%>

	<div class="row" id="content_body">

		<div class="col-md-2" id="sidebar">
			<%@include file="admin_menu.jsp"%>
		</div>

		<%
       String message = null;
	   List<Doctor> doctorlist = null; 
       if(request.getAttribute("message")!=null)
    	   message = (String)request.getAttribute("message");
       
       if(request.getAttribute("doctorlist")!=null)
    	   doctorlist = (List<Doctor>)request.getAttribute("doctorlist");
    	   
       %>
		<div class="col-md-10" id="main">
			<%if(message!=null){ %>
			<strong><%=message %></strong>
			<%} %>
			<form id="form" name="myForm" action="uploadfile" method="post"
				enctype="multipart/form-data" onsubmit="return validateForm()">

				<table>
					<tr>
						<td>Appointment Id:</td>
						<td><input type="text" name="p_id"></td>
					</tr>
					<tr>
						<td>Select Doctor:</td>
						<td>
						<select id="doctor" name="doctor">
								<%for(int d=1;d<=doctorlist.size();d++){ %>
								<%Doctor doctor = doctorlist.get(d-1); %>
								<option value="<%=doctor.getD_name() %>"><%=doctor.getD_name() %></option>
								<% } %>
						</select>
						</td>
					</tr>
					
					<tr>
						<td>Browse Report</td>
						<td><input type="file" name="my_file1"></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="upload"></td>
					</tr>

				</table>

			</form>

		</div>
	</div>

	<script>
function  validateForm(){
	var x =document.forms["myForm"]["d_id"].value;
	var y = document.forms["myForm"]["p_id"].value;
	if(x==''){
		alert("department id should not be empty");
		return false;
	}else if(x.length>3){
		alert("for department id length must be less than or equal to 3 avoid blank spaces");
		return false;
	}else if(y==''){
		alert("patient id should not be empty");
		return false;
	}else{
		return true;
	}
}
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

