<%@ include file="../includes/jspIncludes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parish</title>
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
	This jsp contains the Preference selection dropdown form
	<form name="preferences-form" id="preferences-form" method="POST" action="" class="form-horizontal container">
		<div class="form-group">
			<label for="state" class="col-sm-2 control-label">State</label>
			<div class="col-sm-8">
				<input name="state" type="text" class="form-control"/>
			</div>
		</div>
	</form>
</body>
</html>