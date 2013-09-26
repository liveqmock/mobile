/**
 * 代码声明
 */
package com.gsoft.phone.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class CliAccRelManagerTests extends AbstractJUnit4SpringContextTests{
	private CliAccRelManager cliAccRelManager;
	
	@Autowired
	public void setCliAccRelManager(CliAccRelManager cliAccRelManager){
		this.cliAccRelManager = cliAccRelManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllCliAccRels(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetCliAccRels(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetCliAccRel(){
    	
    }
	@Test
	public void testGetPagerCliAccRels(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveCliAccRel(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveCliAccRel(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveCliAccRels(){
   	
    }
    @Test
    public void testExsitCliAccRel(){
	
	}
}
