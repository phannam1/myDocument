<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Adminnitrator</title>
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano'
	rel='stylesheet' type='text/css' />
<!-- jQuery file -->
<script src="js/jquery.min1.js"></script>
<script type="text/javascript" src="js/onclickDocumentAdmin.js"></script>
<script type="text/javascript" src="js/actionFormDocument.js"></script>

<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<!-- Font awesome -->
<link href="css/font-awesome.css" rel="stylesheet" />
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet" />
<!-- slick slider -->
<link rel="shortcut icon" href="img/T.PNG" type="image/x-icon">

<script type="text/javascript"
	src='https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.min.js'></script>
<script type="text/javascript"
	src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js'></script>
<link rel="stylesheet"
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/css/bootstrap.min.css'
	media="screen" />
</head>
<body>
	<div id="panelwrap">

		<div class="header">
			<div class="title">Trang Quản Lý</div>

			<div class="header_right">
				Xin Chào : ${account.userName}, <a
					href="<%=request.getContextPath()%>/index" class="logout"><i
					class="fa fa-sign-out" aria-hidden="true"></i>Thoát</a>
			</div>

			<div class="menu">
				<ul>
					<li><a href="indexAdmin">Trang Chủ</a></li>
					<li><a href="accountAdmin">Người dùng</a></li>
					<li><a href="roleAdmin" >Quyền người dùng</a></li>
					<li><a href="functionAdmin">Chức năng</a></li>
					<li><a href="roleFunctionAdmin">Chức năng của quyền</a></li>
					<li><a href="documentAdmin" class="selected">Tài liệu</a></li>
					<li><a href="newsAdmin">Tin tức</a></li>

					<li><a href="helpAdmin">Trợ giúp</a></li>
				</ul>
			</div>

		</div>

		<ul class="tabsmenu">
			<li class="active">
				<form name="searchInputDocument" method="post" action="searchDocumentByInput">
					<div>
						<div>
							<input id="btnSearchDocument" type="button" class="form_submit"
								value="Tìm Kiếm" />

						</div>
						<div>
							<input id="valueInputSearch" type="text" class="form_input"
								name="valueInputSearch" value="" />
						</div>


					</div>
				</form>
			</li>
			<li class="active"><a>Thông tin tài liệu</a></li>

		</ul>
		<div class="tabcontent">
			<form name="acctionDocumentUpdate" method="post"
				action="updateIsShowDocument">
				<div class="form">
				 <input id = 'documentId' style="width: 500px;display: none" type="text" class="form_input" name="documentId" value="" />
					 <div class="row">
						<div class="col-sm-6" >
							<div class="col-sm-4" ><label>Tên tài liệu:</label> </div>
							<div class="col-sm-8" >
								<input id="nameDocument" type="text" class="form_input" name="" readonly="readonly" value="" />
							</div>
						</div>
						<div class="col-sm-6" >
							<div class="col-sm-4" ><label>Ngành học:</label> </div>
							<div class="col-sm-8" >
							<input id="major" type="text" class="form_input" name="" readonly="readonly" value="" />
							</div>
						</div>
					</div>
					<div class="row">
					<div class="col-sm-6" >
					<div class="col-sm-4" >
						<label>Kỳ học:</label></div> <div class="col-sm-8" > <input id="semester" type="text" class="form_input"
							name="" value="" readonly="readonly" /></div>
					</div>
					<div class="col-sm-6" >
					<div class="col-sm-4" >
						<label>Chuyên ngành:</label></div><div class="col-sm-8" > <input id="subject" type="text" class="form_input"
							name="" value="" readonly="readonly" /></div>
					</div>
					</div>
						<div class="row">
					<div class="col-sm-6" >
						<div class="col-sm-4" ><label>Tên giáo viên :</label></div><div class="col-sm-8" > <input id="nameTeacher" type="text" class="form_input"
							name="" value="" readonly="readonly" /></div>
					</div>
					<div class="col-sm-6" >				
						<div class="col-sm-4" ><label>Hiển thị:</label></div><div  class="col-sm-8" > <input id="isShow" class="isActive"
							style="width: 50px; height: 20px;" type="checkbox"
							class="form_input" name="isActive" value="" /></div>
					</div>
					</div>
					
				<div class="row">
					<div class="col-sm-12" >
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
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="12">Trang quản lý của Admin!</td>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${listDocument}" var="document">
								<tr class="odd" onclick="getValueDocument('${document.id}','${document.documentName}','${document.major}','${document.semester}','${document.subject}','${document.nameTeacher}','${document.isShow }')">
								 <td style="display: none"><a >${document.id}</a></td>
									<td><a >${document.documentName}</a></td>
									<td>${document.major}</td>
									<td>${document.semester}</td>
									<td>${document.subject}</td>
									<td>${document.courseCredit}</td>
									<td>${document.nameTeacher}</td>									
										<td ><input class="isActive" type="checkbox"
											name="${document.isShow }" value="${document.isShow } "
											 id="${document.isShow }" />
										</td>								
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
		<!--end of center_content-->

		<div class="footer">
			Designed by <a href="https://www.facebook.com/PhanNam2433"
				target="_blank">PTN</a>
		</div>

	</div>


</body>
</html>