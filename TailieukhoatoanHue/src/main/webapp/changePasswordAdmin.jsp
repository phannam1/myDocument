<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Adminnitrator</title>
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'>
<!-- jQuery file -->
<script src="js/jquery.min1.js"></script>
<script src="js/changePasswordAdmin.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<!-- Font awesome -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">   
    <!-- slick slider -->

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
    <div class="title"> Trang Quản Lý</div>
    
    <div class="header_right">Xin Chào ${account.userName},  <a href="<%=request.getContextPath()%>/index" class="logout"><i class="fa fa-sign-out" aria-hidden="true"></i>Thoát</a> </div>
    
    <div class="menu">
    <ul>
     <li><a href="indexAdmin" >Trang Chủ</a></li>
    <li><a href="accountAdmin">Người dùng</a></li>
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
   
    
    <ul  class="tabsmenu">
        <li class="active"><a href="indexAdmin">Thông Tin Admin</a></li>
        <li class="active"><a href="changePasswordAdmin">Đổi Mật Khẩu</a></li>
        
    </ul>
    <div id="tab1" class="tabcontent">
        <form method="post" action="updatePasswordAdmin" name = "changePasswordForm">
        <div class="form"  >           
            <div class="form_row">
            <label>UserName:</label>
            <input type="text" class="form_input" name="userName"  value="${account.userName }" readonly="readonly" />
            </div>
             
            <div class="form_row">
            <label>Mật khẩu cũ:</label>
            <input type="password" class="form_input" name="password" value=""  required="required"/>
            </div>
            
            <div class="form_row">
            <label>Mật khẩu mới:</label>
            <input type="password" class="form_input" name="newPassword" value="" required="required" />
            </div>
            <div class="form_row">
            <label>Nhập lại mật khẩu:</label>
            <input type="password" class="form_input" name="retryPassword"  value="" required="required"/>
            </div>
           
            
            <div class="col-sm-5">
            <input  type="button" id="btnDisplayPopup" class="form_submit"
							value="Chỉnh Sửa" />
            </div> 
            </div>
           
            </form>
       <div class="clear"></div>
        </div>
    </div>
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
      
     </div>
     </div>  
    
    
    <div class="clear"></div>
    <div class="footer">
	Designed by <a href="https://www.facebook.com/PhanNam2433" target="_blank">PTN</a>
</div>
    </div> <!--end of center_content-->
    
    



    	
</body>
</html>