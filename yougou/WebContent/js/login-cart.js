

	 //请求数据
	//var cartId=parseInt(getUrlVal('cartId'));
  		$(function(){
  			//根据userStockt请求stocktId
  			$.get('/yougou/cart.do',{
  				'method': 'userStock',
  				},
  			function(re){
  				var obj=JSON.parse(re);
  				console.log(obj);
  				//验证
  				if(obj.code!=0){
  					console.log(obj.message);
  					return;
  				}
  				var listArr=obj.data;
  				var allStock=listArr.stockId;
  				var filedAll = allStock.split(",");
  				console.log(filedAll);
  				//遍历数组数据拿到每一个stockId
  				for(var i=0;i<filedAll.length;i++){
  					var stockId=filedAll[i];
  					if(stockId==""){
  						return;
  					}
  					//根据stockId请求goodsId
  					$.get('/yougou/cart.do',{
  		  				'method': 'goodStock',
  		  				'stockId':stockId
  		  				},
  		  			function(re){
  		  				var obj=JSON.parse(re);
  		  				console.log(obj);
  		  				//验证
  		  				if(obj.code!=0){
  		  					console.log(obj.message);
  		  					return;
  		  				}
  		  				//拿到每一个goodsId
  		  				var goodsId=obj.data.goodsId;
  		  				//根据goodsId请求商品信息
  		  			$.get('/yougou/cart.do',{
  		  				'method': 'cartInfo',
  		  				'goodsId':goodsId
  		  				},
  		  			function(re){
  		  				var obj=JSON.parse(re);
  		  				console.log(obj);
  		  				//验证
  		  				if(obj.code!=0){
  		  					console.log(obj.message);
  		  					return;
  		  				}
  		  				var cartGoods=obj.data;
  		  				var goodsImg=cartGoods.goodsImg;
  		  				goodsImg=JSON.parse(goodsImg);
  		  				//渲染数据
  		  			var str=`
						<tr class="del-all">
  		  					<td class="form-inline">
  		  						<input class="check" type="checkbox"/>&nbsp;&nbsp;<img lazyLoadSrc="${goodsImg[0].goodsSImg}" src="/yougou/img/loading.gif" />
  		  					</td>
  		  					<td title="${cartGoods.goodsName}">${cartGoods.goodsName}</td>
  		  					<td class="cart-desc">${cartGoods.goodsColor}<p>${cartGoods.goodsSize}</p></td>
  		  					<td class="unit-price">${cartGoods.goodsNewPrice}</td>
  		  					<td>
  		  						<span class="minus">-</span>
  		  						<span class="cart-num">1</span>
  		  						<span class="add">+</span>
  		  					</td>
  		  					<td class="subtotal" style="font-weight: bold;">${cartGoods.goodsNewPrice}</td>
  		  					<td>
  		  						<a href="javascript:;">
  		  						<p>移入收藏夹 </p>
  		  						<p class="del-btn">删除</p>
  		  						</a>
  		  					</td>
  		  				</tr>
					`;
					//组装好一个添加一个
					$('#table').append(str);
					//预加载图片
					$('#table [lazyLoadSrc]').YdxLazyLoad();
//  		  				
//  		  				}
//  		  				)
//  				}
//  				)	
//  				}
//  			});
//  		});
					//数据结构渲染到页面之后进行交互操作
					cartEvent();
//					console.log("----");
					
					
					
					
  		  				}
  		  				)
  		  				}
  		  				)
  				}
  				
  			
  			
  				
  				
  				
  				
  				}
  				)
  		})
  			//点击加
  			$('#table').on('click','.add',function(){
	  				//拿到元素中的number值进行++
	  				var nowNum=parseInt($(this).siblings('.cart-num').html());
	  				nowNum++;
	  				//设置限购最大值
	  				nowNum=nowNum>=10?10:nowNum;
	  				//设置累加后的值
	  				$(this).siblings('.cart-num').html(nowNum);
	  				//求小计
	  				var unitPrice=parseInt($(this).parent().siblings('.unit-price').html());
	  				var subtotal=$(this).parent().siblings('.subtotal');
	  				subtotal.html(nowNum*unitPrice+'.00');
	  				//求总价
	  				total();
	  			});			
  			//点击减
  			$('#table').on('click','.minus',function(){
				//拿到元素中的number值进行++
				var nowNum=parseInt($(this).siblings('.cart-num').html());
				nowNum--;
				//设置限购最大值
				nowNum=nowNum<=1?1:nowNum;
				//设置累加后的值
				$(this).siblings('.cart-num').html(nowNum);
				//求小计
				var unitPrice=parseInt($(this).parent().siblings('.unit-price').html());
				var subtotal=$(this).parent().siblings('.subtotal');
				subtotal.html(nowNum*unitPrice+'.00');
				//求总价
				total();
			});
  			
  			//点击清空购物袋
  			$('#del-all').click(function(){
  				var tr=$('.del-all');
  				tr.remove();
  				$('#table').append('<strong>'+'购物车为空，请去选择心仪的商品吧！'+'</strong>');
  			});
					
  		
  		//购物车交互操作
  		function cartEvent(){
  			//点击全选
  			$('#selectAll').click(function(){
  				console.log($(this).prop('checked'));
  				var allVal=$(this).prop('checked');
  				if(allVal){
  					$('.check').prop('checked',allVal);
  					//给选中的元素设置一个标识
  					$('.check').attr('data-check','active');
  				}else{
  					$('.check').prop('checked',allVal);
  					//删除标识为空
  					$('.check').attr('data-check','');
  				}
  				//求总价
  				total();
  			});
  			
  			//点击单选
  			$('.check').click(function(){
  				if($(this).prop('checked')){
  					//给当前点击元素设置一个标识
  					$(this).attr('data-check','active');
  				}else{
  					//删除当前点击的标识
  					$(this).attr('data-check','');
  				};
  				//求总价
  				total();
  			});
  			
  			//点击删除
  			$('.del-btn').click(function(){
  				var tr=$(this).parent().parent().parent();
  				tr.remove();
  				//求总计
  				total();
  			});
  			
  		};
  		
  		//求总价方法
  		function total(){
  			//判断所有单选有没有选中
  			//拿到有属性data-chech="active"的元素
  			var priceSum=0;
  			$('[data-check="active"]').each(function(){
  				priceSum+=parseInt($(this).parent().siblings('.subtotal').html());
  			});
  			//给总价元素渲染数据
  			$('.total strong').html('¥'+priceSum+'.00');
  		}
  		
  		
  		
