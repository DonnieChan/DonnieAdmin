package com.donnie.service.user;

import com.donnie.bean.User;
import com.donnie.bean.RequestParams;

public interface IUserService {
  
	public User getLogin(RequestParams requestParams);
	
}
