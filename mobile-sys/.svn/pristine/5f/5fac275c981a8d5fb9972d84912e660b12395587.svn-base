/**
 * 代码声明
 */
package com.gsoft.mobile.core.service;

import java.util.Collection;
import java.util.List;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.mobile.core.entity.ClientInf;
import com.gsoft.mobile.core.entity.SignInf;

public interface ClientInfManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<ClientInf> getClientInfs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<ClientInf> getClientInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public ClientInf getClientInf(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerClientInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public ClientInf saveClientInf(ClientInf o) throws BusException;

    /**
     * 删除对象
     */
    public void removeClientInf(String id) throws BusException;
    
    /**
     * 删除对象,修改客户状态
     */
    public ClientInf removeClientInfByClientId(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeClientInfs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitClientInf(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitClientInf(String propertyName,Object value) throws BusException;
	
	/**
	 * 获取客户签约信息
	 * @param clientId
	 * @return
	 * @throws BusException
	 */
	public List<SignInf> getClientSignInfs(String clientId) throws BusException;
	
	/**
	 * 根据银行卡号和密码获取客户信息
	 * @param bankcardNum
	 * @param password
	 * @return
	 * @throws BusException
	 */
//	public ClientInf getLoginClientInf(String bankcardNum,
//			String password,String currPosition,
//			String terminalBrand, String terminalModel, String terminalState)throws BusException;
//	
	
	public ClientInf getLoginClientInf(String bankcardNum,
			String password,String currPosition,
			String terminalBrand, String terminalModel, String terminalState)throws BusException;

	
	public Object getObjectInfByBankcardNum(String bankcardNum) throws BusException;

}
