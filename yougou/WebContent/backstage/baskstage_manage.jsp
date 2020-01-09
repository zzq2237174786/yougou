<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<p>管理员</p>
							<p>欢迎登录</p>
						</div>
					</div>
					<!--菜单-->
					<ul class="menu">
						<li>
							<div class="">
								<img src="/yougou/img/商品管理.png" />
							</div>
							<a href="backlogin.do?method=getBackGoods"><p>商品管理</p></a>
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/我的卡券.png" />
							</div>							
							<p>库存管理</p>	
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/订单管理.png" />
							</div>							
							<a href="backorder.do?method=getUnOrder"><p>订单管理</p></a>
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
					
							<c:forEach items="${uList}" var="s" varStatus="i">	
											
								<ul class="tab-detail">
									<li class="member-id">${s.usersNum}</li>
									<li class="member-tel">${s.usersNum}</li>
									<li class="rigtime">${s.usersEmail }</li>
									<li class="buying-times">${s.usersPTime}</li>
									<li class="buying-water">${s.usersMSum}</li>
									<li class="member-operate">
										<input class="btn btn-default btn-off" type="button" value="禁止">
										<input class="btn btn-default btn-on" type="button" value="允许">
									</li>
								</ul>
							
							</c:forEach>
						
						
					</div>
					
					<!--分页-->
					<div class="row  type-page">
						<div class="pagination">
						<c:if test="${maxNo gt 1}">
							<c:if test="${pageNo eq 1}">
								<a href="javascript:void(0)">上</a>
									<c:forEach var="i" begin="${pageNo}" end="${pageNo+1 }">
										<c:if test="${i ne pageNo}">
											<a href="backorder.do?method=getCOrder&pageNo=${i}">${i}</a>
											
										</c:if>
										<c:if test="${i eq pageNo}">
											<span class="active">${i}</span>
										</c:if>
										
									</c:forEach>
									<a href="backorder.do?method=getCOrder&pageNo=${pageNo+1}">下</a>
								</c:if>
								<c:if test="${pageNo eq maxNo}">
									<a href="backorder.do?method=getCOrder&pageNo=${pageNo-1}">上</a>
									<c:forEach var="i" begin="${pageNo-1}" end="${maxNo }">
										<c:if test="${i ne pageNo}">
											<a href="backorder.do?method=getCOrder&pageNo=${i}">${i}</a>
										</c:if>
										<c:if test="${i eq pageNo}">
											<span class="active">${i}</span>
										</c:if>
									</c:forEach>
									<a href="backorder.do?method=getCOrder&pageNo=${pageNo+1}">下</a>
								</c:if>
								<c:if test="${pageNo ne maxNo and pageNo ne 1}">
									
										<a href="backorder.do?method=getCOrder&pageNo=${pageNo-1}">上</a>
										<c:forEach var="i" begin="${pageNo-1}" end="${pageNo+1 }">
											<c:if test="${i ne pageNo}">
												<a href="backorder.do?method=getCOrder&pageNo=${i}">${i}</a>
											</c:if>
											<c:if test="${i eq pageNo}">
												<span class="active">${i}</span>
											</c:if>
										</c:forEach>
										<a href="backorder.do?method=getCOrder&pageNo=${pageNo+1}">下</a>
									
								</c:if>
						</c:if>
						</div>
					</div>
					
				</div>
			

			</div>
		</section>

		
	</body>
</html>
<script src="/yougou/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/yougou/js/backstage_time.js" type="text/javascript" charset="utf-8"></script>