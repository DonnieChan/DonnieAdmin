package com.donnie.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.donnie.bean.AdminUser;
import com.donnie.service.user.IAdminUserService;
import com.donnie.util.TmStringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestUser {

	@Autowired
	IAdminUserService adminUserService;
	
	@Test
	public void testSaveBatch(){
		ArrayList<AdminUser> adminUsers = new ArrayList<AdminUser>();
		AdminUser adminUser1 = new AdminUser();
		AdminUser adminUser2 = new AdminUser();
		
		adminUser1.setUsername("vicki");
		adminUser1.setPassword(TmStringUtils.md5Base64("123"));
        adminUsers.add(adminUser1);
        
		adminUser2.setUsername("mingzi");
		adminUser2.setPassword(TmStringUtils.md5Base64("345"));
		adminUsers.add(adminUser2);
		
		int result = adminUserService.saveBatch(adminUsers);
		System.out.println("新增的条目数为：" + result);
	}
	
	@Test
	public void testQueryBatch(){
	   List<Integer> ids = new ArrayList<Integer>();
	   ids.add(3);
	   ids.add(4);
	   ids.add(5);
	   
	   List<AdminUser> adminUsers = adminUserService.queryBatch(ids);
	   for(AdminUser adminUser : adminUsers){
		   System.out.println("当前用户的forbiden值为： " + adminUser.getForbiden());
	   }
	}
	
}
