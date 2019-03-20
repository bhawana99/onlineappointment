<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</script>
<link rel="stylesheet" href="css\style.css">
</head>

<body>
	<div class="heading">DASHBOARD</div>
	<%@include file="adminheader.jsp"%>

	<div>
		<div class="row" id="content_body">
			<div class="col-md-2" id="sidebar">
				<%@include file="admin_menu.jsp"%>
			</div>


			<div class="col-md-10" id="main">
			  
				<div class="row">
					<div class="col-md-4">
						<div class="thumbnail">
							<div class="img-group">
								<img src="img/nutrition2.jpg" alt="Lights" style="width: 100%">
							</div>

							<div class="centered">
								<center>Department of Dietetrics & Nutrition</center>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="thumbnail">
							<div class="img-group">
								<img src="img/cardiology2.jpg" alt="Lights" style="width: 100%">
							</div>
							<div class="centered">
								<center>Department of Cardiology</center>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="thumbnail">
							<div class="img-group">
								<img src="img/dermatologist2.jpg" alt="Lights"
									style="width: 100%">
							</div>

							<div class="centered">
								<center>Department of Dermetology</center>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="thumbnail">
							<div class="img-group">
								<img src="img/general-disease2.jpg" alt="Lights"
									style="width: 100%">
							</div>

							<div class="centered">
								<center>Department of General-Diseases</center>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="thumbnail">
							<div class="img-group">
								<img src="img/gynocologist2.jpg" alt="Lights"
									style="width: 100%">
							</div>
							<div class="centered">
								<center>Department of Gynecology</center>
							</div>


							
						</div>
					</div>

					<div class="col-md-4">
						<div class="thumbnail">
							<div class="img-group">
								<img src="img/neurology2.jpg" alt="Lights" style="width: 100%">
							</div>
							<div class="centered">
								<center>Department of Neurology</center>
							</div>
						</div>
					</div>
				</div> 


			</div>
		</div>
	</div>
	
</body>

</html>
