function delimg(e) {
	var path = $("#" + e.name).attr('src');
	console.log(e.name);
	var url = "universitydelimg";
	var data = "id=" + $("#id").val() + "&path=" + path;
	$
			.ajax({
				"url" : url,
				"data" : data,
				"type" : "POST",
				"dataType" : "json",
				"success" : function(obj) {
					if (obj.state == 0) {
						layer.msg(obj.message, {
							icon : 2,
							time : 1000
						});
						return;
					} else {
						layer.msg("操作成功", {
							icon : 1,
							time : 1000
						});
						var d = obj.message.split(";");
						var str = ""
						for (var i = 0; i < d.length; i++) {
							str += '<li><div class="main">'
									+ '<div class="showdiv">'
									+ '<img name="show-img'
									+ i
									+ '" onclick="delimg(this)" class="center" src="${pageContext.request.contextPath}/static/images/updataimg/delete.svg">'
									+ '</div></div>'
									+ '<div class="sch_pic">'
									+ '<img id="show-img'
									+ i
									+ '" class="showimg" src="${pageContext.request.contextPath}'
									+ d[i]
									+ '">'
									+ '<input type="file" name="yysh"  onchange="change(this)" class="file" />'
									+ '</div></li>';
						}
						$("#showui").html(str);
					}
				}
			});
}
function change(e) {
	var fileSize = e.files[0].size;
	var name = e.value;
	if (getObject(fileSize, name)) {
		var formData = new FormData();
		formData.append('unimg', e.files[0]);
		formData.append('oldpath', $(e).prev().attr('src'));
		formData.append('id', $("#id").val());
		formData.append('name', e.name);
		$
				.ajax({
					url : 'universityimg',
					type : 'POST',
					cache : false,
					data : formData,
					processData : false,
					contentType : false,
					success : function(obj) {
						if (obj.state == 0) {
							layer.msg(obj.message, {
								icon : 2,
								time : 2000
							});
							return false;
						} else {
							layer.msg("操作成功", {
								icon : 1,
								time : 1000
							});
							console.log(obj.message);
							if (e.name != "yysh") {
								$("#img_cardPic").attr(
										'src',
										'${pageContext.request.contextPath}'
												+ obj.message);
							} else {
								var d = obj.message.split(";");
								var str = ""
								for (var i = 0; i < d.length; i++) {
									str += '<li><div class="main">'
											+ '<div class="showdiv">'
											+ '<img name="show-img'
											+ i
											+ '" onclick="delimg(this)" class="center" src="${pageContext.request.contextPath}/static/images/updataimg/delete.svg">'
											+ '</div></div>'
											+ '<div class="sch_pic">'
											+ '<img id="show-img'
											+ i
											+ '" class="showimg" src="${pageContext.request.contextPath}'
											+ d[i]
											+ '">'
											+ '<input type="file" name="yysh"  onchange="change(this)" class="file" />'
											+ '</div></li>';
								}
								$("#showui").html(str);
							}
						}
					}
				});
	}
}
function getObjectURL(file) {
	var url = null;
	if (window.createObjcectURL != undefined) {
		url = window.createOjcectURL(file);
	} else if (window.URL != undefined) {
		url = window.URL.createObjectURL(file);
	} else if (window.webkitURL != undefined) {
		url = window.webkitURL.createObjectURL(file);
	}
	return url;
}
function getObject(fileSize, name) {
	var size = fileSize / 1024;
	var fileName = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
	if (size > 2000) {
		layer.msg("文件不能大于2M", {
			icon : 2,
			time : 2000
		});
		this.value = "";
		return false;
	} else if (fileName != "jpg" && fileName != "JPG" && fileName != "png"
			&& fileName != "PNG") {
		layer.msg("请选择图片格式上传,如：.jpg, .JPG, .png, .PNG", {
			icon : 2,
			time : 4000
		});
		this.value = "";
		return false;
	} else {
		return true;
	}
}

