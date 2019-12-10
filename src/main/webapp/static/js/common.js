//点赞
//function like(obj) {
//	var y;
//	var o = $(obj).find('img').attr('src');
//	switch(o) {
//		case '${pageContext.request.contextPath}/img/xgk/like.png':
//			y = '${pageContext.request.contextPath}/img/xgk/unlike.png';
//			$(obj).find('span').text('喜欢');
//			break;
//		case '${pageContext.request.contextPath}/img/xgk/unlike.png':
//			y = '${pageContext.request.contextPath}/img/xgk/like.png';
//			$(obj).find('span').text('取消喜欢');
//			break;
//		default:
//			y = '${pageContext.request.contextPath}/img/xgk/unlike.png';
//			$(obj).find('span').text('喜欢');
//			break;
//	}
//	$(obj).find('img').attr('src', y);
//}

//弹框
function modelshow(title, content, type) {
	layer.open({
		type: type,
		area: ['800px', '500px'],
		fix: true, //是否跟随页面滚动
		maxmin: true,
		shadeClose: true, //点击阴影开关
		shade: 0.4, //阴影透明度
		move: 'false', //默认：.layui-layer-title
		moveOut: false, //是否允许拖拽到窗口外
		title: title,
		content: content,
		scrollbar: true
	});
}

//选项卡				
$('.tab_head li').click(function() {
	$(this).parent().children().removeClass('cur');
	$(this).addClass('cur');
	var index = $(this).index();
	$(this).parents('.tab_list').find('.tab_body').children().removeClass('cur');
	$(this).parents('.tab_list').find('.tab_body').children().eq(index).addClass('cur');
})

// 点击显示更多按钮
function showMore(obj) {
	$(obj).parent('.open-btn').prev().height("auto"); //取消文字容器高度限制
	$(obj).parent().parent().find(".open-btn").hide(); //隐藏查看更多按钮
	var datas = '';
	var ajaxurl = '';
	$.ajax({
		type: "post",
		url: "",
		async: true,
		data: datas,
		dataType: 'json',
		ssuccess: function(res) {
			console.log(res)
		}
	});
}
