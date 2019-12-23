<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>好前途后台管理模板</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/skin_/main.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/global.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main/core.js"></script>
</head>

<body>
<div id="container">
	<div id="hd">
    	<div class="hd-top">
            <h1 class="logo"></h1>
            <div class="user-info">
                <a href="javascript:;" class="user-avatar"><span></span></a>
                <span class="user-name">${SYSTEM_USER.roleName}(</span><span class="user-name1">${SYSTEM_USER.username}</span>)               
            </div>
            <div class="setting ue-clear">            	
                <ul class="setting-main ue-clear">
                	<li><a href="javascript:;">桌面</a></li>
                    <li><a href="javascript:;">设置</a></li>
                    <li><a href="javascript:;">帮助</a></li>
                    <li ><a  href="${pageContext.request.contextPath}/logout" ><label class="close-btn exit"></label>退出</a></li>
                </ul>
            </div>
        </div>
        <div class="hd-bottom">        	
        	<div class="nav-wrap">
                <ul class="nav ue-clear">
                	<c:if test="${SYSTEM_USER.username == 'adminuser'}">
                		<li class="nav_lihover"><a href="javascript:location.replace(location.href);">首页</a></li>
                		<li><a>新高考</a></li>
                		<li><a>志愿填报</a></li>
                		<li><a onclick="change('${pageContext.request.contextPath}/hqt_data')">数据中心</a></li>
                		<li><a onclick="change('${pageContext.request.contextPath}/hqt_user')">用户管理</a></li>
                		<li><a onclick="change('${pageContext.request.contextPath}/hqt_system')">系统管理</a></li> 
                	</c:if>
                	<c:if test="${SYSTEM_USER.username != 'adminuser'}">
                		<shiro:hasPermission name="hqt_index:query">
	                    	<li class="nav_lihover"><a href="javascript:location.replace(location.href);">首页</a></li>
	                    </shiro:hasPermission> 
	                	<shiro:hasPermission name="hqt_xgk:query">
	                    	<li><a>新高考</a></li>
	                    </shiro:hasPermission> 
	                    <shiro:hasPermission name="hqt_zytb:query">
	                   		<li><a>志愿填报</a></li>  
	                   	</shiro:hasPermission>
	                   	<shiro:hasPermission name="hqt_data:query"> 
	                   		<li><a onclick="change('${pageContext.request.contextPath}/hqt_data')">数据中心</a></li>  
	                   	</shiro:hasPermission> 
	                   	<shiro:hasPermission name="hqt_admin:query">  
	                    	<li><a onclick="change('${pageContext.request.contextPath}/hqt_user')">用户管理</a></li>
	                    </shiro:hasPermission>
	                    <shiro:hasPermission name="hqt_sys:query">
	                    	<li><a onclick="change('${pageContext.request.contextPath}/hqt_system')">系统管理</a></li> 
	                    </shiro:hasPermission>
                	</c:if>                	                                                     
                </ul>
            </div>
            <div class="nav-btn">
            	<a href="javascript:;" class="nav-prev-btn"></a>
                <a href="javascript:;" class="nav-next-btn"></a>
            </div>
        </div>
    </div>
    <div id="bd">
        <iframe width="100%" height="100%" id="mainIframe" src="" ></iframe>
    </div>    
    <div id="ft" class="ue-clear">
    	<div class="ft1 ue-clear">
        	<i class="ft-icon1"></i> <span>好前途管理系统  </span>
            <em>Digital Pertal</em>
        </div>
        <div class="ft2 ue-clear">
        	<span>Call Center</span>
            <em>V2.0 2019</em>
            <i class="ft-icon2"></i>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/hqt_index.js"></script>
</html>
