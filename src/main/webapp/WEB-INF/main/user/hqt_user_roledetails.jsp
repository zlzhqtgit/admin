<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery_table/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/2.4/layer.js"></script>
</head>

<body>
<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
<div class="page-container">
		<div class="text-c" style="height: 50px;"></div>
	<div class="cl pd-5 bg-1 bk-gray">  <span class="r">共有数据：<strong>${userRoleDetailslist.size()}</strong> 条</span> </div>
	<table class="table table-border table-bordered table-bg table-hover table-sort">
		<thead>			
			<tr class="text-c">				
				<th width="40">ID</th>
				<th width="200">主角色名</th>
				<th width="200">分类角色编号</th>	
				<th width="200">分类角色名</th>			
				<th width="300">地址</th>	
				<th width="300">创建时间</th>
				<th width="300">操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userRoleDetailslist}" var="c">
				<tr class="text-c">					
					<td>${c.detailsId}</td>
					<td>${c.roleName}</td>
					<td>${c.detailsNumber}</td>	
					<td>${c.detailsName}</td>
					<td>${c.detailsAdress}</td>
					<td><fmt:formatDate value="${c.creationTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>				
					<td class="td-manage"> 
						<a title="编辑" href="javascript:;" onclick="roleDetails_edit('角色：${c.detailsName}编辑','hqt_user_roledetailsedit.do?detailsId=${c.detailsId}','4','850','550')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> 
						<a title="删除" href="javascript:;" onclick="roleDetails_del('${c.detailsId}','${c.detailsName}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
					</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>
</body>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 0, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  {"orderable":false,"aTargets":[6]}// 制定列不参与排序
	]
});
/*分类角色-删除*/
function roleDetails_del(detailsId,detailsName){
	layer.confirm('确认要删除角色：'+detailsName+'  吗？',function(index){		
		var url = "../user/hqt_roledetailsdel.do";
		var data ="detailsId="+detailsId;
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
function roleDetails_edit(title,url,id,w,h){	
	layer_show(title,url,w,h);
}
</script>
</html>
