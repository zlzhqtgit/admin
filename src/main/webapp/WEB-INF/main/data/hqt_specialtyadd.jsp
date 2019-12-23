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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/specialty.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/Hui-iconfont/1.0.8/iconfont.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/hqt_specialty.js"></script> 
</head>

<body>

		<form action="" method="" id="form-specialty-add">			
			<div class="tablist_wrap margin_top1 padding-side">
				<ul class="list-unstyled tab_h clearfix">
					<li class="now">专业概况</li>
					<li>就业概况</li>
					<li>学科评估</li>
					<div class="text-center padding-side"><input class="btn btn-primary" type="button" onclick="add()" value="添加数据"/></div>
				</ul>
				<div class="tab_b">
					<div class="now margin_bot2">
						<div class="majorUpdate padding-side2">
							<form action="" method="post">
								<ul class="list-unstyled major_summary_wrap">
									<li>
										<div class="">
											<div class="">
												<label for="" class="text-muted padding-side" >专业名称:<input class="fontwei text-center text-primary width4em" type="" name="specialtyName" id="specialtyName" style="font-size: 18px;" /></label>
												<label for="" class="text-muted padding-side">所属专业大类：<input class="fontwei text-center text-primary width4em" type="" name="specialtyMajorName" id="specialtyMajorName" /></label>
												<label for="" class="text-muted padding-side">所属专业分类：<input class="fontwei text-center text-primary width4em" type="" name="specialtyClassName" id="specialtyClassName"  /></label>
											</div>
											<div class="margin_top1">
												<label for="" class="text-muted padding-side" style="    width: 268px;">专业门类:<input class="fontwei text-center text-primary width4em" type="" name="specialtyDivided" id="specialtyDivided"  /></label>
												<label for="" class="text-muted padding-side">专业学科分类：<input class="fontwei text-center text-primary width4em" type="" name="specialtyDisciplines" id="specialtyDisciplines"  /></label>													
												<label for="" class="text-muted padding-side">国际代码：<input class="fontwei text-center text-primary width4em" type="" name="specialtyId" id="specialtyId"  />（不可用于填报）</label>
											</div>
										</div>
									</li>
									<li>
										<div class="major_summary">
											<h4 class="text-primary fontwei">专业概况</h4>
											<label for="" class="text-muted padding-side">学历层次：
											<input type="" name="specialtyEducation" id="specialtyEducation" /></label>
											<label for="" class="text-muted padding-side">修业年限：
											<input type="" name="studyDuration" id="studyDuration" /></label>
											<label for="" class="text-muted padding-side">授予学位：
											<input type="" name="bachelorDegree" id="bachelorDegree" /></label>
											<label for="" class="text-muted padding-side">男女比例：
											<input type="" name="maleFemaleRatio" id="maleFemaleRatio" /></label>
										</div>
									</li>
									<li>
										<div class="">
											<h4 class="text-primary fontwei">专业介绍</h4>
											<ul class="list-unstyled padding-side2 major_intro">
												<li>
													<span class="width6em">专业详情：</span>
													<textarea name="specialtyIntro" id="specialtyIntro" rows="3" cols=""></textarea>
												</li>
												<li>
													<span class="width6em">专业简介：</span>
													<textarea name="specialtySummary" id="specialtySummary" rows="3" cols=""></textarea>
												</li>
												<li>
													<span class="width6em">培养要求：</span>
													<textarea name="trainRequirement" id="trainRequirement" rows="3" cols=""></textarea>
												</li>
												<li>
													<span class="width6em">学科要求：</span>
													<textarea name="subjectRequirement" id="subjectRequirement" rows="3" cols=""></textarea>
												</li>
												<li>
													<span class="width6em">知识能力：</span>
													<textarea name="knowledgeAbility" id="knowledgeAbility" rows="3" cols=""></textarea>
												</li>
												<li>
													<span class="width6em">考研方向：</span>
													<textarea name="postgraduateDirection" id="postgraduateDirection" rows="3" cols=""></textarea>
												</li>
												<li>
													<span class="width6em">主要课程：</span>
													<textarea name="majorCourses" id="majorCourses" rows="3" cols=""></textarea>
												</li>
												<li>
													<span class="width6em">培养目标：</span>
													<textarea name="specialtyObjective" id="specialtyObjective" rows="3" cols=""></textarea>
												</li>
												<li>
													<span class="width6em">就业前景：</span>
													<textarea name="specialtyEmployment" id="specialtyEmployment" rows="3" cols=""></textarea>
												</li>
												<li>
													<span class="width6em">报考要求：</span>
													<textarea name="specialtyRequirement" id="specialtyRequirement" rows="3" cols=""></textarea>
												</li>
											</ul>
										</div>
									</li>
									<li>
										<h4 class="text-primary fontwei">专业学科匹配度</h4>
										<div class="subject_pick">											
											<div class="margin_top1">
												<label for="" class="padding-side">物理要求： 
													<input type="text" name="physicsPerformance" id="physicsPerformance"  style="width: 60px;"/>													
												</label>
												<label for="" class="padding-side">化学要求： 
													<input type="text" name="chemistryPerformance" id="chemistryPerformance"  style="width: 60px;"/>													
												</label>
												<label for="" class="padding-side">生物要求： 
													<input type="text" name="biologyPerformance" id="biologyPerformance"  style="width: 60px;"/>													
												</label>
												<label for="" class="padding-side">政治要求：
													<input type="text" name="politicPerformance" id="politicPerformance"  style="width: 60px;"/>													
												</label>
												<label for="" class="padding-side">历史要求： 
													<input type="text" name="historyPerformance" id="historyPerformance"  style="width: 60px;"/>													
												</label>
												<label for="" class="padding-side">地理要求： 
													<input type="text" name="geographyPerformance" id="geographyPerformance"  style="width: 60px;"/>													
												</label>
											</div>
										</div>
									</li>
								</ul>
							</form>
						</div>
					</div>
					<div class="margin_bot2">
						<ul class="list-unstyled padding-side2 margin_top2 summary_Gjob" style="border: 0;">
							<li>
								<h4 class="text-primary fontwei">就业职业方向</h4>
								<ul class="list-unstyled">
									<li>
										<div class="flex_row_start">
											<label for="" class="text-muted padding-side"><span class="width6em">第一职业：</span>
											<input type="" name="jyzyfx-name" id=""  /></label>
											<label for="" class="text-muted padding-side">第一职业概率：
											<input class="width4em" type="" name="jyzyfx-kl" id=""  /><span class="padding-side">%</span></label>
										</div>
										<label for="" class="text-muted padding-side flex_row_start"><span class="width6em">具体职业：</span>
										<input class="width100" type="" name="jyzyfx-commot" id=""  /></label>
									</li>
									<li>
										<div class="flex_row_start margin_top1">
											<label for="" class="text-muted padding-side"><span class="width6em">第二职业：</span>
											<input type="" name="jyzyfx-name" id=""  /></label>
											<label for="" class="text-muted padding-side">第二职业概率：
											<input class="width4em" type="" name="jyzyfx-kl" id=""  /><span class="padding-side">%</span></label>
										</div>
										<label for="" class="text-muted padding-side flex_row_start"><span class="width6em">具体职业：</span>
										<input class="width100" type="" name="jyzyfx-commot" id=""  /></label>
									</li>
									<li>
										<div class="flex_row_start margin_top1">
											<label for="" class="text-muted padding-side"><span class="width6em">第三职业：</span>
											<input type="" name="jyzyfx-name" id="" /></label>
											<label for="" class="text-muted padding-side">第三职业概率：
											<input class="width4em" type="" name="jyzyfx-kl" id=""  /><span class="padding-side">%</span></label>
										</div>
										<label for="" class="text-muted padding-side flex_row_start"><span class="width6em">具体职业：</span>
										<input class="width100" type="" name="jyzyfx-commot" id="" /></label>
									</li>
									<li>
										<div class="flex_row_start margin_top1">
											<label for="" class="text-muted padding-side"><span class="width6em">第四职业：</span>
											<input type="" name="jyzyfx-name" id=""  /></label>
											<label for="" class="text-muted padding-side">第四职业概率：
											<input class="width4em" type="" name="jyzyfx-kl" id=""  /><span class="padding-side">%</span></label>
										</div>
										<label for="" class="text-muted padding-side flex_row_start"><span class="width6em">具体职业：</span>
										<input class="width100" type="" name="jyzyfx-commot" id=""  /></label>
									</li>
									<li>
										<div class="flex_row_start margin_top1">
											<label for="" class="text-muted padding-side"><span class="width6em">第五职业：</span>
											<input type="" name="jyzyfx-name" id="" /></label>
											<label for="" class="text-muted padding-side">第五职业概率：
											<input class="width4em" type="" name="jyzyfx-kl" id=""  /><span class="padding-side">%</span></label>
										</div>
										<label for="" class="text-muted padding-side flex_row_start"><span class="width6em">具体职业：</span>
										<input class="width100" type="" name="jyzyfx-commot" id=""  /></label>
									</li>
									<li>
										<div class="flex_row_start margin_top1">
											<label for="" class="text-muted padding-side"><span class="width6em">第六职业：</span>
											<input type="" name="jyzyfx-name" id=""  /></label>
											<label for="" class="text-muted padding-side">第六职业概率：
											<input class="width4em" type="" name="jyzyfx-kl" id=""  /><span class="padding-side">%</span></label>
										</div>
										<label for="" class="text-muted padding-side flex_row_start"><span class="width6em">具体职业：</span>
										<input class="width100" type="" name="jyzyfx-commot" id=""  /></label>
									</li>
								</ul>
							</li>
							<li>
								<h4 class="text-primary fontwei">就业行业分布</h4>
								<ul class="list-unstyled cols2 clearfix">
									<li>
										<label for="" class="text-muted padding-side">第一行业：
										<input type="" name="jyhyfb-name" id=""  /></label>
										<label for="" class="text-muted padding-side">第一行业概率：
										<input class="width4em" type="" name="jyhyfb-kl" id=""  /><span class="padding-side">%</span></label>
									</li>
									<li>
										<label for="" class="text-muted padding-side">第二行业：
										<input type="" name="jyhyfb-name" id=""  /></label>
										<label for="" class="text-muted padding-side">第二行业概率：
										<input class="width4em" type="" name="jyhyfb-kl" id="" " /><span class="padding-side">%</span></label>
									</li>
									<li>
										<label for="" class="text-muted padding-side">第三行业：
										<input type="" name="jyhyfb-name" id=""  /></label>
										<label for="" class="text-muted padding-side">第三行业概率：
										<input class="width4em" type="" name="jyhyfb-kl" id=""  /><span class="padding-side">%</span></label>
									</li>
									<li>
										<label for="" class="text-muted padding-side">第四行业：
										<input type="" name="jyhyfb-name" id=""  /></label>
										<label for="" class="text-muted padding-side">第四行业概率：
										<input class="width4em" type="" name="jyhyfb-kl" id=""  /><span class="padding-side">%</span></label>
									</li>
									<li>
										<label for="" class="text-muted padding-side">第五行业：
										<input type="" name="jyhyfb-name" id=""  /></label>
										<label for="" class="text-muted padding-side">第五行业概率：
										<input class="width4em" type="" name="jyhyfb-kl" id=""  /><span class="padding-side">%</span></label>
									</li>
								</ul>
							</li>
							<li>
								<h4 class="text-primary fontwei">就业地区分布</h4>
								<ul class="list-unstyled cols2 clearfix">
									<li>
										<label for="" class="text-muted padding-side">第一地区：
										<input type="" name="jydqfb-name" id=""  /></label>
										<label for="" class="text-muted padding-side">第一地区概率：
										<input class="width4em" type="" name="jydqfb-kl" id=""  /><span class="padding-side">%</span></label>
									</li>
									<li>
										<label for="" class="text-muted padding-side">第二地区：
										<input type="" name="jydqfb-name" id=""  /></label>
										<label for="" class="text-muted padding-side">第二地区概率：
										<input class="width4em" type="" name="jydqfb-kl" id=""  /><span class="padding-side">%</span></label>
									</li>
									<li>
										<label for="" class="text-muted padding-side">第三地区：
										<input type="" name="jydqfb-name" id=""  /></label>
										<label for="" class="text-muted padding-side">第三地区概率：
										<input class="width4em" type="" name="jydqfb-kl" id=""  /><span class="padding-side">%</span></label>
									</li>
									<li>
										<label for="" class="text-muted padding-side">第四地区：
										<input type="" name="jydqfb-name" id=""  /></label>
										<label for="" class="text-muted padding-side">第四地区概率：
										<input class="width4em" type="" name="jydqfb-kl" id=""  /><span class="padding-side">%</span></label>
									</li>
									<li>
										<label for="" class="text-muted padding-side">第五地区：
										<input type="" name="jydqfb-name" id=""  /></label>
										<label for="" class="text-muted padding-side">第五地区概率：
										<input class="width4em" type="" name="jydqfb-kl" id=""  /><span class="padding-side">%</span></label>
									</li>
								</ul>
							</li>
						</ul>
					</div>					
					<div class="subject_assess margin_bot2">
						<div class="padding-side2">
							<h4 class="text-primary fontwei margin_top2">学科评估</h4>
							<ul class="list-unstyled padding-side2">
								<li><label for=""><span class="width10em text-muted">第四轮学科评估A+高校：</span>
								<input class="width100" type="" name="aboveA" id="aboveA"  /></label></li>
								<li><label for=""><span class="width10em text-muted">第四轮学科评估A高校：</span>
								<input class="width100" type="" name="equalA" id="equalA"  /></label></li>
								<li><label for=""><span class="width10em text-muted">第四轮学科评估A-高校：</span>
								<input class="width100" type="" name="belowA" id="belowA"  /></label></li>
								<li><label for=""><span class="width10em text-muted">第四轮学科评估B+高校：</span>
								<input class="width100" type="" name="aboveB" id="aboveB"  /></label></li>
								<li><label for=""><span class="width10em text-muted">开设院校：</span>
								<input class="width100" type="" name="openCollege" id="openCollege"/></label></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</form>	
	</body>
