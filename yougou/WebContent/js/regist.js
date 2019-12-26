//在注册到后台之前，有大量验证要去做
//双重验证：前端要验证，后台也必须验证:
//分离开发模式：从前端传到后台的数据一切都是不可信的!!!

$(function(){
  var isUser = false;
  var isPwd = false;
  var userVal = null;
  var pwdVal = null;
  var repwdVal = null;
  
  //用户名获取焦点
  $('.phone-right').focus(function(){
    //提示显示
    $('.phone-check').show();
  });
  //验证码获取焦点
  $('.checknumber-right').focus(function(){
    //提示显示
    $('.checknumber-check').show();
  });
  //短信验证码获取焦点
  $('.newschecknumber-right').focus(function(){
    //提示显示
    $('.newschecknumber-check').show();
  });
  //密码获取焦点
  $('.password-right').focus(function(){
    //提示显示
  	$('.password-check').show();
                function checkStrong(val) {
                    var modes = 0;
                    if (val.length < 6) return 0;
                    if (/\d/.test(val)) modes++; //数字
                    if (/[a-z]/.test(val)) modes++; //小写
                    if (/[A-Z]/.test(val)) modes++; //大写  
                    if (/\W/.test(val)) modes++; //特殊字符
                    if (val.length > 12) return 3;
                    return modes;
                };
                $(".password-right").keyup(function() {
                    var val = $(this).val();
                    var num = checkStrong(val);
                    switch (num) {
                        case 0:
                            break;
                        case 1:
                            $(".password-high").css('background', 'green');
                            break;
                        case 2:
                            $(".password-middle").css('background', 'red');
                            break;
                         case 3:
                            $(".password-low").css('background', 'yellow');
                            break;
                        default:
                            break;
                    }
                })
  });
  //确认密码获取焦点
  $('.repassword-right').focus(function(){
    //提示显示
    $('.repassword-check').show();
  });
  
  //用户名失去焦点
  $('.phone-right').blur(function(){
    //拿到值
    userVal = $(this).val();
    //验证
    if(userVal == ''){
      $('.phone-check-text').html('手机号不能为空').css('color','#333333');
      //设置不能注册
      isUser = false;
      return;
    };
    //3-20位  定正则
    var re = /^[0-9_]{11}$/g;
    if(!re.test(userVal)){
      $('.phone-check-text').html('格式错误,必须为11位数字').css('color', '#333333');
      //设置不能注册
      isUser = false;
    }else{
      //要发送请求查看后台数据库没有此注册过
      //这里接口有问题 
      $('.phone-check-text').hide();
      $('.phone-right-ts').show();
      $('.phone-ts').hide();
      //设置能注册
      isUser = true;
    };
  });
  
  //验证码失去焦点
  $('.checknumber-right').blur(function(){
    //拿到值
    pwdVal = $(this).val();
    //验证
    if(pwdVal == ''){
      $('.checknumber-check-text').html('验证码不能为空').css('color','#333333');
      isPwd = false;
      return;
    };
    //6-20位数字  定正则
    var re = /^[0-9]{4}$/g;
    if(!re.test(pwdVal)){
      $('.checknumber-check-text').html('验证码有误,请重新输入！').css('color', '#333333');
      isPwd = false;
    }else{
      $('.checknumber-check-text').html('验证码正确').css('color', '#333333');
      isPwd = true;
    };
  });
  
  //短信验证码失去焦点
  $('.newschecknumber-right').blur(function(){
    //拿到值
    userVal = $(this).val();
    //验证
    if(userVal == ''){
      $('.newschecknumber-check-text').html('短信验证码不能为空').css('color','#333333');
      //设置不能注册
      isUser = false;
      return;
    };
    //3-20位  定正则
    var re = /^[0-9]{6}$/g;
    if(!re.test(pwdVal)){
      $('.newschecknumber-check-text').html('格式错误,必须为6位数字').css('color', '#333333');
      //设置不能注册
      isUser = false;
    }else{
      //要发送请求查看后台数据库没有此注册过
      //这里接口有问题 
      $('.newschecknumber-check-text').html('短信验证码格式正确').css('color', '#333333');
      //设置能注册
      isUser = true;
    };
  });
  //密码失去焦点
  $('.password-right').blur(function(){
    //拿到值
    pwdVal = $(this).val();
    //验证
    if(pwdVal == ''){
      $('.password-check-text').html('密码不能为空').css('color','#333333');
      isPwd = false;
      return;
    };
    //6-20位数字  定正则
    var re = /([0-9a-zA-Z][!@#%^&()*])/;
    if(!re.test(pwdVal)){
      $('.password-check-text').html('密码格式有误').css('color', '#333333');
      isPwd = false;
    }else{
      $('.password-check-text').hide();
      $('.password-ts').hide();
      $('.password-right-ts').show();
      isPwd = true;
    };
  });
  //确认密码失去焦点
  $('.repassword-right').blur(function(){
    //拿到值
    repwdVal = $(this).val();
    //验证
    if(repwdVal == ''){
      $('.repassword-check-text').html('密码不能为空').css('color','#333333');
      isPwd = false;
      return;
    };
    if(pwdVal==repwdVal){
    	$('.repassword-check-text').hide();
      $('.repassword-ts').hide();
      $('.repassword-right-ts').show();
      isPwd = true;
    }else{
    	$('.repassword-check-text').html('密码错误,请重新输入！').css('color', '#333333');
    	return false;
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
        $('.phone-right').html('用户名已存在').css('color', '#333333');
        //设置不能注册
        isUser = false;
        return;
      };
      
      if(obj.code != 0){return;}
      //注册成功 把文本框清空,设置不能注册
      $('.phone-right, .password-right').val('');     
      isUser = false;
      isPwd = false;
      $('.phone-check-text, .password-right').hide();
      //跳转到登录页面
      alert('注册成功，2秒之后跳转登录页面');
      setTimeout(function(){
        //跳转到登录页面
        window.location.href = '/yougou/login.jsp';
      },2000);
    });
  });
  
});
