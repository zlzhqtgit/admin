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
        <a class="layui-btn layui-btn-primary  layui-bg-green"  href="javascript:location.replace(location.href);"  >刷新</a>    
    	<a class="layui-btn layui-btn-primary layui-bg-green"  onclick="getCheckData();">保存数据</a>    	             
        <br>
    </div>
    <input type="checkbox" checked="checked" >
    <table id="treeTable" class="layui-table"  olay-filter="treeTable">
    </table>  
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
            {type:'checkbox',sort:true,templet: function (d) {
            	console.log(d);
            }
            }
        ]]
             ,parseData:function (res) {//数据加载后回调            	 
            	 var checkStatus = treeGrid.getDataList(tableId)
            	 ,data = checkStatus.data;
            	 console.log(data);
                return res;
            }
        /*
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
            }  */
        });        
    });
    
    function getCheckData() {
        var checkStatus = treeGrid.checkStatus(tableId)
            ,data = checkStatus.data;
        var authority=""
        var id="${id}";
        for(var i=0;i<data.length;i++){
        	if(i==data.length-1){
        		authority+=data[i].authority
        	}else{
        		authority+=data[i].authority+";";
        	}        	
        }
        alert(id);
        if(id !=null|| id!=""){
        	$.ajax({
				"url" : "updateAuthority",
				"data" : "id="+id+"&authority="+authority,
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
        console.log(authority);
       //console.log(JSON.stringify(data)); 
        
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

