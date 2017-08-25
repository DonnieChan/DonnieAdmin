/**
 * Tm系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:xuchengfei 
 * 时间：2015年6月8日-下午1:13:00 
 * 2015Tm公司-版权所有
 */
package com.donnie.bean;

import java.util.Date;

/**
 * 
 * Content 创建人:xuchengfei 时间：2015年6月8日-下午1:13:00
 * 
 * @version 1.0.0
 * 
 */
public class Content implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;/* 主键 */
	private String title;// 标题
	private String subTitle;// 子标题
	private String content;// 内容
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
	private String staticLink;// 静态连接
	private String tag;// 标签
	private String img;// 封面图片
	private Integer userId;// 用户ID
	private Integer isTop;// 是否置顶1置顶0未置顶
	private Integer isDelete;// 0删除1未删除
	private Integer status;// 0未发布1发布
	private Integer type;// 1文章2音乐3视频4其他
	private Integer channel_id;// 类型1Java，2前端，3音乐 4咖啡 5茶文化 6工具
	private Integer categoryId;// 音乐类型
	private Integer push;// 是否精华推荐内容0否1是
	private Integer isComment;// 是否允许评论1允许0不允许
	private String thumnail;// 小图片
	private Integer width;// 封面图片的宽度
	private Integer height;// 封面图片的高度

	/* 源代码存储 */
	private String htmlCode;
	private String jsCode;
	private String cssCode;
	private Integer isCode;// 0不可预览 1可预览

	private Integer hits;// 点击数
	private Integer loves;// 喜欢数量
	private Integer collections;// 收藏数量
	private Integer comments;// 评论数据

	private String keywords;// seo关键字
	private String description;// seo描述

	// 临时字段
	private String headerPic;// 头像
	private String username;// 作者名称
	private String channelName;// 栏目名称
	private String categoryName;// 分类名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getPush() {
		return push;
	}

	public void setPush(Integer push) {
		this.push = push;
	}

	public Integer getIsComment() {
		return isComment;
	}

	public void setIsComment(Integer isComment) {
		this.isComment = isComment;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Integer getLoves() {
		return loves;
	}

	public void setLoves(Integer loves) {
		this.loves = loves;
	}

	public Integer getCollections() {
		return collections;
	}

	public void setCollections(Integer collections) {
		this.collections = collections;
	}

	public String getStaticLink() {
		return staticLink;
	}

	public void setStaticLink(String staticLink) {
		this.staticLink = staticLink;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getHeaderPic() {
		return headerPic;
	}

	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getHtmlCode() {
		return htmlCode;
	}

	public void setHtmlCode(String htmlCode) {
		this.htmlCode = htmlCode;
	}

	public String getJsCode() {
		return jsCode;
	}

	public void setJsCode(String jsCode) {
		this.jsCode = jsCode;
	}

	public String getCssCode() {
		return cssCode;
	}

	public void setCssCode(String cssCode) {
		this.cssCode = cssCode;
	}

	public Integer getIsCode() {
		return isCode;
	}

	public void setIsCode(Integer isCode) {
		this.isCode = isCode;
	}

	public String getThumnail() {
		return thumnail;
	}

	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
}