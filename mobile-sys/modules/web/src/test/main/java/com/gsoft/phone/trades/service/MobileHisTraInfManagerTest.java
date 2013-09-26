/**
 * 代码声明
 */
package com.gsoft.phone.trades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.youi.common.test.ServiceJUnit4Test;
import org.junit.Test;

import com.gsoft.phone.trades.service.MobileHisTraInfManager;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class MobileHisTraInfManagerTests extends ServiceJUnit4Test{
	private MobileHisTraInfManager mobileHisTraInfManager;
	
	@Autowired
	public void setMobileHisTraInfManager(MobileHisTraInfManager mobileHisTraInfManager){
		this.mobileHisTraInfManager = mobileHisTraInfManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllMobileHisTraInfs(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetMobileHisTraInfs(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetMobileHisTraInf(){
    	
    }
	@Test
	public void testGetPagerMobileHisTraInfs(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveMobileHisTraInf(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveMobileHisTraInf(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveMobileHisTraInfs(){
   	
    }
    @Test
    public void testExsitMobileHisTraInf(){
	
	}
}
