<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>好前途后台登录页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/skin_/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/hqt_login.js"></script>
</head>
<body>
    <div id="bd">
    	<div id="main">
    		<h1>立学道平台管理系统</h1>
        	<div class="login-box">               
                <h3>用户登录</h3>
                <div class="input username" >                  
                    <span></span>
                    <input type="text" id="username" placeholder="请输入用户名"/>
                </div>
                <div class="input password">                    
                    <span></span>
                    <input type="password" id="password" placeholder="请输入用户密码"/>
                </div> 
                <div class="login-check">
                	<input type="checkbox" name="rememberMe" value="true">记住密码
                	<a>忘记密码?</a>
                </div>                                
                <div id="btn" class="loginButton">
                    <input type="button" class="button" onclick="login()" value="登录"  />                    
                </div>
            </div>
        </div>        
    </div>

</body>

</html>
