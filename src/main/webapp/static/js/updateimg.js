window.onload = function() {	
    var curWwwPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    var localhostPath = curWwwPath.substring(0, pos);
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    var path=localhostPath+projectName;
				var input = document.getElementById("upgteimg");
				var showui = document.getElementById("showui");
				var result;
				var dataArr = []; // 储存所选图片的结果(文件名和base64数据)  
				var fd; //FormData方式发送请求    
				var oSelect = document.getElementById("select");
				var oAdd = document.getElementById("add");
				var showinput = document.getElementById("showinput");
				var oSubmit = document.getElementById("submit");
				var oInput = document.getElementById("upgteimg");
				var lilength = showui.getElementsByTagName('li');				
				var index = 0;
				var currentReViewImgIndex = 0;
				function show() {}
				//监听展示图片的ul,执行判断是否隐藏
				showui.addEventListener("click", function() {
					show();
				});
				if(typeof FileReader === 'undefined') {
					alert("抱歉，你的浏览器不支持 FileReader");
					input.setAttribute('disabled', 'disabled');
				} else {
					input.addEventListener('change', readFile, false);
				}
				var tname=document.getElementsByName("show-img");				
				if(lilength.length !=0){
					var upath=$("#universitiesCode").val();
					for(var i=0;i<tname.length;i++){						
						var name=tname[i].src.split(upath+"/")[1];
						console.log(name);
						read(i,name,tname[i].src,0);
						console.log(dataArr);
					}
				}
				function getImageBlob(url, cb) {
				      var xhr = new XMLHttpRequest();
				      xhr.open("get", url, true);
				      xhr.responseType = "blob";
				      xhr.onload = function() {
				        if (this.status == 200) {
				          if(cb) cb(this.response);
				        }
				      };
				      xhr.send();
				    }

				function read(i,name,url1,type){
					var li;
					var left;
					var center;
					var right;
					var src;
					var reader = new FileReader();
					reader.index = i;
					if(type==0){
						getImageBlob( url1 , function(blob){
					        reader.readAsDataURL(blob);
					        reader.fileName = name;
						}); 
					}else{
						 reader.readAsDataURL(url1);
						 reader.fileName =url1.name;
					}  				
					reader.onload = function(e) {
						var imgMsg = {
							name: this.fileName, //获取文件名    
							base64: this.result //reader.readAsDataURL方法执行完后，base64数据储存在reader.result里    
						}
						console.log(imgMsg);
						dataArr.push(imgMsg);								
					for(var j = currentReViewImgIndex; j < dataArr.length; j++) {
						currentReViewImgIndex = j
					}
					if(type==1){					
						result = '<div class="showdiv"><img class="left" src="'+path+'/static/images/updataimg/Arrow_left.svg" /><img class="center" src="'+path+'/static/images/updataimg/delete.svg" /><img class="right" src="'+path+'/static/images/updataimg/Arrow_right.svg" /></div><img id="srcimgid' + currentReViewImgIndex + '" class="showimg" src="' + this.result + '" />';
						li = document.createElement('li');
						li.innerHTML = result;
						showui.appendChild(li);
						left = li.getElementsByTagName('img')[0];
						center = li.getElementsByTagName('img')[1];
						right = li.getElementsByTagName('img')[2];
						src = li.getElementsByTagName('img')[3];
						show()
					}else{						
						li =lilength[i];						
						left = li.getElementsByTagName('img')[0];
						center = li.getElementsByTagName('img')[1];
						right = li.getElementsByTagName('img')[2];
						src = li.getElementsByTagName('img')[3];
					}
					left.onclick = function(num) {
							return function() {
								if(num == 0) {

								} else {
									var list = 0;
									for(var j = 0; j < dataArr.length; j++) {
										list = j
									}
									dataArr.splice(up, 0, dataArr[num]);
									dataArr.splice(num + 1, 1)
									var up = num - 1;
									for(var j = 0; j < list + 1; j++) {
										$("#srcimgid" + j + "").attr("src", dataArr[j].base64)
									}									
								}
							}
						}(currentReViewImgIndex)
						center.onclick = function(num) {
								return function() {
									li.remove(); // 在页面中删除该图片元素  
									dataArr.splice(num, 1)
								}
							}(currentReViewImgIndex)

							right.onclick = function(num) {
								return function() {

									var list = 0;
									for(var j = 0; j < dataArr.length; j++) {
										list = j
									}
									dataArr.splice(list + 1, 0, dataArr[num]);
									dataArr.splice(num, 1)
									var down = num - 1;
									var datalist = list+1;
									for(var j = 0; j < datalist; j++) {
										$("#srcimgid" + j + "").attr("src", dataArr[j].base64)
									}

								}
							}(currentReViewImgIndex)
							index++;					
					}
				}	
				function readFile() {					
					var iLen = this.files.length;					
					for(var i = 0; i < iLen; i++) {
						if(!input['value'].match(/.jpg|.gif|.png|.jpeg|.bmp/i)) { //判断上传文件格式    
							return alert("上传的图片格式不正确，请重新选择");
						}else if(dataArr.length==6 || iLen+dataArr.length>6){
							return alert("上传的图片数量不能够大于6张");
						}else{
							read(i,name,this.files[i],1);
						}						
					}
				}
				function send() {
					for(var j = 0; j < dataArr.length; j++) {
						var	inputdata;
						inputdata = '<input name="" type="text" id="" value="' + dataArr[j].base64 + '" />';
						showinput.innerHTML += inputdata;
					}
				}
				oSubmit.onclick = function() {
					if(!dataArr.length) {
						return alert('请先选择文件');
					}	
					
					var formData = new FormData();
					for(var i=0;i<dataArr.length;i++){
						formData.append('cardPic',dataArr[i]);
						console.log(formData);
					}					
					 var data=$("#from-university").serialize();
				
					 //formData.append('university',data);
					 $.ajax({
						 url: 'universityedit',
				          type: 'POST',
				          cache: false,
				          data: formData,				        
				          processData: false,
				          contentType: false,
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
				$('#showui').on('DOMNodeInserted', function() {
					show();
				})
				
			}