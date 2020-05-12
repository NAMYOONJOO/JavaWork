$(document).ready(function(){

$('div#top').on({mouseenter:function(){
    $('div#top').css("background-color","rgb(48,21,0)")
},
mouseleave:function(){
    $('div#top').css("background-color","rgba( 255, 255, 255, 0.1 )")
    $('div#top').css("color","rgb(255,220,115)")

},
})

})