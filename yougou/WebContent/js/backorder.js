$('.body-middle').hide();
	var reduceFavor = $('.goods').children();	 	
	 if ($('.goods>li').length<1) {
	 	console.log($('.goods>li').length);
	 	$('.body-middle').show();
	 	$('.havegoods').hide()
	 }
	var count = ($('.goods>li').length);	
	$("#span1").html(count);

