//在注册到后台之前，有大量验证要去做
//双重验证：前端要验证，后台也必须验证:
//分离开发模式：从前端传到后台的数据一切都是不可信的!!!

$(function(){
  var isUser = false;
  var isPwd = false;
  var userVal = null;
  var pwdVal = null;
  
  //用户名获取焦点
  $('.printk').focus(function(){
    //提示显示
    $('.phone-yz').show();
  });
  //验证码获取焦点
  $('.printy').focus(function(){
    //提示显示
    $('.ssd-yzm').show();
  });
  //短信验证码获取焦点
  $('.yzm-dx-t').focus(function(){
    //提示显示
    $('.dxyzm-yz-ts').show();
  });
  //密码获取焦点
  $('.yzm-password-t').focus(function(){
    //提示显示
    $('.yzm-password-ts1').show();
  });
  //确认密码获取焦点
  $('.yzm-qrpassword-t').focus(function(){
    //提示显示
    $('.yzm-qrpassword-yz-ts').show();
  });
  
  //用户名失去焦点
  $('.printk').blur(function(){
    //拿到值
    userVal = $(this).val();
    //验证
    if(userVal == ''){
      $('.phone-yz').html('手机号不能为空').css('color','red');
      //设置不能注册
      isUser = false;
      return;
    };
    //3-20位  定正则
    var re = /^[0-9_]{11}$/g;
    if(!re.test(userVal)){
      $('.phone-yz').html('格式错误,必须为11位数字').css('color', 'red');
      //设置不能注册
      isUser = false;
    }else{
      //要发送请求查看后台数据库没有此注册过
      //这里接口有问题 
      $('.phone-yz').html('用户名格式正确').css('color', 'green');
      //设置能注册
      isUser = true;
    };
  });
  
  //验证码失去焦点
  $('.printy').blur(function(){
    //拿到值
    pwdVal = $(this).val();
    //验证
    if(pwdVal == ''){
      $('.ssd-yzm').html('验证码不能为空').css('color','red');
      isPwd = false;
      return;
    };
    //6-20位数字  定正则
    var re = /^[0-9]{4}$/g;
    if(!re.test(pwdVal)){
      $('.ssd-yzm').html('验证码有误,请重新输入！').css('color', 'red');
      isPwd = false;
    }else{
      $('.ssd-yzm').html('验证码正确').css('color', 'green');
      isPwd = true;
    };
  });
  
  //短信验证码失去焦点
  $('.yzm-dx-t').blur(function(){
    //拿到值
    userVal = $(this).val();
    //验证
    if(userVal == ''){
      $('.dxyzm-yz-ts').html('短信验证码不能为空').css('color','red');
      //设置不能注册
      isUser = false;
      return;
    };
    //3-20位  定正则
    var re = /^[0-9]{6}$/g;
    if(!re.test(userVal)){
      $('.dxyzm-yz-ts').html('格式错误,必须为6位数字').css('color', 'red');
      //设置不能注册
      isUser = false;
    }else{
      //要发送请求查看后台数据库没有此注册过
      //这里接口有问题 
      $('.dxyzm-yz-ts').html('短信验证码格式正确').css('color', 'green');
      //设置能注册
      isUser = true;
    };
  });
  
  //密码失去焦点
  $('.yzm-password-t').blur(function(){
    //拿到值
    pwdVal = $(this).val();
    //验证
    if(pwdVal == ''){
      $('.yzm-password-ts1').html('密码不能为空').css('color','red');
      isPwd = false;
      return;
    };
    //6-20位数字  定正则
    var re = /^[0-9]{8}$/g;
    if(!re.test(pwdVal)){
      $('.yzm-password-ts1').html('密码格式有误,请重新输入！').css('color', 'red');
      isPwd = false;
    }else{
      $('.yzm-password-ts1').html('密码正确').css('color', 'green');
      isPwd = true;
    };
  });
  //确认密码失去焦点
  $('.yzm-qrpassword-t').blur(function(){
    //拿到值
    pwdVal = $(this).val();
    //验证
    if(pwdVal == ''){
      $('.yzm-qrpassword-yz-ts').html('密码不能为空').css('color','red');
      isPwd = false;
      return;
    };
    var re = /^[0-9]{8}$/g;
    if(!re.test(pwdVal)){
      $('.yzm-qrpassword-yz-ts').html('格式有误,请重新输入！').css('color', 'red');
      isPwd = false;
    }else{
      $('.yzm-qrpassword-yz-ts').html('密码格式正确').css('color', 'green');
      isPwd = true;
    };
  });
  
  //点击注册
  $('.zhuece-loginbtn').click(function(){
    //点击注册按钮时候看所有项都为true才能请求后台
    if(isUser == false || isPwd == false){
      return;
    };
    console.log('可以注册了');
    console.log(userVal);
    console.log(pwdVal);
    //请求注册之前查看每项都OK发起请求
    $.post(URL + 'api_user.php', {
      status : 'register',
      username : userVal,
      password : pwdVal
    }, function(re){
      var obj = JSON.parse(re);
      console.log(obj);
      //验证
      if(obj.code == 2001){
        $('.printk').html('用户名已存在').css('color', 'red');
        //设置不能注册
        isUser = false;
        return;
      };
      
      if(obj.code != 0){return;}
      //注册成功 把文本框清空,设置不能注册
      $('.printk, .yzm-password-t').val('');     
      isUser = false;
      isPwd = false;
      $('.phone-yz, .yzm-password-t').hide();
      //跳转到登录页面
      alert('注册成功，2秒之后跳转登录页面');
      setTimeout(function(){
        //跳转到登录页面
        window.location.href = '/yougou/base_html/login.html';
      },2000);
    });
  });
  
});
