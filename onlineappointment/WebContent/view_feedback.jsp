<%@page import="project.com.bo.Feedback"%>
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

<style type="text/css">
#main{
 height:100%;
}

#feebback{
    margin:auto;
    margin-top:15px;
	border : 1px solid grey;
	width:80%;
	padding-left:5px;
	paading-top:20px;
	
}
#option{
   font-size:15px;
   padding-top:10px;
   padding-bottom:10px;
   font-weight: bold;
}

#feebback_content{
   margin-top:10px;
   padding-left:20px;
}

</style>

</head>
	
<body background="img/admin.jpg">
	<div class="heading">FEEDBACK</div>
	<%@include file="adminheader.jsp"%>
	
	<div class="row" id="content_body">
	
		<div class="col-md-2" id="sidebar">
			<%@include file="admin_menu.jsp"%>
		</div>
       
       <%
       List<Feedback> feedbackList = null;
       if(request.getAttribute("feedbacklist")!=null)
    	   feedbackList = (List<Feedback>)request.getAttribute("feedbacklist");
       
       %>
		<div class="col-md-10" id="main">
		      
		      <%for(int f=feedbackList.size();f>=1;f--){
		    	  Feedback feedback = feedbackList.get(f-1);  
		      %>
		          <div id="feebback">
		              <div class="row" id="heading">
		                  <div class="col-md-6"><strong><%=feedback.getName() %></strong></div>
		                  <div class="col-md-6" style="float: right;">posted on: <strong><%=feedback.getDof() %></strong></div>
		               </div>
		               <div class="row">
		                <div class="col-md-12" id="feebback_content"><%=feedback.getReview() %></div>
		               </div>
		               
		               <div class="row" id="option">
		                <div class="col-md-6">
		                &nbsp;&nbsp; <a href="postfeedback?id=<%=feedback.getId()%>">post</a> 
		                <!--  <a href="deletefeedback?id=<%=feedback.getId()%>">remove</a>
		                -->
		                </div>
		               </div>
		               
		             
		          </div>
		      <%} %>
        </div>
    
    </div>
    
</body>

	
</body>
</html>

