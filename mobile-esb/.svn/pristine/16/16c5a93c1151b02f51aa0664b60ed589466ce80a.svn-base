/**
 * 
 */
package com.gsoft.mobile.login.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;

import com.gsoft.framework.core.dataobj.Domain;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.web.menu.IMenu;
import com.gsoft.framework.esb.EsbConstants;
import com.gsoft.framework.esb.data.ReqContext;
import com.gsoft.framework.esb.data.ResContext;
import com.gsoft.framework.security.DefaultLoginFormToken;
import com.gsoft.framework.security.TokenLoginAccountProvider;
import com.gsoft.framework.security.fuc.dao.RoleDao;
import com.gsoft.framework.security.fuc.entity.Menu;
import com.gsoft.framework.security.fuc.entity.Role;
import com.gsoft.framework.security.fuc.service.MenuManager;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.PasswordUtils;
import com.gsoft.mobile.core.entity.ClientInf;

/**
 * @author Administrator
 *
 */
@Service("clientLoginProvider")
@Transactional
public class ClientLoginProvider implements TokenLoginAccountProvider<ClientAccount> {

	@Autowired
	private MessagingTemplate messagingTemplate;
	
	@Autowired
	private MenuManager menuManager;
	
	@Autowired
	private RoleDao<Role,String> roleDao;
	
	@Override
	public ClientAccount getAccount(String username) {
		return null;
	}
	
	private ResContext callSysService(String beanName,String methodName,
			Map<String,List<Object>> inputParams){
		ReqContext<Object> params = new ReqContext<Object>();
		//设置beanName
		params.add(EsbConstants.PARAM_BEAN_NAME, beanName);
		//设置methodName
		params.add(EsbConstants.PARAM_METHOD_NAME, methodName);
		
		for(Map.Entry<String, List<Object>> entry:inputParams.entrySet()){
			params.put(entry.getKey(), entry.getValue());
		}
		
		Map<String, Object> headersToCopy = new HashMap<String,Object>();
		headersToCopy.put("channel", "sys");
		
		Message<?> mess =  MessageBuilder.withPayload(params).copyHeaders(headersToCopy ).build();
		
		Message<?> result = messagingTemplate.sendAndReceive("beanStart",mess);
		
		return (ResContext)result.getPayload();
	}

	@Override
	public List<IMenu> getProviderMenus() {
		Collection<Order> orders = new ArrayList<Order>();
		orders.add(ConditionUtils.getOrder("menuNum", true));
		List<Menu> menus = menuManager.getMenus(null, orders);
		List<IMenu> providerMenus = new ArrayList<IMenu>();
		for(Menu menu:menus){
			providerMenus.add(menu);
		}
		return providerMenus;
	}

	@Override
	public List<String> getAccountMenus(ClientAccount account) {
		return roleDao.getMenuIdsByRoles(account.getRoles());
	}

	@Override
	public void modifyPassword(String username, String password,
			String confirmPassword, String oldPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientAccount getAccountByToken(DefaultLoginFormToken token) {
		ClientLoginInfo clientLoginInfo = new ClientLoginInfo();
		String username = token.getUsername();
		
		String beanName = "clientInfManager"; 
		String methodName = "getLoginClientInf";
		
		LinkedMultiValueMap<String,Object> inputParams = new LinkedMultiValueMap<String,Object>();
		inputParams.add("bankcardNum", username);
		inputParams.add("password", new String(token.getPassword()));
		
		ResContext res = this.callSysService(beanName, methodName, inputParams);
		
		Domain record = res.getRecord();
		if(record instanceof ClientInf){
			ClientInf clientInf = (ClientInf)record;
			clientLoginInfo.setUserId(clientInf.getClientId());
			clientLoginInfo.setBankcardNum(username);
		}
		
		ClientAccount clientAccount = 
			new ClientAccount(clientLoginInfo, PasswordUtils.md5Password("123456"));
		
		Set<String> roles = new HashSet<String>();
		roles.addAll(clientLoginInfo.roleIds());
		clientAccount.setRoles(roles);
		
		return clientAccount;
	}

}
