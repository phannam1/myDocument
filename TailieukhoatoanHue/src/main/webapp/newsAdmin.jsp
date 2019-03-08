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
				Xin Chào : ${account.userName}, <a
					href="<%=request.getContextPath()%>/index" class="logout"><i
					class="fa fa-sign-out" aria-hidden="true"></i>Thoát</a>
			</div>

			<div class="menu">
				<ul>
					<li><a href="indexAdmin">Trang Chủ</a></li>
					<li><a href="accountAdmin">Người dùng</a></li>
					<li><a href="roleAdmin">Quyền người dùng</a></li>
					<li><a href="functionAdmin">Chức năng</a></li>
					<li><a href="roleFunctionAdmin">Chức năng của quyền</a></li>
					<li><a href="newsAdmin" class="selected">Tin tức</a></li>
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
					<h2>Bảng Tin Tức-Sự Kiện</h2>


					<table id="rounded-corner">
						<thead>
							<tr>
								<th></th>
								<th>Tiêu đề</th>
								<th>Ngày giờ đăng tin</th>
								<th>Đường dẫn ảnh của bản tin</th>
								<th>Nội dung</th>
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
								<td>THÔNG BÁO NHẬN THỰC TẬP SINH NĂM 2018 CỦA CÔNG TY
									BRYCEN VIỆT NAM</td>
								<td>08-12-2017</td>
								<td>img/internship.png</td>
								<td>Bạn đang tìm kiếm môi trường thực tập phù hợp để thực
									tập hay đang lo lắng cho công việc sau khi ra trường. Hãy đến
									với chúng tôi, Brycen Việt Nam với 100% vốn Nhật Bản, môi
									trường làm việc chuyên nghiệp, mang tính quốc tế cao, luôn tạo
									điều kiện cho các cá nhân có cơ hội phát triển nghề nghiệp.</td>
								<td><a href="#"><img src="img/trash.gif" alt=""
										title="" border="0" /></a></td>
							</tr>
							<tr class="even">
								<td><input type="checkbox" name="" /></td>
								<td>THÔNG BÁO NHẬN THỰC TẬP SINH NĂM 2018 CỦA CÔNG TY
									BRYCEN VIỆT NAM</td>
								<td>08-12-2017</td>
								<td>img/internship.png</td>
								<td>Bạn đang tìm kiếm môi trường thực tập phù hợp để thực
									tập hay đang lo lắng cho công việc sau khi ra trường. Hãy đến
									với chúng tôi, Brycen Việt Nam với 100% vốn Nhật Bản, môi
									trường làm việc chuyên nghiệp, mang tính quốc tế cao, luôn tạo
									điều kiện cho các cá nhân có cơ hội phát triển nghề nghiệp.</td>

								<td><a href="#"><img src="img/trash.gif" alt=""
										title="" border="0" /></a></td>
							</tr>





						</tbody>
					</table>
					<div class="form_sub_buttons">

						<a href="#" class="button red">Xóa Lựa Chọn</a>
					</div>
					<ul id="tabsmenu" class="tabsmenu">
						<li class="active"><a href="#tab1">Thông Tin các tin tức
								của trang</a></li>
						<!-- <li><a href="#tab2">Tab two</a></li>
        <li><a href="#tab3">Tab three</a></li>
        <li><a href="#tab4">Tab four</a></li> -->
					</ul>
					<div id="tab1" class="tabcontent">
						<form method="post" action="#">
							<div class="form">

								<div class="form_row">
									<label>Tiêu đề của bản tin:</label> <input type="text"
										class="form_input" name="" value="" />
								</div>
								<div class="form_row">
									<label>Đường dẫn ảnh:</label> <input placeholder=".img/.png"  type="text"
										class="form_input" name="" value=""  />
								</div>
								<div class="form_row">
									<label>Nội dung bản tin:</label>
									<textarea class="form_textarea" name=""
										value="Xem các dữ liệu hiển thị trên trang"></textarea>
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