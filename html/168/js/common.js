let count = 0
$(document).ready(function(){
	$('.qrindex').mouseover(function(){
		$('.indexqrcode').removeClass('uhide')
	})
	$('.qrindex').mouseout(function(){
		$('.indexqrcode').addClass('uhide')
	})
	
	$(".goods_classification").mouseover(function(){
		$("#big_type_view").css('display','block')
	})
	$(".bigtitleSelect").mouseover(function(){
		$(".selections[data-child-select = '42']").css('display','block')
	})
	$(".goods_classification").mouseleave(function(){
		$("#big_type_view").css('display','none')
		$(".selections[data-child-select]").css('display','none')
	})
	
	$(".swiper-button-next").click(function(){
		if($("#command_view").css("transform") == "matrix(1, 0, 0, 1, -1180, 0)"){
			$("#command_view").css("transform","translate3d(30px, 0px, 0px)")
			$("#command_view").css("transition-duration","300ms")
		}else{
			$("#command_view").css("transform","translate3d(-1180px, 0px, 0px)")
		}
	})
	
	
	$(".swiper-button-prev").click(function(){
		if($("#command_view").css("transform") == "matrix(1, 0, 0, 1, -1180, 0)"){
			$("#command_view").css("transform","translate3d(30px, 0px, 0px)")
			$("#command_view").css("transition-duration","300ms")
		}else{
			$("#command_view").css("transform","translate3d(-1180px, 0px, 0px)")
		}
	})
	//监听页面滚动事件
	window.onscroll = function(e){
		scrollFunc();
		if(scrollDirection == 'down'){
			if(document.documentElement.scrollTop>80){
				$(".pageHead_2_wrapper").css("display","block")
				$(".pageHead_2_wrapper").css("transition-duration","300ms")
				$(".pageHead_2_wrapper").css("top","0px")
			}
		}
		else if(scrollDirection == 'up'){
			//页面向上滚动要做的事情
			if(document.documentElement.scrollTop<80){
				$(".pageHead_2_wrapper").css("display","block")
				$(".pageHead_2_wrapper").css("top","-80px")
				$(".pageHead_2_wrapper").css("transition-duration","300ms")
			}
		}
	}
	
	var scrollAction = {x: 'undefined', y: 'undefined'}, scrollDirection;
	function scrollFunc() {
	    if (typeof scrollAction.x == 'undefined') {
	        scrollAction.x = window.pageXOffset;
	        scrollAction.y = window.pageYOffset;
	    }
	    var diffX = scrollAction.x - window.pageXOffset;
	    var diffY = scrollAction.y - window.pageYOffset;
	    if (diffX < 0) {
	        // Scroll right
	        scrollDirection = 'right';
	    } else if (diffX > 0) {
	        // Scroll left
	        scrollDirection = 'left';
	    } else if (diffY < 0) {
	        // Scroll down
	        scrollDirection = 'down';
	    } else if (diffY > 0) {
	        // Scroll up
	        scrollDirection = 'up';
	    } else {
	        // First scroll event
	    }
	    scrollAction.x = window.pageXOffset;
	    scrollAction.y = window.pageYOffset;
	}
	
	$("#login").click(function(){
		document.getElementById('light').style.display='block';
		document.getElementById('fade').style.display='block';
		document.getElementById('close').style.display=	'block';
	})
	$("#close").click(function(){
		document.getElementById('light').style.display='none';
		document.getElementById('fade').style.display='none';
		document.getElementById('close').style.display=	'none';
		document.getElementById('re').style.display='none';
		document.getElementById('phoneLight').style.display='none';
	})
	
	$("#phoneLogin").click(function(){
		document.getElementById('light').style.display='none';
		document.getElementById('phoneLight').style.display='block';
	})
	
	$("#numberLogin").click(function(){
		document.getElementById('phoneLight').style.display='none';
		document.getElementById('light').style.display='block';
	})
	
	$("#regiest").click(function(){
		document.getElementById('light').style.display='none';
		document.getElementById('re').style.display='block';
	})
	$("#toLogin").click(function(){
		document.getElementById('light').style.display='block';
		document.getElementById('re').style.display='none';
		
	})
	$("#register").click(function(){
		document.getElementById('re').style.display='block';
		document.getElementById('fade').style.display='block';
		document.getElementById('close').style.display=	'block';
		
	})
	$("#top").click(function(){
		$("html,body").animate({scrollTop:0},500);
	})
	$("#phone").mouseover(function(){
		$("#supplieroutbox").css("display","block")
	})
	$("#phone").mouseout(function(){
		$("#supplieroutbox").css("display","none")
	})
	$("#goodsinfo").mouseout(function(){
			$(".float_layer").css("display", "none")
			$(".big_box").css("display", "none")
	})
	$(".swiper-container .swiper-wrapper .swiper-slide").mouseover(function(eve){
		$(".swiper-slide").each((item,value)=>{
			value.classList.remove("detailpicchoose");
		});
		eve.currentTarget.classList.add("detailpicchoose")
		$("#box").attr("src",eve.currentTarget.childNodes[1].src);
		$(".mainpic").attr("src",eve.currentTarget.childNodes[1].src);
	})
})