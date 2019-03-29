/**
 * 
 */
var list = [];
  $(document).ready(function(){
	  jQuery(".isActive").each(function(){
		   if(jQuery(this).val()==1){
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
  };
function getValueDocument(id,nameDocument,major,semester,subject,courseCredit,nameTeacher,isShow){
	document.getElementById("documentId").value = id;
	document.getElementById("nameDocument").value = nameDocument;
	document.getElementById("major").value = major;
	document.getElementById("semester").value = semester;
	document.getElementById("subject").value = subject;
	document.getElementById("courseCredit").value = courseCredit;
	document.getElementById("nameTeacher").value = nameTeacher;	
	document.getElementById("isShow").value = isShow;
	var active = $('#isShow').val();
	if(active == 1){
		 $('#isShow').attr("checked","checked");
	}else{
		 $('#isShow').removeAttr("checked");
	}
}