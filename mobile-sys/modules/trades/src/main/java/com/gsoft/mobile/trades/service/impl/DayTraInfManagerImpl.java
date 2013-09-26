/**
 * 代码声明
 */
package com.gsoft.mobile.trades.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.gsoft.mobile.trades.dao.DayTraInfDao;
import com.gsoft.mobile.trades.entity.DayTraInf;
import com.gsoft.mobile.trades.service.DayTraInfManager;

@Service("dayTraInfManager")
@Transactional
public class DayTraInfManagerImpl extends BaseManagerImpl implements DayTraInfManager{
	@Autowired
	private DayTraInfDao<DayTraInf,String> dayTraInfDao;
	
    /**
     * 查询列表
     */
    public List<DayTraInf> getDayTraInfs() throws BusException{
    	return dayTraInfDao.getAll();
    }
     /**
     * 条件查询列表
     */
    public List<DayTraInf> getDayTraInfs(Collection<Condition> conditions,Collection<Order> orders) throws BusException{
    	return dayTraInfDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    public DayTraInf getDayTraInf(String id) throws BusException {
    	return dayTraInfDao.get(id);
    }
	
	public PagerRecords getPagerDayTraInfs(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = dayTraInfDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    public DayTraInf saveDayTraInf(DayTraInf o) throws BusException{
//    	String dayTraInfId = o.getDayTraInfId();
//    	boolean isUpdate = StringUtils.isNotEmpty(dayTraInfId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return dayTraInfDao.save(o);
    }

    /**
     * 删除对象
     */
    public void removeDayTraInf(String id) throws BusException{
    	dayTraInfDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeDayTraInfs(String[] ids) throws BusException{
   		for(String id:ids){
    		removeDayTraInf(id);
    	}
    }
    
    public boolean exsitDayTraInf(String id) throws BusException{
		return dayTraInfDao.exists(id);
	}
    
    public boolean exsitDayTraInf(String propertyName,Object value) throws BusException {
		return dayTraInfDao.exists(propertyName,value);
	}

}
