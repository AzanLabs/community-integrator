
$(document).ready(function(){
	var moduleId = '#edit-church';
	var t = new Tab();
	t.init(moduleId);
	p = new Panels();
	p.init(moduleId);
});
/**
 * tab panel which handles the ssitching of tab 
 * TODO : need to add tab spcific navigation
 */
function Tab(config){
    this.activeTab = '';
    this.activeLink = '';
}

Tab.prototype = {
  
    init : function(moduleId){
      this.setActive(moduleId);
      var navLinks = $('.nav-links');
      this.activeLink = $('.nav-links.active');
      this.activeTab = $(this.activeLink.attr('href'));
      this.activeTab.fadeIn();
      navLinks.on('click', this.handleClick.bind(this));
    },
    
    setActive : function(moduleId){
    	switch(moduleId){
    	case '#edit-church' : $($('.nav-links')[0]).addClass('active');
    							break;
    							
    	case '#edit-priest' : $($('.nav-links')[1]).addClass('active');
    							break;
    	
    	case '#edit-events' : $($('.nav-links')[2]).addClass('active');
    							break;
    	}
    },
    switchTab : function(tabId){
        this.activeTab.hide();
        this.activeTab.removeClass('active');  
        this.activeTab = $(tabId);
        this.activeTab.fadeIn();
    },
    
    handleClick : function(event){
      event.preventDefault();
      var target = $(event.target);
      var tabId = target.attr('href');
      if(tabId === this.activeLink.attr('href')){
        return; 
      }
      this.activeLink.removeClass('active');
      this.activeLink = target;
      this.activeLink.addClass('active');
      this.switchTab(tabId);
      p.load(tabId);
    }
};

function Panels(){
	
	this.isChurchpanelLoaded = false;
	this.isPriestPanelLoaded = false;
	this.isEventsPanelLoaded = false;
	this.currentModule = '';
}

Panels.prototype = {
		
		init : function(moduleId){
			$(moduleId).addClass('active');
			this.load(moduleId);
			this.currentModule = moduleId;
		},
		
		load : function(moduleId){
			if(this.currentModule === moduleId){
				return;
			}
			switch(moduleId) {
				
			case '#edit-church' : this.loadChurchPanel(moduleId);
									break;
									
			case '#edit-priest' : this.loadPriestPanel(moduleId);
									break;
									
			case '#edit-events' : this.loadEventsPanel(moduleId);
									break;
			}
		},
		
		loadChurchPanel : function(moduleId){
			if(!this.isChurchPanelLoaded){
				var that = this;
				$.ajax({
					url : './pageChurchForm',
					type : 'GET',
					success : function(resp){
						$(moduleId).append(resp);
						that.isChurchPanelLoaded = true;
					},
					error : function(resp){
						console.log(resp);
					}
				});
			}
		},
		
		loadPriestPanel : function(moduleId){
			if(!this.isPriestPanelLoaded){
				var that = this;
				$.ajax({
					url : './pagePriestPanel',
					type :'GET',
					success : function(resp){
						$(moduleId).append(resp);
						that.isPriestPanelLoaded = true;
					}
				})
			}
		},
		
		loadEventsPanel : function(moduleId){
			
		}
};
