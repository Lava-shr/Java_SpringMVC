<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/sidemenu.jsp"%>
<html>
	<head>
		<!-- This page should include allow the student user to:
		1- Access all pages (Menu bar) => Done
		2- View all the groups the logged in user is involved with, including Group number, group limit, tutor details, member(s) details => Pending
		 -->
		

		<link href="${pageContext.request.contextPath}/css/contract.css" rel="stylesheet" type="text/css">		
		 <link href="${pageContext.request.contextPath}/css/account.css" rel="stylesheet" type="text/css">
		<title>Contract</title>
	</head>
	
	<body>
		<div class="main">
			<div class="jumbotron">
				<h1 class="jumbotron-heading">
					Contracts
				</h1>
			</div>
			<div class="test">
				<c:forEach var="user_group_no" items="${user_group_no}" varStatus="i">
					<div class="dropdown bd-sidebar jumbotron">
						<!-- Drop down button -->
			  			<button id="all_text" class="orange-background-link btn btn-lg btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    			${user_group_no.key}
			  			</button>
			  			<!-- Drop down menu -->
			  			<div class="drop dropdown-menu" aria-labelledby="dropdownMenuButton">
			  				<p id="all_text">Contract for Group: ${user_group_no.value}</p>	  				
			  				<p id="all_text">${contracts[i.index]}</p> 									  		
			  				
			 			</div>
			 		</div>
			
					<div class="dropdown bd-sidebar jumbotron">
						<!-- Drop down button edit -->
			  			<button id="all_text" class="orange-background-link editdrop btn btn-lg btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    			Edit
			  			</button>
			  			<!-- Drop down menu to edit -->
			  			
			  			<c:set var="root" value="${pageContext.request.contextPath}"/>
			  			
				  			<div class="drop dropdown-menu" aria-labelledby="dropdownMenuButton">
				  			<form action= "${root}/contractPosting/${user_group_no.key}" method="POST">
				  				<div id="forumDiv">
				  					<textarea id="all_text" class="autoExpand forumPost form-control" rows="4" data-min-rows="4" placeholder="Enter your message here" name = "contract">
				  					
				  					
				  					
				  					</textarea>
				  					<br/>
				  					<button  id="all_text" class="orange-background-link forumPostButton btn btn-default">Post</button>
					  			</div>	
					  		</form>					  		
				 			</div>
				 		
			 		</div>
				</c:forEach>
				${errorMessage}
	
			</div>
			
		</div>
		
	
		  				
</body>	

<script>
	function saveToDatabase(){
		
	}

</script>
	
</html>