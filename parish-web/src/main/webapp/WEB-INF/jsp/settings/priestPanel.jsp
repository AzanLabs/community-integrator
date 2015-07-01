<%@ include file="../includes/jspIncludes.jsp" %>
<div class="container-fluid overlay-holder" id="priest-panel">
	<div class="control-bar text-right">
		<a href="#add-priest">
			<button class="btn btn-primary glyphicon glyphicon-plus" id="add-new-priest" >New Priest</button>
		</a>
	</div>
	<div class="overlay"></div>
	<!-- priest tiles -->
	<div id="priest-tiles">
		<c:import url="./savePriest.jsp"></c:import>
		<c:import url="./viewPriest.jsp"></c:import>
		<c:import url="./updatePriest.jsp"></c:import>
	</div>
</div>
<script type="text/javascript">
	var pp = new PriestController();
	pp.init();
</script>
