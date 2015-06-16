<%@ include file="../includes/jspIncludes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First Steps</title>
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/firstSteps.js"></script>
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
	${sessionScope.userRole}<br>
	${sessionScope.roleWeight}
	${sessionScope.isSet}
	${sessionScope.parishId}
	${sessionScope.churchId}
	${sessionScope.userId}
	<!-- first steps starts-->
	<div id="firststeps-church">
		<div class="overlay"></div>
		<h4 class="form-header container-fluid">Church SetUp Form</h4>
		<c:import url="./saveChurch.jsp"></c:import>
	</div>
	<!-- first steps ends -->
</body>
</html>