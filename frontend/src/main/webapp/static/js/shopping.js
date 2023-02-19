
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
		  $('#products').addClass('active');
		  $('#a_' + menu).addClass('active');
		  break;	

	}		
	
})