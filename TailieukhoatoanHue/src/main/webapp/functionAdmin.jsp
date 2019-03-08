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
    
        
                    
    <div class="center_content">  
 
    <div id="right_wrap">
    <div id="right_content">             
    <h2>Bảng Người Dùng</h2> 
                    
                    
<table id="rounded-corner">
    <thead>
    	<tr>
       
            <th>STT</th>
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
    	<tr class="odd"> 
            <td><a href="getFunction?id=${function.functionId }">${function.functionId }</a></td>
            <td>${function.functionName }</td>
            <td>${function.description }</td> 
        </tr>
</c:forEach>
    </tbody>
</table>

<ul id="tabsmenu" class="tabsmenu">
        <li class="active"><a href="#tab1">Thông Tin các chức năng người dùng</a></li>
        
    </ul>
    <div id="tab1" class="tabcontent">
        <form name ="actionFunction" method="post" action="" >
        <div class="form"  >
            
            
            <div class="form_row">
            <label>Tên Chức Năng:</label>
            <input type="text" class="form_input" name="functionName" value="" />
            </div>
            
            <div class="form_row">
            <label>Mô tả:</label>
            <textarea class="form_textarea" name="descriptionFunction" value="" ></textarea>
            </div>
             <div class="col-md-6" >
            <input id="btnRegister" type="button" class="form_submit" value="Thêm Mới" />
            </div>        
            </div>
            </form>
             <div class="col-md-1" >
            <input id="btnUpdate" type="button" class="form_submit" value=" Sửa" />
            </div>
            <div class="col-md-1" >
            <input  type="button" class="form_submit" value="Xóa" />
            </div>
            <div class="clear"></div>
            </div>
            

	   
      
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