<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>用户登录</title>
		<link rel="stylesheet" href="/yougou/css/bootstrap.css" />
		<link rel="stylesheet" href="/yougou/css/phonelogin.css" />
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
		</header>
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
								<input typre="submit" class="zhmmdl-a" value="账号密码登录"/>
						</div></a>
						<a href="/yougou/base_html/phonelogin.jsp"><div class="sjhkjdl">
								<input type="submit" class="sjhkjdl-a" value="手机号码登录"/>
						</div></a>
					</div>
					<div class="form-contain">
						<div class="srzh">
							<div class="box">手机号</div>
							<input class="printk" placeholder="请输入手机号码" type="text" />
						</div>
						<div class="form-contain-blank"><span class="form-contain-blank-yz">请输入11位手机号码！</span></div>
						<div class="srzh1">
							<div class="box2">短信验证码</div>
							<input class="printp" placeholder="" type="password"/>
						</div>
						<a href="" ><div class="yzm-get">获取验证码</div></a>
						<div class="form-contain-blank1"><span class="form-contain-blank1-yz">请输入验证码！</span></div>
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
<script src="/yougou/js/phonelogin.js"></script>
<script src="/yougou/js/base.js"></script>