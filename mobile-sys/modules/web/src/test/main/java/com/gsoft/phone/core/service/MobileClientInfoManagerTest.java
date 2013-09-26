/**
 * 代码声明
 */
package com.gsoft.phone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.youi.common.test.ServiceJUnit4Test;
import org.junit.Test;

import com.gsoft.phone.core.service.MobileClientInfoManager;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class MobileClientInfoManagerTests extends ServiceJUnit4Test{
	private MobileClientInfoManager mobileClientInfoManager;
	
	@Autowired
	public void setMobileClientInfoManager(MobileClientInfoManager mobileClientInfoManager){
		this.mobileClientInfoManager = mobileClientInfoManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllMobileClientInfos(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetMobileClientInfos(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetMobileClientInfo(){
    	
    }
	@Test
	public void testGetPagerMobileClientInfos(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveMobileClientInfo(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveMobileClientInfo(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveMobileClientInfos(){
   	
    }
    @Test
    public void testExsitMobileClientInfo(){
	
	}
}
