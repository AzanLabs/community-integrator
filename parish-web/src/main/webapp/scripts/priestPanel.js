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

function PriestController(){
	
	this.priests = []; //modal
	this.view = $('priest-tiles'); //view
	this.priestPanel = $('priest-panel'); //holder to show the overlay
	this.overlay = $('priest-panel-overlay');
}

PriestController.prototype = {
		
		init : function(){
			
		},
		
		showOverlay : function(content){
			if(content){
				this.overlay.text(content);
			}
			this.overlay.fadeIn();
		},
		
		hideOverlay : function(){
			this.overlay.fadeOut();
		},
		
		loadAllPriestsData : function(churchId){
			var that = this;
			$.ajax({
				url : '.',
				type : 'GET',
				data : churchId,
				beforeSend : function(){
					that.showOverlay("loading");
				},
				success : function(resp){
					that.priests = resp;
					that.renderPriestPanel();
				},
				error : function(){
					
				},
				complete : function(){
					that.hideOverlay();
				}
			});
		},
		
		renderPriestPanel : function(){
			if(this.priests){
				return;
			}
			var priestView = "<div></div>"
		}
		
}