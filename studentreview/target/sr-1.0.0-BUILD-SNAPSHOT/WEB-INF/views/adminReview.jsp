<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/sidemenu.jsp"%>
<html>
	<head>
		<!-- This page should include allow the student user to:
		1- Access all pages (Menu bar) => Done
		2- View all the groups the logged in user is involved with, including Group number, group limit, tutor details, member(s) details => Pending
		 -->
		 <link href="${pageContext.request.contextPath}/css/contract.css" rel="stylesheet" type="text/css">
		 
		<title>Admin Group</title>
	</head>
	<body>
		<div class="main">
			<H1>${uos}</H1>
			<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="User Being reviewed">User Name</th>
					<th scope="Group Limit">Reviews Title</th>
					<th scope="Group Minimum Limit">Review  points</th>
				</tr>
			</thead>
			<tbody>	   
			<c:set var="count" value="0" scope="page" />
			
				<c:forEach var="reviews_details" items="${reviews_details}" varStatus="i">
					<tr>
					
						<td> ${fullname[i.index]}</td>
						<td> ${reviews_details.title} </td>
						<td> ${reviews_details.rev_points} </td>
						
						<c:set var="count" value="${count + 1}" scope="page"/>
						
					</tr>
				</c:forEach>     
			</tbody>
		</table>
		</div>
	</body>
</html>