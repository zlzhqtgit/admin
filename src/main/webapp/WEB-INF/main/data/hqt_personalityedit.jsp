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
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/static/css/specialty.css" />
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/static/css/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/static/layui/css/layui.css" />
<script type="text/javascript"	src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/static/js/H-ui.admin.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/static/js/hqt_personality.js"></script>
<style type="text/css">
.disbl {
	display: inline-block;
}
</style>
</head>

<body>
	<form id="form-personality" class="layui-form layui-form-pane" action="">
		<input type="hidden" id="personalityId" name="personalityId"	value="${ListById[0].personalityId}">
		
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show ">
				<div class="layui-form-item disbl">
					<label class="layui-form-label ">测评编码</label>
					<div class="layui-input-block">
						<input type="text" id="personalityCode" name="personalityCode"
							value="${ListById[0].personalityCode}"
							lay-verify="required" placeholder="请输入" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item disbl">
					<label class="layui-form-label disbl">测评名称</label>
					<div class="layui-input-block">
						<input type="text" id="personalityName" name="personalityName"
							value="${ListById[0].personalityName}"
							lay-verify="required" placeholder="请输入" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item disbl">
					<label class="layui-form-label">测评类型</label>
					<div class="layui-input-block">
						<input type="text" id="testName" name="testName"
							value="${ListById[0].testName}"
							lay-verify="required" placeholder="请输入" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item layui-form-text ">
					<label class="layui-form-label">测评简介</label>
					<div class="layui-input-block">
						<textarea id="personalityBrief" name="personalityBrief"  placeholder="请输入内容" class="layui-textarea"	style="min-height: 80px;">${ListById[0].personalityBrief}</textarea>
					</div>
				</div>
				<div class="layui-form-item layui-form-text ">
					<label class="layui-form-label">测评详细描述</label>
					<div class="layui-input-block">
						<textarea id="personalityDetial" name="personalityDetial"  placeholder="请输入内容" class="layui-textarea"style="min-height: 80px;">${ListById[0].personalityDetial}</textarea>
					</div>
				</div>				
				<c:if test="${listSpecialty == null}">
					<label style="color: red;">地区收入数据错误：${listStr}</label>
				</c:if>
				<fieldset class="layui-elem-field layui-field-title " style="border: 1px solid #e6e6e6;">
					<legend style="font-size: 16px; color: #21941b;">相关的专业</legend>
					<div class="layui-form-item">						
						<c:if test="${listSpecialty != null}">
							<c:forEach items="${listSpecialty}" var="c" varStatus="status1">
								<div class="layui-inline">
									<label class="layui-form-label" style="width: 100px;">专业代码</label>
									<div class="layui-input-inline" style="width: 80px;">
										<input type="text" name="specialty-code" value="${c[0]}"	autocomplete="off" class="layui-input">
									</div>
									<div class="layui-form-mid">-</div>
									<label class="layui-form-label" style="width: 100px;">专业名称</label>
									<div class="layui-input-inline" style="width: 120px;">
										<input type="text" name="specialty-name" value="${c[1]}" autocomplete="off" class="layui-input">
									</div>
								</div>
							</c:forEach>
						</c:if>						
						<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysr(this,'specialty-code','specialty-name','专业代码','专业名称')">
							<i class="layui-icon"></i>
						</button>
					</div>
				</fieldset>
				<c:if test="${listVocation == null}">
					<label style="color: red;">地区收入数据错误：${listStr1}</label>
				</c:if>
				<fieldset class="layui-elem-field layui-field-title "
					style="border: 1px solid #e6e6e6;">
					<legend style="font-size: 16px; color: #21941b;">相关的职业</legend>
					<div class="layui-form-item">
						<c:if test="${listVocation != null}">
							<c:forEach items="${listVocation}" var="c" varStatus="status1">
								<div class="layui-inline">
									<label class="layui-form-label" style="width: 100px;">职业代码</label>
									<div class="layui-input-inline" style="width: 80px;">
										<input type="text" name="vocation-code" value="${c[0]}"	autocomplete="off" class="layui-input">
									</div>
									<div class="layui-form-mid">-</div>
									<label class="layui-form-label" style="width: 100px;">职业名称</label>
									<div class="layui-input-inline" style="width: 120px;">
										<input type="text" name="vocation-name" value="${c[1]}" autocomplete="off" class="layui-input">
									</div>
								</div>
							</c:forEach>
						</c:if>
						<button type="button" class="layui-btn layui-btn-sm" onclick="btnhysr(this,'vocation-code','vocation-name','职业代码','职业名称')">
							<i class="layui-icon"></i>
						</button>
					</div>
				</fieldset>
				<div style="position: fixed; top: 0px; right: 0;">
					<button type="button" class="layui-btn layui-btn-fluid"	onclick="savepet()">更新数据</button>
				</div>
			</div>
		</div>
	</form>
</body>

</html>
