/**
 * Priest Modal
 */
'use strict'; //to minimize errors and for debugging purpose  strict mode is used
function Priest(config){
	if(config){
		for(var key in config){
			this[key] = config[key];
		}
	}
}
/**
 * controller which controls the church view, update action in churchpanel of settings module
 * data is loaded as json and views are rendered by sending json data to jsp
 * json data is used as modal to avoid call to avoid db calls for every view and update view calls
 */
function ChurchController(config){
	
	this.holder = $("#church-panel"); //views
	this.fullView = '';  
	this.updateForm = '';
	
	this.church = ''; //modal populated by loadData call
	
	this.overlay = $("#body-overlay");
	this.churchId = config["churchId"]; 
	this.isUpdateFormLoaded = false; // flag used to optimize the load and initialization of update form
}

ChurchController.prototype = {
		/**
		 * init function which is called just after the creation of ChurcH Controller, 
		 * contains all the functions one after another to render the view and make the panel work
		 */
		init : function(){
			$("#update-church-btn").on('click', this.showUpdateForm.bind(this));
			this.loadData();
			if(!this.church){
				return;
			}
			this.loadView();
		},
		/**
		 * loads church json data and populate the modal
		 */
		loadData : function(){
			var that = this;
			$.ajax({
				url : './actionViewChurch',
				method : 'GET',
				async : false,
				data : {"id" : that.churchId},
				success : function(resp){
					console.log(resp.responseText);
					that.church = resp.church;
				},
				error : function(resp){
					console.log(resp);
					responseBox.error(resp);
				}
			});
		},
		/**
		 * loads the initial view using the json data,
		 * the view is constructed by jsp using the data send, thus avoiding dynamic dom creation , manipulation
		 */
		loadView : function(){
			var that = this;
			$.ajax({
				url : './pageViewChurch',
				method : 'POSt',
				data : this.church,
				beforeSend : function(){
					that.overlay.show();
				},
				success : function(resp){ //response will be the html text 
					that.fullView = $(resp);
					that.fullView.hide();
					that.holder.append(that.fullView);
					that.fullView.fadeIn();
				},
				error : function(resp){
					console.log(resp);
					responseBox.error(resp);
				},
				complete : function(){
					that.overlay.hide();
				}
			});
		},
		/**
		 * this method renders the update form
		 */
		showUpdateForm : function(){
			var that = this;
			if(this.isUpdateFormLoaded){
				this.updateForm.show();
				return;
			}
			$.ajax({
				url : './pageUpdateChurch',
				method : 'POST',
				data : this.church,
				success : function(resp){ //responseText will be html text of updateform
					that.updateForm = $(resp);
					//hook the necessary functions needed to handle user action
					that.updateForm.find('.close').on('click', that.switchFromFormToView.bind(that));
					that.updateForm.find('.clear').on('click', that.switchFromFormToView.bind(that));
					that.updateForm.find('#update-church-form').on('submit', that.handleUpdate.bind(that));
					that.holder.append(that.updateForm);
					that.isUpdateFormLoaded = true;
				},
				error : function(resp){
					console.log(resp);
				}
			})
		},
		clearForm : function(){
			this.updateForm.find('input').val('');
			this.updateForm.find('textarea').val('');
		},
		switchFromFormToView : function(e){
			e.preventDefault();
			this.updateForm.fadeOut();
		},
		handleUpdate : function(e){
			e.preventDefault();
			var that = this;
			var data = parish.form.getFormData('update-church-form');
			$.ajax({
				url : './actionUpdateChurch',
				type : 'POST',
				data : data,
				beforeSend : function(){
					that.overlay.show();
				},
				success : function(resp){//on success close the form and update the view, 
					//response will contain html text of view page
					that.fullView.remove();
					that.fullView = $(resp);
					that.holder.append(that.fullView);
					that.updateForm.hide();
					responseBox.success("Updated Successfully");
				},
				error : function(resp){
					console.log(resp);
					responseBox.error(resp);
				},
				complete : function(){
					that.overlay.hide();
				}
			});
		}
};

function PriestController(){
	
	this.priests = [];
	
	this.holder = $('#priest-tiles');
	this.addForm = $('#priest-form');
	this.updateForm = $("#update-priest-form");
	this.fullView = $("#view-priest-container");
	this.view = $('<div></div>');
	this.overlay = $('#body-overlay');
	
	this.updateFormLoaded = false;
	this.viewLoaded = false;
}

