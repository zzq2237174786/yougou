$(function(){
      //判断跳详情还是首页
	  var goodsId=parseInt(getUrlVal('goods_id'));
	  var isUser = false;
	  var isPwd = false;
	
	  //账号获取焦点
	  $('.printk').focus(function(){
	    //提示显示
	    $('.username-msg').show();
	    $('.username-tssize').show();
	  });
	  //密码获取焦点
	  $('.printp').focus(function(){
	    //提示显示
	    $('.password-msg').show();
	    $('.password-tssize').show();
	  });
	  //账号失去焦点
	  $('.printk').blur(function(){
	    //拿到值
	    userVal = $(this).val();
	    //验证
	    if(userVal == ''||userVal == null){
	      $('.username-msg').html('账号不能为空').css('color','#333333');
	      //设置不能登录
	      isUser = false;
	      return;
	    };
	    //手机号  定正则
	    var re = /^[1][3,4,5,7,8][0-9]{9}$/g;
	    if(!re.test(userVal)){
	      $('.username-msg').html('账号格式错误,请输入正确的手机号').css('color', '#333333');
	      $('.printk-ts').hide();
	      //设置不能注册
	      isUser = false;
	    }else{
	      $('.username-msg').hide();
	      $('.username-tssize').hide();
	      $('.printk-ts').show();
	      //设置能登录
	      isUser = true;
	    };
	  });
	  //密码失去焦点
	  $('.printp').blur(function(){
	    //拿到值
	    pwdVal = $(this).val();
	    //验证
	    if(pwdVal == ''||pwdVal == null){
	      $('.password-msg').html('密码不能为空').css('color','#333333');
	      isPwd = false;
	      return;
	    };
	    //6-20位数字  定正则
	    var re = /^[a-zA-Z0-9!@#^&().?*]{6,15}$/;
	    if(!re.test(pwdVal)){
	      $('.password-msg').html('密码格式错误').css('color', '#333333');
	      $('.printp-ts').hide();
	      isPwd = false;
	    }else{
	      $('.password-msg').hide();
	      $('.password-tssize').hide();
	      $('.printp-ts').show();
	      isPwd = true;
	    };
	  });
	
  //用户名和密码做验证
  $('.loginbtn1').click(function(){
	  if(isPwd==false||isUser==false){
		  return;
	  }
    //拿到用户名和密码
    var userVal = $('.printk').val();
    var pwdVal =  $('.printp').val();
    //发起登录请求 
    $.post('/yougou/login.do',{
      method : 'login',
      usersNum : userVal,
      usersPwd : pwdVal
    }, function(re){
      var obj = JSON.parse(re);
      console.log(obj);
      //验证
      if(obj.code == 2002){
        $('.username-msg').html('用户名不存在').css('color',' #333333');
        return;
      };
      if(obj.code == 1001){
        $('.password-msg').html('密码错误').css('color',' #333333');
        return;
      };
      if(obj.code != 0){
        console.log(obj.message);
        return;
      };
      //成功登录  到底是跳转到首页还是其它商品详情？
      //把用户名和token存到本地
      localStorage.setItem('usersNum', obj.data);
      //跳首页还是详情
      if(goodsId){
        location.href = '/yougou/pro_center.jsp?goodsId='+goodsId;
      }else{
        location.href = '/yougou/base_html/index.jsp';      
      };

    });
    
  });
});