$(function(){
  var isUser = false; //用户验证
  var isPwd = false;  // 密码验证
  var isCode = false; //验证码验证
  var isEmail = false;//邮箱验证
  var isCPwd = false;//账号验证
  var isEmailCode = false; // 邮箱验证码
  
  
  var userVal = null; //用户值
  var pwdVal = null; //密码值
  var emailVal = null; //邮箱值
  var emailCodeVal = null; //邮箱验证码的值
  var repwdVal = null;
  var checknumber = null;
//  var phonenumber = null;
  
  //定义一个全局的邮箱验证的值
  var emailCode = null;
  
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
	var verifyCodeWidth = 120;
	var verifyCodeHeight = 38;

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
//点击图片进行切换
  $('.pic').click(function(){
	s='';
  	refresh();
  });
  //手机号码获取焦点
  $('.phone-right').focus(function(){
    //提示显示
    $('.phone-check').show();
  });
  
  //验证码获取焦点
  $('.checknumber-right').focus(function(){
    //提示显示
    $('.checknumber-check').show();
  });
  
  
  //邮箱获取焦点
  $('.email-right').focus(function(){
    //提示显示
    $('.email-check').show();  
  });
  
  
  
  //邮箱验证码获取焦点
  $('.emailnum-right').focus(function() {
	//提示显示	  
	 $('.emailnum-check').show(); 
  });
  
  
  //点击获取验证码做短信验证
  $('.emailnum-getnumber').click(function() {
	  //拿到值
	  emailVal = $('.email-right').val();
	  //验证
	  if(emailVal == ''||emailVal == null){
	  $('.email-check').show();
      $('.email-check-text').html('邮箱账号不能为空').css('color','#333333');
      $('.email-check-text').show();
      $('.email-ts').show();
      $('.email-right-ts').hide();
      //设置不能注册
      isEmail = false;
      return;
	  };
	  //3-20位  定正则
	  var re = /^[a-zA-Z\d]+([-_\.][a-zA-Z\d]+)*@[a-zA-Z\d]+\.[a-zA-Z\d]{2,4}$/g;
	  if(!re.test(emailVal)){
      $('.email-check-text').html('邮箱格式错误').css('color', '#333333');
      $('.email-check-text').show();
      $('.email-ts').show();
      $('.email-right-ts').hide();
      //设置不能注册
      isEmail = false;
      return;
	  }else{
		  $('.email-check-text').hide();
		  $('.email-ts').hide();
		  $('.email-right-ts').show();
		  isEmail = true;
	  };
    
	  //ajax请求验证码 赋值
	  $.ajax({
  		url:'/yougou/register.do',
  		type:'post',
  		async: false,
  		data: {
  			method: 'getEmailCode',
  			usersEmail: emailVal
  		},
  		success: function(re) {
  			console.log(re);
  				var reslut = JSON.parse(re); 			
  				if(reslut.code==0){
  					emailCode = reslut.data;
  					$('.emailnum-check').show();
  					$('.emailnum-check-text').html('验证码发送成功').css('color','#333333');
  			 	    $('.emailnum-check-text').show();
  			 	    $('.emailnum-ts').show();
  			      //设置不能注册
  			 	   isEmailCode = true;
  				}else{
  					$('.emailnum-check').show();
  					$('.emailnum-check-text').html('验证码发送失败，点击重新发送').css('color','#333333');
  			 	    $('.emailnum-check-text').show();
  			 	    $('.emailnum-ts').show();
  			      //设置不能注册
  			 	   isEmailCode = false;
  				}
  			}
  		});
  });
  
  
  //邮箱验证码失去焦点判断
  $('.emailnum-right').blur(function() {
	//拿到值
	    emailCodeVal = $(this).val();
	    //验证
	    if(emailCodeVal == ''||emailCodeVal == null){
	      $('.emailnum-check-text').html('请输入邮箱验证码').css('color','#333333');
	      $('.emailnum-check-text').show();
	      $('.emailnum-ts').show();
	      //设置不能注册
	      isEmailCode = false;
	      return;
	    };
	    //3-20位  定正则
	    var re = /^[0-9]{4}$/;
	    if(!re.test(emailCodeVal)){
	    	$('.emailnum-check-text').html('验证码格式错误').css('color','#333333');
	 	    $('.emailnum-check-text').show();
	 	    $('.emailnum-ts').show();
	      //设置不能注册
	 	   isEmailCode = false;
	 	   return;
	    }else{
	 	    $('.emailnum-check').hide();;
	 	    isEmailCode = true;
	    }
	    if(emailCodeVal==emailCode&&emailCodeVal!=null){
	    	isEmailCode = true;
	    }else{
	    	isEmailCode = false;
	    }    
	  });
   
  
  //密码获取焦点
  $('.password-right').focus(function(){
    //提示显示
  	$('.password-check').show();
                function checkStrong(val) {
                    var modes = 0;
                    if (val.length < 6){ return 0;}
                    if (/\d/.test(val)){ modes++; }//数字
                    if (/[a-z]/.test(val)){ modes++;}//小写
                    if (/[A-Z]/.test(val)){ modes++;}//大写  
                    if (/\W/.test(val)) {modes++;} //特殊字符
                    if (val.length > 12){modes++;}
                    return modes;
                };
                
                $(".password-right").keyup(function() {
                    var val = $(this).val();
                    var num = checkStrong(val);
                    switch (num) {
                        case 0:
                        	$('.password-high').css('background', '#D5D5D5');
                            $('.password-middle').css('background', '#D5D5D5');
                            $('.password-low').css('background', '#D5D5D5');
                            break;
                        case 1:
                            $('.password-high').css('background', 'red');
                            $('.password-middle').css('background', '#D5D5D5');
                            $('.password-low').css('background', '#D5D5D5');                           
                            break;
                       case 2: case 3:
                            $('.password-middle').css('background', 'yellow');
                            $('.password-high').css('background', '#D5D5D5');
                            $('.password-low').css('background', '#D5D5D5');
                            break;
                       case 4: case 5:
                            $('.password-low').css('background', 'green');
                            $('.password-middle').css('background', '#D5D5D5');
                            $('.password-high').css('background', '#D5D5D5');
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
  
  
  
  //手机号码失去焦点
  $('.phone-right').blur(function(){
    //拿到值
    userVal = $(this).val();
    //验证
    if(userVal == ''||userVal == null){
      $('.phone-check-text').html('手机号不能为空').css('color','#333333');
      $('.phone-check-text').show();
      $('.phone-right-ts').hide();
      $('.phone-ts').show();
      //设置不能注册
      isUser = false;
      return;
    };
    //3-20位  定正则
    var re = /^[1][3,4,5,7,8][0-9]{9}$/g;
    if(!re.test(userVal)){
      $('.phone-check-text').html('格式错误,手机号非法').css('color', '#333333');
      $('.phone-check-text').show();
      $('.phone-right-ts').hide();
      $('.phone-ts').show();
      //设置不能注册
      isUser = false;
    }else{
      //要发送请求查看后台数据库没有此注册过
    	$.ajax({
    		url:'/yougou/register.do',
    		type:'post',
    		async: false,
    		data: {
    			method: 'usersNumVerify',
    			usersNum: userVal
    		},
    		success: function(re) {
    				//如果数据库没有此账号 就是true
    				if("false"==re.trim()){
    					  $('.phone-check-text').html('账号已被注册').css('color', '#333333');
    	    		      $('.phone-check-text').show();
    	    		      $('.phone-right-ts').hide();
    	    		      $('.phone-ts').show();
    	    		      isUser = false;
    				}else{
    					  isUser = true;
    				}
    			}
    		});
    	   	
    	if(!isUser){
    		return; 
    	}
      //成功
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
    checknumber = $(this).val();
    //验证
    if(checknumber == ''||checknumber == null){
      $('.checknumber-check-text').html('验证码不能为空').css('color','#333333');
      $('.checknumber-check-text').show();
      $('.checknumber-ts').show();
      isCode = false;
      return;
    };
   
    if(checknumber.toLocaleLowerCase()!= s.toLocaleLowerCase()){
      $('.checknumber-check-text').html('验证码有误,请重新输入！').css('color', '#333333');
      $('.checknumber-check-text').show();
      $('.checknumber-ts').show();
      isCode = false;
      //重新生成验证码
	  s='';
	  refresh();
	  return;
    }else{
      $('.checknumber-check-text').hide();
      $('.checknumber-ts').hide();
      isCode = true;
    };
  });
  
  
  
  //邮箱去焦点
  $('.email-right').blur(function(){
    //拿到值
	  emailVal = $(this).val();
    //验证
    if(emailVal == ''||emailVal == null){
      $('.email-check-text').html('邮箱账号不能为空').css('color','#333333');
      $('.email-check-text').show();
      $('.email-ts').show();
      $('.email-right-ts').hide();
      //设置不能注册
      isEmail = false;
      return;
    };
    //3-20位  定正则
    var re = /^[a-zA-Z\d]+([-_\.][a-zA-Z\d]+)*@[a-zA-Z\d]+\.[a-zA-Z\d]{2,4}$/g;
    if(!re.test(emailVal)){
      $('.email-check-text').html('格式错误,请重新输入').css('color', '#333333');
      $('.email-check-text').show();
      $('.email-ts').show();
      $('.email-right-ts').hide();
      //设置不能注册
      isEmail = false;
    }else{
      $('.email-check-text').hide();
      $('.email-ts').hide();
      $('.email-right-ts').show();
      isEmail = true;
    };
  });
  
  
  
  //密码失去焦点
  $('.password-right').blur(function(){
    //拿到值
    pwdVal = $(this).val();
    //验证
    if(pwdVal == ''||pwdVal == null){
      $('.password-check-text').html('密码不能为空').css('color','#333333');
      $('.password-check-text').show();
      $('.password-ts').show();
      $('.password-right-ts').hide();
      isPwd = false;
      return;
    };
    //6-15位数字  定正则
    var re = /^[a-zA-Z0-9!@#^&().?*]{6,15}$/;
    if(!re.test(pwdVal)){
      $('.password-check-text').html('密码格式有误').css('color', '#333333');
      $('.password-check-text').show();
      $('.password-ts').show();
      $('.password-right-ts').hide();
      isPwd = false;
      return;
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
	    if(repwdVal == ''||repwdVal == null){
	      $('.repassword-check-text').html('密码不能为空').css('color','#333333');
	      $('.repassword-check-text').show();
	      $('.repassword-ts').show();
	      $('.repassword-right-ts').hide();
	      isCPwd = false;
	      return;
	    };
	    if(pwdVal==repwdVal){
	     $('.repassword-check-text').hide();
	      $('.repassword-ts').hide();
	      $('.repassword-right-ts').show();
	      isCPwd = true;
	      return;
	    }else{
	    	$('.repassword-check-text').html('密码不匹配,请重新输入').css('color', '#333333');
	    	  $('.repassword-check-text').show();
	          $('.repassword-ts').show();
	          $('.repassword-right-ts').hide();
	    	return false;
	    };
  });
  
  //查看是否
  
  
  
  //点击注册
  $('.zhuece-loginbtn').click(function(){
	if(emailCodeVal!=emailCode.trim()||emailCodeVal==null){
		$('.emailnum-check').show();
    	$('.emailnum-check-text').html('验证码错误').css('color','#333333');
 	    $('.emailnum-check-text').show();
 	    $('.emailnum-ts').show();	
	}
    //点击注册按钮时候看所有项都为true才能请求后台
    if(isUser == false || isPwd == false || isCode == false || isEmail==false || isCPwd==false || isEmailCode == false){
      return;
    };
    console.log('可以注册了');
    console.log(userVal);
    console.log(pwdVal);
    console.log(emailVal);
    //请求注册之前查看每项都OK发起请求
    $.post('/yougou/register.do', {
      method : 'register',
      usersNum : userVal,
      usersPwd: pwdVal,
      usersEmail : emailVal   
    }, function(re){
      var obj = JSON.parse(re);
      console.log(obj);
       
      if(obj.code != 0){return;}
      //注册成功 把文本框清空,设置不能注册
      $('.phone-right, .password-right').val('');     
      var isUser = false; //用户验证
      var isPwd = false;  // 密码验证
      var isCode = false; //验证码验证
      var isEmail = false;//邮箱验证
      var isCPwd = false;//账号验证
      var isEmailCode = false; // 邮箱验证码
      
      
      $('.phone-check-text, .password-right').hide();
      //跳转到登录页面
      alert('注册成功，2秒之后跳转登录页面');
      setTimeout(function(){
        //跳转到登录页面
        window.location.href = '/yougou/base_html/login.jsp';
      },2000); 
    });
  });
});