PriestController.prototype = {
	
	init : function(){
		
		$("#add-new-priest").on('click', this.showAddForm.bind(this));
		this.addForm.find('.close').on('click', this.closeAddForm.bind(this));
		this.addForm.find('.clear').on('click', this.closeAddForm.bind(this));
		this.addForm.on('submit', this.handleSave.bind(this));
		this.addForm.hide();
		
		this.fullView.find(".close").on('click', this.closeFullView.bind(this));
		this.fullView.hide();
		
		this.updateForm.find(".close").on('click', this.closeUpdateForm.bind(this));
		this.updateForm.find(".clear").on('click', this.closeUpdateForm.bind(this));
		this.updateForm.on('submit', this.handleUpdate.bind(this));
		this.updateForm.hide();
		
		this.loadData();
		this.createDom();
	},
	loadData : function(){
		var that = this;
		$.ajax({
			url : './actionGetAllPriestByChurch',
			type : 'GET',
			async : false,
			beforeSend : function(){
				that.overlay.show();
			},
			success : function(resp){
				console.log(resp);
				that.priests = resp.priests;
			},
			error : function(resp){
				console.log(resp);
				responseBox.error(resp);
			},
			complete : function(){
				that.overlay.hide();
			}
		});
	},
	priestDom : function(key){
		var dom = {};
		dom.container = $("<div id='"+key+"' class='priest'></div>");
		dom.image = $("<img id='image' src= './getPriestProfileImage?imageId="+this.priests[key].image+"' 'alt='priest-image' class='priest-profile-image'></img>");
		dom.name = $("<h4 id='name'>"+ this.priests[key].name+"</h4>");
		dom.container.append(dom.image).append(dom.name);
		
		//controls
		dom.controls = $("<div class='controls text-right'></div>");
		dom.viewBtn = $("<a href='#view'>View</a>").on('click', this.showFullView.bind(this));
		dom.viewBtn.data('id',key);
		dom.editBtn = $("<a href='#edit'>Edit</a>").on('click', this.showUpdateForm.bind(this));
		dom.editBtn.data('id',key);
		dom.deleteBtn = $("<a href='#delete'>Delete</a>").on('click', this.deletePriest.bind(this));
		dom.deleteBtn.data('id',key);
		
		var v = dom.container.append(dom.controls.append(dom.viewBtn).append(dom.editBtn).append(dom.deleteBtn));
		this.view.append(v);
	},
	createDom : function(){
		for(var key in this.priests){
			this.priestDom(key);
		}
		this.holder.append(this.view);
		this.viewLoaded = true;
	},
	showAddForm : function(e){
		e.preventDefault();
		this.addForm.fadeIn();
	},
	showFullView : function(e){
		e.preventDefault();
		//get the respective data
		var id = $(e.target).data('id');
		var currentPriest = this.priests[id];
		//load the respective date to dom
		for(var key in currentPriest){
			var formEle = "#"+key;
			this.fullView.find(formEle).html(currentPriest[key]);
		}
		this.fullView.find("#profile-img").attr("src", "./getPriestProfileImage?imageId="+currentPriest.image);
		//show the full view
		this.fullView.fadeIn();
	},
	showUpdateForm : function(e){
		e.preventDefault();
		//get the respective data
		var id = $(e.target).data('id');
		var currentPriest = this.priests[id];
		//load data into dom
		for(var key in currentPriest){
			var formEle = "#"+key;
			this.updateForm.find(formEle).val(currentPriest[key]);
		}
		this.updateForm.find("#profile-img").attr("src", "./getPriestProfileImage?imageId="+currentPriest.image);
		//show the update form
		this.updateForm.fadeIn();
	},
	clearForm : function(){
		this.addForm.find('input').val('');
		this.addForm.find('textarea').val('');
	},
	closeAddForm : function(e){
		if(e) e.preventDefault();
		this.clearForm();
		this.addForm.fadeOut();
	},
	closeFullView : function(e){
		e.preventDefault();
		this.fullView.fadeOut();
	},
	closeUpdateForm : function(e){
		e.preventDefault();
		this.updateForm.fadeOut();
	},
	
	handleSave : function(e){
		e.preventDefault();
		var data = new FormData(document.getElementById('priest-form'));; 
		var that = this;
		var xhr = new XMLHttpRequest();
		xhr.onReadyStateChange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				console.log(xhr.response);
				debugger;
				that.addForm.hide();
				//add to the dom view
			}else if(xhr.readyState == 4 && xhr.status != 200){
				console.log(xhr.response);
				responseBox.error(resp);
			}
		}
		xhr.open("POST",'./actionSavePriest',true);
		xhr.send(data);
	},
	handleUpdate : function(e){
		e.preventDefault();
		var that = this;
		var data = parish.form.getFormData('update-priest-form'); 
		$.ajax({
			url : './actionUpdatePriest',
			type : 'POST',
			data : data,
			beforeSend : function(){
				that.overlay.show();
			},
			success : function(resp){ //response has the updated json , update the modal and view accordingly
				var priest = resp.priest;
				responseBox.success("Updated Successfully");
				that.priests[priest.id] = priest;
				that.view.find("#"+priest.id).find('#name').html(priest.name);
				that.updateForm.fadeOut();
			},
			error : function(resp){
				console.log(resp);
				responseBox.error(resp);
				
			},
			complete : function(){
				that.overlay.hide();
			}
		});
	},
	deletePriest : function(e){
		e.preventDefault();
		var that = this;
		var confirm = window.confirm("Do u Really Want to Delete?");
		if(!confirm){
			return;
		}
		var priestId = $(e.target).data('id');
		$.ajax({
			url : './actionDeletePriest',
			type : 'GET',
			data : {id : priestId},
			beforeSend : function(){
				that.overlay.show();
			},
			success : function(resp){
				var id = "#"+resp.id;
				that.priests[resp.id] = null;
				that.view.find(id).remove();
				responseBox.success("Deleted Successfully");
			},
			error : function(resp){
				console.log(resp);
				responseBox.error(resp);
			},
			complete : function(){
				that.overlay.hide();
			}
		});
	}
};

