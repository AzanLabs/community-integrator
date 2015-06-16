<%@ include file="../includes/jspIncludes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PriestPanel</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/priestPanel.js"></script>
</head>
<body>
	<div class="container-fluid" id="priest-panel">
		<div class="row text-right">
			<a href="#add-priest" class="glyphicon glyphicon-add">
				<button class="btn btn-primary" id="add-new-priest" >Add New Priest</button>
			</a>
		</div>
		<!-- priest tiles -->
		<div id="priest-tiles">
			
		</div>
	</div>
</body>
</html>