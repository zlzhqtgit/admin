<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>菜单权限</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main/menu_authority.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main/jquery.treetable.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main/jquery.treetable.theme.default.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery_table/jquery.treetable.js"></script> 
 	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/H-ui.admin.js"></script>
	<style type="text/css">
table.treetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.treetable th {
	background:#b5cfd2 url('cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
table.treetable td {
	background:#dcddc0 url('cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>
</head>
<body>
 <input type="button" onclick="getCheckstrt()" value="保存">
<table id="example-basic" class="treetable">    
    <thead>
      <tr>
        <th>权限名称</th>
        <th>权限值</th>
      </tr>
    </thead>
    <tbody>
		<c:forEach items="${list}" var="c">
			<c:set var="counttt" value="2" />
			 <tr data-tt-id="${c.menuId}" data-tt-parent-id="${c.parentId}" >
            	<td>
					<span style="padding-left: 0px;"></span>
					<c:if test="${Authority!=null}">	
						<c:forEach items="${Authority}" var="f" varStatus="status">												
							<c:if test="${c.authority eq f}">
								<input type="checkbox" name="${c.parentId}" value="${c.authority}" checked="checked"/>${c.menuName}
								<c:set var="counttt" value="${counttt+1 }"/>
							</c:if>
							<c:if test="${status.last && counttt==2}">							
								<input type="checkbox" name="${c.parentId}" value="${c.authority}" />${c.menuName}
							</c:if> 
						</c:forEach>
					</c:if>	
					<c:if test="${Authority==null}">	
						<input type="checkbox" name="${c.parentId}" value="${c.authority}" />${c.menuName}
					</c:if>					
				</td>
            	<td>${c.authority}</td>
      		</tr>
		</c:forEach>      
    </tbody>
  </table> 
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/hqt_menu_authority.js"/>
</html>
