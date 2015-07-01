<%@ include file="../includes/jspIncludes.jsp" %>
<div class="container-fluid overlay-holder" id="events-panel">
	<div class="overlay"></div>
	<div class="control-bar text-right">
		<a href="#add-events">
			<button class="btn btn-primary glyphicon glyphicon-plus" id="add-new-event">New Event</button>
		</a>
	</div>
	<!-- events tiles -->
	<div id="events-tiles">
		<c:import url="./saveEvents.jsp"></c:import>
		<c:import url="./viewEvent.jsp"></c:import>
		<c:import url="./updateEvents.jsp"></c:import>
	</div>
</div>
<script type="text/javascript">
	var ep = new EventsController();
	ep.init();
</script>