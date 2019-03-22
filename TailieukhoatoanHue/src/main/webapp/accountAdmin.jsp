<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<title>Adminnitrator</title>
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano'
	rel='stylesheet' type='text/css' />
<!-- jQuery file -->
<script src="js/jquery.min1.js"></script>
<script src="js/accountAdmin.js"></script>
<script src="js/onclickTable.js"></script>
<link href="css/font-awesome.css" rel="stylesheet">
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<!-- Font awesome -->
<link href="css/font-awesome.css" rel="stylesheet" />
<script type="text/javascript" src="js/paginationAdmin.js"></script>
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
						<li><a href="documentAdmin">Tài liệu</a></li>
					<li><a href="newsAdmin">Tin tức</a></li>

					<li><a href="helpAdmin">Trợ giúp</a></li>
				</ul>
			</div>

		</div>

		<ul class="tabsmenu">
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

			<li class="active"><a>Thông Tin người dùng</a></li>


		</ul>
		<div class="tabcontent">
			<form name="acctionEventUpdate" method="post"
				action="updateActiveDelete">
				<div class="form">
					 <div class="row">
						<div class="col-sm-6" >
							<div class="col-sm-4" ><label>Tài khoản:</label> </div>
							<div class="col-sm-8" >
								<input id="taikhoan" type="text" class="form_input" name="userName" readonly="readonly" value="" />
							</div>
						</div>
						<div class="col-sm-6" >
							<div class="col-sm-4" ><label>Tên:</label> </div>
							<div class="col-sm-8" >
							<input id="ten" type="text" class="form_input" name="" readonly="readonly" value="" />
							</div>
						</div>
					</div>
					<div class="row">
					<div class="col-sm-6" >
					<div class="col-sm-4" >
						<label>Điện thoại:</label></div> <div class="col-sm-8" > <input id="dienthoai" type="text" class="form_input"
							name="" value="" readonly="readonly" /></div>
					</div>
					<div class="col-sm-6" >
					<div class="col-sm-4" >
						<label>Địa chỉ:</label></div><div class="col-sm-8" > <input id="diachi" type="text" class="form_input"
							name="" value="" readonly="readonly" /></div>
					</div>
					</div>
						<div class="row">
					<div class="col-sm-6" >
						<div class="col-sm-4" ><label>Email:</label></div><div class="col-sm-8" > <input id="email" type="text" class="form_input"
							name="" value="" readonly="readonly" /></div>
					</div>
					<div class="col-sm-6" >				
						<div class="col-sm-4" ><label>Hoạt Động:</label></div><div  class="col-sm-8" > <input id="hoatdong" class="isActive"
							style="width: 50px; height: 20px;" type="checkbox"
							class="form_input" name="isActive" value="" /></div>
					</div>
					</div>
					
				<div class="row">
					<div class="col-sm-11" >
						<input style=" margin-right: 5%;" type="button" id="btnDisplayPopup" class="form_submit"
							value="Chỉnh Sửa" />

					</div>
					<div class="col-sm-1">
						<input type="button" id="btnShowPopup"  class="form_submit"
							value="Xóa tài khoản" />

					</div>
					</div>
				</div>
			</form>

			<div class="clear"></div>
		</div>


		<div class="center_content">

			<div id="right_wrap">
				<div id="right_content">
					<h2 >Bảng Người Dùng</h2>


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
							<tr >
							
								<td colspan="12">Trang quản lý của Admin!</td>
								
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${list}" var="account">
	
								<tr onclick="getValueAccount('${account.userName}','${account.name}','${account.phone}','${account.address}','${account.email}','${account.isActive }')"  >
									<td ><a style="color: #0291d4;"
									 >${account.userName}
									</a></td>
									<td >${account.name}</td>
									<td >${account.phone}</td>
									<td >${account.address}</td>
									<td >${account.email}</td>
									<td ><input class="isActive" type="checkbox"
										name="${account.userName}" value="${account.isActive } "
										onchange="myFunction(this.name)" id="${account.userName}" />
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
<div class="aa-properties-content-bottom">
						<nav>
							<ul class="pagination">
								<li><a><button  id="btn_first"
											onClick="firstPage(this.id)">Đầu Trang</button></a> <a><button
											id="btn_prev" onClick="prevPage(this.id)">Trang
											Trước</button></a></li>
								<li class="active" id="1"><a><button id="btn_next1"
											onClick="clickPage1(this.id)">1</button></a></li>
								<li id="2"><a><button id="btn_next2"
											onClick="clickPage2(this.id)">2</button></a></li>
								<li id="3"><a><button id="btn_next3"
											onClick="clickPage3(this.id)">3</button></a></li>
								<li id="4"><a><button id="btn_next4"
											onClick="clickPage4(this.id)">4</button></a></li>
								<li id="5"><a><button id="btn_next5"
											onClick="clickPage5(this.id)">5</button></a></li>
								<li><a><button id="btn_next"
											onClick="nextPage(this.id)">Trang Kế</button></a> <a><button
											id="btn_last" onClick="lastPage(this.id)">Cuối Trang</button></a></li>
							</ul>
						</nav>
					</div>


				</div>
			</div>

			

			<div class="clear"></div>
		</div>
		<!--end of center_content-->
<!-- Modal Popup -->
					<div id="MyPopup" class="modal fade" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
								<h4 class="modal-title"></h4>
									<button type="button" class="close" data-dismiss="modal">
										&times;</button>									
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
					<!-- Modal Popup -->
					<div id="MyPopup1" class="modal fade" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
								<h4 class="modal-title"></h4>
									<button type="button" class="close" data-dismiss="modal">
										&times;</button>									
								</div>								
								<div class="modal-body"></div>
								<div class="modal-footer">
									<input type="button" id="btnConfirmPopup1" value="Xác Nhận"
										class="btn btn-danger" /> <input type="button"
										id="btnClosePopup1" value="Close" class="btn btn-danger" />
								</div>
							</div>
						</div>
					</div>
					<!-- end popup -->
					
		<div class="footer">
		
			Designed by <a href="https://www.facebook.com/PhanNam2433"
				target="_blank">PTN</a>
		</div>

	</div>


</body>
</html>