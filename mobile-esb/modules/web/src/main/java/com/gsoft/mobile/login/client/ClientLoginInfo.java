package com.gsoft.mobile.login.client;

import java.util.ArrayList;
import java.util.List;

import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.security.PrincipalConfig;

public class ClientLoginInfo implements AccountPrincipal{

	private String userId;//
	
	private String bankcardNum;
	
	@Override
	public String getLoginName() {
		return bankcardNum;
	}

	@Override
	public PrincipalConfig getPrincipalConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> roleIds() {
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_CLIENT");
		return roles;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBankcardNum() {
		return bankcardNum;
	}

	public void setBankcardNum(String bankcardNum) {
		this.bankcardNum = bankcardNum;
	}
	
	public String toString(){
		return bankcardNum;
	}
}
