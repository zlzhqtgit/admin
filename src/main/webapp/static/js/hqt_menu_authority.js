function getCheckstrt(){
	var authority=""
    var id="${id}"; 
    var type="${type}"; 
    var len=$('input[type="checkbox"]:checked').length;
	$('input[type="checkbox"]:checked').each(function(index, dom){ 	
		if($(this).attr("name")!=-1 && index<len-1){
			authority+=$(this).val()+";";  
		}else{
			authority+=$(this).val();
		}	    
	});	
	if(id !="" || type!=""){
	     $.ajax({
			"url" : "updateAuthority",
			"data" : "id="+id+"&type="+type+"&authority="+authority,
			"type" : "POST",
			"dataType":"json",
			"success" : function(obj) {
				if (obj.state == 0) {
					layer.msg(obj.message,{icon:2,time:1000});
					return;
				}else{
					layer.msg(obj.message,{icon:1,time:1000},function(){location.replace(location.href);});
				}	
			}
		});    
	 } 
}
 
    $(function(){     
        // initialize treeTable
         $("#example-basic").treetable({  
                 expandable : true,
                 initialState:"expanded",
                 //expandable : true
                 clickableNodeNames:false,//点击节点名称也打开子节点.
                 indent : 30//每个分支缩进的像素数。
             });
 
 
            // Highlight a row when selected
            $("#example-basic tbody").on("mousedown", "tr", function() {
                $(".selected").not(this).removeClass("selected");
                $(this).toggleClass("selected");
            });
            
             $("#example-basic input[type=checkbox]").click(function(e){
                checkboxClickFn(this);
             });
 
    });
    
    function checkboxClickFn(_this, autoFlag, parentSelectedFlag){
         var checked = $(_this).attr("checked");
         var menuId = $(_this).parent().parent().attr("data-tt-id");
         var parentMenuId = $(_this).parent().parent().attr("data-tt-parent-id");
         var childCount = $("#example-basic").find("[data-tt-parent-id='"+menuId+"']").find("input[type=checkbox]").length;
         if(autoFlag){//自动触发
             if(parentSelectedFlag){//如果是需要选中其父节点
                 //将其直接的父节点置为选中状态
                 $("#example-basic").find("[data-tt-id='"+parentMenuId+"']").find("input[type=checkbox]").each(function(){
                     $(this).attr("checked",true).prop("checked",true);
                     if(parentMenuId == "0"){
                         return;//已经到根节点，直接返回
                     }
                     //自动将该节点的父节点的父节点选中
                     checkboxClickFn(this,true,true);
                 });
                 return;
             }
             if(checked){//如果是已经选中，则其子菜单全部选中
                 if(childCount == 0){
                     return;
                 }
                 $("#example-basic").find("[data-tt-parent-id='"+menuId+"']").find("input[type=checkbox]").each(function(){
                     $(this).attr("checked",true).prop("checked",true);
                     checkboxClickFn(this,true);
                 });
             }else{//如果是取消选中，则其子菜单全部取消选中
                 if(childCount == 0){
                     return;
                 }
                 $("#example-basic").find("[data-tt-parent-id='"+menuId+"']").find("input[type=checkbox]").each(function(){
                     $(this).prop("checked",false).removeAttr("checked");
                     checkboxClickFn(this,true);
                 });
             }
             return;
         }
         //手动触发
         if(!checked){
             $(_this).attr("checked",true);
             $(_this).prop("checked",true);
             //将其直接的父节点置为选中状态
             if(menuId != "0"){//选中的不是根节点
                 $("#example-basic").find("[data-tt-id='"+parentMenuId+"']").find("input[type=checkbox]").each(function(){
                     $(this).attr("checked",true).prop("checked",true);
                     //自动将该节点的父节点的父节点选中
                     checkboxClickFn(this,true,true);
                 });
             }
             if(childCount == 0){
                 return;
             }
             $("#example-basic").find("[data-tt-parent-id='"+menuId+"']").find("input[type=checkbox]").each(function(){
                 $(this).attr("checked",true).prop("checked",true);
                 checkboxClickFn(this,true);
             });
         }else{
             $(_this).prop("checked",false).removeAttr("checked");
             if(childCount == 0){
                 return;
             }
             $("#example-basic").find("[data-tt-parent-id='"+menuId+"']").find("input[type=checkbox]").each(function(){
                 $(this).prop("checked",false).removeAttr("checked");
                 checkboxClickFn(this,true);
             });
         }
 }
 