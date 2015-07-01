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

function ResponseBox(){
	this.content = '';
	this.successView = $("#response-box-success");
	this.errorView = $("#response-box-error");
	this.errorView.find(".close").on('click', this.closeErrorView.bind(this));
	this.errorViewContent = this.errorView.find(".content");
	this.successViewContent = this.successView.find(".content");
}

ResponseBox.prototype = {
		success : function(content){
			this.successViewContent.html($("<p class='small'></p>").html(content));
			this.successView.fadeIn().delay(3000).fadeOut();
		},
		error : function(resp){
			var errors,
			content = $("<p class='small'></p>");
			if(resp.responseJSON){
				errors = resp.responseJSON.errors;
				for(var key in errors){
					var error = errors[key];
					if(error instanceof Array){
						error.forEach(function(ele){
							content.append($("<div>").html(ele));
						});
					}else{
						content.append($("<div>").html(error));
					}
				}
			}
			this.errorViewContent.html(content);
			this.errorView.fadeIn().delay(10000).fadeOut();
		},
		closeErrorView : function(e){
			e.preventDefault();
			this.errorView.hide();
		}
}

