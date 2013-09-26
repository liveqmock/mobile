/**
 * 代码声明
 */
package com.gsoft.phone.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class LogQuiRegManagerTests extends AbstractJUnit4SpringContextTests{
	private LogQuiRegManager logQuiRegManager;
	
	@Autowired
	public void setLogQuiRegManager(LogQuiRegManager logQuiRegManager){
		this.logQuiRegManager = logQuiRegManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllLogQuiRegs(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetLogQuiRegs(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetLogQuiReg(){
    	
    }
	@Test
	public void testGetPagerLogQuiRegs(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveLogQuiReg(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveLogQuiReg(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveLogQuiRegs(){
   	
    }
    @Test
    public void testExsitLogQuiReg(){
	
	}
}
