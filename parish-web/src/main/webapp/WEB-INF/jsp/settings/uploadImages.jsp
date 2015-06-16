<%@ include file="../includes/jspIncludes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Church Images</title>
</head>
<body>
<iframe name="target-frame" width="400" height="300">
	${requestScope.uplaodFileName}
</iframe>
<form name="uploadd-form" action="./actionUploadFiles" method="POST" enctype="multipart/form-data" class="form-horizontal" target="target-frame">
	<fieldset>
		<label>Upload Image</label>
		<div class="form-group">
			<label for="file" class="control-label col-sm-2">Church Name</label>
			<div class="col-sm-8">
				<input name="upload" id="file" type="file" class="form-control mandatory" 
				placeholder="File" required/>
				<input name="submit" id="submit" class="btn btn-primary" type="submit"/>
			</div>
		</div>
	</fieldset>
</form>
</body>
</html>