//拿过来goods_id
var goodsId=parseInt(getUrlVal('goods_id'));
$(function(){
	$.get('/yougou/goods.do',{
		'method': 'showInfo',
		'goodsId':'100013180'
	},function(re){
		var obj=JSON.parse(re);
		console.log(obj);
		if(obj.code!=0){
			console.log(obj.message);
			return;
		};
		
		var goodsArr=obj.data;
		//$('.detail2').html(obj.data.goodsName);
		var goodsImg = goodsArr.goodsImg;
		//console.log(goodsImg);
		goodsImg=JSON.parse(goodsImg);
		console.log(goodsImg);
		// 拿到图片
		for(var i=0;i<goodsImg.length;i++){
			var str1=`
          <li>
            <img src="${goodsImg[i].goodsSImg}"/>
          </li>
      `;
      		var str2=`
      	  <li>
            <img src="${goodsImg[i].goodsMImg}"/>
          </li>
      `;
            var str3=`
  	      <li>
            <img src="${goodsImg[i].goodsLImg}"/>
          </li>
      `;
      	$('.small a').append(str2);
      	$('.big a').append(str2);
      	$('.pro-big').append(str3);
      	
		}
		
			//商品品牌图片
			var str1=`
			<img src="${goodsArr.brandSImg}"</img>
			`;
			$('.detail2').html(str1);
			//商品名称
			var str1=`
			<p>${goodsArr.goodsName}</p>
			`;
			$('.detail9').html(str1);
			//商品现价
			var str1=`
			<strong>${goodsArr.goodsNewPrice}</strong>
			`;
			$('.detail3').html('¥'+str1);
			//商品原价
			var str1=`
			${goodsArr.goodsOldPrice}
			`;
			$('.detail4').html('¥'+str1);
			//商品颜色
			var goodsCImg=goodsArr.goodsCImg;//商品颜色图
			goodsCImg=JSON.parse(goodsCImg);
			var goodsColor=goodsArr.goodsColor;//商品颜色名
			var str1=`
			<div id="chooseColor">
			<img data-toggle="tooltip" data-placement="left" title="${goodsColor}" src="${goodsCImg.goodsCSImg}" id="img_" />
			<img src="/yougou/img/choose.png" id="scolor"/>
			</div>
			`;
			$('#goodsColor').append(str1);
			var str1=`
			<div class="sub_menu">
			<img data-toggle="tooltip" data-placement="left" title="${goodsColor}" src="${goodsCImg.goodsCMImg}"/>
			</div>
			`;
			$('#goodsColor').append(str1);
			
			//商品尺码
			var goodsSize=goodsArr.goodsSize;
			for(var i=0;i<goodsSize.length;i++){
				var index=goodsSize[i].lastIndexOf('\-');
				goodsSize[i]=goodsSize[i].substring(index+1);
				console.log("===="+goodsSize[i]);
				var str=`
				<span class="goodsSize">
				<span id="xx1">${goodsSize[i]}</span>
				<img src="/yougou/img/choose.png" id="scolor"/>
				</span>
				`;
				$('#goodsSize').append(str);
			}
			
			//国际尺码
			var goodsSizeSpec=goodsArr.goodsSizeSpec;
			console.log(goodsSizeSpec);
			//goodsSizeSpec=JSON.parse(goodsSizeSpec);
			//console.log(goodsSizeSpec.line1);
			//var filedAll = goodsSizeSpec.line1.split(",");
			for(var i=0;i<goodsSizeSpec.length;i++){
				console.log(goodsSizeSpec[i]);
				var str=`
				<span id="Spec">${goodsSizeSpec[i]}</span>
				`;
				$('#goodsSizeSpec').append(str);
			}
			
			
			//商品收藏数
			/*var str1=`
			<p class="glyphicon glyphicon-heart">${goodsArr.goodsCollect}</p>
			`;
			$('#star').html('收藏数：'+str1);*/
			
			//商品信息
			var goodsInfo=goodsArr.goodsInfo;
			//console.log(goodsInfo);
			for(var i=0;i<goodsInfo.length;i++){
				console.log(goodsInfo[i]);
					var str=`
					<td style="line-height: 100px;" data-toggle="tooltip" data-placement="left" title="${goodsInfo[i]}">${goodsInfo[i]}</td>
					`;
					$('#goodsInfo').append(str);
				
			}
			
			//尺码信息
			var goodsSizeSpec=goodsArr.goodsSizeSpec;
			for(var i=0;i<goodsSizeSpec.length;i++){
				var str=`
				<span id="fo" data-toggle="tooltip" data-placement="left" title="${goodsSizeSpec[i]}">${goodsSizeSpec[i]}</span>
				`;
				$('#info').append(str);
			}
			
			//商品详情
			var goodsDetails=goodsArr.goodsDetails;
			for(var i=0;i<goodsDetails.length;i++){
				var str=`
				<img src="${goodsDetails[i]}" />
				`;
				$('#goodsDetails').append(str);
			}
			
			//品牌缩略图
			var brandLImg=goodsArr.brandLImg;
			var brandInfo=goodsArr.brandInfo;
			var str=`
			<img src="${brandLImg}" />
			<div class="caption text-center">
				<p id="brandL">${brandInfo}</p>
			</div>
			`;
			$('#brandDesc').append(str);
			
			 bigImg();
	})
})


