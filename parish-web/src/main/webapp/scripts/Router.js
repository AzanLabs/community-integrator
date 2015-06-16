$.ready(function(){
	//global variable
	EventBus = new EventBusClass();
	
	//function to handle action after setp 1 in first steps form
	function firstStepsChurchSaved(event, arg){
		console.log(event);
		console.log(arg);
		console.log('church saved going to perform ajax actions');
	}
	
	function settingsChurchSaved(event, arg){
		console.log("inside settings church saved");
	}
	EventBus.listen('church-saved', settingsChurchSaved, this);
	EventBus.listen('church-saved',firstStepsChurchSaved, this);
});