<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
$.ready(function(){ 
	var church = $("#submit");
	church.on('click', function(event){
		event.preventDefault(); 
		var church={}; 
		$.ajax({ url : './savechurch',
				data : church,
				success : function(resp) {console.log(resp); },
				error : function(resp) { console.log(resp);}
		});
	});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="church_form" action="./savechurch" method="POST">
    Name : <input name="church.name" type="text"/><br/>
    DoorNo : <input name="church.doorNo" type="text"/><br/>
    Street : <input name="church.street" type="text"/><br/>
    Village : <input name="church.village" type="text"/><br/>
	<input type="submit" value="submit" id="submit"/>
</form>
</body>
</html>