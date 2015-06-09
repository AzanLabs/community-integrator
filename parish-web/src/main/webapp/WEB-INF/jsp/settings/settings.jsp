<%@ include file="../includes/jspIncludes.jsp" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<!-- left nav -->
		<div class="left-nav col-md-3 border" id="left-nav">
			<ul id="settings-left-nav" class="nav nav-pills">
				<li class="active">
					<a href="#edit-church">Church</a>
				</li>
				<li>
					<a href="#edit-priest">Priest</a>
				</li>
				<li>
					<a href="#edit-events">Events</a>
				</li>
			</ul>
		</div>
		<!-- right holder panel -->
		<section class="settings-right-panel col-md-9" id="right-panel">
			<div id = "edit-church" class="active"></div>
			<div id = "edit-priest"></div>
			<div id = "edit-events"></div>
		</section>
	</div>
</body>
</html>