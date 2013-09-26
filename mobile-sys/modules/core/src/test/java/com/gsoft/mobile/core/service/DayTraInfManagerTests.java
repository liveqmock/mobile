package com.gsoft.mobile.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.gsoft.framework.core.orm.PagerRecords;

@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
//@Transactional  /*AbstractJUnit4SpringContextTests*/
public class DayTraInfManagerTests extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private DayTraInfManager dayTraInfManager;
	
	
	@SuppressWarnings("unused")
	@Test
	public void testGetPagerDayTraInfs(){
		String pageIndex = "1";
		String pageSize = "10";
		String type = "01";
		String cardCode = "6222020403010487994";
		String startDate = "20130701";
		String endDate = "20130906";
		
		PagerRecords records = dayTraInfManager.getPagerTraInfs(pageIndex, pageSize, type, cardCode, startDate, endDate);
		System.out.println(records.getRecords().size());
		
		
	}
//	@Test
	public void testRex(){
		String regex = "^\\d{8}$";
		if(dayTraInfManager.checkRegex("20120506", regex)){
			System.out.println("okokook");
		}else{
			System.out.println("no");
		}
	}
	
	

}
