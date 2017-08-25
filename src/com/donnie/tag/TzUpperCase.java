/**
 * tzdesk系统平台
 * tz_desk
 * com.tz.tag
 * TzUpperCase.java
 * 创建人:xuchengfei 
 * 时间：2015年9月17日-下午8:59:47 
 * 2015潭州教育公司-版权所有
 */
package com.donnie.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 
 * TzUpperCase
 * 创建人:xuchengfei 
 * 时间：2015年9月17日-下午8:59:47 
 * @version 1.0.0
 * 
 */
public class TzUpperCase extends BodyTagSupport{
	
	/*
	 * 	TagSupport和BodyTagSupport它的区别在于
	 *  
	 *  TagSupport是没有办法去获取标签体的内容，
	 *  	1:是将数据放在作用域中，进行返回
	 *  BodyTagSupport:它可以在类获取标签体的内容。
	 *   	1:是将数据放在作用域中，进行返回
	 *      2:通过输出流 this.getPreviousOut()进行数据的返回
	 *      3:获取标签体的内容: this.getBodyContent()
	 *  
	 *  
	 *  
	 * 
	 * */
	
	//次数
	private  int count = 3;
	
	@Override //IteratorTag类
	public int doAfterBody() throws JspException {
		
		if(count>0){
			try {
				//获取标题的内容
				String content = this.getBodyContent().getString();
				JspWriter out = this.getPreviousOut();
				out.print(content.toUpperCase());
				count--;
				//清楚缓存的标签的主题内容
				bodyContent.clearBody();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return EVAL_BODY_AGAIN;
		}else{
			count=1;
			return SKIP_BODY;
		}
	}
	

	@Override
	public void release() {
	}

	public void setCount(int count) {
		this.count = count;
	}
}
