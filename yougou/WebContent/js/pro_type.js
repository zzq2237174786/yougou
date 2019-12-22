//点击分类导航的展开和关闭
$(function() {
	//获取列表的分类
	$('.type-navlist-type').click(function() {
		//如果内容是隐藏就打开 否则关闭
		if($(this).siblings().is(':hidden')) {
			$(this).siblings().slideDown();
			//图标改变
			$(this).children('span').css({
				'background': 'url(/yougou/img/css_sprites.png) -212px -98px'
			});
		} else {
			$(this).siblings().slideUp();
			$(this).children('span').css({
				'background': 'url(/yougou/img/css_sprites.png) -212px -124px'
			});
		}
	});
});

//列表定位
$(function() {
	$(window).scroll(function() {
		if($(document).scrollTop() > 287) {
			$('.type-nav').css('position', 'fixed');
		} else {
			$('.type-nav').css('position', '');
		}
	});
});

//分类加载数据
//全局变量 每个分类下的页数，size固定为3
var allProduct = 0;

//拿传过来的cat_id
var catId = parseInt(getUrlVal('cat_id'));

//模拟页数
$.ajax({
	url: URL + 'api_goods.php',
	data: {
		'cat_id': catId,
		'page': 1,
		'pagesize': 100000
	},
	async: false,
	dataType: 'json',
	success: function(re) {
		if(re.code == 0) {
			allProduct = re.data.length;
		};
	},
});

//打开页面请求分类商品
$(function() {
	//请求当前分类 下的商品
	$.get(URL + 'api_goods.php', {
		'cat_id': catId,
		'page': 1,
		'pagesize': 12
	}, function(re) {
		var obj = JSON.parse(re);
		//验证数据
		if(obj.code == 1) {
			console.log(obj.message);
			//当前分类下面没有商品
			$('#ul-product').html(
				'<h2 class="text-center">商品还没有上架哦,看看别的吧!</h2>'
			);
			$('.pagination').hide();
			return;
		};
		if(obj.code != 0) {
			console.log(obj.message);
			return;
		};
		//有商品，渲染到页面
		var listArr = obj.data;

		//数据渲染
		for(var i = 0; i < listArr.length; i++) {
			var str = `
     				<li>
						<div class="imgbox">
							<a href="/yougou/base_html/pro_center.html?goods_id=${listArr[i].goods_id}"><img src="/yougou/img/loading.gif" lazyLoadSrc="${listArr[i].goods_thumb}" /><a/>
						</div>
						<div class="product-info">
							<a href="/yougou/base_html/pro_center.html?goods_id=${listArr[i].goods_id}">${listArr[i].goods_desc}</a>
							<p><span class="price">￥${listArr[i].price}</span><span class="old-price">￥888</span></p>
						</div>
					</li>
      			`;
			//内部组装一个添加一个
			$('#ul-product').append(str);
		};
		//马上做图片预加载
		$('#ul-product [lazyLoadSrc]').YdxLazyLoad();
		//调用分页方法
		$('.pagination').pagination({
			//这个页数后台要有
			coping: true,
			prevCls: 'page-prev',
			nextCls: 'page-next',
			prevContent: '<上一页',
			nextContent: '下一页>',
			totalData: allProduct,
			showData: 12,
			//回调用来拿当前页码！
			callback: function(event) {
				var pageCurrent = event.getCurrent();
				//做请求数据了吧
				$.get(URL + 'api_goods.php', {
					cat_id: catId,
					page: pageCurrent,
					pagesize: 12,
				}, function(re) {
					var obj = JSON.parse(re);
					var listArr = obj.data;
					//数据渲染
					var str = ``;
					for(var i = 0; i < listArr.length; i++) {
						str += `
     							<li>
									<div class="imgbox">
									<a href="/yougou/base_html/pro_center.html?goods_id=${listArr[i].goods_id}"><img src="/yougou/img/loading.gif" lazyLoadSrc="${listArr[i].goods_thumb}" /><a/>
									</div>
									<div class="product-info">
										<a href="/yougou/base_html/pro_center.html?goods_id=${listArr[i].goods_id}">${listArr[i].goods_desc}</a>
										<p><span class="price">￥${listArr[i].price}</span><span class="old-price">￥888</span></p>
									</div>
								</li>
          					`;
					};
					$('#ul-product').html(str);
					//马上做图片预加载
					$('#ul-product [lazyLoadSrc]').YdxLazyLoad();
				});
			},
		});
	});
});