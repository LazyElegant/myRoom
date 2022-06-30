let count = 2
$(function(){ 
	setInterval(function(){
		$(".rslides").css("background-image","url(img/slider"+ count+ ".jpg)");
		count = count >= 3 ? 1 : count + 1;
	},3000);
})