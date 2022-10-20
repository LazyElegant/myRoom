window.addEventListener('load', ()=>{
    document.addEventListener('click', click);    
    document.addEventListener('mousedown', startdrawormove);
    document.addEventListener('mouseup', stopdrawormove);
    document.addEventListener('mousemove', sketch);
});

var canvas = new fabric.Canvas("canvas");
var isDown, origX, origY;

var colorinput = document.getElementById("favcolor");
var slider = document.getElementById("opacity");
var output_o = document.getElementById("value");
var colorvalue = document.getElementById('colorVal');

output_o.innerHTML = slider.value;
colorvalue.innerHTML = colorinput.value;

var tooltype = "draw";
var shapetype = "circle";
let currentShape = null;
let on = null;

function click(event){ 
  // if users click reset, clear all shapes in the interface (10pts)

	if(tooltype == 'reset'){
		canvas.clear();
	}
}

function startdrawormove(event) {
  isDown = true;
    var pointer = canvas.getPointer(event); // get mouse position
    origX = pointer.x;
    origY = pointer.y;
    if (tooltype=="draw"){
		
		let array = canvas.getObjects();
		for(let i = 0;i < array.length; i++){
			  array[i].set("selectable", false); 
		}
      //Use fabric.Circle/Rect/Triangle to define a circle/rectangle/triangle, respectively. Each shape is for 9pts

		if (shapetype == 'circle'){
			currentShape = new fabric.Circle({
				radius: 0,
				top:origY,
				left:origX,
				fill: colorinput.value
			})
		}else if(shapetype == 'rectangle'){
			currentShape = new fabric.Rect({
				top:origY,
				left:origX,
				fill: colorinput.value
			}); 
		}else if(shapetype == 'triangle'){
			currentShape = new fabric.Triangle({
				angle:60,
				top:origY,
				left:origX,
				width:0,
				fill: colorinput.value
			}); 
		}
		currentShape.set("selectable",false)
	// add the defined shape into canvas (3pts).
		canvas.add(currentShape)
	
	}
    else if (tooltype=="move"){
      // make all shapes selectable (4pts).
		let array = canvas.getObjects();
		for(let i = 0;i < array.length; i++){
			  array[i].set("selectable", true);
		}
    }
    
}

function stopdrawormove(event){
  isDown = false;
}

function sketch(event){
  if (tooltype=="draw"){
	if (!isDown) return;
    var pointer = canvas.getPointer(event); 
    if (shapetype == 'circle'){
      // set the circle radius based on the mouse position (6pts)
		let radius = Math.min(Math.abs(pointer.x - origX), Math.abs(pointer.y - origY))
		let top = pointer.y > origY ? origY : origY - radius * 2
		let left = pointer.x > origX ? origX :  origX - radius * 2

		currentShape.set('radius', radius)
		currentShape.set('top', top)
		currentShape.set('left', left)
		canvas.requestRenderAll()
    }
    else if (shapetype == 'rectangle') {
      // set the width and height of rectangle or triangle based on the mouse position (6pts)
		let left =origX>pointer.x ? Math.abs(pointer.x) :origX;
		let top =origY>pointer.y ? Math.abs(pointer.y) :origY;

		currentShape.set({ width: Math.abs(origX - pointer.x) });
		currentShape.set({ height: Math.abs(origY - pointer.y) });
		currentShape.set('top', top)
		currentShape.set('left', left)
		canvas.requestRenderAll()
	  
    }else if (shapetype == 'triangle') {
      // set the width and height of rectangle or triangle based on the mouse position (6pts)

		currentShape.set('width',  Math.abs(origY - pointer.y) )
		currentShape.set('top', origY)
		currentShape.set('left', origX)
		canvas.requestRenderAll()
	  
    }
    
  }
  else if (tooltype == "move"){
    var pointer = canvas.getPointer(event);

    // move the selected shape  hint: use getActiveObject() function(8pts)
	on = canvas.getActiveObject()
	if(on!= undefined || on != null){
		on.set('top', pointer.y)
		on.set('left', pointer.x)
		canvas.requestRenderAll()
		canvas.on('mouse:down', function(e){
			on = undefined;
		});
	}
  }

  // get all shapes from canvas (6pts) and change the opacity of each shape (6pts)
  let array = canvas.getObjects();
  for(let i = 0;i < array.length; i++){
	  array[i].opacity = slider.value;
  }
}

function select_shape(shape){
  shapetype = shape.value;
}

function use_tool(tool){
  tooltype = tool;
}
function changeShape(value){
	shapetype = value.value;
}

slider.oninput = function() {
  output_o.innerHTML = this.value;
}

colorinput.oninput = function() {
  colorvalue.innerHTML = this.value;
}