//拿过来goods_id
//var goodsId=parseInt(getUrlVal('goods_id'));
$(function(){
	$.get('/yougou/index.do',{
		'page': 15,
		'pageSize': 12,
		'method':'getNewProduct',
		'cartId': 'oc'+Math.ceil(Math.random()*6),
	},function(re){
		var obj=JSON.parse(re);
		if(obj.code!=0){
			console.log(obj.message);
			return;
		};
		var goodsArr=obj.data;
		var str=``;
		//拿到图片
		for(var i=0;i<goodsArr.length;i++){
			str+=`
         <ul class="active88">
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[0].goodsId}">
					<img src="${goodsArr[0].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[0].goodsId}">
					<img src="${goodsArr[0].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[0].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[0].goodsNewPrice}</p></strong></h1>
					</li>
					
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[1].goodsId}">
					<img src="${goodsArr[1].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[1].goodsId}">
					<img src="${goodsArr[1].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[1].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[1].goodsNewPrice}</p></strong></h1>
					</li>
					
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[2].goodsId}">
					<img src="${goodsArr[2].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[2].goodsId}">
					<img src="${goodsArr[2].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[2].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[2].goodsNewPrice}</p></strong></h1>
					</li>
					
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[3].goodsId}">
					<img src="${goodsArr[3].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[3].goodsId}">
					<img src="${goodsArr[3].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[3].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[3].goodsNewPrice}</p></strong></h1>
					</li>
				</ul>
				
				<ul class="active88">
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[4].goodsId}">
					<img src="${goodsArr[4].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[4].goodsId}">
					<img src="${goodsArr[4].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[4].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[4].goodsNewPrice}</p></strong></h1>
					</li>
					
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[5].goodsId}">
					<img src="${goodsArr[5].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[5].goodsId}">
					<img src="${goodsArr[5].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[5].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[5].goodsNewPrice}</p></strong></h1>
					</li>
					
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[6].goodsId}">
					<img src="${goodsArr[6].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[6].goodsId}">
					<img src="${goodsArr[6].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[6].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[6].goodsNewPrice}</p></strong></h1>
					</li>
					
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[7].goodsId}">
					<img src="${goodsArr[7].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[7].goodsId}">
					<img src="${goodsArr[7].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[7].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[7].goodsNewPrice}</p></strong></h1>
					</li>
				</ul>
				
				<ul class="active88">
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[8].goodsId}">
					<img src="${goodsArr[8].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[8].goodsId}">
					<img src="${goodsArr[8].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[8].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[8].goodsNewPrice}</p></strong></h1>
					</li>
					
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[9].goodsId}">
					<img src="${goodsArr[9].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[9].goodsId}">
					<img src="${goodsArr[9].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[9].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[9].goodsNewPrice}</p></strong></h1>
					</li>
					
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[10].goodsId}">
					<img src="${goodsArr[10].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[10].goodsId}">
					<img src="${goodsArr[10].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[10].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[10].goodsNewPrice}</p></strong></h1>
					</li>
					
					<li class="shoes1">
					<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[11].goodsId}">
					<img src="${goodsArr[11].goodsTImg}" />
				</a>

				<a href="/yougou/base_html/pro_center.jsp?goodsId=${goodsArr[11].goodsId}">
					<img src="${goodsArr[11].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[11].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[11].goodsNewPrice}</p></strong></h1>
					</li>
				</ul>
				
      `;
      	$('.full').html(str);
      	
      	
      	//求ul宽度
	var ulWidth=parseInt($('.active88').css('width'));
	//求ul长度
	var ulLength=$('.active88').length;
	//设置full宽度
	$('.full').css('width',ulWidth*ulLength);
	//图片信号量
	var n=0;
	//下一张方法
	var rightBtn=function(){
		//节流
		if($('.full').is(':animated')){
			return;
		}
		//累加
		n++;
		//full标签向左移动的位移
		$('.full').animate({'left':-n*ulWidth},1000,function(){
			//回调判断到最后一张时闪现回第一张
			if(n>=ulLength-1){
				n=0;
				$('.full').css('left',0);
			}
		});
	}
	$('.glyphicon-hand-left').click(rightBtn);
	
	//上一张方法
	$('.glyphicon-hand-right').click(function(){
		//节流
		if($('.full').is(':animated')){
			return;
		}
		//判断是第一张
		if(n==0){
			n=ulLength-1;
			//闪现回最后一张
			$('.full').css('left',-n*ulWidth);
		}
		//累减
		n--;
		$('.full').animate({'left':-n*ulWidth},1000);
	});
      	
      	
      	
		}
	})
})