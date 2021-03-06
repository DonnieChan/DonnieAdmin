<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp" %>
<c:forEach var="content" varStatus="contentindex" items="${contents}">
	<tr data-itemcount="${itemCount}">
	    <td>
	       ${content.id}
	       <c:if test="${contentindex.first}">
	          <input type="hidden" id="itemcount" value="${itemCount}">
	       </c:if>
	    </td>	
		<td>${content.title} 
		<td>${content.userId}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(content.createTime,'yyyy-MM-dd HH:mm:ss')}">
		   ${tz:timeFormat(content.createTime)}
		</td>
		<td>	
		  <tz:if test="${content.isDelete==0}">
	        <tz:then><span class="green">否</span></tz:then>
	        <tz:else><span class="red">是</span></tz:else>
		  </tz:if>
		</td>
		<td>${content.status}</td>
		<td><a href="javascript:void(0);">未删除</a></td>
	</tr>
</c:forEach>
<!--   private Integer id;/* 主键 */
	   private String title;// 标题
	   private Date createTime;// 创建时间
	   private Integer userId;// 用户ID
	   private Integer isTop;// 是否置顶1置顶0未置顶
	   private Integer isDelete;// 0删除1未删除
	   private Integer status;// 0未发布1发布
	   private Integer channelId;// 类型1Java，2前端，3音乐 4咖啡 5茶文化 6工具
	   private Integer push;// 是否精华推荐内容0否1是
	   private Integer isComment;// 是否允许评论1允许0不允许 
-->
