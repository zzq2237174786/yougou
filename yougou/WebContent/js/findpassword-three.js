$(function(){
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
	var verifyCodeHeight = 35;

	//干扰线条数
	var verifyCodeLine = 8;

	//干扰点数
	var verifyCodeDot = 100;

	/**
 	*生成随机整数
 	*/
	function randomNum(min,max){
		return parseInt(Math.random()*(max-min+1) + min);
	}

	/**
 	*  生成随机颜色
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
  //更换验证码
  $('.checknum-wz').click(function(){
  	refresh();
  });
  
  //下一步的点击事件
  $('.bootom-next').click(function(){
  	var a = $('.check-inputnumber').val();
  	var b = $('.foot-phoneofnum').val();
  	if(a == s && b == '666'){
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