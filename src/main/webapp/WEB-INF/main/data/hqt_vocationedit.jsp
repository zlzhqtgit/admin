<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
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
<script type="text/javascript"	src="${pageContext.request.contextPath}/static/js/hqt_vocation.js"></script>
<style type="text/css">
.disbl {
	display: inline-block;
}
</style>
</head>

<body>
	<form id="form-vocation" class="layui-form layui-form-pane" action="">
		<input  type="hidden" id="vId" name="vId" value="${vocationByVocationId[0].vId}">
		<div class="layui-tab">
			<ul class="layui-tab-title">
				<li class="layui-this">基本信息</li>
				<li>拓展信息</li>
			</ul>
			<div style="width: 216px; margin: 0; display: inline-block; float: right; margin-top: -40px; position: absolute; right: 15px;">
				<button type="button" class="layui-btn layui-btn-fluid"	onclick="save()">更新数据</button>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show ">
					<div class="layui-form-item disbl">
						<label class="layui-form-label ">职业代码</label>
						<div class="layui-input-block">							
							<input type="text" id="vocationId"  name="vocationId" value="${vocationByVocationId[0].vocationId}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item disbl">
						<label class="layui-form-label disbl">职业名称</label>
						<div class="layui-input-block">
							<input type="text" id="vocationName" name="vocationName" value="${vocationByVocationId[0].vocationName}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item disbl">
						<label class="layui-form-label">行业名称</label>
						<div class="layui-input-block">
							<input type="text" id="industryName" name="industryName" value="${vocationByVocationId[0].industryName}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">							
						</div>
					</div>
					<div class="layui-form-item disbl">
						<label class="layui-form-label">行业大类</label>
						<div class="layui-input-block">
							<input type="text" id="industryMajorName" name="industryMajorName" value="${vocationByVocationId[0].industryMajorName}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">								
						</div>
					</div>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>职业前景</legend>
						<c:if test="${listhyfb == null}">
							<label style="color: red;">行业收入数据错误：${listStr1}</label>
						</c:if>
						<fieldset class="layui-elem-field layui-field-title " style="border: 1px solid #e6e6e6;">
							<legend style="font-size: 16px; color: #21941b;">行业收入</legend>
							<div class="layui-form-item">
								<c:if test="${listhyfb !=null}">
									<c:forEach items="${listhyfb}" var="c" varStatus="status1">									
										<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">名称</label>
											<div class="layui-input-inline" style="    width: 120px;">
												<input type="text" name="hysr-name" value="${c[0]}" autocomplete="off" class="layui-input">
											</div>
											<div class="layui-form-mid">-</div>
											<label class="layui-form-label" style="width: 60px;">金额</label>
											<div class="layui-input-inline" style="width: 80px;">
												<input type="text" name="hysr-menoy" value="${c[1]}" autocomplete="off" class="layui-input">
											</div>
										</div>							
									</c:forEach>
								</c:if>								
								<button type="button" class="layui-btn layui-btn-sm" onclick="btnhysr(this,'hysr-name','hysr-menoy','金额')"><i class="layui-icon"></i></button>
							</div>
						</fieldset>
						<c:if test="${listdqfb == null}">
							<label style="color: red;">地区收入数据错误：${listStr2}</label>
						</c:if>
						<fieldset class="layui-elem-field layui-field-title "	style="border: 1px solid #e6e6e6;">
							<legend style="font-size: 16px; color: #21941b;">地区收入</legend>
							<div class="layui-form-item">
								<c:if test="${listdqfb != null}">
									<c:forEach items="${listdqfb}" var="c" varStatus="status1">									
										<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">名称</label>
											<div class="layui-input-inline" style="    width: 120px;">
												<input type="text" name="dqsr-name" value="${c[0]}" autocomplete="off" class="layui-input">
											</div>
											<div class="layui-form-mid">-</div>
											<label class="layui-form-label" style="width: 60px;">金额</label>
											<div class="layui-input-inline" style="width: 80px;">
												<input type="text" name="dqsr-menoy" value="${c[1]}" autocomplete="off" class="layui-input">
											</div>
										</div>							
									</c:forEach>
								</c:if>								
								<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysr(this,'dqsr-name','dqsr-menoy','金额')"><i class="layui-icon"></i></button>
							</div>
						</fieldset>
					</fieldset>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>相关介绍</legend>
						<div class="layui-form-item layui-form-text disbl"	style="width: 49%;">
							<label class="layui-form-label">职业介绍</label>
							<div class="layui-input-block">
								<textarea id="vocationBrief" name="vocationBrief"  placeholder="请输入内容" class="layui-textarea"style="min-height: 80px;">${vocationByVocationId[0].vocationBrief}</textarea>
							</div>
						</div>
						<div class="layui-form-item layui-form-text disbl"	style="width: 49%;">
							<label class="layui-form-label">工作经验</label>
							<div class="layui-input-block">
								<textarea id="workExperience" name="workExperience" placeholder="请输入内容" class="layui-textarea"style="min-height: 80px;">${vocationByVocationId[0].workExperience}</textarea>
							</div>
						</div>
						<br>
						<div class="layui-form-item layui-form-text disbl"	style="width: 49%;">
							<label class="layui-form-label">工作内容</label>
							<div class="layui-input-block">
								<textarea id="workContent" name="workContent"  placeholder="请输入内容" class="layui-textarea"	style="min-height: 80px;">${vocationByVocationId[0].workContent}</textarea>
							</div>
						</div>
						<div class="layui-form-item layui-form-text disbl"style="width: 49%;">
							<label class="layui-form-label">教育要求</label>
							<div class="layui-input-block">
								<textarea id="educationCredential" name="educationCredential"  placeholder="请输入内容" class="layui-textarea"style="min-height: 80px;">${vocationByVocationId[0].educationCredential}</textarea>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="layui-tab-item">
					<div class="layui-form-item disbl">
						<label class="layui-form-label disbl">从业资格</label>
						<div class="layui-input-block">
							<input type="text" id="requirementQualification" name="requirementQualification" value="${vocationByVocationId[0].requirementQualification}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item disbl">
						<label class="layui-form-label disbl">学历要求</label>
						<div class="layui-input-block">
							<input type="text" id="educationQualification" name="educationQualification" value="${vocationByVocationId[0].educationQualification}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item disbl">
						<label class="layui-form-label disbl">专业知识</label>
						<div class="layui-input-block">
							<input type="text" id="specialtyKnow" name="specialtyKnow" value="${vocationByVocationId[0].specialtyKnow}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item disbl">
						<label class="layui-form-label disbl">专业技能</label>
						<div class="layui-input-block">
							<input type="text" id="specialtySkill" name="specialtySkill" value="${vocationByVocationId[0].specialtySkill}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div><br>
					<div class="layui-form-item disbl">
						<label class="layui-form-label disbl">工作年限</label>
						<div class="layui-input-block">
							<input type="text" id="workYear" name="workYear" value="${vocationByVocationId[0].workYear}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item disbl">
						<label class="layui-form-label disbl">工作成果</label>
						<div class="layui-input-block">
							<input type="text" id="workAchieved" name="workAchieved" value="${vocationByVocationId[0].workAchieved}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item disbl">
						<label class="layui-form-label disbl">组织能力</label>
						<div class="layui-input-block">
							<input type="text" id="organizationAbility" name="organizationAbility" value="${vocationByVocationId[0].organizationAbility}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item disbl">
						<label class="layui-form-label disbl">统筹能力</label>
						<div class="layui-input-block">
							<input type="text" id="planAbility" name="planAbility" value="${vocationByVocationId[0].planAbility}" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>					
					<fieldset class="layui-elem-field layui-field-title">
						<legend>就业薪资概况</legend>
						<c:if test="${listxzqs == null}">
							<label style="color: red;">薪资趋势数据错误：${listStr3}</label>
						</c:if>
						<fieldset class="layui-elem-field layui-field-title " style="border: 1px solid #e6e6e6;">
							<legend style="font-size: 16px; color: #21941b;">薪资趋势</legend>
							<div class="layui-form-item">
								<c:if test="${listxzqs != null}">
									<c:forEach items="${listxzqs}" var="c" varStatus="status1">									
										<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">名称</label>
											<div class="layui-input-inline" style="    width: 120px;">
												<input type="text" name="xzqs-name" value="${c[0]}" autocomplete="off" class="layui-input">
											</div>
											<div class="layui-form-mid">-</div>
											<label class="layui-form-label" style="width: 60px;">金额</label>
											<div class="layui-input-inline" style="width: 80px;">
												<input type="text" name="xzqs-menoy" value="${c[1]}" autocomplete="off" class="layui-input">
											</div>
										</div>							
									</c:forEach>
								</c:if>								
								<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysr(this,'xzqs-name','xzqs-menoy','金额')"><i class="layui-icon"></i></button>
							</div>
						</fieldset>
						<c:if test="${listxzfb == null}">
							<label style="color: red;">薪资分布数据错误：${listStr4}</label>
						</c:if>
						<fieldset class="layui-elem-field layui-field-title "	style="border: 1px solid #e6e6e6;">
							<legend style="font-size: 16px; color: #21941b;">薪资分布</legend>
							<div class="layui-form-item">
								<c:if test="${listxzfb != null}">
									<c:forEach items="${listxzfb}" var="c" varStatus="status1">									
										<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">名称</label>
											<div class="layui-input-inline" style="    width: 120px;">
												<input type="text" name="xzfb-name" value="${c[0]}" autocomplete="off" class="layui-input">
											</div>
											<div class="layui-form-mid">-</div>
											<label class="layui-form-label" style="width: 60px;">占比</label>
											<div class="layui-input-inline" style="width: 80px;">
												<input type="text" name="xzfb-menoy" value="${c[1]}" autocomplete="off" class="layui-input">
											</div>
										</div>							
									</c:forEach>
								</c:if>								
								<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysr(this,'xzfb-name','xzfb-menoy','占比')"><i class="layui-icon"></i></button>
							</div>
						</fieldset>
						<c:if test="${listjyqsxl == null}">
							<label style="color: red;">就业趋势(按学历)数据错误：${listStr5}</label>
						</c:if>
						<fieldset class="layui-elem-field layui-field-title "	style="border: 1px solid #e6e6e6;">
							<legend style="font-size: 16px; color: #21941b;">就业趋势(按学历)</legend>
							<div class="layui-form-item">
								<c:if test="${listjyqsxl != null}">
									<c:forEach items="${listjyqsxl}" var="c" varStatus="status1">									
										<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">名称</label>
											<div class="layui-input-inline" style="    width: 120px;">
												<input type="text" name="jyqsxl-name" value="${c[0]}" autocomplete="off" class="layui-input">
											</div>
											<div class="layui-form-mid">-</div>
											<label class="layui-form-label" style="width: 60px;">占比</label>
											<div class="layui-input-inline" style="width: 80px;">
												<input type="text" name="jyqsxl-menoy" value="${c[1]}" autocomplete="off" class="layui-input">
											</div>
										</div>							
									</c:forEach>
								</c:if>								
								<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysr(this,'jyqsxl-name','jyqsxl-menoy','占比')"><i class="layui-icon"></i></button>
							</div>
						</fieldset>
						<c:if test="${listjyqsjy == null}">
							<label style="color: red;">就业趋势(按经验)数据错误：${listStr6}</label>
						</c:if>
						<fieldset class="layui-elem-field layui-field-title "	style="border: 1px solid #e6e6e6;">
							<legend style="font-size: 16px; color: #21941b;">就业趋势(按经验)</legend>
							<div class="layui-form-item">
								<c:if test="${listjyqsjy != null}">
									<c:forEach items="${listjyqsjy}" var="c" varStatus="status1">									
										<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">名称</label>
											<div class="layui-input-inline" style="    width: 120px;">
												<input type="text" name="jyqsjy-name" value="${c[0]}" autocomplete="off" class="layui-input">
											</div>
											<div class="layui-form-mid">-</div>
											<label class="layui-form-label" style="width: 60px;">占比</label>
											<div class="layui-input-inline" style="width: 80px;">
												<input type="text" name="jyqsjy-menoy" value="${c[1]}" autocomplete="off" class="layui-input">
											</div>
										</div>							
									</c:forEach>
								</c:if>								
								<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysr(this,'jyqsjy-name','jyqsjy-menoy','占比')"><i class="layui-icon"></i></button>
							</div>
						</fieldset>
					</fieldset>
				</div>
			</div>
		</div>		
	</form>
</body>
</html>
