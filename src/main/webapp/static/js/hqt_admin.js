function editUser(){
	var regBox = {
	        regEmail : /^([A-Z0-9a-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/,//邮箱
	        regName : /^[A-Z0-9a-z_-]{6,16}$/,//用户名
	        regMobile : /^0?1[3|4|5|7|8][0-9]\d{8}$/,//手机
	       	regTel : /^0[\d]{2,3}-[\d]{7,8}$/
			}			
    var userflag = regBox.regName.test($("#username").val());
    var emailflag = regBox.regEmail.test($("#email").val());
    var phoneflag = regBox.regMobile.test($("#phone").val());
    var passflag = regBox.regName.test($("#password").val());  
    if ($("#username").val() == "") {
		layer.msg("用户名不能为空",{icon:2,time:1000});			
	}else if(!userflag){
		layer.msg("用户名是6-16位字母、数字下划线组成",{icon:2,time:1000});	
	}else if($("#phone").val() == ""){
		layer.msg("手机号不能为空",{icon:2,time:1000});
	}else if(!phoneflag){
		layer.msg("手机号格式不正确",{icon:2,time:1000});
	}else if($("#email").val() == ""){			
		layer.msg("邮箱不能为空",{icon:2,time:1000});
	}else if(!emailflag){
		layer.msg("邮箱格式如:XXXXXX@163.COM",{icon:2,time:1000});
	}else if($("#rid").val() == ""){
		layer.msg("请选择角色",{icon:2,time:1000});
	}else if($("#comment").val() == ""){
		layer.msg("请输入备注",{icon:2,time:1000});
	}else{			
		var url = "adminedit";
		var data = $("#form-admin-edit").serialize();
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

function roleclick(){
	console.log($("#companyId").val());
	var companyId=$("#companyId").val();
	if(companyId==0){
		layer.msg("请选择所属单位",{icon:2,time:1000});
	}else{
		var url = "roleList";
		var data ="companyId="+companyId;
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
					var roledata=obj.data;
					var str='<option value="0">请选择</option>';
					for(var i=0;i<roledata.length;i++){
						str+='<option value="'+roledata[i].roleId+'">'+roledata[i].roleName+'</option>';
					}
					$("#rid").html(str);
				}				
			}
		}); 
	}
}
function sdfsd(){
	layer.open({
		type: 1,
		area: ['200px', '200px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: "567",
		content: $("#ddd"),
		scrollbar: false
	});
}
function addUser(){
	var regBox = {
	        regEmail : /^([A-Z0-9a-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/,//邮箱
	        regName : /^[A-Z0-9a-z_-]{6,16}$/,//用户名
	        regMobile : /^0?1[3|4|5|7|8][0-9]\d{8}$/,//手机
	       	regTel : /^0[\d]{2,3}-[\d]{7,8}$/
			}			
    var userflag = regBox.regName.test($("#username").val());
    var emailflag = regBox.regEmail.test($("#email").val());
    var phoneflag = regBox.regMobile.test($("#phone").val());
    var passflag = regBox.regName.test($("#password").val());  
    
	if ($("#username").val() == "") {
		layer.msg("用户名不能为空",{icon:2,time:1000});			
	}else if(!userflag){
		layer.msg("用户名是6-16位字母、数字下划线组成",{icon:2,time:1000});
	}else if($("#password").val() == ""){
		layer.msg("密码不能为空",{icon:2,time:1000});
	}else if(!passflag){
		layer.msg("密码格式不正确",{icon:2,time:1000});
	}else if($("#password2").val() != $("#password").val()){
		layer.msg("两次密码不能为空",{icon:2,time:1000});
	}else if($("#phone").val() == ""){
		layer.msg("手机号不能为空",{icon:2,time:1000});
	}else if(!phoneflag){
		layer.msg("手机号格式不正确",{icon:2,time:1000});
	}else if($("#email").val() == ""){			
		layer.msg("邮箱不能为空",{icon:2,time:1000});
	}else if(!emailflag){
		layer.msg("邮箱格式如:XXXXXX@163.COM",{icon:2,time:1000});
	}else if($("#rid").val() == ""){
		layer.msg("请选择角色",{icon:2,time:1000});
	}else if($("#comment").val() == ""){
		layer.msg("请输入备注",{icon:2,time:1000});
	}else{		
		var url = "adminadd";
		var data = $("#form-admin-add").serialize();
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
					$("#form-admin-add input").each(function(){
						$(this).val('');
					});
					$("#form-admin-add textarea").each(function(){
						$(this).val('');
					});
				}				
			}
		}); 
	}			
}
function editRole(){    
	if ($("#roleName").val() == "") {
		layer.msg("角色名称不能为空",{icon:2,time:1000});			
	}else if($("#comment").val() == ""){
		layer.msg("请输入备注",{icon:2,time:1000});
	}else{		
		var url = "hqt_roleedit.do";
		var data = $("#form-admin-role-add").serialize()+"&roleId="+$("#roleId").val()+"&oldroleName="+$("#oldroleName").val();		
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
function addRole(){    
	if ($("#roleName").val() == "") {
		layer.msg("角色名称不能为空",{icon:2,time:1000});			
	}else if($("#comment").val() == ""){
		layer.msg("请输入备注",{icon:2,time:1000});
	}else{		
		var url = "hqt_roleadd.do";
		var data = $("#form-admin-role-add").serialize();
		alert(data);
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
					$("#roleName").val("");					
					$("#comment").val("");					
				}				
			}
		}); 
	}			
}