$.ready(function(){
	settings.init();
});

var settings = {
		init : function(){
			$('.settings-right-panel > div').hide();
			$('.settings-right-panel > div.active').fadeIn();
		}
};