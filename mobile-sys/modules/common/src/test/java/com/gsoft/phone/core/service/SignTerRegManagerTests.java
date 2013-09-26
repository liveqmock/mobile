/**
 * 代码声明
 */
package com.gsoft.phone.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class SignTerRegManagerTests extends AbstractJUnit4SpringContextTests{
	private SignTerRegManager signTerRegManager;
	
	@Autowired
	public void setSignTerRegManager(SignTerRegManager signTerRegManager){
		this.signTerRegManager = signTerRegManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllSignTerRegs(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetSignTerRegs(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetSignTerReg(){
    	
    }
	@Test
	public void testGetPagerSignTerRegs(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveSignTerReg(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveSignTerReg(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveSignTerRegs(){
   	
    }
    @Test
    public void testExsitSignTerReg(){
	
	}
}
