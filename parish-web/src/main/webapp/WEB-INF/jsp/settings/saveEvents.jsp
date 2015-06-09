<%@ include file="../includes/jspIncludes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
	<div class="container">
	<form id="priest-form" name="priest-form" method="POST" action="churchEvents" class="form-horizontal">
	<input type="hidden" name="eventBean.id" id="eventBean.id"/>
		<div class="form-group">
			<label for="eventBean.name" class="control-label col-sm-2">Event Name</label>
			<div class="col-sm-8">
				<input name="eventBean.name" id="eventBean.name" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="eventBean.eventDate" class="control-label col-sm-2">Event Date</label>
			<div class="col-sm-8">
				<input name="eventBean.eventDate" id="eventBean.eventDate" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="eventBean.description" class="control-label col-sm-2">Event Description</label>
			<div class="col-sm-8">
				<input name="eventBean.description" id="eventBean.description" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="eventBean.details" class="control-label col-sm-2">Event Details</label>
			<div class="col-sm-8">
				<input name="eventBean.details" id="eventBean.details" type="text" class="form-control"/>
			</div>
		</div>
		<input type="hidden" name="eventBean.churchId" id="eventBean.churchId"/>
	</form>
	</div>
</body>
</html>