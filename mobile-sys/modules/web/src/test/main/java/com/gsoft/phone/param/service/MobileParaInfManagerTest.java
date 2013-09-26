/**
 * 代码声明
 */
package com.gsoft.phone.param.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.youi.common.test.ServiceJUnit4Test;
import org.junit.Test;

import com.gsoft.phone.param.service.MobileParaInfManager;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class MobileParaInfManagerTests extends ServiceJUnit4Test{
	private MobileParaInfManager mobileParaInfManager;
	
	@Autowired
	public void setMobileParaInfManager(MobileParaInfManager mobileParaInfManager){
		this.mobileParaInfManager = mobileParaInfManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllMobileParaInfs(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetMobileParaInfs(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetMobileParaInf(){
    	
    }
	@Test
	public void testGetPagerMobileParaInfs(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveMobileParaInf(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveMobileParaInf(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveMobileParaInfs(){
   	
    }
    @Test
    public void testExsitMobileParaInf(){
	
	}
}