function Events(){
	
}

function EventsController(){
	 
	this.events = []; //modal , which will be populated by load data call
	
	this.addForm = $('#event-form'); //views
	this.updateForm = $("#event-update-form");
	this.fullView = $("#event-full-view");
	this.thumbView = $('<div></div>');
	
	this.holder = $('#events-tiles');
	this.overlay = $('#body-overlay');
	this.responseBox = $("#response-box");
}

EventsController.prototype = {
	/**
	 * init function which must be called to bootstrap all needed dependencies for the panel to work
	 */
	init : function(){
		//load the data
		$("#add-new-event").on('click', this.showAddForm.bind(this));
		this.addForm.find('.close').on('click', this.closeAddForm.bind(this));
		this.addForm.find('.clear').on('click', this.closeAddForm.bind(this));
		this.addForm.on('submit', this.handleSave.bind(this));
		this.addForm.hide();
		
		this.fullView.find(".close").on('click', this.closeFullView.bind(this));
		this.fullView.hide();
		
		this.updateForm.find(".close").on('click', this.closeUpdateForm.bind(this));
		this.updateForm.find(".clear").on('click', this.closeUpdateForm.bind(this));
		this.updateForm.on('submit', this.handleUpdate.bind(this));
		this.updateForm.hide();
		//this.events = events;
		this.loadData();
		this.createDom();
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
				responseBox.error(resp);
			},
			complete : function(){
				that.overlay.fadeOut();
			}
		});
	},
	eventDom : function(key){
		var dom = {};
		dom.container = $("<div id='"+key+"' class='event'></div>");
		dom.image = $("<img id='image' src='http://img.jgi.doe.gov/images/img-user-forum.png' alt='event-image'></img>");
		dom.name = $("<h4 id='name'>"+this.events[key].name+"</h4>");
		dom.container.append(dom.image).append(dom.name);
		
		//controls
		dom.controls = $("<div class='controls text-right'></div>");
		dom.viewBtn = $("<a href='#view'>View</a>").on('click', this.showFullView.bind(this));
		dom.viewBtn.data('id',key);
		dom.editBtn = $("<a href='#edit'>Edit</a>").on('click', this.showUpdateForm.bind(this));
		dom.editBtn.data('id',key);
		dom.deleteBtn = $("<a href='#delete' class='glyphicon glyphicon-trash'>Delete</a>").on('click', this.deleteEvent.bind(this));
		dom.deleteBtn.data('id',key);
		var v = dom.container.append(dom.controls.append(dom.viewBtn).append(dom.editBtn).append(dom.deleteBtn));
		this.thumbView.append(v);
	},
	createDom : function(){
		for(var key in this.events){
			this.eventDom(key);
		}
		this.holder.append(this.thumbView);
	},
	showAddForm : function(e){
		e.preventDefault();
		this.addForm.fadeIn();
	},
	showFullView : function(e){
		e.preventDefault();
		//get the respective data
		var id = $(e.target).data('id');
		var currentEvent = this.events[id];
		//load the respective date to dom
		for(var key in currentEvent){
			var formEle = "#"+key;
			this.fullView.find(formEle).html(currentEvent[key]);
		}
		//show the full view
		this.fullView.fadeIn();
	},
	showUpdateForm : function(e){
		e.preventDefault();
		//get the respective data
		var id = $(e.target).data('id');
		var currentEvent = this.events[id];
		//load data into dom
		for(var key in currentEvent){
			var formEle = "#"+key;
			this.updateForm.find(formEle).val(currentEvent[key]);
		}
		//show the update form
		this.updateForm.fadeIn();
	},
	clearForm : function(){
		this.addForm.find('input').val('');
		this.addForm.find('textarea').val('');
	},
	closeAddForm : function(e){
		if(e) e.preventDefault();
		this.clearForm();
		this.addForm.fadeOut();
	},
	closeFullView : function(e){
		e.preventDefault();
		this.fullView.fadeOut();
	},
	closeUpdateForm : function(e){
		e.preventDefault();
		this.updateForm.fadeOut();
	},
	/**
	 * saves the church event
	 * @param e
	 */
	handleSave : function(e){
		e.preventDefault(); //prevent the default event
		var that = this;
		var event = parish.form.getFormData('event-form'); //get the submitted data
		$.ajax({
			url : './actionSaveEvents',
			type : 'POST',
			data : event,
			beforeSend : function(){
				that.overlay.show();
			},
			success : function(resp){ //response will have the json object of new event, 
				//create a new view from the event data add it to the view and hide the form
				console.log(resp.event);
				var event = resp.event;
				responseBox.success(event.name+"Event Created Successfully");
				that.events[event.id] = event;
				that.eventDom(event.id);
				that.closeAddForm();
			},
			error : function(resp){
				console.log(resp);
				responseBox.error(resp);
			},
			complete : function(){
				that.overlay.fadeOut();
			}
		});
	},
	handleUpdate : function(e){
		e.preventDefault();
		var key = $(e.target).data('id');
		var that = this;
		var data = parish.form.getFormData('event-update-form'); 
		$.ajax({
			url : './actionUpdateEvent',
			type : 'POST',
			data : data,
			beforeSend : function(){
				that.overlay.show();
			},
			success : function(resp){//response contains json of updated event, update the data and view accordingly
				console.log(resp.event);
				responseBox.success("Events Updated SuccessFully");
				var event = resp.event;
				that.events[event.id] = event; //update the modal
				that.thumbView.find('#'+event.id).find("#name").html(event.name); //update the view
				that.updateForm.fadeOut();
			},
			error : function(resp){
				console.log(resp);
				responseBox.error(resp);
			},
			complete : function(){
				that.overlay.hide();
			}
		});
	},
	deleteEvent : function(e){
		var id = $(e.target).data('id');
		var that = this;
		var confirm = window.confirm("Do u Really Want to Delete?");
		if(!confirm){
			return;
		}
		$.ajax({
			url : './actionDeleteEvent',
			type : 'GET',
			data : {id : id},
			beforeSend : function(){
				that.overlay.show();
			},
			success : function(resp){ //response contains the id of deleted event
				var id = "#"+resp.id;
				that.events[resp.id] = null;
				that.thumbView.find(id).remove();
				responseBox.success("Event Deleted Successfully");
			},
			error : function(resp){
				console.log(resp);
				responseBox.error(resp);
			},
			complete : function(){
				that.overlay.hide();
			}
		});
	}
};
