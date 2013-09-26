/**
 * 代码声明
 */
package com.gsoft.phone.param.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.youi.common.test.ServiceJUnit4Test;
import org.junit.Test;

import com.gsoft.phone.param.service.MobileParaValInfManager;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class MobileParaValInfManagerTests extends ServiceJUnit4Test{
	private MobileParaValInfManager mobileParaValInfManager;
	
	@Autowired
	public void setMobileParaValInfManager(MobileParaValInfManager mobileParaValInfManager){
		this.mobileParaValInfManager = mobileParaValInfManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllMobileParaValInfs(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetMobileParaValInfs(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetMobileParaValInf(){
    	
    }
	@Test
	public void testGetPagerMobileParaValInfs(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveMobileParaValInf(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveMobileParaValInf(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveMobileParaValInfs(){
   	
    }
    @Test
    public void testExsitMobileParaValInf(){
	
	}
}
