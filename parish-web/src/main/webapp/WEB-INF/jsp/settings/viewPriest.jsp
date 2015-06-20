<%@ include file="../includes/jspIncludes.jsp" %>
<jsp:useBean id="p" class="com.coop.parish.core.beans.PriestBean" scope="request">
	<jsp:setProperty name="p" property="*"></jsp:setProperty>
</jsp:useBean>
<div id="view-priest-container">
	<fieldset>
		<label>Basic Info</label>
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.name}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Date OF Birth</div>
			<div class="col-sm-6">${requestScope.p.dob}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Birth Place</div>
			<div class="col-sm-6">${requestScope.p.birthPlace}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Education</div>
			<div class="col-sm-6">${requestScope.p.education}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Specialization</div>
			<div class="col-sm-6">${requestScope.p.specialization}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Educated University</div>
			<div class="col-sm-6">${requestScope.p.educatedUniversity}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Door No</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">Name</div>
			<div class="col-sm-6">${requestScope.p.doorNo}</div>
		</div>
	</fieldset>
</div>