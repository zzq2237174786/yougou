<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>提交订单中心</title>
		<link rel="stylesheet" type="text/css" href="/yougou/css/shop_cart.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/order_submit.css" />
		<link rel="stylesheet" type="text/css" href="/yougou/css/bootstrap.css" />
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
						<a href="/yougou/base_html/login.html" id="login-btn">登录</a>
						<span id="username"></span>
						<p>/</p>
						<a href="/yougou/base_html/register.html" id="register-btn">注册</a>
						<a href="javaScript:;" id="exit-btn">退出</a>
					</li>
					<!--收藏-->
					<li id="collect-btn">
						<a href="/yougou/base_html/login.html">
							<span class="glyphicon glyphicon-heart"></span> 收藏
						</a>
					</li>
					<!--购物袋-->
					<li id="cart-btn">
						<a href="/yougou/base_html/login.html">
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
		
		<!--顶部-->
		<div class="container">
			<div class="navbar-header">
				<a href=""><img src="/yougou/img/logo.png"/></a>
				<img src="/yougou/img/carlogo.jpg" />
			</div>
			<div class="navbar-left">
				<ul class="nav navbar-nav">
					<li class="active1">我的购物袋<span class="glyphicon glyphicon-menu-right" id="glyphicon"></sapn></li>
					
					<li class="active">提交订单中心
					<span class="glyphicon glyphicon-menu-right" id="glyphicon"></sapn>
					</li>
					<li class="active1">成功提交订单</li>
				</ul>
			</div>
		</div>
		
		<div class="container">
			<div class="text-left" id="car-order">
				<p>请填写您的收货地址
					<a href="/yougou/power_html/login_cart.html">&nbsp;&nbsp;返回购物车</a>
				</p>
				<div class="text-right">
					<button class="btn btn-primary">管理收货地址</button>
				</div>
			</div>
			
			<!--表格加表单-->
			<table align="center">
				<form action="" method="get">
					<tr>
						<td class="text-right" style="width: 200px;">收货人姓名*</td>
						<td class="text-center">
							<input class="form-control" type="text"/>
						</td>
						<td class="text-center" style="width: 550px;">
							<p>（请使用真实姓名，不能全部是数字/英文/包含特殊符号（括号、井号等）） </p>
						</td>
					</tr>
					<tr height="60px">
						<td class="text-right">收货人地址*</td>
						<td class="text-center">
								<select class="form-control"id="provice">
									<option>请选择省</option>
								</select>
						</td>
						<td class="text-left form-inline">
								<select class="form-control" id="city" style="width: 200px;">
									<option>请选择城市</option>
								</select>
								<select class="form-control" id="block">
									<option>请选择县区</option>
								</select>
						</td>	
				
					</tr>
					<tr height="60px">
						<td class="text-right">详细地址：</td>
						<td class="text-center">
							<input class="form-control" type="text"/>
						</td>
					</tr>
					<tr height="60px">
						<td class="text-right">收货人手机*</td>
						<td class="text-center">
							<input class="form-control" type="text" />
						</td>
					</tr>
					
					<tr height="60px">
						<td class="text-right">收货时间*</td>
						<td class="text-center" style="width: 280px;">
							<select class="form-control">
								<option value="只工作日送货(双休日、假日不用送)" name="select" selected>只工作日送货(双休日、假日不用送)</option>
								<option name="select">工作日、双休日与假日均可送货</option>
								<option name="select">只双休日、假日送货(工作日不用送)</option>
							</select>
						</td>
						<td class="text-center">
							<p>(送货时间仅供参考，快递公司会尽量满足您的要求)</p>
						</td>
					</tr>
					
				</form>
			</table>
		</div>
		<div class="container">
			<div class="car-order8">
				<h5 class="text-left">请选择您的付款方式</h5>
				<a href="">
					<p class="text-right">查看银行限额及付款帮助</p>
				</a>
			</div>
		</div>
		
		<div class="container" id="car-order10">
			<p><strong>在线支付</strong> <span>(满99元在线支付免运费)</span></p>
			<button class="btn btn-primary">支付平台</button>
		</div>
		
		<div class="container" id="car-order9">
			
			<input type="radio" name="pay" /><img src="/yougou/img/pay01.png" />
			<input type="radio" name="pay" /><img src="/yougou/img/pay02.png" />
			<input type="radio" name="pay" /><img src="/yougou/img/pay03.png" />
		</div>
		
		<div class="container">
			<input type="radio" name="pay" disabled/><strong>货到付款</strong>
			<span>该商品所在的发货仓库不支持货到付款，请选择其他的支付方式</span>
		</div>
		
		<div class="container">
			<p><strong>确认订单信息</strong></p>
		</div>
		
		<div class="container" id="car-order11">
			<table class="table">
				<tr class="text-center">
					<td></td>
					<td>商品名称</td>
					<td>颜色尺码</td>
					<td>单价</td>
					<td>数量</td>
					<td>小计(元)</td> 
					<td>操作</td> 
				</tr>
				
			</table>
			
			<div class="container">
				<div class="text-right">
					<p><strong>商品总金额：</strong><span class="total">¥410.00</span></p>
					<p><strong>运费：</strong><span>15</span></p>
					<p><strong>满99元在线支付免运费：</strong><span>-15</span></p>
					<p><span>可获得优购积分：1208点</span><strong>应付金额：</strong><span><strong class="total">¥410.00 </strong></span></p>
					<a href="/yougou/power_html/login_cart.html">
						<button class="btn btn-primary" id="back">返回购物车</button>
						
					</a>
					<a href="/yougou/power_html/order_pay.html">
						
						<button class="btn btn-primary" id="sure">确认，提交订单</button>
					</a>
				</div>
			</div>
		</div>
		
		<div class="container" id="car-right">
			<div class="text-right">
			<p>购物保障：
				<img src="/yougou/img/tip01.jpg" />
			   100%正品
			   <img src="/yougou/img/tip02.jpg" />
			   10天退换货
			   <img src="/yougou/img/tip03.jpg" />
			   10天补差价
			</p>
			<img src="/yougou/img/deng.png" />请您在订单提交成功后1小时内完成支付，否则订单将被自动取消
			</div>
			<div class="text-left">
				<p>购物过程中遇到任何问题，请联系在线客服在线咨询 </p>
				<span class="glyphicon glyphicon-earphone"></span>
			</div>
			<div class="text-right">
				<a href="javascript:;">帮助我们改进购物流程 </a>
			</div>
		</div>
		
		<div class="container text-center" id="car-order16">
			<p>Copyright © 2011-2014 Yougou Technology Co., Ltd. 粤ICP备09070608号-4 增值电信业务经营许可证：粤 B2-20090203 </p>
			<div class="text-right">
				<button class="btn btn-primary">联系客服</button>
			</div>
		</div>
	
		<!--返回顶部-->
		<div class="index-back-top">
			<img src="/yougou/img/back-top.png" />
			<p>顶部</p>
		</div>
	</body>
</html>
<script src="/yougou/js/jquery-1.8.3.min.js"></script>
<script src="/yougou/js/jquery.min.js"></script>
<script src="/yougou/js/bootstrap.js"></script>
<script src="/yougou/js/ydxLazyLoad.js"></script>
<script src="/yougou/js/base.js"></script>
<script src="/yougou/js/order_submit.js"></script>