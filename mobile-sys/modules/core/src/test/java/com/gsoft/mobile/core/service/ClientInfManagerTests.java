package com.gsoft.mobile.core.service;

/**
 * 代码声明
 */

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.gsoft.framework.core.orm.Condition;
import com.gsoft.mobile.core.dao.ClientInfDao;
import com.gsoft.mobile.core.entity.AccInf;
import com.gsoft.mobile.core.entity.ClientInf;
import com.gsoft.mobile.core.entity.SignInf;

@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
//@Transactional /*AbstractJUnit4SpringContextTests*/
public class ClientInfManagerTests extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ClientInfManager clientInfManager;


	/**
	 * 查询列表
	 */
//	 @Test
	public void testGetAllClientInfos() {

		List<ClientInf> clientInfs = clientInfManager.getClientInfs();

		List<AccInf> cliAccs = clientInfs.get(0).getAccInfs();
		System.out.println(cliAccs);

	}

	/**
	 * 测试登录
	 */
	 @Test
	public void testGetLoginClientInf() {
//		String bankcardNum = "20110908";
		String bankcardNum = "6222020403010487993"; 
		 
		String password = "1";
		clientInfManager.getLoginClientInf(bankcardNum, password, "", "", "", "");
	}

	/**
	 * 条件查询列表
	 */
	// @Test
	public void testGetClientInfos() {

	}

	/**
	 * 根据主键查询
	 */
	// @Test
	public void testGetClientInfo() {

	}

	// @Test
	public void testGetPagerClientInfos() {
		ClientInf clientInfos = clientInfManager.getClientInf("1");
		Assert.notNull(clientInfos, "clientInfo is not null");
	}

	/**
	 * 保存对象
	 */
//	@Test
	public void testSaveClientInfo() {
		// ClientInf clientInf = clientInfManager.getClientInf("1");
		//
		// List<AccInf> cliAccInfs = new ArrayList<AccInf>();
		// AccInf accInf = new AccInf();
		// accInf.setAccountId("1");
		//
		// cliAccInfs.add(accInf);
		// clientInf.setCliAccInfs(cliAccInfs);
		//
		// clientInfManager.saveClientInf(clientInf);
		ClientInf client = new ClientInf();
		client.setClientName("hello");
		client.setDocumentNum("12353454654");
		client.setDocumentType("02");
		client.setClientAddress("123");
		ClientInf result = clientInfManager.saveClientInf(client);
		System.out.println(result.getClientId());

	}

	/**
	 * 删除对象
	 */
	// @Test
	public void testRemoveClientInfo() {
		this.clientInfManager.removeClientInf("1");
	}

	/**
	 * 根据主键集合删除对象
	 */
	// @Test
	public void testRemoveClientInfos() {

	}

	// @Test
	public void testExsitClientInfo() {

	}

	// @Test
	public void testGetClientInf() {
		String bankcardNum = "";
		AccInf accInf = new AccInf();
		accInf.setBankcardNum(bankcardNum);

		List<AccInf> cliAccInfs = new ArrayList<AccInf>();
		cliAccInfs.add(accInf);

		Condition[] conditions;
		// clientInfManager.getClientInfs(new Condition[]{} ,new
		// Condition<Order>[]);
	}
//	@Test
	public void testGetClientSignInf(){
		String clientId = "1";
		List<SignInf> infs = clientInfManager.getClientSignInfs(clientId);
		Assert.notEmpty(infs, "签约信息未找到");
	    System.out.println(infs.get(0).getBankcardNum());
		
	}
	
}
