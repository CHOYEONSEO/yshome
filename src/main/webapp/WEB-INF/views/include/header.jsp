<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLTE 2 | Dashboard</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="/resources/dist/css/skins/_all-skins.min.css"
	rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>

</head>
<!-- jQuery 2.2.3 -->
<script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>

<body class="skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="/yshome/listAll" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>Y</b>S</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>YS</b> PROJECT</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						
						<!-- Control Sidebar Toggle Button -->
						<li><a href="#" data-toggle="control-sidebar"><i
								class="fa fa-gears"></i></a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<c:if test="${!empty id}">
						<img src="../../resources/images/login.gif" class="img-circle" alt="User Image" />
						</c:if>
						<c:if test="${empty id}">
						<img src="../../resources/images/logout.gif" class="img-circle" alt="User Image" />
							<button>Login</button>
						</c:if>
					</div>
					<div class="pull-left info" >
						<p>
							<c:if test="${!empty id}">
								<security:authorize access="isAuthenticated()">
									<form action="<c:url value='/yshome/logout' />" method="post">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}">
										<button type="submit" style="border: none; background: none;">
										${id} <i class="fa fa-sign-out" style="font-size: 15px; color: red"></i>
										</button>
										<!-- <input type="submit" value="LogOut" style="size: 20px; font-size: xx-small;"> -->

									</form>
								</security:authorize>
							</c:if>
						</p>
					</div>
				</div>
				<!-- search form -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search..." /> <span class="input-group-btn">
							<button type='submit' name='search' id='search-btn'
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="header">MAIN NAVIGATION</li>
					<li class="treeview"><a href="#"> <i class="fa fa-edit"></i>
							<span>Board</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="/yshome/listAll"><i
									class="fa fa-circle-o"></i> Free Board</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-files-o"></i>
							<span>Mypage</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="/yshome/mypage_form?id=${id}"><i class="fa fa-circle-o"></i> Profile</a></li>
						</ul></li>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Welcome <small></small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="listAll"><i class="fa fa-dashboard"></i> Home</a></li>
					<%-- <c:choose>
					<c:when test="${!empty id}"> --%>
					<security:authorize access="isAuthenticated()">
						<li><a href="mypage_form?id=${id}" id="mypage">MyPage</a></li>
					</security:authorize>
					<%-- </c:when>
					<c:otherwise> --%>
					<security:authorize access="isAnonymous()">
						<li><a href="login_form" id="login">Login</a></li>
					</security:authorize>
					<%-- 	</c:otherwise>          
            	</c:choose> --%>
				</ol>
			</section>