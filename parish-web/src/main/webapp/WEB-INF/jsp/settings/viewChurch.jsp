<%@ include file="../includes/jspIncludes.jsp" %>

<jsp:useBean id="churchBean" class="com.coop.parish.core.beans.ChurchBean" scope="request">
	<jsp:setProperty name="churchBean" property="*"></jsp:setProperty>
</jsp:useBean>
<div class="container-fluid">
	<fieldset>
		<label>General Info</label>
		<div class="row">
			<label class="col-sm-3">Church Name</label>
			<div class="col-sm-9">
				${churchBean.name}
			</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Address</label>
			<div class="col-sm-9">
				${churchBean.doorNo} - ${churchBean.street},<br/>
				${churchBean.village} <br/>
				${churchBean.taluk} <br/>
				${churchBean.district} <br/>
			</div>
		</div>
		<div class="row">
			<label class="col-sm-3">State</label>
			<div class="col-sm-9">${churchBean.state}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Country</label>
			<div class="col-sm-9">${churchBean.country}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Pincode</label>
			<div class="col-sm-9">${churchBean.pincode}</div>
		</div>
	</fieldset>
		
	<fieldset>
		<label>Contact Info</label>
		<div class="row">
			<label class="col-sm-3">Telephone Number</label>
			<div class="col-sm-9">${churchBean.telephoneNo}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Mobile Number</label>
			<div class="col-sm-9">${churchBean.mobileNo}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Email Id</label>
			<div class="col-sm-9">${churchBean.emailId}</div>
		</div>
	</fieldset>
		
	<fieldset>
		<label>Church Info</label>
		<div class="row">
			<label class="col-sm-3">Diocese</label>
			<div class="col-sm-9">${churchBean.diocese}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Church History</label>
			<div class="col-sm-9">${churchBean.additionalInfo}</div>
		</div>
	</fieldset>
</div>