<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>后台用户浏览页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/nav_all.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/Hui-iconfont/1.0.8/iconfont.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery_table/jquery.dataTables.min.js"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/H-ui.admin.js"></script>


</head>

<body>
<div style="width: 500px;text-align: center;background: red;">

</div>
<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
	
	<div class="text-c" style="height: 50px;"> 
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	<input type="checkbox" onchange="queryadmin(this)"/>是否显示权限值
	</span><br/><br/>
	<table class="table table-border table-bordered table-bg table-hover table-sort">
		<thead>						
			<tr class="text-c">				
				<th width="40">ID</th>
				<th width="160">登录名</th>
				<th width="130">手机</th>
				<th width="180">邮箱</th>
				<th width="160">角色</th>
				<th width="160">所属单位</th>
				<th id="th_userAuthority" style="display: none;" width="380">权限值</th>
				<th width="130">加入时间</th>			
				<th width="300">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${adminAlllist}" var="c">
				<tr class="text-c">				
				<td>${c.id}</td>
				<td>${c.username}</td>
				<td>${c.phone}</td>
				<td>${c.email}</td>
				<td>${c.roleName}</td>
				<td>${c.companyName}</td>
				<td id="td_userAuthority" style="display: none;">${c.userAuthority}</td>
				<td><fmt:formatDate value="${c.creatTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>				
				<td class="td-manage">				
				<a href="javascript:;" onclick="admin_edit('${c.username}权限设置','menu_authority?type=admin&id=${c.id}','4','500','550')" class="operation operation-add" style="text-decoration:none">
					<i class="Hui-iconfont" style="font-size: 1em;">&#xe63c;</i>权限设置</a> 			
				<a href="javascript:;" onclick="admin_edit('${c.username}编辑','hqt_adminedit?id=${c.id}','4','850','550')" class="operation operation-edit" style="text-decoration:none">
					<i class="Hui-iconfont" style="font-size: 1em;">&#xe60c;</i>编辑</a> 
				<a href="javascript:;" onclick="admin_del('${c.id}','${c.username}')" class="operation operation-del" style="text-decoration:none">
					<i class="Hui-iconfont" style="font-size: 1em;">&#xe6e2;</i>删除</a>
				<a  href="javascript:;" onclick="admin_reset('${c.id}','${c.username}')" class="operation operation-reset" style="text-decoration:none">
					<i class="Hui-iconfont" style="font-size: 1em;">&#xe63f;</i>密码重置</a>
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
	  {"orderable":false,"aTargets":[6]}// 制定列不参与排序
	]
});
function queryadmin(obj){
	if(obj.checked == true){
		$("#th_userAuthority").css("display","block");
		$("#td_userAuthority").css("display","block");		
	}else{
		$("#th_userAuthority").css("display","none");
		$("#td_userAuthority").css("display","none");
	}
}
/*管理员-删除*/
function admin_del(id,username){
	layer.confirm('确认要删除用户'+username+'吗？',function(index){		
		var url = "admindel";
		var data ="id="+id;
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
/*管理员-密码重置*/
function admin_reset(id,username){
	layer.confirm('确认要重置用户：'+username+' 的密码吗？重置后密码为：111111',function(index){		
		var url = "adminpwdreset";
		var data ="id="+id;
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
function admin_edit(title,url,id,w,h){	
	layer_show(title,url,w,h);
}
</script>
</html>
