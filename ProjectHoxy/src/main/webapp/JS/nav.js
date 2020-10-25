$(document).ready(function() {

	$(".sub_nav").hide();



	
	$('#nav_project').mouseover(function() {
		$(".sub_nav").show(200);

       
    })
    $('.sub_nav').mouseleave(function() {
		$(".sub_nav").hide(200);

       
    })

});