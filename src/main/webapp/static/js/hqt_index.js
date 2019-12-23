function change(e){	
	console.log(e);
	document.getElementById('mainIframe').src=e;	
}
$("#bd").height($(window).height()-$("#hd").outerHeight()-26);

$(window).resize(function(e) {
    $("#bd").height($(window).height()-$("#hd").outerHeight()-26);
});
(function(){
	var totalWidth = 0, current = 1;	
	$.each($('.nav').find('li'), function(){
		totalWidth += $(this).outerWidth();
		
		$(this).click(function(e) {  			
			$(this).siblings().removeClass("nav_lihover");
			$(this).addClass("nav_lihover");			
		});
	});
	
	$('.nav').width(totalWidth);
	
	function currentLeft(){
		return -(current - 1) * 93;	
	}
	
	$('.nav-btn a').click(function(e) {
		var tempWidth = totalWidth - ( Math.abs($('.nav').css('left').split('p')[0]) + $('.nav-wrap').width() );
        if($(this).hasClass('nav-prev-btn')){
			if( parseInt($('.nav').css('left').split('p')[0])  < 0){
				current--;
				Math.abs($('.nav').css('left').split('p')[0]) > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': 0}, 200);
			}
		}else{
			if(tempWidth  > 0)	{				
			   	current++;
				tempWidth > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': $('.nav').css('left').split('p')[0]-tempWidth}, 200);
			}
		}
    });	
	$.each($('.skin-opt li'),function(index, element){
		if((index + 1) % 3 == 0){
			$(this).addClass('third');	
		}
		$(this).css('background',$(this).attr('attr-color'));
	});
	
	$('.setting-skin').click(function(e) {
        $('.skin-opt').show();
    });
	
	$('.skin-opt').click(function(e) {
        if($(e.target).is('li')){
			alert($(e.target).attr('attr-color'));	
		}
    });
	
	$('.hd-top .user-info .more-info').click(function(e) {
       $(this).toggleClass('active'); 
	   $('.user-opt').toggle();
    });
	
	$('.logo-icon').click(function(e) {
         $(this).toggleClass('active'); 
	     $('.system-switch').toggle();
    });

})();

