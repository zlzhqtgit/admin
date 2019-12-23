function btnhysr(obj, code, name,cname,mename) {
	var str = '<div class="layui-inline"><label class="layui-form-label" style="width: 100px;">'+cname+'</label>'
			+ '<div class="layui-input-inline" style="width: 80px;">'
			+ '<input type="text" name="'+code+'"  autocomplete="off" class="layui-input">'
			+ '</div>'
			+ '<div class="layui-form-mid">-</div><label class="layui-form-label" style="width: 100px;">'+mename+'</label>'
			+ '<div class="layui-input-inline" style="width: 120px;">'
			+ '<input type="text" name="'+name+'"  autocomplete="off" class="layui-input">'
			+ '</div>' + '</div>';
	$(obj).before(str);
}
function savepet() {			
	var specialtyarray =arraylist("specialty-code","specialty-name");
	var vocationarray =arraylist("vocation-code","vocation-name");		
	if($("#personalityCode").val()==""){
		layer.msg("测评的编码不能为空",{icon:2,time:1000});
	}else if($("#personalityName").val()==""){
		layer.msg("测评的名称不能为空",{icon:2,time:1000});
	}else if(specialtyarray.length==0){
		layer.msg("相关专业不能为空",{icon:2,time:1000});
	}else if(vocationarray.length==0){
		layer.msg("相关职业不能为空",{icon:2,time:1000});
	}else{
		var url = "personalityedit";
		var data=$("#form-personality").serialize()+"&personalitySpecialty="+JSON.stringify(specialtyarray)+"&personalityVocation="+JSON.stringify(vocationarray);
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
					layer.msg(obj.message,{icon:1,time:1000},function(){layer_close();});
				}				
			}
		}); 
	}		
}	
function addpet() {			
	var specialtyarray =arraylist("specialty-code","specialty-name");
	var vocationarray =arraylist("vocation-code","vocation-name");		
	if($("#personalityCode").val()==""){
		layer.msg("测评的编码不能为空",{icon:2,time:1000});
	}else if($("#personalityName").val()==""){
		layer.msg("测评的名称不能为空",{icon:2,time:1000});
	}else if(specialtyarray.length==0){
		layer.msg("相关专业不能为空",{icon:2,time:1000});
	}else if(vocationarray.length==0){
		layer.msg("相关职业不能为空",{icon:2,time:1000});
	}else{
		var url = "personalityadd";
		var data=$("#form-personality").serialize()+"&personalitySpecialty="+JSON.stringify(specialtyarray)+"&personalityVocation="+JSON.stringify(vocationarray);
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
					layer.msg(obj.message,{icon:1,time:1000},function(){layer_close();});
				}				
			}
		}); 
	}		
}
function arraylist(name,value){
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