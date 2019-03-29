/**
 * 
 */
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
    	
    	  $('form[name=acctionDocumentUpdate]').submit();
          $("#MyPopup").modal("hide");
          
      });
  });
$(function () {
    $('input[id=btnShowPopup]').click(function () {
        var title = "Xác Nhận";
        var body = "Bạn có chắc chắn thực hiện chức năng này ?";

        $("#MyPopup1 .modal-title").html(title);
        $("#MyPopup1 .modal-body").html(body);
        $("#MyPopup1").modal("show");
    });

    $("#btnClosePopup1").click(function () {
        $("#MyPopup1").modal("hide");
    });
         
    $("#btnConfirmPopup1").click(function () {
  	  $('form[name=acctionDocumentUpdate]').attr('action','deleteDocument'); 
  	  $('form[name=acctionDocumentUpdate]').submit();
        $("#MyPopup1").modal("hide");
        
    });
});



$(function () {
    $('input[id=btnSearchDocument]').click(function () {
    	
    	  $('form[name=searchInputDocument]').submit();
          
    });

   
         
    
  	
        

});