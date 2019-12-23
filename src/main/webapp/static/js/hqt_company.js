function addcompany(){    
	if($("#companyNumber").val() == ""){
		layer.msg("请输入单位编号",{icon:2,time:1000});
	}else if($("#companyName").val() == ""){
		layer.msg("请输入单位名称",{icon:2,time:1000});
	}else if($("#companyAdress").val() == ""){
		layer.msg("请输入单位地址",{icon:2,time:1000});
	}else{		
		var url = "companyadd";
		var data = $("#form-company-add").serialize();		
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
					$("#companyNumber").val("");					
					$("#companyName").val("");	
					$("#companyAdress").val("");				
				}				
			}
		}); 
	}			
}
function editcompany(){    
	if($("#companyNumber").val() == ""){
		layer.msg("请输入单位编号",{icon:2,time:1000});
	}else if($("#companyName").val() == ""){
		layer.msg("请输入单位名称",{icon:2,time:1000});
	}else if($("#companyAdress").val() == ""){
		layer.msg("请输入单位地址",{icon:2,time:1000});
	}else{		
		var url = "companyedit";
		var data = $("#form-company-edit").serialize();		
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
					layer.msg(obj.message,{icon:1,time:1000},function(){
						$("#companyNumber").val("");					
						$("#companyName").val("");	
						$("#companyAdress").val("");
						layer_close();						
					});								
				}				
			}
		}); 
	}			
}