
<!DOCTYPE html>
<html>
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Upload File</title>

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
							<div class="aa-signin-form-title">
								<h4>UPLOAD TÀI LIỆU CỦA BẠN</h4>
							</div>
							<form class="contactform" method="post"
								action="<%=request.getContextPath()%>/upload"
								enctype="multipart/form-data">
								<div class="aa-single-field">
									<label for="name" >Tên tài liệu: <span class="required">*</span></label>
									<input id="name" type="text" required="required"
										aria-required="true" value="" name="nameDocument"
										placeholder="NameDocument"
										onmousemove="checkValudationRegister(this.id)">
									<p id="checkNullName">Tên của bạn không được trống</p>
								</div>
								<div class="aa-single-field">
									<label> Ngành Học: <span class="required">*</span></label>
									<div class="aa-single-advance-search">
										<select name="Question" style="width: 100%; height: 35px;">
											<option value="0" selected>Toán Học</option>
											<option value="1">Toán Ứng Dụng</option>

										</select>
									</div>
								</div>
								<div class="aa-single-field">
									<label>Kỳ Học: <span class="required">*</span></label>
									<div class="aa-single-advance-search">
										<select name="Question" style="width: 100%; height: 35px;">
											<option value="0" selected>Kỳ 1</option>
											<option value="1">Kỳ 2</option>
											<option value="2">Kỳ 3</option>
											<option value="3">Kỳ 4</option>
											<option value="4">Kỳ 5</option>
											<option value="2">Kỳ 6</option>
											<option value="3">Kỳ 7</option>

										</select>
									</div>
								</div>
								<div class="aa-single-field">
									<label>Chuyên Ngành: <span class="required">*</span></label>
									<div class="aa-single-advance-search">
										<select name="Question" style="width: 100%; height: 35px;">
										<option value="0" selected>Xác Suất Thống Kê</option>
										<option value="1">Tối Ưu</option>
										<option value="2">Ứng Dụng</option>

										</select>
									</div>
								</div>
								<div class="aa-single-field">
									<label>Số Tín Chỉ: <span class="required">*</span></label>
									<div class="aa-single-advance-search">
										<select name="Question" style="width: 100%; height: 35px;">
										<option value="0" selected>2 Tín Chỉ</option>
										<option value="1">3 Tín Chỉ</option>
										<option value="2">4 Tín Chỉ</option>

										</select>
									</div>
								</div>
								<div class="aa-single-field">
									<label>Kiểu dữ liệu: <span class="required">*</span></label>
									<div class="aa-single-advance-search">
										<select  name="fileExtension" style="width: 100%; height: 35px;">
										<option value="0" selected>.pdf</option>
										<option value="1">.img</option>
										<option value="2">.png</option>

										</select>
									</div>
								</div>
								<div class="aa-single-field">
									<label for="name">Tên Giảng Viên Phụ Trách: <span class="required"></span></label>
									<input id="name" type="text" 
										aria-required="true" value="" name="name"
										placeholder="TeacherName"
										onmousemove="checkValudationRegister(this.id)">
									<p id="checkNullName">Tên của bạn không được trống</p>
								</div>
								
									
										
										<div class="aa-single-field">
									<label for="name">Lựa chọn tài liệu của bạn: <span class="required">*</span></label>
										 <input required="required"   type="file" name="file"
											multiple>
									
									<div class="aa-single-submit">
									<input type="submit" value="UPLOAD" class="aa-browse-btn"
										name="submit">
								</div>
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
	<script type="text/javascript" src="js/login.js"></script>
	<!-- Price picker slider -->
	<script type="text/javascript" src="js/nouislider.js"></script>
	<!-- mixit slider -->
	<script type="text/javascript" src="js/jquery.mixitup.js"></script>
	<!-- Add fancyBox -->
	<script type="text/javascript" src="js/jquery.fancybox.pack.js"></script>
	<!-- Custom js -->
	<script src="js/custom.js"></script>

</body>
</html>