/**
 * 代码声明
 */
package com.gsoft.phone.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class SignInfoManagerTests extends AbstractJUnit4SpringContextTests{
	private SignInfoManager signInfoManager;
	
	@Autowired
	public void setSignInfoManager(SignInfoManager signInfoManager){
		this.signInfoManager = signInfoManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllSignInfos(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetSignInfos(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetSignInfo(){
    	
    }
	@Test
	public void testGetPagerSignInfos(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveSignInfo(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveSignInfo(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveSignInfos(){
   	
    }
    @Test
    public void testExsitSignInfo(){
	
	}
}
