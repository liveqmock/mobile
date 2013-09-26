package com.gsoft.mobile.core.service;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.mobile.core.entity.QrCodePayInf;

public interface QrCodePayManager {
	/**
	 * 
	 * 二维码付款
	 */
	public boolean pay() throws BusException;
	/**
	 *二维码收款 
	 */
	public boolean receive() throws BusException;
	
	/**
	 * 二维码交易
	 */
	public boolean trade(QrCodePayInf qrCodePayInf) throws BusException;
	

}
