/**
 * 代码声明
 */
package com.gsoft.mobile.manager.service;

import java.util.Collection;
import java.util.List;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.mobile.manager.entity.BlInf;

public interface BlInfManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<BlInf> getBlInfs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<BlInf> getBlInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public BlInf getBlInf(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerBlInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public BlInf saveBlInf(BlInf o) throws BusException;

    /**
     * 删除对象
     */
    public void removeBlInf(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeBlInfs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitBlInf(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitBlInf(String propertyName,Object value) throws BusException;
	
	/**
	 * 修改账户的黑名单状态
	 */
	public void changeBlackListState(BlInf blInf) throws BusException;
	
	/**
	 * 根据银行卡号获取卡信息
	 * @param bankcardNum
	 * @throws BusException
	 */
	public BlInf getBlInfByBankcardNum(String bankcardNum) throws BusException;
}
