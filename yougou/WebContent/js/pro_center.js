
//bigImg();

//拿过来goods_id
var goodsId=parseInt(getUrlVal('goods_id'));
$(function(){
	$.get(URL+'api_goods.php',{
		'goods_id':goodsId
	},function(re){
		var obj=JSON.parse(re);
		console.log(obj);
		if(obj.code!=0){
			console.log(obj.message);
			return;
		};
		
		var goodsArr=obj.data;
		var str=``;
		//拿到图片
		for(var i=0;i<goodsArr.length;i++){
			str+=`
          <li>
            <img src="${goodsArr[i].goods_thumb}"/>
          </li>
      `;
      	$('.small a').html(str);
      	$('.big a').html(str);
      	$('.pro-big').html(str);
      	
		}
		
		
			var str1=`
			<p><strong>${obj.data[0].goods_name}</strong></p>
			`;
			$('.detail2').html(str1);
			
			var str1=`
			<p>${obj.data[0].goods_desc}</p>
			`;
			$('.detail9').html(str1);
			
			var str1=`
			${obj.data[0].price}
			`;
			$('.detail3').html('¥'+str1);
			
			var str1=`
			<p>${obj.data[0].star_number}</p>
			`;
			$('#star').html('点赞数💗：'+str1);
			
			 bigImg();
	})
})


//拿过来goods_id
$(function(){
	$.get(URL+'api_goods.php',{
		'cat_id': 62,
		'page': 1,
		'pagesize': 10
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
         <ul class="active1">
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
				
				<ul class="active1">
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
				
				<ul class="active1">
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
	var ulWidth=parseInt($('.active1').css('width'));
	//求ul长度
	var ulLength=$('.active1').length;
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
	$('.glyphicon-menu-right').click(rightBtn);
	
	//上一张方法
	$('.glyphicon-menu-left').click(function(){
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


function bigImg(){
	//鼠标移入移出事件
	$('.big').hover(function(){
		$('.slide,.pro-big').show();
	},function(){
		$('.slide,.pro-big').hide();
	});
	
	//切换图片
	$('.small img').mouseenter(function(){
		//移入当前拿当前的src值
		var nowSrc=$(this).attr('src');
		//再设置另外小图和大图src值
		$('.big img,.pro-big img').attr('src',nowSrc);
	});
	
	//鼠标在up移动
	$('.big').mousemove(function(event){
		//复用事件对象里面鼠标的位置
		var l=event.clientX-$('.big').offset().left-$('.slide').outerWidth()/2;
		var t=event.clientY-$('.big').offset().top-$('.slide').outerHeight()/2+ $(document).scrollTop();
		//验证范围
    	if(l <= 0){l = 0};
    	if(t <= 0){t = 0};
    	var maxL = $('.big').width()-$('.slide').outerWidth();
    	var maxT = $('.big').height()-$('.slide').outerHeight();
    	if(l >= maxL){l = maxL};
    	if(t >= maxT){t = maxT};
		//设置滑块
		$('.slide').css({
			left:l,
			top:t
		});
		//求比例 大图距离/小图距离
//		var biliX=($('.big-img').width()-$('pro-big').width())/($('.big').width()-$('.slide').outerWidth());
		//设置大图移动
		$('.pro-big img').css({left:-l,top:-t});
	});
};


	