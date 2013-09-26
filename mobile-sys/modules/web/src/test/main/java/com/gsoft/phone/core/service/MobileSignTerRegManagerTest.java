/**
 * 代码声明
 */
package com.gsoft.phone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.youi.common.test.ServiceJUnit4Test;
import org.junit.Test;

import com.gsoft.phone.core.service.MobileSignTerRegManager;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class MobileSignTerRegManagerTests extends ServiceJUnit4Test{
	private MobileSignTerRegManager mobileSignTerRegManager;
	
	@Autowired
	public void setMobileSignTerRegManager(MobileSignTerRegManager mobileSignTerRegManager){
		this.mobileSignTerRegManager = mobileSignTerRegManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllMobileSignTerRegs(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetMobileSignTerRegs(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetMobileSignTerReg(){
    	
    }
	@Test
	public void testGetPagerMobileSignTerRegs(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveMobileSignTerReg(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveMobileSignTerReg(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveMobileSignTerRegs(){
   	
    }
    @Test
    public void testExsitMobileSignTerReg(){
	
	}
}
