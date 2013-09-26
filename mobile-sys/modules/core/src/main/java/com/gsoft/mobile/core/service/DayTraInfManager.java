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
import com.gsoft.mobile.core.entity.DayTraInf;

public interface DayTraInfManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<DayTraInf> getDayTraInfs() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<DayTraInf> getDayTraInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public DayTraInf getDayTraInf(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerDayTraInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public DayTraInf saveDayTraInf(DayTraInf o) throws BusException;

    /**
     * 删除对象
     */
    public void removeDayTraInf(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeDayTraInfs(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitDayTraInf(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitDayTraInf(String propertyName,Object value) throws BusException;
	/**
	 * 根据卡号和交易日期查找记录,返回该卡当天已消费金额
	 */
	public double  getDayTraAmountByDate(String receiveCard,String payCard,String tranDate) throws BusException;
	

	/**
     * 查询
     */
	public PagerRecords getPagerTraInfs(String pageIndex,String pageSize,String type,String cardCode,String startDate,String endDate);

	public  boolean checkRegex(String param, String regex);

	
	
}
