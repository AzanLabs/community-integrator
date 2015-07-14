<%@ include file="../includes/jspIncludes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>First Steps</title>
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
	<div class="container-fluid navbar navbar-default">
		<div class="navbar-brand">Logo</div>
		<div class="nav navbar-nav navbar-right">
			<a href="./actionLogout">
				<button class="btn btn-primary">Logout</button>
			</a>
		</div>
	</div>
	<div class="overlay-holder">
	<div id="body-overlay" class="overlay"></div>
	${sessionScope.userRole}<br>
	${sessionScope.roleWeight}
	${sessionScope.isSet}
	${sessionScope.parishId}
	${sessionScope.churchId}
	${sessionScope.userId}
	<!-- first steps starts-->
	<div id="firststeps-church">
		<h4 class="form-header container-fluid">Church SetUp Form</h4>
		<c:import url="./saveChurch.jsp"></c:import>
	</div>
	<!-- first steps ends -->
	<div id="response-box-success" class="response-box success">
		<h3>Success</h3>
		<div class="content"></div>
	</div>
	<div id="response-box-error" class="response-box error">
		<a class="close">X</a>
		<h3>Error !</h3>
		<div class="content">
		</div>
	</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/firstSteps.js"></script>
</body>
</html>