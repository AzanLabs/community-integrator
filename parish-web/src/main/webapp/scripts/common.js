/**
 * common js functions needed for all modules and pages
 */
'use strict';
var parish = {};

parish.form = {
	
	/**
	 * @desc returns the data of the form in object form
	 * @param formId
	 * @returns {___anonymous162_163}
	 */
	getFormData : function(formId){	
		var form = $(document.getElementById(formId));
			var object = {};
			var inputArr;
			if(form){
				inputArr = form.find('input');
				inputArr.forEach = [].forEach;
				inputArr.forEach(function(input){
					object[input.name] = input.value;
				});
				
				inputArr = form.find('textarea');
				inputArr.forEach = [].forEach;
				inputArr.forEach(function(input){
					object[input.name] = input.value;
				});
				
				inputArr = form.find('select');
				inputArr.forEach = [].forEach;
				inputArr.forEach(function(input){
					object[input.name] = input.value;
				});
			}
			return object;
	},
	
	showErrors : function(formId, resp){
		var form = $(document.getElementById(formId));
		var errDiv;
		if(resp){
			for(var field in resp.errors){
				var fieldDiv = $(document.getElementById(field));
				resp.errors[field].forEach(
					function(ele){
						errDiv = $('<span class="has-warning"></span>');
						errDiv.text(ele);
						fieldDiv.parent().append(errDiv);
					});
			}
		}
		else{
			alert("no error");
		}
	},
	
	validateForm : function(formId){
		
	}
};

