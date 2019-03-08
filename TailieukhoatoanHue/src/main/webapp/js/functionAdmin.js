/**
 * 
 */
 $(function () {
	      $("#btnRegister").click(function () {
	    	  $('form[name=actionFunction]').attr('action','functionRegister');
	    	  $('form[name=actionFunction]').submit();
	          
	      });
	  });
 $(function () {
     $("#btnUpdate").click(function () {
   	  $('form[name=actionFunction]').attr('action','functionUpdate');
   	  $('form[name=actionFunction]').submit();
         
     });
 });