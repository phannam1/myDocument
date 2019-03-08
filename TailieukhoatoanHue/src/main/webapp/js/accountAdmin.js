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
  $(function () {
      $("#btnShowPopup").click(function () {
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
    	 
    	  $('form[name=acctionEventUpdate]').submit();
          $("#MyPopup").modal("hide");
          
      });
  });
  $(function () {
      $("#btnSearch").click(function () {
    	  $('form[name=searchInput]').attr('action','searchInput');
    	  $('form[name=searchInput]').submit();
          
      });
  });

  
