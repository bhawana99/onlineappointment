<html>
<title>Online Appointment Portal</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<script type="text/javascript" src="home.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="main.js"></script>
<link type="text/css" rel="stylesheet" href="css/home.css">

</head>
<body>

	<%@include file="header.jsp"%>

	<!-- to make screen responsive -->
	<div class="row" id="menu_button">
		<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				Go To>> <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" style="color: black;">
				<li><a id="a" href="home.jsp"><strong
						style="font-size: 15px;">Home</strong></a></li>
				<li><a id="a" href="mission.jsp"><strong
						style="font-size: 15px;">Mission & Vision</strong></a></li>
				<li><a id="a" href="#departments"><strong
						style="font-size: 15px;">Departments</strong></a></li>
				<li><a id="a" href="writefeedback"><strong
						style="font-size: 15px;">Feedback</strong></a></li>
				<li><a id="a" href="#contacts"><strong
						style="font-size: 15px;">Contact Us</strong></a></li>
			</ul>
		</div>

		<div id="dropdown">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Get an Appointment <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="login.jsp" id="a">Get an Appointment</a></li>
					<li><a href="reportlogin.jsp" id="a">Online Lab Reports</a></li>
				</ul>
			</div>
		</div>

		<div class="dropdown" id="login_button">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				Login<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" style="background-color: #77b5f9;">
				<li class="login-content"><i class="fa fa-user-md"
					style="font-size: 24px"></i><a id="a" href="index.jsp">Doctor</a></li>
				<li class="login-content"><i class="fa fa-book"
					style="font-size: 24px"></i><a id="a" href="administration.jsp">Administration</a></li>
			</ul>
		</div>

	</div>

	<!-- On full screen -->
	<div class="row" id="top">
		<div class="col-sm-2">
			<i class="fas fa-home" style="font-size: 28px"></i> <a id="a"
				href="home.jsp"><strong style="font-size: 20px; color: white;">Home</strong></a>
		</div>

		<div class="col-sm-2">
			<a id="a" href="mission.jsp"><strong
				style="font-size: 20px; color: white;">Mission & Vision</strong></a>
		</div>

		<div class="col-sm-2">
			<a id="a" href="#departments"><strong
				style="font-size: 20px; color: white;">Departments</strong></a>
		</div>

		<div class="col-sm-2">
			<a id="a" href="writefeedback"><strong
				style="font-size: 20px; color: white;">Feedback</strong></a>
		</div>

		<div class="col-sm-2">
			<a id="a" href="#contacts"><strong
				style="font-size: 20px; color: white;">Contact Us</strong></a>
		</div>

		<div class="col-sm-2">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown"
				style="background-color: #77b5f9; border: none;">
				<strong style="font-size: 20px;">Login</strong> <span class="caret"></span>
			</button>
			
			<ul class="dropdown-menu" style="background-color: #77b5f9;">
				<li class="login-content"><i class="fa fa-book"
					style="font-size: 24px"></i><a id="a" href="login.jsp">Patient</a></li>
				<li class="login-content"><i class="fa fa-user-md"
					style="font-size: 24px"></i><a id="a" href="index.jsp">Doctor</a></li>
				<li class="login-content"><i class="fa fa-book"
					style="font-size: 24px"></i><a id="a" href="administration.jsp">Administration</a></li>
			</ul>
			
		</div>
	</div>

	<section id="gallery">
		<div clas="row" id="carousel-col">
			<div class="col-sm-12">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="img/home1b.jpg" alt="Los Angeles" style="width: 100%;">
						</div>

						<div class="item">
							<img src="img/home2b.jpg" alt="Chicago" style="width: 100%;">
						</div>

						<div class="item">
							<img src="img/home3b.jpg" alt="New york" style="width: 100%;">
						</div>

						<div class="item">
							<img src="img/home4b.jpg" alt="New york" style="width: 100%;">
						</div>

						<div class="item">
							<img src="img/home5b.jpg" alt="New york" style="width: 100%;">
						</div>

					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</section>

	<section id="services">
		<div style="padding-top: 450px;">
			<center>
				<strong>WELCOME TO SANJEEVAN HOSPITAL,RAIPUR</strong>
			</center>
		</div>
		<hr>

		<div class="row" id="service-list">
			<div class="col-md-4" id="service-box">
				<div class="row">
					<div class="col-md-4">
						<img src="img/location-icon.jpg">
					</div>
					<div class="col-md-8" style="font-size: 18px; padding: 30px 0px;">Location
						over 50 acres.</div>
				</div>
			</div>

			<div class="col-md-4" id="service-box">
				<!-- <img src="img/patient-bed.jpg"> -->
				<div class="row">
					<div class="col-md-4">
						<img src="img/patient-bed.jpg">
					</div>
					<div class="col-md-8" style="font-size: 18px; padding: 30px 0px;">350-bed
						facility</div>
				</div>
			</div>

			<div class="col-md-4" id="service-box">
				<div class="row">
					<div class="col-md-4">
						<img src="img/ambulance.jpg">
					</div>
					<div class="col-md-8" style="font-size: 18px; padding: 30px 0px;">24
						hours ambulance service</div>
				</div>
			</div>
		</div>

		<div class="row" id="service-list">
			<div class="col-md-4" id="service-box">
				<div class="row">
					<div class="col-md-4" style="margin-top: 10px;">
						<img src="img/doctor.jpg">
					</div>
					<div class="col-md-8" style="font-size: 18px; padding: 30px 0px;">
						Trained & experienced<br> doctors
					</div>
				</div>
			</div>

			<div class="col-md-4" id="service-box">
				<!-- <img src="img/patient-bed.jpg"> -->
				<div class="row">
					<div class="col-md-4">
						<img src="img/hospital-computer.jpg">
					</div>
					<div class="col-md-8" style="font-size: 18px; padding: 30px 0px;">
						Treatement using ultra <br>modern technologies
					</div>
				</div>
			</div>

			<div class="col-md-4" id="service-box">
				<div class="row">
					<div class="col-md-4">
						<img src="img/list.jpg">
					</div>
					<div class="col-md-8" style="font-size: 18px; padding: 30px 0px;">
						Best-in-class ambience of <br>international standards
					</div>
				</div>
			</div>
		</div>

	</section>



	<section id="departments" style="font-size: 30px;">
		<div style="padding-top: 450px;">
			<center>
				<strong>OUR DEPARTMENTS</strong>
			</center>
		</div>
		<hr>
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
						<img src="img/dermatologist2.jpg" alt="Lights" style="width: 100%">
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
						<img src="img/gynocologist2.jpg" alt="Lights" style="width: 100%">
					</div>
					<div class="centered">
						<center>Department of Gynecology</center>
					</div>


					<!-- </a> -->
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

	</section>


	<section id="contacts">
		<div style="padding-top: 50px; font-size: 30px">
			<center>
				<strong>Always at your Service</strong>
			</center>
		</div>
		<hr>
		<div class="row" id="bottom">
			<div class="col-sm-4" id="emergency"
				style="background-color: #66a3ff;">
				<ul>
					<li><strong style="font-size: 24px">Emergency-Case</strong></li>
					<li></li>
					<li>0110-757693 &nbsp <i class="fa fa-phone"
						style="font-size: 12px:padding-left:15px;"></i><br>If you
						need a doctor urgently outside of <br> Navjeevan opening
						hours <br> call emergency appointment number for emergency
						service.
					</li>
				</ul>
			</div>

			<div class="col-sm-4" id="contact" style="background-color: #4d94ff;">
				<ul>
					<li><strong style="font-size: 24px;">Contact Us</strong></li>
					<li><address>
							Sanjeevan Hospital,<br>Opposite Mandi Gate<br>G.E. Road<br>
							Raipur Chhattisgarg<br>077140 43106 &nbsp <i
								class="fa fa-phone" style="font-size: 12px:padding-left:15px;"></i>
						</address></li>
				</ul>
			</div>

			<div class="col-sm-4" id="hours" style="background-color: #3385ff;">
				<ul>
					<li><strong style="font-size: 24px;">Opening Hours</strong></li>
					<li style="padding-top: 10px;">Monday-Friday<strong
						style="color: #3385ff;">----</strong>8.00-17.00
					</li>
					<li>Saturday<strong style="color: #3385ff;">-----------</strong>9.30-17.30
					</li>
					<li>Sunday<strong style="color: #3385ff;">-------------</strong>9.30-15.30
					</li>
				</ul>
			</div>

		</div>

	</section>

	</div>


	<%@include file="footer.jsp"%>

	<script>
		window.onscroll = function() {
			myFunction()
		};
		var navbar = document.getElementById("top");
		var sticky = navbar.offsetTop;

		function myFunction() {
			if (window.pageYOffset >= sticky) {
				navbar.classList.add("sticky")
			} else {
				navbar.classList.remove("sticky");
			}
		}

		window.onscroll = function() {
			myFunction()
		};
		var navbar = document.getElementById("menu_button");
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