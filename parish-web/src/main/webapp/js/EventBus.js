/**
 * Event Bus class which acts as a 
 * 
 */
EventBusClass = function(){
	//holds the listeners
	this.listeners = {};
}

EventBusClass.prototype = {
		//use to hook a custom function to the listener
		listen : function(id, type, callback, scope){
			if(typeof this.listeners[type] != 'undefined'){
				this.listeners[type].push({id:id, type : type, callback : callback, scope : scope});
			}
			else{
				this.listeners[type] = {type : type, callback : callback, scope : scope};
			}
		},
		
		//emits the custom events args - custom array or object as needed by the listener fn
		emit : function(type, event, args){
			if(typeof this.listeners[type] != 'undefined'){
				this.listeners[type].forEach(
						function(observer){
							if(observer != null)
							observer.callback.apply(observer.scope,[event,args]);
						}
					);
			}
		},
		
		remove : function(id, type){
			if(typeof this.listeners[type] != 'undefined'){
				this.listeners[type].forEach(
						function(observer){
							if(observer.id === id){
								observer == null;
							}
						}
					);
			}
		}
};
