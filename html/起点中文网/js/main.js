/* �����ڹȸ������������ */

//��ȡ��Ԫ�أ��������
var carouselBox;
var inner;
var imagesBox;
var imgList;
var numberBox;
var arrow;
var left;
var right;
var prePic = pic = 0;       //��ǰͼƬ��ţ���Ϊȫ�ֱ���
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
	
	
	
	//�����ֲ�ͼƬ�ĸ������������ֵ���С��ť
	for(var i=0;i<imgList.length;i++){
		var numberNav=document.createElement("li");
		numberBox.appendChild(numberNav);
		numberNav.textContent=(i+1);
		numberNav.setAttribute("index",i);
	
		//Ϊ��ťע�� click �¼�
		numberNav.onclick=function () {
			for (var j=0;j<numberBox.children.length;j++){           //��������а�ť������ʽ
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
	
	numberBox.children[0].className = "current";      //�������ֵ������е�һ�������б�����ɫ������ǰͼƬ��Ӧ�����֣�
	
	timeId=setInterval(onmouseclickHandle,5000);  //��ʼͼƬ�ֲ�����
	
	//�������ͼƬֹͣ�ֲ����Ƴ�ͼƬ�����ֲ�����
	carouselBox.onmouseover=function () {
		arrow.style.display="block";
		clearInterval(timeId);
	};
	carouselBox.onmouseout=function () {
		arrow.style.display="none";
		timeId=setInterval(onmouseclickHandle,5000);
	};
	
	right.onclick=onmouseclickHandle;     //�����Ҽ�ͷִ��һ��ͼƬ��������

	left.onclick=function () {            //�����Ҽ�ͷִ��һ��ͼƬ������� 
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



//���õ���һ��Ԫ��
function fadein(element,element02) {
    clearInterval(element.timeId);    
    element.style.opacity = 0;
    element.style.zIndex = 10;
    element02.style.zIndex = 0;
    element.timeId = setInterval(function () {                     //��ʱ����idֵ�洢�������һ��������
        element.style.opacity = element.style.opacity * 1 + 0.01;  //�����ı仯��Ϊ0.01
        if (element.style.opacity == 1) {
            element02.style.opacity = 0;
            clearInterval(element.timeId);                         //����ʱ��            
        }
    }, 10);
    for (var i = 0; i < numberBox.children.length; i++) {                //ȥ�����е�С��ť�ı�����ɫ
        numberBox.children[i].removeAttribute("class");
    }
    numberBox.children[pic].className = "current";                       //��ǰͼƬ��Ӧ��ť��������ɫ
}


