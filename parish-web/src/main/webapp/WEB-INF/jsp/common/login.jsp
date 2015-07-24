<%@ include file="../includes/jspIncludes.jsp" %>
<c:if test="${!empty session.user and !empty session.user.identifier}">
	<c:redirect url="./actionHome"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Login</title>
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body class="black-bg">
	<!-- Login Form -->
	<div id="login-box" class="center container-fluid">
		<div class="login-box-header row">
			<h3>Login</h3>
		</div>
		<div class="login-form">
			<form id="login-form" name="login-form" action="./actionLogin" method="POST" onsubmit="return login(this);" class="form-horizontal">
				<p class="error small">${requestScope.actionErrors[0]}</p>
				<div class="form-group">
					<label for="identifier" class="control-label">UserId</label>
					<input name="identifier" id="identifier" type="text" class="form-control" required placeholder="Identifier"/>
					<p class="error small">${requestScope.fieldErrors.identifier[0]}</p>
				</div>
				<div class="form-group">
					<label for="password" class="control-label">Password</label>
					<input name="password" id="password" type="password" class="form-control" required placeholder="Password"/>
					<p class="error small">${requestScope.fieldErrors.password[0]}</p>
				</div>
				<div class="form-group">
					<input id="submit" type="submit" value="submit" class="btn btn-default"/>
				</div>
			</form>		
		</div>
	</div>
</body>
</html>