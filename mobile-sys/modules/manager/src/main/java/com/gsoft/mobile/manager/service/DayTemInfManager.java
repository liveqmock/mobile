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
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.mobile.manager.entity.DayTemInf;


public interface DayTemInfManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<DayTemInf> getDayTemInfs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<DayTemInf> getDayTemInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     * 
     */
    public DayTemInf getDayTemInf(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerDayTemInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
  

    /**
     * 删除对象
     */
    public void removeDayTemInf(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeDayTemInfs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitDayTemInf(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitDayTemInf(String propertyName,Object value) throws BusException;
	
	 
}
