<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>找回密码</title>
		<link rel="stylesheet" href="/yougou/css/bootstrap.css" />
		<link rel="stylesheet" href="/yougou/css/findpassword-three.css" />
		<meta name="viewport" content="width=device-width , initial-scale=1" />
		<link rel="stylesheet" href="/yougou/css/base.css" />
	</head>
	<body>
		<!--头部-->
		<header class="header">
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
						<a href="/yougou/power_html/collect.jsp">
							<span class="glyphicon glyphicon-heart"></span> 收藏
						</a>
					</li>
					<!--购物袋-->
					<li id="cart-btn">
						<a href="/yougou/power_html/login-cart.jsp">
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
		</header>
		
		<!--身体-->
		<div class="findpassword-contain">
			<!--内容上半部分-->
			<div class="contain-top">
				<div class="top-h2"><h2>找回密码</h2></div>
				<div class="top-a"><a href="/yougou/base_html/index.jsp">返回时尚商城</a></div>
			</div>
			<!--内容下半部分-->
			<div class="contain-foot">
				<div class="foot-box">
					<div class="foot-top">
						<div class="box1">1.输入账号</div>
						<div class="box2">2.账号验证及密码重置</div>
						<div class="box3">3.密码修改成功</div>
					</div>
					<div class="foot-bootom">
						<div class="foot-bootom-checknum">
							<div class="checknum">图片验证码：</div>
							<div class="check-input"><input class="check-inputnumber" type="text" /></div>
							<div id="checknumber" class="checknum-num">5462</div>
							<div class="checknum-wz">看不清？换一张</div>
						</div>
						<div class="foot-bootom-user">
							<div class="user-zhanghao">验证手机号：</div>
							<div class="user-input">185****7265</div>
							<div class="user-ts-btn"><button class="check-btn" type="submit">获取验证码</button></div>
						</div>
						<div class="foot-bootom-user">
							<div class="user-zhanghao">输入验证码：</div>
							<div class="user-ts-btn"><input class="foot-phoneofnum" type="text" /></div>
						</div>
						<div class="foot-bootom-next">
							<div class="bootom-next">下一步</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
		
		<div class="findpassword-footer">
			<div class="question">收不到验证短信吗？</div>
			<div class="footer-que1">
				<div><img src="/yougou/img/point.png" alt="" />　若当前号码已停用，请利用注册邮箱找回。</div>
			</div>
			<div class="footer-que1">
				<div><img src="/yougou/img/point.png" alt="" />　请确认短信是否被拦截。</div>
			</div>
			<div class="footer-que1">
				<div><img src="/yougou/img/point.png" alt="" />　由于网络原因，可能会有延迟。</div>
			</div>
			<div class="footer-que1">
				<div><img src="/yougou/img/point.png" alt="" />　如果按照以上方法还是无法解决问题，请拨打客服热线：400 163 8888。</div>
			</div>
		</div>
		
	</body>
</html>
<script src="/yougou/js/jquery.min.js"></script>
<script src="/yougou/js/bootstrap.js"></script>
<script src="/yougou/js/findpassthree-three.js"></script>
<script src="/yougou/js/base.js"></script>