<%@ include file="../includes/jspIncludes.jsp" %>
<c:if var="isLoggedIn" test="${!empty sessionScope.user.role}" scope="request">
	<c:if test="${!empty sessionScope.isSet and SessionScope.isSet eq 'YES'}">
		<!--<c:redirect url="/firstSteps.jsp"></c:redirect> -->
	</c:if>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid navbar navbar-default">
		<div class="navbar-brand">Logo</div>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<a href="./actionLogout">
					<button class="btn btn-primary">Logout</button>
				</a>
			</li>
			<li>
				<a href="./pageSettings">Settings</a>
			</li>
		</ul>
	</div>
	homepage Yet to implement
	is logged in : ${requestScope.isLoggedIn}<br>
	<c:if test="${requestScope.isLoggedIn}">
		<p>hey u r logged in</p>
	</c:if>
	
</body>
</html>