// 拿过来goods_id
$(function(){
	$.get('/yougou/index.do', {
		'page': 15,
		'pageSize': 12,
		'method':'getNewProduct',
		'cartId': 'oc1',
	},function(re){
		var obj=JSON.parse(re);
		console.log(obj);
		if(obj.code!=0){
			console.log(obj.message);
			return;
		};
		var goodsArr=obj.data;
		var str=``;
		// 拿到图片
		for(var i=0;i<goodsArr.length;i++){
			str+=`
         <ul class="active1">
					<li class="shoes1">
						<a href="">
							<img src="${goodsArr[0].goodsTImg}" />
						</a>

						<a href="">
							<img src="${goodsArr[0].brandSImg}" id="goodsTImg"/>
							<p>${goodsArr[0].goodsName}</p>
						</a>
						<h1><p><strong>¥${goodsArr[0].goodsNewPrice}</p></strong></h1>
					</li>
					
					<li class="shoes1">
					<a href="">
						<img src="${goodsArr[1].goodsTImg}" />
					</a>

					<a href="">
						<img src="${goodsArr[1].brandSImg}" id="goodsTImg"/>
						<p>${goodsArr[1].goodsName}</p>
					</a>
					<h1><p><strong>¥${goodsArr[1].goodsNewPrice}</p></strong></h1>
				</li>
					
				<li class="shoes1">
				<a href="">
					<img src="${goodsArr[2].goodsTImg}" />
				</a>

				<a href="">
					<img src="${goodsArr[2].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[2].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[2].goodsNewPrice}</p></strong></h1>
			</li>
					
			<li class="shoes1">
			<a href="">
				<img src="${goodsArr[3].goodsTImg}" />
			</a>

			<a href="">
				<img src="${goodsArr[3].brandSImg}" id="goodsTImg"/>
				<p>${goodsArr[3].goodsName}</p>
			</a>
			<h1><p><strong>¥${goodsArr[3].goodsNewPrice}</p></strong></h1>
		</li>
				</ul>
				
				<ul class="active1">
				<li class="shoes1">
				<a href="">
					<img src="${goodsArr[4].goodsTImg}" />
				</a>

				<a href="">
					<img src="${goodsArr[4].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[4].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[4].goodsNewPrice}</p></strong></h1>
			</li>
					
			<li class="shoes1">
			<a href="">
				<img src="${goodsArr[5].goodsTImg}" />
			</a>

			<a href="">
				<img src="${goodsArr[5].brandSImg}" id="goodsTImg"/>
				<p>${goodsArr[5].goodsName}</p>
			</a>
			<h1><p><strong>¥${goodsArr[5].goodsNewPrice}</p></strong></h1>
		</li>
					
		<li class="shoes1">
		<a href="">
			<img src="${goodsArr[6].goodsTImg}" />
		</a>

		<a href="">
			<img src="${goodsArr[6].brandSImg}" id="goodsTImg"/>
			<p>${goodsArr[6].goodsName}</p>
		</a>
		<h1><p><strong>¥${goodsArr[6].goodsNewPrice}</p></strong></h1>
	</li>
					
	<li class="shoes1">
	<a href="">
		<img src="${goodsArr[7].goodsTImg}" />
	</a>

	<a href="">
		<img src="${goodsArr[7].brandSImg}" id="goodsTImg"/>
		<p>${goodsArr[7].goodsName}</p>
	</a>
	<h1><p><strong>¥${goodsArr[7].goodsNewPrice}</p></strong></h1>
</li>
				</ul>
				
				<ul class="active1">
				<li class="shoes1">
				<a href="">
					<img src="${goodsArr[8].goodsTImg}" />
				</a>

				<a href="">
					<img src="${goodsArr[8].brandSImg}" id="goodsTImg"/>
					<p>${goodsArr[8].goodsName}</p>
				</a>
				<h1><p><strong>¥${goodsArr[8].goodsNewPrice}</p></strong></h1>
			</li>
					
			<li class="shoes1">
			<a href="">
				<img src="${goodsArr[9].goodsTImg}" />
			</a>

			<a href="">
				<img src="${goodsArr[9].brandSImg}" id="goodsTImg"/>
				<p>${goodsArr[9].goodsName}</p>
			</a>
			<h1><p><strong>¥${goodsArr[9].goodsNewPrice}</p></strong></h1>
		</li>
					
		<li class="shoes1">
		<a href="">
			<img src="${goodsArr[10].goodsTImg}" />
		</a>

		<a href="">
			<img src="${goodsArr[10].brandSImg}" id="goodsTImg"/>
			<p>${goodsArr[10].goodsName}</p>
		</a>
		<h1><p><strong>¥${goodsArr[10].goodsNewPrice}</p></strong></h1>
	</li>
					
	<li class="shoes1">
	<a href="">
		<img src="${goodsArr[11].goodsTImg}" />
	</a>

	<a href="">
		<img src="${goodsArr[11].brandSImg}" id="goodsTImg"/>
		<p>${goodsArr[11].goodsName}</p>
	</a>
	<h1><p><strong>¥${goodsArr[11].goodsNewPrice}</p></strong></h1>
</li>
				</ul>
				
      `;
      	$('.full').html(str);
      	
      	
      	// 求ul宽度
	var ulWidth=parseInt($('.active1').css('width'));
	// 求ul长度
	var ulLength=$('.active1').length;
	// 设置full宽度
	$('.full').css('width',ulWidth*ulLength);
	// 图片信号量
	var n=0;
	// 下一张方法
	var rightBtn=function(){
		// 节流
		if($('.full').is(':animated')){
			return;
		}
		// 累加
		n++;
		// full标签向左移动的位移
		$('.full').animate({'left':-n*ulWidth},1000,function(){
			// 回调判断到最后一张时闪现回第一张
			if(n>=ulLength-1){
				n=0;
				$('.full').css('left',0);
			}
		});
	}
	$('.glyphicon-menu-right').click(rightBtn);
	
	// 上一张方法
	$('.glyphicon-menu-left').click(function(){
		// 节流
		if($('.full').is(':animated')){
			return;
		}
		// 判断是第一张
		if(n==0){
			n=ulLength-1;
			// 闪现回最后一张
			$('.full').css('left',-n*ulWidth);
		}
		// 累减
		n--;
		$('.full').animate({'left':-n*ulWidth},1000);
	});
      	
      	
      	
		}
	})
})


