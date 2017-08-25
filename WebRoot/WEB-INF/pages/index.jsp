<%@page import="static com.donnie.util.TzConstant.*"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp" %>
<html>
  <head>
    <title>潭州学院keke老师模版页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- common.jsp中包含引用的js，css，js中要用到的basePath代表项目根目录的字符串变量 -->
  </head>
  
  <body>
 <%--   <h1>This is the welcome page of Pages root folder.</h1>
   <h2>basePath是：${basePath}</h2>
   <h2>rootPath是：${rootPath}</h2>
   <h2>resPath是：${resPath}</h2>
   <h2>当前用户是：<%=session.getAttribute(SESSION_USER_USERNAME) %></h2> --%>
  <html>
  <head>
    <title>潭州学院Donnie模板页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <%@include file="/WEB-INF/pages/common/common.jsp" %>
 </head>
 <body>
	<div class="wrap">
		<div class="slider">
			<div class="logo">
				<a href="#"><img src="${basePath}/resources/images/logo.png"/></a>
			</div>
			<div class="nav">
				<ul>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-home"></i>首页</a></li>
					 <li class="items active"><a href="javascript:void(0);"><i class="fa fa-signal"></i>统计报表</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
					 <li class="items">
						<a href="javascript:void(0);"><i class="fa fa-th-list"></i>表单</a>
						<ul>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
						</ul>
						<span class="numicon c5">3</span>
					 </li>
					 <li class="items">
						<a href="javascript:void(0);"><i class="fa fa-tint"></i>按钮组</a>
						<ul>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
							 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
						</ul>
						<span class="numicon c1">5</span>
					 </li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-pencil"></i>元素</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-star"></i>Addons 5</a></li>
					 <li class="items"><a href="javascript:void(0);"><i class="fa fa-file-o"></i>Error</a></li>
				</ul>
			</div>
		</div>

		<style>
			 
		</style>
		<div class="content">
			<div class="header">
				<ul class="fl">
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-user"></i>欢迎keke来到cms后台</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-envelope"></i>消息5个!</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-cog"></i>设置</a></li>
					 <li class="titems"><a href="${basePath}/logout"><i class="fa fa-share-alt"></i>退出</a></li>	
				</ul>
				<div class="fr sbtn none">
					<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="#" class="fl"><i class="fa fa-search "></i></a>
				</div>
			</div>
			<div class="channel"> Home > Table</div>
			<div class="cnt">
				<div class="tabwrap">
					
					<!--表格-->
					<table class="tztab">
						<caption>
							2015年度一周统计报表数据
							<div class="fr sbtn">
								<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="#" class="fl"><i class="fa fa-search "></i></a>
							</div>
						</caption>
						<!--头部
						<colgroup id="days">
							<col/>
							<col style="background:green;width:200px;"/>
							<col id="t"/>
						</colgroup>-->
						<thead>
							<tr>
								<th>标题 <span class="up"></span> <span class="down"></span></th>	
								<th>类型</th>	
								<th>作者</th>	
								<th>创建时间</th>	
								<th>是否置顶</th>	
								<th>是否精华</th>	
								<th>是否编码</th>	
								<th>发布状态</th>	
								<th>删除状态</th>
							</tr>
						</thead>
						<!--身体部-->
						<tbody>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascriipt:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascriipt:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascriipt:void(0);">未删除</a></td>
							</tr>
							<tr>
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
								
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
							<tr>
							
								<td>JS/CSS3</td>	
								<td>柯柯</td>	
								<td>2015-09-06 15:15:00</td>	
								<td>是</td>	
								<td>是</td>	
								<td>是</td>	
								<td>39/0</td>	
								<td>发布</td>	
								<td><a href="javascript:void(0);">未删除</a></td>
							</tr>
						</tbody>
					</table>
				</div>
					<span class="numicon c1">1</span>
					<span class="numicon c2">2</span>
					<span class="numicon c3">3</span>
					<span class="numicon c4">4</span>
					<span class="numicon c5">5</span>
					<span class="numicon c6">6</span>
			</div>

		</div>
	
	</div>


	<script type="text/javascript">
		$(function(){
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
		});
	</script>
   </script>
  </body>
</html>
