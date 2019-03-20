<%@page import="project.com.bo.Department"%>
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
.main {
	/*margin-left: 10px;  Same as the width of the sidenav */
	padding: 0px 10px;
	margin-top: 50px;
	height: 100%;
	background-image: url("images/background.png");
	background-repeat: no-repeat;
	background-size: cover;
	width: 100%;
}

#form {
    margin:auto;
	font-size: 20px;
	padding: 30px;
}
tr,td{
   padding:10px;
}
</style>
</head>
	
<body background="img/admin.jpg">
	<div class="heading">ADD DEPARTMENT</div>
	<%@include file="adminheader.jsp"%>
	
	
	<%
	  Department departmet = null;
	  if(session.getAttribute("department")!=null){
		  departmet = (Department)session.getAttribute("department");
	  }
	%>
	
	<div class="row" id="content_body">
	
		<div class="col-md-2" id="sidebar">
			<%@include file="admin_menu.jsp"%>
		</div>
       
       <%
       String message = null;
       if(request.getAttribute("message")!=null)
    	   message = (String)request.getAttribute("message");
       
       %>
		<div class="col-md-10" id="main">
		       <%if(message!=null){ %>
		       <strong><%=message %></strong>
		       <%} %>
		       <% if(departmet==null){ %>
		       
              <form name="myForm" id="form" action="addcontroller" method="post"
				onsubmit="return validateForm()">
				<table>
				<tr><td>Department Id:</td> <td><input type='text' name='dept_id'></td></tr> 
				<tr><td>Department Name:</td> <td><input type='text' name='dept_name'></td></tr>
				<tr><td>Diseases:</td> <td><textarea name='diseases' maxlength="200" rows="5" cols="50"></textarea></td></tr>
							
				<tr><td><input type='submit' value='Add'></td></tr>
				</table>
			  </form>
			  
			  <%}else{ %>
			    
			    <form name="myForm" id="form" action="updatedeptcontroller" method="post"
				onsubmit="return validateForm()">
				<table>
				<tr><td>Department Id:</td> <td><input type='text' name='dept_id' value=<%=departmet.getDept_id() %> readonly="readonly" ></td></tr> 
				<tr><td>Department Name:</td> <td><input type='text' name='dept_name' value=<%=departmet.getDept_name() %> ></td></tr>
				<tr><td>Diseases:</td> <td><textarea name='diseases' maxlength="200" rows="5" cols="50" ><%=departmet.getDiseases() %></textarea></td></tr>
							
				<tr><td><input type='submit' value='Update'></td></tr>
				</table>
			  </form>
			    
			  <%} %>
        </div>
    
    </div>
    
</body>

	<script>
		function validateForm() {
			var x = document.forms["myForm"]["dept_id"].value;
			var y = document.forms["myForm"]["dept_name"].value;
			var z = document.forms["myForm"]["diseases"].value;
			if (x == '') {
				alert("dept id should not be empty");
				return false;
			} else if (x.length > 3) {
				alert("for department id length must be less than or equal to 3 avoid blank spaces");
				return false;
			} else if (y == '') {
				alert("department name should not be empty");
				return false;
			}else if (z == '') {
				alert("fill at least one diseases");
				return false;
			} else {
				return true;
			}
		}
	</script>

</body>
</html>

