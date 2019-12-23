<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>数据中心页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/skin_/nav.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/Hui-iconfont/1.0.8/iconfont.css" />
</head>
<body>
<div id="container">
	<div id="bd">
    	<div class="sidebar">
        	<div class="sidebar-bg"></div>
            <i class="sidebar-hide"></i>
            <h2><a href=""><i class="Hui-iconfont h2-icon">&#xe61a;</i><span>数据管理</span></a></h2>
            <ul class="nav" id="nav-tab">
            	<c:if test="${SYSTEM_USER.username == 'adminuser'}">            		          	
	            	 <li class="nav-li"><a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">职业库</span></a>
	                	<ul class="subnav">	                		
	                    	<li class="subnav-li " href="${pageContext.request.contextPath}/hqt_vocation" data-id="2"><a href="javascript:;" class="ue-clear"><span class="subnav-text">职业信息</span></a></li>
	                        <li class="subnav-li" href="${pageContext.request.contextPath}/hqt_vocationadd" data-id="3"><a href="javascript:;" class="ue-clear"><span class="subnav-text">职业信息添加</span></a></li>                                   
	                    </ul>
	                </li>                         	
	            	 <li class="nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">高校/专业库</span></a>
	                	<ul class="subnav">	                		
	                    	<li class="subnav-li " href="${pageContext.request.contextPath}/hqt_specialty" data-id="4"><a href="javascript:;" class="ue-clear"><span class="subnav-text">本科专业</span></a></li>
	                        <li class="subnav-li" href="${pageContext.request.contextPath}/hqt_specialtyadd" data-id="5"><a href="javascript:;" class="ue-clear"><span class="subnav-text">专业信息添加</span></a></li>                                    
	                    	<li class="subnav-li" href="${pageContext.request.contextPath}/hqt_university" data-id="6"><a href="javascript:;" class="ue-clear"><span class="subnav-text">学校信息</span></a></li>                                    
	                    	<li class="subnav-li" href="${pageContext.request.contextPath}/hqt_university" data-id="7"><a href="javascript:;" class="ue-clear"><span class="subnav-text">学校信息添加</span></a></li>                                    
	                    </ul>
	                </li>                             	
	            	 <li class="nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">测评</span></a>
	                	<ul class="subnav">	                		
	                    	<li class="subnav-li " href="${pageContext.request.contextPath}/hqt_personality" data-id="8"><a href="javascript:;" class="ue-clear"><span class="subnav-text">测评数据</span></a></li>
	                        <li class="subnav-li" href="${pageContext.request.contextPath}/hqt_personalityadd" data-id="9"><a href="javascript:;" class="ue-clear"><span class="subnav-text">测评数据添加</span></a></li>                                     
	                    </ul>
	                </li>         	
            	</c:if>
            	<c:if test="${SYSTEM_USER.username != 'adminuser'}"> 
	            	<shiro:hasPermission name="data-v:list">              	
		            	 <li class="nav-li">
		                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">职业库</span></a>
		                	<ul class="subnav">
		                		<shiro:hasPermission name="data-v:query">
		                    		<li class="subnav-li " href="${pageContext.request.contextPath}/hqt_vocation" data-id="2"><a href="javascript:;" class="ue-clear"><span class="subnav-text">职业信息</span></a></li>
		                        </shiro:hasPermission>
		                        <shiro:hasPermission name="data-v:add">
		                        	<li class="subnav-li" href="${pageContext.request.contextPath}/hqt_vocationadd" data-id="3"><a href="javascript:;" class="ue-clear"><span class="subnav-text">职业信息添加</span></a></li>  
		                        </shiro:hasPermission>                
		                    </ul>
		                </li>
	                </shiro:hasPermission>  
	                <shiro:hasPermission name="data-s:list">              	
		            	 <li class="nav-li">
		                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">高校/专业库</span></a>
		                	<ul class="subnav">
		                		<shiro:hasPermission name="data-s:query">
		                    		<li class="subnav-li " href="${pageContext.request.contextPath}/hqt_specialty" data-id="4"><a href="javascript:;" class="ue-clear"><span class="subnav-text">本科专业</span></a></li>
		                        </shiro:hasPermission>
		                        <shiro:hasPermission name="data-s:add">
		                        	<li class="subnav-li" href="${pageContext.request.contextPath}/hqt_specialtyadd" data-id="5"><a href="javascript:;" class="ue-clear"><span class="subnav-text">专业信息添加</span></a></li>  
		                        </shiro:hasPermission>                
		                    </ul>
		                </li>
	                </shiro:hasPermission>    
	                <shiro:hasPermission name="data-u:list">              	
		            	 <li class="nav-li">
		                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">高校库</span></a>
		                	<ul class="subnav">
		                		<shiro:hasPermission name="data-u:query">
		                    		<li class="subnav-li " href="${pageContext.request.contextPath}/hqt_adminadd" data-id="6"><a href="javascript:;" class="ue-clear"><span class="subnav-text">高校信息</span></a></li>
		                        </shiro:hasPermission>
		                        <shiro:hasPermission name="data-u:add">
		                        	<li class="subnav-li" href="${pageContext.request.contextPath}/hqt_admin" data-id="7"><a href="javascript:;" class="ue-clear"><span class="subnav-text">高校信息添加</span></a></li>  
		                        </shiro:hasPermission>                
		                    </ul>
		                </li>
	                </shiro:hasPermission> 
	              </c:if>                                  
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
