/**
 * 代码声明
 */
package com.gsoft.phone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.youi.common.test.ServiceJUnit4Test;
import org.junit.Test;

import com.gsoft.phone.core.service.MobileAccInfManager;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class MobileAccInfManagerTests extends ServiceJUnit4Test{
	private MobileAccInfManager mobileAccInfManager;
	
	@Autowired
	public void setMobileAccInfManager(MobileAccInfManager mobileAccInfManager){
		this.mobileAccInfManager = mobileAccInfManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllMobileAccInfs(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetMobileAccInfs(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetMobileAccInf(){
    	
    }
	@Test
	public void testGetPagerMobileAccInfs(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveMobileAccInf(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveMobileAccInf(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveMobileAccInfs(){
   	
    }
    @Test
    public void testExsitMobileAccInf(){
	
	}
}
