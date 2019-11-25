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
		<!-- This page should include allow the student user to:
		1- Login to the system => Done
		2- Create session for user for navigation ==> Done
		 -->
		<style>
			/* The side navigation menu */
			.login_div {
			 
			  width: 350px;
			  margin:auto;
			  margin-top: 250;
			  
			}
			
			.form_control{
				font-size: 1.4rem;
			}
			
			.font-weight-normal {    
    			font-size: 2.1rem;
    		}
		
		</style>
		<title>Admin Login Page</title>
	</head>
<body class="jumbotron">
	<div class="text-center">
	
	<div class = "login_div"> 
		<h1 class="h3 mb-3 font-weight-normal">Welcome Admin</h1>
	
		
		<form:form class="form-signin"  action="/studentreview/admin/" method="POST" modelAttribute="adminlogin">
			
			<form:label for="inputUsername"  class="sr-only" path="username">Username</form:label>
			<form:input id="inputUsername" class="form-control" path="username" type="text" placeholder="Username"/>
			<form:label for="inputPassword" class="sr-only" path="password">Password</form:label>
			<form:input id="inputPassword" class="form-control" path="password" type="password" placeholder="Password"/>
			<form:button class="btn btn-lg btn-primary btn-block" type='success'>Login</form:button>
			<p class="mt-5 mb-3 text-muted">© 2019-2020</p>
		
		</form:form>
	</div>
	<h3>${message}</h3>
	<br/>
	</div>
</body>
</html>	