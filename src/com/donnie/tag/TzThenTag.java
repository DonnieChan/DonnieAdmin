/**
 * tzdesk系统平台
 * tz_desk
 * com.tz.tag
 * TzIFTag.java
 * 创建人:xuchengfei 
 * 时间：2015年9月19日-下午11:28:46 
 * 2015潭州教育公司-版权所有
 */
package com.donnie.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * TzIFTag
 * 创建人:xuchengfei 
 * 时间：2015年9月19日-下午11:28:46 
 * @version 1.0.0
 * 
 */
public class TzThenTag extends TagSupport{
	
	@Override
	public int doStartTag() throws JspException {
		TzIFTag parent = (TzIFTag)this.getParent();
		if(parent!=null && parent.getTest()){
			return EVAL_BODY_INCLUDE;//继续去执行标签体的内容
		}else{
			return SKIP_BODY;
		}
	}
	
//	tz:if
//	tz:elseif
//	tz:elseif
//	tz:else
}
