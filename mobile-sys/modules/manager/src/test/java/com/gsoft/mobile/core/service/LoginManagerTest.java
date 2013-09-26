package com.gsoft.mobile.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.gsoft.framework.core.web.view.Message;
import com.gsoft.mobile.manager.service.LoginManager;

@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })

public class LoginManagerTest  extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private LoginManager loginManager;
	
	@Test
	public void testGetLogin(){
		String bankcardNum = "6222020403010487999"; 
		 
		String password = "1";
		 //Message mess = loginManager.getLoginInf(bankcardNum, password, "", "", "", "","");
		 //System.out.println(mess.code+":"+mess.info);
		
	}
	

}
