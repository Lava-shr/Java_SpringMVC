<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/sidemenu.jsp"%>

<html>

	<head>
		<link href="${pageContext.request.contextPath}/css/review_stars.css" rel="stylesheet" type="text/css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
					<div class="col-md-5">
						<img class="border border-dark" alt="img" src="data:image/jpg;base64,${image}" width="156" height="190" onerror="src='${pageContext.request.contextPath}/images/default_avatar.jpg';"/>
					</div>
					<div class="bio_all col-md-5">
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
						 <div>
                            <span id = "1" class="glyphicon glyphicon-star"></span>
                            <span id = "2" class="glyphicon glyphicon-star"></span>
                            <span id = "3" class="glyphicon glyphicon-star"></span>
                            <span id = "4" class="glyphicon glyphicon-star"></span>
                            <span id = "5" class="glyphicon glyphicon-star"></span>
                         </div>
									
							
							</tr>
							<tr> ${average_1} / 5</tr>
							<tr> ${description_1} </tr>							
						</table>
					</div>
				<h4>Effort</h4>				
					<div>
						<table>
							<tr>			
						 <div>
                            <span id = "6" class="glyphicon glyphicon-star"></span>
                            <span id = "7" class="glyphicon glyphicon-star"></span>
                            <span id = "8" class="glyphicon glyphicon-star"></span>
                            <span id = "9" class="glyphicon glyphicon-star"></span>
                            <span id = "10" class="glyphicon glyphicon-star-empty"></span>
                         </div>
							</tr>
							<tr> ${average_2} / 5</tr>
							<tr> ${description_2} </tr>							
						</table>
					</div>				
				<h4>Team Skills</h4>				
					<div>
						<table>
							<tr>			
						 <div>
                            <span id = "11"class="glyphicon glyphicon-star"></span>
                            <span id = "12"class="glyphicon glyphicon-star"></span>
                            <span id = "13"class="glyphicon glyphicon-star"></span>
                            <span id = "14"class="glyphicon glyphicon-star"></span>
                            <span id = "15"class="glyphicon glyphicon-star-empty"></span>
                         </div>
							</tr>
							<tr> ${average_3} / 5</tr>
							<tr> ${description_3} </tr>							
						</table>
					</div>						
				<h4>Technical Skills</h4>				
					<div>
						<table>
							<tr>			
						 <div>
                            <span id = "16" class="glyphicon glyphicon-star"></span>
                            <span id = "17" class="glyphicon glyphicon-star"></span>
                            <span id = "18" class="glyphicon glyphicon-star"></span>
                            <span id = "19" class="glyphicon glyphicon-star"></span>
                            <span id = "20" class="glyphicon glyphicon-star-empty"></span>
                         </div>
							</tr>
							<tr> ${average_4} / 5</tr>
							<tr> ${description_4} </tr>							
						</table>
					</div>						
				<h4>Contextual Skills</h4>				
					<div>
						<table>
							<tr>			
						 <div>
                            <span id = "21" class="glyphicon glyphicon-star"></span>
                            <span id = "22" class="glyphicon glyphicon-star"></span>
                            <span id = "23" class="glyphicon glyphicon-star"></span>
                            <span id = "24" class="glyphicon glyphicon-star"></span>
                            <span id = "25" class="glyphicon glyphicon-star-empty"></span>
                         </div>
							</tr>
							<tr> ${average_5} / 5</tr>
							<tr> ${description_5} </tr>							
						</table>
					</div>									
				</div>				
			</div>
		</div>

	</body>
	<script>
	updateRerview1();
	updateRerview2();
	updateRerview3();
	updateRerview4();
	updateRerview5();
	
	function updateRerview1(){	
		var stars =  ${average_1} ;
		
		if(stars == "4"){
			document.getElementById("5").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "3"){
			document.getElementById("5").className = "glyphicon glyphicon-star-empty";
			document.getElementById("4").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "2"){
			document.getElementById("5").className = "glyphicon glyphicon-star-empty";
			document.getElementById("4").className = "glyphicon glyphicon-star-empty";
			document.getElementById("3").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "1"){
			document.getElementById("5").className = "glyphicon glyphicon-star-empty";
			document.getElementById("4").className = "glyphicon glyphicon-star-empty";
			document.getElementById("3").className = "glyphicon glyphicon-star-empty";
			document.getElementById("2").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "0"){
			document.getElementById("5").className = "glyphicon glyphicon-star-empty";
			document.getElementById("4").className = "glyphicon glyphicon-star-empty";
			document.getElementById("3").className = "glyphicon glyphicon-star-empty";
			document.getElementById("2").className = "glyphicon glyphicon-star-empty";
			document.getElementById("1").className = "glyphicon glyphicon-star-empty";
			}
	}

	function updateRerview2(){	
		var stars =  ${average_2} ;
		
		if(stars == "4"){
			document.getElementById("10").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "3"){
			document.getElementById("10").className = "glyphicon glyphicon-star-empty";
			document.getElementById("9").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "2"){
			document.getElementById("10").className = "glyphicon glyphicon-star-empty";
			document.getElementById("9").className = "glyphicon glyphicon-star-empty";
			document.getElementById("8").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "1"){
			document.getElementById("10").className = "glyphicon glyphicon-star-empty";
			document.getElementById("9").className = "glyphicon glyphicon-star-empty";
			document.getElementById("8").className = "glyphicon glyphicon-star-empty";
			document.getElementById("7").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "0"){
			document.getElementById("10").className = "glyphicon glyphicon-star-empty";
			document.getElementById("9").className = "glyphicon glyphicon-star-empty";
			document.getElementById("8").className = "glyphicon glyphicon-star-empty";
			document.getElementById("7").className = "glyphicon glyphicon-star-empty";
			document.getElementById("6").className = "glyphicon glyphicon-star-empty";
			}
	}

	function updateRerview3(){	
		var stars =  ${average_3} ;
		
		if(stars == "4"){
			document.getElementById("15").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "3"){
			document.getElementById("15").className = "glyphicon glyphicon-star-empty";
			document.getElementById("14").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "2"){
			document.getElementById("15").className = "glyphicon glyphicon-star-empty";
			document.getElementById("14").className = "glyphicon glyphicon-star-empty";
			document.getElementById("13").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "1"){
			document.getElementById("15").className = "glyphicon glyphicon-star-empty";
			document.getElementById("14").className = "glyphicon glyphicon-star-empty";
			document.getElementById("13").className = "glyphicon glyphicon-star-empty";
			document.getElementById("12").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "0"){
			document.getElementById("15").className = "glyphicon glyphicon-star-empty";
			document.getElementById("14").className = "glyphicon glyphicon-star-empty";
			document.getElementById("13").className = "glyphicon glyphicon-star-empty";
			document.getElementById("12").className = "glyphicon glyphicon-star-empty";
			document.getElementById("11").className = "glyphicon glyphicon-star-empty";
			}
	}

	function updateRerview4(){	
		var stars =  ${average_4} ;
		
		if(stars == "4"){
			document.getElementById("20").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "3"){
			document.getElementById("20").className = "glyphicon glyphicon-star-empty";
			document.getElementById("19").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "2"){
			document.getElementById("20").className = "glyphicon glyphicon-star-empty";
			document.getElementById("19").className = "glyphicon glyphicon-star-empty";
			document.getElementById("18").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "1"){
			document.getElementById("20").className = "glyphicon glyphicon-star-empty";
			document.getElementById("19").className = "glyphicon glyphicon-star-empty";
			document.getElementById("18").className = "glyphicon glyphicon-star-empty";
			document.getElementById("17").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "0"){
			document.getElementById("20").className = "glyphicon glyphicon-star-empty";
			document.getElementById("19").className = "glyphicon glyphicon-star-empty";
			document.getElementById("18").className = "glyphicon glyphicon-star-empty";
			document.getElementById("17").className = "glyphicon glyphicon-star-empty";
			document.getElementById("16").className = "glyphicon glyphicon-star-empty";
			}
	}

	function updateRerview5(){	
		var stars =  ${average_5} ;
		
		if(stars == "4"){
			document.getElementById("25").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "3"){
			document.getElementById("24").className = "glyphicon glyphicon-star-empty";
			document.getElementById("23").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "2"){
			document.getElementById("25").className = "glyphicon glyphicon-star-empty";
			document.getElementById("24").className = "glyphicon glyphicon-star-empty";
			document.getElementById("23").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "1"){
			document.getElementById("25").className = "glyphicon glyphicon-star-empty";
			document.getElementById("24").className = "glyphicon glyphicon-star-empty";
			document.getElementById("23").className = "glyphicon glyphicon-star-empty";
			document.getElementById("22").className = "glyphicon glyphicon-star-empty";
			}
		else if(stars == "0"){
			document.getElementById("25").className = "glyphicon glyphicon-star-empty";
			document.getElementById("24").className = "glyphicon glyphicon-star-empty";
			document.getElementById("23").className = "glyphicon glyphicon-star-empty";
			document.getElementById("22").className = "glyphicon glyphicon-star-empty";
			document.getElementById("21").className = "glyphicon glyphicon-star-empty";
			}
	}


	</script>
</html>
