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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/hqt_admin.js"></script> 
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
</html>
