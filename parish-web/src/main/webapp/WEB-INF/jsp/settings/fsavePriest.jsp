<%@ include file="../includes/jspIncludes.jsp" %>
	<form id="priest-form" name="priest-form" method="POST" action="./actionSavePriest" 
		enctype="multipart/form-data" class="form-horizontal popover">
		<a class="close">X</a>
		<h2>Priest Form</h2>
		<div class="with-img overlay-holder">
			<fieldset>
			<label>Basic Info</label>
			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
						<label for="priestBean.name" class="control-label col-sm-2">Priest Name</label>
						<div class="col-sm-8">
							<input name="priestBean.name" id="priestBean.name" type="text" class="form-control mandatory" required
							placeholder="Name"/>
						</div>
					</div>
					<div class="form-group">
						<label for="priestBean.dob" class="control-label col-sm-2">Priest DOB</label>
						<div class="col-sm-8">
							<input name="priestBean.dob" id="priestBean.dob" type="text" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label for="priestBean.birthPlace" class="control-label col-sm-2">Priest Birth Place</label>
						<div class="col-sm-8">
							<input name="priestBean.birthPlace" id="priestBean.birthPlace" type="text" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<label>PriestImage</label>
					<div class="priest-img-holder">
						<img src="/parish/images/no-img-icon-md.png" class="priest-img border">
					</div>
					<input name="upload" type="file">
				</div>
			</div>
			</fieldset>
		</div>
		<fieldset>
			<label>Education</label>
			<div class="form-group">
				<label for="priestBean.education" class="control-label col-sm-2">Priest Education</label>
				<div class="col-sm-8">
					<input name="priestBean.education" id="priestBean.education" type="text" class="form-control"/>
				</div>
			</div>
	       <div class="form-group">
				<label for="priestBean.specialization" class="control-label col-sm-2">Priest Specialization</label>
				<div class="col-sm-8">
					<input name="priestBean.specialization" id="priestBean.specialization" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.educatedUniversity" class="control-label col-sm-2">Priest Educated University</label>
				<div class="col-sm-8">
					<input name="priestBean.educatedUniversity" id="priestBean.educatedUniversity" type="text" class="form-control"/>
				</div>
			</div>
		</fieldset>
		
		<fieldset>
			<label>Address</label>
			<div class="form-group">
				<label for="priestBean.doorNo" class="control-label col-sm-2">Priest Door Number</label>
				<div class="col-sm-8">
					<input name="priestBean.doorNo" id="priestBean.doorNo" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.street" class="control-label col-sm-2">Priest Street</label>
				<div class="col-sm-8">
					<input name="priestBean.street" id="priestBean.street" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.village" class="control-label col-sm-2">Priest Village</label>
				<div class="col-sm-8">
					<input name="priestBean.village" id="priestBean.village" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.taluk" class="control-label col-sm-2">Priest Taluk</label>
				<div class="col-sm-8">
					<input name="priestBean.taluk" id="priestBean.taluk" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.district" class="control-label col-sm-2">Priest District</label>
				<div class="col-sm-8">
					<input name="priestBean.district" id="priestBean.district" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.district" class="control-label col-sm-2">Priest District</label>
				<div class="col-sm-8">
					<input name="priestBean.district" id="priestBean.district" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.state" class="control-label col-sm-2">Priest State</label>
				<div class="col-sm-8">
					<input name="priestBean.state" id="priestBean.state" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.country" class="control-label col-sm-2">Priest Country</label>
				<div class="col-sm-8">
					<input name="priestBean.country" id="priestBean.country" type="text" class="form-control"/>
				</div>
			</div>
		</fieldset>
		
		<fieldset>
			<label>Contact Info</label>
			<div class="form-group">
				<label for="priestBean.pincode" class="control-label col-sm-2">Priest Pincode</label>
				<div class="col-sm-8">
					<input name="priestBean.pincode" id="priestBean.pincode" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.telephoneNo" class="control-label col-sm-2">Priest Telephone Number</label>
				<div class="col-sm-8">
					<input name="priestBean.telephoneNo" id="priestBean.telephoneNo" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.mobileNo" class="control-label col-sm-2">Priest Mobile Number</label>
				<div class="col-sm-8">
					<input name="priestBean.mobileNo" id="priestBean.mobileNo" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.emailId" class="control-label col-sm-2">Priest Email Id</label>
				<div class="col-sm-8">
					<input name="priestBean.emailId" id="priestBean.emailId" type="text" class="form-control"/>
				</div>
			</div>
		</fieldset>
		
		<fieldset>
		<label>Additional Info</label>
			<div class="form-group">
				<label for="priestBean.diocese" class="control-label col-sm-2">Priest Diocese</label>
				<div class="col-sm-8">
					<input name="priestBean.diocese" id="priestBean.diocese" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.additionalPosition" class="control-label col-sm-2">Priest Addditional Position</label>
				<div class="col-sm-8">
					<input name="priestBean.additionalPosition" id="priestBean.additionalPosition" type="text" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="priestBean.additionalInfo" class="control-label col-sm-2">Priest Additional Information</label>
				<div class="col-sm-8">
					<textarea name="priestBean.additionalInfo" id="priestBean.additionalInfo" class="form-control"></textarea>
				</div>
			</div>
			<hr/>
			<div class="text-right">
				<a href="#close" class="clear">Cancel</a>
				<button id="submit" type="submit" class="btn btn-primary">Submit</button>
			</div>
		</fieldset>
	</form>