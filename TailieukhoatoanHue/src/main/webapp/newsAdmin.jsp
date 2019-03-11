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
<ul  class="tabsmenu">
<li class="active">
				<form name="searchInput" method="post" action="searchInput">
					<div>
						<div>
							<input id="btnSearch" type="button" class="form_submit"
								value="Tìm Kiếm" />

						</div>
						<div>
							<input id="valueInputSearch" type="text" class="form_input"
								name="valueInput" value="" />
						</div>


					</div>
				</form>
			</li>
						<li class="active"><a href="">Thông Tin các tin tức
								của trang</a></li>
						
					</ul>
					<div class="tabcontent">
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
		

		<div class="center_content">

			<div id="right_wrap">
				<div id="right_content">
					<h2>Bảng Tin Tức-Sự Kiện</h2>


					<table id="rounded-corner">
						<thead>
							<tr>						
								<th>Tiêu đề</th>
								<th>Ngày giờ đăng tin</th>
								<th>Đường dẫn ảnh của bản tin</th>
								<th>Nội dung</th>
								
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="12">Trang quản lý của Admin!</td>
							</tr>
						</tfoot>
						<tbody>
						<c:forEach items="${listNews}" var="listNews">
							<tr class="odd">
								<td style="display: none">${listNews.newsId}</td>
								<td>${listNews.title}</td>
								 <td>${listNews.dateTime}</td> 
								<td>${listNews.pictureLink}</td>
								<td>${listNews.content }</td>
								
							</tr>
							</c:forEach>





						</tbody>
					</table>
					
					



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