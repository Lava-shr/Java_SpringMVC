<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page session="false" %>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/account.css" rel="stylesheet" type="text/css">
		<!-- This page should include allow the student user to:
		1- Login to the system => Done
		2- Create session for user for navigation ==> Done
		 -->
		<style>
			.login_background{
				background:url("${pageContext.request.contextPath}/images/white.jpg");
			}
		
		</style>
		
		<title>Login Page</title>
	</head>
<body class="jumbotron">
	<div class="text-center">
	<div class="login_background">
	<div class="login_div">
			<img id="logo" src="${pageContext.request.contextPath}/images/logo_long_2.svg" alt="Logo"/>
			<h1 class="text h3 mb-3 font-weight-normal">Enter your credentials </h1>
		
			
			<form:form class="form-signin form-line-active" action="/studentreview/" method="POST" modelAttribute="login">
				
				<form:label id="all_text"  for="inputUsername"  class="sr-only" path="username">Username</form:label>
				<form:input id="inputUsername" class="form-control" path="username" type="text" placeholder="Username" autocomplete="off"/>
				<form:label id="all_text" for="inputPassword" class="sr-only" path="password">Password</form:label>
				<form:input id="inputPassword" class="form-control" path="password" type="password" placeholder="Password"/>
				<form:button id="all_text" class="loginButton btn btn-lg btn-primary btn-block orange-background-link orange-login-link" type='success'>Login</form:button>
				<p class="mt-5 mb-3 text-muted">© 2019-2020</p>
			
			</form:form>
	</div>
	</div>
	<h3>${message}</h3>
	<br/>
	</div>
</body>
</html>	