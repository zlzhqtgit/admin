<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>好前途后台管理模板</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/skin_/main.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/global.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/core.js"></script>
<!-- <script language = javascript>
window.onload=function(){	
	if($(".user-name1").text()==null || $(".user-name1").text()==""){
		window.open('${pageContext.request.contextPath }/user/nav_login.do','_top');
	}
} 
</script> -->
</head>

<body>
<div id="container">
	<div id="hd">
    	<div class="hd-top">
            <h1 class="logo"></h1>
            <div class="user-info">
                <a href="javascript:;" class="user-avatar"><span></span></a>
                <span class="user-name">${adminRole}(</span><span class="user-name1">100005</span><span class="user-name2">)</span>
                <a href="javascript:;" class="more-info"></a>
            </div>
            <div class="setting ue-clear">            	
                <ul class="setting-main ue-clear">
                	<li><a href="javascript:;">桌面</a></li>
                    <li><a href="javascript:;">设置</a></li>
                    <li><a href="javascript:;">帮助</a></li>
                    <li ><a  href="${pageContext.request.contextPath}/logout" ><label class="close-btn exit"></label>退出</a></li>
                </ul>
            </div>
        </div>
        <div class="hd-bottom">        	
        	<div class="nav-wrap">
                <ul class="nav ue-clear">
                	<shiro:hasPermission name="hqt_index:query">
                    	<li class="nav_lihover"><a>首页</a></li>
                    </shiro:hasPermission> 
                	<shiro:hasPermission name="hqt_xgk:query">
                    	<li><a>新高考</a></li>
                    </shiro:hasPermission> 
                    <shiro:hasPermission name="hqt_zytb:query">
                   		<li><a>志愿填报</a></li>  
                   	</shiro:hasPermission>
                   	<shiro:hasPermission name="hqt_admin:query">  
                    	<li><a onclick="change('${pageContext.request.contextPath}/hqt_user')">用户管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="hqt_sys:query">
                    	<li><a onclick="change('${pageContext.request.contextPath}/hqt_system')">系统管理</a></li> 
                    </shiro:hasPermission>                                                     
                </ul>
            </div>
            <div class="nav-btn">
            	<a href="javascript:;" class="nav-prev-btn"></a>
                <a href="javascript:;" class="nav-next-btn"></a>
            </div>
        </div>
    </div>
    <div id="bd">
        <iframe width="100%" height="100%" id="mainIframe" src="" ></iframe>
    </div>
    
    <div id="ft" class="ue-clear">
    	<div class="ft1 ue-clear">
        	<i class="ft-icon1"></i> <span>好前途管理系统  </span>
            <em>Digital Pertal</em>
        </div>
        <div class="ft2 ue-clear">
        	<span>Call Center</span>
            <em>V2.0 2019</em>
            <i class="ft-icon2"></i>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
function change(e){	
	document.getElementById('mainIframe').src=e;
	
}

</script>
<script type="text/javascript">
$("#bd").height($(window).height()-$("#hd").outerHeight()-26);

$(window).resize(function(e) {
    $("#bd").height($(window).height()-$("#hd").outerHeight()-26);

});


(function(){
	var totalWidth = 0, current = 1;	
	$.each($('.nav').find('li'), function(){
		totalWidth += $(this).outerWidth();
		
		$(this).click(function(e) {  			
			$(this).siblings().removeClass("nav_lihover");
			$(this).addClass("nav_lihover");			
		});
	});
	
	$('.nav').width(totalWidth);
	
	function currentLeft(){
		return -(current - 1) * 93;	
	}
	
	$('.nav-btn a').click(function(e) {
		var tempWidth = totalWidth - ( Math.abs($('.nav').css('left').split('p')[0]) + $('.nav-wrap').width() );
        if($(this).hasClass('nav-prev-btn')){
			if( parseInt($('.nav').css('left').split('p')[0])  < 0){
				current--;
				Math.abs($('.nav').css('left').split('p')[0]) > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': 0}, 200);
			}
		}else{
			if(tempWidth  > 0)	{				
			   	current++;
				tempWidth > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': $('.nav').css('left').split('p')[0]-tempWidth}, 200);
			}
		}
    });	
	$.each($('.skin-opt li'),function(index, element){
		if((index + 1) % 3 == 0){
			$(this).addClass('third');	
		}
		$(this).css('background',$(this).attr('attr-color'));
	});
	
	$('.setting-skin').click(function(e) {
        $('.skin-opt').show();
    });
	
	$('.skin-opt').click(function(e) {
        if($(e.target).is('li')){
			alert($(e.target).attr('attr-color'));	
		}
    });
	
	$('.hd-top .user-info .more-info').click(function(e) {
       $(this).toggleClass('active'); 
	   $('.user-opt').toggle();
    });
	
	$('.logo-icon').click(function(e) {
         $(this).toggleClass('active'); 
	     $('.system-switch').toggle();
    });

})();

	

</script>

</html>
