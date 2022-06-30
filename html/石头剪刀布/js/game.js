 // 石头代表1，剪刀代表2，布代表3 
let rockVal = 1
let scissorsVal = 2
let paperVal =3

// 火代表1，水代表2，草代表3
let fire = 1
let water = 2
let grass = 3

// 用于存储自身的属性
let MyAttribute
// 用于存储敌人的属性
let FoeAttribute
// 用于存储自身的出拳
let MyResult
// 用于存储敌人的出拳
let FoeResult
// 选择关卡
let level 

// 文档加载时调用该函数，开局获取属性
$(function() {
	level = 1
	load_level();
})

// 我方出拳
function rock() {
	$('#icon-a').css({"background":"url(images/rock.png) no-repeat","background-size":"100% 100%"})
	//调用函数让敌方出拳，并存储我方出拳结果
	MyResult = rockVal
	foe_Attacks()
}

function scissors() {
	$('#icon-a').css({"background":"url(images/scissors.png) no-repeat","background-size":"100% 100%"})
	MyResult = scissorsVal
	foe_Attacks()
}

function paper() {
	$('#icon-a').css({"background":"url(images/paper.png) no-repeat","background-size":"100% 100%"})
	MyResult = paperVal
	foe_Attacks()
}


// 更换关卡
function enemy(){
	level = parseInt($("#enemy").val())
}


//敌方出拳
function foe_Attacks(){
	var e = Math.floor(Math.random() * 3) + 1;
	switch(e){
		case rockVal:
			$('#icon-b').css({"background":"url(images/rock.png) no-repeat","background-size":"100% 100%","-webkit-transform":"rotateY(180deg);"})
			break;
		case scissorsVal:
			$('#icon-b').css({"background":"url(images/scissors.png) no-repeat","background-size":"100% 100%","-webkit-transform":"rotateY(180deg);"})
			break;
		case paperVal: 
			$('#icon-b').css({"background":"url(images/paper.png) no-repeat","background-size":"100% 100%","-webkit-transform":"rotateY(180deg);"})
			break;
	}
	ForResult = e
	// 调用函数判断输赢 并将值赋给val
	var val = result()
	if (val != null){
		// 调用函数计算扣血多少
		var blood = Buckle_blood(val)
		
		if (val){
			if ($('.xie2')[0].offsetWidth - blood <= 0){
				$('.xie2')[0].style.width = "0px";
				if(confirm("你赢了要开始下一关吗？")){
					level = level +1
					load_level();
				}
			} 
			$('.xie2')[0].style.width =  parseInt($('.xie2')[0].offsetWidth - blood) + "px"
		}else{
			if ($('.xie1')[0].offsetWidth - blood <= 0){
				$('.xie1')[0].style.width = "0px";
				if(confirm("你输了要重开吗？")){
					level = 1
					load_level();
				}
			} 
			$('.xie1')[0].style.width = parseInt( $('.xie1')[0].offsetWidth - blood) + "px"
		}
		
	}
}

// 判断输赢结果
function result(){
	// 如果出拳相同则跳出
	if(MyResult === ForResult){
		return null;
	}
	// 我方出拳 敌方出布 或者 我方出布 敌方出剪刀 或者 我方出剪刀 敌方出拳 
	// 以上情况判断为我方输，其他为我方赢
	// 赢了返回true，输了返回false
	if(MyResult === rockVal && ForResult === paperVal || 
	MyResult === paperVal && ForResult === scissorsVal ||
	MyResult === scissorsVal && ForResult === rockVal){
		return false;
	}else{
		return true;
	}
}

// 扣血多少
function Buckle_blood(val){
	// 我方属性与敌方属性相同 扣20滴 
	if(MyAttribute === FoeAttribute){
		return 20;
	}
	
	// 我方属性是火 敌方属性是草 或者 我方是草 敌方是水 或者 我方是水 敌方是火 
	// 以上情况判断为我方克制方 如果是我方赢则扣30滴 否则扣20滴
	// 我方被克制方 输则扣30滴 否则扣20滴
	if(MyAttribute === fire && FoeAttribute === grass ||
	MyAttribute === grass && FoeAttribute === water ||
	MyAttribute === water && FoeAttribute === fire){
		return val ? 30 : 20;
	}else{
		return val ? 20 : 30;
	}
}

// 加载关卡
function load_level(){
	console.log(level);
	if(level > 4){
		alert("您通关了！！！")
	}else{
		$('.xie1')[0].style.width = "400px";
		$('.line1')[0].style.width = "400px";
		$("#foeImg")[0].setAttribute("src", "images/foe"+ level +".jpeg");
		$('.xie2')[0].style.width = level * 100 + "px";
		$('.line2')[0].style.width = level * 100 + "px";
		$('#icon-a')[0].style.background = ''
		$('#icon-b')[0].style.background = ''
		load_Attribute();
	}
}

// 加载属性
function load_Attribute(){
	
	// 获取随机属性，并给自身赋值
	var e = Math.floor(Math.random() * 3) + 1;
	switch(e){
		case fire:
			$('#title-a')[0].innerText= "我的出拳(火)"
			break;
		case water:
			$('#title-a')[0].innerText= "我的出拳(水)"
			break;
		case grass: 
			$('#title-a')[0].innerText= "我的出拳(草)"
			break;
	}
	MyAttribute = e
	var t = Math.floor(Math.random() * 3) + 1;
	switch(t){
		case fire:
			$('#title-b')[0].innerText= "对手出拳(火)"
			break;
		case water:
			$('#title-b')[0].innerText= "对手出拳(水)"
			break;
		case grass: 
			$('#title-b')[0].innerText= "对手出拳(草)"
			break;
	}
	FoeAttribute = t
}