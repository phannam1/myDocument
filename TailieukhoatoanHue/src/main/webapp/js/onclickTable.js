/**
 * 
 */
function getValueAccount(userName,name,phone,address,email,isActive){	
	
	  document.getElementById('taikhoan').value = userName;
	  document.getElementById('ten').value = name;
	  document.getElementById('dienthoai').value = phone;
	  document.getElementById('diachi').value = address;
	  document.getElementById('email').value = email;
	  document.getElementById('hoatdong').value = isActive;
	  var active = $('#hoatdong').val();
		if(active == 1){
			 $('#hoatdong').attr("checked","checked");
		}else{
			 $('#hoatdong').removeAttr("checked");
		}
  }
