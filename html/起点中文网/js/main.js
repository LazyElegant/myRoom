/* 建议在谷歌浏览器下运行 */

//获取各元素，方便操作
var carouselBox;
var inner;
var imagesBox;
var imgList;
var numberBox;
var arrow;
var left;
var right;
var prePic = pic = 0;       //当前图片序号，其为全局变量
var timeId;

var index = 0;
onload = function(){
	var list = document.getElementsByClassName("slide-li");
	for(let i = 0;i < list.length;i++){
		list[i].style.width = window.screen.width-30 + "px";
		list[i].style.left ="-"+ (window.screen.width-30)*i + "px";
		list[i].style.transform = "translate("+(window.screen.width-30)+"px, 0px) translateZ(0px)";
		list[i].style.zIndex = '1';
	}
	list[0].style.transform = "translate(0px, 0px) translateZ(0px)";
	var time = setInterval(lunbo, 5000);
	
	carouselBox = document.getElementById("c2");
	inner = carouselBox.children[0];
	imagesBox = inner.children[0];
	imgList = imagesBox.children;
	numberBox = inner.children[1];
	arrow = document.getElementById("arrow");
	left = document.getElementById("left");
	right = document.getElementById("right");
	
	
	
	//根据轮播图片的个数，创建数字导航小按钮
	for(var i=0;i<imgList.length;i++){
		var numberNav=document.createElement("li");
		numberBox.appendChild(numberNav);
		numberNav.textContent=(i+1);
		numberNav.setAttribute("index",i);
	
		//为按钮注册 click 事件
		numberNav.onclick=function () {
			for (var j=0;j<numberBox.children.length;j++){           //先清除所有按钮的类样式
				numberBox.children[j].removeAttribute("class");
			}
			this.className="current";
			pic=this.getAttribute("index");
			for(i=0; i < imgList.length; i++){
				if(imgList[i].style.zIndex == 10){
					prePic = i;
				}
			}        
			if(pic != prePic){
				fadein(imgList[pic],imgList[prePic]);
			}              
		}
	}
	
	numberBox.children[0].className = "current";      //设置数字导航条中第一个数字有背景颜色（即当前图片对应的数字）
	
	timeId=setInterval(onmouseclickHandle,5000);  //开始图片轮播功能
	
	//鼠标移入图片停止轮播，移出图片继续轮播功能
	carouselBox.onmouseover=function () {
		arrow.style.display="block";
		clearInterval(timeId);
	};
	carouselBox.onmouseout=function () {
		arrow.style.display="none";
		timeId=setInterval(onmouseclickHandle,5000);
	};
	
	right.onclick=onmouseclickHandle;     //单击右箭头执行一次图片淡出操作

	left.onclick=function () {            //单击右箭头执行一次图片淡入操作 
		prePic = pic;
		if (pic == 0) {        
			pic = imgList.length - 1;
		}else{
			pic--; 
		}
		fadein(imgList[pic],imgList[prePic]);
	};
}

function lunbo(){
	var list = document.getElementsByClassName("slide-li");
	var dot = document.getElementsByClassName("slide-dot");
	list[index].style.transform = "translate(-"+(window.screen.width)+"px, 0px) translateZ(0px)";
	dot[index].classList.remove("active")
	index ++ ;
	if(index===4){
		index = 0;
	}
	list[index].style.zIndex = "1"
	list[index].style.transform = "translate(0px, 0px) translateZ(0px)";
	dot[index].classList.add("active")
	if(index===3){
		list[0].style.zIndex = "0"
		list[0].style.transform = "translate("+(window.screen.width-24)+"px, 0px) translateZ(0px)";
	}else{
		list[index+1].style.zIndex = "0"
		list[index+1].style.transform = "translate("+(window.screen.width-24)+"px, 0px) translateZ(0px)";	
	}
	
}
 



function onmouseclickHandle() {
    prePic = pic;
    if (pic == imgList.length - 1) {        
        pic = 0;
    }else{
        pic++; 
    }    
    fadein(imgList[pic],imgList[prePic]);  
}



//设置淡入一个元素
function fadein(element,element02) {
    clearInterval(element.timeId);    
    element.style.opacity = 0;
    element.style.zIndex = 10;
    element02.style.zIndex = 0;
    element.timeId = setInterval(function () {                     //定时器的id值存储到对象的一个属性中
        element.style.opacity = element.style.opacity * 1 + 0.01;  //淡出的变化量为0.01
        if (element.style.opacity == 1) {
            element02.style.opacity = 0;
            clearInterval(element.timeId);                         //清理定时器            
        }
    }, 10);
    for (var i = 0; i < numberBox.children.length; i++) {                //去掉所有的小按钮的背景颜色
        numberBox.children[i].removeAttribute("class");
    }
    numberBox.children[pic].className = "current";                       //当前图片对应按钮设置上颜色
}


