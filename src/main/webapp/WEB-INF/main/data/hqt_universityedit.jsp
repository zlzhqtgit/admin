<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>学校信息修改页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/static/layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/specialty.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/updataimg.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/Hui-iconfont/1.0.8/iconfont.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/hqt_university.js"></script>
</head>
<body>	
	<form id="from-university"action="" method="post" class="layui-form layui-form-pane">
			<div class="tablist_wrap margin_top1 padding-side">
				<ul class="list-unstyled tab_h clearfix">
					<li class="now">学校介绍</li>
					<li>招生录取</li>
					<li>校验教学</li>
					<li>招生简章</li>
					<div class="text-center padding-side"><input class="btn btn-primary" type="button" onclick="updateun()" value="保存修改"/></div>
				</ul>
				<div class="tab_b">
					<div class="now margin_bot2">
						<div class="majorUpdate padding-side2">
							<ul class="list-unstyled major_summary_wrap">
								<li>
									<div class="">
										<div class="" style="display: flex;justify-content: flex-start;align-items: center;">
											<label for="" class="text-muted" style="display: flex;justify-content: center;align-items: center;"><h4 class="fontwei">学校代码：</h4>
												<input type="hidden" name="id" id="id" value="${universityById.id}">
												<input class="fontwei text-center text-primary" type="" name="universitiesCode" id="universitiesCode" style="font-size: 18px;" value="${universityById.universitiesCode}" /></label>
											<label for="" class="text-muted padding-side">大学名称：<input class="text-center width6em" type="" name="universitiesName" id="universitiesName" value="${universityById.universitiesName}" /></label>
											<label for="" class="text-muted padding-side">省份信息：<input class="text-center width6em" type="" name="province" id="province" value="${universityById.province}" /></label>
										</div>
										<div class="margin_top1">
											<label for="" class="text-muted padding-side">城市信息：<input class="text-center" type="" name="city" id="city" value="${universityById.city}" /></label>
											<label for="" class="text-muted padding-side">创建时间：<input class="text-center" type="" name="establishedTime" id="establishedTime" value="${universityById.establishedTime}" /></label>
											<label for="" class="text-muted padding-side">办学性质：<input class="text-center" type="" name="universitiesNature" id="universitiesNature" value="${universityById.universitiesNature}" /></label>
										</div>
										<div class="margin_top1">
											<label for="" class="text-muted padding-side">隶属于：<input class="text-center" type="" name="belongTo" id="belongTo" value="${universityById.belongTo}" /></label>
											<label for="" class="text-muted padding-side">学校地址：<input class="text-center" type="" name="address" id="address" value="${universityById.address}" /></label>										
										</div>
										<div class="margin_top1">
											<label for="" class="text-muted padding-side" style="display: flex;justify-content: flex-start;"><span class="width6em">学校介绍：</span> 
											<textarea name="universitiesIntroduction" rows="4" cols="">${universityById.universitiesIntroduction}</textarea></label>
										</div>
									</div>
								</li>
								<li>
									<div class="major_summary flex_JAstart">
										<div class="">
											<h4 class="text-primary fontwei">院校属性</h4>
											<div class="">
												<c:forEach items="${universitiesAttributes}" var="c">
													<input type="text" name="yxsx-name"  autocomplete="off" class="width6em text-center" value="${c}">											
												</c:forEach>																								 
												<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysrone(this,'yxsx-name')"><i class="layui-icon"></i></button>
											</div>
										</div>
										<div class="padding-side2">
											<h4 class="text-primary fontwei">院校类型</h4>
											<input type="" class="width6em text-center" name="" id="" value="${universityById.universitiesType}" />
										</div>
									</div>
								</li>
								<li>
									<div class="major_summary">
										<h4 class="text-primary fontwei">学校图标</h4>
										<div class="sch_pic">
											<img id="img_cardPic" name="show-img3" class="showimg" src="${pageContext.request.contextPath}${universityById.universitiesLogo}">										
											<input type="file" name="cardPic" id="cardPic" onchange="change(this)" class="file" />
										</div>
									</div>
								</li>
								<li>
									<div class="">
										<h4 class="text-primary fontwei">校园生活</h4>
										<div class="">
											<div id="showimg">
												<ul id="showui">
												<c:if test="${universitiesLife!=null}">
													<c:forEach items="${universitiesLife}" var="c" varStatus="catr">
														<li>													
															<div class="main">
																<div class="showdiv">																	
																	<img class="center" name="show-img${catr.index}"  onclick="delimg(this)" src="${pageContext.request.contextPath}/static/images/updataimg/delete.svg">																	
																</div>																																 
															 </div>
															 <div class="sch_pic">
																	<img id="show-img${catr.index}"  class="showimg" src="${pageContext.request.contextPath}${c}">										
																	<input type="file" name="yysh" id="cardPic${catr.index}" onchange="change(this)" class="file" />
																</div>
														</li>
													</c:forEach>
												</c:if>																																																		
												</ul>	
												<div class="upimg">
													<input type="file" id="upgteimg" name="yysh" onchange="change(this)"  multiple />
												</div>																					
											</div>																												
											<ul class="list-unstyled padding-side major_intro">
												<li>
													<span class="width6em">食宿条件：</span>
													<textarea name="roomAndBoard" id="roomAndBoard" rows="9" cols="">${universityById.roomAndBoard} </textarea>
												</li>
												<li>
													<span class="width6em">奖助学金：</span>
													<textarea name="scholarships" id="scholarships" rows="9" cols="">${universityById.scholarships} </textarea>
												</li>
											</ul>
										</div>
											
									</div>
								</li>
								<li>
									<c:if test="${teachingResearch == null}">
										<label>教研教学数据错误：${listStr1}</label>
									</c:if>
									<h4 class="text-primary fontwei">教研教学</h4>									
									<div class="layui-form-item" style="margin-left: 45px;">
									<c:if test="${teachingResearch != null}">
										<c:forEach items="${teachingResearch}" var="c">
											<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">名称</label>
												<div class="layui-input-inline" style="width: 130px;">
													<input type="text" name="jyjx-name"  autocomplete="off" class="layui-input" value="${c[0]}">
												</div>
												<div class="layui-form-mid">-</div><label class="layui-form-label" style="width: 60px;">数值</label>
												<div class="layui-input-inline" style="width: 130px;">
													<input type="text" name="jyjx-nub"  autocomplete="off" class="layui-input" value="${c[1]}">
												</div>
											</div>
										</c:forEach>
									</c:if>
										<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysr(this,'jyjx-name','jyjx-nub','名称','数值')"><i class="layui-icon"></i></button>
									</div>									
								</li>
								<li>
									<h4 class="text-primary fontwei">男女比例</h4>
									<div class="subject_pick">
										<div class="margin_top1">
											<label for="" class="text-muted padding-side">男生:女生-比例：<input class="text-center width6em" type="" name="maleFemaleRatio" id="maleFemaleRatio" value="${universityById.maleFemaleRatio}" /></label>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>					
					<div class="margin_bot2">
						<div class="margin_top1">
							<label for="" class="text-muted padding-side">省份：
								<select class="" name="where" onclick=" unwhere()" id="ur_province" style="display: block;float: right;margin-top: -5px;">
									<option value="0">请选择</option>
									<option value="贵州省">贵州省</option>
									<option value="北京省">北京省</option>
									<option value="上海省">上海省</option>
								</select>
							</label>
							<label for="" class="text-muted padding-side">年份：
								<select name="where"  id="ur_year" onclick=" unwhere()" style="display: block;float: right;margin-top: -5px;">
									<option value="0">请选择</option>
									<option value="2019">2019</option>
									<option value="2018">2018</option>
									<option value="2017">2017</option>
									<option value="2015">2015</option>
								</select>
							</label>
							<label for="" class="text-muted padding-side">录取类型：
								<select name="where"  onclick=" unwhere()" id="subject_type"  style="display: block;float: right;margin-top: -5px;">
									<option value="0">请选择</option>
									<option value="理科">理科</option>
									<option value="文科">文科</option>
								</select>
							</label>
							<label for="" class="text-muted padding-side">录取批次：
								<select name="where" onclick=" unwhere()" id="admission_batch"  style="display: block;float: right;margin-top: -5px;">
									<option value="0">请选择</option>
									<option value="本科一批">本科一批</option>
									<option value="本科二批">本科二批</option>
									<option value="本科三批">本科三批</option>
								</select>
							</label>
							<label for="" class="text-muted padding-side">
								<!-- <input type="button" onclick="unwhere()" value="查询"> -->
								<input type="button" onclick="savedatafs()" value="保存更改">
							</label>							
						</div>
						<ul class="list-unstyled padding-side2 margin_top2 summary_Gjob" style="border: 0;">
							<li>
								<div class="flex_JCbetw margin_bot">
									<h3 class="text-primary fontwei">院校分数线</h3>
									<!-- <a href="javascript:void(0)" class="btn btn-success" onclick="add_dateRow('yxfsx')">
										<span class="glyphicon glyphicon-plus"></span> 新增数据
									</a> -->
								</div>
								<table class="table table-striped table-hover border-defult" id="yxfsx" cellspacing="" cellpadding="">
									<thead>
										<tr><th>最低分</th><th>平均分</th><th>最高分</th><th>投档线</th><th>线差</th><th>最低位次</th><th>计划人数</th><th>录取人数</th><th>操作</th></tr>
									</thead>
									<tbody>										
									</tbody>									
								</table>
							</li>
							<li>
								<div class="flex_JCbetw margin_bot">
									<h3 class="text-primary fontwei">招生计划</h3>
									<a href="javascript:void(0)" class="btn btn-success" onclick="add_dateRow('zsjh')">
										<span class="glyphicon glyphicon-plus"></span> 新增数据
									</a>
								</div>							
								<table class="table table-hover border-defult" id="zsjh" cellspacing="" cellpadding="">
									<thead>
										<tr><th>专业代码</th><th>专业名称</th><th>学科门类</th><th>二级门类</th><th>计划招生</th><th>操作</th></tr>
									</thead>
									<tbody>										
									</tbody>								
								</table>
							</li>
							<li>
								<div class="flex_JCbetw margin_bot">
									<h3 class="text-primary fontwei">专业录取分数线</h3>
									<a href="javascript:void(0)" class="btn btn-success" onclick="add_dateRow('lqfsx')">
										<span class="glyphicon glyphicon-plus"></span> 新增数据
									</a>
								</div>								
								<table class="table table-hover border-defult" id="lqfsx" cellspacing="" cellpadding="">
									<thead>
										<tr><th>专业代码</th><th>专业名称</th><th>学科门类</th><th>录取人数</th><th>录取平均分</th><th>录取最低分</th><th>操作</th></tr>
									</thead>
									<tbody>										
									</tbody>								
								</table>
							</li>
						</ul>
						<script type="text/javascript">
						function savedatafs(){							    
							var zsjhrows = document.getElementById("yxfsx").rows;
							var yxfsxdata=new Array();
							for (var i = 1; i < zsjhrows.length; i++) {    //--循环所有的行
							    var cells = zsjhrows[i].cells;  // cells 集合返回表格中所有 <td> 或 <th> 元素。
							    for (var j = 0; j < cells.length-1; j++) {    //--循环所有的列，从第一列取数据，因为一般第一列都是标识，数据毫无意义。
							    	yxfsxdata[j]= cells[j].childNodes[0].value;//取有input框的数据var value = cells[j].innerHTML;//取没有input框的数据
							    }
							}
							
							var zsjhrows = document.getElementById("zsjh").rows;
							var zsjhdata=new Array();
							for (var i = 1; i < zsjhrows.length; i++) {   
								zsjhdata[i-1]=new Array();
							    var cells = zsjhrows[i].cells;             
							    for (var j = 0; j < cells.length-1; j++) {   
							    	zsjhdata[i-1][j]= cells[j].childNodes[0].value; //取有input框的数据var value = cells[j].innerHTML;//取没有input框的数据
							    }
							}
							var lqfsxrows = document.getElementById("lqfsx").rows;
							var lqfsxdata=new Array();
							for (var i = 1; i < lqfsxrows.length; i++) {   
								lqfsxdata[i-1]=new Array();
							    var cells = lqfsxrows[i].cells;             
							    for (var j = 0; j < cells.length-1; j++) {   
							    	lqfsxdata[i-1][j]= cells[j].childNodes[0].value; //取有input框的数据var value = cells[j].innerHTML;//取没有input框的数据
							    }
							}
							var where=onwhere();
							var data="universitiesCode="+$("#universitiesCode").val()+"&urYear="+$("#ur_year").val()+"&urProvince="+$("#ur_province").val()+
							"&subjectType="+$("#subject_type").val()+"&admissionBatch="+$("#admission_batch").val()+"&collegeScoreLine="+JSON.stringify(yxfsxdata)+"&enrollmentPlan="+JSON.stringify(zsjhdata)+
							"&professionalAdmissionScore="+JSON.stringify(lqfsxdata)+"&where="+where;
							 $.ajax({
									"url" : "universityRelationedit",
									"data" : data,
									"type" : "POST",
									"dataType" : "json",
									"success" : function(obj) {
										if (obj.state == 0) {
											layer.msg(obj.message, {icon : 2,time : 1000});
											return;
										} else {
											layer.msg("操作成功", {icon : 1,time : 1000});
										}
									}
							 });
						}
						function onwhere(){
							 var where="";
							 var shcheck=document.querySelectorAll("select[name='where']");
							 if(shcheck.length==0){
								 return where;
							 }
							 for(var i=0;i<shcheck.length;i++){	
								 if(shcheck[i].value!=0){
									 if(i==shcheck.length-1){
										 where+=shcheck[i].id+"='"+shcheck[i].value+"'";
									 }else{
										 where+=shcheck[i].id+"='"+shcheck[i].value+"' and ";
									 }										 
								 }else{									 
									 where="";
									 return where;
								 }																	
							 }								
							 if(where!=""){
								 where="universities_code='"+$("#universitiesCode").val()+"' and "+where;
							 }
							
							 return where;
						}
							 function unwhere(){															 
								 var where = onwhere();								
								 if(where !=""){
									 var data="where="+where;								 
									 $.ajax({
											"url" : "universityRelation",
											"data" : data,
											"type" : "POST",
											"dataType" : "json",
											"success" : function(obj) {
												if (obj.state == 0) {
													layer.msg(obj.message, {icon : 2,time : 1000});
													return;
												} else {
													layer.msg("操作成功", {icon : 1,time : 1000});												
													var yxfsx="<tr>";
													var yxfsxsum=$("#yxfsx").find("tr").find("th").length;	
													var zsjhsum=$("#zsjh").find("tr").find("th").length;
													var lqfsxsum=$("#lqfsx").find("tr").find("th").length;
													if(obj.data[0].length>0){
														for(var i=0;i<yxfsxsum;i++){
															if(i < parseInt(obj.data[0].length)&& i<yxfsxsum-1){														
																yxfsx+='<td><input type="text" value="'+obj.data[0][i]+'"></td>';
															}else{
																if(i==yxfsxsum-1){
																	yxfsx+='<td style="width: 80px;"><a href="javascript:;" onclick="del_tr(this)" class="operation operation-del" style="text-decoration:none">'+
																		'<i class="Hui-iconfont" style="font-size: 1em;">&#xe6e2;</i>删除</a>'+
																		'</td></tr>';
																}else{
																	yxfsx+='<td><input type="text" value=""></td>';
																}
															}													
														}
													}else{
														layer.msg("有不合法的数据，请重新处理数据", {icon : 2,time : 2000});
													}												
													$("#yxfsx").find("tbody").html(yxfsx);											
													var zsjh=""
													if(obj.data[1].length>0){
														for(var j=0;j<zsjhsum;j++){
															zsjh +="<tr>";
															for(var h=0;h<obj.data[1][j].length+1;h++){															
																if(h < parseInt(obj.data[1][j].length)&& h<zsjhsum-1){														
																	zsjh+='<td><input type="text" value="'+obj.data[1][j][h]+'"></td>';
																}else{
																	if(h==zsjhsum-1){
																		zsjh +='<td style="width: 80px;"><a href="javascript:;" onclick="del_tr(this)" class="operation operation-del" style="text-decoration:none">'+
																			'<i class="Hui-iconfont" style="font-size: 1em;">&#xe6e2;</i>删除</a>'+
																			'</td></tr>';
																	}else{
																		zsjh +='<td><input type="text" value=""></td>';
																	}
																}														
															}																									
														}
														$("#zsjh").find("tbody").html(zsjh);
													}else{
														layer.msg("有不合法的数据，请重新处理数据", {icon : 2,time : 2000});
													}											
													if(obj.data[2].length>0){
														var lqfsx=""
															for(var j=0;j<lqfsxsum;j++){
																lqfsx +="<tr>";
																for(var h=0;h<obj.data[2][j].length+1;h++){																
																	if(h < parseInt(obj.data[2][j].length) && h<lqfsxsum-1){														
																		lqfsx+='<td><input type="text" value="'+obj.data[2][j][h]+'"></td>';
																	}else{
																		if(h==lqfsxsum-1){
																			lqfsx +='<td style="width: 80px;"><a href="javascript:;" onclick="del_tr(this)" class="operation operation-del" style="text-decoration:none">'+
																				'<i class="Hui-iconfont" style="font-size: 1em;">&#xe6e2;</i>删除</a>'+
																				'</td></tr>';
																		}else{
																			lqfsx +='<td><input type="text" value=""></td>';
																		}
																	}														
																}																									
															}
															$("#lqfsx").find("tbody").html(lqfsx);
													}else{
														layer.msg("有不合法的数据，请重新处理数据", {icon : 2,time : 2000});
													}												
												}
											}
									 }); 
								 }
								 
							};
							function del_tr(obj) {
								$(obj).parents("tr").remove();
							}
							function add_dateRow(name) {
								var sum=$("#"+name).find("tr").find("th").length; //行数	
								console.log(sum);
								var str="<tr>";
								for(var i=0;i<sum;i++){
									if(i==sum-1){
										str+='<td style="width: 80px;"><a href="javascript:;" onclick="del_tr(this)" class="operation operation-del" style="text-decoration:none">'+
											'<i class="Hui-iconfont" style="font-size: 1em;">&#xe6e2;</i>删除</a>'+
											'</td></tr>';
									}else{
										str+='<td><input type="text" value=""></td>';
									}
								}							
								$("#"+name).find("tbody").prepend(str);							
							}
						</script>
					</div>
					<div class="margin_bot2">
						<div class="margin_top1">
							<div class="margin_top1" style="    border-bottom: 1px solid #0166cc;">
								<label for="" class="text-muted padding-side2" style="display: flex;justify-content: flex-start;"><span class="width6em" style="font-size: 18px;">师资力量：</span> 
								<textarea name="teachersResources" rows="4" cols="">${universityById.teachersResources}</textarea></label>
								<fieldset class="layui-elem-field layui-field-title " style="border:0;">
									<legend style="font-size: 18px;color: #0166cc;font-weight: 600;">重点专业</legend>
									<c:if test="${coreSpecialty == null}">
										<label style="color: red;">重点专业数据错误：${listStrSpecialty}</label>
									</c:if>
									<div class="layui-form-item" style="margin-left: 45px;">
									<c:if test="${coreSpecialty != null}">
										<c:forEach items="${coreSpecialty}" var="c">
											<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">编号</label>
												<div class="layui-input-inline" style="width: 130px;">
													<input type="text" name="zdzy-code"  autocomplete="off" class="layui-input" value="${c[0]}">
												</div>
												<div class="layui-form-mid">-</div><label class="layui-form-label" style="width: 60px;">名称</label>
												<div class="layui-input-inline" style="width: 130px;">
													<input type="text" name="hysr-name"  autocomplete="off" class="layui-input" value="${c[1]}">
												</div>
											</div>
										</c:forEach>
									</c:if>
										<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysr(this,'zdzy-code','hysr-name','编号','名称')"><i class="layui-icon"></i></button>
									</div>
								</fieldset>	
							</div>							
							<div class="margin_top1" style="    border-bottom: 1px solid #0166cc;">
								<fieldset class="layui-elem-field layui-field-title " id="zdxk" style="border:0;">
									<legend style="font-size: 18px;color: #0166cc;font-weight: 600;">重点学科
									<button type="button" class="layui-btn layui-btn-sm"onclick="btnzdxk('zdxk','zdxk-name')"><i class="layui-icon"></i></button></legend>
									<c:if test="${coreSubject.size()==0}">
										<label style="color: red;">重点学科数据错误：${listStrSubject}</label>
									</c:if>	
									<c:if test="${coreSubject.size()>0}">																	
									 <c:forEach items="${coreSubject}" var="c" varStatus="cs1">
									 <input id="zdxk-name${cs1.index}" name="zdxk-name" value="${c[0][0]}" class="zdxk-label"><br>	
									 	<div class="layui-form-item" style=" display: inline-block;margin-left: 45px"">									 	
										<c:forEach items="${c[1]}" var="f" varStatus="cs2">
											<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">名称</label>
												<div class="layui-input-inline" style="width: 130px;">
													<input type="text" name="zdxk-name${cs1.index}"  autocomplete="off" class="layui-input" value="${f}">
												</div>
											</div>
											<c:if test="${cs2.last}">												
												<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysrtwo(this,'zdxk-name${cs1.index}','名称')"><i class="layui-icon"></i></button>
											</c:if>
										</c:forEach> 
										</div><br>																		
									</c:forEach>
									</c:if>								
								</fieldset>	
							</div>	
							<div class="margin_top1" style="    border-bottom: 1px solid #0166cc;">
								<fieldset class="layui-elem-field layui-field-title " id="zdsys" style="border:0;">
									<legend style="font-size: 18px;color: #0166cc;font-weight: 600;">重点实验室及科研中心
									<button type="button" class="layui-btn layui-btn-sm"onclick="btnzdxk('zdsys','zdsys-name')"><i class="layui-icon"></i></button></legend>
									<c:if test="${researchCenters.size()==0}">
										<label style="color: red;">重点实验室及科研中心数据错误：${listStrResearchCenters}</label>
									</c:if>
									<c:if test="${researchCenters.size()>0}">																	
									 <c:forEach items="${researchCenters}" var="c" varStatus="cs1">
									 <input id="zdsys-name${cs1.index}" name="zdsys-name" value="${c[0][0]}" class="zdxk-label"><br>	
									 	<div class="layui-form-item" style=" display: inline-block;margin-left: 45px"">									 	
										<c:forEach items="${c[1]}" var="f" varStatus="cs2">
											<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">名称</label>
												<div class="layui-input-inline" style="width: 130px;">
													<input type="text" name="zdsys-name${cs1.index}"  autocomplete="off" class="layui-input" value="${f}">
												</div>
											</div>
											<c:if test="${cs2.last}">												
												<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysrtwo(this,'zdsys-name${cs1.index}','名称')"><i class="layui-icon"></i></button>
											</c:if>
										</c:forEach> 
										</div><br>																		
									</c:forEach>
									</c:if>															
								</fieldset>	
							</div>								
							<ul class="list-unstyled padding-side2 margin_top2 summary_Gjob" style="border: 0;">
								<li style="margin-left: -25px;">
									<div class="margin_top1" style="    border-bottom: 1px solid #0166cc;">
										<fieldset class="layui-elem-field layui-field-title " style="border:0;">
											<legend style="font-size: 18px;color: #0166cc;font-weight: 600;">录取批次</legend>
											<c:if test="${admissionLot == null}">
												<label style="color: red;">录取批次数据错误：${listStradmissionLot}</label>
											</c:if>
											<c:if test="${admissionLot != null}">
											<div class="layui-form-item" style="    margin-left: 45px;">
												<c:forEach items="${admissionLot}" var="c">
													<input type="text" name="lqpc-name" value="${c}" autocomplete="off" class="width6em text-center">
												</c:forEach>
												<button type="button" class="layui-btn layui-btn-sm"onclick="btnhysrone(this,'lqpc-name')"><i class="layui-icon"></i></button>
											</div>
											</c:if>
										</fieldset>	
									</div>									
									<ul class="list-unstyled">
										<li>											
											<div class="flex_row_start margin_top1">
												<label for="" class="text-muted padding-side"><span class="width6em lebel-rigth">一流学科数量：</span><input type="" name="admissionProbability" id="" value="${universityById.admissionProbability}" /></label></br>
												<label for="" class="text-muted padding-side"><span class="width6em lebel-rigth">学校官网：</span><input class="" type="" name="universitiesWebsite" id="" value="${universityById.universitiesWebsite}" /></label></br>
												<label for="" class="text-muted padding-side "><span class="width6em lebel-rigth">招生电话：</span><input  type="" name="universitiesPhone" id="" value="${universityById.universitiesPhone}" /></label>
											</div>											
											<div class="flex_row_start margin_top1">
												<label for="" class="text-muted padding-side"><span class="width6em lebel-rigth">校友会排名：</span><input type="" name="alumniAssociationRanking" id="" value="${universityById.alumniAssociationRanking}" /></label>
												<label for="" class="text-muted padding-side"><span class="width6em lebel-rigth">武书联排名：</span><input class="width4em" type="" name="martialBookAssociationRanking" id="" value="${universityById.martialBookAssociationRanking}" /></label>
												<label for="" class="text-muted padding-side">软科：<input class="width4em" type="" name="softScienceRanking" id="" value="${universityById.softScienceRanking}" /></label>
												<label for="" class="text-muted padding-side">QS排名：<input class="width4em" type="" name="quacquarelliSymondsRanking" id="" value="${universityById.quacquarelliSymondsRanking}" /></label>
												<label for="" class="text-muted padding-side">USNews：<input class="width4em" type="" name="usNewsRanking" id="" value="${universityById.usNewsRanking}" /></label>
											</div>
											<div class="flex_row_start margin_top1">
												<label for="" class="text-muted padding-side"><span class="width6em lebel-rigth">录取平均分排名：</span><input type="" name="admissionAverageRanking" id="" value="${universityById.admissionAverageRanking}" /></label>
												<label for="" class="text-muted padding-side"><span class="width6em lebel-rigth">综合评级：</span><input class="width4em" type="" name="totalRanking" id="" value="${universityById.totalRanking}" /></label>
											</div>
										</li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
					<div class="margin_bot2">
						<div class="margin_top1">
							<div class="padding-side2">
								<label for="" class="text-muted padding-side">省份：
									<select name="">
										<option value="">贵州</option>
										<option value="">北京</option>
										<option value="">上海</option>
									</select>
								</label>
								<label for="" class="text-muted padding-side">年份：
									<select name="">
										<option value="">2019</option>
										<option value="">2018</option>
										<option value="">2017</option>
									</select>
								</label>
							</div>
							<ul class="list-unstyled padding-side2 margin_top2 summary_Gjob" style="border: 0;">
								<li>
									<h4 class="text-primary fontwei">招生简章</h4>
									<ul class="list-unstyled padding-side2 admiss_policy">
										<li>
											<span class="width6em">招生简章：</span>
											<textarea name="specialtyEmployment" id="specialtyEmployment" rows="9" cols="">的撒发噶似高大上给怪我怪我我国 </textarea>
										</li>
									</ul>
								</li>
								<li>
									<h4 class="text-primary fontwei">招生章程</h4>
									<ul class="list-unstyled padding-side2 admiss_policy">
										<li>
											<span class="width6em">招生章程：</span>
											<textarea name="specialtyEmployment" id="specialtyEmployment" rows="9" cols="">的撒发噶似高大上给怪我怪我我国 </textarea>
										</li>
									</ul>
								</li>
							</ul>							
						</div>
					</div>
				</div>
			</div>
	</form>			
</body>
<script type="text/javascript">
tablist('.tab_h','.tab_b');
</script>
</html>
