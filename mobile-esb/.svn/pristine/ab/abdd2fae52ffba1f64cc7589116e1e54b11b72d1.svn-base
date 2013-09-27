/**
 * 
 */
package com.gsoft.mobile.login.client;

import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.security.LoginAccount;

/**
 * @author Administrator
 *
 */
public class ClientAccount extends LoginAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6488426881457883313L;

	private String username;
	
	public ClientAccount(AccountPrincipal principal, String password) {
		super(principal, password);
		this.username = principal.getLoginName();
	}

	@Override
	public String getUsername() {
		return this.username;
	}

}
