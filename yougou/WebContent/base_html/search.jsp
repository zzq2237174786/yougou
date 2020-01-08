<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品搜索</title>
		<!--移动端优先-->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/pro_type.css" />
		<script type="text/javascript" src="/yougou/js/jquery.min.js"></script>
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
						<a href="/yougou/base_html/register.jsp" id="register-btn">注册</a>
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
							<input type="text" id="searchVal"/>
							<a href="javaScript:;" id="search"><span></span></a>
						</div>
					   </div>

					<!--导航条下的内容-->
					<div class="nav-content" id="nav-content">
						<!--分类下的内容-->
					</div>
				</div>
			</div>

		</div>

		<hr/>
		<!--分类-->
		<div class="type">
			<div class="container">
				<!--分类标签 面包屑-->
				<div class="row type-title">
					<ul class="breadcrumb">
						<li>
							<a href="javaScript:;" style="font-size:16px;" id="show">搜索</a>
						</li>
					</ul>			
				</div>

				<!--分类导航和内容-->
				<div class="row">					
					<!--右边的内容-->
						<!--产品-->
						<div class="type-content-product">
						<ul class="ul-product" id="ul-product" style="margin: 0 auto;">
								
					    </ul>
					</div>

				</div>

				<!--分页-->
				<div class="row  type-page">
					<div class="pagination"></div>
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
<script type="text/javascript" src="/yougou/js/bootstrap.js"></script>
<script type="text/javascript" src="/yougou/js/ydxLazyLoad.js"></script>
<script type="text/javascript" src="/yougou/js/jquery.pagination.js"></script>
<script src="/yougou/js/base.js"></script>
<script src="/yougou/js/search.js"></script>