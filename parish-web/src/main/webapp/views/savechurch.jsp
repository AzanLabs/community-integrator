<%@ include file="jspincludes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="staticincludes.html"></jsp:include>
</head>
<body>
	<div class="container">
	<form id="church-form" name="church-form" method="POST" action="savechurch" class="form-horizontal">
		<div class="form-group">
			<label for="churchBean.name" class="control-label col-sm-2">Church Name</label>
			<div class="col-sm-8">
				<input name="churchBean.name" id="churchBean.name" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
        	<label class="col-sm-2 control-label">Address</label>
            <div class="col-sm-8">
              <div class="form-inline">
                <div class="form-group no-margin">
                  <input id="churchBean.doorNo" name="churchBean.doorNo" class="form-control" type="text" placeholder="Door No"/>
                </div>
                <div class="form-group no-margin">
                  <input id="churchBean.street" name="churchBean.street" class="form-control" type="text" placeholder="Street"/>
                </div>
              </div>
            </div>
        </div>
        <div class="form-group">
			<label for="churchBean.village" class="control-label col-sm-2">Village / Town</label>
			<div class="col-sm-8">
				<input name="churchBean.village" id="churchBean.village" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.name" class="control-label col-sm-2">Church Name</label>
			<div class="col-sm-8">
				<input name="churchBean.name" id="churchBean.name" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.name" class="control-label col-sm-2">Church Name</label>
			<div class="col-sm-8">
				<input name="churchBean.name" id="churchBean.name" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.name" class="control-label col-sm-2">Church Name</label>
			<div class="col-sm-8">
				<input name="churchBean.name" id="churchBean.name" type="text" class="form-control"/>
			</div>
		</div>
      	<div class="form-group">
      		<input type="submit" name="submit" value="submit"/>
      	</div>
	</form>
	</div>
</body>
</html>