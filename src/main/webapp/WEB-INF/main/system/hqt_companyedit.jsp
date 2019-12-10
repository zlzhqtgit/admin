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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/nav_all.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/Hui-iconfont/1.0.8/iconfont.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/H-ui.admin.js"></script> 
</head>

<body>
<div class="text-c" style="height: 50px;"></div>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-company-edit">	
		<input type="hidden" name="companyId" value="${companyList[0].companyId}"> 
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单位编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${companyList[0].companyNumber}" placeholder="" id="companyNumber" name="companyNumber">
			</div>
		</div>	
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单位名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${companyList[0].companyName}" placeholder="" id="companyName" name="companyName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单位地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${companyList[0].companyAdress}" placeholder="" id="companyAdress" name="companyAdress">
			</div>
		</div>			
	</form>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button type="button" class="btn btn-success radius" id="admin-role-save" name="admin-role-save" onclick="editcompany()"><i class="icon-ok"></i> 确定</button>
			</div>
		</div>
	
</article>

</body>
<script type="text/javascript">
function editcompany(){    
	if($("#companyNumber").val() == ""){
		layer.msg("请输入单位编号",{icon:2,time:1000});
	}else if($("#companyName").val() == ""){
		layer.msg("请输入单位名称",{icon:2,time:1000});
	}else if($("#companyAdress").val() == ""){
		layer.msg("请输入单位地址",{icon:2,time:1000});
	}else{		
		var url = "companyedit";
		var data = $("#form-company-edit").serialize();		
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
					layer.msg(obj.message,{icon:1,time:1000},function(){
						$("#companyNumber").val("");					
						$("#companyName").val("");	
						$("#companyAdress").val("");
						layer_close();						
					});								
				}				
			}
		}); 
	}			
}
</script>
</html>