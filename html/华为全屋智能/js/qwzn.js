function myOnscroll(){
			
			
	if(document.documentElement.scrollTop<250){
		document.getElementById('productnav').classList.remove('js-fixed-position');
	}else{
		document.getElementById('productnav').classList.add('js-fixed-position');
	}
	
}
function ts(){
	document.getElementById('btn').classList.remove('miss');
}
function out(){
	document.getElementById('btn').classList.add('miss');
}

function left(){
		document.getElementById('recommendList').classList.remove('recommend-list-k');
	$('#recommendList').css('margin-left','34%');
	
}

function right(){
	document.getElementById('recommendList').classList.remove('recommend-list-k');
	$('#recommendList').css('margin-left','-34%');
	
}
window.addEventListener('transitionend', this.callbackTransitionend)
function callbackTransitionend(e) {
 	if (e.srcElement.className === 'recommend-list-list' && e.srcElement.style.marginLeft == "34%"){
		var cp_html = $("#recommendList ul li").last();
		$(cp_html).prependTo("#recommendList ul");
		document.getElementById('recommendList').classList.add('recommend-list-k');
		document.getElementById('recommendList').style.marginLeft = "0%";
	}
 	if (e.srcElement.className === 'recommend-list-list' && e.srcElement.style.marginLeft == "-34%"){
		var cp_html = $("#recommendList ul li").first();
		$(cp_html).appendTo("#recommendList ul");
		document.getElementById('recommendList').classList.add('recommend-list-k');
		document.getElementById('recommendList').style.marginLeft = "0%";
	}
}