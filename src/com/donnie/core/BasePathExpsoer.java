package com.donnie.core;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ServletContextAware;

import com.donnie.util.TmStringUtils;
/***
 * <b>类名称：</b>BasePathExpsoer<br/>
 * <b>类描述：</b>存储以项目名字为根目录的路径名，以及其资源文件的总路径<br/>
 * <b>创建人：</b>donnie<br/>
 * <b>修改人：</b>donnie<br/>
 * <b>修改时间：</b>2016年4月2日 下午7:23:08<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0
 *
 */
public class BasePathExpsoer  implements ServletContextAware{

	private ServletContext application;
	private ApplicationContext context;

	private String rootPath;
	public void init(){
		if(TmStringUtils.isEmpty(rootPath)){
			rootPath = application.getContextPath();
		}
		application.setAttribute("rootPath", rootPath);
		application.setAttribute("resPath", rootPath+"/resources");
	}
	
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
}
