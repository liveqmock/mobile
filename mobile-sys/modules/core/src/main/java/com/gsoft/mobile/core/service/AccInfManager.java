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
import com.gsoft.mobile.core.entity.AccInf;

public interface AccInfManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<AccInf> getAccInfs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<AccInf> getAccInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public AccInf getAccInf(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerAccInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public AccInf saveAccInf(AccInf o) throws BusException;

    /**
     * 删除对象
     */
    public void removeAccInf(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeAccInfs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitAccInf(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitAccInf(String propertyName,Object value) throws BusException;
	
	/**
	 * 查询密码修改
	 */
	public Message saveAccInfQueryPwd(AccInf accInf) throws BusException ;
	
	/**
	 * 取款密码修改
	 */
	public Message saveAccInfWithdrawPwd(AccInf accInf) throws BusException ;
}
