package com.donnie.dao.user;

import com.donnie.bean.User;
import com.donnie.bean.RequestParams;

/***
 * 
 * @author Administrator
 *
 */
public interface IUserMapper {
   
	public User getLogin(RequestParams requestParams);
	
}
