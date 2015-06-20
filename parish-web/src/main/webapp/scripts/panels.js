/**
 * Priest Modal
 */
'use strict';
function Priest(config){
	if(config){
		for(var key in config){
			this[key] = config[key];
		}
	}
}

function ChurchController(config){
	
	this.churchId = config.churchId;
	this.view = $("#church-panel");//view
	this.church = ''; //modal
	this.overlay = $("#church-panel-container .overlay");
	this.viewHide = $("#church-panel-container .no-edit");
	this.init();
} 

ChurchController.prototype = {
		init : function(){
			this.cancelBtn = $("<a href='#cancel' alt='cancel'>Cancel</a>");
			this.cancelBtn.on('click', this.makeAsView.bind(this));// binding the cancel function
			var edit = $('<a href="#edit" id="church-edit-btn">Edit</a>');
			edit.on('click', this.makeAsForm.bind(this));
			edit.appendTo($('.edit-btn-holder'));//binding the eedit btn function
			this.loadData(this.churchId); //loads data
			//this.renderChurchPanel(); // render the churchpanel
			
		},
		showOverlay : function(text){
			this.overlay.text(text);
			this.overlay.fadeIn();
		},
		hideOverlay : function(){
			this.overlay.fadeOut();
		},
		loadData : function(churchId){
			//get the data and render to panel
			var that = this;
			$.ajax({
				url : './pageChurchForm',
				type : 'GET',
				beforeSend : function(){
					that.showOverlay();
				},
				success : function(resp){
					console.log(resp);
					//returns the form
					that.church = resp;
					that.renderChurchPanel();
				},
				error : function(resp){
					console.log(resp);
				},
				complete : function(){
					that.hideOverlay();
				}
			});
		},
		makeAsView : function(){
			$('#church-form #submit-grp').hide();
			$('#church-form .form-control').css('border','none');
			this.viewHide.fadeIn();
		},
		makeAsForm : function(){
			$('#church-form #submit-grp').show();
			$('#church-form .form-control').css('border-bottom','#08C 1px dashed');
			this.viewHide.fadeOut();
		},
		renderChurchPanel : function(){
			if(this.church){
				this.view.html(this.church);
				$('#church-form #submit').before(this.cancelBtn); //add cancelbtn to the form
				this.makeAsView();
			}
		}
}

function PriestController(){
	 
	this.dom = [];
	this.priests = [];
	this.holder = $('#priest-tiles');
	this.overlay = $('#priest-panel .overlay');
	
	this.addForm = $('#priest-form');
	this.updateForm = '';
	this.view = $('<div></div>');
	
	this.updateFormLoaded = false;
	this.viewLoaded = false;
}

