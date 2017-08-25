<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp" %>
<c:forEach var="message" varStatus="messageindex" items="${messages}">
	<tr data-itemcount="${itemCount}">
	    <td>
	       ${message.id}
	       <c:if test="${messageindex.first}">
	          <input type="hidden" id="itemcount" value="${itemCount}">
	       </c:if>
	    </td>	
		<td>${message.name} 
		<td>${message.userId}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(message.createTime,'yyyy-MM-dd HH:mm:ss')}">
		   ${tz:timeFormat(message.createTime)}
		</td>	
		<td>${message.isDelete}</td>	
		<td>${message.status}</td>
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
