<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Adminnitrator</title>
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'/>
<!-- jQuery file -->
<script src="js/jquery.min1.js"></script>
<script src="js/functionAdmin.js"></script>
<script src="js/functionOnclickAdmin.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<!-- Font awesome -->
    <link href="css/font-awesome.css" rel="stylesheet"/>
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet"/>   
    <!-- slick slider -->
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
    <div class="title"> Trang Quản Lý</div>
    
    <div class="header_right">Xin Chào : ${account.userName},  <a href="<%=request.getContextPath()%>/index" class="logout"><i class="fa fa-sign-out" aria-hidden="true"></i>Thoát</a> </div>
    
    <div class="menu">
    <ul>
    <li><a href="indexAdmin" >Trang Chủ</a></li>
    <li><a href="accountAdmin" >Người dùng</a></li>
    <li><a href="roleAdmin" >Quyền người dùng</a></li>
    <li><a href="functionAdmin" class="selected">Chức năng</a></li>
    <li><a href="roleFunctionAdmin">Chức năng của quyền</a></li>
    <li><a href="newsAdmin">Tin tức</a></li> 
    <li><a href="helpAdmin">Trợ giúp</a></li>
    </ul>
    </div>
    
    </div>
    
        <ul  class="tabsmenu">
        <li class="active">
				<form name="searchInput" method="post" action="searchInputFunction">
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
        <li class="active"><a >Thông Tin các chức năng người dùng</a></li>
        
    </ul>
    <div  class="tabcontent">
        <form name ="actionFunction" method="post" action="functionUpdate" >
        <div class="form"  >
            
            <input id = 'inputfunctionId' style="width: 500px;display: none" type="text" class="form_input" name="functionId" value="" />
            <div class="form_row">
            <label>Tên Chức Năng:</label>
            <input id = 'ten' style="width: 500px;" type="text" class="form_input" name="functionName" value="" />
            </div>
            
            <div class="form_row">
            <label>Mô tả:</label>
            <input  style="width: 500px" id = 'mota' class="form_input" name="descriptionFunction" value="" />
            </div>
             <div class="col-md-6" >
            <input id="btnRegister" type="button" class="form_submit" value="Thêm Mới" />
            </div>        
            </div>
            </form>
             <div class="col-md-1" >
           <input  type="button" id="btnDisplayPopup" class="form_submit"
							value=" Sửa" />
            </div>
            <div class="col-md-1" >
            <input id="btnDelete" type="button" class="form_submit" value="Xóa" />
            </div>
            <div class="clear"></div>
            </div>
            
                    
    <div class="center_content">  
 
    <div id="right_wrap">
    <div id="right_content">             
    <h2>Bảng Người Dùng</h2> 
                    
                    
<table id="rounded-corner">
    <thead>
    	<tr>
       
            <th style="display: none">ID</th>
            <th>Tên Chức Năng</th>
            <th>Mô tả</th>      
            
        </tr>
    </thead>
        <tfoot>
    	<tr>
        	<td colspan="12">Trang quản lý của Admin!</td>
        </tr>
    </tfoot>
    <tbody>
    <c:forEach items="${list}" var="function">
    	<tr class="odd" onclick="clickTableFunction('${function.functionId }','${function.functionName }','${function.description }')"> 
            <td style="display: none"><a >${function.functionId }</a></td>
            <td>${function.functionName }</td>
            <td>${function.description }</td> 
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
								<h4 class="modal-title">Xác nhận Xóa</h4>
									<button type="button" class="close" data-dismiss="modal">
										&times;</button>									
								</div>								
								<div class="modal-body">Bạn có chắc chắn thực hiện chức năng này ?</div>
								<div class="modal-footer">
									<input type="button" id="btnConfirmPopup1" value="Xác Nhận"
										class="btn btn-danger" /> <input type="button"
										id="btnClosePopup1" value="Close" class="btn btn-danger" />
								</div>
							</div>
						</div>
					</div>
					<!-- end popup -->

	   
      
     </div>
     </div>
    
    <div class="clear"></div>
    </div> <!--end of center_content-->
    
    <div class="footer">
	Designed by <a href="https://www.facebook.com/PhanNam2433" target="_blank">PTN</a>
</div>

</div>

    	
</body>
</html>