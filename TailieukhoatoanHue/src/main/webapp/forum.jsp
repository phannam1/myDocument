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
<link rel="stylesheet" type="text/css" href="css/admin.css" />

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
										<span class="fa fa-phone">19001900</span>

									</div>
									<div class="aa-email hidden-xs">
										<span class="fa fa-envelope-o"></span>KhoaToanDHKHHue@gmail.com
									</div>
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<div class="aa-header-right">
									<p id="account">${account.accountId}</p>
									<p id="admin">${account.roleId}</p>
									<p id="show2">Xin Chào: ${account.name}</p>
									<a id="show" href="<%=request.getContextPath()%>/Infor"><i class="fa fa-cog"></i>
										Cài Đặt </a> <a id="show1"
										href="<%=request.getContextPath()%>/Logout"><i class="fa fa-sign-out" aria-hidden="true"></i>Đăng Xuất</a>
										<a id="showAdmin"
										href="indexAdmin"><i class="fa fa-user"></i>Quản trị viên</a> <a
										id="hide" href="register.jsp"><i class="fa fa-user-plus"></i>Đăng Ký</a>
									<a id="hide1" href="signin.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i>Đăng Nhập</a>

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
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!-- LOGO -->
					<!-- Text based logo -->
					<!-- <a class="navbar-brand aa-logo" href="<%=request.getContextPath()%>/index"> Home <span>Property</span></a> -->
					<!-- Image based logo -->
					<!-- <a class="navbar-brand aa-logo-img" href="<%=request.getContextPath()%>/index"><img src="img/logo.png" alt="logo"></a> -->
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
						<li class="active"><a
							href="<%=request.getContextPath()%>/forum">DIỄN ĐÀN </a> <!-- <ul class="dropdown-menu" role="menu">                
                <li><a href="blog-archive.html">BLOG</a></li>
                <li><a href="blog-single.html">BLOG DETAILS</a></li>                                            
              </ul> --></li>
						<li><a href="<%=request.getContextPath()%>/contact">LIÊN
								HỆ</a></li>
						<li><a href="<%=request.getContextPath()%>/help">PHẢN HỒI</a></li>
						<div class="dropdown1">
						<li class="dropbtn1"><a>TẢI TÀI LIỆU
								 </a>	
								<div class="dropdown-content1">
									<a style="color: blue;" href="<%=request.getContextPath()%>/uploadDocument">Upload</a> <a style="color: blue;" href="yourDocument">Tài liệu của bạn</a>
								</div>
							
							</li>
							</div>
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
					<img src="img/slider/2.PNG" alt="img">
				</div>
			</div>
		</div>
	</section>
	<!-- End Proerty header  -->
	<section id="aa-latest-blog">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-latest-blog-area">
						<div class="aa-title">
							<h2>Cộng đồng sinh viên khoa toán DHKH Huế</h2>
							<span></span>
							<div >
								<div id="navbar" class="navbar-collapse collapse"></div>										
								<div style="text-align: left; padding-left: 10px;" >
								<div class="menu">
				<ul>
					<li><a href="<%=request.getContextPath()%>/forum" class="selected" style="size: 100px;">Câu hỏi gần đây</a></li>
					
					<li><a href="question">Câu hỏi của bạn</a></li>
					
				</ul>
			</div>
		
