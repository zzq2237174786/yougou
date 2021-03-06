<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<!--移动端优先-->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/base.css" />
		<link rel="stylesheet" href="/yougou/css/index.css" />
	</head>

	<body>
		<!--头部-->
		<div class="header">
			<!--导航条 通栏-->
			<nav class="navbar navbar-inverse">
				<!--左边导航条-->
				<ul class="nav navbar-nav navbar-left">
					<!--attention 关注-->
					<li>
						<a href="javaScript:;" class="attention">关注</a>
						<!--二维码-->
						<div class="attention-code">
							<div class="code">
								<img src="/yougou/img/weChat.jpg" />
								<span class="title">关注公众号</span>
							</div>
						</div>
					</li>
					<!--app-->
					<li>
						<a href="javaScript:;" class="app">下载APP</a>
						<!--二维码-->
						<div class="app-code">
							<div class="code">
								<img src="/yougou/img/app.jpg" />
								<span class="title">优购APP下载</span>
							</div>
						</div>
					</li>
				</ul>

				<!--右边的导航条-->
				<ul class="nav navbar-nav navbar-right">
					<!--登录注册-->
					<li>
						<a href="/yougou/base_html/login.jsp" id="login-btn">登录</a>
						<span id="username"></span>
						<p>/</p>
						<a href="/yougou/base_html/regist.jsp" id="register-btn">注册</a>
						<a href="javaScript:;" id="exit-btn">退出</a>
					</li>
					<!--收藏-->
					<li id="collect-btn">
						<a href="/yougou/power_html/collect_order.jsp">
							<span class="glyphicon glyphicon-heart"></span> 收藏
						</a>
					</li>
					<!--购物袋-->
					<li id="cart-btn">
						<a href="/yougou/power_html/login_cart.jsp">
							<span class="glyphicon glyphicon-shopping-cart"></span> 购物车
						</a>
					</li>
					<!--公告-->
					<li class="affiche">
						<a href="javaScript:;">公告</a>
					</li>
				</ul>
			</nav>
		</div>

		<!--logo 广告条-->
		<div class="logo">
			<!--logo 和 导航-->
			<div class="container">
				<!--logo-->
				<div class="row">
					<div class="col-md-2 col-md-offset-5 logo-header">
						<a href=""><img src="/yougou/img/logo.png" /></a>
					</div>
				</div>
			</div>

			<!--logo下的分类-->
			<div class=" logo-nav">
				<div class="container">
					<div class="row">
						<!--导航条-->
						<div class="col-md-10">
							<nav class="navbar ">
								<ul class="nav navbar-nav" id="nav-type">
									<li class="nav-log">
										<a href=""><img src="/yougou/img/nav-logo.png" /></a>
									</li>
									<li>
										<a href="/yougou/base_html/index.jsp">首页</a>
									</li>
									<!--分类-->
								</ul>
							</nav>
						</div>

						<!--搜索框 logo-serach-->
						<div class="col-md-2 logo-search">
							<input type="text" />
							<a href=""><span></span></a>
						</div>
					</div>

					<!--导航条下的内容-->
					<div class="nav-content" id="nav-content">
						<!--分类下的内容-->
					</div>
				</div>
			</div>

		</div>

		<!--大广告图-->
		<div class="big-banner">
			<!--两个大的广告图-->
			<a href="/yougou/base_html/pro_type.jsp?cat_id=101" class="big-banner-active"><img src="/yougou/img/banner1.jpg" /></a>
			<a href="/yougou/base_html/pro_type.jsp?cat_id=112"><img src="/yougou/img/banner2.jpg" /></a>
			<ul class="banner-point">
				<!--两个小方形-->
				<li class="banner-active"></li>
				<li class=></li>
			</ul>
		</div>

		<!--新品推荐-->
		<div class="new-product">
			<div class="container text-center">
				<!--标题-->
				<div class="row title">
					<h1>新品推荐</h1>
					<ul>
						<li>
							<a href="javaScript:;" class="title-active">男女鞋</a>
						</li>
						<li>
							<a href="javaScript:;">运动</a>
						</li>
					</ul>
				</div>

				<!--新品轮播图-->
				<div class="row new-product-slideshow">
					<!--两个小箭头-->
					<a class="new-next" href="javaScript:;"></a>
					<a class="new-prev" href="javaScript:;"></a>
					<!--轮播图1-->
					<div class="slideshow-banner newSlideshow">
						<ul id="newSildeshow1">
							<!--内容1-->
						</ul>
						<div class="modal fade in" data-backdrop="static" id="collect-modal">
							<div class="modal-dialog">
								<div class="modal-content">
									
								</div>
							</div>
						</div>
					</div>
					<!--轮播图2-->
					<div class="newSlideshow">
						<ul id="newSildeshow2">
							<!--内容1-->
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!--今日主推大牌-->
		<div class="recommend">
			<div class="container text-center">
				<!--标题-->
				<div class="row title">
					<h1>今日主推大牌</h1>
					<ul>
						<li>
							<a href="javaScript:;" class="title-active">男女鞋</a>
						</li>
						<li>
							<a href="javaScript:;">运动</a>
						</li>
					</ul>
				</div>

				<!--内容-->
				<div class="row recommend-content">
					<!--今日大牌下的图片-->
					<!--男女服-->
					<div class="recommend-brands">
						<ul class="recommend-brands-imgbox " id="recommend-brands1">
						</ul>
					</div>
					<!--运动风-->
					<div>
						<ul class="recommend-brands-imgbox" id="recommend-brands2">
						</ul>
					</div>
				</div>

				<!--品牌轮播-->
				<div class="row recommend-solideshow">
					<!--两个小箭头-->
					<a class="recommend-next" href="javaScript:;"></a>
					<a class="recommend-prev" href="javaScript:;"></a>
					<div class="recommend-banner">
						<ul class="solideshow">
							<li>
								<a href=""><img src="/yougou/img/recommend-slide1.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide2.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide3.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide4.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide1.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide2.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide3.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide4.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide1.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide2.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide3.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide4.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide1.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide2.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide3.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide4.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide1.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide2.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide3.png" /></a>
							</li>
							<li>
								<a href=""><img src="/yougou/img/recommend-slide4.png" /></a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!--品牌潮流资讯-->
		<div class="fashion">
			<div class="container text-center">
				<!--标题-->
				<div class="row title">
					<h1>品牌潮流资讯</h1>
					<h4>BRAND FASHION</h4>
				</div>

				<!--第一行内容-->
				<div class="row">
					<ul class="fashion-content1">
						<li>
							<video class="video" controls src="/yougou/img/bai_li.mp4"></video>
							<img src="/yougou/img/bai_li_img.jpg" class="video-img" />
						</li>
						<li>
							<video class="video" controls src="/yougou/img/advertising_video_staccato_20190313.mp4"></video>
							<img src="/yougou/img/si_jia_tu.jpg" class="video-img" />
						</li>
						<li>
							<video class="video" controls src="/yougou/img/bai_li.mp4"></video>
							<img src="/yougou/img/bai_li_img.jpg" class="video-img" />
						</li>
					</ul>
				</div>

				<!--第二行内容-->
				<div class="row">
					<ul class="fashion-content2" id="fashion-content2">
					</ul>
				</div>

				<!--第三行内容-->
				<div class="row">
					<div class="fashion-content3">
						<video class="video" controls src="/yougou/img/video3.mp4"></video>
						<img class="video-img" src="/yougou/img/video3-img.jpg" />
					</div>
				</div>

				<!--第四行内容-->
				<div class="row">
					<div class="fashion-content4">
						<ul id="fashion-content4">
						</ul>
					</div>
				</div>

			</div>
		</div>

		<!--尾部样式-->
		<div class="footer">
			<!--底部1-->
			<div class="footer-feature">
				<div class="container">
					<ul>
						<li class="li-one">
							<span class="footer-img1"></span>
							<a href="javaScript:;">正品保证 </a>
						</li>
						<li>
							<span class="footer-img2"></span>
							<a href="javaScript:;">10天退换货 </a>
						</li>
						<li>
							<span class="footer-img3"></span>
							<a href="javaScript:;">10天调补差价额 </a>
						</li>
						<li>
							<span class="footer-img4"></span>
							<a href="javaScript:;"> 09:00—21:00在线客服</a>
						</li>
					</ul>
				</div>
			</div>

			<!--底部2-->
			<div class="footer-help">
				<div class="container">
					<!--上面部分-->
					<ul class="footer-help-top">
						<li class="li-one">
							<ul>
								<li class="item">
									<a href="javaScript:;">新手帮助</a>
								</li>
								<li>
									<a href="javaScript:;">交易条款协议</a>
								</li>
								<li>
									<a href="javaScript:;">注册新用户</a>
								</li>
								<li>
									<a href="javaScript:;">会员积分详情</a>
								</li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="item">
									<a href="javaScript:;">购物指南</a>
								</li>
								<li>
									<a href="javaScript:;">订单流程</a>
								</li>
								<li>
									<a href="javaScript:;">验货与签收</a>
								</li>
								<li>
									<a href="javaScript:;">订单配送</a>
								</li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="item">
									<a href="javaScript:;">支付/配送</a>
								</li>
								<li>
									<a href="javaScript:;">支付方式</a>
								</li>
								<li>
									<a href="javaScript:;">配送方式</a>
								</li>
								<li>
									<a href="javaScript:;">配送事件及运费</a>
								</li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="item">
									<a href="javaScript:;">售后服务</a>
								</li>
								<li>
									<a href="javaScript:;">退换货政策</a>
								</li>
								<li>
									<a href="javaScript:;">退款说明</a>
								</li>
								<li>
									<a href="javaScript:;">发票制度</a>
								</li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="item">
									<a href="javaScript:;">会员服务</a>
								</li>
								<li>
									<a href="javaScript:;">找回密码</a>
								</li>
								<li>
									<a href="javaScript:;">联系我们</a>
								</li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="item">
									<a href="javaScript:;">优购服务</a>
								</li>
								<li>
									<a href="javaScript:;">在线质询</a>
								</li>
								<li>
									<a href="javaScript:;">Email: ygservice@belle.com.cn</a>
								</li>
								<li>
									<a href="javaScript:;">微信客服：优购时尚商城</a>
								</li>
							</ul>
						</li>
					</ul>
					<!--中间部分-->
					<div class="footer-help-center">
						<ul class="ul-left">
							<li class="li-one">
								<a href="javaScript:;"><img src="/yougou/img/footer-img1.png" /></a>
							</li>
							<li>
								<a href="javaScript:;"><img src="/yougou/img/footer-img2.jpg" /></a>
							</li>
							<li>
								<a href="javaScript:;"><img src="/yougou/img/footer-img3.png" /></a>
							</li>
							<li>
								<a href="javaScript:;"><img src="/yougou/img/footer-img4.png" /></a>
							</li>
						</ul>
						<ul class="ul-right">
							<li>
								<a><img src="/yougou/img/app.jpg" class="ul-right-img1" /></a>
								<a class="a-title">扫描下载手机客户端</a>
							</li>
							<li>
								<a><img src="/yougou/img/weChat.jpg" /></a>
								<a class="a-title">关注公众号</a>
							</li>
						</ul>
					</div>
					<!--下面部分-->
					<div class="footer-help-bottom">
						<div class="friend-link">
							<ul>
								<li class="li-one">
									<a href="javaScript:;">关于优购</a>|</li>
								<li>
									<a href="javaScript:;">集团采购</a>|</li>
								<li>
									<a href="javaScript:;">招纳贤士</a>|</li>
								<li>
									<a href="javaScript:;">手机优购</a>|</li>
								<li>
									<a href="javaScript:;">联系我们</a>|</li>
								<li>
									<a href="javaScript:;">友情连接</a>|</li>
							</ul>
						</div>
						<div class="copy-right">
							<span>Copyright © 2011-2016 Yougou Technology Co., Ltd.</span>
							<a href="javaScript:;">粤ICP备09070608号-4</a>
							<span> 增值电信业务经营许可证：</span>
							<a href="javaScript:;">粤ICP备09070608号-4</a>
							<span>深公网安备：4403101910665</span>
							<a href="javaScript:;"> 粤公网安备 44030502000017号</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	
		<!--返回顶部-->
		<div class="index-back-top">
			<img src="/yougou/img/back-top.png" />
			<p>顶部</p>
		</div>
	</body>

</html>
<!--js-->
<script type="text/javascript" src="/yougou/js/jquery.min.js"></script>
<script type="text/javascript" src="/yougou/js/ydxLazyLoad.js"></script>
<script type="text/javascript" src="/yougou/js/bootstrap.js"></script>
<script src="/yougou/js/index.js"></script>
<script src="/yougou/js/base.js"></script>
