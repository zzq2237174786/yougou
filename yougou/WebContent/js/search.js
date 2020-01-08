
//拿到导航栏里面的条件
     var vaules = getUrlVal('values');
     var term = decodeURIComponent(decodeURIComponent(vaules));
	
//打开页面请求分类商品 从首页跳转过来
$(function() { 
	//请求当前分类 下的商品
	$.get('/yougou/base.do', {
		'page':1,
		'pageSize':12,
		'method':'sreach',
		'term':vaules
	}, function(re) {
		var obj = JSON.parse(re);
		//验证数据
		if(obj.code == 1) {
			console.log(obj.message);
			//当前分类下面没有商品
			$('#ul-product').html(
				'<h2 class="text-center">商品还没有上架哦,搜索看看别的吧!</h2>'
			);
			$('#nav-count').html('共>0个结果');
			$('#nav-price-ul').empty();
			$('.pagination').hide();
			return;
		};
		if(obj.code != 0) {
			console.log(obj.message);
			return;
		};
	
		//有商品，渲染到页面
		var data = obj.data;
		console.log(obj);	
		
		var count = data.goodsCount;
//		$('#nav-count').html('共>'+count+'个结果');
		
		
		$('#show').html("搜索结果："+count+"条> &nbsp;&nbsp; &nbsp;"+term);
		//商品
		var listArr = data.goodsList;

		//数据渲染
		for(var i = 0; i < listArr.length; i++) {
			var str = `
     				<li>
						<div class="imgbox">
							<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[i].goodsId}"><img src="/yougou/img/loading.gif" lazyLoadSrc="${listArr[i].goodsTImg}" /><a/>
						</div>
						<div class="product-info">
							<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[i].goodsId}">${listArr[i].goodsName}</a>
							<p><span class="price">￥${listArr[i].goodsNewPrice}</span><span class="old-price">￥${listArr[i].goodsOldPrice}</span></p>
						</div>
					</li>
      			`;
			//内部组装一个添加一个
			$('#ul-product').append(str);
			//马上做图片预加载
			$('#ul-product [lazyLoadSrc]').YdxLazyLoad();
		};
		//调用分页方法
		$('.pagination').pagination({
			//这个页数后台要有
			coping: true,
			prevCls: 'page-prev',
			nextCls: 'page-next',
			prevContent: '<上一页',
			nextContent: '下一页>',
			totalData: count,
			showData: 12,
			//回调用来拿当前页码！
			callback: function(event) {
				var pageCurrent = event.getCurrent();
				//做请求数据了吧
				$.get('/yougou/base.do', {
					'page':pageCurrent,
					'pageSize':12,
					'method':'sreach',
					'term':vaules
				}, function(re) {	
					var obj = JSON.parse(re);
					console.log(obj);
					var data = obj.data;
					var listArr = data.goodsList;
					//数据渲染
					var str = ``;
					for(var i = 0; i < listArr.length; i++) {
						str += `
     							<li>
									<div class="imgbox">
									<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[i].goodsId}"><img src="/yougou/img/loading.gif" lazyLoadSrc="${listArr[i].goodsTImg}" /><a/>
									</div>
									<div class="product-info">
										<a href="/yougou/base_html/pro_center.jsp?goodsId=${listArr[i].goodsId}">${listArr[i].goodsName}</a>
										<p><span class="price">￥${listArr[i].goodsNewPrice}</span><span class="old-price">￥${listArr[i].goodsOldPrice}</span></p>
									</div>
								</li>
          					`;
					};
					$('#ul-product').html(str);
					//马上做图片预加载
					$('#ul-product [lazyLoadSrc]').YdxLazyLoad();
				});
			}
		});	
	});	
});