 if(window !=top){
        top.location.href=location.href;
  }
function login(){	
	if ($("#username").val() == "") {
		alert("用户名不能为空");				
	}else if($("#password").val() == ""){
		alert("请输入密码");
	}else{
		var url = "hqt_login";
		var username=$("#username").val();
		var password=$("#password").val();		
		var data = "username="+username+"&password="+password;		
		$.ajax({
			"url" : url,
			"data" : data,
			"type" : "POST",
			"dataType" : "json",
			"success" : function(obj) {
				if (obj.state == 0) {
					alert(obj.message);
					return;
				}else{
					alert(obj.message);
					location.href = "index";
				}
			}
		}); 
	}			
}
function loginreset(){
	$("#username").val('');
	$("#password").val('');
	$("#username").focus();
}
