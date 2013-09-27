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
import com.gsoft.mobile.core.entity.SignInf;

public interface SignInfManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<SignInf> getSignInfs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<SignInf> getSignInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public SignInf getSignInf(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerSignInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public Message saveSignInf(SignInf o) throws BusException;

    /**
     * 删除对象
     */
    public void removeSignInf(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeSignInfs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitSignInf(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitSignInf(String propertyName,Object value) throws BusException;
	
	 /**
     * 根据签约类型和卡号查找签约记录
     * 应该只返回一条记录
     */
    public SignInf getSignInfByCardNo(String cardNo,String signBusiness )throws BusException;
}
