$(function(){
	$('.bootom-next').click(function(){
		if($(".radiobtn").is(':checked')){
			window.location.href = '/yougou/base_html/findpassword-three.jsp';
		}else{
			alert('请选择找回方式');
		}
  });
});