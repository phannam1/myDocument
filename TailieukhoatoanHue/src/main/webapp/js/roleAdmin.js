/**
 * 
 */

	 $(function () {
      $("#btnShowPopup").click(function () {
          var title = "Xác Nhận";
          var body = "Bạn có chắc chắn thực hiện chức năng này ?";

          $("#MyPopup .modal-title").html(title);
          $("#MyPopup .modal-body").html(body);
          $("#MyPopup").modal("show");
          $("#btnClosePopup").click(function () {
              $("#MyPopup").modal("hide");
          });
               
          $("#btnConfirmPopup").click(function () {
//        	  $('form[name=actionRoleUpdate]').attr('action','actionRole');
        	  $('form[name=actionRoleUpdate]').submit();
              $("#MyPopup").modal("hide");
              
          });
      });
      document.getElementById("nhap").onchange = function() {myFunction()};

      function myFunction() {
       document.getElementById("error").style.display = 'none'; 
      } 
	 });
	 $(function () {
	      $("#btnSearchRole").click(function () {
	    	  $('form[name=searchInputRole]').attr('action','searchInputRole');
	    	  $('form[name=searchInputRole]').submit();
	          
	      });
	  });
	


