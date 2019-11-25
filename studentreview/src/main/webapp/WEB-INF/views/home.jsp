<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/sidemenu.jsp"%>

<html>
	<head>
		<!-- This page should include allow the student user to:
		1- Access all pages (Menu bar) => Done
		2- View the courses he/she is enrolled in => Done
		3- View the group limit, people not in group, & group number for each course => Pending
		 -->
		 <link href="${pageContext.request.contextPath}/css/account.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet" type="text/css">
		<title>Home page</title>
	</head>
	<body>
		<div class="main">
			<section class="jumbotron text-center">
				<div class="container">
					<h1 class="jumbotron-heading">
						Units of Study
					</h1>
				</div>
			</section>
			<div class="album py-5 bg-light">
	        	<div class="container">
					<div class="row">
						<c:forEach var="course" items="${courses}">
							<div class="col-md-4">
								<div class="card mb-4 shadow-sm">
									<img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22208%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20208%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_16dfc2f4237%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A11pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_16dfc2f4237%22%3E%3Crect%20width%3D%22208%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2266.9296875%22%20y%3D%22117.45%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
									<div class="card-body">
										<h2 class="card-text"><a class="orange-link" href="<c:out value='uos?uosId=${course}' />">${course}</a></h2>
                   						<small id="all_text" class="text-muted">Group Number: ${user_group_no[course]}</small><br>
                   						<small id="all_text" class="text-muted">Total Students: ${unit_total_students[course]}</small><br>
                   						<small id="all_text" class="text-muted">Not in group: ${not_in_group[course]}</small><br>
                   						<small id="all_text" class="text-muted">Group limit: ${group_limit[course]}</small><br>
	               					</div>
	             				</div>
		           			</div>
	           			</c:forEach>
	         		</div>
	        	</div>
	    	</div>			
		</div>
	</body>
</html>