function bigImg(){
	// 鼠标移入移出事件
	$('.big').hover(function(){
		$('.slide,.pro-big').show();
	},function(){
		$('.slide,.pro-big').hide();
	});
	
	// 切换图片
	$('.small img').mouseenter(function(){
		// 移入当前拿当前的src值
		var nowSrc=$(this).attr('src');
		// 再设置另外小图和大图src值
		$('.big img,.pro-big img').attr('src',nowSrc);
	});
	
	// 鼠标在up移动
	$('.big').mousemove(function(event){
		// 复用事件对象里面鼠标的位置
		var l=event.clientX-$('.big').offset().left-$('.slide').outerWidth()/2;
		var t=event.clientY-$('.big').offset().top-$('.slide').outerHeight()/2+ $(document).scrollTop();
		// 验证范围
    	if(l <= 0){l = 0};
    	if(t <= 0){t = 0};
    	var maxL = $('.big').width()-$('.slide').outerWidth();
    	var maxT = $('.big').height()-$('.slide').outerHeight();
    	if(l >= maxL){l = maxL};
    	if(t >= maxT){t = maxT};
		// 设置滑块
		$('.slide').css({
			left:l,
			top:t
		});
		// 求比例 大图距离/小图距离
// var
// biliX=($('.big-img').width()-$('pro-big').width())/($('.big').width()-$('.slide').outerWidth());
		// 设置大图移动
		$('.pro-big img').css({left:-l,top:-t});
	});
};


