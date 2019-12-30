$(function(){
	var ret = null;
	
	  //打开页面刷新验证码
  changeNum();
  //验证码的更换
  function changeNum(){
  	for(var i=0;i<5;i++){
			    var number = Math.round((Math.random() * 8999)+1000); //随机产生一个0~9之间的数字
			    ret = number;//将随机产生的数字当作字符串的位置下标,在字符串s中取出该字符，并加入到ret中
			  }
    $('#checknumber').text(ret);
  }
  //账号获取焦点
  $('.user-input-phone').focus(function(){
    //提示显示
    $('.user-ts-img').show();
    $('.user-ts').show();
  });
  
  //更换验证码
  $('.checknum-wz').click(function(){
  	changeNum();
  });
  
  //下一步的点击事件
  $('.bootom-next').click(function(){
  	var a = $('.check-inputnumber').val();
  	var b = $('.foot-phoneofnum').val();
  	alert(a);
  	alert(b);
  	if(a == ret && b == '666'){
  		window.location.href = '/yougou/base_html/login.jsp'
  	}else{
  		alert('账号或者验证码有误，请重新输入');
  	}
  });
  
  //获取验证码的点击事件
  $('.check-btn').click(function(){
  	alert('验证码是666');
  });
});