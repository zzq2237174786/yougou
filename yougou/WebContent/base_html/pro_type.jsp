<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品分类</title>
		<!--移动端优先-->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/pro_type.css" />
		<script type="text/javascript" src="/yougou/js/jquery.min.js"></script>
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
										<a href="/yougou/base_html/index.jsp">首页</a>
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

		<hr/>
		<!--分类-->
		<div class="type">
			<div class="container">
				<!--分类标签 面包屑-->
				<div class="row type-title">
					<ul class="breadcrumb">
						<li>
							<a href="">首页</a>
						</li>
						<li>
							<a href="">分类</a>
						</li>
					</ul>
				</div>

				<!--分类导航和内容-->
				<div class="row">
					<!--左边的导航栏-->
					<div class="type-nav">
						<!--搜索结果-->
						<p>共>666个结果</p>

						<!--导航列表-->
						<ul class="type-navlist">
							<!--品牌-->
							<li>
								<p class="type-navlist-type"><span></span>品牌</p>
								<!--详情-->
								<div class="type-navlist-content">
									<ul>
										<li>
											<a href="">百丽</a>
										</li>
										<li>
											<a href="">天意美</a>
										</li>
										<li>
											<a href="">百思图</a>
										</li>
										<li>
											<a href="">他他</a>
										</li>
										<li>
											<a href="">森达</a>
										</li>
										<li>
											<a href="">思加图</a>
										</li>
										<li>
											<a href="">拔佳</a>
										</li>
									</ul>
								</div>
							</li>
							<!--种类-->
							<li>
								<p class="type-navlist-type"><span></span>品类</p>
								<!--详情-->
								<div class="type-navlist-content">
									<ul>
										<li>
											<a href="">女士鞋子</a>
										</li>
										<li>
											<a href="">女士单鞋</a>
										</li>
										<li>
											<a href="">女士凉鞋</a>
										</li>
								</div>
							</li>
							<!--价格-->
							<li>
								<p class="type-navlist-type"><span></span>价格</p>
								<!--详情-->
								<div class="type-navlist-content">
									<ul>
										<li>
											<a href="">500-100</a>
										</li>
										<li>
											<a href="">101-200</a>
										</li>
										<li>
											<a href="">201-300</a>
										</li>
										<li>
											<a href="">301-500</a>
										</li>
										<li>
											<a href="">501-700</a>
										</li>
										<li>
											<a href="">701-1000</a>
										</li>
										<li>
											<a href="">1000以上</a>
										</li>
									</ul>
								</div>
							</li>
							<!--尺码-->
							<li>
								<p class="type-navlist-type"><span></span>尺码</p>
								<!--详情-->
								<div class="type-navlist-content">
									<ul>
										<li>
											<a href="">28cm</a>
										</li>
										<li>
											<a href="">30</a>
										</li>
										<li>
											<a href="">31</a>
										</li>
										<li>
											<a href="">32</a>
										</li>
										<li>
											<a href="">33</a>
										</li>
										<li>
											<a href="">34</a>
										</li>
										<li>
											<a href="">35</a>
										</li>
										<li>
											<a href="">36</a>
										</li>
										<li>
											<a href="">37</a>
										</li>
									</ul>
								</div>
							</li>
							<!--颜色-->
							<li>
								<p class="type-navlist-type"><span></span>颜色</p>
								<!--详情-->
								<div class="type-navlist-content">
									<ul>
										<li>
											<a href="">黑色</a>
										</li>
										<li>
											<a href="">白色</a>
										</li>
										<li>
											<a href="">粉色</a>
										</li>
										<li>
											<a href="">棕色</a>
										</li>
										<li>
											<a href="">青色</a>
										</li>
										<li>
											<a href="">黄色</a>
										</li>
										<li>
											<a href="">拼色</a>
										</li>
										<li>
											<a href="">七彩</a>
										</li>
										<li>
											<a href="">紫色</a>
										</li>
									</ul>
								</div>
							</li>
							<!--款式季节-->
							<li>
								<p class="type-navlist-type"><span></span>季节款式</p>
								<!--详情-->
								<div class="type-navlist-content">
									<ul>
										<li>
											<a href="">春季</a>
										</li>
										<li>
											<a href="">夏季</a>
										</li>
										<li>
											<a href="">秋季</a>
										</li>
										<li>
											<a href="">冬季</a>
										</li>
									</ul>
								</div>
							</li>
							<!--风格-->
							<li>
								<p class="type-navlist-type"><span></span>风格</p>
								<!--详情-->
								<div class="type-navlist-content">
									<ul>
										<li>
											<a href="">休闲</a>
										</li>
										<li>
											<a href="">简约</a>
										</li>
										<li>
											<a href="">复古</a>
										</li>
										<li>
											<a href="">欧美</a>
										</li>
										<li>
											<a href="">帅气</a>
										</li>
										<li>
											<a href="">潮流</a>
										</li>
										<li>
											<a href="">英伦</a>
										</li>
										<li>
											<a href="">性感</a>
										</li>
										<li>
											<a href="">甜美</a>
										</li>
									</ul>
								</div>
							</li>
							</ul>
					</div>

					<!--右边的内容-->
					<div class="type-content">
						<!--上面的导航条-->
						<div class="type-content-nav">
							<!--导航-->
							<ul>
								<li>
									<a href="">新品</a>
								</li>
								<li>
									<a href="" class="active">热销</a>
								</li>
								<li>
									<a href="">推荐</a>
								</li>
								<li>
									<a href="">价格</a>
								</li>
								<li>
									<a href="">折扣</a>
								</li>
							</ul>
							<!--翻页-->
							<div class="nav-page">
								<span>1</span> - <span>60</span> / 页
								<span><a href="">下一页></a></span>
							</div>
						</div>

						<!--产品-->
						<div class="type-content-product">
							<ul class="ul-product" id="ul-product">
							</ul>
						</div>
					</div>

				</div>

				<!--分页-->
				<div class="row  type-page">
					<div class="pagination"></div>
				</div>
			</div>
		</div>
		
		<!--返回顶部-->
		<div class="index-back-top">
			<img src="/yougou/img/back-top.png" />
			<p>顶部</p>
		</div>
	</body>

</html>
<!--js-->
<script type="text/javascript" src="/yougou/js/jquery.min.js"></script>
<script type="text/javascript" src="/yougou/js/bootstrap.js"></script>
<script type="text/javascript" src="/yougou/js/ydxLazyLoad.js"></script>
<script type="text/javascript" src="/yougou/js/jquery.pagination.js"></script>
<script src="/yougou/js/base.js"></script>
<script src="/yougou/js/pro_type.js"></script>
<script>

</script>