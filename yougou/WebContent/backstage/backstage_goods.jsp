<%@page import="com.yougou.dto.zz.BackGoods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>商品管理</title>
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/yougou/css/backstage.css"/>
		<link rel="stylesheet" type="text/css" href="/yougou/css/backstage_goods.css"/>
	
	
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
							
							<a href="backstage_stock.jsp"><p>商品库存</p></a>
							
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/我的卡券.png" />
							</div>							
							<p>商品管理</p>
							<p class="current"></p>
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
							<a href="baskstage_manage.jsp"><p>会员管理</p></a>	
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
					<div class="select">
						<li>商品名称：<input type="text" class="goodsInfo" id="goodsInfo"/></li>
						
						<li>
							商品价格：<input type="text" class="goods-min" id="goods-min" />
						~<input type="text" class="goods-max" id="goods-max" />
						</li>
						<li>
							商品状态：<input type="text" class="goodsStatus" id="goodsStatus"/>
						</li>
						
						<li class="goodsSelect"><input type="button" class="goods-select" id="goods-select" value="查询" /></li>
						<!--<li class="goodsAdd"><input type="button" data-toggle="modal" data-target="#myModal" class="goods-add " id="goods-add" value="添加新商品" /></li>-->
						
						
						
					</div>
					<!--内容菜单-->
					<ul class="tab-top col-lg-12">
						<li class="top-goodsname">商品名称</li>
						<li>商品旧价</li>
						<li>商品新价</li>
						<li>商品状态</li>
						<li>操作</li>
					</ul>
					<!--详细内容-->
					<div class="tab-body col-lg-12">						
						<ul class="tab-detail"id="ulList">
						<c:forEach items="${bgList}" var="s" varStatus="i">
							<li class="goods-name" style="line-height: 40px;">${s.goodsName }</li>
							<li class="goods-size">${s.goodsOldPrice }</li>
							<li class="goods-stock">${s.goodsOldPrice }</li>
							<li class="goods-status">
								<input class="btn btn-default btn-off" type="button" value="下架">
								<input class="btn btn-default btn-on" type="button" value="上架">
							</li>
							<li class="goods-true">
								<input class="btn btn-default btn-true" name=${s.goodsId } type="button" value="确认修改">
								
							</li>
						</c:forEach>					
						</ul>
						
					</div>
					
					<!--分页-->
					<div class="row  type-page">
						<div class="pagination">
							
		
							<c:if test="${pageNo eq 1}">
							<a href="javascript:void(0)">上</a>
								<c:forEach var="i" begin="${pageNo}" end="${pageNo+6 }">
									<c:if test="${i ne pageNo}">
										<a href="backlogin.do?method=getBackGoods&pageNo=${i}">${i}</a>
										
									</c:if>
									<c:if test="${i eq pageNo}">
										<span class="active">${i}</span>
									</c:if>
									
								</c:forEach>
								<a href="backlogin.do?method=getBackGoods&pageNo=${pageNo+1}">下</a>
							</c:if>
							<c:if test="${pageNo eq maxNo}">
								<a href="backlogin.do?method=getBackGoods&pageNo=${pageNo-1}">上</a>
								<c:forEach var="i" begin="${pageNo-6}" end="${maxNo }">
									<c:if test="${i ne pageNo}">
										<a href="backlogin.do?method=getBackGoods&pageNo=${i}">${i}</a>
									</c:if>
									<c:if test="${i eq pageNo}">
										<span class="active">${i}</span>
									</c:if>
								</c:forEach>
								<a href="backlogin.do?method=getBackGoods&pageNo=${pageNo+1}">下</a>
							</c:if>
							<c:if test="${pageNo ne maxNo and pageNo ne 1}">
								<c:if test="${pageNo le 4}">
									<a href="backlogin.do?method=getBackGoods&pageNo=${pageNo-1}">上</a>
									<c:forEach var="i" begin="1" end="7">
										<c:if test="${i ne pageNo}">
										<a href="backlogin.do?method=getBackGoods&pageNo=${i}">${i}</a>
									</c:if>
									<c:if test="${i eq pageNo}">
										<span class="active">${i}</span>
									</c:if>
									</c:forEach>
									<a href="backlogin.do?method=getBackGoods&pageNo=${pageNo+1}">下</a>
								</c:if>
								<c:if test="${pageNo gt 4}">
									<a href="backlogin.do?method=getBackGoods&pageNo=${pageNo-1}">上</a>
									<c:forEach var="i" begin="${pageNo-3 }" end="${pageNo+3 }">
										<c:if test="${i ne pageNo}">
											<a href="backlogin.do?method=getBackGoods&pageNo=${i}">${i}</a>
										</c:if>
										<c:if test="${i eq pageNo}">
											<span class="active">${i}</span>
										</c:if>
									</c:forEach>
									<a href="backlogin.do?method=getBackGoods&pageNo=${pageNo+1}">下</a>
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
<script src="/yougou/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>


