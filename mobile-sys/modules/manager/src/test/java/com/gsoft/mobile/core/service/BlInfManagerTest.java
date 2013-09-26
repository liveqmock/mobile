package com.gsoft.mobile.core.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.gsoft.mobile.manager.entity.BlInf;
import com.gsoft.mobile.manager.service.BlInfManager;

@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
//@Transactional /*AbstractJUnit4SpringContextTests*/
public class BlInfManagerTest  extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private BlInfManager blInfManager;
	
//	@Test
	public void testGetBlInfs(){
		
		List<BlInf> BlInfs = blInfManager.getBlInfs();
		Assert.notNull(BlInfs, "非空");
		
	}
	
//	@Test
	public void testGetBlInfById(){
		
		String id = "6222020403010479426";
		BlInf blInf = blInfManager.getBlInf(id);
//		blInf.getAccInf();
		
		Assert.notNull(blInf, "非空");
	}
	
//	@Test
	public void testChangeBlackListState(){
		BlInf blInf = new BlInf();
		blInf.setBankcardNum("20110908");
		blInf.setAddQuitReason("0102");
		blInf.setAddQuitType("01");
		
		blInfManager.changeBlackListState(blInf);
		
	}
	@Test
	public void testGetBlInfByBankcardNum(){
		String  bankcardNum = "6222020403010487993";
		BlInf blInf = blInfManager.getBlInfByBankcardNum(bankcardNum);
		Assert.notNull(blInf, "未找到");		
		blInf.setAddQuitReason("0001");
		blInf.setAddQuitType("00");
		
		blInfManager.changeBlackListState(blInf);
		
	}
	
	
	

}
