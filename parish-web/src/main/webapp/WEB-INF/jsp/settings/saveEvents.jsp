<%@ include file="../includes/jspIncludes.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Save Events</title>
</head>
<body>
	<div class="container">
	<form id="priest-form" name="priest-form" method="POST" action="churchEvents" class="form-horizontal">
	<input type="hidden" name="eventBean.id" id="eventBean.id"/>
		<fieldset>
			<label>Events Info</label>
			<div class="form-group">
				<label for="eventBean.name" class="control-label col-sm-2">Event Name</label>
				<div class="col-sm-8">
					<input name="eventBean.name" id="eventBean.name" type="text" class="form-control mandatory"/>
				</div>
			</div>
			<div class="form-group">
				<label for="eventBean.eventDate" class="control-label col-sm-2">Event Date</label>
				<div class="col-sm-8">
					<input name="eventBean.eventDate" id="eventBean.eventDate" type="text" class="form-control mandatory"/>
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
					<textarea name="eventBean.details" id="eventBean.details" class="form-control mandatory"></textarea>
				</div>
			</div>
		</fieldset>
		<input type="hidden" name="eventBean.churchId" id="eventBean.churchId"/>
	</form>
	</div>
</body>
</html>