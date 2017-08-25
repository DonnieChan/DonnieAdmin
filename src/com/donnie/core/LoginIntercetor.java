/**
 * tzdesk系统平台
 * tzupload
 * com.tz.core
 * LoginIntercetor.java
 * 创建人:xuchengfei 
 * 时间：2015年11月13日-下午9:51:18 
 * 2015潭州教育公司-版权所有
 */
package com.donnie.core;
import static com.donnie.util.TzConstant.SESSION_USER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.donnie.bean.AdminUser;

/***
 * <b>类名称：</b>LoginIntercetor<br/>
 * <b>类描述：</b>拦截AdminUser的登录操作，加以判断<br/>
 * <b>创建人：</b>donnie<br/>
 * <b>修改人：</b>donnie<br/>
 * <b>修改时间：</b>2016年3月24日 下午12:20:49<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0
 *
 */
public class LoginIntercetor implements HandlerInterceptor{
	
	/***
	 * 描述：(拦截AdminUser的登录操作，加以判断)
	 * 方法名：preHandle
	 * 创建人：Donnie 时间：2016年3月24日-下午12:22:06  boolean
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("进来了吗..........");
		AdminUser user =(AdminUser)request.getSession().getAttribute(SESSION_USER);
		if(user!=null){
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/login");	
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("请求结束执行的方法..........");
		
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("响应已经被渲染成功后执行的方法..........");
		
	}

}
