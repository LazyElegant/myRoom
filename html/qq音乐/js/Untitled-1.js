onload=haha;
function haha(){
    tab($("mod_index_gd_nav1","mod_index_gd_nav1_nav"),$("show","mod_index_gd_music"));
}
function $(a, b) {
    var ID = document.getElementById(a);
    var OBJ = ID.getElementsByClassName(b);
    return OBJ;
}
var n=0;
function tab(MENU,BODY){
    var l = MENU.length;
    for(var i=0;i<l;i++){
        MENU[i].onmouseover=function(i){
            return function(){
                BODY[n].style.display = "none";
                BODY[i].style.display = "block";
                n=i;
            }
        }(i);
    }
}