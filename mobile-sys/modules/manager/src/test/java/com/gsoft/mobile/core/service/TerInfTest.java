package com.gsoft.mobile.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.TerminatedRetryException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.gsoft.mobile.manager.entity.TerInf;
import com.gsoft.mobile.manager.service.DayTemInfManager;
import com.gsoft.mobile.manager.service.TerInfManager;
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class TerInfTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private TerInfManager terInfManager;
	@Autowired
	private DayTemInfManager dayTemInfManager;
	

	
	@Test
	public void testTer(){
		
		dayTemInfManager.getDayTemInf("0000000001");
	  
	}

}
