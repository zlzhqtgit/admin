<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>tree-table</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/main_menus.css">
</head>
<body>
<div class="layui-container">
    <br><br>   
    <div class="layui-btn-group">    	
    	<button class="layui-btn layui-btn-primary  layui-bg-green" onclick="addmain();">新增一行</button>       
        <button class="layui-btn layui-btn-primary layui-bg-green"  onclick="openAll();">展开或折叠全部</button>              
        <a class="layui-btn layui-btn-primary  layui-bg-green"  href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>刷新</a>                  
        <br>
    </div>

    <table id="treeTable" class="layui-table"  olay-filter="treeTable">
    </table>
    
<form action="" method="" id="layer_add" style="display: none;" class="smart-green layui-layer-wrap">
	<h1>权限信息添加
		<span>请输入权限信息.</span>
	</h1>
	<label>
		<span>父菜单名称:</span>
		<input id="parentname" type="text" name="name" class="error" >
		<div class="error-msg"></div>
	</label>
	<label>
		<span>菜单名称：</span>
		<input id="menuName" type="text" value="" name="menuName" >
		<div class="error-msg"></div>
	</label>
	<label>
		<span>权限标识：</span>
		<input id="authority" type="text" value="" name="authority" >
		<div class="error-msg"></div>
	</label>
	<label>
		<span>菜单URL：</span>
		<input id="menuUrl" type="text" value="" name="menuUrl" >
		<div class="error-msg"></div>
	</label>
	<label>
		<span>菜单类型：</span>
		<select id="ismenus" >
			<option value="0">请选择......</option>
			<option value="1">目录</option>
			<option value="2">菜单</option>
			<option value="3">按钮</option>
		</select>
	</label>	
</form>
<form action="" method="" id="layer_edit" style="display: none;" class="smart-green layui-layer-wrap">
	<h1>权限信息编辑
		<span>请输入权限信息.</span>
	</h1>	
	<label>
		<span>菜单名称：</span>
		<input id="ditmenuName" type="text" value="" name="menuName" >
		<div class="error-msg"></div>
	</label>
	<label>
		<span>权限标识：</span>
		<input id="ditauthority" type="text" value="" name="authority" >
		<div class="error-msg"></div>
	</label>
	<label>
		<span>菜单URL：</span>
		<input id="ditmenuUrl" type="text" value="" name="menuUrl" >
		<div class="error-msg"></div>
	</label>
	<label>
		<span>菜单类型：</span>
		<input id="ditismenus" type="text" value="" name="address" >
		<div class="error-msg"></div>
	</label>	
