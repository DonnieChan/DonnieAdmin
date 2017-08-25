package com.donnie.web;

import static com.donnie.util.TzConstant.SESSION_USER;
import static com.donnie.util.TzConstant.SESSION_USER_USERNAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.donnie.bean.AdminUser;
import com.donnie.bean.RequestParams;
import com.donnie.core.BaseController;
import com.donnie.service.user.IAdminUserService;
import com.donnie.service.user.IUserService;
import com.donnie.util.TmStringUtils;

@Controller
@RequestMapping()
public class LoginController extends BaseController{
    
	@Autowired
	IUserService userService;
	
	@Autowired
	IAdminUserService adminUserService;
	
	@RequestMapping("/login")
	public String login(){
		return "login"; 
	}
	
	@ResponseBody
	@RequestMapping(value="/logined",method=RequestMethod.POST)
	public String logined(RequestParams params){
		if(params!=null){
			if(TmStringUtils.isNotEmpty(params.getAccount()) && TmStringUtils.isNotEmpty(params.getPassword())){
				params.setPassword(TmStringUtils.md5Base64(params.getPassword()));
				AdminUser user = adminUserService.getLogin(params);
				if(user!=null){
					if(user.getForbiden()==0){
						return "forbiden";
					}else{
						session.setAttribute(SESSION_USER, user);
						session.setAttribute(SESSION_USER_USERNAME, user.getUsername());
						return "success";
					}
				}else{
					return "fail";
				}
			}else{
				return "null";//请输入账号和密码
			}
		}else{
			return "error";
		}
	}	
	
	/*@ResponseBody
	@RequestMapping(value = "/logined")
	public String logined(RequestParams requestParams){
	  
     User user = null;	
		
	  if(requestParams != null){
		  
	   if(TmStringUtils.isNotEmpty(requestParams.getAccount()) && TmStringUtils.isNotEmpty(requestParams.getpassWord())){
		   
		requestParams.setpassWord(TmStringUtils.md5Base64(requestParams.getpassWord()));
		user = userService.getLogin(requestParams);
        
		if(user != null){		
			 System.out.println("当前User的账号名是：" + user.getAccount());
			 session.setAttribute(SESSION_USER, user);
			 session.setAttribute(SESSION_USER_USERNAME, user.getAccount());
		     return "success";
	      }else{
	         return "fail";
	     }
	   }else{
		   return "null";
	   }
	}else{
		return "error";
	}
  }*/
	
}
