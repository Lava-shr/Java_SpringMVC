<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/sidemenu.jsp"%>

<html>
<head>
	<!-- This page should include allow the student user to:
	1- Access all pages (Menu bar) => Done
	2- View all students with correct rating => Pending
	 -->
	<title>Student List</title>
	
	
</head>

	
<body>
	<div class="main container">
		<H1>${uosId}</H1>
		<H3>People</H3>
		
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="Name">Name</th>
					<th scope="Email">Email</th>
					<th scope="Group No">Group No</th>
					<th scope="Group Limit">Group Limit</th>
					<th scope="Average Ratings">Average Ratings</th>
				</tr>
			</thead>
			<tbody>	   
				<c:forEach var="user_list" items="${user_list}">
					<tr>
						<td> 
							<a class="orange-link" href="<c:url value= "/viewStudentAccount/${user_list.username}" />">${user_list.username} </a> 
						</td>
						<td> ${user_list.email}</td>
						<td> ${user_list.group_no} </td>
						<td> ${user_list.group_limit} </td>
						<td> ${user_list.avg_ratings} </td>
					</tr>
				</c:forEach>     
			</tbody>
		</table>
	</div>
</body>



</html>
