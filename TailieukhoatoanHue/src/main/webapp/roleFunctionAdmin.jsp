<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Adminnitrator</title>
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano'
	rel='stylesheet' type='text/css' />
<!-- jQuery file -->
<script src="js/jquery.min1.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<!-- Font awesome -->
<link href="css/font-awesome.css" rel="stylesheet" />
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet" />
<!-- slick slider -->
</head>
<body>
	<div id="panelwrap">

		<div class="header">
			<div class="title">Trang Quản Lý</div>

			<div class="header_right">
				Xin Chào : ${account.userName},  <a href="<%=request.getContextPath()%>/index" class="logout"><i
					class="fa fa-sign-out" aria-hidden="true"></i>Thoát</a>
			</div>

			<div class="menu">
				<ul>
					<li><a href="indexAdmin">Trang Chủ</a></li>
					<li><a href="accountAdmin">Người dùng</a></li>
					<li><a href="roleAdmin">Quyền người dùng</a></li>
					<li><a href="functionAdmin">Chức năng</a></li>
					<li><a href="roleFuntionAdmin" class="selected">Chức năng
							của quyền</a></li>
					<li><a href="newsAdmin">Tin tức</a></li>

					<li><a href="helpAdmin">Trợ giúp</a></li>
				</ul>
			</div>

		</div>

		<!--   <div class="submenu">
    <ul>
    <li><a href="#" class="selected">settings</a></li>
    <li><a href="#">users</a></li>
    <li><a href="#">categories</a></li>
    <li><a href="#">edit section</a></li>
    <li><a href="#">templates</a></li>
    </ul>
    </div>   -->

		<div class="center_content">

			<div id="right_wrap">
				<div id="right_content">
					<h2>Bảng Người Dùng</h2>


					<table id="rounded-corner">
						<thead>
							<tr>
								<th></th>
								<th>Tài khoản</th>
								<th>Tên Chức Năng</th>
								<th>Mô tả</th>
								<th>Xóa</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="12">Trang quản lý của Admin!</td>
							</tr>
						</tfoot>
						<tbody>
							<tr class="odd">
								<td><input type="checkbox" name="" /></td>
								<td>User4</td>
								<td>Account-Xem trang</td>
								<td></td>

								<td><a href="#"><img src="img/trash.gif" alt=""
										title="" border="0" /></a></td>
							</tr>
							<tr class="even">
								<td><input type="checkbox" name="" /></td>
								<td>User3</td>
								<td>Account-Tải file</td>
								<td></td>


								<td><a href="#"><img src="img/trash.gif" alt=""
										title="" border="0" /></a></td>
							</tr>





						</tbody>
					</table>
					<div class="form_sub_buttons">

						<a href="#" class="button red">Xóa Lựa Chọn</a>
					</div>
					<ul id="tabsmenu" class="tabsmenu">
						<li class="active"><a href="#tab1">Thông Tin các chức năng của quyền </a></li>
						<!-- <li><a href="#tab2">Tab two</a></li>
        <li><a href="#tab3">Tab three</a></li>
        <li><a href="#tab4">Tab four</a></li> -->
					</ul>
					<div id="tab1" class="tabcontent">
						<form method="post" action="#">
							<div class="form">

								<div class="form_row">
									<label>Tài Khoản:</label> <select class="form_select" name="">
										<option>Chọn tài khoản</option>
										<option>User4</option>
										<option>User3</option>
									</select>
								</div>
								<div class="form_row">
									<label>Quyền:</label> <select class="form_select" name="">
										<option>Chọn quyền</option>
										<option>Account</option>

									</select>
								</div>
								<div class="form_row">
									<label>Chức năng:</label> <select class="form_select" name="">
										<option>Chọn chức năng</option>
										<option>Xem trang</option>
										<option>Tải file</option>
									</select>
								</div>
								<div class="form_row">
									<label>Mô tả:</label>
									<textarea class="form_textarea" name=""></textarea>
								</div>
								<div class="col-md-6">
									<input type="button" class="form_submit" value="Thêm Mới" />
								</div>

							</div>
						</form>
						<div class="col-md-1">
							<input type="button" class="form_submit" value=" Sửa" />
						</div>
						<div class="col-md-1">
							<input type="button" class="form_submit" value="Xóa" />
						</div>
						<div class="clear"></div>
					</div>


					

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