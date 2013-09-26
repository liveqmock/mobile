/**
 * 代码声明
 */
package com.gsoft.mobile.core.service;

import java.util.List;
import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.core.web.view.Message;

import com.gsoft.mobile.core.entity.MerInf;

public interface MerInfManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<MerInf> getMerInfs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<MerInf> getMerInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public MerInf getMerInf(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerMerInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public MerInf saveMerInf(MerInf o) throws BusException;

    /**
     * 删除对象
     */
    public void removeMerInf(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMerInfs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitMerInf(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitMerInf(String propertyName,Object value) throws BusException;
	/**
	 * 
	 * @param id 
	 * 商户解约操作
	 * @throws BusException
	 */
	public void signoutMer(String id) throws BusException; 
	/**
	 * 切换商户状态
	 * 00正常 01 暂停  
	 */
	public void updateMerInfState( String id) throws BusException;
	/**
	 * 
	 * @param cardNum
	 * @return根据卡号查找用户
	 * @throws BusException
	 */
	public MerInf getMerInfByCardNum(String cardNum) throws BusException;
	/**
	 * 商户签约
	 */
	public Message signMer(MerInf o) throws BusException;
}
