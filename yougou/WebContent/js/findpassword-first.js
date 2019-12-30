$(function(){
	var useVal = null;
	var pwdVal = null;
	var isUser = false;
	var isPwd = false;
	var ret = null;
	
	//验证码字符
	var upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var lower = "abcdefghijklmnopqrstuvwxyz";
	var number = "0123456789"
	var str = upper+lower+number;

	//验证码最小和最大字体
	var fontMinSize = 25;
	var fontMaxSize = 35;

	//验证码字符个数
	var verifyCodeNum = 4;

	//默认验证码宽高
	var verifyCodeWidth = 130;
	var verifyCodeHeight = 40;

	//干扰线条数
	var verifyCodeLine = 8;

	//干扰点数
	var verifyCodeDot = 100;

	/**
 	* @description 生成随机整数
 	* @param {Object} min 最小整数
 	* @param {Object} max 最大整数
 	*/
	function randomNum(min,max){
		return parseInt(Math.random()*(max-min+1) + min);
	}

	/**
 	*  生成随机颜色
 	* @param {Object} min 最小强度值
 	* @param {Object} max 最大强度值
 	*/
	function randomCol(min,max){
		var r = randomNum(min,max);
		var g = randomNum(min,max);
		var b = randomNum(min,max);
		return "rgb("+r+","+g+","+b+")";
	}
	var s = '';
	//随机生成验证码
	function randomStr(){
		for(var i = 0;i < 4;i++){
			var verifyChar = str[randomNum(0,str.length-1)];
			var fontSize = randomNum(fontMinSize,fontMaxSize);
			var angle = randomNum(-30,30);
			verifyCodePic.font = fontSize + 'px consolas';
			verifyCodePic.textBaseline = "top";
			verifyCodePic.save();
			verifyCodePic.fillStyle = randomCol(50,150);
			verifyCodePic.translate(30*i+15,15);
			verifyCodePic.rotate(angle*Math.PI/180);
			verifyCodePic.fillText(verifyChar,-10,-5);
			verifyCodePic.restore();
			s+=verifyChar;
		}
	}
	//随机产生干扰线,干扰线的颜色要浅一点
	function randomLine(){
		for(var i = 0;i < verifyCodeLine;i++){
			verifyCodePic.beginPath();
			verifyCodePic.moveTo(randomNum(0,verifyCodeWidth),randomNum(0,verifyCodeHeight));
			verifyCodePic.lineTo(randomNum(0,verifyCodeWidth),randomNum(0,verifyCodeHeight));
			verifyCodePic.strokeStyle=randomCol(50,230);
			verifyCodePic.closePath();
			verifyCodePic.stroke();
		}
	}

	//随机产生干扰的小点
	function randomDot(){
		for(var i = 0;i < verifyCodeDot;i++){
			verifyCodePic.beginPath();
			verifyCodePic.arc(randomNum(0,verifyCodeWidth),randomNum(0,verifyCodeHeight),1,0,2*Math.PI);
			verifyCodePic.closePath();
			verifyCodePic.fillStyle=randomCol(50,200);
			verifyCodePic.fill();
		}
	}

	var verifyCode = document.getElementById("verifyCode");
	var verifyCodePic = verifyCode.getContext("2d");
	initVerifyCode();
	//初始化验证码
	function initVerifyCode(){
		verifyCode.setAttribute("width",verifyCodeWidth);
		verifyCode.setAttribute("height",verifyCodeHeight);
		verifyCodePic.fillStyle = randomCol(180,255);
		verifyCodePic.fillRect(0,0,verifyCodeWidth,verifyCodeHeight);
		randomStr();
		randomLine();
		randomDot();
	}
	function refresh(){
		initVerifyCode();
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
    if(pwdVal != s){
    	alert('验证码错误，请重新输入！');
      	isPwd = false;
    }else{
      isPwd = true;
    };
  });
  
  //更换验证码
  $('.checknum-wz').click(function(){
  	refresh();
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
        location.href = '/yougou/base_html/findpassword-two.jsp';      
      };

    });
    
  });
});