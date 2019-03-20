<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/changepassword.css">
</head>


<body background="img/login.jpg">
	<div class="container-fluid">

		<%@include file="header.jsp"%>

		<%
	     Patient p = (Patient)session.getAttribute("patient");
	     String name = p.getP_fname().toUpperCase() +" "+ p.getP_lname().toUpperCase();
	     String contact = p.getP_contact();
	     String email = p.getP_email();
	     String message = null;
	     if(session.getAttribute("message")!=null){
	    	 message = (String)session.getAttribute("message");
	     }
	     
	    %>


		<div class="row">
			<div>
				<h3 style="visibility: hidden">don't show it</h3>
			</div>
		</div>

		<form action="changepassword" method="post">
            
            <div id="aptmt_receipt" style="margin-left: 0px">Change Password</div>
			<hr>
            
            
            <%if (message != null){ %>
				<div class="row" id="error_msg" style="color: blue">
					<div>
						<strong style="visibility: visible;"><%=message%></strong>
					</div>
				</div>
				<%}else{%>
				<div class="row" id="error_msg" style="color: blue">
					<div>
						<strong style="visibility: hidden;">Don't show it</strong>
					</div>
				</div>
             <%} %>
             
			
            <div class="col-sm-12">
				<input type="hidden" name="email" value="<%=email %>"
					readonly="readonly">
				</div>
            
			<div class="row">
				<div class="col-sm-4">
					<label>Name</label><br> <input type="text" name="name" value="<%=name %>"
					readonly="readonly">
				</div>

				<div class="col-sm-4">
					<label>contact</label><br> <input type="text" name="contact" value="<%=contact %>"
						readonly="readonly">
				</div>

				<div class="col-sm-4">
					<label>Old Password</label><br> <input type="password" name="old_password"
						required>
				</div>
			</div>

       <div class="row">  
			<div class="col-sm-6">
					<label>New Password</label><br> <input type="password" name="new_password" required>
				</div>

           <div class="col-sm-6">
					<label>Confirm Password</label><br> <input type="password" name="confirm_new_password" required>
			</div>
			
	  </div>
          
           
			<div class="row">
				<center>
					<input type="submit" value="Go">
				</center>
			</div>
			
		</form>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>
