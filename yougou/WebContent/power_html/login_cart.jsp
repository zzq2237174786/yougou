<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登陆后购物车</title>
		<link rel="stylesheet" type="text/css" href="/yougou/css/shop_cart.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/login-cart.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/base.css" />
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
						<a href="/yougou/base_html/login.jsp">
							<span class="glyphicon glyphicon-heart"></span> 收藏
						</a>
					</li>
					<!--购物袋-->
					<li id="cart-btn">
						<a href="/yougou/base_html/login.jsp">
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
		
		<!--顶部-->
		<div class="container">
			<div class="navbar-header">
				<a href="/yougou/base_html/index.jsp"><img src="/yougou/img/logo.png"/></a>
				<img src="/yougou/img/carlogo.jpg" />
			</div>
			<div class="navbar-left">
				<ul class="nav navbar-nav">
					<li class="active">我的购物袋<span class="glyphicon glyphicon-menu-right" id="glyphicon"></sapn></li>
					
					<li class="active1">提交订单中心
					<span class="glyphicon glyphicon-menu-right" id="glyphicon"></sapn>
					</li>
					<li class="active1">成功提交订单</li>
				</ul>
			</div>
		</div>
		
		<!--中间 巨幕-->
		<div class="container">
			<table id="table" cellpadding="0px" cellspacing="0px">
				<tr>
					<td class="form-inline">
						<input class="form-control" id="selectAll" type="checkbox" style="width: 20px;height: 20px;"/>&nbsp;全选
					</td>
					<td>商品名称</td>
					<td>描述</td>
					<td>单价</td>
					<td>数量</td>
					<td>小计(元)</td> 
					<td>操作</td>
				</tr>	
			</table>
		</div>
		<!--翻页-->
		<div class="nav-page">
			<span>1</span> - <span>5</span> / 页
			<span><a href="">下一页></a></span>
		</div>
		<div class="container" id="logincar">
			<div class="logincar">
				<a href="index.html">
					<button class="btn btn-primary">继续购物</button>
				</a>
				<a href="javascript:;">
					<button class="btn btn-primary" id="del-all">清空购物袋 </button>
				</a>
				<div>
					
				</div>
				<p class="total">总计（不含运费 ）：<strong>¥0.00</strong>
					<a href="order_submit.jsp">
					<button class="btn btn-primary">去结算</button>
				</a>
				</p>
				
			</div>
		</div>
		
		<div class="container" id="car-right">
			<div class="text-right">
			<p>购物保障：
				<img src="/yougou/img/tip01.jpg" />
			   100%正品
			   <img src="/yougou/img/tip02.jpg" />
			   10天退换货
			   <img src="/yougou/img/tip03.jpg" />
			   10天补差价
			</p>
			<p>优惠券/礼品卡在下一步使用</p>
			<a href="">帮助我们改进购物流程</a>
			</div>
			<div class="text-left">
				<h3>购买了您购物袋中商品的顾客还买了
					<span class="glyphicon glyphicon-hand-down"></span>
				</h3>
			</div>
		</div>
		
		<!--动画轮播-->
			<div class="shoes">
				<div class="full">
				
				
				
				</div>
				<!--两个上下按钮-->
				<a href="javascript:;" id="prev" class="glyphicon glyphicon-hand-right"></a>
				<a href="javascript:;" id="next" class="glyphicon glyphicon-hand-left"></a>
				
			</div>
		
		<div class="container text-center" id="car-bottom1">
			<p>Copyright © 2011-2014 Yougou Technology Co., Ltd. 粤ICP备09070608号-4 增值电信业务经营许可证：粤 B2-20090203 </p>
		</div>
	</body>
</html>
<script src="/yougou/js/jquery-1.8.3.min.js"></script>
<script src="/yougou/js/jquery.min.js"></script>
<script src="/yougou/js/bootstrap.js"></script>
<script src="/yougou/js/ydxLazyLoad.js"></script>
<script src="/yougou/js/base.js"></script>
<script src="/yougou/js/login-cart.js"></script>