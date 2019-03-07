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
<script src="js/roleAdmin.js"></script>

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
					<li><a href="roleAdmin" class="selected">Quyền người dùng</a></li>
					<li><a href="functionAdmin">Chức năng</a></li>
					<li><a href="roleFunctionAdmin">Chức năng của quyền</a></li>
					<li><a href="newsAdmin">Tin tức</a></li>

					<li><a href="helpAdmin">Trợ giúp</a></li>
				</ul>
			</div>

		</div>



		<div class="center_content">

			<div id="right_wrap">
				<div id="right_content">
					<h2>Bảng Người Dùng</h2>


					<table id="rounded-corner">
						<thead>
							<tr>

								<th>Tài khoản</th>
								<th>Tên quyền</th>
								<th>Mô tả</th>

							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="12">Trang quản lý của Admin!</td>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${listRole}" var="role">
								<tr class="odd">
									<td>${role.userName}</td>
									<td>${role.roleName}</td>
									<td>${role.description}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<ul class="tabsmenu">
						<li class="active"><a href="#">Thông Tin các quyền của
								người dùng</a></li>

					</ul>
					<div id="tab1" class="tabcontent">
						<form method="post" action="actionRole" name = "actionRoleUpdate">
							<div class="form">

								<div class="form_row">
									<label>Nhập Tài Khoản:</label>
									 <input id="nhap" required="required"  class="form_select" name="chooseUserName" type="text"  list="ide" />
									 <p style="color: red; padding-left: 100px" id="error" >${error}</p>
									 <c:remove var="error" scope="session" /> 
									<datalist id="ide" >
									<c:forEach items="${listRole}" var="role">
										<option value="${role.userName}">${role.userName}</option>
									</c:forEach> </datalist>
								</div>
								<div class="form_row">
									<label>Chọn quyền:</label> <select class="form_select"
										name="chooseRole">
										<option value="1">Admin</option>
										<option value="2">User</option>
									</select>
								</div>
								<div class="col-md-7">
									<input id="btnShowPopup" type="button" class="form_submit" value="Chỉnh Sửa" />
								</div>

								
							</div>
						</form>
							<div class="col-md-1">
							<input id="btnDisplayPopup" type="button" class="form_submit" value="Xóa" />
									
								</div>
						<div class="clear"></div>
					</div>


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
								class="btn btn-danger" />
							<input type="button" id="btnClosePopup" value="Close"
								class="btn btn-danger" />
						</div>
					</div>
				</div>
			</div><!-- end popup -->
					

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