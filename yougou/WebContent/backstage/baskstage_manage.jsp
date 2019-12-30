<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>会员管理</title>
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/yougou/css/backstage.css"/>
		<link rel="stylesheet" type="text/css" href="/yougou/css/backstage_manage.css"/>
	</head>
	<body>
		<!--头部-->
		<header>
			<!--导航栏-->
			<nav class="nav navbar-default">
				<!--版星宽度1200-->
				<div class="container">
					<div class="navbar-header">
						<p>优购后台管理</p>
					</div>
					<div class="nowtime">
						
					</div>
					<ul class="navbar-list">
						<li>退出登录</li>
						<li>修改密码</li>
					</ul>
				</div>
			</nav>
		</header>
		
		<!--内容部分-->
		<section>
			<div class="container">
				<div class="col-lg-2 main-left">
					<!--个人信息-->
					<div class="left-top">
						<div class="picture col-lg-5">
							<img src="/yougou/img/小乔.jpg"/>
						</div>
						<div class="left-info col-lg-7">
							<p>xxx</p>
							<p>欢迎登录</p>
						</div>
					</div>
					<!--菜单-->
					<ul class="menu">
						<li>
							<div class="">
								<img src="/yougou/img/商品管理.png" />
							</div>
							<a href="backstage_goods.jsp"><p>商品管理</p></a>
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/我的卡券.png" />
							</div>							
							<p>促销互动</p>	
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/订单管理.png" />
							</div>							
							<a href="backstage_order.jsp"><p>订单管理</p></a>
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/资金查询.png" />
							</div>							
							<p>支付方式</p>	
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/物流资费.png" />
							</div>							
							<p>配送方式</p>	
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/广告设置.png" />
							</div>							
							<p>页面设置管理</p>	
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/账户信息.png" />
							</div>							
							<p>会员管理</p>
							<p class="current"></p>
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/企业资料.png" />
							</div>							
							<p>系统分析</p>	
						</li>
					</ul>					
				</div>	
				<!--右侧主内容-->
				<div class="col-lg-10 main-right">
					<!--查找-->
					<ul class="select">
						<li>购买次数>=：<input type="text" class="buy-times" id="buy-times" /></li>
						<li>购买流水>=：<input type="text" class="buy-water" id="buy-water" /></li>
						<li>是否被禁用：<input type="text" class="buy-water" id="buy-water" /></li>
						<li>
							<input type="button" class="on-select" id="on-select" value="查询" />
							
						</li>
					</ul>
					<!--内容菜单-->
					<ul class="tab-top col-lg-12">
						<li >会员编号</li>
						<li >会员手机</li>
						<li >注册时间</li>
						<li >购买次数</li>
						<li >购买流水</li>	
						<li>操作</li>
					</ul>
					<!--详细内容-->
					<div class="tab-body col-lg-12">						
						<ul class="tab-detail">
							<li class="member-id">yg000001</li>
							<li class="member-tel">13888888888</li>
							<li class="rigtime">2019-12-26</li>
							<li class="buying-times">3</li>
							<li class="buying-water">976</li>
							<li class="member-operate">
								<input class="btn btn-default btn-off" type="button" value="禁止">
								<input class="btn btn-default btn-on" type="button" value="允许">
							</li>
						</ul>
						<ul class="tab-detail">
							<li class="member-id">yg000001</li>
							<li class="member-tel">13888888888</li>
							<li class="rigtime">2019-12-26</li>
							<li class="buying-times">3</li>
							<li class="buying-water">976</li>					
						</ul>
						<ul class="tab-detail">
							<li class="member-id">yg000001</li>
							<li class="member-tel">13888888888</li>
							<li class="rigtime">2019-12-26</li>
							<li class="buying-times">3</li>
							<li class="buying-water">976</li>					
						</ul>
						<ul class="tab-detail">
							<li class="member-id">yg000001</li>
							<li class="member-tel">13888888888</li>
							<li class="rigtime">2019-12-26</li>
							<li class="buying-times">3</li>
							<li class="buying-water">976</li>					
						</ul>
					</div>
					
					<!--分页-->
					<div class="row  type-page">
						<div class="pagination"></div>
					</div>
					
				</div>
			

			</div>
		</section>

		
	</body>
</html>
<script src="/yougou/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/yougou/js/backstage_time.js" type="text/javascript" charset="utf-8"></script>