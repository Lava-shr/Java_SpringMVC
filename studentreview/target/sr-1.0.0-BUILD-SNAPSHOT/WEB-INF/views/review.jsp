<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/sidemenu.jsp"%>
<html>
	<head>
		 <link href="${pageContext.request.contextPath}/css/group.css" rel="stylesheet" type="text/css">
		 
		<title>Review </title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js">
		</script>
		
	</head>
	
	<body>
	<div class="main">
	<h2> Review</h2>
	<h2> Please Review your experience with ${student}</h2>	
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	
	<form action= "${root}/reviewStudentPost/${student}" method="POST">
	
	
			Meeting Punctuality
		  <input type="checkbox" name="Punctuality" value="1">1
		  <input type="checkbox" name="Punctuality" value="2">2
		  <input type="checkbox" name="Punctuality" value="3">3
		  <input type="checkbox" name="Punctuality" value="4">4
		  <input type="checkbox" name="Punctuality" value="5">5
		  <br><br>
		  Effort
		  <input type="checkbox" name="Effort" value="1">1
		  <input type="checkbox" name="Effort" value="2">2
		  <input type="checkbox" name="Effort" value="3">3
		  <input type="checkbox" name="Effort" value="4">4
		  <input type="checkbox" name="Effort" value="5">5
		  <br><br>
		  Team Skills
		  <input type="checkbox" name="TeamSkills" value="1">1
		  <input type="checkbox" name="TeamSkills" value="2">2
		  <input type="checkbox" name="TeamSkills" value="3">3
		  <input type="checkbox" name="TeamSkills" value="4">4
		  <input type="checkbox" name="TeamSkills" value="5">5
		  <br><br>
		  Technical Skills
		  <input type="checkbox" name="TechnicalSkills" value="1">1
		  <input type="checkbox" name="TechnicalSkills" value="2">2
		  <input type="checkbox" name="TechnicalSkills" value="3">3
		  <input type="checkbox" name="TechnicalSkills" value="4">4
		  <input type="checkbox" name="TechnicalSkills" value="5">5
		  <br><br>
		  Contextual Skills
		  <input type="checkbox" name="ContextualSkills" value="1">1
		  <input type="checkbox" name="ContextualSkills" value="2">2
		  <input type="checkbox" name="ContextualSkills" value="3">3
		  <input type="checkbox" name="ContextualSkills" value="4">4
		  <input type="checkbox" name="ContextualSkills" value="5">5
		  <br><br>
		  
		  <input type="submit" value="Submit">
	</form>
	
	
	</div>
	</body>
	<script>
	$("input:checkbox").on('click', function() {
		  // in the handler, 'this' refers to the box clicked on
		  var $box = $(this);
		  if ($box.is(":checked")) {
			//ref : https://stackoverflow.com/questions/9709209/html-select-only-one-checkbox-in-a-group
		    // the name of the box is retrieved using the .attr() method
		    // as it is assumed and expected to be immutable
		    var group = "input:checkbox[name='" + $box.attr("name") + "']";
		    // the checked state of the group/box on the other hand will change
		    // and the current value is retrieved using .prop() method
		    $(group).prop("checked", false);
		    $box.prop("checked", true);
		  } else {
		    $box.prop("checked", false);
		  }
		});
	</script>
</html>