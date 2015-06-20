<%@ include file="../includes/jspIncludes.jsp" %>
<div class="container-fluid overlay-holder" id="priest-panel">
	<div class="control-bar text-right">
		<a href="#add-priest" class="glyphicon glyphicon-add">
			<button class="btn btn-primary" id="add-new-priest" >Add New Priest</button>
		</a>
	</div>
	<div class="overlay"></div>
	<!-- priest tiles -->
	<div id="priest-tiles" class="container-fluid">
		<c:import url="./savePriest.jsp"></c:import>
	</div>
</div>
<script type="text/javascript">
	var pp = new PriestController();
	pp.init();
</script>
