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
    
    <div class="header_right">Xin Chào ${account.userName}, <a href="#" class="settings"><i class="fa fa-cog"></i>Cài đặt</a> <a href="<%=request.getContextPath()%>/index" class="logout"><i class="fa fa-sign-out" aria-hidden="true"></i>Thoát</a> </div>
    
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
    <!--<h2>Thông Tin Admin</h2> 
                    
                    
 <table id="rounded-corner">
    <thead>
    	<tr>
        	<th></th>
            <th>Tên</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Email</th>
            <th>IsActive</th>
            <th>IsDelete</th>
            <th>Sửa</th>
            <th>Xóa</th>
        </tr>
    </thead>
        <tfoot>
    	<tr>
        	<td colspan="12">Trang quản lý người dùng.</td>
        </tr>
    </tfoot>
    <tbody>
    	<tr class="odd">
        	<td><input type="checkbox" name="" /></td>
            <td>User4</td>
            <td>19001900</td>
            <td>Hue</td>
            <td>a@gmail.com</td>
            <td>No</td>
            <td>No</td>
            <td><a href="#"><img src="img/edit.png" alt="" title="" border="0" /></a></td>
            <td><a href="#"><img src="img/trash.gif" alt="" title="" border="0" /></a></td>
        </tr>
    	<tr class="even">
        	<td><input type="checkbox" name="" /></td>
            <td>User4</td>
            <td>19001900</td>
            <td>Hue</td>
            <td>a@gmail.com</td>
            <td>No</td>
            <td>No</td>
            <td><a href="#"><img src="img/edit.png" alt="" title="" border="0" /></a></td>
            <td><a href="#"><img src="img/trash.gif" alt="" title="" border="0" /></a></td>
        </tr>
    	
    	
    	
    	
        
    </tbody>
</table>

	<div class="form_sub_buttons">
	<a href="#" class="button green">Sửa Lựa Chọn</a>
    <a href="#" class="button red">Xóa Lựa Chọn</a>
    </div> -->
    
    <ul  class="tabsmenu">
        <li class="active"><a href="indexAdmin">Thông Tin Admin</a></li>
        <li><a href="changePasswordAdmin">Đổi Mật Khẩu</a></li>
        <!-- <li><a href="#tab2">Tab two</a></li>
        <li><a href="#tab3">Tab three</a></li>
        <li><a href="#tab4">Tab four</a></li> -->
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
    <!--   <div id="tab2" class="tabcontent">
        <h3>Tab two title</h3>
        <ul class="lists">
        <li>Consectetur adipisicing elit  error sit voluptatem accusantium doloremqu sed</li>
        <li>Sed do eiusmod tempor incididunt</li>
        <li>Ut enim ad minim veniam is iste natus error sit</li>
        <li>Consectetur adipisicing elit sed</li>
        <li>Sed do eiusmod tempor  error sit voluptatem accus antium dolor emqu incididunt</li>
        <li>Ut enim ad minim veniam</li>
        <li>Consectetur adipisi  error sit voluptatem accusantium doloremqu cing elit sed</li>
        <li>Sed do eiusmod tempor in is iste natus error sit cididunt</li>
        <li>Ut enim ad minim ve is iste natus error sitniam</li>
        </ul>
    </div>

  <div id="tab3" class="tabcontent">
        <h3>Tab three title</h3>
        <p>
    Lorem ipsum <a href="#">dolor sit amet</a>, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. <br /><br />Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?
        </p>
    </div> 
    
    <div id="tab4" class="tabcontent">
        <h3>Tab four title</h3>
        <p>
    Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, ad <br /><br />Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?
        </p>
    </div>  -->
     
    

    
       <!--  <div class="toogle_wrap">
            <div class="trigger"><a href="#">Toggle with text</a></div>

            <div class="toggle_container">
			<p>
        Lorem ipsum <a href="#">dolor sit amet</a>, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Lorem ipsum <a href="#">dolor sit amet</a>, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
			</p>
            </div>
        </div> -->
      
     </div>
     </div><!-- end of right content-->
                     
                    
    <!--  <div class="sidebar" id="sidebar">
    <h2>Browse categories</h2>
    
        <ul>
            <li><a href="#" class="selected">Main page</a></li>
            <li><a href="#">Template settings</a></li>
            <li><a href="#">Add page</a></li>
            <li><a href="#">Edit section</a></li>
            <li><a href="#">Templates</a></li>
            <li><a href="#">Clients</a></li>
        </ul>
        
    <h2>Page Section</h2>
    
        <ul>
            <li><a href="#">Edit section</a></li>
            <li><a href="#">Templates</a></li>
            <li><a href="#">Clients</a></li>
            <li><a href="#">Docs and info</a></li>
        </ul> 
        
    <h2>User Settings</h2>
    
        <ul>
            <li><a href="#">Edit user</a></li>
            <li><a href="#">Add users</a></li>
            <li><a href="#">Manage users</a></li>
            <li><a href="#">Help</a></li>
        </ul>   
         
    <h2>Text Section</h2> 
    <div class="sidebar_section_text">
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
    </div>         
    
    </div>  -->           
    
    
    <div class="clear"></div>
    </div> <!--end of center_content-->
    
    <div class="footer">
	Designed by <a href="https://www.facebook.com/PhanNam2433" target="_blank">PTN</a>
</div>

</div>

    	
</body>
</html>