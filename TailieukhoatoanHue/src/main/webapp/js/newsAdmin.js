/**
 * 
 */
 $(function () {
	    $('input[id=btnDisplayPopup]').click(function () {
	        var title = "Xác Nhận Sửa";
	        var body = "Bạn có chắc chắn thực hiện chức năng này ?";
	
	        $("#MyPopup .modal-title").html(title);
	        $("#MyPopup .modal-body").html(body);
	        $("#MyPopup").modal("show");
		 });
	        $("#btnClosePopup").click(function () {
	            $("#MyPopup").modal("hide");
	        });
	             
	        $("#btnConfirmPopup").click(function () {
	        	 $('form[name=formNews]').attr('action','updateNews');
	         	  $('form[name=formNews]').submit();
	            $("#MyPopup").modal("hide");	            
	        });
	    });
 $(function () {
	    $('input[id=btnDelete]').click(function () {
	        var title = "Xác Nhận Xóa";
	        var body = "Bạn có chắc chắn thực hiện chức năng này ?";	
	        $("#MyPopup1.modal-title").html(title);
	        $("#MyPopup1.modal-body").html(body);
	        $("#MyPopup1").modal("show");
		 });
	        $("#btnClosePopup1").click(function () {
	            $("#MyPopup1").modal("hide");
	        });	             
	        $("#btnConfirmPopup1").click(function () {
	      	      $('form[name=formNews]').attr('action','deleteNews');
	         	  $('form[name=formNews]').submit();
	            $("#MyPopup1").modal("hide");
	            
	        });
	    });
 $(function () {
	  $('#btnSearchNews').click(function () {
	  
	  $('form[name=searchInput]').submit();
     
 });
});