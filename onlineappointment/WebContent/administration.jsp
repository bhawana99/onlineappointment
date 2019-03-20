<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="css/administration.css">
  </head>
	
	
  <body background="img/login.jpg">
    
   <div class="container-fluid">
	   
	<%@include file="header.jsp" %>
	   <div class="row">
          <div><h3 style="visibility:hidden">don't show it</h3></div>
       </div>
      
      <%
         String message = null;
         if(request.getAttribute("message")!=null)
        	 message = (String)request.getAttribute("message");
      
      %>
      
	   <form action='adminlogin' method='post'>
	      

				<%if (message != null) { %>
				<div id="error_msg" style="color:red;">
					<center>
						<strong><%=message%></strong>
					</center>
				</div>
				<%} %>
	      
	    
	       <div id="form-heading">
		       Administrator Login
		   </div>
		   
		   <div class="row">
               <div class="col-sm-12">
		       <input type="text" id="id" name="userid" placeholder="Enter Email Id">
		       </div>            
		   </div>
			
			<div class="row">
               <div class="col-sm-12">
		       <input type="password" name="password" placeholder="Enter Password">
		       </div>            
		   </div>
		   <a href="#" style="margin-left:5px">Forgot Your Password?</a>
		   
		   <div class="row">
		      <div class="col-sm-12">
                <input type="submit" value="Submit">
			  </div>
           </div>
	      
	   </form>
	    
		
    </div>
	
	<%@include file="footer.jsp" %>
	
  </body>
</html>
