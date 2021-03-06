<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<!--视口-->
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<title>商品详情页</title>
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/pro_center.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/base.css" />
		<link rel="stylesheet" href="/yougou/css/phonelogin.css" /> 
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
						<a href="/yougou/power_html/loing_cart.jsp">
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
					<div class="row" >
						<!--导航条-->
						<div class="col-md-10">
							<nav class="navbar ">
								<ul class="nav navbar-nav" id="nav-type">
									<li class="nav-log">
										<a href="/yougou/base_html/index.jsp"><img src="/yougou/img/nav-logo.png" /></a>
									</li>
									<li>
										<a href="/yougou/base_html/index.jsp">首页</a>
									</li>
									<!--分类-->
								</ul>
							</nav>
						</div>
						<!--搜索框 logo-serach-->
						<div class="col-md-2 logo-search">
							<input type="text" id="searchVal"/>
							<a href="javaScript:;" id="search"><span></span></a>
						</div>
						<span id="num" class="badge">0</span>
						<a href="/yougou/power_html/login_cart.jsp"><span class="glyphicon glyphicon-shopping-cart" id="end"></span>购物车</a>
						
			
					<!--导航条下的内容-->
					<div class="nav-content" id="nav-content">
						<!--分类下的内容-->
					</div>
				</div>
			</div>

		</div>

		<!--导航路径  面包屑-->
		<!--<div class="container"style="padding-top: 150px;margin-left: -20px;">-->
		<!-- <ul class="breadcrumb" id="location">
			<li id="position">您当前位置：</li>
			<li>
				<a href="">首页</a>
			</li>
			<li>
				<a href="">女鞋</a>
			</li>
			<li>
				<a href="">女士靴子</a>
			</li>
			<li>中靴</li>
		</ul> -->

		<!--选项卡-->
		<!--左图右文字-->
		<div class="container detail1">
			<div class="row" id="pro-left">
				<div class="col-md-6">
					<div class="media">
						<div class="media-left">
							<ul class="small">
								<a href=""></a>
							</ul>
						</div>
						<div class="media-body" id="pro-slide">
							<ul class="big">
								<a href="">
									<!--<li class="active"><img id="img-banner" src="img/picbig01.jpg"/></li>
										<li><img src="img/picbig02.jpg"/></li>
										<li><img src="img/picbig03.jpg"/></li>
										<li><img src="img/picbig04.jpg"/></li>
										<li><img src="img/picbig05.jpg"/></li>
										<li><img src="img/picbig06.jpg"/></li>
										<li><img src="img/picbig07.jpg"/></li>-->
									<!--<li class="active"></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>-->
								</a>
								<!--滑块-->
								<div class="slide"></div>

							</ul>
							<!--放大图的-->
							<!--<div class="pro-big">-->

						</div>
						<!--<div class="pro-big">-->
					</div>
					<!--<div class="pro-big">
								<img class="big-img" src="img/pro01.png" />
						</div>-->
				</div>
				
				<div class="tc">
				<div class="lineSize">
				<!--<span class="close">X</span>-->
				<h3 class="con">尺码对照表<span class="close1">X</span></h3>
				<a href="javaScript:;" id="goodsSizeSpec">
												
				</a>
				<!-- <button class="btn-default" id="sure">确定</button> -->
				</div>
				<!--<div class="bk"></div>-->
				</div>

				<div class="col-md-6">
					<div class="media" id="pro-right">
						<div class="media-left">
							<!--<a href=""><img src="img/belle.png"></a>-->

							<p class="detail2"></p>
							<p class="detail9"></p>

							<h3 class="detail3"></h3>
							<p class="detail4"></p>
							<div class="container detail5"></div>
							<!--<div class="row">-->
							<div class="col-md-6">
								<div class="media">
									<div class="media-body detail6">
										<p style="margin:0">颜色：
											<a href="javaScript:;" id="goodsColor"></a>
											<ul class="brotherColor"></ul>
										</p>
										<span id="single">尺码：</span>
										<p class="detail7">
											<a href="javaScript:;" id="goodsSize" class="CartSize">
												
											</a>
											<!--模态框-->
											<span id="look"><img src="/yougou/img/rule.png"/>查看尺码表>></span>
											

										</p>
										<p>&nbsp;数量：
											<span class="minus">-</span>
											<span class="cart-num">1</span>
											<span class="add">+</span>
											
										</p>
										<p id="star"></p>

										<!--<input class="form-control" type="number" placeholder="1"style="width: 100px;height: 40px;" />-->
										<!--<p><span class="minus">-</span><span class="num">0</span><span class="add">+</span></p>-->
										
										

										<!--模态框-->

										<!--只能作为body子集-->
										<div class="modal fade" data-backdrop="static" id="myModal1">
											<!--窗口层-->
											<div class="modal-dialog">
												<!--内容层-->
												<div class="modal-content" id="context">
													<!--分头部，身体，底部-->
													<div class="model-header">
														<h4><strong>您尚未登陆</strong><span class="close" data-dismiss="modal" id="cha">&times;</span></h4>
													</div>
													<div class="modal-body" style="margin-right: 500px;">
														<div class="form" id="context1">
															<div class="form-head">
																<a href="login.html">
																	<div class="zhmmdl">
																		<input typre="submit" class="zhmmdl-a" value="账号密码登录" />
																	</div>
																</a>
																<a href="phonelogin.html">
																	<div class="sjhkjdl">
																		<input type="submit" class="sjhkjdl-a" value="手机号码登录" />
																	</div>
																</a>
															</div>
															<div class="form-contain"style="margin-left: 25px;">
																<div class="srzh">
																	<div class="box">手机号</div>
																	<input class="printk" placeholder="请输入手机号码" type="text" />
																</div>
																<div class="form-contain-blank"><span class="form-contain-blank-yz">请输入11位手机号码！</span></div>
																<div class="srzh1">
																	<div class="box2">短信验证码</div>
																	<input class="printp" placeholder="" type="password" />
																</div>
																<a href="">
																	<div class="yzm-get">获取验证码</div>
																</a>
																<div class="form-contain-blank1"><span class="form-contain-blank1-yz">请输入验证码！</span></div>
																<div class="loginbtn">
																	<input type="submit" class="loginbtn1" value="点击登录" title="登录" />
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
												</div>

											</div>

										</div>

										<!-- <img id="img_" src="/yougou/img/picsmall01.jpg"> -->
										
										<div class="form-inline">
											<button class="form-control" style="background: #333;color: white;padding-left: 30px;padding-right: 30px;margin-right: 20px;margin-top: 20px;" id="addcart">加入购物袋</button>
											<a href="javaScript:;"><button  class="form-control" style="padding-left: 30px;padding-right: 30px;margin-top: 20px;" id="come">立即购买</button></a>
										</div>
										<!-- 尺码弹窗 -->
										<div class="CartTc">
											<div class="CartLine">
											<!--<span class="close">X</span>-->
											<h3 class="con">您尚未选择尺码<span class="CartClose">X</span></h3>
											<a href="javaScript:;" id="CartSize" class="CartSize">
												
											</a>
											</div>
										</div>

										<div class="form-inline" style="margin-top: 30px;">
											<a href="javaScript:;">
												<p class="glyphicon glyphicon-heart" style="padding-right: 30px;color: black;" data-toggle="modal" data-target="#myModal1">收藏</p>
												<p class="glyphicon glyphicon-share" style="color: black;">分享</p>
											</a>

										</div>

									</div>

								</div>

							</div>
							<div class="pro-big">
								<!--<img class="big-img" src="/yougou/img/pro01.png" />-->
							</div>

						</div>

					</div>

				</div>
			</div>
			<div class="jumbotron text-center">
				<h1>商品信息</h1>
			</div>

			<div class="goods" id="goodsInfo">
				

			</div>

			<div class="jumbotron text-center">
				<h1>尺码信息</h1>
			</div>

			<div class="goods" id="info">
				<!-- <table class="table">
					<tr class="text-center" id="info" width="200px">
				
					</tr>
				</table> -->
			</div>

			<div class="jumbotron text-center">
				<h1>商品详情</h1>
			</div>

			<p align="center" id="goodsDetails">
				
				
			</p>

			<!--缩略图-->
			<div class="container" id="bg">
				<div class="row">
					<div class="col-md-12">
						<!--缩略图-->
						<div class="thumbnail center-block" id="brandDesc">
							
						</div>
					</div>
				</div>
			</div>

			<div class="jumbotron text-center">
				<h1>商品评价</h1>
			</div>

			<div class="judge">
				<p>该商品暂无点评。</p>
				<strong>赶快来发表第一个点评吧！<a href=""><button>我要写点评</button></a></strong>
			</div>

			<div class="jumbotron text-center">
				<h1>猜你喜欢</h1>
			</div>

			<!--动画轮播-->
			<div class="shoes">
				<div class="full">

				</div>
				<!--两个上下按钮-->
				<a href="javascript:;" class="glyphicon glyphicon-menu-left"></a>
				<a href="javascript:;" class="glyphicon glyphicon-menu-right"></a>

			</div>

		</div>
		

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
<script src="/yougou/js/jquery.min.js"></script>
<script src="/yougou/js/bootstrap.js"></script>
<script src="/yougou/js/base.js"></script>
<script src="/yougou/js/pro_center.js"></script>