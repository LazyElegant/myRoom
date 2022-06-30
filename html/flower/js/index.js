$(function(){
	$(".J_photoImgPanel img").mousemove(function(e){
		$(this).css("margin","0px 0px 0px -10px")
		$(this).css("transition-duration","300ms")
	})
	$(".J_photoImgPanel img").mouseout(function(e){
		$(this).css("transition-duration","300ms")
		$(this).css("margin","0")
	})
})