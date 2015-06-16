<%@ include file="../includes/jspIncludes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Coming Soon</title>
</head>
<body>
	<c:if test="${sessionScope.roleWeight eq 4}">
		<p>welcome Platform Admin!</p>
	</c:if>
	<c:if test="${sessionScope.roleWeight eq 3}">
		<p>welcome Parish Admin!</p>
	</c:if>
	Yet to implement...
</body>
</html>