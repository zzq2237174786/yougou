<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>订单管理</title>
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/yougou/css/backstage.css"/>
		<link rel="stylesheet" type="text/css" href="/yougou/css/backstage_order.css"/>
	</head>
	<script src="/yougou/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	 function Order(orderId){
		this.orderId = orderId;
		this.method = 'operateUnOrder';
	 }
	
	function operateOrder(name){
		//拿到值，封装成json对象
		var orderId = name
		var order = new Order(orderId);
		$.ajax({
			type:"post",
			url:"/yougou/backorder.do",
			data:order,
			success:function(resText){	
				location.reload();
			}
		});
	}
	
	function UnOrder(orderId) {
		
		this.orderId=orderId;
		this.method='inquiryUnorder';
	}
	function inquiryUnorder(){
		//拿到值，封装成json对象

		//alert("进入");
		var ordernum = $('#ordernum').val();
	//	alert(ordernum);
		
		location.href="/yougou/backorder.do?method=inquiryUnorder&orderId="+ordernum;
	}
	
	</script>
	
	
	<body>
	
	
		<!--头部-->
		<header>
			<!--导航栏-->
			<nav class="nav">
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
							<a href="javascript:void(0)"><p>库存管理</p></a>	
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/订单管理.png" />
							</div>							
							<p>订单管理</p>
							<p class="current"></p>
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
							<a href="backusers.do?method=getAllUsers"><p>会员管理</p></a>	
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
				<div class="col-lg-10  main-right">
					<!--查找-->
					<ul class="select" >
						<li>订单时间：<input type="text" class="order-time" id="ordertime"/></li>
						<li>订单编号：<input type="text" class="order-num" id="ordernum"/></li>
						<li>
							<input type="button" class="on-select" id="on-select" onclick="inquiryUnorder()" value="查询" />
							
						</li>
					</ul>
					<div class="content-top">
							<a class="current choosed" href="javascript:void(0)">
								未发货订单
							</a>
							<a class="current zeronum" href="backorder.do?method=getDOrder">
								已发货订单
							</a>
							<a class="current zeronum" href="backorder.do?method=getCOrder">
								已完成订单
							</a>
						</div>	
						
					
					<!--内容菜单-->
					<div class="content-body ">
							<ul class="body-top">
								<li class="top-goodsinfo">商品信息</li>
								<li class="top-orderifo">订单人信息</li>
								<li class="top-ordertime">订单信息</li>
								<li class="top-orderconfirm">确认发货</li>
							</ul>
							<!--无数据时-->
							<!--<ul class="body-middle">
								<li><span class="text-center">
									暂无收藏商品
								</span></li>
							</ul>-->
							
							<!--有数据-->
							<ul class="goods">
								<c:forEach items="${unoList}" var="s" varStatus="i">
								<li id="orderLi">
									<div class="goods-list">
										<div class="goods-info">
											<p>
												${s.goodsName }
												
											</p>
											<p>
												<span class="goods-color">
													颜色：
													<em>${s.goodsColor }</em>
													&nbsp;&nbsp;尺码：
													<em>${s.goodsSize }</em>
													&nbsp;&nbsp;数量：
													<em>${s.orderNum }</em>
													&nbsp;&nbsp;价格：
													<em>${s.orderMsum }</em>
												</span>	
											</p>
										</div>
										<div class="haved-info">
											<span class="haved-ard">
												${s.usersRegion }
												${s.usersAddress }
											</span>
											<span class="order-haved">
												${s.usersName }
											</span>
											<span id="">
												收
											</span>
											<span class="order-tel">
												${s.usersPhone }
											</span>
										</div>
										<!--订单时间-->
										<div class="order-info">
											订单时间：<p class="order-time">${s.orderDate }</p>
											订单编号：<p class="order-num ordernum">${s.orderId }</p>
										</div>
										<div class="order-confirm">
											<input type="button" name="${s.orderId}" class="confirm-content" id="confirm-content"  onclick="operateOrder(this.name)" value="确认发货" />
										</div>
									</div>
								</li>
								
								</c:forEach>
								
							</ul>
							<!--<div class="body-bottom">
								<div class="nogoods">
									暂无订单,请先去<a href="index.jsp">优购</a>
								</div>
								<div class="havegoods">		
									
								</div>
							</div>-->
						</div>

						
					<!--分页-->
					<div class="row  type-page">
						<div class="pagination" id="pagination">
						<c:if test="${maxNo gt 1}">
							<c:if test="${pageNo eq 1}">
								<a href="javascript:void(0)">上</a>
									<c:forEach var="i" begin="${pageNo}" end="${pageNo+1 }">
										<c:if test="${i ne pageNo}">
											<a href="backorder.do?method=getUnOrder&pageNo=${i}">${i}</a>
											
										</c:if>
										<c:if test="${i eq pageNo}">
											<span class="active">${i}</span>
										</c:if>
										
									</c:forEach>
									<a href="backorder.do?method=getUnOrder&pageNo=${pageNo+1}">下</a>
								</c:if>
								<c:if test="${pageNo eq maxNo}">
									<a href="backorder.do?method=getUnOrder&pageNo=${pageNo-1}">上</a>
									<c:forEach var="i" begin="${pageNo-1}" end="${maxNo }">
										<c:if test="${i ne pageNo}">
											<a href="backorder.do?method=getUnOrder&pageNo=${i}">${i}</a>
										</c:if>
										<c:if test="${i eq pageNo}">
											<span class="active">${i}</span>
										</c:if>
									</c:forEach>
									<a href="backorder.do?method=getUnOrder&pageNo=${pageNo+1}">下</a>
								</c:if>
								<c:if test="${pageNo ne maxNo and pageNo ne 1}">
									
										<a href="backorder.do?method=getUnOrder&pageNo=${pageNo-1}">上</a>
										<c:forEach var="i" begin="${pageNo-1}" end="${pageNo+1 }">
											<c:if test="${i ne pageNo}">
												<a href="backorder.do?method=getUnOrder&pageNo=${i}">${i}</a>
											</c:if>
											<c:if test="${i eq pageNo}">
												<span class="active">${i}</span>
											</c:if>
										</c:forEach>
										<a href="backorder.do?method=getUnOrder&pageNo=${pageNo+1}">下</a>
									
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
<script src="/yougou/js/backorder.js" type="text/javascript" charset="utf-8"></script>
