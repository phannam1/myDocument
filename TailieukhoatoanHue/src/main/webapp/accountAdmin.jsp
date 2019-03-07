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
<script src="js/accountAdmin.js"></script>

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
					<li><a href="accountAdmin" class="selected">Người dùng</a></li>
					<li><a href="roleAdmin">Quyền người dùng</a></li>
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
								<th>Tên</th>
								<th>Điện thoại</th>
								<th>Địa chỉ</th>
								<th>Email</th>
								<th>Hoạt Động ?</th>

							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="12">Trang quản lý của Admin!</td>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${list}" var="account">
								<tr>
									<td><a style="color: #0291d4;"
										href="getUserName?id=${account.userName} " name="name">${account.userName}
									</a></td>
									<td>${account.name}</td>
									<td>${account.phone}</td>
									<td>${account.address}</td>
									<td>${account.email}</td>
									<td><input class="isActive" type="checkbox"
										name="${account.userName}" value="${account.isActive } "
										onchange="myFunction(this.name)" id="${account.userName}" />
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>

					<ul class="tabsmenu">
						<li class="active"><a>Thông Tin người dùng</a></li>

					</ul>
					<div class="tabcontent">
						<form name="acctionEventUpdate" method="post" action="updateActiveDelete">
							<div class="form">
								<div class="form_row">
									<label>Tài khoản:</label> <input type="text" class="form_input"
										name="userName" readonly="readonly" value="${user.userName }" />
								</div>
								<div class="form_row">
									<label>Tên:</label> <input type="text" class="form_input"
										name="" readonly="readonly" value="${user.name }" />
								</div>
								<div class="form_row">
									<label>Điện thoại:</label> <input type="text"
										class="form_input" name="" value="${user.phone }"
										readonly="readonly" />
								</div>
								<div class="form_row">
									<label>Địa chỉ:</label> <input type="text" class="form_input"
										name="" value="${user.address }" readonly="readonly" />
								</div>
								<div class="form_row">
									<label>Email:</label> <input type="text" class="form_input"
										name="" value="${user.email }" readonly="readonly" />
								</div>
								<div class="form_row">
									<label>Hoạt Động:</label> <input class="isActive"
										style="width: 50px; height: 20px;" type="checkbox"
										class="form_input" name="isActive" value="${user.isActive }" />
								</div>
								<div class="form_row">
									<label>Xác nhận Xóa :</label> <input class="isActive"
										style="width: 50px; height: 20px;" type="checkbox"
										class="form_input" name="isDelete" value="${user.isDelete }" />
								</div>

								<div class="col-md-8">
									<input type="button" id="btnShowPopup" class="form_submit" value="Chỉnh Sửa" />

								</div>

							</div>
						</form>

						<div class="clear"></div>
					</div>



				</div>
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