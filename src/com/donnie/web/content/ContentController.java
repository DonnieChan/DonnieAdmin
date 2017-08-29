package com.donnie.web.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.donnie.bean.Content;
import com.donnie.bean.RequestParams;
import com.donnie.service.content.IContentService;

/***
 * 
 * <b>类名称：</b>ContentController<br/>
 * <b>类描述：</b>ContentController类<br/>
 * <b>创建人：</b>donnie<br/>
 * <b>修改人：</b>donnie<br/>
 * <b>修改时间：</b>2016年4月14日 上午1:05:33<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/admin/content")
public class ContentController {
    
	@Autowired
	IContentService contentService;
	
	/***
	 * 描述：(返回多条用户资料内容给列表)
	 * 方法名：list
	 * 创建人：Donnie 时间：2016年4月14日-上午1:06:19 
	 * @param requestParams
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/list")
	public String list(RequestParams requestParams){
		return "content/list";
	}
	
	/***
	 * 
	 * 描述：(获取列表模板中的内容)
	 * 方法名：template
	 * 创建人：Donnie 时间：2017年8月30日-上午12:13:01 
	 * @param requestParams
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/template")
	public ModelAndView template(RequestParams requestParams){
		ModelAndView modelAndView = new ModelAndView();
		//查询内容记录
		List<Content> contents = contentService.findContents(requestParams);
		//查询内容记录总数
		int count = contentService.count(requestParams);
		
		for(Content content : contents){
			System.out.println("当前内容为：  " + content.getTitle());
		}
		
		modelAndView.setViewName("content/template");
		modelAndView.addObject("contents",contents);
		modelAndView.addObject("itemCount",count);
		
		return modelAndView;
	}
	
	/***
	 * 描述：(更新消息内容)
	 * 方法名：update
	 * 创建人：Donnie 时间：2017年8月30日-上午12:20:35 
	 * @param content
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Content content){
		int count = contentService.update(content);
		return count!=0 ? "success":"fail";
	}
}
