<%@ include file="../includes/jspIncludes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First Steps</title>
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
	<header class="header container-fluid">
		<div class="logo col-xs-6">
			<h2>Logo</h2>
		</div>
		<div class="col-xs-6 logout text-right">
			<a href="./actionLogout">
				<button class="btn btn-primary">Logout</button>
			</a>
		</div>
	</header>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/firstSteps.js"></script>
</body>
</html>