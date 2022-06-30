$(document).ready(function(){
	$('.header-search-trigger').click(function(){
		if($('.header-search-wrapper').css('display')=='block'){
			$('.header-search-wrapper').fadeToggle();
		}else{	
			$('.header-search-wrapper').fadeTo('slow',1);
		}
	})
	$("#RegistrationPainter").click(function () {
		var r=confirm("申请成为一名画师？");
		if (r) {
			$.post("/registeredPainter")
		}
	})
	$.each($(".menus"),function (index ,e) {

		let number = Math.ceil(Math.random()*5);
		if (number=== 1){
			e.style.backgroundColor = 'rgb(126, 141, 200)';
		}else if(number === 2){
			e.style.backgroundColor = 'rgb(126, 185, 200)';
		}else if(number === 3){
			e.style.backgroundColor = 'rgb(200, 192, 126)';
		}else if(number === 4){
			e.style.backgroundColor = 'rgb(192, 126, 200)';
		}else if(number === 5){
			e.style.backgroundColor = 'rgb(171, 200, 126)';
		}


	})

})
