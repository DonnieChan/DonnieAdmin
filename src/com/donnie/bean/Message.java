/**
 * Tm系统平台
 * moonvip
 * 创建人:Donnie 
 * 时间：2017年08月25日 17:49:33
 * 2015Tm公司-版权所有
 */
package com.donnie.bean;

import java.util.Date;

/**
 * 
 * 栏目模块：信息
 * Message
 * Content 创建人:Donnie
 * QQ: 461560867
 * 时间：2017年08月25日 17:49:33
 * 
 * @version 1.0.0
 * 
 */
public class Message implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;/* 主键 */
	private String name;
	private Integer userId; //用户ID
	private Date createTime;// 创建时间
	private Integer isDelete;// 0删除1未删除
	private Integer status;// 0未发布1发布

    public Message(){
      super();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
}
