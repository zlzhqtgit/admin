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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery_table/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
</head>

<body>
<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
<div class="page-container">
		<div class="text-c" style="height: 50px;"></div>
	<div class="cl pd-5 bg-1 bk-gray">  <span class="r">共有数据：<strong>${roleList.size()}</strong> 条</span> </div>
	<table class="table table-border table-bordered table-bg table-hover table-sort">
		<thead>			
			<tr class="text-c">				
				<th width="40">ID</th>
				<th width="200">所属单位</th>				
				<th width="300">角色名称</th>
				<th width="300">角色权限值</th>
				<th width="300">角色描述</th>	
				<th width="300">操作</th>		
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${roleList}" var="c">
				<tr class="text-c">					
					<td>${c.roleId}</td>
					<td>${c.companyName}</td>
					<td>${c.roleName}</td>
					<td>${c.roleAuthority}</td>
					<td>${c.roleDescription}</td>
					<td class="td-manage"> 
						<a href="javascript:;" onclick="role_edit('角色：${c.roleName}权限设置','menu_authority?type=role&id=${c.roleId}','4','500','550')" class="operation operation-add" style="text-decoration:none">
							<i class="Hui-iconfont" style="font-size: 1em;">&#xe63c;</i>权限设置</a> 				
						<a href="javascript:;" onclick="role_edit('角色：${c.roleName}信息编辑','hqt_roleedit?roleId=${c.roleId}','4','850','550')" class="operation operation-edit" style="text-decoration:none">
							<i class="Hui-iconfont" style="font-size: 1em;">&#xe60c;</i>编辑</a> 
						<a href="javascript:;" onclick="role_del('${c.roleId}','${c.roleName}')" class="operation operation-del" style="text-decoration:none">
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
	  {}// 制定列不参与排序
	]
});
/*分类角色-删除*/
function role_del(roleId,roleName){
	layer.confirm('确认要删除角色：'+roleName+'  吗？',function(index){		
		var url = "roledel";
		var data ="roleId="+roleId;
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
function role_edit(title,url,id,w,h){	
	layer_show(title,url,w,h);
}
</script>
</html>
