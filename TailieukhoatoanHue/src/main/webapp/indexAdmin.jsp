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
    
    <div class="header_right">Xin Chào : ${account.userName}, <a href="#" class="settings"><i class="fa fa-cog"></i>Cài đặt</a> <a href="<%=request.getContextPath()%>/index" class="logout"><i class="fa fa-sign-out" aria-hidden="true"></i>Thoát</a> </div>
    
    <div class="menu">
    <ul>
    <li><a href="indexAdmin" class="selected">Trang Chủ</a></li>
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
   
    <ul id="tabsmenu" class="tabsmenu">
        <li class="active"><a href="#tab1">Thông Tin Admin</a></li>
       
    </ul>
    <div id="tab1" class="tabcontent">
        <form method="post" action="updateAdmin">
        <div class="form"  >           
            <div class="form_row">
            <label>Tài khoản:</label>
            <input type="text" class="form_input" name="userName" readonly="readonly" value="${account.userName }" />
            </div>
             
            <div class="form_row">
            <label>Tên:</label>
            <input type="text" class="form_input" name="name" value="${account.name }" />
            </div>
            
            <div class="form_row">
            <label>Địa chỉ:</label>
            <input type="text" class="form_input" name="address" value="${account.address }" />
            </div>
            <div class="form_row">
            <label>Email:</label>
            <input type="text" class="form_input" name="email"  value="${account.email }"/>
            </div>
            <div class="form_row">
            <label>Điện thoại:</label>
            <input type="text" class="form_input" name="phone" value="${account.phone }"/>
            </div>
            
            <div class="form_row">
            <input type="submit" class="form_submit" value="Chỉnh Sửa" />
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