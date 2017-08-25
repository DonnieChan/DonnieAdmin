package com.donnie.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donnie.bean.AdminUser;
import com.donnie.bean.RequestParams;
import com.donnie.dao.user.IAdminUserMapper;
import com.donnie.service.user.IAdminUserService;

@Service
public class AdminUserServiceImpl implements IAdminUserService {

	@Autowired
	private IAdminUserMapper adminUserMapper;
	
	@Override
	public AdminUser getLogin(RequestParams requestParams) {
         return adminUserMapper.getLogin(requestParams);
	}
	
	@Override
	public int saveBatch(List<AdminUser> adminUsers){
		return adminUserMapper.saveBatch(adminUsers);
	}

	@Override
	public List<AdminUser> queryBatch(List<Integer> ids) {
		return adminUserMapper.queryBatch(ids);
	}

}
