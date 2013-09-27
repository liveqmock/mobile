/**
 * 代码声明
 */
package com.gsoft.phone.core.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.gsoft.phone.core.entity.ClientInfo;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class ClientInfoManagerTests extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private ClientInfoManager clientInfoManager;
	
//	@Autowired
//	private MessagingTemplate messagingTemplate;
//	
    /**
     * 查询列表
     */
//    @Test
    public void testGetAllClientInfos(){
    	
    }
     /**
     * 条件查询列表
     */
//    @Test
    public void testGetClientInfos(){
//    	ReqContext<Object> params = new ReqContext<Object>();
////		params.add("userId", "zhangsan");
//
//		String beanName = "clientInfoManager"; 
//		String methodName = "getClientInfos";
//		//设置beanName
//		params.add(EsbConstants.PARAM_BEAN_NAME, beanName);
//		//设置methodName
//		params.add(EsbConstants.PARAM_METHOD_NAME, methodName);
//		
//		Map<String, Object> headersToCopy = new HashMap<String,Object>();
//		headersToCopy.put("channel", "receiveChannel");
//		
//		Message<?> mess =  MessageBuilder.withPayload(params).copyHeaders(headersToCopy ).build();
//		
//		Message<?> result = messagingTemplate.sendAndReceive("start",mess);
//		Object obj = result.getPayload();
//		System.out.println("******"+obj);
    	
    }
    /**
     * 根据主键查询
     */
  //  @Test
    public void testGetClientInfo(){
    	
    }
	@Test
	public void testGetPagerClientInfos(){
		List<ClientInfo> clientInfos = clientInfoManager.getClientInfos();
		
		Assert.notEmpty(clientInfos,"clientInfos is not null");
	}
    /**
     * 保存对象
     */
   // @Test
    public void testSaveClientInfo(){
    	
    }

    /**
     * 删除对象
     */
  //  @Test
    public void testRemoveClientInfo(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
   // @Test
    public void testRemoveClientInfos(){
   	
    }
 //   @Test
    public void testExsitClientInfo(){
	
	}
}
