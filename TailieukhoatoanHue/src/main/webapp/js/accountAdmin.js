/**
 * 
 */
	var list = [];
  $(document).ready(function(){
	  jQuery(".isActive").each(function(){
		   if(jQuery(this).val()== 1){
			  
			   jQuery(this).attr("checked","checked");
			  list.push(jQuery(this).attr("name"));
		   }
		  
		  });
               
          });
  
  function myFunction(val){
	  if(document.getElementById(val).checked){
		  list.push(val);
	  }
	  else{
		  for(var i = 0 ;i<list.length ;i++){
			  if(val == list[i]){
				  list.splice(i, 1); 
			  }
		  }
	  }
	  
	  console.log(list.valueOf());
  }
 
 