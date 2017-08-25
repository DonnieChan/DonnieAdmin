package com.donnie.service.user;

import java.util.List;

import com.donnie.bean.AdminUser;
import com.donnie.bean.RequestParams;

public interface IAdminUserService {
  
	public AdminUser getLogin(RequestParams requestParams);
	
	public int saveBatch(List<AdminUser> adminUsers);
	
	public List<AdminUser> queryBatch(List<Integer> ids);
}
