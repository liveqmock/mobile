/**
 * 代码声明
 */
package com.gsoft.phone.mobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.youi.common.test.ServiceJUnit4Test;
import org.junit.Test;

import com.gsoft.phone.mobile.service.TerminalInfoManager;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class TerminalInfoManagerTests extends ServiceJUnit4Test{
	private TerminalInfoManager terminalInfoManager;
	
	@Autowired
	public void setTerminalInfoManager(TerminalInfoManager terminalInfoManager){
		this.terminalInfoManager = terminalInfoManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllTerminalInfos(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetTerminalInfos(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetTerminalInfo(){
    	
    }
	@Test
	public void testGetPagerTerminalInfos(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveTerminalInfo(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveTerminalInfo(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveTerminalInfos(){
   	
    }
    @Test
    public void testExsitTerminalInfo(){
	
	}
}
