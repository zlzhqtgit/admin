function save() {		
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
		var url = "specialtyedit";
		var data=$("#form-specialty").serialize()+"&employmentCareerDirection="+JSON.stringify(employmentCareerDirection)+
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
	
function tablist(th,tb) {
	$(th).find("li").click(function() {
		$(this).parent().find("li").removeClass("now");
		$(this).addClass("now");
		var index=$(this).index();
		$(this).parent().parent().find(tb).children().removeClass("now");
		$(this).parent().parent().find(tb).children().eq(index).addClass("now");
	})
}
	function arraylist(name,kl,commot){
		var jyarray = new Array();
		var cont=0;
		var jyname = document.querySelectorAll("input[name='"+name+"']");
		var jykl = document.querySelectorAll("input[name='"+kl+"']");
		var jycommot = document.querySelectorAll("input[name='"+commot+"']");
		for(var i = 0; i < jyname.length; i++){ 
			if(jyname[i].value!="" && jykl[i].value!="" && jycommot[i].value!=""){
				jyarray[cont]=new Array();
				jyarray[cont][0]=jyname[i].value; 
				jyarray[cont][1]=jykl[i].value;
				jyarray[cont][2]=jycommot[i].value;
				cont++;
			}    		    	 	
    	 }
		if(jyarray.length==0){
			return "暂无相关数据";
		}else{
			return jyarray;
		}		
	}
	function arraylisttwo(name,kl){
		var hyarray = new Array();
		var cont=0;
		var hyname = document.querySelectorAll("input[name='"+name+"']");
		var hykl = document.querySelectorAll("input[name='"+kl+"']");		
		for(var i = 0; i < hyname.length; i++){ 
			if(hyname[i].value!="" && hykl[i].value!=""){
				hyarray[cont]=new Array();
				hyarray[cont][0]=hyname[i].value; 
				hyarray[cont][1]=hykl[i].value;				
				cont++;
			}    		    	 	
    	 }
		if(hyarray.length==0){
			return "暂无相关数据";
		}else{
			return hyarray;
		}		
	}
	