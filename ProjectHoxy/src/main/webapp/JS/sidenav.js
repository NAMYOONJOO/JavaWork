$(document).ready(function() {


	
	$('div[id^="nav_box"]').click(function() {

        var id = $(this).attr('id').split("box")[1];

        $('div[id^="nav_position_"]').removeClass('ID');
        $('#nav_position_'+id).addClass('ID');

        var scrollPosition = $(".ID").offset().top;

        
        $( 'html, body' ).stop().animate( { scrollTop : scrollPosition },300 )
    })

});