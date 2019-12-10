<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>底部内容页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/skin_/nav.css" />

</head>

<body>
<div id="container">
	<div id="bd">
    	<div class="sidebar">
        	<div class="sidebar-bg"></div>
            <i class="sidebar-hide"></i>
            <h2><a href=""><i class="h2-icon" title="切换到树型结构"></i><span>用户管理</span></a></h2>
            <ul class="nav">
            	<!-- <li class="nav-li current" data-id="1"><a href="javascript:;" class="ue-clear"><i class="nav-ivon1"></i><span class="nav-text">首页</span></a></li> -->
            	<shiro:hasPermission name="admin:list">              	
	            	 <li class="nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">后台用户管理</span></a>
	                	<ul class="subnav">
	                		<shiro:hasPermission name="admin:add">
	                    		<li class="subnav-li " href="${pageContext.request.contextPath}/hqt_adminadd" data-id="2"><a href="javascript:;" class="ue-clear"><span class="subnav-text">添加用户</span></a></li>
	                        </shiro:hasPermission>
	                        <shiro:hasPermission name="admin:query">
	                        	<li class="subnav-li" href="${pageContext.request.contextPath}/hqt_admin" data-id="4"><a href="javascript:;" class="ue-clear"><span class="subnav-text">用户资料</span></a></li>  
	                        </shiro:hasPermission>                
	                    </ul>
	                </li>
                </shiro:hasPermission>
                <shiro:hasPermission name="user:list">
	                <li class="nav-li last-nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">前端用户管理</span></a>
	                    <ul class="subnav">
	                    	<shiro:hasPermission name="user:add">
	                    		<li class="subnav-li" href="${pageContext.request.contextPath}/user/hqt_user_role.do" data-id="5"><a href="javascript:;" class="ue-clear"><span class="subnav-text">添加用户</span></a></li>    
	                    	</shiro:hasPermission>
	                    </ul>
	                </li>
                </shiro:hasPermission>
                <shiro:hasPermission name="role:list">
	                <li class="nav-li last-nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">菜单管理</span></a>
	                    <ul class="subnav">
	                    	<shiro:hasPermission name="menu:query">
	                    		<li class="subnav-li" href="${pageContext.request.contextPath}/menu" data-id="6"><a href="javascript:;" class="ue-clear"><span class="subnav-text">菜单信息</span></a></li>  
	                    	</shiro:hasPermission>                 	
	                    </ul>
	                </li>
                </shiro:hasPermission>
                <shiro:hasPermission name="safe:list">
	                <li class="nav-li last-nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">安全管理</span></a>
	                    <ul class="subnav">
	                    	<shiro:hasPermission name="safe:pwdedit">
	                    		<li class="subnav-li" href="${pageContext.request.contextPath}/admin/hqt_admin_password.do" data-id="7"><a href="javascript:;" class="ue-clear"><<span class="subnav-text">修改密码</span></a></li>                        
	                    	</shiro:hasPermission>
	                    </ul>
	                </li>
                </shiro:hasPermission>
               <%--  <c:if test="${adminRole eq '在线客服'}">
                 <li class="nav-li last-nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">咨询中心</span></a>
                    <ul class="subnav">
                    	<li class="subnav-li" href="${pageContext.request.contextPath}/admin/hqt_admin_chat.do" data-id="14"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">打开客服咨询</span></a></li>                        
                    </ul>
                </li>     
                </c:if>  --%> 
                <shiro:hasPermission name="role:list">
	                <li class="nav-li last-nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">角色管理</span></a>
	                    <ul class="subnav">
	                    	<shiro:hasPermission name="role:query">
	                    		<li class="subnav-li" href="${pageContext.request.contextPath}/role" data-id="8"><a href="javascript:;" class="ue-clear"><span class="subnav-text">角色信息</span></a></li>    
	                    	</shiro:hasPermission>
	                    	<shiro:hasPermission name="role:add">
	                    		<li class="subnav-li" href="${pageContext.request.contextPath}/hqt_roleadd" data-id="9"><a href="javascript:;" class="ue-clear"><span class="subnav-text">角色信息添加</span></a></li>                                            
	                    	</shiro:hasPermission>
	                    </ul>
	                </li>
                </shiro:hasPermission>                        
            </ul>
            <div class="tree-list outwindow">
            	<div class="tree ztree"></div>
            </div> 
        </div>
        <div class="main">
        	<div class="title">
                <i class="sidebar-show"></i>
                <ul class="tab ue-clear">
                   
                </ul>
                <i class="tab-more"></i>
                <i class="tab-close"></i>
            </div>
            <div class="content">
            </div>
        </div>
    </div>
</div>

<div class="more-bab-list">
	<ul></ul>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
    <div class="opt-panel-bl"></div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/global.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/nav.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/Menu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/jquery.ztree.core-3.5.js"></script>
 <script type="text/javascript">
	var menu = new Menu({
		/*  defaultSelect: $('.nav').find('li[data-id="1"]')  */
	});
</script> 
</html>
