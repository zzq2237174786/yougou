//新品推荐 数据加载
$(function() {
	//新品推荐轮播图方法
	var newSlideShow = function() {
		//获取每一个内容的宽度 4个一组
		var liWidth = 920;
		//4个一组
		var liCount = 4;
		//定义两个信号量
		var NPCount = 0;
		//下一张方法
		var nextPic = function() {
			//节流 
			if($('.slideshow-banner>ul').is(':animated')) {
				return;
			};
			NPCount++;
			//运动 设置ul的left
			$('.slideshow-banner>ul').animate({
				left: -liWidth * NPCount
			}, 200, function() {
				//判断n的值
				if(NPCount >= liCount - 1) {
					NPCount = 0;
					$('.slideshow-banner>ul').css('left', 0);
				};
			});
		};

		//点击下一张
		$('.new-next').click(nextPic);

		//点击上一张
		$('.new-prev').click(function() {
			//节流 
			if($('.slideshow-banner>ul').is(':animated')) {
				return;
			};
			if(NPCount == 0) {
				//闪现到第四张
				$('.slideshow-banner>ul').css('left', -liWidth * (liCount - 1));
				NPCount = 3
			};
			NPCount--;
			//运动 设置ul的left
			$('.slideshow-banner>ul').animate({
				left: -liWidth * NPCount
			}, 200);
		});

		// 新品 点击切换轮播图
		$('.new-product  .title>ul>li>a').each(function(i) {
			$(this).click(function() {
				$(this).addClass('title-active').parent().siblings().children().removeClass('title-active');
				$('.new-product-slideshow .newSlideshow').eq(i).addClass('slideshow-banner').siblings().removeClass('slideshow-banner');
			});
		});
	};

	//新品推荐数据加载 参数 加载的样式 谁加载 分类
	var NPloading = function(catId, module) {
		$.get('/yougou/index.do', {
			'page': 15,
			'pageSize': 12,
			'method':'getNewProduct',
			'cartId': catId,
		}, function(re) {
			var obj = JSON.parse(re);
			//验证数据
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
				<div class="new-product-img">
						<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[i].goodsId}"><img src="/yougou/img/loading.gif" lazyLoadSrc="${listArr[i].goodsTImg}"/></a>
				</div>
				<img src="${listArr[i].brandSImg}" />
				<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[i].goodsId}">${listArr[i].goodsStyle}</a>
				<div class="price">
					<span>￥ ${listArr[i].goodsNewPrice}</span>
					<a href="javaScript:;" class="glyphicon glyphicon-heart my-collect"></a>
				</div>
			</li>
     			 `;
				//内部组装一个添加一个
				module.append(str);
			};
			//把前四个商品在加载一遍 做障眼法
			for(var j = 0; j < 4; j++) {
				var str = `
			<li>
				<div class="new-product-img">
						<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[j].goodsId}"><img src="/yougou/img/loading.gif" lazyLoadSrc="${listArr[j].goodsTImg}"/></a>
				</div>
				<img src="${listArr[j].brandSImg}" />
				<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[j].goodsId}">${listArr[j].goodsStyle}</a>
				<div class="price">
					<span>￥ ${listArr[j].goodsNewPrice}</span>
					<a href="javaScript:;" class="glyphicon glyphicon-heart my-collect"></a>
				</div>
			</li>
     			 `;
				//内部组装一个添加一个
				module.append(str);
			};
			newSlideShow();
			/*点击收藏*/
			clickCollect();
			module.find('[lazyLoadSrc]').YdxLazyLoad();
		});
	};

	//新品轮播图家居 加载数据
	var module1 = $('#newSildeshow1');
	var catId1 = 'oc1';
	NPloading(catId1, module1);
	//新品轮播图数码 加载数据
	var module2 = $('#newSildeshow2');
	var catId2 = 'oc3';
	NPloading(catId2, module2);
});

//今日大牌数据加载
$(function() {
	$.get('/yougou/index.do', {
		'page': 15,
		'pageSize': 3,
		'method':'getBigBrand',
	}, function(re) {
		var obj = JSON.parse(re);
		//验证数据
		if(obj.code != 0) {
			console.log(obj.message);
			return;
		};
		//有商品，渲染到页面
		var listArr = obj.data;
		console.log(listArr);
		//数据渲染
		for(var i = 0; i < listArr.length; i++) {
			var str = `
       			<li>
					<img src="/yougou/img/loading.gif" lazyLoadSrc="/yougou/img/brand${i+1}.jpg"/>
					<a href="/yougou/base_html/pro_type.jsp?goodsBrand=${listArr[i].brandId}"><img src="${listArr[i].brandSImg}" /></a>
				</li>
     			 `;
			//内部组装一个添加一个
			$('#recommend-brands1').append(str);
		};
		$('#recommend-brands1 [lazyLoadSrc]').YdxLazyLoad();
	});


	$.get('/yougou/index.do', {
		'page': 12,
		'pageSize': 3,
		'method':'getBigBrand',
	}, function(re) {
		var obj = JSON.parse(re);
		//验证数据
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
					<img src="/yougou/img/loading.gif" lazyLoadSrc="/yougou/img/brand${i+4}.jpg"/>
					<a href="/yougou/base_html/pro_type.jsp?goodsBrand=${listArr[i].brandId}"><img src="${listArr[i].brandSImg}" /></a>
				</li>
     			 `;
			//内部组装一个添加一个
			$('#recommend-brands2').append(str);
			$('#recommend-brands2 [lazyLoadSrc]').YdxLazyLoad();
		};
	});
});