function updateun() {	 
	 var admissionLot =arraylistone("lqpc-name");  
	 var researchCenters=arraylistthirs("zdsys-name");
	 var coreSubject=arraylistthirs("zdxk-name");
	 var coreSpecialty=arraylisttwo('zdzy-code','hysr-name');	
	 var teachingResearch=arraylisttwo('jyjx-name','jyjx-nub');	
	 var universitiesAttributes=arraylistone("yxsx-name");
	 var data=$("#from-university").serialize()+"&admissionLot="+JSON.stringify(admissionLot)+"&coreLaboratoriesAndResearchCenters="+JSON.stringify(researchCenters)+
	 "&coreSubject="+JSON.stringify(coreSubject)+"&coreSpecialty="+JSON.stringify(coreSpecialty)+"&teachingResearch="+JSON.stringify(teachingResearch)+"&universitiesAttributes="+JSON.stringify(universitiesAttributes);	 
	 $.ajax({
			"url" : 'universityedit',
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
function arraylistthirs(name){
	var rh = new Array();	
	var cont=0;
	 var rt=document.querySelectorAll("input[name='"+name+"']");
	 for(var i=0;i<rt.length;i++){		 
		 if(rt[i].value != "" && arraylistone(rt[i].id).length!=0){
			 rh[cont]=new Array();
			 var rt1 = new Array();
			 rt1[0]=rt[i].value;
			 rh[cont][0]=rt1;
			 rh[cont][1]=arraylistone(rt[i].id); 
			 cont++;
		 }		 
	 }
	if(rh.length==0){
		return "暂无相关数据";
	}else{
		return rh;
	}		
}
function arraylistone(name){
	var hysrarray = new Array();
	var cont=0;
	var hysrname = document.querySelectorAll("input[name='"+name+"']");	
	for(var i = 0; i < hysrname.length; i++){ 
		if(hysrname[i].value!=""){
			hysrarray[cont]=hysrname[i].value; 
			cont++;
		}    		    	 	
	 }
	return hysrarray;		
}
function arraylisttwo(name,value){
	var hysrarray = new Array();
	var hysrname = document.querySelectorAll("input[name='"+name+"']");
	var hysrmenoy = document.querySelectorAll("input[name='"+value+"']");
	for(var i = 0; i < hysrname.length; i++){ 
		if(hysrname[i].value!="" && hysrmenoy[i].value!=""){
			hysrarray[i]=new Array();
   	 	hysrarray[i][0]=hysrname[i].value; 
   	 	hysrarray[i][1]=hysrmenoy[i].value;
		}    		    	 	
	 }
	if(hysrarray.length==0){
		return "暂无相关数据";
	}else{
		return hysrarray;
	}		
}
var cont=10001;
function btnzdxk(id,name) {	
	var str = '<input id="'+name+cont+'" name="'+name+'" style="margin-left: 45px;"><br>'+	
	 			'<div class="layui-form-item" style=" display: inline-block;margin-left: 45px">'+																		
				'<button type="button" class="layui-btn layui-btn-sm"onclick='+"btnhysrtwo(this,'"+name+cont+"','名称')" +'><i class="layui-icon"></i></button>'+				
				'</div><br>';
	$("#"+id).append(str);
	cont++;
}
function btnhysrone(obj, code) {
	var str = '<input type="text" name="'+code+'"  autocomplete="off" class="width6em text-center">';
	$(obj).before(str);
}
function btnhysrtwo(obj, code, name) {
	var str = '<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">'+name+'</label>'
			+ '<div class="layui-input-inline" style="width: 130px;">'
			+ '<input type="text" name="'+code+'"  autocomplete="off" class="layui-input">'
			+ '</div>'
			+ '</div>';
	$(obj).before(str);
}
function btnhysr(obj, code, name,cname,mename) {
	var str = '<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">'+cname+'</label>'
			+ '<div class="layui-input-inline" style="width: 130px;">'
			+ '<input type="text" name="'+code+'"  autocomplete="off" class="layui-input">'
			+ '</div>'
			+ '<div class="layui-form-mid">-</div><label class="layui-form-label" style="width: 60px;">'+mename+'</label>'
			+ '<div class="layui-input-inline" style="width: 130px;">'
			+ '<input type="text" name="'+name+'"  autocomplete="off" class="layui-input">'
			+ '</div>' + '</div>';
	$(obj).before(str);
}
function tablist(th,tb) {
	$(th).find("li").click(function() {
		$(this).parent().find("li").removeClass("now");
		$(this).addClass("now");
		var index=$(this).index();
		$(this).parent().parent().find(tb).children().removeClass("now");
		$(this).parent().parent().find(tb).children().eq(index).addClass("now");
	})
}

$(".file-list").on('click','.file-del',function(){
    let $parent = $(this).parent().parent();
    let index = $parent.index();
    fileList.splice(index,1);
    $parent.remove();
    let fd = new FileReader();
});
