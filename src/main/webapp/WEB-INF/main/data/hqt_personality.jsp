<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>测评信息页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/nav_all.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/Hui-iconfont/1.0.8/iconfont.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery_table/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
</head>

<body>
<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
	
	<div class="text-c" style="height: 50px;"> 
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l"></span><br/><br/>
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>						
					<tr class="text-c">	
						<th width="80">主键ID</th>			
						<th width="80">测评编码</th>
						<th width="80">测评名称</th>				
						<th width="80">测评类型</th>				
						<th width="220">测评简介</th>																			
						<th width="200">操作</th>			
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${personalityAll}" var="c">
						<tr class="text-c">	
							<td>${c.personalityId}</td>
							<td>${c.personalityCode}</td>				
							<td>${c.personalityName}</td>
							<td>${c.testName}</td>						
							<td>${c.personalityBrief}</td>								
							<td class="td-manage"> 
								<a href="javascript:;" onclick="personality_edit('专业：${c.personalityName} 信息编辑','hqt_personalityedit?personalityId=${c.personalityId}','4','850','550')" class="operation operation-edit" style="text-decoration:none">
									<i class="Hui-iconfont" style="font-size: 1em;">&#xe60c;</i>编辑</a> 
								<a href="javascript:;" onclick="personality_del('${c.personalityId}','${c.personalityName}')" class="operation operation-del" style="text-decoration:none">
									<i class="Hui-iconfont" style="font-size: 1em;">&#xe6e2;</i>删除</a>
							</td>
						</tr> 
					</c:forEach>
				</tbody>
			</table>
		</div>
					
</body>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  {"orderable":false,"aTargets":[5]}// 制定列不参与排序
	]
});
/*分类角色-删除*/
function personality_del(personalityId,personalityName){
	layer.confirm('确认要删除职业：'+personalityName+'  吗？',function(index){		
		var url = "personalitydel";
		var data ="personalityId="+personalityId;
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
					layer.msg(obj.message,{icon:1,time:1000},function(){location.replace(location.href);layer.close(layer.index);});
				}				
			}
		}); 
	});
}
/*管理员-编辑*/
function personality_edit(title,url,id,w,h){	
	var index=layer.open({
		type: 2,		
		fix: false, //不固定
		area: [w+'px', h +'px'],
		maxmin: true,
		shade:0.4,
		title: title,
		content: url,
		scrollbar: false
	});
	layer.full(index);
}
</script>
</html>
