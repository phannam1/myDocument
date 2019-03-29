<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Adminnitrator</title>
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'>
<!-- jQuery file -->
<script src="js/jquery.min1.js"></script>
<script src="js/onclickDocumentAdmin.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<!-- Font awesome -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">   
    <!-- slick slider -->
</head>
<body>
<div id="panelwrap">
  	
	<div class="header">
    
    
    <div class="header_right">Xin Chào : ${account.name},  <a href="<%=request.getContextPath()%>/index" class="logout"><i class="fa fa-sign-out" aria-hidden="true"></i>Thoát</a> </div>
    
    <div class="menu">
    <ul>
    <li><a href="" class="selected">Tài liệu của bạn</a></li>
    
    </ul>
    </div>
    
    </div>
<div class="tabcontent">
			<form name="acctionDocumentUpdate" method="post"
				action="updateIsShowDocument">
				<div class="form">
				 <input id = 'documentId' style="width: 500px;display: none" type="text" class="form_input" name="documentId" value="" />
					 <div class="row">
						<div class="col-sm-6" >
							<div class="col-sm-4" ><label>Tên tài liệu:</label> </div>
							<div class="col-sm-8" >
								<input id="nameDocument" type="text" class="form_input" name="nameDocument"  value="" />
							</div>
						</div>
						<div class="col-sm-6" >
							<div class="col-sm-4" ><label>Ngành học:</label> </div>
							<div class="col-sm-8" >
							<input id="major" type="text" class="form_input" name="major"  value="" />
							</div>
						</div>
					</div>
					<div class="row">
					<div class="col-sm-6" >
					<div class="col-sm-4" >
						<label>Kỳ học:</label></div> <div class="col-sm-8" > <input id="semester" type="text" class="form_input"
							name="semester" value=""  /></div>
					</div>
					<div class="col-sm-6" >
					<div class="col-sm-4" >
						<label>Chuyên ngành:</label></div><div class="col-sm-8" > <input id="subject" type="text" class="form_input"
							name="subject" value=""  /></div>
					</div>
					</div>
						<div class="row">
					<div class="col-sm-6" >
						<div class="col-sm-4" ><label>Tên giáo viên :</label></div><div class="col-sm-8" > <input id="nameTeacher" type="text" class="form_input"
							name="nameTeacher" value=""  /></div>
					</div>
					<div class="col-sm-6" >				
						<div class="col-sm-4" ><label>Hiển thị:</label></div><div  class="col-sm-8" > <input id="isShow" class="isActive"
							style="width: 50px; height: 20px;" type="checkbox"
							class="form_input" name="isActive" value="" /></div>
					</div>
					</div>
					
				<div class="row">
				<div class="col-sm-6" >
						<div class="col-sm-4" ><label>Số tín chỉ :</label></div><div class="col-sm-8" > <input id="courseCredit" type="text" class="form_input"
							name="courseCredit" value="" /></div>
					</div>
					<div class="col-sm-6" >
						<input  type="button" id="btnDisplayPopup" class="form_submit"
							value="Chỉnh Sửa" />

					</div>
					
					</div>
				</div>
			</form>

			<div class="clear"></div>
		</div>
    <div class="center_content">

			<div id="right_wrap">
				<div id="right_content">
					<h2>Bảng tài liệu</h2>


					<table id="rounded-corner">
						<thead>
							<tr>
								<th>Tên tài liệu</th>
								<th>Ngành học</th>
								<th>Kỳ học</th>
								<th>Chuyên ngành</th>
								<th>Số tín chỉ</th>
								<th>Tên giáo viên phụ trách</th>							
								<th>hiển thị</th>
								<th>LastModifiledByUserName</th>
								<th>creationDate</th>
								<th>lastModifiedDate</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="12">Trang tài liệu của người dùng</td>
							</tr>
						</tfoot>
						<tbody>
					
							<c:forEach items="${listDocument}" var="document">
								<tr class="odd" onclick="getValueDocument('${document.id}','${document.documentName}','${document.major}','${document.semester}','${document.subject}','${document.courseCredit}','${document.nameTeacher}','${document.isShow }')">
								 <td style="display: none"><a >${document.id}</a></td>
									<td><a >${document.documentName}</a></td>
									<td>${document.major}</td>
									<td>${document.semester}</td>
									<td>${document.subject}</td>
									<td>${document.courseCredit}</td>
									<td>${document.nameTeacher}</td>									
										<td ><input class="isActive" type="checkbox" onchange="myFunction(this.name)"
											name="${document.isShow }" value="${document.isShow } "
											 id="${document.isShow }" disabled />
										</td>
										<td>${document.lastModifiedUserName}</td>
										<td>${document.creationDate}</td>	
										<td>${document.lastModifiedDate}</td>	
									
									
									
																		
								</tr>
							</c:forEach>
						
						</tbody>
					</table>




					<!-- Modal Popup -->
					<div id="MyPopup" class="modal fade" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										&times;</button>
									<h4 class="modal-title"></h4>
								</div>
								<div class="modal-body"></div>
								<div class="modal-footer">
									<input type="button" id="btnConfirmPopup" value="Xác Nhận"
										class="btn btn-danger" /> <input type="button"
										id="btnClosePopup" value="Close" class="btn btn-danger" />
								</div>
							</div>
						</div>
					</div>
					<!-- end popup -->


				</div>
			</div>


			<div class="clear"></div>
		</div>
    
    
   
    <div class="footer">
	Designed by <a href="https://www.facebook.com/PhanNam2433" target="_blank">PTN</a>
</div>
    </div> <!--end of center_content-->
    
    

<!-- bang thu nhat:id, cac fields, createdbyid, bang thu 2:id, lastmodifiedbyid -->
    	
</body>
</html>