<%@ include file="../includes/jspIncludes.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
	<jsp:useBean id="churchBean" class="com.coop.parish.core.beans.ChurchBean">
		<jsp:setProperty name="churchBean" property="*"></jsp:setProperty>
	</jsp:useBean>
	<div class="container">
	<h4 class="form-header">Church Information</h4>
	<form id="church-form" name="church-form" method="POST" action="./actionSaveChurch" class="form-horizontal">
		<fieldset>
		<label>General Info</label>
		<div class="form-group">
			<label for="churchBean.name" class="control-label col-sm-2">Church Name</label>
			<div class="col-sm-8">
				<input name="churchBean.name" id="churchBean.name" type="text" class="form-control" placeholder="Church Name" value="${churchBean.name}"/>
			</div>
		</div>
		</fieldset>
	  <fieldset>
	   <label>Address</label>
		<div class="form-group">
			<label for="churchBean.doorNo" class="control-label col-sm-2">Door No</label>
			<div class="col-sm-8">
				<input name="churchBean.doorNo" id="churchBean.doorNo" type="text" class="form-control" placeholder="Door No" value="${churchBean.doorNo}"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.street" class="control-label col-sm-2">Street</label>
			<div class="col-sm-8">
				<input name="churchBean.street" id="churchBean.street" type="text" class="form-control" placeholder="Street" value="${churchBean.street}"/>
			</div>
		</div>
        <div class="form-group">
			<label for="churchBean.village" class="control-label col-sm-2">Village / Town</label>
			<div class="col-sm-8">
				<input name="churchBean.village" id="churchBean.village" type="text" class="form-control" placeholder="Village / Town"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.taluk" class="control-label col-sm-2">Taluk</label>
			<div class="col-sm-8">
				<input name="churchBean.taluk" id="churchBean.taluk" type="text" class="form-control" placeholder="Taluk"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.district" class="control-label col-sm-2 mandatory">District</label>
			<div class="col-sm-8">
				<input name="churchBean.district" id="churchBean.district" type="text" class="form-control" placeholder="District"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.state" class="control-label col-sm-2 mandatory">State</label>
			<div class="col-sm-8">
				<input name="churchBean.state" id="churchBean.state" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.country" class="control-label col-sm-2 mandatory">Country</label>
			<div class="col-sm-8">
				<input name="churchBean.country" id="churchBean.country" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.pincode" class="control-label col-sm-2 mandatory">Pincode</label>
			<div class="col-sm-8">
				<input name="churchBean.pincode" id="churchBean.pincode" type="text" class="form-control"/>
			</div>
		</div>
		</fieldset>
		<fieldset>
		<label>Contact Info</label>
		<div class="form-group">
			<label for="churchBean.mobileNo" class="control-label col-sm-2 mandatory">Mobile Number</label>
			<div class="col-sm-8">
				<input name="churchBean.mobileNo" id="churchBean.mobileNo" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.emailId" class="control-label col-sm-2 mandatory">Email Id</label>
			<div class="col-sm-8">
				<input name="churchBean.emailId" id="churchBean.emailId" type="text" class="form-control"/>
			</div>
		</div>
		</fieldset>
		<fieldset>
		<label>Church Info</label>
		<div class="form-group">
			<label for="churchBean.diocese" class="control-label col-sm-2 mandatory">Diocese</label>
			<div class="col-sm-8">
				<input name="churchBean.diocese" id="churchBean.diocese" type="text" class="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="churchBean.additionalInfo" class="control-label col-sm-2 mandatory">Church History</label>
			<div class="col-sm-8">
				<textarea name="churchBean.additionalInfo" id="churchBean.additionalInfo" rows="10" class="form-control"></textarea>
			</div>
		</div>
		</fieldset>
      	<div class="form-group">
      		<input type="submit" name="submit" value="submit"/>
      	</div>
	</form>
	</div>
</body>
</html>