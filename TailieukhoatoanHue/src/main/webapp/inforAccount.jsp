<!DOCTYPE html>
<html lang="en">
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<link rel="stylesheet" href="css/jquery.fancybox.css" type="text/css"
	media="screen" />
<!-- Theme color -->
<link id="switcher" href="css/theme-color/default-theme.css"
	rel="stylesheet">

<!-- Main style sheet -->
<link href="css/style.css" rel="stylesheet">


<!-- Google Font -->
<link href='https://fonts.googleapis.com/css?family=Vollkorn'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>


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
						<a style="float: right; font-size: 30px"
							href="<%=request.getContextPath()%>/index"><i
							class="fa fa-times" aria-hidden="true"></i></a>
						<div class="aa-signin-form">
							<a href="changePassword.jsp">Đổi Mật Khẩu </a>
							<div class="aa-signin-form-title">
								<a href="#"><img
									style="float: right; color: blue; width: 100px; height: 100px"
									src="${account.avatar}" alt="Avatar"></a>
								<h4>Cập Nhật Thông Tin Của Bạn</h4>
							</div>

							<form class="contactform" action="update" method="post">
								<div class="aa-single-field">
									<label for="name">Xin Chào :<span style="color: red">
											${account.name}</span></label>

								</div>
								<div id="checkValue" class="aa-single-field">
									<label>Mật Khẩu Cấp 2 Của Bạn : <span class="required"></span></label>
									<input id="matkhau" type="password" name="passwordLevel2"
										value="${account.passwordLevel2}" placeholder="passwordLevel2"
										onmousemove="checkValudationInfor(this.id)">
									<p id="checkMore6">Mật khẩu phải từ 6 ký tự trở lên</p>
									<label>Xác Nhận mật khẩu cấp 2: <span class="required"></span></label>
									<input id="confirmmatkhau" type="password"
										name="confirmpassword" value="${account.passwordLevel2}" placeholder="RetryPassword"
										onmousemove="checkValudationInfor(this.id)">
									<p id="checkNullConfirm">Mật khẩu phải giống nhau</p>
								</div>
								<div id="questionAndAnswer" class="aa-single-field">
									<label>Câu hỏi bảo mật Của Bạn : <span class="required"></span></label>
									<div class="aa-single-advance-search">
										<select name="Question" id="mySelect"
											style="width: 100%; height: 35px;">
											<option value="" selected></option>
											<option value="Tên của bạn">Tên của bạn</option>
											<option value="Địa chỉ của bạn">Địa chỉ của bạn</option>
											<option value="Con vật bạn thích">Con vật bạn thích</option>
											<option value="Con vật bạn ghét">Con vật bạn ghét</option>
										</select>
									</div>
									<label for="answer">Câu trả lời bảo mật của bạn : <span
										class="required"></span></label> <input id="answer" type="text"
										aria-required="true" value="${account.answerSecurity}"
										name="answer" placeholder="answer">
									   <p style="color: red" id="error" >${error}</p>
               							<c:remove var="error" scope="session" />
								</div>

								<div class="aa-single-field">
									<label>Địa chỉ : <span class="required"></span></label> <input
										id="mk" type="text" aria-required="true"
										value="${account.address}" name="address"
										placeholder="address"
										onmousemove="checkValudationInfor(this.id)">

								</div>
								<div class="aa-single-field">
									<label>Điện thoại: <span class="required"></span></label> <input
										type="text" aria-required="true" value="${account.phone}"
										name="phone" placeholder="phone">

								</div>
								<div class="aa-single-field">
									<label for="email">Email <span class="required"></span></label>
									<input id="email" type="email" aria-required="true"
										value="${account.email}" name="email" placeholder="email">
									<p id="checkNullEmail" onmousemove="validateEmail(this.id)">
								</div>
								<div class="aa-single-submit">
									<input type="submit" value="Cập Nhật " name="submit">
								</div>
							</form>




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
	<script type="text/javascript" src="js/checkValueInfor.js"></script>
	<script type="text/javascript" src="js/onchange.js"></script>
</body>
</html>