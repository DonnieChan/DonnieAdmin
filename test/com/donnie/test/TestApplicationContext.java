package com.donnie.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;
import com.donnie.bean.AdminUser;
import com.donnie.bean.Content;
import com.donnie.bean.User;
import com.donnie.bean.RequestParams;
import com.donnie.dao.user.IUserMapper;
import com.donnie.service.content.IContentService;
import com.donnie.service.user.IAdminUserService;
import com.donnie.service.user.IUserService;
import com.donnie.util.TmStringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestApplicationContext {
	
	@Autowired
	IUserService service;
	
	@Autowired
	IAdminUserService adminUserService;
	
	@Autowired
	IContentService contentService;
	
	/*
	如果出现不能连接数据库的异常，在applicationContext中直接填入数据库连接属性，而不采用properties文件引用的方式 
	@Test
	public void handler(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		DruidDataSource dataSource = context.getBean(DruidDataSource.class);
		System.out.println("============" + dataSource);
	}*/
	
	
	@Test
	public void testAdminUser(){
		
		RequestParams requestParams = new RequestParams();
		requestParams.setAccount("461560867@qq.com");
		requestParams.setPassword("AlLe/WbCTwU=");
		AdminUser adminUser = adminUserService.getLogin(requestParams);
		
		if(adminUser.getForbiden() == 0){
		  System.out.println("当前adminUser的账号名是：   " + adminUser.getEmail());
		}
		
	}
	
	
/*	@Test
	public void testContents(){
		
		RequestParams requestParams = new RequestParams();
      //  requestParams.setOrder("create_time");
     //   requestParams.setPageNo(0);
     //   requestParams.setPageSize(10);
        
		List<Content> contents = contentService.findContents(requestParams);
		
		for(Content content : contents){
			System.out.println("当前内容为：  " + content.getTitle());
		}
		
	}*/
	
	
/*	@Test
	public void testMd5(){
		System.out.println("123被Md5加密后为：" + TmStringUtils.md5Base64("123"));
		System.out.println("root被Md5加密后为：" + TmStringUtils.md5Base64("root"));
	}*/
	
}
