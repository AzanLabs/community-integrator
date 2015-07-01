<%@ include file="../includes/jspIncludes.jsp" %>
<jsp:useBean id="p" class="com.coop.parish.core.beans.PriestBean" scope="request">
	<jsp:setProperty name="p" property="*"></jsp:setProperty>
</jsp:useBean>
<div id="view-priest-container" class="popover">
	<a class="close">X</a>
	<h4>View Priest</h4>
	<fieldset>
		<label>Basic Info</label>
		<div class="row">
			<div class="col-sm-4">
				<img class="priest-profile-image" id="profile-img" src='' alt="priest img"/>
			</div>
			<div class="col-sm-8">
				<div class="row">
					<label class="col-sm-3">Name</label>
					<div class="col-sm-9" id="name">${requestScope.p.name}</div>
				</div>
				<div class="row">
					<label class="col-sm-3">Date OF Birth</label>
					<div class="col-sm-9" id="dob">${requestScope.p.dob}</div>
				</div>
				<div class="row">
					<label class="col-sm-3">Birth Place</label>
					<div class="col-sm-9" id="birthplace">${requestScope.p.birthPlace}</div>
				</div>
			</div>	
		</div>
		
		
	</fieldset>
	<fieldset>
		<label>Education</label>
		<div class="row">
			<label class="col-sm-3">Education</label>
			<div class="col-sm-9" id="education">${requestScope.p.education}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Specialization</label>
			<div class="col-sm-9" id="specialization">${requestScope.p.specialization}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Educated University</label>
			<div class="col-sm-9" id="educatedUniversity">${requestScope.p.educatedUniversity}</div>
		</div>
	</fieldset>
	<fieldset>
		<label>Address</label>
		<div class="row">
			<label class="col-sm-3">Address</label>
			<div class="col-sm-9">
				<span id="doorNo">${requestScope.p.doorNo}</span> - <span id="street">${requestScope.p.street},</span><br/>
				<div id="village">${requestScope.p.village}</div>
				<div id="taluk">${requestScope.p.taluk}</div>
				<div id="district">${requestScope.p.district}</div>
			</div>
		</div>
		<div class="row">
			<label class="col-sm-3">State</label>
			<div class="col-sm-9" id="state">${requestScope.p.state}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Country</label>
			<div class="col-sm-9" id="country">${requestScope.p.country}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Pincode</label>
			<div class="col-sm-9" id="pincode">${requestScope.p.pincode}</div>
		</div>
	</fieldset>
	
	<fieldset>
		<label>Contact Info</label>
		<div class="row">
			<label class="col-sm-3">Telephone Number</label>
			<div class="col-sm-9" id="telephoneNo">${requestScope.p.telephoneNo}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Mobile Number</label>
			<div class="col-sm-9" id="mobileNo">${requestScope.p.mobileNo}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Email Id</label>
			<div class="col-sm-9" id="emailId">${requestScope.p.emailId}</div>
		</div>
	</fieldset>
		
	<fieldset>
		<label>Additional Info</label>
		<div class="row">
			<label class="col-sm-3">Diocese</label>
			<div class="col-sm-9" id="diocese">${requestScope.p.diocese}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Church History</label>
			<div class="col-sm-9" id="additionalPosition">${requestScope.p.additionalPosition}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">Church History</label>
			<div class="col-sm-9" id="additionalInfo">${requestScope.p.additionalInfo}</div>
		</div>
	</fieldset>
</div>