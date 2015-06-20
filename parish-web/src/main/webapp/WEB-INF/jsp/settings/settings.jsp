<%@ include file="../includes/jspIncludes.jsp" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/settings.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/panels.js"></script>
</head>
<body>
	<div class="container">
		<!-- left nav -->
		<section class="col-sm-3">
			<ul id="settings-left-nav" class="nav settings">
				<li>
					<a href="#edit-church" class="nav-links glyphicon glyphicon-home">Church</a>
				</li>
				<li>
					<a href="#edit-priest" class="nav-links glyphicon glyphicon-edit">Priest</a>
				</li>
				<li>
					<a href="#edit-events" class="nav-links glyphicon glyphicon-trash">Events</a>
				</li>
			</ul>
		</section>
		<!-- right holder panel -->
		<section id="settings-right-panel" class="settings col-sm-9">
			<div id = "edit-church" class="nav-panel"></div>
			<div id = "edit-priest" class="nav-panel">I am </div>
			<div id = "edit-events" class="nav-panel">Here</div>
		</section>
	</div>
</body>
</html>