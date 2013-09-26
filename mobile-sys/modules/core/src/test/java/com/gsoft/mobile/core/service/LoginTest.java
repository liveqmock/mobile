package com.gsoft.mobile.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
@Transactional
public class LoginTest {
	
	@Autowired
	private ClientInfManager clientInfManager;
	
	
    /**
     * 测试登陆
     */
    @Test
    public void testLogin(){
    	
    	
    }

}
