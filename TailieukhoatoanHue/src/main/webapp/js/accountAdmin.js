/**
 * 
 */
	
  $(document).ready(function(){
	  jQuery(".isActive").each(function(){
		   if(jQuery(this).val()== 1){
			  
			   jQuery(this).attr("checked","checked");
		   }
		  
		  });
               
          });