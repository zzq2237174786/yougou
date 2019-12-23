<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的收藏夹</title>
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/yougou/css/collect.css"/>
		<link rel="stylesheet" type="text/css" href="/yougou/css/base.css"/>
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
						<a href="/yougou/base_html/register.jsp" id="register-btn">注册</a>
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
						<a href="/yougou/base_htm/login.jsp">
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

		<!--logo 广告条-->
		<div class="logo">
			<!--logo 和 导航-->
			<div class="container">
				<!--logo-->
				<div class="row">
					<div class="col-md-2 col-md-offset-5 logo-header">
						<a href=""><img src="/yougou/img/logo.png" /></a>
					</div>
				</div>
			</div>

			<!--logo下的分类-->
			<div class=" logo-nav">
				<div class="container">
					<div class="row">
					<!--导航条-->
					<div class="col-md-10">
						<nav class="navbar ">
							<ul class="nav navbar-nav" id="nav-type">
								<li class="nav-log">
									<a href=""><img src="/yougou/img/nav-logo.png" /></a>
								</li>
								<li>
									<a href="index.html">首页</a>
								</li>
								<!--分类-->
							</ul>
						</nav>
					</div>

					<!--搜索框 logo-serach-->
					<div class="col-md-2 logo-search">
						<input type="text" />
						<a href=""><span></span></a>
					</div>
				</div>

				<!--导航条下的内容-->
				<div class="nav-content" id="nav-content">
					<!--分类下的内容-->
				</div>
				</div>
			</div>

		</div>
		
		<!--内容部分-->
		<section>
			<div class="container">
				<!--导航路径-->
				<div class="row col-lg-10 col-lg-offset-1">
					<p class="curmbs">
						您当前的位置：
						<a href="/yougou/index.html">首页</a>
						>
						<a href="collect-my.html">我的优购</a>
						>我的收藏夹
					</p>
				</div>
				<!--主体-->
				<div class="row">
					<!--菜单-->
					<div class="umenu col-lg-2 col-lg-offset-1" id="umenu ">
						<!--我的优购-->
						<div class="myyougou ">
							<a class="text-center" href="collect-my.jsp">
								<span class="text-center">我的优购</span>
							</a>
						</div>
						
						<!--交易中心-->
						<ul class="jiaoyizx">
							<li class=" ultitle ">交易中心</li>
							<li class="current myorder"><a href="/yougou/power_html/collect_order.jsp">
								<span>
								我的订单
							</span></a></li>
							<li class="present myfavor"><a href="/yougou/power_html/collect.jsp"><span>
								我的收藏
							</span></a></li>
							<li class="current mycomment"><a href="/yougou/power_html/collect_comment.jsp"><span>
								商品评论/晒单
							</span></a></li>
							<li class="current mymessage"><a href="/yougou/power_html/collect_message.jsp"><span>
								站内消息
							</span></a></li>							
						</ul>
						<!--我的资产-->
						<ul class="wodezc">
							<li class=" ultitle ">我的资产</li>
							<li class="current mycoupon"><a href="/yougou/power_html/collect_coupon.jsp"><span>
								我的优惠券
							</span></a></li>
							<li class="current mygiftcard"><a href="/yougou/power_html/colect_giftcard.jsp"><span>
								我的礼品卡
							</span></a></li>
							<li class="current mypoint"><a href="/yougou/power_html/collect_point.jsp"><span>
								我的积分
							</span></a></li>
						</ul>
						<!--个人设置-->
						<ul class="gerensz">
							<li class="ultitle ">个人设置</li>
							<li class="current mysafeset"><a href="/yougou/power_html/collect_safeSet.jsp"><span>
								安全设置
							</span></a></li>
							<li class="current myaddress"><a href="/yougou/power_html/collect_address.jsp"><span>
								我的收获地址
							</span></a></li>
						</ul>
						<!--售后服务-->
						<ul class="shouhoufw">
							<li class="ultitle">售后服务</li>
							<li class="current mysafeset"><a href="/yougou/power_html/collect_afterService.jsp"><span>
								查看退换货
							</span></a></li>
							<li class="current myaddress"><a href="/yougou/power_html/collect_applicationService.jsp"><span>
								申请退换货
							</span></a></li>
						</ul>
						<!--热门推荐-->
						
						<ul class="hotlist">
							<li class="hottitle">
								<p>24小时热销推荐</p>
							</li>
							<li class="hotmiddle">
								<dl>
									<dt>
										<a href="javascript:void(0)"><img src="/yougou/img/101244991_01_s.jpg"/></a>
									</dt>
									<dd>
										<p class="hotgoodsname">
											<a href="javascript:void(0)">阿迪达斯 单肩包</a>
										</p>
										<p class="hotgoodsprice">
											<span>￥62</span>
											<span class="primecost">￥99</span>
										</p>
									</dd>
								</dl>
								<dl>
									<dt>
										<a href="javascript:void(0)"><img src="/yougou/img/101301590_01_s.jpg"/></a>
									</dt>
									<dd>
										<p class="hotgoodsname">
											<a href="javascript:void(0)">百丽 长靴</a>
										</p>
										<p class="hotgoodsprice">
											<span>￥699</span>
											<span class="primecost">￥2299</span>
										</p>
									</dd>
								</dl>
								<dl>
									<dt>
										<a href="javascript:void(0)"><img src="/yougou/img/100990096_01_s.jpg"/></a>
									</dt>
									<dd>
										<p class="hotgoodsname">
											<a href="javascript:void(0)">阿迪三叶草 休闲鞋</a>
										</p>
										<p class="hotgoodsprice">
											<span>￥209</span>
											<span class="primecost">￥899</span>
										</p>
									</dd>
								</dl>
								<dl>
									<dt>
										<a href="javascript:void(0)"><img src="/yougou/img/101306504_01_s.jpg"/></a>
									</dt>
									<dd>
										<p class="hotgoodsname">
											<a href="javascript:void(0)">阿迪三叶草 休闲鞋</a>
										</p>
										<p class="hotgoodsprice">
											<span>￥329</span>
											<span class="primecost">￥899</span>
										</p>
									</dd>
								</dl>
								<dl>
									<dt>
										<a href="javascript:void(0)"><img src="/yougou/img/101306504_01_s.jpg"/></a>
									</dt>
									<dd>
										<p class="hotgoodsname">
											<a href="javascript:void(0)">天美意 中靴</a>
										</p>
										<p class="hotgoodsprice">
											<span>￥628</span>
											<span class="primecost">￥1299</span>
										</p>
									</dd>
								</dl>
							</li>
							<li class="hotlast">
								<a class="glyphicon glyphicon-repeat" href="javascript:void(0)">换一批</a>
							</li>
						</ul>
						
						
					</div>
					<!--主要内容-->
					<div class="content col-lg-9" id="content">
						<div class="content-top">
							<a class="current choosed" href="javascript:void(null)">
								所有收藏
								<span>
								</span>
							</a>
							<a class="current zeronum" href="javascript:void(0)">
								已降价
								<span>
									0
								</span>
							</a>
							<a class="current zeronum" href="javascript:void(0)">
								正促销
								<span>
									0
								</span>
							</a>
							<a class="current zeronum" href="javascript:void(0)">
								即将断货
								<span>
									0
								</span>
							</a>
						</div>
						
						<!--商品收藏列表-->
						<div class="content-body">
							<ul class="body-top">
								<li class="product-name">商品信息</li>
								<li class="price">价格</li>
								<li class="make">操作</li>
							</ul>
							<!--无数据时-->
							<ul class="body-middle">
								<li><span class="text-center">
									暂无收藏商品
								</span></li>
							</ul>
							
							<!--有数据-->
							<ul class="goods">
								<li>
									<span id="">
										<a class="goods-up glyphicon glyphicon-circle-arrow-up" href="javascript:void(0)" title="置顶"></a>
										<input type="checkbox" class="check"/>
									</span>
									<a href="pro_center.jsp"><img src="img/101244991_01_s.jpg"/></a>
									<div class="goods-list">
										<div class="goods-name">
											<p>
												<a href="pro_center.html" target="_blank">adidas阿迪达斯2019中性EC ORG单肩包ED6877</a>
											</p>
											<p>
												<span class="goods-color">
													颜色：
													<em>黑</em>
													&nbsp;&nbsp; 尺码
													<em>F</em>
												</span>
											</p>
										</div>
										<div class="goods-price">
											<p class="">￥62</p>
										</div>
										<div class="goods-make">
											<p><a class="addcart" href="pro_center.jsp">加入购物车</a></p>
											<p><a class="reducefavor" href="javascript:void(0)">取消收藏</a></p>
										</div>
									</div>
								</li>
								<li>
									<span id="">
										<a class="goods-up glyphicon glyphicon-circle-arrow-up" href="javascript:void(0)" title="置顶"></a>
										<input type="checkbox" class="check"/>
									</span>
									<a href="/yougou/base_html/pro_center.jsp"><img src="/yougou/img/101244991_01_s.jpg"/></a>
									<div class="goods-list">
										<div class="goods-name">
											<p>
												<a href="/yougou/base_html/pro_center.jsp" target="_blank">adidas阿迪达斯2019中性EC ORG单肩包ED6877</a>
											</p>
											<p>
												<span class="goods-color">
													颜色：
													<em>黑</em>
													&nbsp;&nbsp; 尺码
													<em>F</em>
												</span>
											</p>
										</div>
										<div class="goods-price">
											<p class="">￥62</p>
										</div>
										<div class="goods-make">
											<p><a class="addcart" href="/yougou/base_html/pro_center.jsp">加入购物车</a></p>
											<p><a class="reducefavor" href="javascript:void(0)">取消收藏</a></p>
										</div>
									</div>
								</li>
								<li>
									<span id="">
										<a class="goods-up glyphicon glyphicon-circle-arrow-up" href="javascript:void(0)" title="置顶"></a>
										<input type="checkbox" class="check"/>
									</span>
									<a href="/yougou/base_html/pro_center.jsp"><img src="/yougou/img/101244991_01_s.jpg"/></a>
									<div class="goods-list">
										<div class="goods-name">
											<p>
												<a href="/yougou/power_html/pro_center.jsp" target="_blank">adidas阿迪达斯2019中性EC ORG单肩包ED6877</a>
											</p>
											<p>
												<span class="goods-color">
													颜色：
													<em>黑</em>
													&nbsp;&nbsp; 尺码
													<em>F</em>
												</span>
											</p>
										</div>
										<div class="goods-price">
											<p class="">￥62</p>
										</div>
										<div class="goods-make">
											<p><a class="addcart" href="/yougou/power_html/login-order.jsp">加入购物车</a></p>
											<p><a class="reducefavor" href="javascript:void(0)">取消收藏</a></p>
										</div>
									</div>
								</li>
							</ul>
							<div class="body-bottom">
								<div class="nogoods"></div>
								<div class="havegoods">		
									<div class="cleall">
										<input type="checkbox" class="check-all"/>
										&nbsp;&nbsp;
										<label>全选</label>
										&nbsp;&nbsp;
										<a class="removeall" href="javascript:void(0)">取消收藏</a>
										&nbsp;&nbsp;
									</div>
									<div class="listcount">
										总记录数：
										<span id="goods-count"></sapn>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
					
		<!--尾部样式-->
		<div class="footer">
			<!--底部1-->
			<div class="footer-feature">
				<div class="container">
					<ul>
						<li class="li-one">
							<span class="footer-img1"></span>
							<a href="javaScript:;">正品保证 </a>
						</li>
						<li>
							<span class="footer-img2"></span>
							<a href="javaScript:;">10天退换货 </a>
						</li>
						<li>
							<span class="footer-img3"></span>
							<a href="javaScript:;">10天调补差价额 </a>
						</li>
						<li>
							<span class="footer-img4"></span>
							<a href="javaScript:;"> 09:00—21:00在线客服</a>
						</li>
					</ul>
				</div>
			</div>

			<!--底部2-->
			<div class="footer-help">
				<div class="container">
					<!--上面部分-->
					<ul class="footer-help-top">
						<li class="li-one">
							<ul>
								<li class="item">
									<a href="javaScript:;">新手帮助</a>
								</li>
								<li>
									<a href="javaScript:;">交易条款协议</a>
								</li>
								<li>
									<a href="javaScript:;">注册新用户</a>
								</li>
								<li>
									<a href="javaScript:;">会员积分详情</a>
								</li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="item">
									<a href="javaScript:;">购物指南</a>
								</li>
								<li>
									<a href="javaScript:;">订单流程</a>
								</li>
								<li>
									<a href="javaScript:;">验货与签收</a>
								</li>
								<li>
									<a href="javaScript:;">订单配送</a>
								</li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="item">
									<a href="javaScript:;">支付/配送</a>
								</li>
								<li>
									<a href="javaScript:;">支付方式</a>
								</li>
								<li>
									<a href="javaScript:;">配送方式</a>
								</li>
								<li>
									<a href="javaScript:;">配送事件及运费</a>
								</li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="item">
									<a href="javaScript:;">售后服务</a>
								</li>
								<li>
									<a href="javaScript:;">退换货政策</a>
								</li>
								<li>
									<a href="javaScript:;">退款说明</a>
								</li>
								<li>
									<a href="javaScript:;">发票制度</a>
								</li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="item">
									<a href="javaScript:;">会员服务</a>
								</li>
								<li>
									<a href="javaScript:;">找回密码</a>
								</li>
								<li>
									<a href="javaScript:;">联系我们</a>
								</li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="item">
									<a href="javaScript:;">优购服务</a>
								</li>
								<li>
									<a href="javaScript:;">在线质询</a>
								</li>
								<li>
									<a href="javaScript:;">Email: ygservice@belle.com.cn</a>
								</li>
								<li>
									<a href="javaScript:;">微信客服：优购时尚商城</a>
								</li>
							</ul>
						</li>
					</ul>
					<!--中间部分-->
					<div class="footer-help-center">
						<ul class="ul-left">
							<li class="li-one">
								<a href="javaScript:;"><img src="/yougou/img/footer-img1.png" /></a>
							</li>
							<li>
								<a href="javaScript:;"><img src="/yougou/img/footer-img2.jpg" /></a>
							</li>
							<li>
								<a href="javaScript:;"><img src="/yougou/img/footer-img3.png" /></a>
							</li>
							<li>
								<a href="javaScript:;"><img src="/yougou/img/footer-img4.png" /></a>
							</li>
						</ul>
						<ul class="ul-right">
							<li>
								<a><img src="/yougou/img/app.jpg" class="ul-right-img1" /></a>
								<a class="a-title">扫描下载手机客户端</a>
							</li>
							<li>
								<a><img src="/yougou/img/weChat.jpg" /></a>
								<a class="a-title">关注公众号</a>
							</li>
						</ul>
					</div>
					<!--下面部分-->
					<div class="footer-help-bottom">
						<div class="friend-link">
							<ul>
								<li class="li-one">
									<a href="javaScript:;">关于优购</a>|</li>
								<li>
									<a href="javaScript:;">集团采购</a>|</li>
								<li>
									<a href="javaScript:;">招纳贤士</a>|</li>
								<li>
									<a href="javaScript:;">手机优购</a>|</li>
								<li>
									<a href="javaScript:;">联系我们</a>|</li>
								<li>
									<a href="javaScript:;">友情连接</a>|</li>
							</ul>
						</div>
						<div class="copy-right">
							<span>Copyright © 2011-2016 Yougou Technology Co., Ltd.</span>
							<a href="javaScript:;">粤ICP备09070608号-4</a>
							<span> 增值电信业务经营许可证：</span>
							<a href="javaScript:;">粤ICP备09070608号-4</a>
							<span>深公网安备：4403101910665</span>
							<a href="javaScript:;"> 粤公网安备 44030502000017号</a>
						</div>
					</div>
				</div>
			</div>

		</div>

	</body>
</html>
<script src="/yougou/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/yougou/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="/yougou/js/base.js" type="text/javascript" charset="utf-8"></script>
<script src="/yougou/js/collect.js" type="text/javascript" charset="utf-8"></script>