<%@ include file="../includes/jspIncludes.jsp" %>
<c:if test="${!empty session.userRole and session.userRole eq 'C'}">
	<c:redirect url="./actionHome"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
	<!-- Login Form -->
	<form id="login-form" name="login-form" action="./actionLogin" method="POST" class="form-horizontal center text-center">
		<div class="form-group">
			<label for="userBean.identifier" class="control-label col-sm-2">UserId</label>
			<div class="col-sm-8">
				<input name="identifier" id="identifier" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="control-label col-sm-2">Password</label>
			<div class="col-sm-8">
				<input name="password" id="password" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<input id="submit" type="submit" value="submit" class="btn btn-default"/>
		</div>
	</form>
</body>
</html>