PriestController.prototype = {
	
	init : function(){
		//load the data
		var priests = {'1001' : {
		    name : 'sankar',
		    image : 'http://img.jgi.doe.gov/images/img-user-forum.png'
		}, '1002' : {
		    name : 'sankar',
		    image : 'http://img.jgi.doe.gov/images/img-user-forum.png'
		},'1003' : {
		    name : 'sankar',
		    image : 'http://img.jgi.doe.gov/images/img-user-forum.png'
		}};
		
		$("#add-new-priest").on('click', this.showAddForm.bind(this));
		$("#priest-form .close").on('click', this.switchFromFormToView.bind(this));
		$("#priest-form").on('submit', this.handleSave.bind(this));
		this.addForm.hide();
		this.priests = priests;
		this.createDom();
		this.loadDataToDom();
		this.show();
	},
	loadData : function(){
		var that = this;
		$.ajax({
			url : '.',
			type : 'GET',
			beforeSend : function(){
				
			},
			success : function(resp){
				console.log(resp);
			},
			error : function(resp){
				console.log(resp);
			},
			complete : function(){
				
			}
		});
	},
	createDom : function(){
		for(var key in this.priests){
			var dom = {};
			dom.container = $("<div class='priest'></div>");
			dom.image = $("<img src='' alt='priest-image'></img>");
			dom.name = $("<h4></h4>");
			dom.container.append(dom.image).append(dom.name);
			
			//controls
			dom.controls = $("<div class='controls text-right'></div>");
			dom.viewBtn = $("<a href='#view'>View</a>").on('click', this.priestFullView.bind(this));
			dom.viewBtn.data('id',key);
			dom.editBtn = $("<a href='#edit'>Edit</a>").on('click', this.editPriest.bind(this));
			dom.editBtn.data('id',key);
			dom.deleteBtn = $("<a href='#delete'>Delete</a>").on('click', this.deletePriest.bind(this));
			dom.deleteBtn.data('id',key);
			
			var v = dom.container.append(dom.controls.append(dom.viewBtn).append(dom.editBtn).append(dom.deleteBtn));
			this.view.append(v);
			this.dom[key] = dom;
			this.viewLoaded = true;
		}
	},
	loadDataToDom : function(){
		for(var key in this.priests){
			this.dom[key].image.attr('src',this.priests[key].image);
			this.dom[key].name.html(this.priests[key].name);
		}
	},
	show : function(){
		this.holder.append(this.view);
	},
	showAddForm : function(event){
		event.preventDefault();
		this.view.hide();
		this.addForm.fadeIn();
	},
	switchFromFormToView : function(event){
		event.preventDefault();
		this.addForm.hide();
		this.view.fadeIn();
	},
	handleSave : function(event){
		event.preventDefault();
		var data = new FormData(document.getElementById('priest-form'));; 
		var that = this;
		var xhr = new XMLHttpRequest();
		xhr.onReadyStateChange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				console.log(xhr.response);
				that.addForm.hide();
				that.view.fadeIn();
			}else if(xhr.readyState == 4 && xhr.status != 200){
				console.log(xhr.response);
			}
		}
		xhr.open("POST",'./actionSavePriest',true);
		xhr.send(data);
	},
	priestFullView : function(event){
		event.preventDefault();
		//get the full view of priest
		var priestId = $(event.target).data('id');
		$.ajax({
			url : './',
			type : 'POST',
			data : this.priests[priestId],
			beforeSend : function(){
				
			},
			success : function(){
				
			},
			error : function(){
				
			},
			complete : function(){
				
			}
		});
	},
	editPriest : function(event){
		var priestId = $(event.target).data('id');
		$.ajax({
			url : './',
			type : 'POST',
			data : this.priests[priestId],
			beforeSend : function(){
				
			},
			success : function(){
				
			},
			error : function(){
				
			},
			complete : function(){
				
			}
		});
	},
	deletePriest : function(event){
		var priestId = $(event.target).data('id');
		$.ajax({
			url : './',
			type : 'GET',
			data : priestId,
			beforeSend : function(){
				
			},
			success : function(){
				
			},
			error : function(){
				
			},
			complete : function(){
				
			}
		});
	}
};

function EventsController(){
	 
	this.dom = [];
	this.events = [];
	this.holder = $('#events-tiles');
	this.overlay = $('#events-panel .overlay');
	
	this.addForm = $('#event-form');
	this.updateForm = '';
	this.view = $('<div></div>');
	this.fullView = '';
	
	this.updateFormLoaded = false;
	this.viewLoaded = false;
}