//品牌潮流 
$(function() {
	//第二行
	$.get('/yougou/index.do', {
		'page':16,
		'pageSize': 4,
		'method':'getNewProduct',
		'cartId': 'oc4',
	}, function(re) {
		var obj = JSON.parse(re);
		//验证数据
		if(obj.code != 0) {
			console.log(obj.message);
			return;
		};
		//有商品，渲染到页面
		var listArr = obj.data;

		//数据渲染
		for(var i = 0; i < listArr.length; i++) {
			var str;
			if(i == listArr.length - 1) {
				str = `
       					<li class="fashion-content2-four">
							<img src="/yougou/img/loading.gif" lazyLoadSrc="${listArr[i].goodsTImg}"/>
							<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[i].goodsId}">${listArr[i].goodsStyle}</a>
						</li>
     			    `;
			} else {
				str = `
       			<li>
					<img src="/yougou/img/loading.gif" lazyLoadSrc="${listArr[i].goodsTImg}"/>
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[i].goodsId}">${listArr[i].goodsStyle}</a>
				</li>
     			 `;
			}
			//内部组装一个添加一个
			$('#fashion-content2').append(str);
		};
		$('#fashion-content2 [lazyLoadSrc]').YdxLazyLoad();
	});

	//第四行
	$.get('/yougou/index.do', {
		'page': 50,
		'pageSize': 8,
		'method':'getNewProduct',
		'cartId': 'oc6',
	}, function(re) {
		var obj = JSON.parse(re);
		//验证数据
		if(obj.code != 0) {
			console.log(obj.message);
			return;
		};
		//有商品，渲染到页面
		var listArr = obj.data;

		//数据渲染
		for(var i = 0; i < listArr.length; i++) {
			var str;
			if(i == 3 || i == 7) {
				str = `
       					<li class="fashion-content4-four">
								<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[i].goodId}">
								<img src="/yougou/img/loading.gif" lazyLoadSrc="${listArr[i].goodsTImg}"/>
								<h3>${listArr[i].goodsName}</h3>
									<p>${listArr[i].brandId}</p>
								</a>
							</li>
     			    `;
			} else {
				str = `
       			<li>
								<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[i].goodsId}">
								<img src="/yougou/img/loading.gif" lazyLoadSrc="${listArr[i].goodsTImg}"/>
								<h3>${listArr[i].goodsName}</h3>
									<p>${listArr[i].brandId}</p>
								</a>
							</li>
     			 `;
			}
			//内部组装一个添加一个
			$('#fashion-content4').append(str);
		};
		$('#fashion-content4 [lazyLoadSrc]').YdxLazyLoad();
	});
});

//*大的广告图轮播 定时器
$(function() {
	//定义一个变量 
	var BnCount = 0;
	//广告图切换函数
	var bigBanner = function() {
		//变换背景图片
		BnCount > 1 ? BnCount = 0 : BnCount = BnCount;
		//获取广告图改变
		$('.big-banner>a').eq(BnCount).addClass('big-banner-active').siblings().removeClass('big-banner-active');
		//小圆点改变
		$('.banner-point li').eq(BnCount).addClass('banner-active').siblings().removeClass('banner-active');
		BnCount++;
	};

	//开启一个定时器
	var bigBannerTimer = setInterval(bigBanner, 5000);
	//移入开启定时器 移除去掉定时器
	$('.big-banner').hover(
		function() {
			clearInterval(bigBannerTimer);
		},
		function() {
			bigBannerTimer = setInterval(bigBanner, 5000);
		}
	);

	//点击小圆点切换图片
	$('.banner-point li').each(function(i) {
		//点击切换
		$(this).click(function() {
			BnCount = i;
			//小圆点变换
			$(this).addClass('banner-active').siblings().removeClass('banner-active');
			//图片切换
			$('.big-banner>a').eq(BnCount).addClass('big-banner-active').siblings().removeClass('big-banner-active');
		});
	});
});

/*大牌推荐*/
$(function() {
	//推荐 点击切换不同的风格
	$('.recommend  .title>ul>li>a').each(function(i) {
		$(this).click(function() {
			$(this).addClass('title-active').parent().siblings().children().removeClass('title-active');
			$('.recommend-content>div').eq(i).addClass('recommend-brands').siblings().removeClass('recommend-brands');
		});
	});

	//点击上一张下一张切换轮播
	//获取每一个内容的宽度 4个一组
	var liWidth = parseInt($('.recommend-banner>ul>li').css('width')) * 10;
	//4个一组
	var liCount = $('.recommend-banner>ul>li').length / 10;
	//定义两个信号量
	var NPCount = 0;
	//下一张方法
	var nextPic = function() {
		//节流 
		if($('.recommend-banner>ul').is(':animated')) {
			return;
		};
		NPCount++;
		//运动 设置ul的left
		$('.recommend-banner>ul').animate({
			left: -liWidth * NPCount
		}, 200, function() {
			//判断n的值
			if(NPCount >= liCount - 1) {
				NPCount = 0;
				$('.recommend-banner>ul').css('left', 0);
			};
		});
	};

	//点击下一张
	$('.recommend-next').click(nextPic);

	//点击上一张
	$('.recommend-prev').click(function() {
		//节流 
		if($('.recommend-banner>ul').is(':animated')) {
			return;
		};
		if(NPCount == 0) {
			//闪现到第四张
			$('.recommend-banner>ul').css('left', -liWidth * (liCount - 1));
			NPCount = 3
		};
		NPCount--;
		//运动 设置ul的left
		$('.recommend-banner>ul').animate({
			left: -liWidth * NPCount
		}, 200);
	});
});

/*品牌潮流质询*/
$(function() {
	//播放视屏
	$('.video-img').each(function(i) {
		$(this).click(function() {
			$(this).css('display', 'none')
		});
	});
});
