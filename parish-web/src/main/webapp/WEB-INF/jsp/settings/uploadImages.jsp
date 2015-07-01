<%@ include file="../includes/jspIncludes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Church Images</title>
</head>
<body>
<form id="upload-form" name="upload-form" action="./actionUploadMultipleFiles" method="POST" enctype="multipart/form-data" class="form-horizontal">
	<fieldset>
		<label>Upload Image</label>
		<div class="form-group">
			<label for="file" class="control-label col-sm-2">Church Name</label>
			<div class="col-sm-8">
				<input name="upload" id="file" type="file" class="form-control mandatory" 
				placeholder="File" required/>
				<input name="upload" id="file" type="file" class="form-control mandatory" 
				placeholder="File" required/>
				<input id="submit" class="btn btn-primary" type="submit"/>
			</div>
		</div>
	</fieldset>
</form>
</body>
</html>