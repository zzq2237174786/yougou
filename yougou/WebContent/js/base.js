//公共url前缀
var URL = 'http://www.wjian.top/shop/';

//获取地址栏参数
function getUrlVal(property) {
	//得到地址栏参数的后缀 去掉问号
	var urlStr = window.location.search.substring(1);
	var regex = new RegExp('(^|&)' + property + '=([^&]*)(&|$)');
	var result = urlStr.match(regex);
	if(result == null) {
		return null
	};
	//返回地址栏后面的参数
	return result[2];
}

//判断用户是否登录
function checkLogin() {
	if(localStorage.getItem('username') && localStorage.getItem('token')) {
		//用户登录了
		$('#username').show().html('欢迎！'+localStorage.getItem('username'));
		$('#exit-btn').show();
		$('#register-btn, #login-btn').hide();
		$('#username').siblings('p').hide();
	} else {
		//用户没登录了
		$('#username, #exit-btn').hide();
		$('#register-btn, #login-btn').show();
		$('#username').siblings('p').show();
	};
};

//请求商品分类
$(function() {
	//刷新就请求
	$.get(URL + 'api_cat.php', function(result) {
		var obj = JSON.parse(result);
		//验证
		if(obj.code != 0) {
			console.log(obj.message);
			return;
		};
		//OK的分类
		var listArr = obj.data;
		console.log(listArr);
		var str1 = ` `;
		var str2 = ` `;
		for(var i = 0; i < listArr.length; i++) {
			str1 += `
    			<li><a href="/yougou/base_html/pro_type.html?cat_id=${listArr[i].cat_id}">${listArr[i].cat_name}</a></li>
    			`;
			str2 += `
    				<!--运动-->
					<div>
						<ul class="container">
							<!--品牌-->
							<li>
								<a href="javaScript:;">品牌</a>
								<!--品牌下的详情-->
								<ul>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="javaScript:;">关键词</a>
								<ul>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="javaScript:;">风格</a>
								<ul>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
									<li>
										<a href="javaScript:;">缺货</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
    			`;
		};
		//添加到页面
		$('#nav-type').append(str1);
		$('#nav-content').append(str2);

		//滑动到头部logo下的分类导航时 出现相应的详情
		$(function() {
			$('.logo-nav .nav li a').each(function(i) {
				if(i == 0 || i == 1) {
					return
				};
				$(this).hover(
					function() {
						//相应的详情出现
						$('.nav-content>div').eq(i - 2).delay(300).slideDown(500);
					},
					function() {
						//相应的详情消失
						$('.nav-content>div').siblings().stop(true, true);
						$('.nav-content>div').eq(i - 2).slideUp(500);
					}
				);
			});

			//鼠标移入也会出现
			$('.nav-content>div').each(function(i) {
				$(this).hover(
					function() {
						$(this).stop(true, true);
						$(this).css('display', 'block');
					},
					function() {
						$('.nav-content>div').eq(i).slideUp(500);
					}
				);
			});
		});
	});
});

//用户登录状态
$(function() {
	//刷新验证用户是否登录
	checkLogin();

	//点击退出
	$('#exit-btn').click(function() {
		//清除本地存储
		localStorage.removeItem('username');
		localStorage.removeItem('token');
		checkLogin();
		location.href = '/yougou/base_html/index.html'
	});

	//点击购物车
	$('#cart-btn').click(function() {
		if(localStorage.getItem('username') && localStorage.getItem('token')) {
			//跳购物车
			location.href = '/yougou/base_html/login_cart.html';
		} else {
			//跳登录
			location.href = '/yougou/base_html/login.html';
		}
	});
	//点击收藏
	$('#collect-btn').click(function() {
		if(localStorage.getItem('username') && localStorage.getItem('token')) {
			//跳收藏页面
			location.href = '/yougou/power_html/collect.html';
		} else {
			//跳登录
			location.href = '/yougou/base_html/login.html';
		}
	});
	//产品点击跳购物车
		$('#centerToCart').click(function() {
		if(localStorage.getItem('username') && localStorage.getItem('token')) {
			//跳购物车
			location.href = '/yougou/power_html/login_cart.html';
		} else {
			//跳登录
			location.href = '/yougou/base_html/login.html';
		}
	});
	
	//产品点击跳购物车
		$('#centerToOrder').click(function() {
		if(localStorage.getItem('username') && localStorage.getItem('token')) {
			//跳订单页面
			location.href = '/yougou/power_html/order_submit.html';
		} else {
			//跳登录
			location.href = '/yougou/base_html/login.html';
		}
	});
	//产品点击跳收藏
		$('#centerToCollect').click(function() {
		if(localStorage.getItem('username') && localStorage.getItem('token')) {
			//跳购物车
			location.href = '/yougou/power_html/collect.html';
		} else {
			//跳登录
			location.href = '/yougou/base_html/login.html';
		}
	});
	
	
	
	
});

//窗口滚动事件
$(function() {
	//窗口滚动事件
	$(window).scroll(function() {
		if($(document).scrollTop() > 208) {
			$('.logo-nav').css('position', 'fixed');
			$('.nav-log').css('display', 'block');
		} else {
			$('.logo-nav').css('position', '');
			$('.nav-log').css('display', 'none');
		}
	});
});

/*返回顶部*/
$(function(){
	$(window).scroll(function(){
		//监听窗口滚动
		$(document).scrollTop()>600 ? $('.index-back-top').fadeIn() : $('.index-back-top').fadeOut();
	});	
	
	//点击返回顶部 滚动回顶部
	$('.index-back-top').click(function(){
		$('body , html').animate({scrollTop:0},500);
		$('.index-back-top').fadeIn();
	});
});

/*点击爱心 收藏商品*/
var clickCollect = function(){
	$('.my-collect').each(function(){
		if(localStorage.getItem('username') && localStorage.getItem('token')) {
			$(this).attr({
				'data-toggle':'modal',
				'data-target':'collect-modal'
			});
			$(this).click(function(){
				$(this).css('color','black');
			});
		}else{
			$(this).attr('href','/yougou/base_html/login.html');
		};
	});
};
