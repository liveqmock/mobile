/**
 * 代码声明
 */
package com.gsoft.mobile.core.dao;

import java.io.Serializable;
import com.gsoft.framework.core.dao.Dao;


public interface ClientInfDao<T, PK extends Serializable> extends Dao<T, PK>  {
	
	/**
	 * 根据卡号查询客户号
	 * @param bankcardNum
	 * @return
	 */
	public String getClientInfByBankcardNum(final String bankcardNum);
}