
<%@page import="project.com.bo.Patient"%>
<%
  Patient patient = null;
  if(session.getAttribute("patient")!=null)
	  patient = (Patient)session.getAttribute("patient");
  
%>
<div class="row" id="header" style="background-color: white;">
	<div class="col-sm-6">
		<img src="img/logo2.png">
	</div>

	

	<div class="col-sm-6" id="tag">
		<a href="home.jsp" id="a">Back to Home</a><br>
		<%if(patient!=null){ %>
		Welcome
		<%=patient.getP_fname().toUpperCase() %><br> <a
			href="patientlogout">Logout</a>

		<%}else{ %>

		<a href="login.jsp" id="a">Get an Appointment</a><br> <a
			href="reportlogin.jsp" id="a">Online Lab Reports</a>
		<%} %>

	</div>



</div>