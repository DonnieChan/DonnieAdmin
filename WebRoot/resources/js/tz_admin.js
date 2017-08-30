$(function(){
		$(".tmui-tips").tmTip();
		
		$(".nav").find("li.items").find("a").click(function(){
			var len = $(this).next().length;
			if(len>0){
				$(this).next().stop(true,true).slideToggle()
				.end().parents("li")
				.addClass("active")
				.siblings().removeClass("active")
				.find("ul").slideUp("slow");
			}
	  });

//初始化列表
tzAdmin.loadData(0, 10, function(itemCount) {
	tzAdmin.initPage(itemCount);
	});
});

var tzAdmin = {
		pageNo:0,
		papgeSize:10,
		initPage:function(itemCount){
  		   $(".cpage").tzPage(itemCount,{
  			num_edge_entries:1, 
  			num_display_entries:4,
  			num_edge_entries:5,
  			current_page:0,
  			showGo:true,
  			showSelect:true,
  			items_per_page:10,
  			prev_text:"上一页",
  			next_text:"下一页",
  			callback:function(pageNo,psize){
  				   //点击页码或者上一页，下一页按钮，根据页码，显示对应应该显示的列表内容
                     tzAdmin.loadData(pageNo,psize);
  			}
		 });
	   },
	   loadData:function(pageNo,pageSize,callback){
		        var keyword = $("#keywords").val();
		        var model = $("#tbody").data("model");
		        //alert($("#tbody").data("model"));
				$.ajax({
					type:"post",
					url:adminPath + "/"+ model +"/template",
					beforeSend:function(){
				      loading2($("#loading"),4);
					},
					data:{pageNo:pageNo*pageSize,pageSize:pageSize,keyword:keyword},
					success:function(data){
						$("#tbody").html(data);
						var $data = $(data);
						var itemCount = $data.find("#itemcount").val();
						//alert("itemCount is : "+itemCount);
						//如果是第一次载入页面，将会初始化列表内容，默认为从1条数据记录，显示到第10条
						if(callback)callback(itemCount);
					}
				});
	   },
	   search:function(){
		   var keyword = $("#keywords").val();
		   //判断是否已经输入了搜索内容
		   if(isEmpty(keyword)){
			   loading("请输入关键字!",3);
			   $("#keywords").focus();
			   //如果之前已经缓存了当前内容列表的内容，则直接从缓存中读取
         	   /* if(window.sessionStorage){
         		  $("#tbody").html(sessionStorage.getItem("table_content"));
         	   } */
			   return;
		   }
		   //如有输入搜索内容，则进行关键字搜索
		   tzAdmin.loadData(0,10);
	   },
	   op:function(obj){
		   //灵活使用data方法，缓存行级数据需要变更的部分值
		   var $this = $(obj);
		   var $td = $this.parent("td");
		   var opid = $this.data("opid");
		   var mark = $this.data("mark");
		   var val = $this.data("val");
           //状态控制的相关变量
		   var text;
		   var color;
		   //后台update操作的关键字
		   var params = {};
		   params[mark] = val;
		   params["id"] = opid;

		   $.ajax({
			   type:"post",
			   url:adminPath + "/content/update",
			   data:params,
			   success:function(data){
				   if(data == "success"){
					switch(mark){
					  case "isDelete":
					   if(val == 0){
						 $this.text("是");
						 $this.removeClass("green").addClass("red");
						 $this.data("val",1);
					   }else{
						 $this.text("否");
						 $this.removeClass("red").addClass("green");
						 $this.data("val",0);
					   }
					   break;
				   }
			   }
		   }
	   });
   }
}
//添加等待效果？该原型方法定义在sg.js中
function loading2(target,mark){
	  $.loading({target:$(target),mark:1});
}