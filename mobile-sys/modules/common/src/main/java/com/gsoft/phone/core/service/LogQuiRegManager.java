/**
 * 代码声明
 */
package com.gsoft.phone.core.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;

import com.gsoft.phone.core.entity.LogQuiReg;

public interface LogQuiRegManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<LogQuiReg> getLogQuiRegs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<LogQuiReg> getLogQuiRegs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public LogQuiReg getLogQuiReg(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerLogQuiRegs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public LogQuiReg saveLogQuiReg(LogQuiReg o) throws BusException;

    /**
     * 删除对象
     */
    public void removeLogQuiReg(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeLogQuiRegs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitLogQuiReg(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitLogQuiReg(String propertyName,Object value) throws BusException;
}
