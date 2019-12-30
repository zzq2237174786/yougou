
	//导航栏上的时间
		var time = null;
	var timer = function(){
		time = new Date();
		var year = time.getFullYear();
		var month = time.getMonth()+1;
		var dates = time.getDate();
		var hour = time.getHours();
		var minutes = time.getMinutes();
		var seconds = time.getSeconds();
		$('.nowtime').html(year+'年'+month+'月'+dates+'日  '+hour+'时'+minutes+'分'+seconds+'秒');
	};
	
		timer();
	setInterval(timer,1000);

