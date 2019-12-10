<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>后台用户信息修改页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/nav_all.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/H-ui.admin.js"></script> 
</head>

<body>
	
<article class="page-container">
	<form class="form form-horizontal" id="form-admin-edit">
	<input  type="hidden" id="id" name="id"value="${adminList[0].id}">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${adminList[0].username}" placeholder="" id="username" name="username">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="password" style="border:none;" autocomplete="off" value="${adminList[0].password}" disabled="disabled" placeholder="密码" id="password" name="password">
		</div>
	</div>	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
		<div class="formControls col-xs-8 col-sm-9 skin-minimal">
			<c:if test="${adminList[0].userSex eq '1'}" >
				<div class="radio-box"><input name="userSex" type="radio" id="sex-1" checked value="1"><label for="sex-1">男</label>	</div>
				<div class="radio-box"><input type="radio" id="sex-2" name="userSex" value="2"><label for="sex-2">女</label>	</div>
			</c:if>
			<c:if test="${adminList[0].userSex  eq '2'}" >
				<div class="radio-box"><input name="userSex" type="radio" id="sex-1" value="1"><label for="sex-1">男</label>	</div>
				<div class="radio-box"><input type="radio" id="sex-2" name="userSex" checked value="2"><label for="sex-2">女</label>	</div>
			</c:if>		
			<c:if test="${adminList[0]==null}" >
				<div class="radio-box"><input name="userSex" type="radio" id="sex-1" checked value="1"><label for="sex-1">男</label>	</div>
				<div class="radio-box"><input type="radio" id="sex-2" name="userSex" value="2"><label for="sex-2">女</label>	</div>
			</c:if>		
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${adminList[0].phone}" placeholder="" id="phone" name="phone">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" placeholder="@" name="email" id="email" value="${adminList[0].email}">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">角色：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" id="rid" name="rid" size="1">				
					<option value="${adminList[0].rid}">${adminList[0].roleName}</option>
					<c:forEach items="${roleList}" var="c">
						<option value="${c.roleId}">${c.roleName}</option>
					</c:forEach>				
			</select>
			</span> </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">备注：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<textarea id="comment" name="comment" cols="" rows="" class="textarea" title="" placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="$.Huitextarealength(this,100)">${adminList[0].comment}</textarea>
			<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
		</div>
	</div>
	</form>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">			
			<input class="btn btn-primary radius" type="button" onclick="editUser()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	
</article>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/H-ui.admin.js"></script> 
<script type="text/javascript">
function editUser(){
	var regBox = {
	        regEmail : /^([A-Z0-9a-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/,//邮箱
	        regName : /^[A-Z0-9a-z_-]{6,16}$/,//用户名
	        regMobile : /^0?1[3|4|5|7|8][0-9]\d{8}$/,//手机
	       	regTel : /^0[\d]{2,3}-[\d]{7,8}$/
			}			
    var userflag = regBox.regName.test($("#username").val());
    var emailflag = regBox.regEmail.test($("#email").val());
    var phoneflag = regBox.regMobile.test($("#phone").val());
    var passflag = regBox.regName.test($("#password").val());  
    if ($("#username").val() == "") {
		layer.msg("用户名不能为空",{icon:2,time:1000});			
	}else if(!userflag){
		layer.msg("用户名是6-16位字母、数字下划线组成",{icon:2,time:1000});	
	}else if($("#phone").val() == ""){
		layer.msg("手机号不能为空",{icon:2,time:1000});
	}else if(!phoneflag){
		layer.msg("手机号格式不正确",{icon:2,time:1000});
	}else if($("#email").val() == ""){			
		layer.msg("邮箱不能为空",{icon:2,time:1000});
	}else if(!emailflag){
		layer.msg("邮箱格式如:XXXXXX@163.COM",{icon:2,time:1000});
	}else if($("#rid").val() == ""){
		layer.msg("请选择角色",{icon:2,time:1000});
	}else if($("#comment").val() == ""){
		layer.msg("请输入备注",{icon:2,time:1000});
	}else{			
		var url = "adminedit";
		var data = $("#form-admin-edit").serialize();
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
					layer.msg(obj.message,{icon:1,time:1000},function(){layer_close();});
				}				
			}
		}); 
	}			
}
</script>
</html>
