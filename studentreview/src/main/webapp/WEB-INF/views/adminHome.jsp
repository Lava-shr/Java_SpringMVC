<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/sidemenu.jsp"%>

<html>
<head>
	<!-- This page should include allow the student user to:
	1- Access all pages (Menu bar) => Pending
	2- View the courses he/she is enrolled in => Pending
	3- View the group limit, people not in group, & group number for each course => Pending
	 -->
	<title>Admin Home page</title>
		<style>
.dropbtn {
  background-color: #3498DB;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}
.dropbtn:hover, .dropbtn:focus {
  background-color: #2980B9;
}
.dropdown {
  position: relative;
  display: inline-block;
}
.dropdown-content {
  display: none;
  position: sticky;
  background-color: #f1f1f1;
  min-width: 160px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}
.dropdown a:hover {background-color: #ddd;}
.show {display: block;}
.button{
	position:relative;
}
</style>
	
</head>
<body>

		
	<div class="main">
		<div class="jumbotron">
			<h1 class="jumbotron-heading">
				Units of Study
			</h1>
		</div>
		<c:forEach var="uos1" items="${uos}">
		
		</c:forEach>
		
		<c:forEach var="uos1" items="${uos}">
			<div class="dropdown bd-sidebar jumbotron">
				<!-- Drop down button -->
				
	  			<button class="btn btn-lg btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    			${uos1}
	  			</button>
	  			<!-- Drop down menu -->
	  			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	  			
	  				<a href="<c:url value= "/admin/group/${uos1}" />">Check Group </a> <br>
	  				<a href="<c:url value= "/admin/contract/${uos1}" />">Check Contract </a> <br>
	  				<a href="<c:url value= "/admin/reviews/${uos1}" />">Check Reviews </a> <br>
	 			</div>
	 			
			</div>
		</c:forEach> 
	</div>
	
		
</body>
</html>