<script type="text/javascript">
tablist('.tab_h','.tab_b');	
function add(){		
	var employmentCareerDirection =arraylist("jyzyfx-name","jyzyfx-kl","jyzyfx-commot");
	var employmentIndustryDistribution =arraylisttwo("jyhyfb-name","jyhyfb-kl");
	var employmentAreaDistribution =arraylisttwo("jydqfb-name","jydqfb-kl");					
	if($("#specialtyName").val()==""){
		layer.msg("专业名称不能为空",{icon:2,time:1000});
	}else if($("#specialtyMajorName").val()==""){
		layer.msg("专业大类不能为空",{icon:2,time:1000});
	}else if($("#specialtyDisciplines").val()==""){
		layer.msg("专业学科分类不能为空",{icon:2,time:1000});						
	}else if($("#specialtyId").val()==""){
		layer.msg("专业代码不能为空",{icon:2,time:1000});						
	}else{					
		var url = "specialtyadd";
		var data=$("#form-specialty-add").serialize()+"&employmentCareerDirection="+JSON.stringify(employmentCareerDirection)+
		"&employmentIndustryDistribution="+JSON.stringify(employmentIndustryDistribution)+"&employmentAreaDistribution="+JSON.stringify(employmentAreaDistribution);
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
					layer.msg(obj.message,{icon:1,time:1000});
				}				
			}
		}); 
	}		 
}	
</script>
</html>
