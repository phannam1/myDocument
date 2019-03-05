<!DOCTYPE html>
<html lang="en">
<%@ page isELIgnored="false"%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Tài Liệu Khoa Toán DHKH Huế</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="img/T.PNG" type="image/x-icon">
    
    
    <!-- Font awesome -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">   
    <!-- slick slider -->
    <link rel="stylesheet" type="text/css" href="css/slick.css">
    <!-- price picker slider -->
    <link rel="stylesheet" type="text/css" href="css/nouislider.css">
    <!-- Fancybox slider -->
    <link rel="stylesheet" href="css/jquery.fancybox.css" type="text/css" media="screen" /> 
    <!-- Theme color -->
    <link id="switcher" href="css/theme-color/default-theme.css" rel="stylesheet">     

    <!-- Main style sheet -->
    <link href="css/style.css" rel="stylesheet">    

   
    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Vollkorn' rel='stylesheet' type='text/css'>    
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  

  </head>
  <body>   
  <section id="aa-signin">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-signin-area">
           <a style="float: right;font-size: 30px" href="<%=request.getContextPath()%>/index"><i class="fa fa-times" aria-hidden="true"></i></a>
            <div class="aa-signin-form">
              <div class="aa-signin-form-title">
              
                <h4>Điền Thông Tin Đăng Ký</h4>
              </div>
              <form class="contactform" method="post" action="<%=request.getContextPath()%>/register"> 
              <div class="aa-single-field">
                  <label for="name">Tên Của Bạn <span class="required">*</span></label>
                  <input  id = "name" type="text" required="required" aria-required="true" value="" name="name" placeholder="YourName" onmousemove="checkValudationRegister(this.id)">
                 <p id="checkNullName"> Tên của bạn không được trống</p>
                </div> 
              <div class="aa-single-field">
                  <label for="name"> Tài Khoản <span class="required">*</span></label>
                  <input id ="taikhoan" type="text" required="required" aria-required="true" value="" name="userName" placeholder="UserName" onmousemove="checkValudationRegister(this.id)">
                   <p id="checkNulltk"> Tài khoản không được trống</p>
                </div>                                                                           
                <div class="aa-single-field">
                  <label >Mật Khẩu <span class="required">*</span></label>
                  <input id = "matkhau" style="width: 35%" id="matkhau" type="password" name="password" value="" placeholder="password" onmousemove="checkValudationRegister(this.id)"> 
               
                  <label >Xác Nhận lại mật khẩu <span class="required">*</span></label>
                  <input style="width: 36%" id="confirmmatkhau" type="password" name="confirmpassword" value="" placeholder="RetryPassword" onmousemove="checkValudationRegister(this.id)"> 
                  <p id="checkMore6">Mật khẩu phải từ 6 ký tự trở lên</p>
                  <p id="checkNullConfirm"> Mật khẩu phải giống nhau</p>
                </div>
                <div class="aa-single-field">
                  <label for="email">Email <span class="required">*</span></label>
                  <input id = "email" type="email" required="required" aria-required="true" value="" name="email" placeholder="Email" onmousemove="validateEmail(this.id)">
                   <p id="checkNullEmail"> Email phải đúng định dạng</p>
                </div> 
                <div class="aa-single-submit">
                  <input type="submit" value="Đăng Ký" name="submit">                                    
                </div>
              </form>             
            </div>
          </div>
        </div>
      </div>
    </div>
  </section> 


  <!-- jQuery library -->
  <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
  <script src="js/jquery.min.js"></script>   
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.js"></script>   
  <!-- slick slider -->
  <script type="text/javascript" src="js/slick.js"></script>
  <!-- Price picker slider -->
  <script type="text/javascript" src="js/nouislider.js"></script>
   <!-- mixit slider -->
  <script type="text/javascript" src="js/jquery.mixitup.js"></script>
  <!-- Add fancyBox -->        
  <script type="text/javascript" src="js/jquery.fancybox.pack.js"></script>
  <!-- Custom js -->
  <script src="js/custom.js"></script> 
<script type="text/javascript" src="js/validationInput.js"></script>
  </body>
</html>