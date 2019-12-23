$(function(){
  //账号获取焦点
  $('.printk').focus(function(){
    //提示显示
    $('.form-contain-blank-yz').show();
  });
  //密码获取焦点
  $('.printp').focus(function(){
    //提示显示
    $('.form-contain-blank1-yz').show();
  });
  //账号失去焦点
  $('.printk').blur(function(){
    //拿到值
    userVal = $(this).val();
    //验证
    if(userVal == ''){
      $('.form-contain-blank-yz').html('账号不能为空').css('color','red');
      //设置不能注册
      isUser = false;
      return;
    };
    //3-20位  定正则
    var re = /^[0-9_]{11}$/g;
    if(!re.test(userVal)){
      $('.form-contain-blank-yz').html('格式错误,必须为11位数字').css('color', 'red');
      //设置不能注册
      isUser = false;
    }else{
      //要发送请求查看后台数据库没有此注册过
      //这里接口有问题 
      $('.form-contain-blank-yz').html('用户名格式正确').css('color', 'green');
      //设置能注册
      isUser = true;
    };
  });
  //密码失去焦点
  $('.printp').blur(function(){
    //拿到值
    pwdVal = $(this).val();
    //验证
    if(pwdVal == ''){
      $('.form-contain-blank1-yz').html('密码不能为空').css('color','red');
      isPwd = false;
      return;
    };
    //6-20位数字  定正则
    var re = /^[0-9]{6}$/g;
    if(!re.test(pwdVal)){
      $('.form-contain-blank1-yz').html('验证码错误，请重新输入！').css('color', 'red');
      isPwd = false;
    }else{
      $('.form-contain-blank1-yz').html('验证码正确！').css('color', 'green');
      isPwd = true;
    };
  });
  
});
$(function(){
  //用户名和密码做验证
  $('.loginbtn1').click(function(){
    //拿到用户名和密码
    var userVal = $('.printk').val();
    var pwdVal = $('.printp').val();
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
        $('.form-contain-blank-yz').html('用户名不存在').css('color',' red');
        return;
      };
      if(obj.code == 1001){
        $('.form-contain-blank1-yz').html('验证码错误').css('color',' red');
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
        location.href = '/yougou/base_html/pro_center.jsp?goods_id='+goodsId;
      }else{
        location.href = '/yougou/base_html/login.jsp';      
      };

    });
    
  });
});