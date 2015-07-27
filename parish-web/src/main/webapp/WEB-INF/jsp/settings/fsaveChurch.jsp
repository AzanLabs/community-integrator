<%@ include file="../includes/jspIncludes.jsp" %>	
<jsp:useBean id="churchBean" class="com.coop.parish.core.beans.ChurchBean">
	<jsp:setProperty name="churchBean" property="*"></jsp:setProperty>
</jsp:useBean>
<c:if test="${empty session.user or empty session.user.identifier}">
	<c:redirect url="./pageLogin"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Login</title>
<jsp:include page="../includes/staticIncludes.jsp"></jsp:include>
</head>
<body>
<div class="container">
	<p class="info">All fields are mandatory unless specified otherwise</p>
	<form id="church-form" name="church-form" method="POST"  action="./actionFStepsSaveChurch" class="form-horizontal">
		<fieldset>
			<label>General Info</label>
			<div class="form-group">
				<label for="churchBean.name" class="control-label col-sm-3 mandatory">Church Name</label>
				<div class="col-sm-9">
					<input name="churchBean.name" id="churchBean.name" type="text" class="form-control" 
					placeholder="Church Name" required autofocus value="${churchBean.name}"/>
				</div>
			</div>
		</fieldset>
		
	  	<fieldset>
		   <label>Address</label>
			<div class="form-group">
				<label for="churchBean.doorNo" class="control-label col-sm-3 mandatory">Door No</label>
				<div class="col-sm-9">
					<input name="churchBean.doorNo" id="churchBean.doorNo" type="text" class="form-control" 
					placeholder="Door No" required value="${churchBean.doorNo}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="churchBean.street" class="control-label col-sm-3 mandatory">Street</label>
				<div class="col-sm-9">
					<input name="churchBean.street" id="churchBean.street" type="text" class="form-control" required 
					placeholder="Street" value="${churchBean.street}"/>
				</div>
			</div>
	        <div class="form-group">
				<label for="churchBean.village" class="control-label col-sm-3 mandatory">Village / Town</label>
				<div class="col-sm-9">
					<input name="churchBean.village" id="churchBean.village" type="text" class="form-control" required
					placeholder="Village / Town" value="${churchBean.village}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="churchBean.taluk" class="control-label col-sm-3 optional">Taluk</label>
				<div class="col-sm-9">
					<input name="churchBean.taluk" id="churchBean.taluk" type="text" class="form-control" 
					placeholder="Taluk" value="${churchBean.taluk}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="churchBean.district" class="control-label col-sm-3 mandatory">District</label>
				<div class="col-sm-9">
					<input name="churchBean.district" id="churchBean.district" type="text" class="form-control" required
					placeholder="District" value="${churchBean.district}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="churchBean.state" class="control-label col-sm-3 mandatory">State</label>
				<div class="col-sm-9">
					<input name="churchBean.state" id="churchBean.state" type="text" class="form-control" required 
					placeholder="State" value="${churchBean.state}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="churchBean.country" class="control-label col-sm-3 mandatory">Country</label>
				<div class="col-sm-9">
					<input name="churchBean.country" id="churchBean.country" type="text" class="form-control" required 
					placeholder="Country" value="${churchBean.street}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="churchBean.pincode" class="control-label col-sm-3 mandatory">Pincode</label>
				<div class="col-sm-9">
					<input name="churchBean.pincode" id="churchBean.pincode" type="number" class="form-control" required 
					placeholder="Pincode" value="${churchBean.pincode}"/>
				</div>
			</div>
		</fieldset>
		
		<fieldset>
			<label>Contact Info</label>
			<div class="form-group">
				<label for="churchBean.telephoneNo" class="control-label col-sm-3 mandatory">Phone Number</label>
				<div class="col-sm-9">
					<input name="churchBean.telephoneNo" id="churchBean.telephoneNo" type="number" class="form-control" required 
					placeholder="Phone Number" value="${churchBean.telephoneNo}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="churchBean.mobileNo" class="control-label col-sm-3 optional">Mobile Number</label>
				<div class="col-sm-9">
					<input name="churchBean.mobileNo" id="churchBean.mobileNo" type="number" class="form-control" 
					placeholder="Mobile No" value="${churchBean.mobileNo}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="churchBean.emailId" class="control-label col-sm-3 mandatory">Email Id</label>
				<div class="col-sm-9">
					<input name="churchBean.emailId" id="churchBean.emailId" type="email" class="form-control" required 
					placeholder="Email Id" value="${churchBean.emailId}"/>
				</div>
			</div>
		</fieldset>
		
		<fieldset>
			<label>Church Info</label>
			<div class="form-group">
				<label for="churchBean.diocese" class="control-label col-sm-3 mandatory">Diocese</label>
				<div class="col-sm-9">
					<input name="churchBean.diocese" id="churchBean.diocese" type="text" class="form-control" required 
					placeholder="Diocese" value="${churchBean.diocese}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="churchBean.additionalInfo" class="control-label col-sm-3 mandatory">Church History</label>
				<div class="col-sm-9">
					<textarea name="churchBean.additionalInfo" id="churchBean.additionalInfo" rows="10" class="form-control" required 
					placeholder="Please Enter Church History">${churchBean.additionalInfo}</textarea>
				</div>
			</div>
			<hr/>
			<div class="text-right" id="submit-grp">
				<input id="submit" type="submit" class="submit btn btn-primary" value="Submit"/>
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>