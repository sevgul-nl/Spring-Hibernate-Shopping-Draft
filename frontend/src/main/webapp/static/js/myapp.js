
$(function(){
	
	switch(menu){
		case 'Products':
		  $('#products').addClass('active');
		  break;	
		case 'About':
		  $('#about').addClass('active');
		  break;	
		case 'Contact':
		  $('#contact').addClass('active');
		  break;	
	    default:
		  $('#home').addClass('active');
		  $('#'+menu).addClass('active');
		  break;	
	}		
});

