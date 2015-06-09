<%@ include file="../includes/jspIncludes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
	<!-- first steps starts-->
	<!-- steps -->
	<nav class="steps container">
		<ul class="nav">
			<li class="col-sm-4">
				<section class="row">
					<div class="col-sm-3">
						<h1>1</h1>
					</div>
					<div class="col-sm-9">
						<p>Save Church Info</p>
					</div>
				</section>
			</li>
			<li class="col-sm-4">
				<section class="row">
					<div class="col-sm-3">
						<h1>1</h1>
					</div>
					<div class="col-sm-9">
						<p>Save Church Info</p>
					</div>
				</section>
			</li>
			<li class="col-sm-4">
				<section class="row">
					<div class="col-sm-3">
						<h1>1</h1>
					</div>
					<div class="col-sm-9">
						<p>Save Church Info</p>
					</div>
				</section>
			</li>
		</ul>
	</nav>
	<!-- steps ends -->
	
	<!-- tab panel starts -->
	<div id="firststeps-tabs" class="container">
		<div id="firststeps-church" class="tab active">
			<c:import url="./saveChurch.jsp"></c:import>
		</div>
		<div id="firststeps-priest" class="tab hidden">
			<c:import url="./savePriest.jsp"></c:import>
		</div>
		<div id="firststeps-images" class="tab hidden">
			<c:import url="./saveEvents.jsp"></c:import>
		</div>
	</div>
	<!-- tab panel ends -->
	<!-- first steps ends -->
</body>
</html>