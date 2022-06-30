var carouselBox = document.getElementById("carousel-box");
var inner = carouselBox.children[0];
var imagesBox = inner.children[0];
var imgList = imagesBox.children;
var numberBox = inner.children[1];
var imgWidth = inner.offsetWidth;
var arrow = document.getElementById("arrow");
var left = document.getElementById("left");
var right = document.getElementById("right");
var pic = 0;      

for(var i=0;i<imgList.length;i++){
    var numberNav=document.createElement("li");
    numberBox.appendChild(numberNav);
    numberNav.textContent=(i+1);
    numberNav.setAttribute("index",i);

    numberNav.onclick=function () {
        for (var j=0;j<numberBox.children.length;j++){
            numberBox.children[j].removeAttribute("class");
        }
        this.className="current";
        pic=this.getAttribute("index");
        animate(imagesBox,-pic*imgWidth);
    }
}

numberBox.children[0].className = "current";

imagesBox.appendChild(imagesBox.children[0].cloneNode(true));

var timeId=setInterval(onmouseclickHandle,3000);

carouselBox.onmouseover=function () {
    arrow.style.display="block";
    clearInterval(timeId);
};
carouselBox.onmouseout=function () {
    arrow.style.display="none";
    timeId=setInterval(onmouseclickHandle,3000);
};

right.onclick=onmouseclickHandle;

function onmouseclickHandle() {

    if (pic == imgList.length - 2) {        
        pic = 0;
		animate(imagesBox, -pic * imgWidth);
    }else{
		pic++;  
		animate(imagesBox, -pic * imgWidth);
	} 

    if (pic == imgList.length - 1) {        
        numberBox.children[numberBox.children.length - 1].className = "";     
        numberBox.children[0].className = "current";
    } else {        
        for (var i = 0; i < numberBox.children.length; i++) {
            numberBox.children[i].removeAttribute("class");
        }
        numberBox.children[pic].className = "current";
    }
}

left.onclick=function () {
    if (pic==0){
        pic=imgList.length-2;
        imagesBox.style.left=-pic*imgWidth+"px";
		animate(imagesBox,-pic*imgWidth);
    }else{
		pic--;
		animate(imagesBox,-pic*imgWidth);
	}
    for (var i = 0; i < numberBox.children.length; i++) {
        numberBox.children[i].removeAttribute("class");
    }    
    numberBox.children[pic].className = "current";
};

function animate(element, target) {
    clearInterval(element.timeId);
    element.timeId = setInterval(function () {        
        var current = element.offsetLeft;
        var step = 10;
        step = current < target ? step : -step;        
        current += step;
        if (Math.abs(current - target) > Math.abs(step)) {
            element.style.left = current + "px";
        } else {            
            clearInterval(element.timeId);           
            element.style.left = target + "px";
        }
    }, 10);
}

