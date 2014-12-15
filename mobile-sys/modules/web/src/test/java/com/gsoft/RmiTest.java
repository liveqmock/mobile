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

/**
 * @author zhyi_12
 *
 */

@ContextConfiguration("classpath:applictionContext-rmiclient.xml")
public class RmiTest extends AbstractJUnit4SpringContextTests{

//	@Autowired
//	private RequestReplyExchanger requestReplyExchanger;
	
	@Autowired
	private MessagingTemplate messagingTemplate;
	//@Test
	public void testExchange(){
		
		ReqContext<Object> params = new ReqContext<Object>();
//		params.add("userId", "zhangsan");

		String beanName = "userManager"; 
		String methodName = "getPagerUsers";
		//设置beanName
		params.add(EsbConstants.PARAM_BEAN_NAME, beanName);
		//设置methodName
		params.add(EsbConstants.PARAM_METHOD_NAME, methodName);
		
		Map<String, Object> headersToCopy = new HashMap<String,Object>();
		headersToCopy.put("channel", "receiveChannel");
		
		Message<?> mess =  MessageBuilder.withPayload(params).copyHeaders(headersToCopy ).build();
		
		Message<?> result = messagingTemplate.sendAndReceive("start",mess);
		Object obj = result.getPayload();
//		[Payload=records:[管理用户, 杨玉斌, 普通用户]]
//		 [Headers={timestamp=1376966302578, id=b1fdaea6-ac5a-4cae-8a51-772578a25f77, channel=receiveChannel}]
		System.out.println("******"+obj);
	}
	
	
	@Test
     public void test(){
		ReqContext<Object> params = new ReqContext<Object>();
//	params.add("userId", "zhangsan");

	String beanName = "clientInfoManager"; 
	String methodName = "getClientInfos";
	//设置beanName
	params.add(EsbConstants.PARAM_BEAN_NAME, beanName);
	//设置methodName
	params.add(EsbConstants.PARAM_METHOD_NAME, methodName);
	
	Map<String, Object> headersToCopy = new HashMap<String,Object>();
	headersToCopy.put("channel", "receiveChannel");
	
	Message<?> mess =  MessageBuilder.withPayload(params).copyHeaders(headersToCopy ).build();
	
	Message<?> result = messagingTemplate.sendAndReceive("start",mess);
	Object obj = result.getPayload();
	//[Payload=][Headers={timestamp=1376966132866, id=bb54efb0-6a32-45dd-9237-b68423fd436c, channel=receiveChannel}]
	System.out.println("******"+obj);
	
	}
	
	
}
