$(function(){
	var useVal = null;
	var pwdVal = null;
	var isUser = false;
	var isPwd = false;
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
  
  
  //账号失去焦点
  $('.user-input-phone').blur(function(){
    //拿到值
    userVal = $(this).val();
    //验证
    if(userVal == ''){
      alert('手机号不能为空！');
      //设置不能注册
      isUser = false;
      return;
    };
    //3-20位  定正则
    if(userVal == '111'){
      //要发送请求查看后台数据库没有此注册过
      //这里接口有问题 
      $('.user-ts-img').hide();
      $('.user-ts').hide();
      //设置能注册
      isUser = true;
    }else{
    	$('.user-input-phone').html('手机号不存在').css('color', '#5D5D5D');
    	$('.user-ts-img').show();
    	$('.user-ts').show();
    	//设置不能注册
    	isUser = false;
    };
  });
  
  //验证码失去焦点
  $('.check-inputnumber').blur(function(){
    //拿到值
    pwdVal = $(this).val();
    //验证
    if(pwdVal == ''){
      alert('验证码不能为空！');
      isPwd = false;
      return;
    };
    //6-20位数字  定正则
    if(pwdVal != ret){
    	alert('验证码错误，请重新输入！');
      	isPwd = false;
    }else{
      isPwd = true;
    };
  });
  
  //更换验证码
  $('.checknum-wz').click(function(){
  	changeNum();
  });
  
  //下一步的点击事件
  $('.bootom-next').click(function(){
  	if(isPwd == true && isUser == true){
  		window.location.href = 'findpassword-two.html'
  	}else{
  		alert('账号或者验证码有误，请重新输入');
  	}
  });
  
});


$(function(){
  //用户名和密码做验证
  $('.bootom-next').click(function(){
    //拿到用户名和密码
    var userVal = $('.user-input-phone').val();
    var pwdVal = $('.check-inputnumber').val();
    //验证
    if(userVal == '' || pwdVal == ''){
      alert('用户名和密码不能为空');
      return;
    };
    //发起登录请求 
    $.post(URL + 'api_user.php',{
      status : 'login',
      username : userVal,
      password : pwdVal
    }, function(re){
      var obj = JSON.parse(re);
      console.log(obj);
      //验证
      if(obj.code == 2002){
        $('.user-input-phone').html('用户名不存在').css('color','#5D5D5D');
        return;
      };
      if(obj.code == 1001){
        alert('验证码有误');
        return;
      };
      if(obj.code != 0){
        console.log(obj.message);
        return;
      };
      //成功登录  到底是跳转到首页还是其它商品详情？
      //把用户名和token存到本地
      localStorage.setItem('username', obj.data.username);
      localStorage.setItem('token', obj.data.token);
      //跳首页还是详情
      if(goodsId){
        location.href = 'product.html?goods_id='+goodsId;
      }else{
        location.href = '/yougou/base_html/login.jsp';      
      };

    });
    
  });
});