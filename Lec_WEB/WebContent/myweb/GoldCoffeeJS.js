$(document).ready(function(){

    $('div#top').on({mouseenter:function(){
        $('div#top').css("background-color","rgba(20,20,20,1)")
    },
    mouseleave:function(){
        $('div#top').css("background-color","rgba( 255, 255, 255, 0.2 )")

    },
    })

    
    function main_content(){
        
        $('div.main_content').fadeOut(0)
        $('div#content1').fadeIn(0)
        $('div#content1').delay(8000).fadeOut(1000)
        $('div#content2').delay(8000).fadeIn(1000).promise()
        .then(function(){
            $('div#content2').delay(8000).fadeOut(1000)
            return $('div#content3').delay(8000).fadeIn(1000).promise()
        })
        .then(function(){
            $('div#content3').delay(8000).fadeOut(1000)
            return $('div#content1').delay(8000).fadeIn(1000).promise()
        })
        .then(main_content)

    }

    main_content()
   


})


