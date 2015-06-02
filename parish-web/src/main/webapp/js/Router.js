$.ready(function(){
	//global variable
	EventBus = new EventBusClass();
	
	//function to handle action after setp 1 in first steps form
	function firstStepsChurchSaved(event, arg){
		console.log(event);
		console.log(arg);
		console.log('church saved going to perform ajax actions');
	}
	
	EventBus.listen('firststeps-church-saved',firstStepsChurchSaved, this);
});