</form>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    var editObj=null,ptable=null,treeGrid=null,tableId='treeTable',layer=null;
    layui.config({
        base: 'static/layui/extend/'
    }).extend({
        treeGrid:'treeGrid'
    }).use(['jquery','treeGrid','layer'], function(){
        var $=layui.jquery;
        treeGrid = layui.treeGrid;//很重要
        layer=layui.layer;
        ptable=treeGrid.render({
            id:tableId
            ,elem: '#'+tableId
            ,url:'getMenu'
            ,cellMinWidth: 100
            ,idField:'menuId'//必須字段
            ,treeId:'menuId'//树形id字段名称
            ,treeUpId:'parentId'//树形父id字段名称
            ,treeShowName:'menuName'//以树形式显示的字段
            ,heightRemove:[".dHead",10]//不计算的高度,表格设定的是固定高度，此项不生效
            ,height:'100%'
            ,isFilter:false
            ,iconOpen:true//是否显示图标【默认显示】
            ,isOpenDefault:true//节点默认是展开还是折叠【默认展开】
            ,loading:true
            ,method:'post'
            ,isPage:false
            ,cols: [[
            {type: 'numbers'},
            {field: 'menuName', minWidth: 200, title: '权限名称'},
            {field: 'authority', title: '权限标识'},
            {field: 'menuUrl', title: '菜单url'},           
            {
                field: 'isMenu', width: 80, align: 'center',templet: function (d) {
                    if (d.isMenu == 3) {
                        return '<span class="layui-badge layui-bg-gray">按钮</span>';
                    }
                    if (d.isMenu ==1) {
                        return '<span class="layui-badge layui-bg-blue">目录</span>';
                    } else if(d.isMenu ==2){
                        return '<span class="layui-badge-rim">菜单</span>';
                    }else{
                    	return "";
                    }
                }, title: '类型'
            },
            {width:300,title: '操作', align:'center'/*toolbar: '#barDemo'*/
                ,templet: function(d){                	
                	var name=d.menuName;
                	var menuId=d.menuId;
                	var menus=d.isMenu;
                	var authority=d.authority;
                	var menuUrl=d.menuUrl;
                	var parentId=d.parentId;
                	var strdel="del('"+name+"',"+menuId+","+menus+")";
                	var stradd="add('"+name+"',"+menuId+","+menus+")";
                	var stredit="edit('"+name+"',"+menuId+","+menus+",'"+authority+"','"+menuUrl+"',"+parentId+")";
                	var editBtn='<a class="layui-btn layui-btn-primary layui-btn-xs layui-bg-green" href="javascript:;"  onclick="'+stredit+'" >编辑</a>';
                    var delBtn='<a class="layui-btn layui-btn-primary layui-btn-xs layui-bg-green" href="javascript:;"  onclick="'+strdel+'" >删除</a>';
                    var addBtn='<a class="layui-btn layui-btn-primary layui-btn-xs layui-bg-green" href="javascript:;"  onclick="'+stradd+'" >添加</a>';
                	if(menus <= 2){
                		return addBtn+editBtn+delBtn;
                	}                
                    return editBtn+delBtn;
                }
            }
        ]]
            ,parseData:function (res) {//数据加载后回调
                return res;
            }
            ,onClickRow:function (index, o) {
                console.log(index,o,"单击！");
                //msg("单击！,按F12，在控制台查看详细参数！");
            }
            ,onDblClickRow:function (index, o) {
                console.log(index,o,"双击");
                msg("双击！,按F12，在控制台查看详细参数！");
            }
            ,onCheck:function (obj,checked,isAll) {//复选事件
                console.log(obj,checked,isAll,"复选");
                msg("复选,按F12，在控制台查看详细参数！");
            }
            ,onRadio:function (obj) {//单选事件
                console.log(obj,"单选");
                msg("单选,按F12，在控制台查看详细参数！");
            } 
        });        
    });
    function addmain() {  
    	var jsonObj = {};    	
    	layer.prompt({title: '请输入主菜单的名称'}, function(pass, index){
    		var time=new Date();
    		jsonObj = { "menuId": null,"menuName": pass,"menuUrl": null,"menuIcon": null,"authority": null,"isMenu":null,"parentId": -1};
    		var adminMenu = JSON.stringify(jsonObj);    		    				
    		$.ajax({
    			"url" : "addMenu",
    			"data" : adminMenu,
    			"type" : "POST",
    			contentType:"application/json"
    		});     	
    		layer.close(index);
    	}); 
    	location.replace(location.href);
    }
    function del(name,menuId,menus){    	
    	if(menus==1){
    		menus="目录";
    	}else if(menus==2){
    		menus="菜单";
    	}else{
    		menus="按钮";
    	}
        layer.confirm("你确定删除<span class='layui-badge layui-bg-blue'>"+menus+"->"+name+"</span>的所有数据吗？如果存在下级节点则一并删除，此操作不能撤销！", {icon: 3, title:'提示'}, function (index) {
        	console.log(menuId);
        	$.ajax({
				"url" : "deleteMenu",
				"data" : "menuId="+menuId,
				"type" : "POST",
				"dataType":"json",
				"success" : function(obj) {
					if (obj.state == 0) {
						layer.msg(obj.message,{icon:2,time:1000});
						return;
					}else{
						layer.msg(obj.message,{icon:1,time:1000},function(){location.replace(location.href);layer.close(index);});
					}	
				}
			});     
        }); 
    }
    function edit(name,menuId,menus,authority,menuUrl,parentId) {
    	var ismenus;    	
    	if(menus==1){
    		ismenus="目录";
    	}else if(menus==2){
    		ismenus="菜单";
    	}else{
    		ismenus="按钮";
    	}    		
    	$("#ditmenuName").val(name);
    	$("#ditauthority").val(authority);
    	$("#ditmenuUrl").val(menuUrl);
    	$("#ditismenus").val(ismenus);    	
    	layer.open({
    		  type: 1,
    		  shade: false,
    		  title: false, //不显示标题
    		  content: $('#layer_edit'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响   
    		  btn: ['提交'],
    		  yes: function(index, layero){    			
    			  jsonObj = { "menuId": menuId, "menuName": $("#ditmenuName").val(), "menuUrl": $("#ditmenuUrl").val(), "menuIcon": null,      		  
    	      		      "authority": $("#ditauthority").val(), "isMenu": menus, "parentId": parentId };
    			  var adminMenu = JSON.stringify(jsonObj);    			 
    			 $.ajax({
    	    			"url" : "updateMenu",
    	    			"data" : adminMenu,
    	    			"type" : "POST",
    	    			contentType:"application/json",
    	    			"success" : function(obj) {
    	    				if (obj.state == 0) {
    	    					layer.msg(obj.message,{icon:2,time:1000});
    	    					return;
    	    				}else{
    	    					layer.msg(obj.message,{icon:1,time:1000},function(){location.replace(location.href);layer.close(index);});
    	    				}	
    	    			}
    	    		});     		  
    		  }
    	});  
    	
    }
    function add(name,menuId,menus) {
    	
    	
    	$("#parentname").val(name);
    	//$("#ismenus").val(ismenus);    	
    	layer.open({
    		  type: 1,
    		  shade: false,
    		  title: false, //不显示标题
    		  content: $('#layer_add'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响   
    		  btn: ['提交'],
    		  yes: function(index, layero){  
    			  var ismenus=$("#ismenus").val();
    			  jsonObj = {
    	      			  "menuId": null,
    	      		      "menuName": $("#menuName").val(),      		      
    	      		      "menuUrl": $("#menuUrl").val(),
    	      		      "menuIcon": null,      		  
    	      		      "authority": $("#authority").val(),      		     
    	      		      "isMenu": ismenus,
    	      		      "parentId": menuId
    	      		    };    			  
    			  var adminMenu = JSON.stringify(jsonObj);
    			 $.ajax({
    	    			"url" : "addMenu",
    	    			"data" : adminMenu,
    	    			"type" : "POST",
    	    			contentType:"application/json",
    	    			"success" : function(obj) {
    	    				if (obj.state == 0) {
    	    					layer.msg(obj.message,{icon:2,time:1000});
    	    					return;
    	    				}else{
    	    					layer.msg(obj.message,{icon:1,time:1000},function(){location.replace(location.href);layer.close(index);});
    	    				}	
    	    			}
    	    		});     			  
    		  }
    	});  
    	
    }
    
    function print() {
        console.log(treeGrid.cache[tableId]);
        msg("对象已打印，按F12，在控制台查看！");
    }

    function msg(msg) {
        var loadIndex=layer.msg(msg, {
            time:3000
            ,offset: 'b'//顶部
            ,shade: 0
        });
    }
    
    function openorclose() {
        var map=treeGrid.getDataMap(tableId);
        var o= map['102'];
        treeGrid.treeNodeOpen(tableId,o,!o[treeGrid.config.cols.isOpen]);
    }


    function openAll() {
        var treedata=treeGrid.getDataTreeList(tableId);
        treeGrid.treeOpenAll(tableId,!treedata[0][treeGrid.config.cols.isOpen]);
    }

    function getCheckData() {
        var checkStatus = treeGrid.checkStatus(tableId)
            ,data = checkStatus.data;
        layer.alert(JSON.stringify(data));
    }
    function radioStatus() {
        var data = treeGrid.radioStatus(tableId)
        layer.alert(JSON.stringify(data));
    }
    function getCheckLength() {
        var checkStatus = treeGrid.checkStatus(tableId)
            ,data = checkStatus.data;
        layer.msg('选中了：'+ data.length + ' 个');
    }

    function reload() {
        treeGrid.reload(tableId,{
            page:{
                curr:1
            }
        });
    }
    function query() {
        treeGrid.query(tableId,{
            where:{
                name:'sdfsdfsdf'
            }
        });
    }    
    function test() {
        console.log(treeGrid.cache[tableId],treeGrid.getClass(tableId));
    }
</script>

</body>
</html>

