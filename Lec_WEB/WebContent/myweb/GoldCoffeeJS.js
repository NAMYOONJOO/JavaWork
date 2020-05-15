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

    //Page2
    
    //order 팝업
    var modal = document.getElementById('orderpopup1')
    var btn = document.getElementById('orderbtn1')
    var modal2 = document.getElementById('orderpopup2')
    var orderbtn = document.getElementById('orderbtn')
    var span = document.getElementsByClassName('close')[0]

    btn.onclick = function(){
        modal.style.display = "block"
    }
    orderbtn.onclick = function(){
        modal2.style.display = "block"
        modal.style.display = "none"
    }

    span.onclick = function(){
        modal.style.display='none'
      }
      // 팝업창 바깥을 클릭해도 팝업이 닫히게 하기 (modal)<--->(반대 : modeless)
      window.onclick = function(event){
        if(event.target==modal){
          modal.style.display = 'none'
        }
      
      }
      //order popup menubar---------------------------------------------------
      
      var menu1 = document.getElementById('Omenu1') 
      var menu2 = document.getElementById('Omenu2') 
      var menu3 = document.getElementById('Omenu3')
      var menubtn1 = document.getElementById('menu1') 
      var menubtn2 = document.getElementById('menu2') 
      var menubtn3 = document.getElementById('menu3')
      menubtn1.onclick = function(){
            menubtn1.style.backgroundColor='rgb(236,150,120)'
            menubtn1.style.color='#fff'
            menubtn2.style.backgroundColor='#eee'
            menubtn2.style.color='#444'
            menubtn3.style.backgroundColor='#eee'
            menubtn3.style.color='#444'

            menu1.style.display = 'block'
            menu2.style.display = 'none'
            menu3.style.display = 'none'
        }
    menubtn2.onclick = function(){
            menubtn2.style.backgroundColor='rgb(236,150,120)'
            menubtn2.style.color='#fff'
            menubtn1.style.backgroundColor='#eee'
            menubtn1.style.color='#444'
            menubtn3.style.backgroundColor='#eee'
            menubtn3.style.color='#444'

            menu1.style.display = 'none'
            menu2.style.display = 'block'
            menu3.style.display = 'none'
    }
    menubtn3.onclick = function(){
            menubtn3.style.backgroundColor='rgb(236,150,120)'
            menubtn3.style.color='#fff'
            menubtn2.style.backgroundColor='#eee'
            menubtn2.style.color='#444'
            menubtn1.style.backgroundColor='#eee'
            menubtn1.style.color='#444'
            menu1.style.display = 'none'
            menu2.style.display = 'none'
            menu3.style.display = 'block'
    }
    //order list
    var orderlist= "";
    var price = 0;
    var menucount =0;
    var ordermenu = document.getElementsByClassName('ordermenu')
    // alert($('#menu3-1').text())
    for(i = 0;i<ordermenu.length;i++){
        ordermenu[i].addEventListener('click',addmenulist)

    }
    function addmenulist(){
        orderlist+=$(this).text()+"<br>"
        menucount++;
        price += $(this).val()
        $('#orderlist').html(orderlist)
        $('#orderprice').text("총 "+menucount+"잔 "+price+" 원 ")
    }
    // $('#orderlist').text($('#menu3-1').text())
   



    
   
})
var didScroll;

$(window).scroll(function(event){ didScroll = true; });
setInterval(function() { if (didScroll) { hasScrolled(); didScroll = false; } }, 250);

function hasScrolled() {
    $('div#top').css("background-color","rgba(20,20,20,1)")
   
}