<%@ include file="../includes/jspIncludes.jsp" %>
<div id="church-panel-container" class="container-fluid overlay-holder">
	<div class = "control-bar text-right">
		<a href="#">
			<button class="btn btn-primary glyphicon glyphicon-edit" id="update-church-btn">Edit</button>
		</a>
	</div>
	<div id="church-panel">
		
	</div>
</div>
<script>
	var cp =new ChurchController({
		"churchId" : 1, //include this variable from live
	});
	cp.init();
</script>
