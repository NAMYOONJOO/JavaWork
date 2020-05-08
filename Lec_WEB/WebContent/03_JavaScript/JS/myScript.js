/**
 * TODO
 */


 function light(sw){
     var pic;
     if(sw ==0){
        pic = "https://www.w3schools.com/html/pic_bulboff.gif"
        
    }else{
        pic = "https://www.w3schools.com/html/pic_bulbon.gif"



    }
    //<img> src 값 변경
    document.getElementById('myImage').src = pic;

}