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
	    $('input[id=btnDisplayPopup]').click(function () {
	        var title = "Xác Nhận";
	        var body = "Bạn có chắc chắn thực hiện chức năng này ?";
	
	        $("#MyPopup .modal-title").html(title);
	        $("#MyPopup .modal-body").html(body);
	        $("#MyPopup").modal("show");
		 });
	        $("#btnClosePopup").click(function () {
	            $("#MyPopup").modal("hide");
	        });
	             
	        $("#btnConfirmPopup").click(function () {
	      	      //$('form[name=actionFunction]').attr('action','functionUpdate');
	         	  $('form[name=actionFunction]').submit();
	            $("#MyPopup").modal("hide");
	            
	        });
	    });
 $(function () {
	    $('input[id=btnDelete]').click(function () {
	        var title = "Xác Nhận";
	        var body = "Bạn có chắc chắn thực hiện chức năng này ?";
	
	        $("#MyPopup .modal-title").html(title);
	        $("#MyPopup .modal-body").html(body);
	        $("#MyPopup").modal("show");
		 });
	        $("#btnClosePopup").click(function () {
	            $("#MyPopup").modal("hide");
	        });
	             
	        $("#btnConfirmPopup").click(function () {
	      	      $('form[name=actionFunction]').attr('action','functionDelete');
	         	  $('form[name=actionFunction]').submit();
	            $("#MyPopup").modal("hide");
	            
	        });
	    });

 
