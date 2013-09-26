package com.gsoft.mobile.core.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.gsoft.mobile.core.entity.AccInf;
import com.gsoft.mobile.core.entity.ClientInf;


@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
//@Transactional  /*AbstractJUnit4SpringContextTests*/
public class AccInfManagerTests extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private AccInfManager accInfManager;
	
	@Autowired
	private ClientInfManager clientInfManager;
	
	@Test
	public void testGetAllAccInfs() {

		List<AccInf> accInfs = accInfManager.getAccInfs();

		System.out.println(accInfs.get(0).getAccountState());

	}
	
//	@Test
	public void testGetAccInf(){
		String bankcardNum = "6222020403010479425";
		AccInf accInf = accInfManager.getAccInf(bankcardNum);
		
//		List<ClientInf> cliAccs = accInf.getClientAccInfs();
//		
//		System.out.println(cliAccs.get(0).getClientAddress());
		
	}
	
//	@Test
	public void testGetClientInfs(){
		
	}
	

}
