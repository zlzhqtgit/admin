<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>底部内容页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nav_all.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Hui-iconfont/1.0.8/iconfont.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/CN-US/Convert_Pinyin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/2.4/layer.js"></script>
</head>
<body>
<div class="page-head">当前用户：<label id="username" style="color: #0000ff;font-size: 24px;">${username}</label></div>
<div class="page-password">
	<div class="page-top">修改密码</div>
	<form action="" method="post"  id="form-article-add">		
		<div >
			<p>新 密 码 ：<input type="password" name="password" id="password" placeholder="" value=""  style="width:70%"></p>			
		</div>			
		<div>
			<p>确认密码：<input type="password"name="newpassword" id="newpassword" placeholder="" value=""  style="width:70%"></p>			
		</div>		
			<div >
				<input type="hidden" id="user_id" value="${uid}">
				<button onClick="admin_change()" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe63f;</i> 修改密码</button>
				<button onClick="article_save();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 重置</button>			
			</div>
		
	</form>
</div>



</body>
<script type="text/javascript">
/*管理员-密码重置*/
function admin_change(){
	var regBox = {		       
	        regpassword : /^[A-Z0-9a-z_-]{6,16}$/ //用户名		       
			}			
    var passwordflag = regBox.regpassword.test($("#password").val());     
	if ($("#password").val() == "") {
		layer.msg("请输入密码",{icon:2,time:1000});			
	}else if(!passwordflag){
		layer.msg("密码格式不正确",{icon:2,time:1000});
	}else if($("#password").val()!=$("#newpassword").val()){
		layer.msg("两次输入的密码不正确",{icon:2,time:1000});
	}else{
		layer.confirm('确认要修改用户：'+$("#username").text()+' 的密码吗？',function(index){		
			var url = "nav_userchangepwd.do";
			var data ="id="+$("#user_id").val()+"&password="+$("#password").val();		
			$.ajax({
				"url" : url,
				"data" : data,
				"type" : "POST",
				"dataType" : "json",
				"success" : function(obj) {
					if (obj.state == 0) {
						layer.msg(obj.message,{icon:2,time:1000});
						return;
					}else{
						layer.msg(obj.message,{icon:1,time:1000},function(){layer.close(layer.index);});
						$("#newpassword").val('');
						$("#password").val('');
					}							
				}
			});			
		});
	}
}
</script>
</html>
