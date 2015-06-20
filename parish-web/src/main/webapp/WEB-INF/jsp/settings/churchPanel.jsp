<%@ include file="../includes/jspIncludes.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ChurchPanel</title>
</head>
<body>
	<div id="church-panel-container" class="overlay-holder">
		<div class = "edit-btn-holder text-right">
		</div>
		<div class="overlay"></div>
		<div class="no-edit"></div>
		<div id="church-panel" class="overlay-holder">
			
		</div>
	</div>
	<script>
		new ChurchController({
			"churchId" : 1,
		});
	</script>
</body>
</html>