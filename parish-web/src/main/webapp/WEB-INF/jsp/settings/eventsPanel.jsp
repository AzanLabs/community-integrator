<%@ include file="../includes/jspIncludes.jsp" %>
<div class="container-fluid overlay-holder" id="events-panel">
	<div class="overlay"></div>
	<div class="row text-right">
		<a href="#add-events">
			<button class="btn btn-primary" id="add-new-event" class="glyphicon glyphicon-plus">New Event</button>
		</a>
	</div>
	<!-- events tiles -->
	<div id="events-tiles" class="container-fluid">
		<c:import url="./saveEvents.jsp"></c:import>
	</div>
</div>
<script type="text/javascript">
	var ep = new EventsController();
	ep.init();
</script>