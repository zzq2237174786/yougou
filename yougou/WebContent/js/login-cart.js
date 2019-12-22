	//请求数据
//		var goodsId=parseInt(getUrlVal('goods_id'));
  		$(function(){
  			$.get(URL+'api_goods.php',{'goods_id':34233},
  			function(re){
  				var obj=JSON.parse(re);
  				console.log(obj);
  				//验证
  				if(obj.code!=0){
  					console.log(obj.message);
  					return;
  				}
  				var listArr=obj.data;
  				//遍历数组数据
  				for(var i=0;i<listArr.length;i++){
  					var str=`
  						<tr class="del-all">
					<td class="form-inline">
						<input class="check" type="checkbox"/>&nbsp;&nbsp;<img lazyLoadSrc="${listArr[i].goods_thumb}" src="/yougou/img/loading.gif" />
					</td>
					<td title="${listArr[i].goods_name}">${listArr[i].goods_name}</td>
					<td class="cart-desc">${listArr[i].goods_desc}</td>
					<td class="unit-price">${listArr[i].price}</td>
					<td>
						<span class="minus">-</span>
						<span class="cart-num">1</span>
						<span class="add">+</span>
					</td>
					<td class="subtotal" style="font-weight: bold;">${listArr[i].price}</td>
					<td>
						<a href="javascript:;">
							<p>移入收藏夹 </p>
						</br>
						<p class="del-btn">删除</p>
						</a>
					</td>
				</tr>
  					`;
  					//组装好一个添加一个
  					$('#table').append(str);
  				};
  				//预加载图片
  				$('#table [lazyLoadSrc]').YdxLazyLoad();
  				//数据结构渲染到页面之后进行交互操作
  				cartEvent();
  				
  			});
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
  			
  			//点击加
  			$('.add').click(function(){
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
  			$('.minus').click(function(){
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
  			
  			//点击删除
  			$('.del-btn').click(function(){
  				var tr=$(this).parent().parent().parent();
  				tr.remove();
  				//求总计
  				total();
  			});
  			
  			//点击清空购物袋
  			$('#del-all').click(function(){
  				var tr=$('.del-all');
  				tr.remove();
  				$('#table').append('<strong>'+'购物车为空，请去选择心仪的商品吧！'+'</strong>');
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
var goodsId=parseInt(getUrlVal('goods_id'));
$(function(){
	$.get(URL+'api_goods.php',{
		'goods_id':goodsId
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
						<a href="">
							<img src="${goodsArr[0].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[0].goods_name}</strong></p>
							<p>${goodsArr[0].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[0].price}</p></strong></h1>
					</li>
					
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[1].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[1].goods_name}</strong></p>
							<p>${goodsArr[1].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[1].price}</p></strong></h1>
					</li>
					
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[2].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[2].goods_name}</strong></p>
							<p>${goodsArr[2].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[2].price}</p></strong></h1>
					</li>
					
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[3].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[3].goods_name}</strong></p>
							<p>${goodsArr[3].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[3].price}</p></strong></h1>
					</li>
				</ul>
				
				<ul class="active88">
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[4].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[4].goods_name}</strong></p>
							<p>${goodsArr[4].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[4].price}</p></strong></h1>
					</li>
					
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[5].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[5].goods_name}</strong></p>
							<p>${goodsArr[5].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[5].price}</p></strong></h1>
					</li>
					
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[6].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[6].goods_name}</strong></p>
							<p>${goodsArr[6].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[6].price}</p></strong></h1>
					</li>
					
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[7].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[7].goods_name}</strong></p>
							<p>${goodsArr[7].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[7].price}</p></strong></h1>
					</li>
				</ul>
				
				<ul class="active88">
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[8].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[8].goods_name}</strong></p>
							<p>${goodsArr[8].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[8].price}</p></strong></h1>
					</li>
					
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[9].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[9].goods_name}</strong></p>
							<p>${goodsArr[9].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[9].price}</p></strong></h1>
					</li>
					
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[1].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[1].goods_name}</strong></p>
							<p>${goodsArr[1].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[1].price}</p></strong></h1>
					</li>
					
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[0].goods_thumb}" />
						</a>

						<a href="">
							<p><strong>${goodsArr[0].goods_name}</strong></p>
							<p>${goodsArr[0].goods_desc}</p>
						</a>
						<h1><p><strong>¥${goodsArr[0].price}</p></strong></h1>
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