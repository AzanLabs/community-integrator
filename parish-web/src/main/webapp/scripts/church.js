var church = {};

church.save = function(event, scope, successFn, errorFn){
	if(event)
		event.preventDefault();
	var formId = 'church-form';
	$('#church-form > .has-warning').remove();
	console.log('here');
	var church = form.getFormData(formId);
	debugger;
	console.log('here');
	if(church){
		$.ajax({
			url : './actionFStepsSaveChurch',
			type : 'POST',
			data : church,
			success : function(resp){
				console.log("here"+resp);
				$(document.body).innerHtml = resp;
				if(successFn)
					successFn.call(scope, resp);
			},
			error : function(resp){
				console.log("failure"+resp);
				window.form.showErrors(formId, resp);
				if(errorFn)
					errorFn.call(scope, resp);
			}
		});
	}
};

