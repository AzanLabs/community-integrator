<%@ include file="../includes/jspIncludes.jsp" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
	<div>
		<div id="body-overlay" class="overlay">
			<h4 class="overlay-text">
				Loading...
			</h4>
		</div>
		<div class="navbar navbar-default">
			<div class="navbar-brand">Logo</div>
		</div>
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
			<div id = "edit-priest" class="nav-panel"></div>
			<div id = "edit-events" class="nav-panel"></div>
		</section>
	</div>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/settings.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/panels.js"></script> 
</body>
</html>