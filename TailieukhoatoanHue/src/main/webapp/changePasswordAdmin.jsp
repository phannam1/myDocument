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
   
    
    <ul  class="tabsmenu">
        <li class="active"><a href="indexAdmin">Thông Tin Admin</a></li>
        <li class="active"><a href="changePasswordAdmin">Đổi Mật Khẩu</a></li>
        
    </ul>
    <div id="tab1" class="tabcontent">
        <form method="post" action="updatePasswordAdmin">
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
           
            
            <div class="form_row">
            <input type="submit" class="form_submit" value="Chỉnh Sửa" required="required" />
            </div> 
            </div>
           
            </form>
       <div class="clear"></div>
        </div>
    </div>
   
      
     </div>
     </div>  
    
    
    <div class="clear"></div>
    <div class="footer">
	Designed by <a href="https://www.facebook.com/PhanNam2433" target="_blank">PTN</a>
</div>
    </div> <!--end of center_content-->
    
    



    	
</body>
</html>