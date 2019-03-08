/**
 * 
 */
var passwordLevel2 = document.getElementById("matkhau").value;
if (passwordLevel2 != ("")) {
	document.getElementById("checkValue").style.display = 'none';
} else {
	document.getElementById("checkValue").style.display = 'display';
}
var answerSecurity = document.getElementById("answer").value;
if (answerSecurity != ("")) {
	document.getElementById("questionAndAnswer").style.display = 'none';
} else {
	document.getElementById("questionAndAnswer").style.display = 'display';
}