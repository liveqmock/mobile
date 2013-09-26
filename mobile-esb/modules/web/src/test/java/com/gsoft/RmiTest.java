/**
 * 
 */
package com.gsoft;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.gsoft.framework.esb.EsbConstants;
import com.gsoft.framework.esb.data.ReqContext;
import com.gsoft.framework.esb.data.ResContext;
import com.gsoft.mobile.manager.entity.BlInf;

/**
 * @author zhyi_12
 *
 */

@ContextConfiguration("classpath:applictionContext-rmiclient.xml")
public class RmiTest extends AbstractJUnit4SpringContextTests{

//	@Autowired
//	private RequestReplyExchanger requestReplyExchanger;
	

//	@Autowired
//	private ClientInfoManager clientInfoManager;
//	
	@Autowired
	private MessagingTemplate messagingTemplate;
	
	@Test
	public void testExchange(){
		
		ReqContext<Object> params = new ReqContext<Object>();
		params.add("clientId", "1");
		

		String beanName = "clientInfManager"; 
		String methodName = "getClientInf";
		//设置beanName
		params.add(EsbConstants.PARAM_BEAN_NAME, beanName);
		//设置methodName
		params.add(EsbConstants.PARAM_METHOD_NAME, methodName);
		
		Map<String, Object> headersToCopy = new HashMap<String,Object>();
		headersToCopy.put("channel", "receiveChannel");
		
		Message<?> mess =  MessageBuilder.withPayload(params).copyHeaders(headersToCopy ).build();
		
		Message<?> result = messagingTemplate.sendAndReceive("start",mess);
		Object obj = result.getPayload();
//		[Payload=records:[管理用户, 周毅, 普通用户]]
//		 [Headers={timestamp=1376966302578, id=b1fdaea6-ac5a-4cae-8a51-772578a25f77, channel=receiveChannel}]
		System.out.println("******"+obj);
	}
	
	
//	@Test
     public void test(){
		ReqContext<Object> params = new ReqContext<Object>();
		
    	params.add("bankcardNum", "6222020403010479426");//
    	params.add("addQuitReason", "02");
    	
    	
    	BlInf blInf = new BlInf();
		blInf.setBankcardNum("20110908");
		blInf.setAddQuitReason("0102");
		blInf.setAddQuitType("01");
		
		params.add("blInf", blInf);

		String beanName = "blInfManager"; 
		String methodName = "changeBlackListState";
		
//		String beanName = "clientInfManager"; 
//		String methodName = "getclientInfs";
		
	//设置beanName
	params.add(EsbConstants.PARAM_BEAN_NAME, beanName);
	//设置methodName
	params.add(EsbConstants.PARAM_METHOD_NAME, methodName);
	
	Map<String, Object> headersToCopy = new HashMap<String,Object>();
	headersToCopy.put("channel", "receiveChannel");
	
	Message<?> mess =  MessageBuilder.withPayload(params).copyHeaders(headersToCopy ).build();
	
	Message<?> result = messagingTemplate.sendAndReceive("start",mess);
	ResContext obj = (ResContext) result.getPayload();
	//[Payload=][Headers={timestamp=1376966132866, id=bb54efb0-6a32-45dd-9237-b68423fd436c, channel=receiveChannel}]
//	List<Domain> client = obj.getRecords();
//	for (Domain domain : client) {
//		ClientInf info = (ClientInf)domain;
//		System.out.println(info.getClientId()+":"+info.getClientName());
//	}
	
	
	}
	
	
}
