<%@ include file="../includes/jspIncludes.jsp" %>
	<div class="container-fluid">
	<form id="event-form" name="event-form" method="POST" action="./actionSaveEvents" class="form-horizontal popover">	<input type="hidden" name="eventBean.id" id="eventBean.id"/>
		<fieldset>
			<label>Events Info</label>
			<div class="close" id="close">X</div>
			<div class="form-group">
				<label for="eventBean.name" class="control-label col-sm-2">Event Name</label>
				<div class="col-sm-8">
					<input name="eventBean.name" id="eventBean.name" type="text" class="form-control mandatory"/>
				</div>
			</div>
			<div class="form-group">
				<label for="eventBean.eventDate" class="control-label col-sm-2">Event Date</label>
				<div class="col-sm-8">
					<input name="eventBean.eventDate" id="eventBean.eventDate" type="date" format="dd/mm/yyyy" class="form-control mandatory"/>
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
			<div class="text-right">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</fieldset>
	</form>
	</div>