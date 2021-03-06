<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>用户登录</title>
		<link rel="stylesheet" href="/yougou/css/bootstrap.css" />
		<link rel="stylesheet" href="/yougou/css/login.css" />
		<meta name="viewport" content="width=device-width , initial-scale=1" />
		<link rel="stylesheet" href="/yougou/css/base.css" />
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
		<!--身体-->
		<div class="contain">
			<div class="contain-top">
				<div class="contain-top-logo"><a href=""><img src="/yougou/img/logo.png"/></a></div>
				<div><span>用户登录</span></div>
			</div>
			<div class="contain-bottom">
				<div class="form">
					<div class="form-head">
						<a href="/yougou/base_html/login.jsp"><div class="zhmmdl">
								<input type="submit" class="zhmmdl-a" value="账号密码登录"/>
						</div></a>
						<a href="/yougou/base_html/phonelogin.jsp"><div class="sjhkjdl">
								<input type="submit" class="sjhkjdl-a" value="手机号码登录"/>
						</div></a>
					</div>
					<div class="form-contain">
						<div class="srzh-username">
							<div class="box"></div>
							<div class="username-srzh">
								<input class="printk" placeholder="请输入账号" type="text" />
								<img class="printk-ts" src="/yougou/img/yes-ts_03.png" />
							</div>
						</div>
						<div class="form-contain-usernameblank">
							<div class="username-tssize"><img src="/yougou/img/ts_03.png"/></div>
							<div class="username-size"><span class="username-msg">请输入账号</span></div>
						</div>
						<div class="srzh-password">
							<div class="box2"></div>
							<div class="password-srzh">
								<input class="printp" placeholder="请输入密码" type="password" />
								<img class="printp-ts" src="/yougou/img/yes-ts_03.png" />
							</div>
						</div>
						<div class="form-contain-passwordblank">
							<div class="password-tssize"><img src="/yougou/img/ts_03.png"/></div>
							<div class="password-size"><span class="password-msg">请输入密码</span></div>
						</div>
						<p class="form-contain-p"><a href="/yougou/base_html/findpassword-first.jsp">忘记密码</a></p>
						<div class="loginbtn">
							<input type="submit" class="loginbtn1" value="点击登录" title="登录"/>
						</div>
						<div class="form-contain-tisement">
							<p class="tisement">使用合作网站账号登录优购：</p>
						</div>
						<div class="form-contain-foot">
							<a href="" class="wechet tubiao"></a>
							<a href="" class="zhifubao tubiao"></a>
							<a href="" class="qq tubiao"></a>
							<a href="" class="weibo tubiao"></a>
							<a href="" class="renren tubiao"></a>
						</div>
					</div>
				</div>
			</div>
			<div class="blank"></div>
		</div>
		<div class="footer">
			<p>Copyright © 2011-2014 Yougou Technology Co., Ltd.</p>
			<p>粤ICP备09070608号-4</p>
			<p>增值电信业务经营许可证：粤 B2-20090203</p>
		</div>
	</body>
</html>
<script src="/yougou/js/jquery.min.js"></script>
<script src="/yougou/js/bootstrap.js"></script>
<script src="/yougou/js/base.js"></script>
<script src="/yougou/js/login.js"></script>


