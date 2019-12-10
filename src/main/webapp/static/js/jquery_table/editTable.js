//自定义选科对比表格
//xgkXk(e)选科组合点击事件
//hideTable()控制table的显示和隐藏
//delTd(e)点击a标签执行方法
//del(id)删除指定的列

function xgkxk(e){	 
	 var rs = document.querySelectorAll("input[type='checkbox']:checked");
	 if(rs.length > 4){ 
	    alert("只能对比4个组合"); 
	    e.checked=false;
	 }else{
		 if(e.checked==true){
		    	$("thead tr").append("<th>"+e.value+"<a name='"+e.id+"' onclick='delTd(this)' class='delBtn' href='javascript:void(0);'>删除</a></th>");
		    	$("#major-nub").append("<td>"+e.value+"</td>");
		    	$("#major-max").append("<td>"+e.value+"</td>");
		    	$("#major-min").append("<td>"+e.value+"</td>");
		    	$("#major-no").append("<td>"+e.value+"</td>"); 
		    }else{    		
		    	var rs = document.getElementsByName(e.id);
		    	var id=$(rs).parent().prevAll().length;
		    	alert(id);
		    	del(id);
		    	e.checked=false;
		    } 
		    	hidetable();   	  
	 }    
}; 
 //控制table在checkbox选中少于2个时候隐藏
function hidetable(){
    var rs = document.querySelectorAll("input[type='checkbox']:checked");
    if(rs.length > 1){ 
    	$('#tableid').css('display','block');      		
    }else{
    	$('#tableid').css('display','none');
    }  	     
}
 //a标签删除
 function delTd(e){		
		var id=$(e).parent().prevAll().length;
		var boxid=$(e).attr("name");		
		del(id);	
		var rs = document.getElementById(boxid); 	
		rs.checked = false;	
		hidetable();
 }
 //执行删除操作
function del(id){
	var table = document.getElementById("tableid");//获得要操作的table对象
	table.rows[0].deleteCell(id);//先获取到要操作的第几行（3代表第四行）ID代表列，
	table.rows[1].deleteCell(id);
	table.rows[2].deleteCell(id);
	table.rows[3].deleteCell(id);
	table.rows[4].deleteCell(id);
}


