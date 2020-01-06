var innerType = function(callback) {
	//查询商品 先获取面包屑里面的物品 拼成对象
	var pmStr = '{';
	$('.breadcrumb-a').each(function() {
		pmStr+="\""+$(this).attr('id') + "\":\"" + $(this).attr('values')+"\",";
	});
	pmStr+="\"method\":\"innerGoodsType\",\"pageSize\":\"12\",\"page\":\"1\"}";
	var innerObj = JSON.parse(pmStr);
	
	//ajax请求数据
	$.ajax({
		url:'/yougou/proType.do',
		type:'post',
		data: innerObj, 
		async: false,
		success: function(re) {
		
		var innerReslut = JSON.parse(re);
		console.log(innerReslut);
		if(innerReslut.code == 1) {
			console.log(innerReslut.message);
			//当前分类下面没有商品
			$('#ul-product').html(
				'<h2 class="text-center">商品还没有上架哦,看看别的吧!</h2>'
			);
			$('#nav-count').html('共>0个结果');
			$('#nav-price-ul').empty();
			$('.pagination').hide();
			return;
		};
		
		if(innerReslut.code != 0) {
			console.log(innerReslut.message);
			return;
		};
		
		var innerData = innerReslut.data;

		
		//结果
		var innerCount = innerData.goodsCount;
		$('#nav-count').html('共>'+innerCount+'个结果');
		
		var listArr = JSON.parse(innerData.goodsData);
		//数据渲染
		var strData =``;
		for(var i = 0; i < listArr.length; i++) {
			 strData += `
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
		};
		//马上做图片预加载
		$('#ul-product').html(strData);
		$('#ul-product [lazyLoadSrc]').YdxLazyLoad();
		
		//添加品类分类
		if(!$('#nav-kind').attr('id')){
			//获取品类分类
			var goodsType = innerData.goodsType;
			if(goodsType){
				var typeArr= JSON.parse(goodsType);
				typeStr = `
					<li id="nav-kind">
					<p class="type-navlist-type-copy"><span></span>品类</p>				
					<div class="type-navlist-content">
					<ul id="nav-kind-ul">
						`;
				for (var i = 0; i < typeArr.length; i++) {
					if(typeArr[i].ocName){
						typeStr+=`
							<li><a href="javaScript:;" class="ocId" values="${typeArr[i].ocId}">${typeArr[i].ocName}</a></li>
						`;
					}else if(typeArr[i].tcName){
						typeStr+=`
							<li><a href="javaScript:;" class="tcId" values="${typeArr[i].tcId}">${typeArr[i].tcName}</a></li>
						`;
					}else{
						typeStr+=`
							<li><a href="javaScript:;" class="ccId" values="${typeArr[i].ccId}">${typeArr[i].ccName}</a></li>
						`;
					}
				}
				typeStr+=`</ul></div></li>`;
				$('#navlist').prepend(typeStr);
			}				
		}
		
		//调用分页方法
		$('.pagination').pagination({
			//这个页数后台要有
			coping: true,
			prevCls: 'page-prev',
			nextCls: 'page-next',
			prevContent: '<上一页',
			nextContent: '下一页>',
			totalData: innerCount,
			showData: 12,
			//回调用来拿当前页码！
			callback: function(event) {
				var pageCurrent = event.getCurrent();
				//做请求数据
				innerObj.page = pageCurrent;
				innerObj.method = 'innerNextGoodsType';
				$.ajax({
					url:'/yougou/proType.do',
					type:'post',
					data: innerObj, 
					async: false,
					success:function(re) {								
						var obj = JSON.parse(re);
						var listArr = obj.data;
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
					}								
				});//请求数据结束	
			}
		}); //分页方法结束		
	  }
	});		//ajax结束	
	
	
	$('.type-navlist-type-copy').click(function() {
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
	
}


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

//拿传过来的cat_id
var ocId = getUrlVal('ocId');
var tcId = getUrlVal('tcId');
var ccId = getUrlVal('ccId');
var goodsBrand = getUrlVal('goodsBrand');

console.log(ocId);
console.log(tcId);
console.log(ccId);
console.log(goodsBrand);


//打开页面请求分类商品 从首页跳转过来
$(function() {
	//请求当前分类 下的商品
	$.get('/yougou/proType.do', {
		'ocId': ocId,
		'tcId': tcId,
		'ccId': ccId,
		'goodsBrand':goodsBrand,
		'page':1,
		'pageSize':12,
		'method':'showGoodsType'
	}, function(re) {
		var obj = JSON.parse(re);
		//验证数据
		if(obj.code == 1) {
			console.log(obj.message);
			//当前分类下面没有商品
			$('#ul-product').html(
				'<h2 class="text-center">商品还没有上架哦,看看别的吧!</h2>'
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
		$('#nav-count').html('共>'+count+'个结果');
		
		//商品总条数
		var allProduct = data.goodsCount;
		
		
		//品牌进入头部设置
		var goodsBrandInfo = data.goodsBrandInfo;
		if(goodsBrandInfo){
			goodsBrandInfo = JSON.parse(data.goodsBrandInfo);
			var brand = ``;
			//品牌推荐 添加品牌信息
			var simg = goodsBrandInfo.brandSImg;
			var limg = goodsBrandInfo.brandLImg;
			var info = goodsBrandInfo.brandInfo;

			if(simg){
				brand+=`
					<div class="brandInfo"><img src="${simg}" id="brandSImg"/></div>
				`;			
			}
			if(limg){
				brand+=`
					<div class="brandInfo"><img src="${limg}" id="brandLImg"/></div>
				`;
			}
			if(info){
				brand+=`
					<div class="brandInfo"><p id="brandInfo">${info}</p></div>
				`;
			}
			//添加信息
			var brandBC = `
				<li>
					<a class="breadcrumb-a" href="javaScirpt:;" id="goodsBrand" values="${goodsBrandInfo.brandId}">${goodsBrandInfo.brandName}</a>
				</li>
			`;
			
			//面包屑设置
			$('.type-content').prepend(brand);
			$('.breadcrumb').append(brandBC);
		}
		
		
		//面包屑设置	
		var breadcrumb = data.breadcrumb;
		if(breadcrumb){
			for (var i = 0; i < breadcrumb.length; i++) {
				if(breadcrumb[i].ocId){
					var str=`
						<li>
							<a class="breadcrumb-a" href="javaScirpt:;" id="ocId" values="${breadcrumb[i].ocId}">${breadcrumb[i].ocName}</a>
					   </li>
					`;
					$('.breadcrumb').append(str);
				}else if(breadcrumb[i].tcId){
					var str=`
						<li>
							<a class="breadcrumb-a" href="javaScirpt:;" id="tcId" values="${breadcrumb[i].tcId}">${breadcrumb[i].tcName}</a>
					   </li>
					`;
					$('.breadcrumb').append(str);
				}else if(breadcrumb[i].ccId){
					var str=`
						<li>
							<a class="breadcrumb-a" href="javaScirpt:;" id="ccId" values="${breadcrumb[i].ccId}">${breadcrumb[i].ccName}</a>
					   </li>
					`;
					$('.breadcrumb').append(str);
				}
			}
		}
		
				
		//获取品牌分类
		var goodsBrandType = data.goodsBrandType;
		if(!goodsBrandType){
			//如果没有就删除这一分类
			$('#navlist').children('#nav-brand').remove(); 
		}else{
			//得到品牌的数据
			var brandArr= JSON.parse(goodsBrandType);
			brandStr = ``;
			for (var i = 0; i < brandArr.length; i++) {
				brandStr+=`
					<li><a href="javaScript:;" class="goodsBrand" values="${brandArr[i].brandId}">${brandArr[i].brandName}</a></li>
				`;
			}
			$('#nav-brand-ul').append(brandStr);
		}
		
		//获取品类分类
		var goodsType = data.goodsType;
		if(goodsType){
			var typeArr= JSON.parse(goodsType);
			typeStr = ``;
			for (var i = 0; i < typeArr.length; i++) {
				if(typeArr[i].ocName){
					typeStr+=`
						<li><a href="javaScript:;" class="ocId" values="${typeArr[i].ocId}">${typeArr[i].ocName}</a></li>
					`;
				}else if(typeArr[i].tcName){
					typeStr+=`
						<li><a href="javaScript:;" class="tcId" values="${typeArr[i].tcId}">${typeArr[i].tcName}</a></li>
					`;
				}else{
					typeStr+=`
						<li><a href="javaScript:;" class="ccId" values="${typeArr[i].ccId}">${typeArr[i].ccName}</a></li>
					`;
				}
			}
			$('#nav-kind-ul').append(typeStr);
		}else{
			$('#navlist').children('#nav-kind').remove(); 
		}
		
		//得到风格分类
		var goodsStyle = data.goodsStyle;
		if(goodsStyle){
			//得到品牌的分类
			var styleArr= JSON.parse(goodsStyle);
			styleStr = ``;
			for (var i = 0; i < styleArr.length; i++) {
				styleStr+=`
					<li><a href="javaScript:;"  class="goodsStyle" values="${styleArr[i].styleName}">${styleArr[i].styleName}</a></li>
				`;
			}
			$('#nav-style-ul').append(styleStr);
		}
		
		
		var goodsData = data.goodsData;
		var listArr= JSON.parse(goodsData);
		
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
				$.get('/yougou/proType.do', {
					'page': pageCurrent,
					'pageSize': 12,
					'ocId': ocId,
					'tcId': tcId,
					'ccId': ccId,
					'goodsBrand':goodsBrand,
					'method':'nextGoodsType'
				}, function(re) {
					
					var obj = JSON.parse(re);
					var listArr = obj.data;
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

 
 $(document).on("click",".goodsStyle, .goodsBrand, .goodsPrice, .ccId, .tcId, .ocId",function(){
	//删除这个分类
		$(this).parent().parent().parent().parent().remove();

		//添加面包屑
		var name = $(this).attr('class');
		var values = $(this).attr('values');
		var text = $(this).text().trim();
		
		var str = `
			<li>
				<a class="breadcrumb-a" href="" id="${name}" values="${values}">${text}</a>
			</li>
		`;
		
		$('.breadcrumb').append(str);
		
		//调用分类方法
		innerType();	
});