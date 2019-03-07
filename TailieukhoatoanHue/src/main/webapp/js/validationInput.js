
function checkValudation(id) {
	var userName = document.getElementById(id).value;
	if (userName == "" && id == "taikhoan") {

		document.getElementById("checkNulltk").style.display = 'block';
	} else {
		document.getElementById("checkNulltk").style.display = 'none';
	}
	if( (document.getElementById(id).value).length <6 && id == "matkhau"){
		document.getElementById("checkMore6").style.display = 'block';
	}else{
		document.getElementById("checkMore6").style.display = 'none';
	}
	
}
function checkValudationRegister(id){
	var userName = document.getElementById(id).value;
	if (userName == "" && id == "taikhoan") {

		document.getElementById("checkNulltk").style.display = 'block';
	} else {
		document.getElementById("checkNulltk").style.display = 'none';
	}
	if( (document.getElementById(id).value).length <6 && id == "matkhau"){
		document.getElementById("checkMore6").style.display = 'block';
	}else{
		document.getElementById("checkMore6").style.display = 'none';
	}
	if (userName == "" && id == "name") {
		document.getElementById("checkNullName").style.display = 'block';
	} else {
		document.getElementById("checkNullName").style.display = 'none';
	}
	
	var password = document.getElementById("matkhau").value;
	var retryPassword = document.getElementById("confirmmatkhau").value;
	if(password !=retryPassword){
		document.getElementById("checkNullConfirm").style.display = 'block';
	}
	else{
		document.getElementById("checkNullConfirm").style.display = 'none';
	}
}
function checkValudationForgotPassword(id){
	var userName = document.getElementById(id).value;
	if (userName == "" && id == "taikhoan") {

		document.getElementById("checkNulltk").style.display = 'block';
	} else {
		document.getElementById("checkNulltk").style.display = 'none';
	}
	if(userName == "" && id == "matkhau"){
		document.getElementById("checkMore6").style.display = 'block';
	}else{
		document.getElementById("checkMore6").style.display = 'none';
	}
	
}
function checkValudationChangePassword(id){
	if (document.getElementById("mk").value == "" && id == "mk") {

		document.getElementById("checkNullmk").style.display = 'block';
	} else {
		document.getElementById("checkNullmk").style.display = 'none';
	}
	if( (document.getElementById(id).value).length <6 && id == "matkhau"){
		document.getElementById("checkMore6").style.display = 'block';
	}else{
		document.getElementById("checkMore6").style.display = 'none';
	}
	var password = document.getElementById("matkhau").value;
	var retryPassword = document.getElementById("confirmmatkhau").value;
	if(password !=retryPassword){
		document.getElementById("checkNullConfirm").style.display = 'block';
	}
	else{
		document.getElementById("checkNullConfirm").style.display = 'none';
	}
}
function checkValudationInfor(id){
	if (document.getElementById("mk").value == "" && id == "mk") {

		document.getElementById("checkNullmk").style.display = 'block';
	} else {
		document.getElementById("checkNullmk").style.display = 'none';
	}
	if( (document.getElementById(id).value).length <6 && id == "matkhau"){
		document.getElementById("checkMore6").style.display = 'block';
	}else{
		document.getElementById("checkMore6").style.display = 'none';
	}
	
}
function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if( re.test(String(email).toLowerCase())){
    	document.getElementById("checkNullEmail").style.display = 'block';
    }
    else {
		
		document.getElementById("checkNullEmail").style.display = 'none';
	}	
}
function checkValudationRegister1(id){
	if( (document.getElementById(id).value).length <6 && id == "matkhau"){
		document.getElementById("checkMore6").style.display = 'block';
	}else{
		document.getElementById("checkMore6").style.display = 'none';
	}
	var password = document.getElementById("matkhau").value;
	var retryPassword = document.getElementById("confirmmatkhau").value;
	if(password !=retryPassword){
		document.getElementById("checkNullConfirm").style.display = 'block';
	}
	else{
		document.getElementById("checkNullConfirm").style.display = 'none';
	}
}


