<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/sidemenu.jsp"%>

<html>

	<head>
		<link href="${pageContext.request.contextPath}/css/review_stars.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/account.css" rel="stylesheet" type="text/css">

		<!-- This page should include allow the student user to:
		1- Access all pages (Menu bar) => Done
		2- Show Name, picture, biography, contact details => Done
		3- Show reviews of the logged in user => Pending
		 -->
		<title>Account</title>
	</head>
	<body>
		<div class="main">
			<div class="dropdown bd-sidebar float-right">
	  			<button id="all_text"  class="btn btn-lg btn-secondary dropdown-toggle orange-background-link" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    			My Courses
	  			</button>
	  			<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
	  				<c:forEach var="course" items="${courses}">
	  					<%-- <c:url var="uos" value="uos" /> --%>	
	  					<a id="all_text" class="dropdown-item orange-link" href="<c:out value='uos?uosId=${course}' />">${course}</a>
	  				</c:forEach>
	 			</div>
			</div>
			<div class="jumbotron">
				<h1>
					${user_fullname}
				</h1>	
				<div class="row">
					<div class="col-md-4">
						<img class="border border-dark" alt="img" src="data:image/jpg;base64,${image}" width="156" height="190" onerror="src='${pageContext.request.contextPath}/images/default_avatar.jpg';"/>
					</div>
					<div class="bio_all col-md-8">
						<h4 id="bio">Biography</h4>
						<p id="all_text"> ${user_biography} </p>
					</div>
				</div>
			</div>
			
			<c:if test="${(user_email != null) || (user_phoneNumber != null)}">
				<div class="jumbotron">
					<h2>
						Contact
					</h2>
					<c:if test="${(user_email != null)}"><p id="all_text"> Email: ${user_email} </p></c:if>
					<c:if test="${(user_phoneNumber != null)}"><p id="all_text"> Phone Number: ${user_phoneNumber} </p></c:if>
				</div>
			</c:if>
			
			<div class="jumbotron">
				<h2>Reviews</h2>
				<div class="rating-block">
				<h4>Meeting Punctuality</h4>				
					<div>
						<table>
							<tr>			
								<button id = "star1" type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
						  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
						  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
							</tr>
							<tr> ${average_1} / 5</tr>
							<tr> ${description_1} </tr>							
						</table>
					</div>
				<h4>Effort</h4>				
					<div>
						<table>
							<tr>			
								<button id = "star2" type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
						  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
						  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
							</tr>
							<tr> ${average_2} / 5</tr>
							<tr> ${description_2} </tr>							
						</table>
					</div>				
				<h4>Team Skills</h4>				
					<div>
						<table>
							<tr>			
								<button id = "star3" type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
						  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
						  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
							</tr>
							<tr> ${average_3} / 5</tr>
							<tr> ${description_3} </tr>							
						</table>
					</div>						
				<h4>Technical Skills</h4>				
					<div>
						<table>
							<tr>			
								<button id = "star4" type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
						  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
						  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
							</tr>
							<tr> ${average_4} / 5</tr>
							<tr> ${description_4} </tr>							
						</table>
					</div>						
				<h4>Contextual Skills</h4>				
					<div>
						<table>
							<tr>			
								<button id = "star5" type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
						  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
						  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
							</tr>
							<tr> ${average_5} / 5</tr>
							<tr> ${description_5} </tr>							
						</table>
					</div>									
				</div>				
			</div>
		</div>
	</body>
</html>
