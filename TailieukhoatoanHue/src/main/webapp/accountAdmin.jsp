<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Adminnitrator</title>
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'/>
<!-- jQuery file -->
<script src="js/jquery.min1.js"></script>
<script src="js/accountAdmin.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<!-- Font awesome -->
    <link href="css/font-awesome.css" rel="stylesheet"/>
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet"/>   
    <!-- slick slider -->
</head>
<body>
<div id="panelwrap">
  	
	<div class="header">
    <div class="title"> Trang Quản Lý</div>
    
    <div class="header_right">Xin Chào : ${account.userName}, <a href="#" class="settings"><i class="fa fa-cog"></i>Cài đặt</a> <a href="<%=request.getContextPath()%>/index" class="logout"><i class="fa fa-sign-out" aria-hidden="true"></i>Thoát</a> </div>
    
    <div class="menu">
    <ul>
    <li><a href="indexAdmin" >Trang Chủ</a></li>
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
            <th>Xóa ?</th>        
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
     <td><a style="color: #0291d4;" href="getUserName?id=${account.userName} " name = "name">${account.userName} </a></td>
      <td>${account.name} </td>
       <td>${account.phone} </td>
        <td>${account.address} </td>
         <td>${account.email} </td>
          <td > <input  class="isActive" type="checkbox" name="${account.userName}" value="${account.isActive } " onchange = "myFunction(this.name)" id="${account.userName}" /> 	</td>
          <td><input type="checkbox" name="" /> </td>
    </tr>
  </c:forEach> 
    </tbody>
</table>
<div class="form_sub_buttons">
 <a href="#" class="button red" id="getUserName">Xác nhận sửa</a>
    <a href="#" class="button red">Xóa Lựa Chọn</a>
   
    </div>
 <ul id="tabsmenu" class="tabsmenu">
        <li class="active"><a href="#tab1">Thông Tin người dùng</a></li>
      
    </ul>
    <div id="tab1" class="tabcontent">
        <form method="post" action="#">
        <div class="form"  >
             <div class="form_row">
            <label>Tài khoản:</label>
            <input type="text" class="form_input" name="" readonly="readonly" value=""/>
            </div>
            <div class="form_row">
            <label>Tên:</label>
            <input type="text" class="form_input" name="" readonly="readonly" value=""/>
            </div>
            <div class="form_row">
            <label>Điện thoại:</label>
            <input type="text" class="form_input" name="" value="" readonly="readonly"/>
            </div>
            <div class="form_row">
            <label>Địa chỉ:</label>
            <input type="text" class="form_input" name="" value="" readonly="readonly" />
            </div>
            <div class="form_row">
            <label>Email:</label>
            <input type="text" class="form_input" name=""  value="" readonly="readonly"/>
            </div>
            <div class="form_row">
            <label>Hoạt Động:</label>
            <input style="width: 50px;height: 20px;" type="checkbox" class="form_input" name=""  value="" />
            </div>
            <div class="form_row">
            <label>Xác nhận Xóa :</label>
            <input style="width: 50px;height: 20px;" type="checkbox" class="form_input" name=""  value="" />
            </div>
            
            <div class="col-md-7" >
            <input type="submit" class="form_submit" value="Chỉnh Sửa" />
            </div> 
             
            </div>
            </form>
            <div class="col-md-5" >
            <input style="float: left;" type="submit" class="form_submit" value="Xóa" />
            </div>
            <div class="clear"></div>
            </div> 
            

	  
     </div>
     </div><!-- end of right content-->
                     
                    
       
    
    
    <div class="clear"></div>
    </div> <!--end of center_content-->
    
    <div class="footer">
	Designed by <a href="https://www.facebook.com/PhanNam2433" target="_blank">PTN</a>
</div>

</div>

    	
</body>
</html>