$(function(){
    $('#addcart').click(function(){
    //$('.tc').fadeIn();
    //$('#sure').click(function(){
    	 // var id = $(this).attr('id');
        var fly = $('#img_').clone().css('opacity','0.7');
        fly.css({
            'z-index': 90,
            'display': 'block',
            'position': 'absolute',
           // 'top': $('#img_'+id).offset().top +'px',
            'top': $('#img_').offset().top +'px',
            'left': $('#img_').offset().left +'px',
            'width': $('#img_').width() +'px',
            'height': $('#img_').height() +'px'
        });
        $('body').append(fly);
        fly.animate({
            top:$('#end').offset().top,
            left:$('#end').offset().left,
            width:50,
            height:50
        },1000,function(){$(this).remove()});
        var str=parseInt($('#num').text())+1;
        $('#num').text(str).css('display','block');
		//$('.tc').fadeOut();
	});
	/*$('.close').click(function(){
		$('.tc').fadeOut();
	});*/
    });

/*$('#buy').click(function(){
    $('#tc').fadeIn();
});
$('#close').click(function(){
	$('#tc').fadeOut();
});*/
//点击查看尺码表弹出国际尺码表
$(function(){	
$('#look').click(function(){
	$('.tc').fadeIn();
});
$('.close1').click(function(){
	$('.tc').fadeOut();
});
});
/* 点击尺码弹窗中的尺码页面上的尺码会相应的被选中 */

var oPoint=document.querySelector('.detail7');
var aSpan=oPoint.querySelectorAll('#xx1');

// 尺码信号量
	var n=0;
	var x=0;
	// 点击尺码
	$('.xx').each(function(i){
		// 点哪个this就是哪个
		$(this).click(function(){
			// 联动
			n=i;
			x=i;
			// 当前元素添加类名，其他兄弟元素移除类名
			$('.xx').eq(x).addClass('current').siblings('.xx').removeClass('current');
		});
		/*
		 * //尺码跟随 x++; if(x>9){ x=0; } size();
		 */
	});
	
/*
 * //尺码方法封装 function size(){ //排他 for(var i=0;i<aSpan.length;i++){ //先让每一个变为空
 * aSpan[i].className=''; }; //再让当前点击的小圆点变色 aSpan[x].className='current'; };
 */
	// 点击加
	$('.add').click(function(){
	  	// 拿到元素中的number值进行++
	  	var nowNum=parseInt($(this).siblings('.cart-num').html());
	  	nowNum++;
	  	// 设置限购最大值
	  	nowNum=nowNum>=10?10:nowNum;
	  	// 设置累加后的值
	  	$(this).siblings('.cart-num').html(nowNum);
	  });
	  			
	// 点击减
	$('.minus').click(function(){
	  	// 拿到元素中的number值进行++
	  	var nowNum=parseInt($(this).siblings('.cart-num').html());
	  	nowNum--;
	  	// 设置限购最大值
	  	nowNum=nowNum<=1?1:nowNum;
	  	// 设置累加后的值
	  	$(this).siblings('.cart-num').html(nowNum);
	});
