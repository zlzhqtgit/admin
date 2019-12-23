layui.use('element', function() {
		var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
		//触发事件
		var active = {
			tabChange : function() {
				//切换到指定Tab项
				element.tabChange('demo', '22'); //切换到：用户管理
			}
		};
	});	
	
	function btnhysr(obj, name, menoy,mename) {
		var str = '<div class="layui-inline"><label class="layui-form-label" style="width: 60px;">名称</label>'
				+ '<div class="layui-input-inline" style="width: 120px;">'
				+ '<input type="text" name="'+name+'"  autocomplete="off" class="layui-input">'
				+ '</div>'
				+ '<div class="layui-form-mid">-</div><label class="layui-form-label" style="width: 60px;">'+mename+'</label>'
				+ '<div class="layui-input-inline" style="width: 80px;">'
				+ '<input type="text" name="'+menoy+'"  autocomplete="off" class="layui-input">'
				+ '</div>' + '</div>';
		$(obj).before(str);
	}
	function save() {			
		var hysrarray =arraylist("hysr-name","hysr-menoy");
		var dqsrarray =arraylist("dqsr-name","dqsr-menoy");
		var salaryTrend =arraylist("xzqs-name","xzqs-menoy");		
		var salaryDistribution =arraylist("xzfb-name","xzfb-menoy");
		var employmentSituationEducation =arraylist("jyqsxl-name","jyqsxl-menoy");
		var employmentSituationExperience =arraylist("jyqsjy-name","jyqsjy-menoy");
		var prospect=new Array();		
		if(hysrarray == "暂无相关数据" || dqsrarray == "暂无相关数据"){
			layer.msg("行业收入或地区收入不能为空",{icon:2,time:1000});
			return;			
		}else{
			prospect.push(hysrarray);					
			prospect.push(dqsrarray);
		}
		if($("#vocationId").val()==""){
			layer.msg("职业代码不能为空",{icon:2,time:1000});
		}else if($("#vocationName").val()==""){
			layer.msg("职业名称不能为空",{icon:2,time:1000});
		}else{
			var url = "vocationedit";
			var data=$("#form-vocation").serialize()+"&prospect="+JSON.stringify(prospect)+"&salaryTrend="+JSON.stringify(salaryTrend)+"&salaryDistribution="+JSON.stringify(salaryDistribution)+"&employmentSituationEducation="+JSON.stringify(employmentSituationEducation)+"&employmentSituationExperience="+JSON.stringify(employmentSituationExperience);
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
	function add() {
		var hysrarray =arraylist("hysr-name","hysr-menoy");
		var dqsrarray =arraylist("dqsr-name","dqsr-menoy");
		var salaryTrend =arraylist("xzqs-name","xzqs-menoy");		
		var salaryDistribution =arraylist("xzfb-name","xzfb-menoy");
		var employmentSituationEducation =arraylist("jyqsxl-name","jyqsxl-menoy");
		var employmentSituationExperience =arraylist("jyqsjy-name","jyqsjy-menoy");
		var prospect=new Array();		
		if($("#vocationId").val()==""){
			layer.msg("职业代码不能为空",{icon:2,time:1000});
		}else if($("#vocationName").val()==""){
			layer.msg("职业名称不能为空",{icon:2,time:1000});
		}else if(hysrarray == "暂无相关数据" || dqsrarray == "暂无相关数据"){
			layer.msg("行业收入或地区收入不能为空",{icon:2,time:1000});						
		}else{
			prospect.push(hysrarray);					
			prospect.push(dqsrarray);			
			var url = "vocationadd";
			var data=$("#form-vocation").serialize()+"&prospect="+JSON.stringify(prospect)+"&salaryTrend="+JSON.stringify(salaryTrend)+"&salaryDistribution="+JSON.stringify(salaryDistribution)+"&employmentSituationEducation="+JSON.stringify(employmentSituationEducation)+"&employmentSituationExperience="+JSON.stringify(employmentSituationExperience);
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