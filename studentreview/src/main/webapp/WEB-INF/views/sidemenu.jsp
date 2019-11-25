<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<%-- <link rel="stylesheet" href="<c:url value="/resources/css/sidenav.css" />"> --%>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
		<link href="${pageContext.request.contextPath}/css/sidenav.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/account.css" rel="stylesheet" type="text/css">
		
	</head>
	<body>
		<!-- Side navigation -->
		<nav class="sidebar" id="main-side-bar">
			<ul id="all_text" class="nav flex-column">
				<li class="nav-item"><a href="<c:url value="/account"/>">Account</a></li>
				<%-- <li class="nav-item"><a href="<c:url value="/mycourses"/>">Courses</a></li> --%>
				<li class="nav-item"><a data-toggle="collapse" href="#courseList" role="button" aria-expanded="false" aria-controls="courseList">Courses</a></li>
				<li class="nav-item"><a href="<c:url value = "/"/>">Dashboard</a></li>
				<li class="nav-item"><a href="<c:url value = "/group"/>">Groups</a></li>
				<li class="nav-item"><a href="<c:url value = "/contract"/>">Contract</a></li>
				<c:if test="${!empty sessionScope.id}">
					<li class="nav-item"><a href="<c:url value="/logout"/>">Logout</a></li>
				</c:if>
			</ul>
		</nav>
		<!-- Collapse body for "Courses" side button -->
		<div class="collapse secondary-list" id="courseList">
   			<nav class="sidebar" id="secondary-side-bar">
   				<c:forEach var="user_group_no" items="${user_group_no}">
		      		<th scope="col">
		      		
		      		<c:url var="uos" value="uos" />
		      		
		      		 <div id="all_text" class="course_sidebar" > <a href="<c:out value='uos?uosId=${user_group_no.key}' />">
		      					${user_group_no.key}</a> </div>
		      	</c:forEach>
   			</nav>
		</div>
	</body>
</html>