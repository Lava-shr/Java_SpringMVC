<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/sidemenu.jsp"%>
<html>
	<head>
		<!-- This page should include allow the student user to:
		1- Access all pages (Menu bar) => Done
		2- View all the groups the logged in user is involved with, including Group number, group limit, tutor details, member(s) details => Pending
		 -->
		 <link href="${pageContext.request.contextPath}/css/contract.css" rel="stylesheet" type="text/css">
		 
		<title>Admin Contract</title>
	</head>
	<body>
		<div class="main">
			<H1>${uos}</H1>
			<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="Group Id">Group Id</th>
					<th scope="Contract Details">Contract Details</th>
				</tr>
			</thead>
			<tbody>	   
				<c:forEach var="group_details" items="${group_details}">
					<tr>
						<td> ${group_details.unitGroupId}</td>
						<td> ${group_details.contract} </td>
					</tr>
				</c:forEach>     
			</tbody>
		</table>
		</div>
	</body>
</html>