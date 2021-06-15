$(document).ready(function(){
    
    
    //Main home contact form submit
    $('#maincontactformsubmit').click(function(e) {
        e.preventDefault(); // prevent the link's default behaviour
        $('#maincontactformsubmit').off('click');
        
        //Check email validity:
        if($('#email')[0].checkValidity()){
            $.post('enviamensaje.php', $("#homecontactform").serialize(), function(data) {
                if(data == 'chido'){
                    $('#maincontactformsubmit').off('click');
                    $('#contactosuccess').html('<br>Hemos recibido su mensaje. Nos pondremos en contacto a la brevedad.');
                    $('#maincontactformsubmit').css('background-color', 'rgba(76, 76, 76, 0.31');
                    $('#maincontactformsubmit').css('color', 'rgba(255, 255, 255, 0.36');
                }
                else{
                    $('#contactoerror').html('<br>Ocurrió un error al enviar su mensaje, favor de intentar nuevamente.');
                    $('#maincontactformsubmit').on('click');
                }
            });
        }
        else{
            $('#contactoerror').html('<br>Favor de ingresar un correo electrónico válido.');
        }
    });
    
    // LOADING IMAGES
    
    /*
    $body = $('body');
    $window = $(window);
    $main = $('main');
    
    //FadeIn all sections   
	$body.imagesLoaded( function() {
		setTimeout(function() {
		      // Fade in sections
			  $body.removeClass('loading').addClass('loaded');
			  
		}, 800);
	});
    */
    
    //FANCYBOX
    //$("a.iframe").fancybox();
    
    $(".fancybox_iframe").fancybox({
			openEffect  : 'none',
			closeEffect : 'none',
			'width' : 540,
			'height' : 360,
            autoSize: false,
			helpers : {
				media : {},
				overlay : {
					css : {
						'background' : 'rgba(0, 0, 0, 0.7)'
					}
				}
			}
		});
    
    
    $("a.iframe").css('padding', '20px');
    
    
    
    
    
    //Main header carrusel
    $(".header_carrusel").owlCarousel({

          navigation : true, // Show next and prev buttons
          slideSpeed : 3000,
          pagination : false,
          navigation: false,
          singleItem:true,
          autoPlay:true,
          transitionStyle : "fadeUp"

          // "singleItem:true" is a shortcut for:
          // items : 1, 
          // itemsDesktop : false,
          // itemsDesktopSmall : false,
          // itemsTablet: false,
          // itemsMobile : false

      });
    
    $(".header_carrusel_oneitem").owlCarousel({

          navigation : true, // Show next and prev buttons
          slideSpeed : 3000,
          pagination : false,
          navigation: false,
          singleItem:true,
          autoPlay:false,
          transitionStyle : "fadeUp"

          // "singleItem:true" is a shortcut for:
          // items : 1, 
          // itemsDesktop : false,
          // itemsDesktopSmall : false,
          // itemsTablet: false,
          // itemsMobile : false

      });
    
    
    
    var s = skrollr.init({
        forceHeight: false
    });
    
    
    // Expand quienes somos in home page
    
    $('#conozcamas_home').click(function() {
        var alto = $('#section_grain02_wrapper').height();
        if (alto == 455){
            alto = 800;
        }
        else{
            alto = 455;
        }
        $('#section_grain02_wrapper').animate({
          height: alto + "px"
        }, 400);
        return false;
    });
    
    // Scroll to contact section on home page
    
    $("#contacto_link_home").click(function() {
        $('html, body').animate({
            scrollTop: $("#contact_home").offset().top
        }, 200);
    });
    
    // Scroll to services section on home page
    
    $("#servicios_link_home").click(function() {
        $('html, body').animate({
            scrollTop: $("#servicios_home").offset().top
        }, 200);
    });
    
    
    /*
    
    //Submenu slide
    
        function addMega(){
      //$(this).addClass("hovering");
            $('#submenu').slideToggle(200);
      }

    function removeMega(){
      $('#submenu').slideToggle(200);
      }

        var megaConfig = {    
         interval: 60,
         sensitivity: 4,
            over: addMega,
            timeout: 200,
         out: removeMega
         };

        $("li.mega").hoverIntent(megaConfig)
        
        */
    
    
    //Scroll to animate:
    
    function goToByScroll(id){
          // Reove "link" from the ID
        id = id.replace("link", "");
          // Scroll
        $('html,body').animate({
            scrollTop: $("#"+id).offset().top - 66},
            'fast');
    }

    $(".scrollto").click(function(e) { 
          // Prevent a page reload when a link is pressed
        e.preventDefault(); 
          // Call the scroll function
        goToByScroll($(this).attr("id"));           
    });
    
    
    
});