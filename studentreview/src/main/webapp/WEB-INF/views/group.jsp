<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/sidemenu.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
	<head>
		<!-- This page should include allow the student user to:
		1- Access all pages (Menu bar) => Done
		2- View all the groups the logged in user is involved with, including Group number, group limit, tutor details, member(s) details => Pending
		 -->
		 <link href="${pageContext.request.contextPath}/css/group.css" rel="stylesheet" type="text/css">
		 <link href="${pageContext.request.contextPath}/css/account.css" rel="stylesheet" type="text/css">
		 
		<title>Group</title>
	</head>
	<body>
		<div class="main">
			<div class="jumbotron">
				<h1 class="jumbotron-heading">
					Groups
				</h1>
			</div>
			<c:forEach var="group" items="${group}">
				<div class="dropdown bd-sidebar jumbotron">
					<!-- Drop down button -->
		  			<button id="all_text" class="btn btn-lg btn-secondary dropdown-toggle orange-background-link" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    			${group.course}
		  			</button>
		  			<!-- Drop down menu -->
		  			<div class="drop dropdown-menu" aria-labelledby="dropdownMenuButton">
		  				<p id="all_text">Group Number: ${group.group_no} </p>
						<p id="all_text">Group Limit: ${group.group_limit} </p>
						<c:if test="${fn:length(group.group_member) gt 0}"><p id="all_text" >Group People:</p></c:if>
						<ul>
							<c:forEach var="group_member" items="${group.group_member}" varStatus="status">
								 <li id="all_text" > ${group_member} 
								 
								 	<a class="orange-link" id="all_text" href="<c:url value= "/reviewStudent/${group_member}" />"> Review </a>
								 	<a class="orange-link" id="all_text" href="<c:url value= "/viewStudentAccount/${group_member}" />"> View Profile</a> 
								 
								 </li>
							</c:forEach>
						</ul>
						<p id="all_text">Tutor Name: Aron Tut</p>
						<p id="all_text">Tutor Email: atut@uni.sydney.edu.au</p>
		 			</div>
				</div>
			</c:forEach> 
		</div>
	</body>
</html>