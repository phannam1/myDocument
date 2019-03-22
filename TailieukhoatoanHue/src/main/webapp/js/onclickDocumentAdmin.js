/**
 * 
 */
function getValueDocument(id,nameDocument,major,semester,subject,nameTeacher,isShow){
	document.getElementById("documentId").value = id;
	document.getElementById("nameDocument").value = nameDocument;
	document.getElementById("major").value = major;
	document.getElementById("semester").value = semester;
	document.getElementById("subject").value = subject;
	document.getElementById("nameTeacher").value = nameTeacher;
	document.getElementById("isShow").value = isShow;
}