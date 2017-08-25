package com.donnie.web.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.donnie.bean.Message;
import com.donnie.bean.RequestParams;
import com.donnie.service.message.IMessageService;

/***
 * 
 * <b>类名称：</b>MessageController<br/>
 * <b>类描述：</b>MessageController类<br/>
 * <b>创建人：</b>donnie<br/>
 * <b>修改人：</b>donnie<br/>
 * <b>修改时间：</b>2016年4月14日 上午1:05:33<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/admin/message")
public class MessageController {
    
	@Autowired
	IMessageService messageService;
	
	/***
	 * 描述：(列表查询)
	 * com.donnie.dao.message
	 * 方法名：count
	 * 创建人：Donnie 时间：2017年08月25日 14:30:34 
	 * @param requestParams
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/list")
	public String list(RequestParams requestParams){
		return "message/list";
	}
	
	/***
	 * 描述：(获取模版页面)
	 * com.donnie.dao.message
	 * 方法名：count
	 * 创建人：Donnie 时间：2017年08月25日 14:30:34 
	 * @param requestParams
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/template")
	public ModelAndView template(RequestParams requestParams){
		ModelAndView modelAndView = new ModelAndView();
		//查询内容记录
		List<Message> messages = messageService.findMessages(requestParams);
		//查询内容记录总数
		int count = messageService.count(requestParams);
		modelAndView.setViewName("message/template");
		modelAndView.addObject("messages",messages);
		modelAndView.addObject("itemCount",count);
		
		return modelAndView;
	}
	
}
