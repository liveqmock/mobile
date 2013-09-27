package com.gsoft.mobile.manager.service;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.mobile.manager.entity.TerInf;

public interface LoginManager extends BaseManager{
	
	/**
	 * 根据银行卡和密码获取登录信息
	 * @return
	 * @throws BusException
	 */
	public Message getLoginInf(String bankcardNum,
			String password,
//			String currPosition,String terminalBrand, 
//			String terminalModel, String terminalState,String terminalNo
			TerInf terInf
			) throws BusException;
	
	/**
	 * 退出登录
	 * @throws BusException
	 */
	public void quit(String bankcardNum,TerInf terInf) throws BusException;
	
	public Object getObjectInfByBankcardNum(String bankcardNum)throws BusException;

}
