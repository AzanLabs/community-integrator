<%@ include file="../includes/jspIncludes.jsp" %>
<form id="event-update-form" name="event-form" method="POST" action="./actionSaveEvents" class="form-horizontal popover">
	<a class="close">X</a>
	<h4>Update Form</h4>
	<fieldset>
		<label>Event</label>
		<input type="hidden" name="eventBean.id" id="id"/>
		<div class="form-group">
			<label for="eventBean.name" class="control-label col-sm-2">Event Name</label>
			<div class="col-sm-8">
				<input name="eventBean.name" id="name" type="text" class="form-control mandatory"/>
			</div>
		</div>
		<div class="form-group">
			<label for="eventBean.eventDate" class="control-label col-sm-2">Event Date</label>
			<div class="col-sm-8">
				<input name="eventBean.eventDate" id="eventDate" type="date" format="dd/mm/yyyy" class="form-control mandatory"/>
			</div>
		</div>
		<div class="form-group">
			<label for="eventBean.description" class="control-label col-sm-2">Event Description</label>
			<div class="col-sm-8">
				<input name="eventBean.description" id="description" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="eventBean.details" class="control-label col-sm-2">Event Details</label>
			<div class="col-sm-8">
				<textarea name="eventBean.details" id="details" class="form-control mandatory"></textarea>
			</div>
		</div>
		<hr/>
		<div class="text-right">
			<a class="clear" href="#clear">Cancel</a>
			<button type="submit" class="btn btn-primary">Update</button>
		</div>
	</fieldset>
</form>