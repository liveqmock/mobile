package com.gsoft.mobile.manager.service;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.mobile.manager.entity.DayTemInf;
import com.gsoft.mobile.manager.entity.QrCodePayInf;

public interface QrCodePayManager extends BaseManager {
	/**
	 * 
	 * 二维码付款
	 */
	public boolean pay(String payCard,String payAmount,String pwd) throws BusException;
	/**
	 *二维码收款 
	 */
	public Message receive(DayTemInf dayTemInf) throws BusException;
	/**
	 * 收款信息查询
	 */
	public Message qryPayDayTemInf(DayTemInf dayTemInf) throws BusException;
	
	/**
	 * 做交易
	 */
	public Message savePayDayTemInf(DayTemInf dayTemInf) throws BusException;
	
  

}
