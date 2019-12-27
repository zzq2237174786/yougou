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
						<a href="/yougou/power_html/login.jsp">
							<span class="glyphicon glyphicon-heart"></span> 收藏
						</a>
					</li>
					<!--购物袋-->
					<li id="cart-btn">
						<a href="/yougou/power_html/login.jsp">
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
				<div class="form-top">
					<div class="form-head">
						<a href="/yougou/base_html/login.jsp"><div class="form-login">
								<input type="submit" class="form-loginbtn" value="登录"/>
						</div></a>
						<a href="/yougou/base_html/regist.jsp"><div class="for-regist">
								<input type="submit" class="form-registbtn" value="注册"/>
						</div></a>
					</div>
					<div class="form-contain">
						<div class="form-contain-phone">
							<div class="phone">
								<div class="phone-left"><p>手机号</p></div>
								<div class="box1">
									<input class="phone-right" placeholder="请输入手机号码" type="text"/>
									<img class="phone-right-ts"  style="display: none;" src="/yougou/img/yes-ts_03.png" />
								</div>
							</div>
							<div class="phone-check">
								<img class="phone-ts" src="/yougou/img/ts_03.png"/>
								<span class="phone-check-text">请输入手机号码</span>
							</div>
						</div>
						<div class="form-contain-checknum">
							<div class="checknumber">
								<div class="checknumber-left">验证码</div>
								<input class="checknumber-right" type="text"/>
								<div class="checknumber-number"><span id="tips" class="num">8888</span></div>
							</div>
							<div class="checknumber-check">
								<img class="checknumber-ts" src="/yougou/img/ts_03.png"/>
								<span class="checknumber-check-text">请输入验证码</span>
							</div>
						</div>
						<div class="form-contain-email">
							<div class="newschecknumber">
								<div class="newschecknumber-left"><p>短信验证码</p></div>
								<input class="newschecknumber-right" type="text"/>
								<div class="newschecknumber-getnumber"><a href="">获取验证码</a></div>
							</div>
							<div class="newschecknumber-check">
								<img class="newschecknumber-ts" src="/yougou/img/ts_03.png"/>
								<span class="newschecknumber-check-text">请输入短信验证码</span>
							</div>
						</div>
						<div class="form-contain-password">
							<div class="password">
								<div class="password-left"><p>密码</p></div>
								<div class="box2">
									<input class="password-right" maxlength="15" placeholder="由字母、数字、符号组成" type="password"/>
									<img class="password-right-ts" style="display: none;" src="/yougou/img/yes-ts_03.png" />
								</div>
							</div>
							<div class="password-check">
								<img class="password-ts" src="/yougou/img/ts_03.png"/>
								<span class="password-check-text">请输入密码</span>
								<div class="password-strength">
									<div class="password-low">高</div>
									<div class="password-middle">中</div>
									<div class="password-high">低</div>
								</div>
							</div>
						</div>
						<div class="form-contain-repassword">
							<div class="repassword">
								<div class="repassword-left"><p>确认密码</p></div>
								<div class="box3">
									<input class="repassword-right" type="password"/>
									<img class="repassword-right-ts" style="display: none;" src="/yougou/img/yes-ts_03.png" />
								</div>
							</div>
							<div class="repassword-check">
								<img class="repassword-ts" src="/yougou/img/ts_03.png"/>
								<span class="repassword-check-text">请重复输入密码</span>
							</div>
						</div>
						<div class="zhuce-xieyi">
							<div class="zhuce-xieyi-left"><input type="checkbox" checked="checked" class="zhuce-chec"/></div>
							<div class="zhuce-xieyi-right"><a href="">我已阅读并同意《优购会员注册协议》</a></div>
						</div>
						<div class="zhuce-btn">
							<input type="submit" class="zhuece-loginbtn" value="确认并登陆" title="登录"/>
						</div>
					</div>
				</div>
			</div>
			<div class="blank"></div>
		</div>
		<div class="login-footer">
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
