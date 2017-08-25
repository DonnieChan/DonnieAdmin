/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.dao
 * TzParams.java
 * 创建人:xuchengfei 
 * 时间：2015年11月24日-上午12:42:33 
 * 2015潭州教育公司-版权所有
 */
package com.donnie.bean;

/***
 * <b>类名称：</b>RequestParams<br/>
 * <b>类描述：</b>将实体数据传输到Mybatis DAO中<br/>
 * <b>创建人：</b>donnie<br/>
 * <b>修改人：</b>donnie<br/>
 * <b>修改时间：</b>2016年3月24日 下午5:48:30<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0
 *
 */
public class RequestParams {

	private Integer id;
	private String username;
	private String account;
	private Integer channel_id;
	private String keyword;
	private String password;
	private Integer pageNo = 0;
	private Integer pageSize = 10;
	private Integer totalCount = 0;
	private String order ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