<div class="center_content">

			<div id="right_wrap">
				<div id="right_content">
				
					<div class="search_Forum">
					<form action="">
					<input class="input_Forum" type="text" value ="" name = "inputValueSearch">
					<input class="submit_Forum" type="submit" value="Tìm kiếm">
					
					
					</form>
					</div>
					<h2>Diễn Đàn Khoa Toán</h2>
				
					<table id="rounded-corner">
						<thead>
							<tr>
								
								<th>UserName(<i class="fa fa-user"></i>)</th>
								<th>Câu Hỏi(<i class="fa fa-question"></i>)</th>
								<th>Câu trả lời(<i class="fa fa-comment"></i>)</th>
								<th>Câu trả lời khác(<i class="fa fa-comment"></i>)</th>
								<th>Ngày Tháng(<i class="fa fa-clock-o"></i>)</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="12">Diễn Đàn Khoa Toán!</td>
							</tr>
						</tfoot>
						<tbody>
							<tr class="odd">
								
								<td>user4</td>				
								<td>1+1 = ?</td>
							<td>2 </td>
							<td><a href="<%=request.getContextPath()%>/answer">	5 Câu trả lời khác(Xem thêm)</a></td>
									<td>04/03/2019 </td>
							</tr>
							<tr class="even">
								<td>2</td>
								<td>user4</td>				
								<td>1+1 = ?</td>
								<td>2 </td>
							<td><a href="<%=request.getContextPath()%>/answer">	5 Câu trả lời khác (Xem thêm)</a></td>
							<td>04/03/2019 </td>
							
							</tr>
							<tr class="odd">
								<td>3</td>
								<td>user4</td>				
								<td>1+1 = ?</td>
								<td>2 </td>
							<td><a href="<%=request.getContextPath()%>/answer">	5 Câu trả lời khác (Xem thêm)</a></td>
									<td>04/03/2019 </td>
							</tr>
							<tr class="even">
								<td>4</td>
								<td>user4</td>				
								<td>1+1 = ?</td>
							<td>2 </td>
							<td><a href="<%=request.getContextPath()%>/answer">	5 Câu trả lời khác (Xem thêm)</a></td>
								<td>04/03/2019 </td>
							</tr>
							<tr class="odd">
								<td>5</td>
								<td>user4</td>				
								<td>1+1 = ?</td>
								<td>2 </td>
							<td><a href="<%=request.getContextPath()%>/answer">	5 Câu trả lời khác (Xem thêm)</a></td>
									<td>04/03/2019 </td>
							</tr>
							<tr class="odd">
								<td>6</td>
								<td>user4</td>				
								<td>1+1 = ?</td>
								<td>2 </td>
							<td><a href="<%=request.getContextPath()%>/answer">	5 Câu trả lời khác (Xem thêm)</a></td>
								<td>04/03/2019 </td>
							</tr>





						</tbody>
					</table>
			<div class="clear"></div>
		</div>
		</div>
		
										<label style="margin-top: 10px;">Đặt câu hỏi ngay:<form action="#">
					<input style="border: 1px solid #ccc !important;" class="input_Forum" type="text" value ="" name = "inputValueSearch">
					<input  style="border: 1px solid #ccc !important;" class="submit_Forum" type="submit" value="Xác Nhận">
					
					
					</form>
					</label>
											<div class="aa-properties-content-bottom">
												<nav>
													<ul class="pagination">
														<li><a><button id="btn_first1"
																	onClick="firstPage(this.id)">Đầu Trang</button></a> <a><button
																	id="btn_prev1" onClick="prevPage(this.id)">Trang
																	Trước</button></a></li>
														<li class="active" id="6"><a><button
																	id="btn_next11" onClick="clickPage1(this.id)">1</button></a></li>
														<li id="7"><a><button id="btn_next22"
																	onClick="clickPage2(this.id)">2</button></a></li>
														<li id="8"><a><button id="btn_next33"
																	onClick="clickPage3(this.id)">3</button></a></li>
														<li id="9"><a><button id="btn_next44"
																	onClick="clickPage4(this.id)">4</button></a></li>
														<li id="10"><a><button id="btn_next55"
																	onClick="clickPage5(this.id)">5</button></a></li>
														<li><a><button id="btn_next111"
																	onClick="nextPage(this.id)">Trang Kế</button></a> <a><button
																	id="btn_last1" onClick="lastPage(this.id)">Cuối
																	Trang</button></a></li>
													</ul>
												</nav>
											</div>
										
									</div>
								</div>
							
									</div>

						</div>
					</div>
				</div>
				
			</div>
		</div>
	</section>
	<!-- Start Blog  -->
          
    
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
	<!-- Price picker slider -->
	<script type="text/javascript" src="js/nouislider.js"></script>
	<!-- mixit slider -->
	<script type="text/javascript" src="js/jquery.mixitup.js"></script>
	<!-- Add fancyBox -->
	<script type="text/javascript" src="js/jquery.fancybox.pack.js"></script>
	<!-- Custom js -->
	<script src="js/custom.js"></script>
	<script type="text/javascript" src="js/pagination.js"></script>
	<!-- add pagination js -->
	<script type="text/javascript" src="js/login.js"></script>
</body>
</html>