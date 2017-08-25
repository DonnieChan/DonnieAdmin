/**
 * tzdesk系统平台
 * tz_desk
 * com.tz.tag
 * TzLoopTag.java
 * 创建人:xuchengfei 
 * 时间：2015年9月16日-上午12:08:41 
 * 2015潭州教育公司-版权所有
 */
package com.donnie.tag;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * TzLoopTag
 * 创建人:xuchengfei 
 * 时间：2015年9月16日-上午12:08:41 
 * @version 1.0.0
 * 
 */
public class TzLoopTag  extends TagSupport{
	
	
	private Object items;
	private String var;
	private Iterator iterator;
	
	/*
	 * 自定义标签的第一步：
	 * 1:继承TagSupport 或者BodyTagSupport
	 * 2:覆盖里面对应标签的方法 快捷键：Alt+Shift+S
	 * 3:注册：tld文件中注册标签
	 * 4:引入：<%@taglib uri="/web-inf/tld/tz.tld" prefix="tz" %>
	 * 5:调用
	 * <div></div>
	 * <br/>
	 * 
	 * 
	 * 后台标签类注意点：
	 * 1:定义标签属性，只需要生成set方法即可,必须和tld文件中的属性名保持一致
	 * 2:
	 * doStartTag:
	 * SKIP_BODY:忽略标签体的主题内容，这默认值
	 * EVAL_BODY_INCLUDE:要求JSP容器记性执行标签体内容并将结果返回给页面
	 * */
	
	//标签开始 <tz:loop> 
	@Override
	public int doStartTag() throws JspException {
		System.out.println("2======================>dostarttag-start");
		if(items==null || !(items instanceof Collection)){
			return SKIP_BODY;
		}
		System.out.println("2======================>dostarttag--value");
		//集合初始化成功
		iterator = ((Collection)items).iterator();
		if(iterator.hasNext()){//你集合有数据
			//显示主题标签的内容 
			this.pageContext.setAttribute(var, iterator.next());
			return EVAL_BODY_INCLUDE;//里面去执行循环体
		}else{
			return SKIP_BODY;
		}
	}

	//标签体 内容需要一个迭代器
	@Override
	public int doAfterBody() throws JspException {
		if(iterator.hasNext()){
			System.out.println("3======================>doAfterBody-for");
			this.pageContext.setAttribute(var, iterator.next());
			return EVAL_BODY_AGAIN;
		}else {
			System.out.println("3======================>doAfterBody-end");
			return SKIP_BODY;
		}
	}
	
	//标签结束</tz:loop>
	@Override
	public int doEndTag() throws JspException {
		System.out.println("4======================>doEndTag");
		return SKIP_PAGE;
	}
	
	
	//jvm GC垃圾回收
	@Override
	public void release() {
		items = null;
		System.out.println("5======================>release");
		super.release();
	}

	public void setItems(Object items) {
		System.out.println("===================1赋值操作");
		this.items = items;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
	
}
