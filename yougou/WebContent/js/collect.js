//判断是否拥有数据
	//无数据的时候
	$('.body-middle').hide();
	goodsCount();
	$('.reducefavor').click(reduce)
	function reduce(){
	 	var reduceFavor = $(this).parent().parent().parent().parent();
	 	reduceFavor.remove();
	 	goodsCount();
	 	if ($('.goods>li').length<1) {
	 		console.log($('.goods>li').length);
	 		$('.body-middle').show();
	 		$('.havegoods').hide()
	 	}
	 }
	function reduceAll(){
		var reduceFavor = $('.goods').children();
	 	reduceFavor.remove();
	 	goodsCount();
	 	if ($('.goods>li').length<1) {
	 		console.log($('.goods>li').length);
	 		$('.body-middle').show();
	 		$('.havegoods').hide()
	 	}
	}
	function goodsCount(){
		console.log($('.goods>li').length)
		var count = ($('.goods>li').length);
		console.log($("#goods-count").text())
		$("#goods-count").html(count);
	}
	//选中元素
	$('.check-all').click(function(){
		 var allVal = $(this).prop('checked');
	   	if(allVal){
	      $('.check').prop('checked', allVal);
	      //给选中的元素设置一个标识
	      $('.check').attr('data-check', 'active');
		    }else{
		      $('.check').prop('checked', allVal);
		      //删除标识
		      $('.check').attr('data-check', ''); 
	    };
		$('.removeall').click(function(){
			reduceAll();
		})
	})