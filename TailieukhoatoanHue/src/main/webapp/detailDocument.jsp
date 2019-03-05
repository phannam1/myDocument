<!DOCTYPE html>
<html lang="en">
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
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
<body class="aa-price-range">
	<!-- Pre Loader -->
	<div id="aa-preloader-area">
		<div class="pulse"></div>
	</div>
	<!-- SCROLL TOP BUTTON -->
	<a class="scrollToTop" href="#"><i class="fa fa-angle-double-up"></i></a>
	<!-- END SCROLL TOP BUTTON -->

	<!-- Start header section -->
	<header id="aa-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-header-area">
						<div class="row">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<div class="aa-header-left">
									<div class="aa-telephone-no">
										<span class="fa fa-phone"></span>

									</div>
									<div class="aa-email hidden-xs">
										<span class="fa fa-envelope-o"></span> @gmail.com
									</div>
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<div class="aa-header-right">
									<p id="account">${account.accountId}</p>
									<p id="show2">Xin Chào : ${account.name}</p>
									<a id="show" href="<%=request.getContextPath()%>/Infor"">
										Thông Tin </a> <a id="show1"
										href="<%=request.getContextPath()%>/Logout">Đăng Xuất</a> <a
										id="hide" href="register.jsp" class="aa-register">Đăng Ký</a>
									<a id="hide1" href="signin.jsp" class="aa-login">Đăng Nhập</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- End header section -->

	<!-- Start menu section -->
	<section id="aa-menu-area">
		<nav class="navbar navbar-default main-navbar" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<!-- FOR MOBILE VIEW COLLAPSED BUTTON -->
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>

				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul id="top-menu" class="nav navbar-nav navbar-right aa-main-nav">
						<li><a href="<%=request.getContextPath()%>/index">TRANG
								CHỦ</a></li>
						<li><a href="<%=request.getContextPath()%>/introduce">GIỚI
								THIỆU</a></li>
						<li><a href="<%=request.getContextPath()%>/document">TÀI
								LIỆU <!-- <span class="caret"></span> -->
						</a> <!-- <ul class="dropdown-menu" role="menu">                
                <li><a href="properties.html">PROPERTIES</a></li>
                <li><a href="properties-detail.html">PROPERTIES DETAIL</a></li>                                            
              </ul> --></li>
						<li><a href="<%=request.getContextPath()%>/event">SỰ KIỆN</a></li>
						<li><a href="<%=request.getContextPath()%>/forum">DIỄN
								ĐÀN </a> <!-- <ul class="dropdown-menu" role="menu">                
                <li><a href="blog-archive.html">BLOG</a></li>
                <li><a href="blog-single.html">BLOG DETAILS</a></li>                                            
              </ul> --></li>
						<li><a href="<%=request.getContextPath()%>/contact">LIÊN
								HỆ</a></li>
						<li><a href="<%=request.getContextPath()%>/help">PHẢN HỒI</a></li>
						<li><a href="<%=request.getContextPath()%>/uploadDocument">UPLOAD
								TÀI LIỆU</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
	</section>
	<!-- End menu section -->

	<!-- Start slider  -->
	<section id="aa-slider">
		<div class="aa-slider-area">
			<!-- Top slider -->
			<div class="aa-top-slider">
				<!-- Top slider single slide -->
				<div class="aa-top-slider-single">
					<img src="img/slider/9.jpg" alt="img">
				</div>
			</div>
		</div>
	</section>
	<!-- End Proerty header  -->

	<section id="aa-properties">
		<div class="container">
			<div class="row">
				<div class="col-md-7">
					<div class="aa-properties-content">
						<!-- start properties content head -->
						<div class="aa-properties-content-head">
							<div class="aa-properties-content-head-left1">
								<form action="" class="aa-sort-form">
									<label>Hàm Biến Phức</label>
								</form>

							</div>
							<ul>
								<li>
									<article class="aa-properties-item1">
										<a class="aa-properties-item-img1"> <img
											src="data/hambienphuc/document1.jpg" alt="img">
										</a>

										<div class="aa-properties-item-content">

											<div class="aa-properties-about">
												<h3>
													<a>Hàm Biến Phức</a>
												</h3>
												<p>Hàm Biến Phức</p>
											</div>
											<div class="aa-properties-detial">
												<a href="#" class="aa-secondary-btn1">tải xuống </a>

											</div>
											<div class="aa-properties-detial">
												<a href="document" class="aa-secondary-btn2">Quay lại </a>

											</div>
										</div>
									</article>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- Start properties sidebar -->
				<div class="col-md-5">
					<aside class="aa-properties-sidebar">
						<!-- Start Single properties sidebar -->
						<div class="aa-properties-single-sidebar">
							<h3>Thông tin chi tiết Tài Liệu</h3>

						</div>
						<div class="detail_Document">
							<div>
								<label>HÀM BIẾN PHỨC</label>
							</div>
							<div>
								<label>THUỘC KHOA TOÁN</label>
							</div>

							<div>
								<label>Bộ môn: ${document}</label>
							</div>

							<div>
								<label>Số tín chỉ:${document}</label>
							</div>
							<div>
								<label>Giáo viên giảng dạy:${document}</label>
							</div>
							<div>
								<label>Độ khó: 7/10</label>
							</div>
							<div>
								<label>Học Kỳ:${document}</label>
							</div>

							<div>
								<label>Loại file:${document}</label>
							</div>
						</div>

					</aside>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer id="aa-footer">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-footer-area">
						<div class="row">
							<div class="col-md-3 col-sm-6 col-xs-12">
								<div class="aa-footer-left">
									<p>
										Designed by <a rel="nofollow"
											href="https://www.facebook.com/PhanNam2433">PTN</a>
									</p>
								</div>
							</div>
							<div class="col-md-3 col-sm-6 col-xs-12">
								<div class="aa-footer-middle">
									<a href="https://www.facebook.com/PhanNam2433"><i
										class="fa fa-facebook"></i></a> <a
										href="https://twitter.com/Phantha27859524"><i
										class="fa fa-twitter"></i></a>
								</div>
							</div>
							<div class="col-md-6 col-sm-12 col-xs-12">
								<div class="aa-footer-right">
									<a href="<%=request.getContextPath()%>/index">Trang Chủ</a> <a
										href="<%=request.getContextPath()%>/contact">Liên Hệ</a> <a
										href="<%=request.getContextPath()%>/forum">Diễn Đàn</a> <a
										href="<%=request.getContextPath()%>/document">Tài Liệu</a>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- / Footer -->

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