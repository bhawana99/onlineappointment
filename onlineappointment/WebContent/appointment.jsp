<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="project.com.bo.Department"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://unpkg.com/gijgo@1.9.11/js/gijgo.min.js" type="text/javascript"></script>
  <link href="https://unpkg.com/gijgo@1.9.11/css/gijgo.min.css" rel="stylesheet" type="text/css" />
  <link type="text/css" rel="stylesheet" href="css/appointment.css">
  
</head>
<body background="img/login.jpg">
<div class="container-fluid">
  
   <%@include file="header.jsp" %>
  
  <div class="row">
    <div><h3 style="visibility:hidden">don't show it</h3></div>
  </div>
   
   <%
     
   
   
      List<Department> dept = new ArrayList<Department>();
      List<String> doctor_list = new ArrayList<String>();
      String selected_department = null;
      String message = null;
      
      if(session.getAttribute("message")!=null)
    	  message = (String)session.getAttribute("message");
      
      if(session.getAttribute("departmentlist")!=null)
    	  dept = (List<Department>)session.getAttribute("departmentlist");  
      
      if(session.getAttribute("doctorlist")!=null)
    	  doctor_list = (List<String>)session.getAttribute("doctorlist");
      
      if(session.getAttribute("selected_department")!=null)
    	  selected_department = (String)session.getAttribute("selected_department");
   %>
   
  <div class="form_outline">
    <form  name="myForm" id="form" action="getappointment" method="get" >
	<div id="new_aptmt" style="margin-left:0px">New Appointment</div>
	
	<%if(message!=null){ %>
	<div id="new_aptmt" style="font-size: 10px;"><%=message %></div>
	  
	<%} %>
    
   <%if(session.getAttribute("doctorlist")==null){%>
    <div class="row">
      <div class="col-25">
        <label for="department">Department</label>
	  </div>
      <div class="col-75">
        <select id="Department" name="Department">
          <option selected="selected" value="-1" disabled="disabled">--Select Department--</option>
          <%for(int d=1;d<=dept.size();d++){ %>
                 <%Department department = dept.get(d-1); %>
            	 <option value="<%=department.getDept_name() %>"><%=department.getDept_name() %></option>
          <% } %>
        </select>
      </div>
    </div>
    <%}else{ %>
	<div class="row">
      <div class="col-25">
        <label for="department">Department</label>
	  </div>
      <div class="col-75">
        <select id="Department" name="Department">
          <option selected="selected" value="<%=selected_department %>" disabled="disabled"><%=selected_department %></option>
        </select>
      </div>
    </div>
    
	
	<div class="row">
      <div class="col-25">
        <label for="doctor">Doctor</label>
	  </div>
      <div class="col-75">
        <select id="doctor" name="doctor">
          <option selected="selected" value="-1" disabled="disabled">--Select Doctor--</option>
          <%for(int d=1;d<=doctor_list.size();d++){ %>
               <%String doctor = doctor_list.get(d-1); %>
            	 <option value="<%=doctor %>"><%=doctor %></option>
          <%} %>
        </select>
      </div>
    </div> 
    
    <div class="row">
      <div class="col-25">
        <label for="Date">DOA</label>
      </div>
      <div class="col-75">
	    <input id="datepicker" name="datepicker" width="90%" placeholder="choose your appointment date"/>
      </div>
    </div>
	
    <%} %>
    
    
    <div class="row">
      <center><input type="submit" value="Next" onclick="return validateForm()"></center>
    </div>
	
   </form>
  </div>
 </div>
   
   <%@include file="footer.jsp" %>
   <script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4'
        });
        
     
		function validateForm() {
			var x = document.forms["myForm"]["Department"].value;
			var y = document.forms["myForm"]["doctor"].value;
			if (x == "-1") {
				alert("choose valid department");
				return false;
			} else if (y == "-1") {
				alert("choose valid doctor");
				return false;
			}  else {
				return true;
			}
		}
    </script>
</body>
</html>