package com.donnie.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donnie.bean.User;
import com.donnie.bean.RequestParams;
import com.donnie.dao.user.IUserMapper;
import com.donnie.service.user.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public User getLogin(RequestParams requestParams) {
         return userMapper.getLogin(requestParams);
	}

}
