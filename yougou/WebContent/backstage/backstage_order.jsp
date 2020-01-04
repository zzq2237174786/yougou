<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>订单管理</title>
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/yougou/css/backstage.css"/>
		<link rel="stylesheet" type="text/css" href="/yougou/css/backstage_order.css"/>
	</head>
	<body>
	
	<table>
   			<thead>
   				<tr>
   					<th>序号</th>
   					<th>姓名</th>
   					<th>性别</th>
   					<th>成绩</th>
   					<th>操作</th>
   				</tr>
   			</thead>
   			<tbody>
   				
   				<c:forEach items="${unoList}" var="s" varStatus="i">
   					
   						<tr>
   							<td>
   								
   								${s.orderId }
   							</td>
   							
   							
   						</tr>	
   				</c:forEach>
   			</tbody>
   		</table>
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
							<a href="backstage_stock.jsp"><p>商品库存</p></a>
							
						</li>
						<li>
							<div class="">
								<img src="/yougou/img/我的卡券.png" />
							</div>							
							<a href="backstage_goods.jsp"><p>商品管理</p></a>	
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
				<div class="col-lg-10  main-right">
					<!--查找-->
					<ul class="select">
						<li>订单时间：<input type="text" class="order-time" id="order-time" /></li>
						<li>订单编号：<input type="text" class="order-num" id="order-num" /></li>
						<li>
							<input type="button" class="on-select" id="on-select" value="查询" />
							<!--<input type="button" class="off-select" id="off-select" value="取消" />-->
						</li>
					</ul>
					<div class="content-top">
							<a class="current choosed" href="javascript:void(0)">
								未发货订单
							</a>
							<a class="current zeronum" href="backstage_delivered.jsp">
								已发货订单
							</a>
							<a class="current zeronum" href="backstage_sign.jsp">
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
								<li>
									<div class="goods-list">
										<div class="goods-info">
											<p>
												adidas阿迪达斯2019中性EC ORG单肩包ED6877
											</p>
											<p>
												<span class="goods-color">
													颜色：
													<em>黑</em>
													&nbsp;&nbsp;尺码：
													<em>F</em>
													&nbsp;&nbsp;数量：
													<em>1</em>
													&nbsp;&nbsp;价格：
													<em>1000000000000</em>
												</span>	
											</p>
										</div>
										<div class="haved-info">
											<span class="haved-ard">
												天津市宁河区潘庄镇大龙湾村
												详细地址。。。
											</span>
											<span class="order-haved">
												周哈哈
											</span>
											<span id="">
												收
											</span>
											<span class="order-tel">
												138****8888
											</span>
										</div>
										<!--订单时间-->
										<div class="order-info">
											订单时间：<p class="order-time">2020-1-1</p>
											订单时间：<p class="order-num">1027583A</p>
										</div>
										<div class="order-confirm">
											<input type="button"  class="confirm-content" id="confirm-content" value="确认发货" />
										</div>
									</div>
								</li>
								<li>
									<div class="goods-list">
										<div class="goods-info">
											<p>
												adidas阿迪达斯2019中性EC ORG单肩包ED6877
											</p>
											<p>
												<span class="goods-color">
													颜色：
													<em>黑</em>
													&nbsp;&nbsp;尺码：
													<em>F</em>
													&nbsp;&nbsp;数量：
													<em>1</em>
													&nbsp;&nbsp;价格：
													<em>1000000000000</em>
												</span>	
											</p>
										</div>
										<div class="haved-info">
											<span class="haved-ard">
												天津市宁河区潘庄镇大龙湾村
												详细地址。。。
											</span>
											<span class="order-haved">
												周哈哈
											</span>
											<span id="">
												收
											</span>
											<span class="order-tel">
												138****8888
											</span>
										</div>
										<!--订单时间-->
										<div class="order-info">
											订单时间：<p class="order-time">2020-1-1</p>
											订单时间：<p class="order-num">1027583A</p>
										</div>
										<div class="order-confirm">
											<input type="button" id="confirm-btn" value="确认发货" />
										</div>
									</div>
								</li>
								<li>
									<div class="goods-list">
										<div class="goods-info">
											<p>
												adidas阿迪达斯2019中性EC ORG单肩包ED6877
											</p>
											<p>
												<span class="goods-color">
													颜色：
													<em>黑</em>
													&nbsp;&nbsp;尺码：
													<em>F</em>
													&nbsp;&nbsp;数量：
													<em>1</em>
													&nbsp;&nbsp;价格：
													<em>1000000000000</em>
												</span>	
											</p>
										</div>
										<div class="haved-info">
											<span class="haved-ard">
												天津市宁河区潘庄镇大龙湾村
												详细地址。。。
											</span>
											<span class="order-haved">
												周哈哈
											</span>
											<span id="">
												收
											</span>
											<span class="order-tel">
												138****8888
											</span>
										</div>
										<!--订单时间-->
										<div class="order-info">
											订单时间：<p class="order-time">2020-1-1</p>
											订单编号：<p class="order-num">1027583A</p>
										</div>
										<div class="order-confirm">
											<input type="button" id="confirm-btn" value="确认发货" />
										</div>
									</div>
								</li>
								
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
						<div class="pagination"></div>
					</div>
					
				</div>
			

			</div>
		</section>

		
	</body>
</html>

<script src="/yougou/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/yougou/js/backstage_time.js" type="text/javascript" charset="utf-8"></script>
