$(document).ready(function(){
	$('.header-search-trigger').click(function(){
		if($('.header-search-wrapper').css('display')=='block'){
			$('.header-search-wrapper').fadeToggle();
		}else{	
			$('.header-search-wrapper').fadeTo('slow',1);
		}
	})
})

let count = 2
$(function(){ 
	setInterval(function(){
		$(".rslides").css("background-image","url(img/slider"+ count+ ".jpg)");
		count = count >= 3 ? 1 : count + 1;
	},3000);

	$(".navbar-toggler").click(function(){
		$("#navbarNav").toggle("collapse")
	})
})