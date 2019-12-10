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
              	<li class="nav-li current" href=""  data-id="1"><a href="javascript:;" class="ue-clear"><i class="nav-ivon1"></i><span class="nav-text">首页</span></a></li>
            	 <li class="nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">单位信息管理</span></a>
                	<ul class="subnav">
                    	<li class="subnav-li current" href="${pageContext.request.contextPath}/hqt_company" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">单位信息查看</span></a></li>
                        <li class="subnav-li current" href="${pageContext.request.contextPath}/hqt_companyadd" data-id="3"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">单位信息添加</span></a></li>               
                    </ul>
                </li>                               
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
		defaultSelect: $('.nav').find('li[data-id="1"]')	
	});
	
	
</script>
</html>