EventsController.prototype = {
	
	init : function(){
		//load the data
		var events = {'1001' : {
		    name : 'sankar',
		    image : 'http://img.jgi.doe.gov/images/img-user-forum.png'
		}, '1002' : {
		    name : 'sankar',
		    image : 'http://img.jgi.doe.gov/images/img-user-forum.png'
		},'1003' : {
		    name : 'sankar',
		    image : 'http://img.jgi.doe.gov/images/img-user-forum.png'
		}};
		
		$("#add-new-event").on('click', this.showAddForm.bind(this));
		$("#event-form #close").on('click', this.switchFromFormToView.bind(this));
		$("#event-form").on('submit', this.handleSave.bind(this));
		this.addForm.hide();
		//this.events = events;
		this.loadData();
		this.createDom();
		this.loadDataToDom();
		this.show();
	},
	loadData : function(){
		var that = this;
		$.ajax({
			url : './actionAllEvents',
			type : 'GET',
			async : false,
			beforeSend : function(){
				that.overlay.show();
			},
			success : function(resp){
				that.events = resp.events;
				console.log(resp);
			},
			error : function(resp){
				console.log(resp);
			},
			complete : function(){
				that.overlay.fadeOut();
			}
		});
	},
	createDom : function(){
		for(var key in this.events){
			var dom = {};
			dom.container = $("<div class='event'></div>");
			dom.image = $("<img src='' alt='event-image'></img>");
			dom.name = $("<h4></h4>");
			dom.container.append(dom.image).append(dom.name);
			
			//controls
			dom.controls = $("<div class='controls text-right'></div>");
			dom.viewBtn = $("<a href='#view'>View</a>").on('click', this.eventFullView.bind(this));
			dom.viewBtn.data('id',key);
			dom.editBtn = $("<a href='#edit'>Edit</a>").on('click', this.editEvent.bind(this));
			dom.editBtn.data('id',key);
			dom.deleteBtn = $("<a href='#delete' class='glyphicon glyphicon-trash'>Delete</a>").on('click', this.deleteEvent.bind(this));
			dom.deleteBtn.data('id',key);
			
			var v = dom.container.append(dom.controls.append(dom.viewBtn).append(dom.editBtn).append(dom.deleteBtn));
			this.view.append(v);
			this.dom[key] = dom;
			this.viewLoaded = true;
		}
	},
	loadDataToDom : function(){
		for(var key in this.events){
			this.dom[key].image.attr('src','http://img.jgi.doe.gov/images/img-user-forum.png');
			this.dom[key].name.html(this.events[key].name);
		}
	},
	show : function(){
		this.holder.append(this.view);
	},
	showAddForm : function(e){
		e.preventDefault();
		this.view.hide();
		this.addForm.fadeIn();
	},
	clearForm : function(){
		this.addForm.find('input').val('');
		this.addForm.find('textarea').val('');
	},
	switchFromFormToView : function(){
		this.clearForm();
		this.addForm.hide();
		this.view.fadeIn();
	},
	handleSave : function(e){
		e.preventDefault();
		var that = this;
		var event = parish.form.getFormData('event-form');
		$.ajax({
			url : './actionSaveEvents',
			type : 'POST',
			data : event,
			beforeSend : function(){
				that.overlay.show();
			},
			success : function(resp){
				console.log(resp);
				that.switchFromFormToView();
			},
			error : function(resp){
				console.log(resp);
			},
			complete : function(){
				that.overlay.fadeOut();
			}
		});
	},
	eventFullView : function(e){
		e.preventDefault();
		//get the full view of priest
		var id = $(e.target).data('id');
		var that = this;
		$.ajax({
			url : './pageViewEvent',
			type : 'POST',
			data : this.events[id],
			beforeSend : function(){
				
			},
			success : function(resp){
				console.log(resp);
				that.view.hide();
				that.fullView = $(resp);
				that.holder.append(that.fullView);
			},
			error : function(resp){
				console.log(resp);
			},
			complete : function(){
				
			}
		});
	},
	editEvent : function(e){
		var priestId = $(e.target).data('id');
		$.ajax({
			url : './',
			type : 'POST',
			data : this.events[eventId],
			beforeSend : function(){
				
			},
			success : function(){
				
			},
			error : function(){
				
			},
			complete : function(){
				
			}
		});
	},
	deleteEvent : function(e){
		var id = $(e.target).data('id');
		var that = this;
		$.ajax({
			url : './actionDeleteEvent',
			type : 'GET',
			data : {id : this.events[id].id},
			beforeSend : function(){
				
			},
			success : function(resp){
				console.log(resp);
				that.dom[id].container.remove();
				that.events[id] = null;
			},
			error : function(resp){
				console.log(resp);
			},
			complete : function(){
				
			}
		});
	}
};