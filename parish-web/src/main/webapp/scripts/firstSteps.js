var saveChurch = function(event){
	event.preventDefault();
	var overlay = $('.overlay');
	var church = parish.form.getFormData("church-form");
	console.log('here'+church);
	$.ajax({
		url : './actionFStepsSaveChurch',
		type : 'POST',
		data : church,
		beforeSend : function(){
			overlay.fadeIn();
		},
		success : function(resp){
			console.log("sucess function");
			$(document.body).html(resp);
		},
		error : function(resp){
			console.log("failure");
			parish.form.showErrors('church-form', resp.responseText);
		},
		complete : function(){
			overlay.hide();
		}
	});
} 

$(document).ready(function(){
	$('#church-form').on('submit', saveChurch);
})