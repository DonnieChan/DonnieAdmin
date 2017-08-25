<%@page import="static com.donnie.util.TzConstant.*"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp" %>
<!DOCTYPE HTML>
<html>
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
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
	<script type="text/javascript" src="${basePath}/resources/js/tz_admin.js"></script>
 </head>
 <body>
	<div class="wrap">
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
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
			<div class="channel"> 首页 > 信息管理</div>
			<div class="cnt">
				<div class="tabwrap">
					<!--表格-->
					<table class="tztab">
						<caption>
							<div class="fr sbtn">
								<input type="text" id="keywords" class="fl" placeholder="搜索的关键字..."/>
								<a onclick="tzAdmin.search(this)" href="javascript:void(0);" class="fl">
								<i class="fa fa-search "></i>
								</a>
							</div>
						</caption>					
						<thead>
							<tr>
								<th>主键</th>	
								<th>名称 <span class="up"></span> <span class="down"></span></th>	
								<th>用户ID</th>
								<th>创建时间</th>	
								<th>删除状态</th>
								<th>发布状态</th>	
								<th>操作</th>
							</tr>
						</thead>
						<!--身体部-->
						<tbody id="tbody" data-model="message">
						<!-- 此处使用template模版的概念来引入表格内容 -->
						  <tr>
						    <td id="loading" colspan="100"></td>
						  </tr>
						</tbody>
					  </table>
					<!-- 分页 -->
                    <div class="cpage"></div>
				</div>
			</div>
		</div>
	</div>
  </body>
  <script type="text/javascript">

	</script>
</html>
