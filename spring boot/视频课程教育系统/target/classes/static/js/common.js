$(document).ready(function(){
	var test1 = setTimeout(function(){
		alert("该开始学习了！！");
		},600000);
})
$(document).ready(function(){
	$('.header-search-trigger').click(function(){
		if($('.header-search-wrapper').css('display')=='block'){
			$('.header-search-wrapper').fadeToggle();
		}else{
			$('.header-search-wrapper').fadeTo('slow',1);
		}
	})
})
