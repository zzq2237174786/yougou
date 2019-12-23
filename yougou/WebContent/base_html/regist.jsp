<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>用户注册</title>
		<link rel="stylesheet" href="/yougou/css/bootstrap.css" />
		<link rel="stylesheet" href="/yougou/css/regist.css" />
		<meta name="viewport" content="width=device-width , initial-scale=1" />
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
				<div><span>用户注册</span></div>
			</div>
			<div class="contain-bottom">
				<div class="form">
					<div class="form-head">
						<a href="/yougou/base_html/login.jsp"><div class="form-login">
								<input type="submit" class="form-loginbtn" value="登录"/>
						</div></a>
						<a href="/yougou/base_html/regist.jsp"><div class="for-regist">
								<input type="submit" class="form-registbtn" value="注册"/>
						</div></a>
					</div>
					<div class="form-contain">
						<div class="phone">
							<div class="box">手机号</div>
							<input class="printk" placeholder="请输入你的手机号码" type="text"/>
						</div>
						<div class="form-contain-blank">
							<span class="phone-yz">请输入11位数字!</span>
						</div>
						<div class="yzm">
							<div class="box2">验证码</div>
							<input class="printy" type="text"/>
						</div>
						<div class="yzm-y"><a href="">8615</a></div>
						<div class="ssd"><span class="ssd-yzm">情输入验证码！</span></div>
						<div class="yzm-dx">
							<div class="box3">短信验证码</div>
							<input class="yzm-dx-t" type="text"/>
						</div>
						<a href="" ><div class="yzm-get">获取验证码</div></a>
						<div class="dxyzm-yz"><span class="dxyzm-yz-ts">请输入六位数字的短信验证码！</span></div>
						<div class="yzm-password">
							<div class="box4">密码</div>
							<input class="yzm-password-t" type="password" placeholder="8位数字"/>
						</div>
						<div class="yzm-password-ts"><span class="yzm-password-ts1">请输入8位数字的密码！</span></div>
						<div class="yzm-qrpassword">
							<div class="box5">确认密码</div>
							<input class="yzm-qrpassword-t" type="password"></input>
						</div>
						<div class="yzm-qrpassword-yz"><span class="yzm-qrpassword-yz-ts">请输入确认密码！</span></div>
						<div class="zhuce-xieyi">
							<input type="checkbox" checked="checked" class="zhuce-chec"/>
							<a href="">我已阅读并同意《优购会员注册协议》</a>
						</div>
						<div class="zhuce-btn">
							<input class="zhuece-loginbtn" value="确认并登录" title="立即注册" />
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
<script src="/yougou/js/regist.js"></script>
<script src="/yougou/js/base.js"></script>