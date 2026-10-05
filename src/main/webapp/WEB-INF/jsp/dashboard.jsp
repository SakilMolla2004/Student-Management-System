<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link class="icon" type="image/png" sizes="16x16"
	href="assets/images/favicon.png">
<title>Home Dashboard</title>
<link href="assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link href="assets/plugins/chartist-js/dist/chartist.min.css"
	rel="stylesheet">
<link href="assets/plugins/chartist-js/dist/chartist-init.css"
	rel="stylesheet">
<link
	href="assets/plugins/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css"
	rel="stylesheet">
<link href="assets/plugins/css-chart/css-chart.css" rel="stylesheet">
<link href="assets/plugins/c3-master/c3.min.css" rel="stylesheet">
<link href="assets/plugins/vectormap/jquery-jvectormap-2.0.2.css"
	rel="stylesheet" />
<link href="css/style.css" rel="stylesheet">
<link href="css/colors/blue.css" id="theme" rel="stylesheet">

<style>
.custom-thead {
	background-color: #3b82f6 !important;
	color: white !important;
}

.custom-thead th {
	color: white !important;
	text-transform: uppercase;
	font-size: 13px;
	letter-spacing: 0.5px;
}

.action-icons-cell a {
	margin-right: 12px;
	color: #3b82f6;
	font-size: 16px;
	transition: color 0.3s;
}

.action-icons-cell a:hover {
	color: #2563eb;
}

/* New CSS to make dashboard links look professional */
.dashboard-card-link {
	text-decoration: none !important;
	display: block;
	transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.dashboard-card-link:hover .card {
	transform: translateY(-3px);
	box-shadow: 0 4px 15px rgba(0,0,0,0.1);
}
</style>
</head>

<body class="fix-header fix-sidebar card-no-border">
	<div class="preloader">
		<svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none"
				stroke-width="2" stroke-miterlimit="10" />
        </svg>
	</div>

	<div id="main-wrapper">
		<header class="topbar">
			<nav class="navbar top-navbar navbar-expand-md navbar-light">
				<div class="navbar-header">
					<a class="navbar-brand" href="index.html"></a>
				</div>
			</nav>
		</header>

		<%@ include file="navigation.jsp" %>
		<div class="page-wrapper">
			<div class="container-fluid">
				<div class="row page-titles">
					<div class="col-md-5 col-8 align-self-center">
						<h3 class="text-themecolor">Home Dashboard</h3>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-3 col-md-6 m-b-20">
						<a href="Departments" >
							<div class="card m-b-0">
								<div class="card-body">
									<div class="d-flex flex-row">
										<div class="round round-lg align-self-center round-info">
											<i class="mdi mdi-domain"></i>
										</div>
										<div class="m-l-10 align-self-center">
											<h3 class="m-b-0 font-light">${md.count_dept}</h3>
											<h5 class="text-muted m-b-0">Departments</h5>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
					
					<div class="col-lg-3 col-md-6 m-b-20">
						<a href="SubjectView" class="dashboard-card-link">
							<div class="card m-b-0">
								<div class="card-body">
									<div class="d-flex flex-row">
										<div class="round round-lg align-self-center round-warning">
											<i class="mdi mdi-book-open-page-variant"></i>
										</div>
										<div class="m-l-10 align-self-center">
											<h3 class="m-b-0 font-light">${mds.count_sub}</h3>
											<h5 class="text-muted m-b-0">Subjects</h5>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
					
					<div class="col-lg-3 col-md-6 m-b-20">
						<a href="TeacherRegistration" class="dashboard-card-link">
							<div class="card m-b-0">
								<div class="card-body">
									<div class="d-flex flex-row">
										<div class="round round-lg align-self-center round-primary">
											<i class="mdi mdi-school"></i>
										</div>
										<div class="m-l-10 align-self-center">
											<h3 class="m-b-0 font-light">${mdt.count_teacher}</h3>
											<h5 class="text-muted m-b-0">Teachers</h5>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
					
					<div class="col-lg-3 col-md-6 m-b-20">
						<a href="Semesters" class="dashboard-card-link">
							<div class="card m-b-0">
								<div class="card-body">
									<div class="d-flex flex-row">
										<div class="round round-lg align-self-center round-primary">
											<i class="mdi mdi-calendar-range"></i>
										</div>
										<div class="m-l-10 align-self-center">
											<h3 class="m-b-0 font-light">${mdsem.count_sem}</h3>
											<h5 class="text-muted m-b-0">Semesters</h5>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
					
					<div class="col-lg-3 col-md-6 m-b-20">
						<a href="Year" class="dashboard-card-link">
							<div class="card m-b-0">
								<div class="card-body">
									<div class="d-flex flex-row">
										<div class="round round-lg align-self-center round-primary">
											<i class="mdi mdi-calendar-blank"></i>
										</div>
										<div class="m-l-10 align-self-center">
											<h3 class="m-b-0 font-light">${mdyear.count_year }</h3>
											<h5 class="text-muted m-b-0">Years</h5>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
					
					<div class="col-lg-3 col-md-6 m-b-20">
						<a href="Students" class="dashboard-card-link">
							<div class="card m-b-0">
								<div class="card-body">
									<div class="d-flex flex-row">
										<div class="round round-lg align-self-center round-primary">
											<i class="mdi mdi-account-multiple"></i>
										</div>
										<div class="m-l-10 align-self-center">
											<h3 class="m-b-0 font-light">${mdstudent.count_student }</h3>
											<h5 class="text-muted m-b-0">Students</h5>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script src="assets/plugins/jquery/jquery.min.js"></script>
	<script src="assets/plugins/bootstrap/js/popper.min.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/jquery.slimscroll.js"></script>
	<script src="js/waves.js"></script>
	<script src="js/sidebarmenu.js"></script>
	<script src="assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
	<script src="assets/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="js/custom.min.js"></script>
	<script src="assets/plugins/chartist-js/dist/chartist.min.js"></script>
	<script
		src="assets/plugins/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.min.js"></script>
	<script src="assets/plugins/d3/d3.min.js"></script>
	<script src="assets/plugins/c3-master/c3.min.js"></script>
	<script src="assets/plugins/vectormap/jquery-jvectormap-2.0.2.min.js"></script>
	<script src="assets/plugins/vectormap/jquery-jvectormap-us-aea-en.js"></script>
	<script src="js/dashboard2.js"></script>
	<script src="assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
</body>
</html>